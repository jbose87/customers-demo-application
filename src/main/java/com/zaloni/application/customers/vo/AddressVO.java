package com.zaloni.application.customers.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AddressVO {
	
	@NotNull
	@Size(min = 1, max = 150)
	@Pattern(regexp = "^[a-zA-Z 0-9.,]+$")
	private String addressLine1;
	
	
	@Size(min = 1, max = 150)
	@Pattern(regexp = "^[a-zA-Z 0-9.,]+$")
	private String addressLine2;
	
	@NotNull
	@Size(min = 10, max = 10)
	@Pattern(regexp = "^[0-9]+$")
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
