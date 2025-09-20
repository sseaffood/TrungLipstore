/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package sample.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import sample.product.Cart;
import sample.product.Product;
import sample.product.ProductDAO;
import sample.product.OrderDAO;
import sample.user.UserDTO;
        
/**
 *
 * @author 84904
 */
@WebServlet(name="CheckoutController", urlPatterns={"/CheckoutController"})
public class CheckoutController extends HttpServlet {
    private static final String ERROR = "viewCart.jsp";
    private static final String SUCCESS = "viewCart.jsp";
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(CheckoutController.class);
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try{
        //1. Kiem tra session
        HttpSession session = request.getSession();
        if(session == null || session.getAttribute("CART") == null){
            request.setAttribute("MESSAGE", "Phien lam viec da het. Vui long dang nhap lai...");
            logger.warn("Het session viewCart");
            return;
        }
        //2. Kiem tra gio hang con hay ko
        Cart cart = (Cart) session.getAttribute("CART");
        if(cart.getCart() == null){
            request.setAttribute("MESSAGE", "Gio hang rong!");
            return;
        }
        //3. Kiem tra ton kho
        ProductDAO productDAO = new ProductDAO();
        Map<String, Integer> inventoryMap = new java.util.HashMap<>();
        StringBuilder errorMessage = new StringBuilder();
        boolean hasError = false;
        for (Map.Entry<String, Product> entry : cart.getCart().entrySet()) {
            String productID = entry.getKey();
            int quantityInCart = entry.getValue().getQuantity();
            int available = productDAO.getQuantity(productID);
            inventoryMap.put(productID, available);
            if (available < quantityInCart) {
                hasError = true;
                errorMessage.append("Product <strong>")
                            .append(productID)
                            .append("</strong> only have <strong>")
                            .append(available)
                            .append("</strong> in eventory.<br/>");
                logger.warn("So luong trong kho khong du '{}' ", productID);
            }
        }
        if (hasError) {
            request.setAttribute("MESSAGE", errorMessage.toString());
            request.setAttribute("INVENTORY", inventoryMap);
            url = ERROR;
            request.getRequestDispatcher(url).forward(request, response);
            return;
        }
        //checkout
        String orderID = "ORD" + System.currentTimeMillis();
        UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        String userID = (loginUser != null) ? loginUser.getUserID() : "GUEST";

        OrderDAO orderDAO = new OrderDAO();
        boolean checkoutSuccess = orderDAO.checkout(orderID, userID, cart);
        if (checkoutSuccess) {
            session.removeAttribute("CART");
            request.setAttribute("MESSAGE", "Thanh toán thành công");
            logger.info("Da xu ly thanh cong don hang!");
            url = SUCCESS;
        } else {
            request.setAttribute("MESSAGE", "Thanh toán thất bại. Vui lòng thử lại...");
            logger.debug("Loi thanh toan do checkoutController");
        }
        }catch (Exception e) {
            log("Error at CheckoutController: " + e.toString());
            request.setAttribute("MESSAGE", "Lỗi hệ thống khi thanh toán.");
            logger.debug("Loi khong xac dinh");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }   
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CheckoutController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
