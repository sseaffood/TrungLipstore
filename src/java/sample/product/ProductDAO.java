package sample.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.utils.DButils;

public class ProductDAO {
    private static final String SEARCH = "SELECT id, name, price, quantity FROM tblProduct WHERE name LIKE ?";
    private static final String GET_BY_ID = "SELECT id, name, price, quantity FROM tblProduct WHERE id = ?";
    private static final String INSERT = "INSERT INTO tblProduct(id, name, price, quantity) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE tblProduct SET name = ?, price = ?, quantity = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM tblProduct WHERE id = ?";

    public List<Product> getListProduct(String search) throws SQLException {
        List<Product> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DButils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(SEARCH);
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    list.add(new Product(id, name, price, quantity));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }

        return list;
    }

    public Product getProductByID(String productID) throws SQLException {
        Product product = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DButils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(GET_BY_ID);
                ptm.setString(1, productID);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    product = new Product(productID, name, price, quantity);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) rs.close();
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }

        return product;
    }

    public boolean insert(Product product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DButils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(INSERT);
                ptm.setString(1, product.getId());
                ptm.setString(2, product.getName());
                ptm.setDouble(3, product.getPrice());
                ptm.setInt(4, product.getQuantity());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }

        return check;
    }

    public boolean update(Product product) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DButils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(UPDATE);
                ptm.setString(1, product.getName());
                ptm.setDouble(2, product.getPrice());
                ptm.setInt(3, product.getQuantity());
                ptm.setString(4, product.getId());
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }

        return check;
    }

    public boolean delete(String productID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;

        try {
            conn = DButils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DELETE);
                ptm.setString(1, productID);
                check = ptm.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) ptm.close();
            if (conn != null) conn.close();
        }

        return check;
    }
    public int getQuantity(String productID) throws SQLException, ClassNotFoundException {
        String sql = "SELECT quantity FROM tblProduct WHERE id = ?";
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = DButils.getConnection();
            ptm = conn.prepareStatement(sql);
            ptm.setString(1, productID);
            ResultSet rs = ptm.executeQuery();
            if (rs.next()) {
                return rs.getInt("quantity");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn!=null) conn.close();
            if(ptm != null) ptm.close();
        }
        return 0; 
    }

    public boolean decreaseQuantity(String productID, int amount) throws SQLException, ClassNotFoundException {
    String sql = "UPDATE tblProduct SET quantity = quantity - ? WHERE id = ? AND quantity >= ?";
    Connection conn = null;
    PreparedStatement ptm = null;
    boolean check = false;

    try {
        conn = DButils.getConnection();
        ptm = conn.prepareStatement(sql);
        ptm.setInt(1, amount);
        ptm.setString(2, productID);
        ptm.setInt(3, amount);
        check = ptm.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (ptm != null) ptm.close();
        if (conn != null) conn.close();
    }

    return check;
    }
   
    public boolean decreaseQuantity(String productID, int amount, Connection conn) throws SQLException {
    String sql = "UPDATE tblProduct SET quantity = quantity - ? WHERE id = ? AND quantity >= ?";
    try (PreparedStatement ptm = conn.prepareStatement(sql)) {
        ptm.setInt(1, amount);
        ptm.setString(2, productID);
        ptm.setInt(3, amount);
        return ptm.executeUpdate() > 0;
    } catch (Exception e) {
        e.printStackTrace();
        return false; // ← BỔ SUNG return nếu xảy ra lỗi
    }
}
}

