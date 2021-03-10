package com.thbs.mip.dto;

import java.util.List;

public class EditCustomerdto {
	EditCustomerDetailsdto customerDetails;
	List<EditSubscriptionDetailsdto> currentSubscriptions;
	
	public EditCustomerDetailsdto getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(EditCustomerDetailsdto customerDetails) {
		this.customerDetails = customerDetails;
	}
	public List<EditSubscriptionDetailsdto> getCurrentSubscriptions() {
		return currentSubscriptions;
	}
	public void setCurrentSubscriptions(List<EditSubscriptionDetailsdto> currentSubscriptions) {
		this.currentSubscriptions = currentSubscriptions;
	}
	@Override
	public String toString() {
		return "EditCustomerdto [customerDetails=" + customerDetails + ", currentSubscriptions="
				+ currentSubscriptions + "]";
	}
	
	
	
	
	
}
