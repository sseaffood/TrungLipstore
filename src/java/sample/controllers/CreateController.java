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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "createUser.jsp";
    private static final String SUCCESS = "SearchController";
    private static final Logger logger = LogManager.getLogger(CreateController.class);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        boolean checkValidation = true;
        UserError userError = new UserError();
        UserDAO dao = new UserDAO();
        String url = ERROR;
        try {
            String userID = request.getParameter("userID");
            String fullName = request.getParameter("fullName");
            String roleID = "US";
            String password = request.getParameter("password");
            String confirm = request.getParameter("confirm");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");

            if (userID.length() < 2 || userID.length() > 10) {
                checkValidation = false;
                userError.setUserIDError("User ID must in [2,10]");
                logger.warn("Validation failed: userID '{}' length out of range", userID);
            }
            boolean checkDuplicate = dao.checkDuplicate(userID);
            if (checkDuplicate) {
                checkValidation = false;
                userError.setUserIDError("Duplicate userID");
                logger.warn("Validation failed: Duplicate userID '{}'", userID);
            }
            if (fullName.length() < 5 || fullName.length() > 20) {
                checkValidation = false;
                userError.setFullNameError("Full Name must in [5,20]");
                logger.warn("Validation failed: fullName '{}' length out of range", fullName);
            }
            if (!password.equals(confirm)) {
                checkValidation = false;
                userError.setConfirmError("Hai Password không giống nhau !");
                logger.warn("Validation failed: Password and confirm do not match");
            }
            if (checkValidation) {
                UserDTO user = new UserDTO(userID, fullName, roleID, password, phone, address);
                boolean checkInsert = dao.insert(user);
                if (checkInsert) {
                    url = SUCCESS;
                    logger.info("Create user successfull {}", userID);
                } else {
                    userError.setError("Unknown error !!!");
                    request.setAttribute("USER_ERROR", userError);
                    logger.error("Unknown error at creatController '{}'", userID);
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
        } catch (Exception e) {
            logger.error("Exception tại CreateController: ", e);
            log("error at CreateController: " + e.toString()); 
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
