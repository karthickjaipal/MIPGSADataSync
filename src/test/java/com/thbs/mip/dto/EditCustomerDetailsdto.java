package com.thbs.mip.dto;

import java.util.List;

public class EditCustomerDetailsdto {
	String customerName;
	Integer customerAge;
	String customerGender;
	String customerMsisdn;
	Integer modifiedBy;
	String modifiedDate;
	List<Documentdetailsdto> documentDetails;
	
	
	public List<Documentdetailsdto> getDocumentDetails() {
		return documentDetails;
	}
	public void setDocumentDetails(List<Documentdetailsdto> documentDetails) {
		this.documentDetails = documentDetails;
	}
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
	public Integer getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(Integer modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "EditCustomerDetailsdto [customerName=" + customerName + ", customerAge=" + customerAge
				+ ", customerGender=" + customerGender + ", customerMsisdn=" + customerMsisdn + ", modifiedBy="
				+ modifiedBy + ", modifiedDate=" + modifiedDate + ", documentDetails=" + documentDetails + "]";
	}
	
	
    
	
    
	
	

}
