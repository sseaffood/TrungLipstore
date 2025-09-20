<%-- 
    Document   : createUser.jsp
    Created on : Jun 3, 2025, 12:34:36 AM
    Author     : 84904
--%>

<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <!-- CSS riêng -->
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body>
    <div class="d-flex align-items-center" style="margin-left: 7cm;">
        <a href="MainController?action=WELCOME" style="display: inline-block;">
            <img src="welcomeImages/logo.jpg" style="width: 70px;" alt="logo">
        </a>
        <h2 class="ms-3 mb-0">Đăng ký</h2>
    </div>
    <div class="login-wrapper">
        <div class="banner">
            <img src="loginImages/banner1.jpg" alt="banner">
        </div>
        <div class="logout-container">
            <div class="login-title text-center">Đăng ký tài khoản</div>
            <form action="MainController" method="POST">
                <div class="mb-3">
                    <input type="text" class="form-control" name="userID" placeholder="Tên đăng nhập" required>
                    ${requestScope.USER_ERROR.userIDError}
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="fullName" placeholder="Họ và tên" required>
                    ${requestScope.USER_ERROR.fullNameError}
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="confirm" placeholder="Nhập lại mật khẩu" required>
                    ${requestScope.USER_ERROR.confirmError}
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="phone" placeholder="Số điện thoại">
                </div>
                <div class="mb-3">
                    <input type="text" class="form-control" name="address" placeholder="Địa chỉ">
                </div>
                <div class="d-grid mb-2">
                    <button type="submit" name="action" value="Create" class="btn btn-login">Đăng ký</button>
                </div>
                <div class="d-grid mb-2">
                    <button type="reset" class="btn btn-outline-secondary">Reset</button>
                </div>
            </form>
            <div class="register-prompt text-center mt-3">
                <span>Đã có tài khoản? </span>
                <a href="login.jsp" class="register-link">Đăng nhập</a>
            </div>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
