package com.thbs.mip.testdata;

import org.testng.annotations.DataProvider;

public class Registrationdata {

	@DataProvider
	public Object[][] lifeRegistrationData()
	{
		
			
			return new Object[][]{
			/*(String customerName,int customerAge,String customerGender,String customerMsisdn,int createdBy,String createdDate
					, int offerId, int offerCoverId, int healthTipsSmsFrequency, String healthTipsSmsLang, int documentTypeId, String documentValue,
					int paymentConfigurationId,int registeredChannelId, int paymentChannelId, String name, int age, String msisdn, String relationship, String gender)*/
			{"TestAutoCustomer",68,"M","01828989927",13009,"2020-02-28 14:53:01",5,11,6,"B",3,"Ders2hu7geu",5,5,3,"testnominee",45,"01898745632","Father","M"}
			,{"TestAutoCus",68,"M","01828989928",13009,"2020-02-28 14:53:01",5,12,4,"B",2,"Ders2hu7geu",5,5,3,"testnominee",45,"01898745632","Father","M"}
			,{"TestAutoCustom",68,"M","01828989928",13009,"2020-02-28 14:53:01",5,13,3,"B",1,"Ders2hu7geu",5,5,3,"testnominee",45,"01898745632","Father","M"}
			};
	}
	
	@DataProvider
	public Object[][] hospitalRegistrationData()
	{
		return new Object[][]{
			/*(String customerName,int customerAge,String customerGender,String customerMsisdn,int createdBy,String createdDate
			, int offerId, int offerCoverId, int healthTipsSmsFrequency, String healthTipsSmsLang, int documentTypeId, String documentValue,
			int paymentConfigurationId,int registeredChannelId, int paymentChannelId, String name, int age, String msisdn, String relationship, String gender)*/
	
			{"TestAutoCustomer",68,"M","01828989927",13009,"2020-02-28 14:53:01",6,22,4,"B",3,"Ders2hu7geu",5,5,3,"testnominee",45,"01898745632","Father","M"}
			,{"TestAutoCustomer",68,"M","01828989928",13009,"2020-02-28 14:53:01",6,21,4,"B",1,"Ders2hu7geu",5,5,3,"testnominee",45,"01898745632","Father","M"}
			,{"TestAutoCustomer",68,"M","01828989929",13009,"2020-02-28 14:53:01",6,15,4,"B",2,"Ders2hu7geu",5,5,3,"testnominee",45,"01898745632","Father","M"}
			};
	}
	
	@DataProvider
	public Object[][] searchData()
	{
		return new Object[][]{{"01798795428"},{"01798564129"},{"01789495098"}};
		

	}
}
