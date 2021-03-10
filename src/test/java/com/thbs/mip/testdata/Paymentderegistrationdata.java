package com.thbs.mip.testdata;

import org.testng.annotations.DataProvider;

public class Paymentderegistrationdata {

	@DataProvider
	public Object[][] lifePaymentDeactivateData()
	{
		/*Object[][] data=new Object[1][6];
				data[0][0]="01898795672";
				data[0][1]=6;
				data[0][2]=22;
				data[0][3]=1;
				data[0][4]=13009;
				data[0][5]="2020-02-28 14:53:01";

				return data;*/

		return new Object[][]{{"01898795672",6,22,1,13009,"2020-02-28 14:53:01"}};

	}
	
	@DataProvider
	public Object[][] hospPaymentDeactivateData()
	{
		/*Object[][] data=new Object[1][6];
				data[0][0]="01898795672";
				data[0][1]=6;
				data[0][2]=22;
				data[0][3]=1;
				data[0][4]=13009;
				data[0][5]="2020-02-28 14:53:01";

				return data;*/

		return new Object[][]{{"01898795672",6,22,1,13009,"2020-02-28 14:53:01"}};

	}
}
