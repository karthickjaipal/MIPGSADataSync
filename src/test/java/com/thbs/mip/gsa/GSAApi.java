package com.thbs.mip.gsa;


import org.json.simple.JSONObject;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thbs.mip.dto.CustomerDetailsdto;
import com.thbs.mip.dto.Customerdto;
import com.thbs.mip.dto.Deactivationdto;
import com.thbs.mip.dto.NomineeDetailsdto;
import com.thbs.mip.dto.PaymentReactivationdto;
import com.thbs.mip.dto.ReadExcelData;
import com.thbs.mip.dto.ReadPropertyFile;
import com.thbs.mip.dto.RootCustomerdto;
import com.thbs.mip.dto.RootEditCustomerdto;
import com.thbs.mip.dto.RootReactCustomerdto;
import com.thbs.mip.dto.SubscriptionDetailsdto;
import com.thbs.mip.dto.UpdateCoverHistorydto;
import com.thbs.mip.testdata.Registrationdata;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;


public class GSAApi{
	String access_token;
	String base_url;

	@BeforeTest
	public void accessToken()
	{
		System.out.println("*************API testing Started*****************");
		Properties prop = ReadPropertyFile.property();
		System.out.println(prop.getProperty("BaseURI_uat"));
		base_url=prop.getProperty("BaseURI_uat");
		baseURI=base_url;
		Map<String,String> reqParam=new HashMap<String,String>();
		reqParam.put("loginID",prop.getProperty("clientId_uat"));
		reqParam.put("password",prop.getProperty("clientPassword_uat"));

		JSONObject reqObjects=new JSONObject(reqParam);
		Response response = 
				given().
				header("Content-Type", "application/json").
				when().
				body(reqObjects.toJSONString()).post("/v1/token").
				then().log().body().extract().response();

		String responseBody= response.asString();
		JsonPath path=new JsonPath(responseBody);
		access_token=path.getString("token");
		Assert.assertEquals(200, response.statusCode());
		System.out.println("Token Generated........!!!!!!!");
	}


