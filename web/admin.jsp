<%-- 
    Document   : admin.jsp
    Created on : Jun 3, 2025, 12:34:36 AM
    Author     : 84904
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/admin.css">
</head>
<body class="bg-light">
    <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'AD'}">
        <c:redirect url="login.jsp" />
    </c:if>
    <div class="container py-4">
        <h2 class="text-center text-primary mb-4">Greetings: ${sessionScope.LOGIN_USER.fullName}</h2>
        <!-- Phan action -->
        <div class="d-flex justify-content-between mb-4">
            <form action="MainController" method="post" class="d-inline">
                <button type="submit" name="action" value="Create User" class="btn btn-success">➕ Add user</button>
            </form>

            <form action="MainController" method="get" class="d-flex">
                <input type="text" name="search" value="${param.search}" class="form-control me-2" placeholder="I'm looking for user...">
                <button type="submit" name="action" value="Search" class="btn btn-outline-primary">🔍 Search</button>
            </form>

            <form action="MainController" method="post">
                <input type="submit" name="action" value="Add Product" class="btn btn-primary"/>
            </form>

            <form action="MainController" method="post" class="d-inline">
                <button type="submit" name="action" value="Logout" class="btn btn-danger">Logout</button>
            </form>
        </div>
        <c:if test="${requestScope.LIST_USER != null}">
            <div class="table-responsive">
                <table class="table table-bordered table-hover bg-white shadow-sm">
                    <thead class="table-dark">
                        <tr>
                            <th>#</th>
                            <th>User ID</th>
                            <th>Full Name</th>
                            <th>Role ID</th>
                            <th>Password</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" varStatus="counter" items="${requestScope.LIST_USER}">
                            <form action="MainController" method="post">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td><input type="text" name="userID" class="form-control-plaintext" readonly value="${user.userID}" /></td>
                                    <td><input type="text" name="fullName" class="form-control" value="${user.fullName}" required /></td>
                                    <td><input type="text" name="roleID" class="form-control" value="${user.roleID}" required /></td>
                                    <td><input type="password" class="form-control" value="${user.password}" readonly /></td>
                                    <td>
                                        <input type="hidden" name="search" value="${param.search}" />
                                        <button type="submit" name="action" value="Update" class="btn btn-sm btn-primary">Save</button>
                                    </td>
                                    <td>
                                        <c:url var="deleteLink" value="MainController">
                                            <c:param name="action" value="Delete" />
                                            <c:param name="userID" value="${user.userID}" />
                                            <c:param name="search" value="${param.search}" />
                                        </c:url>
                                        <a href="${deleteLink}" class="btn btn-sm btn-danger">Delete</a>
                                    </td>
                                </tr>
                            </form>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </c:if>
        <c:if test="${not empty requestScope.ERROR_MESSAGE}">
            <div class="alert alert-danger mt-3 text-center">
                ${requestScope.ERROR_MESSAGE}
            </div>
        </c:if>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>