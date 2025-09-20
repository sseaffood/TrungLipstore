<%-- 
    Document   : viewCart.jsp
    Created on : Jun 27, 2025, 8:56:05 PM
    Author     : 84904
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng của bạn</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" href="css/style.css"> 
    <link rel="stylesheet" href="css/viewCart.css"> 
</head>
<body>
    <jsp:include page="welcomeHeader.jsp" />
    
    <div class="container">
        <h1>Your shopping cart</h1>
        <c:if test="${not empty requestScope.MESSAGE}">
            <div class="message">${requestScope.MESSAGE}</div>
        </c:if>
        <c:choose>
            <c:when test="${not empty sessionScope.CART.cart}">
                <table class="cart-table">
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Image</th>
                            <th>Code</th>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Quantity</th>
                            <th>Cost</th>
                            <th>Edit</th>
                            <th>Remove</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set var="grandTotal" value="0" />
                        <c:forEach var="item" items="${sessionScope.CART.cart}" varStatus="loop">
                            <c:set var="product" value="${item.value}" />
                            <c:set var="subtotal" value="${product.price * product.quantity}" />
                            <c:set var="grandTotal" value="${grandTotal + subtotal}" />
                            <tr>
                                <form action="MainController" method="post">
                                    <td>${loop.count}</td>
                                    <td>
                                        <img src="welcomeImages/${product.id}.png" width="80" alt="${product.name}">
                                    </td>
                                    <td><input type="text" name="id" value="${product.id}" readonly /></td>
                                    <td>${product.name}</td>
                                    <td>${product.price}</td>
                                    <td>
                                        <input type="number" name="quantity" value="${product.quantity}" min="1" />
                                        <div class="text-muted small">
                                            Inventory:
                                            <c:choose>
                                                <c:when test="${not empty INVENTORY[product.id]}">
                                                    ${INVENTORY[product.id]}
                                                </c:when>
                                                <c:otherwise>?</c:otherwise>
                                            </c:choose>
                                        </div>
                                    </td>
                                    <td>${subtotal}</td>
                                    <td><input type="submit" name="action" value="Edit" /></td>
                                    <td><input type="submit" name="action" value="Remove" /></td>
                                </form>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="total-section">
                    Total: <span style="color: red;">${grandTotal} $</span>
                </div>
                <div class="actions">
                    <form action="MainController" method="post">
                        <input type="submit" name="action" value="Checkout" class="btn btn-success">
                    </form>
                    <a href="MainController?action=Shopping Page" class="btn btn-secondary">Tiếp tục mua sắm</a>
                </div>
            </c:when>
            <c:otherwise>
                <p class="message">Your cart is empty.</p>
                <div style="text-align: center;">
                    <a href="MainController?action=Shopping Page" class="btn btn-primary">Mua sắm ngay</a>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</body>
</html>
