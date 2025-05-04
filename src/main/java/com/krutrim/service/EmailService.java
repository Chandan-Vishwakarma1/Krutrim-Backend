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
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);

				helper.setTo(toEmail);
				helper.setSubject("Enrollment Confirmation");

				// Set "From" with a custom name (e.g., "Krutrim Support <noreply@krutrim.com>")
				helper.setFrom(new InternetAddress(mailUsername,"Krutrim Education"));

				// Set email content (supports HTML if needed)
				String emailContent = "Hello " + name + ",\n\n"
						+ "Thank you for registering for our free workshop. "
						+ "The event details and access link will be shared with you shortly via email and WhatsApp.\n\n\n"
						+ "Regards,\n"
						+ "Team Krutrim";

				helper.setText(emailContent);

				mailSender.send(mimeMessage);
			} catch (MessagingException e) {
				throw new RuntimeException("Failed to send email", e);
			} catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
    }

}
