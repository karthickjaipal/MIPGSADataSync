package com.thbs.mip.gsa;


import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;


public class DELETEMethodDemo {
	@Test
	public void tc_o2_Delete()
	{
		given().
		header("Content-Type", "application/json").accept(ContentType.JSON).
		delete("https://reqres.in/api/users/2").
		then().statusCode(204).log().all();
	}

}
