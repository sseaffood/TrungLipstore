<%-- 
    Document   : articleDetail
    Created on : Jul 12, 2025, 1:29:02 AM
    Author     : 84904
--%>

<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link rel="stylesheet" href="css/style.css"> <!-- CSS-->

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${article.title}</title>
        <link rel="stylesheet" href="css/forum.css">
    </head>
    <body>
        <jsp:include page="welcomeHeader.jsp" />
        <div class="article-list">
            <h3>${article.title}</h3>
            <p>${article.content}</p>
            <a href="MainController?action=Forum">← Back to list</a>
        </div>
    </body>
</html>

