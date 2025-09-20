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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author 84904
 */
@WebServlet(name = "CaptchaVerifyController", urlPatterns = {"/CaptchaVerifyController"})
public class CaptchaVerifyController extends HttpServlet {

    private static final String SECRET_KEY = "6LdByH8rAAAAAD9YKDyDMhbhChBjTbjdDYfvCDHy";
    private static final String SUCCESS = "MainController?action=Welcome";
    private static final String ERROR = "captcha.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
        try {
            if (gRecaptchaResponse == null || !verifyCaptcha(gRecaptchaResponse)) {
                request.setAttribute("error", "Xác minh CAPTCHA thất bại. Vui lòng thử lại.");
                request.getRequestDispatcher(ERROR).forward(request, response);
                return;
            }
            HttpSession session = request.getSession();
            session.setAttribute("PASSED_CAPTCHA", true); 
            response.sendRedirect(SUCCESS);

        } catch (Exception e) {
            log("Error at CaptchaVerifyController: " + e.toString());
            request.setAttribute("error", "Lỗi hệ thống.");
            request.getRequestDispatcher(ERROR).forward(request, response);
        }
    }
    private boolean verifyCaptcha(String gRecaptchaResponse) throws Exception {
        String url = "https://www.google.com/recaptcha/api/siteverify";
        String postParams = "secret=" + URLEncoder.encode(SECRET_KEY, "UTF-8") +
                            "&response=" + URLEncoder.encode(gRecaptchaResponse, "UTF-8");
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(postParams.getBytes());
        os.flush();
        os.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString().contains("\"success\": true");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
