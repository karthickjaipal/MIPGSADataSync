package com.thbs.mip.gsa;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

public class GETMethodDemo {
	
	@Test
	public void tc_01()
	{
		
		System.out.println("Hiiiiiiiii");
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		int statusCode=response.getStatusCode();
		System.out.println(response.getStatusLine());
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.getBody().asString());
	}
	
	@Test
	public void tc_02_get()
	{
		//This logs the entire Response in the console
		given()
		     .get("https://reqres.in/api/users?page=2")
		.then()
		     .statusCode(200).log().all();
	}
	
	@Test
	public void tc_03_get()
	{
		//Validating the response with Matchers
		given().
		     get("https://reqres.in/api/users?page=2").
		then().
		     statusCode(200).
		     body("data.id[1]", equalTo(8)).
		     body("data.first_name", hasItems("Michael","Lindsay"));
	}
	
	@Test
	public void SearchAPI()
	{
		
		baseURI="http://uat-ap-app-01.sg.bimamobile.internal:8080/mip-sync";
		//Request Formation
		
		given().
		header("Content-Type", "application/json").accept(ContentType.JSON).
		header("X-AUTH-TOKEN","eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJSQTEzMjIzIiwiYXV0aG9yaXRpZXMiOiJHU0FfQVBQIiwiZXhwIjoxNTkxMTc5MjM1LCJpc3MiOiJpbi5taXAuand0In0.dL1YQhp-3WuSCf486vQUE3LdwxSs8SFtQrCfJK3h5DoxRKLrW4gQ3CTE_DKxYVZSMeN5QzxEb1Ka-WDnBqk3Ew").
		get("/v1/search/01898795672").
		then().contentType(ContentType.JSON).
		log().all().
		statusCode(200);
	}
}
