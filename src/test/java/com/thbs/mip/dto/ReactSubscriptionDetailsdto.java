package com.thbs.mip.dto;

import java.util.List;

public class ReactSubscriptionDetailsdto {
	Integer offerId;
	Integer offerCoverId;
	Integer healthTipsSmsFrequency;
	String healthTipsSmsLang;
	Integer paymentConfigurationId;
	Integer paymentChannelId;
	Integer registeredChannelId;
	Integer createdBy;
	String  createdDate;
	List<NomineeDetailsdto> nomineeDetails;
	
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
	public Integer getHealthTipsSmsFrequency() {
		return healthTipsSmsFrequency;
	}
	public void setHealthTipsSmsFrequency(Integer healthTipsSmsFrequency) {
		this.healthTipsSmsFrequency = healthTipsSmsFrequency;
	}
	public String getHealthTipsSmsLang() {
		return healthTipsSmsLang;
	}
	public void setHealthTipsSmsLang(String healthTipsSmsLang) {
		this.healthTipsSmsLang = healthTipsSmsLang;
	}
	public Integer getPaymentConfigurationId() {
		return paymentConfigurationId;
	}
	public void setPaymentConfigurationId(Integer paymentConfigurationId) {
		this.paymentConfigurationId = paymentConfigurationId;
	}
	public Integer getPaymentChannelId() {
		return paymentChannelId;
	}
	public void setPaymentChannelId(Integer paymentChannelId) {
		this.paymentChannelId = paymentChannelId;
	}
	public Integer getRegisteredChannelId() {
		return registeredChannelId;
	}
	public void setRegisteredChannelId(Integer registeredChannelId) {
		this.registeredChannelId = registeredChannelId;
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
	public List<NomineeDetailsdto> getNomineeDetails() {
		return nomineeDetails;
	}
	public void setNomineeDetails(List<NomineeDetailsdto> nomineeDetails) {
		this.nomineeDetails = nomineeDetails;
	}
	@Override
	public String toString() {
		return "ReactSubscriptionDetailsdto [offerId=" + offerId + ", offerCoverId=" + offerCoverId
				+ ", healthTipsSmsFrequency=" + healthTipsSmsFrequency + ", healthTipsSmsLang=" + healthTipsSmsLang
				+ ", paymentConfigurationId=" + paymentConfigurationId + ", paymentChannelId=" + paymentChannelId
				+ ", registeredChannelId=" + registeredChannelId + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", nomineeDetails=" + nomineeDetails + "]";
	}
	

	

}
