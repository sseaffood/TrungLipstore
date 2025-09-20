/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package tech.gmail;

import java.io.IOException;
import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author 84904
 */
@WebServlet("/SendEmail")
public class SendEmail extends HttpServlet {
    private static final String FROM_EMAIL = "trungdinh.dev@gmail.com";
    private static final String FROM_PASSWORD = "ypro gvtg pzqc hplx";
    private static final String ERROR = "contact.jsp";
    private static final String SUCCESS = "thankyou.jsp";
    private static final Logger logger = LogManager.getLogger(SendEmail.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.info("Da nhan yeu cau gui mail");
        String toEmail = request.getParameter("email");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, FROM_PASSWORD);
            }
        });
        String url= ERROR;
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(FROM_EMAIL));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Thu xac nhan TrungLipstick");
            message.setText("Hello!\n\nChuc mung gui mail thanh cong!!!");
            Transport.send(message);
            url=SUCCESS;
        } catch (MessagingException e) {
            log("Error at SearchController: "+ e.toString());
        }finally{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
}