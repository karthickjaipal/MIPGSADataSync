package com.thbs.mip.dto;

public class Deactivationdto {
	String customerMsisdn;
	Integer offerId;
	Integer offerCoverId;
	Integer deactivationMode;
	Integer deactivatedBy;
	String deactivationDate;

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
	public Integer getDeactivationMode() {
		return deactivationMode;
	}
	public void setDeactivationMode(Integer deactivationMode) {
		this.deactivationMode = deactivationMode;
	}
	public Integer getDeactivatedBy() {
		return deactivatedBy;
	}
	public void setDeactivatedBy(Integer deactivatedBy) {
		this.deactivatedBy = deactivatedBy;
	}
	public String getDeactivationDate() {
		return deactivationDate;
	}
	public void setDeactivationDate(String deactivationDate) {
		this.deactivationDate = deactivationDate;
	}


}
