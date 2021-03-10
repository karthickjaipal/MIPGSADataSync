package com.thbs.mip.dto;

public class PaymentReactivationdto {
	String customerMsisdn;
	Integer offerId;
	Integer offerCoverId;
	

	public String getCustomerMsisdn() {
		return customerMsisdn;
	}
	public void setCustomerMsisdn(String customerMsisdn) {
		this.customerMsisdn = customerMsisdn;
	}
	public Integer getOfferId() {
		return offerId;
	}
	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
	}
	public Integer getOfferCoverId() {
		return offerCoverId;
	}
	public void setOfferCoverId(Integer offerCoverId) {
		this.offerCoverId = offerCoverId;
	}
	
}
