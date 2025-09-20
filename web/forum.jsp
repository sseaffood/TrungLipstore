<%-- 
    Document   : forum
    Created on : Jul 7, 2025, 11:45:08 PM
    Author     : 84904
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
<link rel="stylesheet" href="css/style.css"> <!-- CSS-->

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Điệu với son</title>
    <link rel="stylesheet" href="css/forum.css">
</head>
<body>
<jsp:include page="welcomeHeader.jsp" />
    <div class="article-list">
        <h3>Những bài viết của tuần</h3>
        <ul>
            <c:forEach var="a" items="${articles}">
                <li><a href="ArticleDetailController?id=${a.id}">${a.title}</a></li>
            </c:forEach>
        </ul>
        <div class="pagination">
            <c:forEach var="i" begin="1" end="${totalPages}">
                <c:choose>
                    <c:when test="${i == currentPage}">
                        <strong>${i}</strong>
                    </c:when>
                    <c:otherwise>
                        <a href="MainController?action=Forum&page=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
    </div>
</body>
</html>
