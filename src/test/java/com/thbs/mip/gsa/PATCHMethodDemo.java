package com.thbs.mip.gsa;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class PATCHMethodDemo {
	
	@Test
	public void tc_01_Patch()
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
	
	@Test
	public void tc_o2_Patch()
	{
		//Request Formation
		Map<String,Object> reqParam = new HashMap<String,Object>();
		reqParam.put("name", "Tom");
		reqParam.put("job", "Hacker");
		
		//Json request formation
		JSONObject jsonreq=new JSONObject(reqParam);
		
		given().
		header("Content-Type", "application/json").accept(ContentType.JSON).
		body(jsonreq.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		//Response validation
		then().
		body("job", equalTo("Hacker")).
		//Validating the response code and logging entire response in console
		statusCode(200).log().all();
	}

}
