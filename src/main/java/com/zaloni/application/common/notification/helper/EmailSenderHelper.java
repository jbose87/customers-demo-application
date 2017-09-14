package com.zaloni.application.common.notification.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderHelper {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String to, String from, String subject, String body) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(to);
		mailMessage.setReplyTo(to);
		mailMessage.setFrom(from);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		
		mailSender.send(mailMessage);
	}

}
