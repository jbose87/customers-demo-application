package com.zaloni.application.common.notification.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaloni.application.common.notification.INotificationService;
import com.zaloni.application.common.notification.helper.EmailSenderHelper;
import com.zaloni.application.common.util.email.EmailTemplate;
import com.zaloni.application.common.vo.EmailConfig;
import com.zaloni.application.customers.dao.ICustomerDAO;
@Service
public class EmailNotificationService implements INotificationService {
	@Autowired
	private EmailSenderHelper emailSenderHelper;
	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	public void sendMail(EmailConfig emailConfig) {
		
		EmailTemplate template = new EmailTemplate(emailConfig.getTemplateFileName());
		
		Map<String,String> replacements = new HashMap<String,String>();
    	replacements.put("user", StringUtils.split(emailConfig.getToAddress(), "@")[0]);
    	replacements.put("count", String.valueOf(customerDAO.getCountOfCustomerRecordsLast24Hours()));
    	
	    String message = template.getTemplate(replacements);
	    
        emailSenderHelper.sendEmail(emailConfig.getToAddress(),emailConfig.getFromAddress(),emailConfig.getSubject(),message);
	}
}
