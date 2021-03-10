package com.thbs.mip.dto;

public class UpdateCoverHistorydto {
String customerMsisdn;
Integer offerId;
Integer offerCoverId;
String createdDate;
String paidAmount;
String lifeCoverAmount;
String healthCoverAmount;
String coverStartDate;
String coverEndDate;

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
public String getCreatedDate() {
	return createdDate;
}
public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}
public String getPaidAmount() {
	return paidAmount;
}
public void setPaidAmount(String paidAmount) {
	this.paidAmount = paidAmount;
}
public String getLifeCoverAmount() {
	return lifeCoverAmount;
}
public void setLifeCoverAmount(String lifeCoverAmount) {
	this.lifeCoverAmount = lifeCoverAmount;
}
public String getHealthCoverAmount() {
	return healthCoverAmount;
}
public void setHealthCoverAmount(String healthCoverAmount) {
	this.healthCoverAmount = healthCoverAmount;
}
public String getCoverStartDate() {
	return coverStartDate;
}
public void setCoverStartDate(String coverStartDate) {
	this.coverStartDate = coverStartDate;
}
public String getCoverEndDate() {
	return coverEndDate;
}
public void setCoverEndDate(String coverEndDate) {
	this.coverEndDate = coverEndDate;
}
@Override
public String toString() {
	return "UpdateCoverHistorydto [customerMsisdn=" + customerMsisdn + ", offerId=" + offerId + ", offerCoverId="
			+ offerCoverId + ", createdDate=" + createdDate + ", paidAmount=" + paidAmount + ", lifeCoverAmount="
			+ lifeCoverAmount + ", healthCoverAmount=" + healthCoverAmount + ", coverStartDate=" + coverStartDate
			+ ", coverEndDate=" + coverEndDate + "]";
}


}
