package com.example.OrderService.utils;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.OrderService.config.EmailConfig;

@Component
public class EmailUtils {

	private static final Logger LOGGER = LogManager.getLogger(EmailUtils.class);

	private EmailConfig emailConfig;

	@Autowired
	public EmailUtils(EmailConfig emailConfig) {
		this.emailConfig = emailConfig;
	}

	public boolean sendEmail(String to, String subject, String body) {
		LOGGER.info("inside sendEmail - EmailUtils");
		LOGGER.info("To : {} , subject : {}, content :{} ",to,subject,body);
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", emailConfig.getSmtpAuth());
		properties.put("mail.smtp.starttls.enable", emailConfig.getStarttlsEnable());
		properties.put("mail.smtp.host", emailConfig.getHost());
		properties.put("mail.smtp.port", emailConfig.getPort());
		properties.put("mail.smtp.timeout", emailConfig.getTimeout()); 
		 
		Session session = Session.getInstance(properties,
	          new javax.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(emailConfig.getUsername(), emailConfig.getPassword());
	            }
	          });

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailConfig.getUsername()));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
//			message.setText(body);
			message.setContent(body, "text/html; charset=utf-8"); // Set content type to HTML

			Transport.send(message);

			LOGGER.info("Email sent successfully!");
			return true;
		} catch (MessagingException e) {
			LOGGER.error("Error while sending mail {} ", e);
		}
		return false;
	}
//	public static void main(String[] args) {
//		
//        EmailConfig emailConfig = new EmailConfig();
//        
//        EmailUtils emailUtil = new EmailUtils(emailConfig);
//
//        String to = "youremail@gmail.com";
//        String subject = "Test Order Service Application";
//        String content = "This is a test email from JavaMail.";
//
//        emailUtil.sendEmail(to, subject, content);
//
//	}
}
