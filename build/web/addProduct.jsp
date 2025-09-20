<%-- 
    Document   : addProduct
    Created on : Jul 12, 2025, 3:21:52 PM
    Author     : 84904
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm sản phẩm</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2 class="mb-4 text-center text-success">➕ Add new product</h2>
        <form action="MainController" method="post">
            <div class="mb-3">
                <label class="form-label">ID</label>
                <input type="text" name="productID" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Name</label>
                <input type="text" name="name" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Price</label>
                <input type="number" name="price" step="0.01" class="form-control" required>
            </div>
            <div class="mb-3">
                <label class="form-label">Quantity</label>
                <input type="number" name="quantity" class="form-control" required>
            </div>
            <div class="d-flex justify-content-between">
                <button type="submit" name="action" value="AddNewProduct" class="btn btn-success">Add</button>
                <a href="admin.jsp" class="btn btn-secondary">Back</a>
            </div>
        </form>
        <c:if test="${not empty requestScope.MESSAGE}">
            <div class="alert alert-info mt-3">${requestScope.MESSAGE}</div>
        </c:if>
    </div>
</body>
</html>