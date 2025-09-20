<%-- 
    Document   : captcha
    Created on : Jul 12, 2025, 2:08:53 AM
    Author     : 84904
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.*, jakarta.servlet.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Xác minh CAPTCHA</title>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <style>
            body {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
                margin: 0;
                background: #fef0f5;
                font-family: Arial, sans-serif;
            }
            .captcha-box {
                background: white;
                padding: 30px;
                border-radius: 10px;
                box-shadow: 0px 0px 20px rgba(0,0,0,0.2);
                text-align: center;
            }
            .error {
                color: red;
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="captcha-box">
            <h2>Verify you are not robot</h2>

            <form action="CaptchaVerifyController" method="post">
                <div class="g-recaptcha" data-sitekey="6LdByH8rAAAAALH_2nYEW2NFOQ7gzZtjI9YXjb9s"></div>
                <br/>
                <input type="submit" value="Confirm" />
            </form>

            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
        </div>

    </body>
</html>

