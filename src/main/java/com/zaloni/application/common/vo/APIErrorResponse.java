package com.zaloni.application.common.vo;

import java.util.List;

public class APIErrorResponse {
	
	private String code;
	private List<String> causes;
	
	public APIErrorResponse(String code, List<String> causes) {
        this.code = code;
        this.causes = causes;
    }
    public APIErrorResponse() {
    }   
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the causes
	 */
	public List<String> getCauses() {
		return causes;
	}
	/**
	 * @param causes the causes to set
	 */
	public void setCauses(List<String> causes) {
		this.causes = causes;
	}
	
	

}
