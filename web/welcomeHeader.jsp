<%-- 
    Document   : welcomeHeader
    Created on : Jul 11, 2025, 10:17:04 PM
    Author     : 84904
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Top Bar -->
<div class="top-contact d-flex justify-content-between align-items-center px-4 py-2 bg-dark text-white small">
    <div class="d-flex align-items-center">
        Thế giới mỹ phẩm
    </div>
    <div class="d-flex align-items-center">
        <div class="me-5">
            ☎ 0904520999
            <a href="#" class="text-white ms-2"><i class="fab fa-facebook-f"></i></a>
            <a href="#" class="text-white ms-2"><i class="fab fa-instagram"></i></a>
        </div>

        <div class="dropdown">
            <a href="#" class="text-white dropdown-toggle" data-bs-toggle="dropdown">
                <i class="fas fa-user"></i> Login
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
                <c:if test="${not empty sessionScope.LOGIN_USER}">
                    <c:choose>
                        <c:when test="${sessionScope.LOGIN_USER.roleID == 'AD'}">
                            <li><a class="dropdown-item" href="admin.jsp">Greetings, ${sessionScope.LOGIN_USER.fullName}</a></li>
                            </c:when>
                            <c:otherwise>
                            <li><a class="dropdown-item" href="user.jsp">Greetings, ${sessionScope.LOGIN_USER.fullName}</a></li>
                            </c:otherwise>
                        </c:choose>
                    <li><a class="dropdown-item" href="MainController?action=Logout">Đăng xuất</a></li>
                    </c:if>
                    <c:if test="${empty sessionScope.LOGIN_USER}">
                    <li><a class="dropdown-item" href="login.jsp">Đăng nhập</a></li>
                    <li><a class="dropdown-item" href="createUser.jsp">Đăng ký</a></li>
                    </c:if>
            </ul>
        </div>
    </div>
</div>
<!-- Logo + Search + Cart -->
<div class="d-flex align-items-center justify-content-between px-4 py-3 bg-white shadow-sm">
    <a href="MainController?action=WELCOME" class="text-decoration-none fs-4 text-danger d-flex align-items-center">
        <img src="welcomeImages/logo.jpg" style="width: 70px; display: inline-block; margin-left: 2.5cm;" alt="logo">
    </a>
    <form class="d-flex flex-grow-1 mx-4" role="search" style="max-width: 710px;">
        <input class="form-control form-control-sm nav-search" type="search" placeholder="I'm shopping for ..." aria-label="Search">
    </form>
    <a href="MainController?action=View" class="btn btn-outline-success fw-bold px-4 py-2">
        🛒 Cart
    </a>
</div>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm">
    <div class="container justify-content-center">
        <ul class="navbar-nav">
            <li class="nav-item px-2"><a class="nav-link" href="MainController?action=WELCOME">Trang chủ</a></li>
            <li class="nav-item px-2"><a class="nav-link" href="MainController?action=Shopping Page">Son môi</a></li>
            <li class="nav-item px-2"><a class="nav-link" href="MainController?action=Forum">Diễn đàn</a></li>
            <li class="nav-item px-2"><a class="nav-link" href="contact.jsp">Liên hệ</a></li>
        </ul>
    </div>
</nav>
