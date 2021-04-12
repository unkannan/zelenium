package com.org.testapi;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestApiGetUsingQueryParams {
	@Test
    public void queryParameter() {

		RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/"; 
		RequestSpecification request = RestAssured.given();
		
		Response response =  request
							.queryParam("q", "London,UK") 
							.queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8") 
							.get("/weather");
		
		assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getStatusCode());
		System.out.println(response.asString());
		//Assert.assertEquals(jsonString.contains("London"), true);
		
		JsonPath js = response.jsonPath();
			System.out.println("coord " + js.get("coord"));
			System.out.println("name " + js.get("name"));
			System.out.println("country " + js.get("country"));
			System.out.println("clouds " + js.get("clouds"));
			System.out.println("main.humidity " + js.get("main.humidity"));
			System.out.println("main.temp_min " + js.get("main.temp_min"));
		
			 JSONObject jsonResponseResult=new JSONObject(response.getBody().asString()); 
				System.out.println(jsonResponseResult.get("name"));
}

}

