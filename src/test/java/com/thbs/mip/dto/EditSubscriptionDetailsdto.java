package com.thbs.mip.dto;

import java.util.List;

public class EditSubscriptionDetailsdto {
	Integer offerId;
	Integer offerCoverId;
	Integer healthTipsSmsFrequency;
	String healthTipsSmsLang;
	Integer paymentChannelId;
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
	public Integer getPaymentChannelId() {
		return paymentChannelId;
	}
	public void setPaymentChannelId(Integer paymentChannelId) {
		this.paymentChannelId = paymentChannelId;
	}
	public List<NomineeDetailsdto> getNomineeDetails() {
		return nomineeDetails;
	}
	public void setNomineeDetails(List<NomineeDetailsdto> nomineeDetails) {
		this.nomineeDetails = nomineeDetails;
	}
	@Override
	public String toString() {
		return "EditSubscriptionDetailsdto [offerId=" + offerId + ", offerCoverId=" + offerCoverId
				+ ", healthTipsSmsFrequency=" + healthTipsSmsFrequency + ", healthTipsSmsLang=" + healthTipsSmsLang
				+ ", paymentChannelId=" + paymentChannelId + ", nomineeDetails=" + nomineeDetails + "]";
	}
	
	
	
}
