package com.zaloni.application.common.notification.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaloni.application.common.vo.EmailConfig;

@Configuration
public class EmailConfigProvider {
	
	@Value("${emailNotification.toAddress}")
	private String toAddress;

	@Value("${emailNotification.fromAddress}")
	private String fromAddress;

	@Value("${emailNotification.subject}")
	private String subject;
	
	@Value("${emailNotification.templateFileName}")
	private String templateFileName;
	
	@Bean
	public EmailConfig emailConfig(@Value("${emailNotification.toAddress}") String toAddress,@Value("${emailNotification.fromAddress}") String fromAddress,
			@Value("${emailNotification.subject}") String subject, @Value("${emailNotification.templateFileName}") String templateFileName) {

    
		return new EmailConfig(toAddress,fromAddress,subject,templateFileName);
    
    
}
	

}
