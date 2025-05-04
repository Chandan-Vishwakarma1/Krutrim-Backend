package com.krutrim.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String mailUsername;

    public void sendEnrollmentEmail(String toEmail, String name) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(toEmail);
            helper.setSubject("Thank You for Registering – Your AI/ML Workshop Details Await!");
            helper.setFrom(new InternetAddress(mailUsername, "Krutrim Education"));

            // HTML email content with bold tags
            String emailContent = "<p>Dear <strong>" + name + "</strong>,</p>" +
                    "<p>Thank you for registering for our <strong>Free Foundational AI/ML Workshop!</strong> We’re thrilled to have you join us on this journey into the world of Artificial Intelligence and Machine Learning.</p>" +
                    "<p>You'll receive details about the upcoming weekend workshop shortly, including how to access the session online. Stay tuned!</p>" +
                    "<p>Meanwhile, if you have any questions, feel free to reach out to us at <strong>support@krutrimedu.com</strong> or connect with us on WhatsApp at <strong>9970776903</strong>.</p>" +
                    "<p>We can't wait to explore AI/ML together!</p>" +
                    "<p>Best regards,<br><strong>Krutrim Education Team</strong></p>";

            helper.setText(emailContent, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send email", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
