package com.thbs.mip.dto;

public class CustomerDetailsdto {
	String customerName;
	Integer customerAge;
	String customerGender;
	String customerMsisdn;
	Integer createdBy;
	String createdDate;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Integer getCustomerAge() {
		return customerAge;
	}
	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}
	public String getCustomerGender() {
		return customerGender;
	}
	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}
	public String getCustomerMsisdn() {
		return customerMsisdn;
	}
	public void setCustomerMsisdn(String customerMsisdn) {
		this.customerMsisdn = customerMsisdn;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "CustomerDetailsdto [customerName=" + customerName + ", customerAge=" + customerAge + ", customerGender="
				+ customerGender + ", customerMsisdn=" + customerMsisdn + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
    
	
	

}
