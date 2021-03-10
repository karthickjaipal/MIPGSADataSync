package com.thbs.mip.dto;

import java.util.List;

public class SubscriptionDetailsdto {
	Integer offerId;
	Integer offerCoverId;
	Integer healthTipsSmsFrequency;
	String healthTipsSmsLang;
	Integer documentTypeId;
	String documentValue;
	Integer paymentConfigurationId;
	Integer paymentChannelId;
	Integer registeredChannelId;
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
	public Integer getDocumentTypeId() {
		return documentTypeId;
	}
	public void setDocumentTypeId(Integer documentTypeId) {
		this.documentTypeId = documentTypeId;
	}
	public String getDocumentValue() {
		return documentValue;
	}
	public void setDocumentValue(String documentValue) {
		this.documentValue = documentValue;
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
	public List<NomineeDetailsdto> getNomineeDetails() {
		return nomineeDetails;
	}
	public void setNomineeDetails(List<NomineeDetailsdto> nomineeDetails) {
		this.nomineeDetails = nomineeDetails;
	}

	
	@Override
	public String toString() {
		return "SubscriptionDetailsdto [offerId=" + offerId + ", offerCoverId=" + offerCoverId
				+ ", healthTipsSmsFrequency=" + healthTipsSmsFrequency + ", healthTipsSmsLang=" + healthTipsSmsLang
				+ ", documentTypeId=" + documentTypeId + ", documentValue=" + documentValue
				+ ", paymentConfigurationId=" + paymentConfigurationId + ", registeredChannelId=" + registeredChannelId
				+ ", nomineeDetails=" + nomineeDetails + "]";
	}
	
	
}