	@Test(priority=0)
	public void registrationAPITest()
	{
	    System.out.println("Test case execution started.....!!!!");
	    System.out.println("Entering registrationAPITest");
		ReadExcelData data=new ReadExcelData();
		List<RootCustomerdto> customerlist = data.readRegData();
		for(RootCustomerdto cusdata:customerlist)
		{
			ObjectMapper obj=new ObjectMapper();
			String jsonStr;
			try {
				jsonStr = obj.writeValueAsString(cusdata);
				Response res = given()
						.header("Content-Type", "application/json")
						.header("X-AUTH-TOKEN",access_token).accept(ContentType.JSON)
						.body(jsonStr)
						.when().post("/v1/register-customer")
						.then().log().body().extract().response();

				String JSONString=res.asString();
				Assert.assertEquals(200, res.getStatusCode());
				Assert.assertEquals(JSONString.contains("Success"), true);
				//Assert.assertEquals(JSONString.contains("5"), true);
			}
			catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}



		}
	}

	@Test(priority=1)
	public void deactivationAPITest()
	{
		System.out.println("Entering deactivationAPITest");
		ReadExcelData red=new ReadExcelData();
		ObjectMapper obj=new ObjectMapper();
		String jsonStr;
		List<Deactivationdto> dereglist = red.readDeregData();
		for(Deactivationdto deregobj:dereglist)
		{
			try {
				jsonStr=obj.writeValueAsString(deregobj);
				Response response = 
						given().
						header("Content-Type","application/json").accept(ContentType.JSON).
						header("X-AUTH-TOKEN",access_token).
						body(jsonStr).
						when().post("/v1/deactivate").
						then().
						log().body().extract().response();
				String resString=response.asString();
				Assert.assertEquals(200, response.getStatusCode());
				Assert.assertEquals(resString.contains("Success"), true);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	//@Test(priority=2)
	public void paymentReactivationAPITest()
	{
		System.out.println("Entered paymentReactivationAPITest");
		ReadExcelData red=new ReadExcelData();
		ObjectMapper obj=new ObjectMapper();
		String jsonStr;
		List<PaymentReactivationdto> reactlist = red.readPaymentReactivatedata();
		for(PaymentReactivationdto reactobj:reactlist)
		{
			try {
				jsonStr=obj.writeValueAsString(reactobj);
				Response response = 
						given().
						header("Content-Type","application/json").accept(ContentType.JSON).
						header("X-AUTH-TOKEN",access_token).
						body(jsonStr).
						when().post("/v1/reactivate-payment").
						then().
						log().body().extract().response();
				String resString=response.asString();
				Assert.assertEquals(200, response.getStatusCode());
				Assert.assertEquals(resString.contains("Success"), true);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}


	}

	@Test(priority=3)
	public void searchCustomerAPITest()
	{
		System.out.println("Entered searchCustomerAPITest");
		ReadExcelData readdata=new ReadExcelData();
		List<String> searchlist = readdata.readSearchData();
		for(String msisdn: searchlist)
		{
			try {
				Response res=
						given()
						.header("Content-Type","application/json")
						.header("X-AUTH-TOKEN",access_token).accept(ContentType.JSON)
						.get("/v1/search/"+msisdn).then().log().body().extract().response();

				String resStr = res.asString();
				//JsonPath path=new JsonPath(resStr);
				Assert.assertEquals(200, res.getStatusCode());
				Assert.assertEquals(resStr.contains(msisdn),true);


			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority=4)
	public void updateCoverAPITest()
	{
		System.out.println("Entered updateCoverAPITest");
		ReadExcelData readdata=new ReadExcelData();
		List<UpdateCoverHistorydto> updatecoverlist = readdata.readUpdateCover();
		ObjectMapper obj=new ObjectMapper();
		String jsonStr;
		for(UpdateCoverHistorydto updatecoverobj: updatecoverlist)
		{

			try {

				jsonStr = obj.writeValueAsString(updatecoverobj);
				Response response = given().
						header("Content-Type","application/json").
						header("X-AUTH-TOKEN",access_token).accept(ContentType.JSON).
						body(jsonStr).
						when().
						post("/v1/update-cover").then().log().body().extract().response();
				String resStr=response.asString();
				Assert.assertEquals(200, response.getStatusCode());
				JsonPath path=new JsonPath(resStr);
				String statusmessage=path.getString("statusMessage");
				Assert.assertEquals("Success", statusmessage);
				
				//Assert.assertEquals(resStr.contains("5"), true);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	@Test(priority=4)
	public void subscriptionReactivationAPITest()
	{
		System.out.println("Entered subscriptionDeactivationAPITest");
		ReadExcelData readdata=new ReadExcelData();
		List<RootReactCustomerdto> subreactlist = readdata.readSubReactData();
		ObjectMapper obj=new ObjectMapper();
		String jsonStr;
		for(RootReactCustomerdto subreactobj: subreactlist)
		{

			try {

				jsonStr = obj.writeValueAsString(subreactobj);
				Response response = given().
						header("Content-Type","application/json").
						header("X-AUTH-TOKEN",access_token).accept(ContentType.JSON).
						body(jsonStr).
						when().
						post("/v1/reactivate-subscriptions").then().log().body().extract().response();
				String resStr=response.asString();
				Assert.assertEquals(200, response.getStatusCode());
				//JsonPath path=new JsonPath(resStr);
				//String statusMessage=path.getString("reactivationResponse.statusMessage");
				//Assert.assertTrue(statusMessage.contains("Customer subscription cannot be reactivated in the same month of deactivation"));
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void editCustomerAPITest()
	{
		 System.out.println("Entered editAPITest");
		 ReadExcelData red=new ReadExcelData();
		 List<RootEditCustomerdto> editlist = red.readEditData();
		 ObjectMapper obj=new ObjectMapper();
		 String editjsonStr;
		 for(RootEditCustomerdto editdto: editlist)
		 {
			 try{
				 //Converting object into Json object
			 editjsonStr=obj.writeValueAsString(editdto);
			 Response resbody=
			 given().
			 header("Content-Type","application/json").
			 header("X-AUTH-TOKEN",access_token).accept(ContentType.JSON).
			 body(editjsonStr).
			 when().put("/v1/edit-customer-subscriptions").
			 then().log().body().extract().response();
			 Assert.assertEquals(200, resbody.getStatusCode());
			 
			 }
			 catch(Exception e)
			 {
				 e.printStackTrace();
			 }
		 }
		 
		
		
		
	}
	
	@Test
    public void testAPI()
    {
    	Response response=given().
    	header("Content-Type","application/json").
    	header("X-AUTH-TOKEN",access_token).
    	body("{\"customer\" : {\"customerDetails\" : {\"customerName\" : \"AnnaNew\",   \"customerAge\" : 35,\"customerGender\" : \"M\",\"customerMsisdn\" : \"01828989333\",\"createdBy\" : 13009,\"createdDate\" : \"2020-02-28 14:53:01\"},    \"customerSubscriptions\" : [ {\"offerId\" : 5,\"offerCoverId\" : 13,\"healthTipsSmsFrequency\" : 5,\"healthTipsSmsLang\" : \"B\",\"documentTypeId\" : 2,\"documentValue\" : \"Ders2hu7geu\",\"paymentConfigurationId\" : 2,\"registeredChannelId\" : 5,\"paymentChannelId\" : 3,\"nomineeDetails\" : [ {\"name\" : \"JacobNominee\",\"age\" : 50,\"msisdn\" : \"01898745632\",\"relationship\" : \"Father\",\"gender\" : \"M\"},{\"name\" : \"JacobBeneficiary\",\"age\" : 50,\"msisdn\" : \"01898745632\",\"relationship\" : \"Father\",\"gender\" : \"M\"}]}]}}").
    	when().post("/v1/register-customer").then().
    	log().body().extract().response();
    	
    	String respBody=response.toString();
    	JsonPath js=new JsonPath(respBody);
    	String statusmessage=js.get("statusMessage");
    	Assert.assertEquals("Success", statusmessage);
    }

	@AfterTest
	public void tearDown()
	{
		System.out.println("********API testing completed***********");
	}




}
