<%-- 
    Document   : login.jsp
    Created on : Jun 3, 2025, 12:34:36 AM
    Author     : 84904
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body>
    <div class="d-flex align-items-center" style="margin-left: 7cm;">
        <a href="MainController?action=WELCOME" style="display: inline-block;">
            <img src="welcomeImages/logo.jpg" style="width: 70px;" alt="logo">
        </a>
        <h2 class="ms-3 mb-0">Đăng nhập</h2>
    </div>
    <div class="login-wrapper">
        <div class="banner">
            <img src="loginImages/banner1.jpg" alt="banner">
        </div>
        <div class="login-container">
            <div class="login-title text-center">Đăng nhập</div>
            <form action="MainController" method="POST">
                <div class="mb-3">
                    <input type="text" class="form-control" name="userID" placeholder="Tên đăng nhập" required>
                </div>
                <div class="mb-3">
                    <input type="password" class="form-control" name="password" placeholder="Mật khẩu" required>
                </div>
                <div class="d-grid mb-2">
                    <button type="submit" name="action" value="Login" class="btn btn-login">Đăng nhập</button>
                </div> 
            </form>
            ${requestScope.ERROR}
            <div class="register-prompt text-center mt-3">
                <span>Bạn mới biết đến Trung Lip Store? </span>
                <a href="createUser.jsp" class="register-link">Đăng ký</a>
            </div>
        </div>
            <form action="MainController" method="post">
                <input type="submit" name="action" value="Check">
            </form>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <jsp:include page="footer.jsp" />
</body>
</html>