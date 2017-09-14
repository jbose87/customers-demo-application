package com.zaloni.application.customers.vo;

public class CustomerResponseVO {
	
	int custId;
	
	String responseMessage;
	
	public CustomerResponseVO() {
		super();
	}
	
	public CustomerResponseVO(int custId, String responseMessage) {
		super();
		this.custId = custId;
		this.responseMessage = responseMessage;
	}

	/**
	 * @return the custId
	 */
	public int getCustId() {
		return custId;
	}

	/**
	 * @param custId the custId to set
	 */
	public void setCustId(int custId) {
		this.custId = custId;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
