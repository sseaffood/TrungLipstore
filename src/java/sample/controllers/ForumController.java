/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package sample.controllers;

import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ForumController", urlPatterns = {"/ForumController"})
public class ForumController extends HttpServlet {
    private static final int ARTICLES_PER_PAGE = 4;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pageStr = request.getParameter("page");
        int page = (pageStr != null) ? Integer.parseInt(pageStr) : 1;

        ArticleDAO dao = new ArticleDAO();
        List<ArticleDTO> allArticles = dao.getAllArticle();

        int totalArticles = allArticles.size();
        int totalPages = (int) Math.ceil((double) totalArticles / ARTICLES_PER_PAGE);
        int start = (page - 1) * ARTICLES_PER_PAGE;
        int end = Math.min(start + ARTICLES_PER_PAGE, totalArticles);

        List<ArticleDTO> articlesToShow = allArticles.subList(start, end);

        request.setAttribute("articles", articlesToShow);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);

        request.getRequestDispatcher("forum.jsp").forward(request, response);
    }
}
