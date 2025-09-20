/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import sample.utils.DButils;

/**
 *
 * @author 84904
 */
public class OrderDAO {
    public boolean createOrder(String orderID, String userID, BigDecimal total, Connection conn) throws SQLException {
        String sql = "INSERT INTO tblOrder(orderID, userID, date, total) VALUES (?, ?, GETDATE(), ?)";
        try (PreparedStatement ptm = conn.prepareStatement(sql)) {
            ptm.setString(1, orderID);
            ptm.setString(2, userID);
            ptm.setBigDecimal(3, total);
            return ptm.executeUpdate() > 0;
        }
    }
    public boolean addOrderDetail(String orderID, String productID, BigDecimal price, int quantity, Connection conn) throws SQLException {
        String sql = "INSERT INTO tblOrderDetail(orderID, productID, price, quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ptm = conn.prepareStatement(sql)) {
            ptm.setString(1, orderID);
            ptm.setString(2, productID);
            ptm.setBigDecimal(3, price);
            ptm.setInt(4, quantity);
            return ptm.executeUpdate() > 0;
        }
    }
    
    public boolean checkout(String orderID, String userID, Cart cart) {
    try (Connection conn = DButils.getConnection();
         PreparedStatement orderStmt = conn.prepareStatement(
             "INSERT INTO tblOrder(orderID, userID, date, total) VALUES (?, ?, GETDATE(), ?)")) {

        conn.setAutoCommit(false);

        // Tính tổng tiền
        BigDecimal total = BigDecimal.ZERO;
        for (Product p : cart.getCart().values()) {
            BigDecimal price = BigDecimal.valueOf(p.getPrice()).setScale(2, java.math.RoundingMode.HALF_UP);
            total = total.add(price.multiply(BigDecimal.valueOf(p.getQuantity())));
        }

        // Thêm vào tblOrder
        orderStmt.setString(1, orderID);
        orderStmt.setString(2, userID);
        orderStmt.setBigDecimal(3, total);
        if (orderStmt.executeUpdate() <= 0) {
            conn.rollback();
            return false;
        }

        // Thêm chi tiết và giảm tồn kho
        ProductDAO productDAO = new ProductDAO();
        for (Product p : cart.getCart().values()) {
            BigDecimal price = BigDecimal.valueOf(p.getPrice()).setScale(2, java.math.RoundingMode.HALF_UP);
            if (!addOrderDetail(orderID, p.getId(), price, p.getQuantity(), conn)
                || !productDAO.decreaseQuantity(p.getId(), p.getQuantity(), conn)) {
                conn.rollback();
                return false;
            }
        }

        conn.commit();
        return true;

    } catch (Exception e) {
        return false;
    }
}

}
