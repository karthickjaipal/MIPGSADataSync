package com.thbs.mip.dto;

import java.util.List;

public class Customerdto {
	CustomerDetailsdto customerDetails;
	List<SubscriptionDetailsdto> customerSubscriptions;
	
	public CustomerDetailsdto getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(CustomerDetailsdto customerDetails) {
		this.customerDetails = customerDetails;
	}
	public List<SubscriptionDetailsdto> getCustomerSubscriptions() {
		return customerSubscriptions;
	}
	public void setCustomerSubscriptions(List<SubscriptionDetailsdto> customerSubscriptions) {
		this.customerSubscriptions = customerSubscriptions;
	}
	
	@Override
	public String toString() {
		return "Customerdto [customerDetails=" + customerDetails + ", customerSubscriptions=" + customerSubscriptions
				+ "]";
	}
	
	
	
}
