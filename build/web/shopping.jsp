<%-- 
    Document   : shopping.jsp
    Created on : Jun 27, 2025, 8:56:05 PM
    Author     : 84904
--%>


<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
</head>
<body class="bg-light">
    <jsp:include page="welcomeHeader.jsp" />

    <div class="container mt-3">
        <c:if test="${not empty MESSAGE}">
            <div class="alert alert-success text-center" role="alert">
                ${MESSAGE}
            </div>
        </c:if>
    </div>
    <div class="container py-4">
        <h2 class="text-center mb-4">Choose your favourite</h2>
        <div class="row">
            <c:forEach var="product" items="${PRODUCT_LIST}">
                <div class="col-md-3 mb-4">
                    <div class="card h-100 text-center shadow-sm">
                        <img src="welcomeImages/${product.id}.png" class="card-img-top" style="height: 200px; object-fit: contain;" alt="${product.name}">
                        <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text text-danger fw-bold">${product.price}$</p>
                            <form action="MainController" method="post">
                                <input type="hidden" name="action" value="Add" />
                                <input type="hidden" name="product" value="${product.id}-${product.name}-${product.price}" />
                                <div class="mb-2">
                                    <label for="quantity_${product.id}" class="form-label">Số lượng:</label>
                                    <input type="number" id="quantity_${product.id}" name="quantity" value="1" min="1" class="form-control form-control-sm">
                                </div>
                                <div class="d-grid gap-2">
                                    <button type="submit" class="btn btn-outline-success btn-sm">Thêm vào giỏ</button>
                                    <button type="submit" name="action" value="Checkout" class="btn btn-danger btn-sm">Mua ngay</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <jsp:include page="footer.jsp" />
</body>
</html>
