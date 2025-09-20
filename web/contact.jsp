<%-- 
    Document   : contact
    Created on : Jul 7, 2025, 11:42:47 PM
    Author     : 84904
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liên hệ</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <link rel="stylesheet" href="css/style.css"> <!-- CSS-->
    <link rel="stylesheet" href="css/contact.css">
</head>
<body>
    <jsp:include page="welcomeHeader.jsp" />
    <div class="container py-5">
        ,<!-- thong tin -->
        <div class="row">
            <!-- Liên hệ -->
            <div class="col-md-6 mb-4">
                <h4>Liên Hệ</h4>
                <p><i class="bi bi-geo-alt-fill"></i> Số nhà 36 Khu trại mới, Quận 9, HCM</p>
                <p><i class="bi bi-envelope-fill"></i> <a href="mailto:trungdinh.dev@gmail.com">trungdinh.dev@gmail.com</a></p>
                <p><i class="bi bi-phone-fill"></i> (+84) 904520999</p>
            </div>
            <!-- phan feedback -->
            <div class="col-md-6 mb-4">
                <h4>Send feedback</h4>
                <form>
                    <div class="mb-3">
                        <input type="email" class="form-control" placeholder="Email *" required>
                    </div>
                    <div class="mb-3">
                        <input type="text" class="form-control" placeholder="Tiêu đề *" required>
                    </div>
                    <div class="mb-3">
                        <textarea class="form-control" placeholder="Nội dung *" rows="4" required></textarea>
                    </div>
                    <button type="submit" class="btn custom-send">SEND</button>
                </form>
            </div>
        </div>
        ,<!-- phan gui mail -->
        <div class="row mt-5">
            <div class="col-md-12 text-center bg-light p-4 rounded">
                <h5>Nhập email đăng ký ngay để nhận ưu đãi sớm nhất</h5>
                <form action="SendEmail" method="post" class="d-flex justify-content-center mt-3">
                    <input type="email" name="email" class="form-control w-50 me-2" placeholder="Nhập email của bạn" required>
                    <button type="submit" class="btn btn-success">Đăng ký ngay</button>
                </form>
            </div>
        </div>
    </div>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
    <jsp:include page="footer.jsp" />
</body>
</html>
