<%-- 
    Document   : user.jsp
    Created on : Jun 27, 2025, 8:56:05 PM
    Author     : 84904
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="sample.user.UserDTO" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>User Infomation</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="css/user.css">
    </head>
    <body>
        <jsp:include page= "welcomeHeader.jsp"/>
        <!-- Kiểm tra quyền truy cập -->
        <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}">
            <c:redirect url="login.jsp"/>
        </c:if>
        <div class="user-info-box">
            <h3>Thông tin tài khoản</h3>
            <div class="info-item">
                <label>User ID:</label>
                <span>${sessionScope.LOGIN_USER.userID}</span>
            </div>
            <div class="info-item">
                <label>Full Name:</label>
                <span>${sessionScope.LOGIN_USER.fullName}</span>
            </div>
            <div class="info-item">
                <label>Role ID:</label>
                <span>${sessionScope.LOGIN_USER.roleID}</span>
            </div>
            <div class="info-item">
                <label>Password:</label>
                <span>***</span>
            </div>
            <div class="info-item">
                <label>Phone:</label>
                <span>${sessionScope.LOGIN_USER.phone}</span>
            </div>
            <div class="info-item">
                <label>Address:</label>
                <span>${sessionScope.LOGIN_USER.address}</span>
            </div>
            <form action="MainController" method="post" class="mt-3 d-flex gap-2">
                <button type="submit" name="action" value="Logout" class="btn btn-danger">Logout</button>
            </form>
        </div>
        <jsp:include page="footer.jsp" />
    </body>
</html>

