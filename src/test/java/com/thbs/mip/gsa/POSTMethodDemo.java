package com.thbs.mip.gsa;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thbs.mip.dto.CustomerDetailsdto;
import com.thbs.mip.dto.Customerdto;
import com.thbs.mip.dto.NomineeDetailsdto;
import com.thbs.mip.dto.RootCustomerdto;
import com.thbs.mip.dto.SubscriptionDetailsdto;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import junit.framework.Assert;

public class POSTMethodDemo {
	
	//@Test
	public void tc_01_Post()
	{
		/*
		 * Request Formation
		 * 
		 */
		//Map converted into Json object
		Map<String, Object> requestParameters=new HashMap<String, Object>();
		requestParameters.put("id", "1");
		requestParameters.put("name", "Karthic");
		JSONObject req=new JSONObject(requestParameters);
		
		//Direct Json object creation
		
		JSONObject jreq= new JSONObject();
		jreq.put("id", "2");
		jreq.put("name", "Karthic");
		
		//Printing the request
		System.out.println("Request in Json :"+req);
		System.out.println("Request in Json :"+jreq.toJSONString());
	}
	
	//@Test
	public void tc_o2_Post()
	{
		//Request Formation
		Map<String,Object> reqParam = new HashMap<String,Object>();
		reqParam.put("name", "Tom");
		reqParam.put("job", "Sailor");
		
		//Json request formation
		JSONObject jsonreq=new JSONObject(reqParam);
		
		given().
		header("Content-Type", "application/json").accept(ContentType.JSON).
		body(jsonreq.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().
		body("name", equalTo("Tom")).
		statusCode(201).log().all();
	}
	
	@Test
	public void tokenization()
	{
		
		baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";
		//Request Formation
		Map<String,Object> reqParam = new HashMap<String,Object>();
		reqParam.put("loginID", "RA13223");
		reqParam.put("password", "UkExMzIyMzMz");
		
		//Json request formation
		JSONObject jsonreq=new JSONObject(reqParam);
		Response res = given().
		header("Content-Type", "application/json").accept(ContentType.JSON).
		body(jsonreq.toJSONString()).
		when().
		post("/v1/token").
		then().contentType(ContentType.JSON).
		log().body().extract().response();
		
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	
	//@Test
	public void PaymentDeactivateAPI()
	{
		baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";
		//Request Formation
		Map<String,Object> reqParam = new HashMap<String,Object>();
		reqParam.put("customerMsisdn", "01898795672");
		reqParam.put("offerId", "6");
		reqParam.put("offerCoverId", "22");
		reqParam.put("deactivationMode", "1");
		reqParam.put("deactivatedBy", "13009");
		reqParam.put("deactivationDate", "2020-02-28 14:53:01");
		
		//Json request formation
		JSONObject jsonreq=new JSONObject(reqParam);
		
        Response res = given().
		header("Content-Type","application/json").accept(ContentType.JSON).
		header("X-AUTH-TOKEN","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQTEzMjIzIiwiYXV0aG9yaXRpZXMiOiJHU0FfQVBQIiwiZXhwIjoxNTkxMzQ5MTc4LCJpc3MiOiJpbi5taXAuand0In0.EXsEtYtC4K8oQbI5uMdUSwGFjzVZ0w9xHcOb4PMwkfiiGqxuafpgThqx3iVRxlrq7XbPPeotsdHLUq_i99WVBg").
		body(jsonreq.toJSONString()).when().post("/v1/deactivate");
        
        System.out.println(res.body().asString());
        int statusCode=res.statusCode();
        Assert.assertEquals(statusCode, 200);
	}
	
	//@Test(dataProvider="paymentDeactivateData")
	
	
	//Dataproviders
	
	@DataProvider
	public Object[][] paymentDeactivateData()
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
	
	//@Test
	public void paymentReactAPITest()
	{
		baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";
		
		Map<String,Object> reqBody = new HashMap<String,Object>();
		reqBody.put("customerMsisdn","O");
		reqBody.put("offerId", 5);
		reqBody.put("offerCoverId", 13);
		reqBody.put("reactivationDate", "");
		reqBody.put("reactivationBy", 1);
		
		JSONObject req=new JSONObject(reqBody);
		String reqString = req.toJSONString();
		
		Map<String, String> reqHeaders=new HashMap<String,String>();
		reqHeaders.put("Content-Type", "application/json");
		reqHeaders.put("X-AUTH-TOKEN", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQTEzMjIzIiwiYXV0aG9yaXRpZXMiOiJHU0FfQVBQIiwiZXhwIjoxNTkxNjAzNjk0LCJpc3MiOiJpbi5taXAuand0In0.q94OMksQmBSu2O0vMcMhWXp0NN5x_rvwOMADnwzuKK-5lJA9eiFQD1zbelthfIqzKwoXnG52ULoSG973i2Tp0w");
		//Request Formation
		
		Response responseBody = given().
		 headers(reqHeaders).
		 contentType(ContentType.JSON).
		 body(reqString).
		when().
		 post("/v1/reactivate-payment").
		then()
		 .log().body().extract().response();
		
		//Verification of HTTP Status code
		Assert.assertEquals(200, responseBody.getStatusCode());
	}
	
	//@Test(dataProvider="lifeRegistrationData")
		public void lifeRegistrationAPI(String customerName,int customerAge,String customerGender,String customerMsisdn,int createdBy,String createdDate
				, int offerId, int offerCoverId, int healthTipsSmsFrequency, String healthTipsSmsLang, int documentTypeId, String documentValue,
				int paymentConfigurationId,int registeredChannelId, int paymentChannelId, String name, int age, String msisdn, String relationship, String gender  )
		{
			baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";

			CustomerDetailsdto customerdata=new CustomerDetailsdto();
			customerdata.setCustomerName(customerName);
			customerdata.setCustomerAge(customerAge);
			customerdata.setCustomerGender(customerGender);
			customerdata.setCustomerMsisdn(customerMsisdn);
			customerdata.setCreatedBy(createdBy);
			customerdata.setCreatedDate(createdDate);


			NomineeDetailsdto nomineedata=new NomineeDetailsdto();
			nomineedata.setName(name);
			nomineedata.setAge(age);
			nomineedata.setGender(gender);
			nomineedata.setMsisdn(msisdn);
			nomineedata.setRelationship(relationship);

			List<NomineeDetailsdto> nomineelist=new ArrayList<NomineeDetailsdto>();
			nomineelist.add(nomineedata);

			SubscriptionDetailsdto subscriptiondata=new SubscriptionDetailsdto();
			subscriptiondata.setOfferId(offerId);
			subscriptiondata.setOfferCoverId(offerCoverId);
			subscriptiondata.setHealthTipsSmsFrequency(healthTipsSmsFrequency);
			subscriptiondata.setHealthTipsSmsLang(healthTipsSmsLang);
			subscriptiondata.setDocumentTypeId(documentTypeId);
			subscriptiondata.setDocumentValue(documentValue);
			subscriptiondata.setPaymentConfigurationId(paymentConfigurationId);
			subscriptiondata.setRegisteredChannelId(registeredChannelId);
			subscriptiondata.setPaymentChannelId(paymentChannelId);
			subscriptiondata.setNomineeDetails(nomineelist);


			List<SubscriptionDetailsdto> subsubscriptionlist=new ArrayList<SubscriptionDetailsdto>();
			subsubscriptionlist.add(subscriptiondata);


			Customerdto customer=new Customerdto();
			customer.setCustomerDetails(customerdata);
			customer.setCustomerSubscriptions(subsubscriptionlist);

			RootCustomerdto rootcustomer=new RootCustomerdto();
			rootcustomer.setCustomer(customer);

			//COnvert Object to JsonObject
			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = null;
			try {

				jsonStr = Obj.writeValueAsString(rootcustomer);
			} catch (Exception e) {

				e.printStackTrace();
			}


			/*JSONObject jsonreq=new JSONObject();
			System.out.println(jsonreq.toJSONString());*/

			Response res = given()
					.header("Content-Type", "application/json")
					.header("X-AUTH-TOKEN","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQTEzMjIzIiwiYXV0aG9yaXRpZXMiOiJHU0FfQVBQIiwiZXhwIjoxNTkxMzQ5MTc4LCJpc3MiOiJpbi5taXAuand0In0.EXsEtYtC4K8oQbI5uMdUSwGFjzVZ0w9xHcOb4PMwkfiiGqxuafpgThqx3iVRxlrq7XbPPeotsdHLUq_i99WVBg").accept(ContentType.JSON)
					.body(jsonStr)
					.when().post("/v1/register-customer")
					.then().log().body().extract().response();

			String JSONString=res.asString();
			Assert.assertEquals(200, res.getStatusCode());
			Assert.assertEquals(JSONString.contains("Success"), true);
			Assert.assertEquals(JSONString.contains("5"), true);
		}

		//@Test(dataProvider="hospitalRegistrationData")
		public void hospitalRegistrationAPI(String customerName,int customerAge,String customerGender,String customerMsisdn,int createdBy,String createdDate
				, int offerId, int offerCoverId, int healthTipsSmsFrequency, String healthTipsSmsLang, int documentTypeId, String documentValue,
				int paymentConfigurationId,int registeredChannelId, int paymentChannelId, String name, int age, String msisdn, String relationship, String gender  )
		{
			baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";

			CustomerDetailsdto customerdata=new CustomerDetailsdto();
			customerdata.setCustomerName(customerName);
			customerdata.setCustomerAge(customerAge);
			customerdata.setCustomerGender(customerGender);
			customerdata.setCustomerMsisdn(customerMsisdn);
			customerdata.setCreatedBy(createdBy);
			customerdata.setCreatedDate(createdDate);


			NomineeDetailsdto nomineedata=new NomineeDetailsdto();
			nomineedata.setName(name);
			nomineedata.setAge(age);
			nomineedata.setGender(gender);
			nomineedata.setMsisdn(msisdn);
			nomineedata.setRelationship(relationship);

			List<NomineeDetailsdto> nomineelist=new ArrayList<NomineeDetailsdto>();
			nomineelist.add(nomineedata);

			SubscriptionDetailsdto subscriptiondata=new SubscriptionDetailsdto();
			subscriptiondata.setOfferId(offerId);
			subscriptiondata.setOfferCoverId(offerCoverId);
			subscriptiondata.setHealthTipsSmsFrequency(healthTipsSmsFrequency);
			subscriptiondata.setHealthTipsSmsLang(healthTipsSmsLang);
			subscriptiondata.setDocumentTypeId(documentTypeId);
			subscriptiondata.setDocumentValue(documentValue);
			subscriptiondata.setPaymentConfigurationId(paymentConfigurationId);
			subscriptiondata.setRegisteredChannelId(registeredChannelId);
			subscriptiondata.setPaymentChannelId(paymentChannelId);
			subscriptiondata.setNomineeDetails(nomineelist);


			List<SubscriptionDetailsdto> subsubscriptionlist=new ArrayList<SubscriptionDetailsdto>();
			subsubscriptionlist.add(subscriptiondata);


			Customerdto customer=new Customerdto();
			customer.setCustomerDetails(customerdata);
			customer.setCustomerSubscriptions(subsubscriptionlist);

			RootCustomerdto rootcustomer=new RootCustomerdto();
			rootcustomer.setCustomer(customer);

			//COnvert Object to JsonObject
			ObjectMapper Obj = new ObjectMapper();
			String jsonStr = null;
			try {

				jsonStr = Obj.writeValueAsString(rootcustomer);
			} catch (Exception e) {

				e.printStackTrace();
			}


			/*JSONObject jsonreq=new JSONObject();
				System.out.println(jsonreq.toJSONString());*/

			Response res = given()
					.header("Content-Type", "application/json")
					.header("X-AUTH-TOKEN","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQTEzMjIzIiwiYXV0aG9yaXRpZXMiOiJHU0FfQVBQIiwiZXhwIjoxNTkxMzQ5MTc4LCJpc3MiOiJpbi5taXAuand0In0.EXsEtYtC4K8oQbI5uMdUSwGFjzVZ0w9xHcOb4PMwkfiiGqxuafpgThqx3iVRxlrq7XbPPeotsdHLUq_i99WVBg").accept(ContentType.JSON)
					.body(jsonStr)
					.when().post("/v1/register-customer")
					.then().log().body().extract().response();

			String JSONString=res.asString();
			Assert.assertEquals(200, res.getStatusCode());
			Assert.assertEquals(JSONString.contains("Success"), true);
			Assert.assertEquals(JSONString.contains("6"), true);
		}
		
		//@Test(dataProvider="paymentDeactivateData")
		public void PaymentDeactivateAPI(String msisdn,int offerId,int offerCoverId,int deactivationMode,int deactivatedBy,String deactivatedDate)
		{
			baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";
			//Request Formation
			Map<String,Object> reqParam = new HashMap<String,Object>();
			reqParam.put("customerMsisdn", msisdn);
			reqParam.put("offerId", offerId);
			reqParam.put("offerCoverId", offerCoverId);
			reqParam.put("deactivationMode", deactivationMode);
			reqParam.put("deactivatedBy", deactivatedBy);
			reqParam.put("deactivationDate", deactivatedDate);

			//Json request formation
			JSONObject jsonreq=new JSONObject(reqParam);

			Response res = given().
					header("Content-Type","application/json").accept(ContentType.JSON).
					header("X-AUTH-TOKEN","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQTEzMjIzIiwiYXV0aG9yaXRpZXMiOiJHU0FfQVBQIiwiZXhwIjoxNTkxMzQ5MTc4LCJpc3MiOiJpbi5taXAuand0In0.EXsEtYtC4K8oQbI5uMdUSwGFjzVZ0w9xHcOb4PMwkfiiGqxuafpgThqx3iVRxlrq7XbPPeotsdHLUq_i99WVBg").
					body(jsonreq.toJSONString()).when().post("/v1/deactivate").
					then().log().body().extract().response();


			String JSONString= res.asString();
			//System.out.println(JSONString);
			Assert.assertEquals(200, res.statusCode());
			//Assert.assertEquals(JSONString.contains("Customer is already payment deactivated"), true);
			Assert.assertEquals(JSONString.contains("Success"), true);
		}


		//@Test(dataProvider="paymentReactivateData")
		public void PaymentReactivateAPI(String msisdn,int offerId,int offerCoverId)
		{
			baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";
			//Request Formation
			Map<String,Object> reqParam = new HashMap<String,Object>();
			reqParam.put("customerMsisdn", msisdn);
			reqParam.put("offerId", offerId);
			reqParam.put("offerCoverId", offerCoverId);

			//Json request formation
			JSONObject jsonreq=new JSONObject(reqParam);

			Response res = given().
					header("Content-Type","application/json").accept(ContentType.JSON).
					header("X-AUTH-TOKEN","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQTEzMjIzIiwiYXV0aG9yaXRpZXMiOiJHU0FfQVBQIiwiZXhwIjoxNTkxMzQ5MTc4LCJpc3MiOiJpbi5taXAuand0In0.EXsEtYtC4K8oQbI5uMdUSwGFjzVZ0w9xHcOb4PMwkfiiGqxuafpgThqx3iVRxlrq7XbPPeotsdHLUq_i99WVBg").
					body(jsonreq.toJSONString()).when().post("/v1/reactivate-payment").
					then().log().body().extract().response();


			String JSONString= res.asString();
			//System.out.println(JSONString);
			Assert.assertEquals(200, res.statusCode());
			Assert.assertEquals(JSONString.contains("Success"), true);
		}

		@Test(dataProvider="searchData")
		public void searchAPI(String msisdn)
		{
			baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";
			Response res = given()
					.headers("Content-Type","application/json")
					.header("X-AUTH-TOKEN","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQTEzMjIzIiwiYXV0aG9yaXRpZXMiOiJHU0FfQVBQIiwiZXhwIjoxNTkxMzQ5MTc4LCJpc3MiOiJpbi5taXAuand0In0.EXsEtYtC4K8oQbI5uMdUSwGFjzVZ0w9xHcOb4PMwkfiiGqxuafpgThqx3iVRxlrq7XbPPeotsdHLUq_i99WVBg").accept(ContentType.JSON)
					.get("/v1/search/"+msisdn)
					.then().log().body().extract().response();

			Assert.assertEquals(200, res.getStatusCode());
			String jsonStr= res.asString();
			Assert.assertEquals(jsonStr.contains(msisdn), true);
		}

        
		

		
	

}
