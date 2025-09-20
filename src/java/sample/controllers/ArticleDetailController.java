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
import sample.article.ArticleDAO;
import sample.article.ArticleDTO;

/**
 *
 * @author 84904
 */
@WebServlet(name = "ArticleDetailController", urlPatterns = {"/ArticleDetailController"})
public class ArticleDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String id = request.getParameter("id");
        ArticleDAO dao = new ArticleDAO();
        ArticleDTO article = dao.getArticleById(id);
        if (article != null) {
            request.setAttribute("article", article);
            request.getRequestDispatcher("articleDetail.jsp").forward(request, response);
        } else {
            response.sendRedirect("MainController?action=Forum"); 
        }
    }
}