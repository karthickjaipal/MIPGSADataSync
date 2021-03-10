package com.thbs.mip.testdata;

import org.testng.annotations.DataProvider;

public class Paymentreactivationdata {

	@DataProvider
	public Object[][] lifePaymentReactivateData()
	{
		return new Object[][]{{"01898795672",5,11}};
	}
	
	@DataProvider
	public Object[][] hospPaymentReactivateData()
	{
		return new Object[][]{{"01898795672",6,22}};
	}

}
