package com.example.OrderService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderService.config.EmailConfig;
import com.example.OrderService.utils.EmailUtils;

@RestController
public class HomeController {

	@Autowired
	EmailConfig emailConfig;
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "hello world!";
	}

	@GetMapping("/sendMail")
	public String sendMail() {
		try {

			EmailUtils emailUtil = new EmailUtils(emailConfig);

			String to = "pareshpanchal1742@gmail.com";
			String subject = "Order Service Application";
			String body =  "<h1>Hello Paresh,</h1>"
					+ "<p>This is a testing mail.</p>";

			boolean isSent = emailUtil.sendEmail(to, subject, body);
			return (isSent==true) ? "mail sent successfully!!!" :"mailed not sended.";
		} catch (Exception e) {
			System.out.println(e);
			return "error while sending mail - " + e.getMessage();
		}

	}
}
