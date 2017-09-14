package com.zaloni.application.customers.vo;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document(indexName="customerindex",type="personal")
public class CustomerVO {
	

	private Integer id;
	
	
	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp = "^[a-zA-Z 0-9]+$")
	private String name;
	
	@NotNull
	@Size(min = 1, max = 30)
	@Pattern(regexp = "[a-zA-Z0-9]+[._a-zA-Z0-9!#$%&'*+-/=?^_`{|}~]*[a-zA-Z]*@[a-zA-Z0-9]{2,8}.[a-zA-Z.]{2,6}")
	private String emailId;
	
	@NotNull
	@Min(value = 1, message = "Age cannot be less than 1")
	@Max(value = 100, message = "Age cannot be greater than 100")
	private int age;
	
	@NotNull
	@Size(min = 1, max = 150)
	@Pattern(regexp = "^[a-zA-Z 0-9.,-]+$")
	private String addressLine1;
	
	
	@Size(min = 1, max = 150)
	@Pattern(regexp = "^[a-zA-Z 0-9.,-]+$")
	private String addressLine2;
	
	@NotNull
	@Size(min = 6, max = 10)
	@Pattern(regexp = "^[0-9]+$")
	private String pinCode;
	
	@NotNull
	@Pattern(regexp = "Mobile|Email")
	private String promotionalDeliveryPreference;
	
	@NotNull
	@Size(min = 1, max = 100)
	@Pattern(regexp = "^[a-zA-Z 0-9.,-]+$")
	private String usageRemarks;
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
    /**
	 * @return the promotionalDeliveryPreference
	 */
	public String getPromotionalDeliveryPreference() {
		return promotionalDeliveryPreference;
	}
	/**
	 * @param promotionalDeliveryPreference the promotionalDeliveryPreference to set
	 */
	public void setPromotionalDeliveryPreference(String promotionalDeliveryPreference) {
		this.promotionalDeliveryPreference = promotionalDeliveryPreference;
	}
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
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the addressLine2
	 */
	public String getAddressLine2() {
		return addressLine2;
	}
	/**
	 * @param addressLine2 the addressLine2 to set
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	/**
	 * @return the pinCode
	 */
	public String getPinCode() {
		return pinCode;
	}
	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	/**
	 * @return the usageRemarks
	 */
	public String getUsageRemarks() {
		return usageRemarks;
	}
	/**
	 * @param usageRemarks the usageRemarks to set
	 */
	public void setUsageRemarks(String usageRemarks) {
		this.usageRemarks = usageRemarks;
	}
	public String toString() {
    	String value = null;
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		value = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return value;
    }
}
