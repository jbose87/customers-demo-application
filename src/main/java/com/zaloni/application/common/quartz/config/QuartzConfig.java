package com.zaloni.application.common.quartz.config;

import java.util.Properties;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.zaloni.application.common.quartz.factory.QuartzJobFactory;
import com.zaloni.application.common.quartz.job.EmailNotificationJob;
@Configuration
public class QuartzConfig {
	
	@Value("${org.quartz.scheduler.instanceName}")
	private String instanceName;

	@Value("${org.quartz.scheduler.instanceId}")
	private String instanceId;

	@Value("${org.quartz.threadPool.threadCount}")
	private String threadCount;

	@Bean
	public org.quartz.spi.JobFactory jobFactory(ApplicationContext applicationContext) {

    QuartzJobFactory sampleJobFactory = new QuartzJobFactory();
    sampleJobFactory.setApplicationContext(applicationContext);
    return sampleJobFactory;
	}

	@Bean
	public SchedulerFactoryBean schedulerFactoryBean(ApplicationContext applicationContext,Trigger cronJobTrigger) {

    SchedulerFactoryBean factory = new SchedulerFactoryBean();

    factory.setJobFactory(jobFactory(applicationContext));

    Properties quartzProperties = new Properties();
    quartzProperties.setProperty("org.quartz.scheduler.instanceName",instanceName);
    quartzProperties.setProperty("org.quartz.scheduler.instanceId",instanceId);
    quartzProperties.setProperty("org.quartz.threadPool.threadCount",threadCount);

    factory.setQuartzProperties(quartzProperties);
    factory.setTriggers(cronJobTrigger);

    return factory;
	}

	@Bean
	public CronTriggerFactoryBean cronJobTrigger(@Qualifier("cronJobDetail") JobDetail jobDetail, @Value("${quartz.cronExpression}") String cronExpression) {

    
    CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
    factoryBean.setJobDetail(jobDetail);
    factoryBean.setCronExpression(cronExpression);
    factoryBean.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_FIRE_ONCE_NOW);
    
    return factoryBean;
}

	@Bean
	public JobDetailFactoryBean cronJobDetail() {

    JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
    jobDetailFactoryBean.setJobClass(EmailNotificationJob.class);
    jobDetailFactoryBean.setDurability(true);
    

    return jobDetailFactoryBean;
}
}
