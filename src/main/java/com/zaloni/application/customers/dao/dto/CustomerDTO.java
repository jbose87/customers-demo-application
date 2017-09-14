package com.zaloni.application.customers.dao.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "CUSTOMER_DATA",uniqueConstraints = @UniqueConstraint(columnNames = {"NAME","EMAIL_ID"}))
public class CustomerDTO {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;
    
    @Column(name = "EMAIL_ID")
    private String emailId;
    
    @Column(name = "UPDATED_TIME")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    
    @Column(name = "AGE")
    private int age;
    
    @Column(name="ADDRESS_LINE1")
	private String addressLine1;
	
	
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name="PINCODE")
	private String pinCode;
    
    @Column(name = "PROMO_DELV_PREF")
    private String promotionalDeliveryPreference;
    
    @Column(name = "USAGE_REMARKS")
    private String usageRemarks;

	/**
	 * @return the updatedTime
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * @param updatedTime the updatedTime to set
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
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
	 * @param promotionalDeliveryPreference the promotionalDeliveryPreference to set
	 */
	public void setPromotionalDeliveryPreference(String promotionalDeliveryPreference) {
		this.promotionalDeliveryPreference = promotionalDeliveryPreference;
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

}

