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
import com.thbs.mip.dto.NomineeDetailsdto;
import com.thbs.mip.dto.ReadExcelData;
import com.thbs.mip.dto.ReadPropertyFile;
import com.thbs.mip.dto.RootCustomerdto;
import com.thbs.mip.dto.SubscriptionDetailsdto;
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

public class RegisterCustomerAPI extends Baseclass {
	
	@Test
	public void registrationAPItest()
	{
		baseURI=base_url;
		System.out.println("Test case execution started.....!!!!");
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
				/*Assert.assertEquals(JSONString.contains("Success"), true);
				Assert.assertEquals(JSONString.contains("5"), true);*/
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		
		}
	}

}
