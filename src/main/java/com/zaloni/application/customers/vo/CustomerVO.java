package com.zaloni.application.customers.vo;

import java.util.Date;

import org.springframework.data.annotation.Id;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName="customerindex",type="personal")
public class CustomerVO {
	
	@Id
	private Integer id;
	
	
	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp = "^[a-zA-Z 0-9]+$")
	private String name;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Field(type = FieldType.Date, store = true)
	private Date submissionDate;
	
	@NotNull
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}")
	private String emailId;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the submissionDate
	 */
	public Date getSubmissionDate() {
		return submissionDate;
	}
	/**
	 * @param submissionDate the submissionDate to set
	 */
    public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}
	

}
