package com.zaloni.application.common.vo;

public class EmailConfig {
	
	private String fromAddress;
	private String toAddress;
	private String subject;
	private String templateFileName;
	
	public EmailConfig() {
		super();
	}
	
	public EmailConfig(String fromAddress, String toAddress, String subject,String templateFileName) {
		super();
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.subject = subject;
		this.templateFileName = templateFileName;
	}
	/**
	 * @return the fromAddress
	 */
	public String getFromAddress() {
		return fromAddress;
	}
	/**
	 * @param fromAddress the fromAddress to set
	 */
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	/**
	 * @return the toAddress
	 */
	public String getToAddress() {
		return toAddress;
	}
	/**
	 * @param toAddress the toAddress to set
	 */
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the templateFileName
	 */
	public String getTemplateFileName() {
		return templateFileName;
	}

	/**
	 * @param templateFileName the templateFileName to set
	 */
	public void setTemplateFileName(String templateFileName) {
		this.templateFileName = templateFileName;
	}
	
}
