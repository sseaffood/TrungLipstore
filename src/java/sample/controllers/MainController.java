/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sample.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sample.product.Cart;
import sample.product.Product;
import sample.product.ProductDAO;

/**
 *
 * @author 84904
 */
public class MainController extends HttpServlet {

    private static final String WELCOME = "welcome.jsp";
    private static final String LOGIN = "Login";
    private static final String LOGOUT = "Logout";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String SEARCH = "Search";
    private static final String SEARCH_CONTROLLER = "SearchController";
    private static final String UPDATE = "Update";
    private static final String UPDATE_CONTROLLER = "UpdateController";
    private static final String DELETE = "Delete";
    private static final String DELETE_CONTROLLER = "DeleteController";
    private static final String CREATE_USER="Create User";
    private static final String CREATE_USER_VIEW="createUser.jsp";
    private static final String CREATE="Create";
    private static final String CREATE_CONTROLLER="CreateController";
    private static final String SHOPPING_PAGE="Shopping Page";
    private static final String SHOPPING_PAGE_VIEW="shopping.jsp";
    private static final String ADD="Add";
    private static final String ADD_CONTROLLER="AddController";
    private static final String VIEW="View";
    private static final String VIEW_CART="viewCart.jsp";
    private static final String EDIT="Edit";
    private static final String EDIT_CONTROLLER="EditController";
    private static final String REMOVE="Remove";
    private static final String REMOVE_CONTROLLER="RemoveController";
    private static final String CHECKOUT="Checkout";
    private static final String CHECKOUT_CONTROLLER="CheckoutController";
    private static final String FORUM = "Forum";
    private static final String FORUM_CONTROLLER = "ForumController";
    private static final String ADD_PRODUCT = "Add Product";
    private static final String ADD_PRODUCT_CONTROLLER = "AddProductController";
    private static final String ADD_PRODUCT_PAGE = "addProduct.jsp";
    private static final String ADD_NEW_PRODUCT = "AddNewProduct";
    private static final String CHECK = "Check";
    private static final String CHECK_CONTROLLER = "CheckController";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
        String url = WELCOME;
        boolean redirected = false;
        try {
            HttpSession session = request.getSession(false);
            boolean passedCaptcha = (session != null && session.getAttribute("PASSED_CAPTCHA") != null);
            String action = request.getParameter("action");

            if (!passedCaptcha && (action == null || !action.equals("Captcha"))) {
                response.sendRedirect("captcha.jsp");
                redirected = true;
                return;
            }
            ProductDAO dao = new ProductDAO();
            List<Product> list = dao.getListProduct("");
            request.setAttribute("PRODUCT_LIST", list);
            if (action == null) {
                url = WELCOME;
            } else if (LOGIN.equals(action)) {
                url = LOGIN_CONTROLLER;
            } else if (SEARCH.equals(action)) {
                url = SEARCH_CONTROLLER;
            } else if (UPDATE.equals(action)) {
                url = UPDATE_CONTROLLER;
            } else if (DELETE.equals(action)) {
                url = DELETE_CONTROLLER;
            } else if (CREATE_USER.equals(action)) {
                url = CREATE_USER_VIEW;
            } else if (CREATE.equals(action)) {
                url = CREATE_CONTROLLER;
            } else if (SHOPPING_PAGE.equals(action)) {
                url = SHOPPING_PAGE_VIEW;
            } else if (ADD.equals(action)) {
                url = ADD_CONTROLLER;
            } else if (VIEW.equals(action)) {
                if (session != null) {
                    Cart cart = (Cart) session.getAttribute("CART");
                    if (cart != null) {
                        Map<String, Integer> inventoryMap = new HashMap<>();
                        for (String productID : cart.getCart().keySet()) {
                            int available = dao.getQuantity(productID);
                            inventoryMap.put(productID, available);
                        }
                        request.setAttribute("INVENTORY", inventoryMap);
                    }
                }
                url = VIEW_CART;
            } else if (EDIT.equals(action)) {
                url = EDIT_CONTROLLER;
            } else if (REMOVE.equals(action)) {
                url = REMOVE_CONTROLLER;
            } else if (CHECKOUT.equals(action)) {
                url = CHECKOUT_CONTROLLER;
            } else if (LOGOUT.equals(action)) {
                if (session != null) {
                    session.invalidate();
                }
                url = WELCOME;
            } else if (FORUM.equals(action)) {
                url = FORUM_CONTROLLER;
            }else if (ADD_PRODUCT.equals(action)) {
                url = ADD_PRODUCT_PAGE;
            }else if (ADD_NEW_PRODUCT.equals(action)) {
                url = ADD_PRODUCT_CONTROLLER;
            }else if (CHECK.equals(action)) {
                url = CHECK_CONTROLLER;
            }
        } catch (IOException | ClassNotFoundException | SQLException e) {
            log("Error at MainController: " + e.toString());
        } finally {
            if (!redirected) {
                request.getRequestDispatcher(url).forward(request, response);
            }
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
