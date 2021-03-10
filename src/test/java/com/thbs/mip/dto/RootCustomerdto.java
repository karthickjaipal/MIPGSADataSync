package com.thbs.mip.dto;

public class RootCustomerdto {
	Customerdto customer;

	public Customerdto getCustomer() {
		return customer;
	}

	public void setCustomer(Customerdto customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "RootCustomerdto [customer=" + customer + "]";
	}
}
