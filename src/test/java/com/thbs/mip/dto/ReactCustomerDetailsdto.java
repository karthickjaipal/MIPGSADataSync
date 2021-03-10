package com.thbs.mip.dto;

import java.util.List;

public class ReactCustomerDetailsdto {
	String customerMsisdn;
	List<ReactSubscriptionDetailsdto> customerSubscriptions;

	public String getCustomerMsisdn() {
		return customerMsisdn;
	}
	public void setCustomerMsisdn(String customerMsisdn) {
		this.customerMsisdn = customerMsisdn;
	}
	public List<ReactSubscriptionDetailsdto> getCustomerSubscriptions() {
		return customerSubscriptions;
	}
	public void setCustomerSubscriptions(List<ReactSubscriptionDetailsdto> customerSubscriptions) {
		this.customerSubscriptions = customerSubscriptions;
	}

	@Override
	public String toString() {
		return "ReactCustomerDetailsdto [customerMsisdn=" + customerMsisdn + ", customerSubscriptions="
				+ customerSubscriptions + ", getCustomerMsisdn()=" + getCustomerMsisdn()
				+ ", getCustomerSubscriptions()=" + getCustomerSubscriptions() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}



}
