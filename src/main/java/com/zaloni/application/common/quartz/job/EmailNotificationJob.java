package com.zaloni.application.common.quartz.job;



import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.zaloni.application.common.notification.impl.EmailNotificationService;
import com.zaloni.application.common.vo.EmailConfig;


public class EmailNotificationJob implements Job {
	
	@Autowired
    private EmailNotificationService emailNotificationService;
	
	@Autowired
    private EmailConfig emailConfig;
 
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	
        emailNotificationService.sendMail(emailConfig);
    }
}


