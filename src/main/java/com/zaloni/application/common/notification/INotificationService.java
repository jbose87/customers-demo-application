package com.zaloni.application.common.notification;


import com.zaloni.application.common.vo.EmailConfig;


public interface INotificationService {
	
	public void sendMail(EmailConfig emailConfig);
}
