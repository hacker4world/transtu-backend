package com.group.transtubackend.services;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailService(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.mailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendPasswordResetEmail(String email, String passwordResetCode) throws MessagingException {
        try {

            // creating email instance
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // setting the email title, sender and recipient
            helper.setTo(email);
            helper.setSubject("Password reset - Transtu");
            helper.setFrom("hamdijbeli1920@gmail.com");

            Context context = new Context();

            // choosing the HTML template for the email and setting the name and code variables
            context.setVariable("code", passwordResetCode);

            String htmlContent = templateEngine.process("password_reset", context);

            helper.setText(htmlContent, true);

            mailSender.send(message);

        } catch (Exception e) {
            e.printStackTrace();
            throw new MessagingException("Failed to send verification email", e);
        }
    }

}
