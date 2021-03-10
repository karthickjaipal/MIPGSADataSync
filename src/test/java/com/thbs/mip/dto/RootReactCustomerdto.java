package com.thbs.mip.dto;

public class RootReactCustomerdto {
	ReactCustomerDetailsdto reactivateCustomer;

	public ReactCustomerDetailsdto getReactivateCustomer() {
		return reactivateCustomer;
	}

	public void setReactivateCustomer(ReactCustomerDetailsdto reactivateCustomer) {
		this.reactivateCustomer = reactivateCustomer;
	}

	@Override
	public String toString() {
		return "RootReactCustomerdto [reactivateCustomer=" + reactivateCustomer + ", getReactivateCustomer()="
				+ getReactivateCustomer() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
}
