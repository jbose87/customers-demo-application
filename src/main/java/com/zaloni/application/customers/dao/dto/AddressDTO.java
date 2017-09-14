package com.zaloni.application.customers.dao.dto;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressDTO {
	

	@Column(name="ADDRESS_LINE1")
	private String addressLine1;
	
	
	@Column(name="ADDRESS_LINE2")
	private String addressLine2;
	
	@Column(name="PINCODE")
	private String pinCode;
	
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
}