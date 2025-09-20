<%-- 
    Document   : welcome.jsp
    Created on : Jun 27, 2025, 8:56:05 PM
    Author     : 84904
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>LIP PAGE</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" href="css/style.css"> <!-- CSS-->
</head>

<body>
    <jsp:include page="welcomeHeader.jsp" />
    
    <!-- Carousel anh-->
    <div class="d-flex justify-content-center my-4">
        <div id="carousel" class="carousel slide w-75" data-bs-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="welcomeImages/carousel1.jpg" class="d-block w-100" alt="banner1">
                </div>
                <div class="carousel-item">
                    <img src="welcomeImages/carousel2.jpg" class="d-block w-100" alt="banner2">
                </div>
                <div class="carousel-item">
                  <img src="welcomeImages/carousel3.jpg" class="d-block w-100" alt="banner3">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carousel" data-bs-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carousel" data-bs-slide="next">
                <span class="carousel-control-next-icon"></span>
            </button>
        </div>
    </div>  
    <!-- Home -->
    <section id="home" class="py-5 text-center bg-light">
        <h2>Chào mừng đến với Trung LIP Store</h2>
        <p>Chuyên các dòng son hot nhất, đẹp nhất, chất lượng nhất.</p>
    </section>
    <!-- sonMoi -->
    <section id="son" class="py-5 container">
        <h3>Sản phẩm son nổi bật</h3>
        <div class="text-left mb-3">
            <a href="MainController?action=Shopping Page" class="btn btn-danger">Mua Ngay</a>
        </div>
        <div class="row">
        <c:forEach var="product" items="${PRODUCT_LIST}">
            <div class="col-md-3 product-card text-center">
                <img src="welcomeImages/${product.id}.png" class="img-fluid mb-2" style="max-height: 200px;" alt="${product.name}">
                <h5>${product.id} - ${product.name}</h5>
                <p class="price">${product.price}$</p>
            </div>
        </c:forEach>
    </div>
    </section>
    <jsp:include page="footer.jsp" />
</body>
</html>
