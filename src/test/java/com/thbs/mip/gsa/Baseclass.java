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


public class Baseclass {
	public String access_token;
	public String base_url;

	@BeforeTest
	public void accesstoken()
	{
		System.out.println("*************API testing Started*****************");
		Properties prop = ReadPropertyFile.property();
		base_url=prop.getProperty("BaseURI_uat");
		System.out.println(base_url);
		baseURI=base_url;
		Map<String,String> reqParam=new HashMap<String,String>();
		reqParam.put("loginID",prop.getProperty("clientId_uat"));
		reqParam.put("password",prop.getProperty("clientpassword_uat"));

		JSONObject reqObjects=new JSONObject(reqParam);
		Response response = 
				given().
				header("Content-Type", "application/json").
				when().
				body(reqObjects.toJSONString()).post("/v1/token").
				then().log().body().extract().response();

		String responseBody= response.asString();
		JsonPath path=new JsonPath(responseBody);
		//access_token=path.getString("token");
		Assert.assertEquals(200, response.statusCode());
		System.out.println("Token Generated........!!!!!!!");
	}


	@AfterTest
	public void tearDown()
	{
		System.out.println("********API testing completed***********");
	}

}
