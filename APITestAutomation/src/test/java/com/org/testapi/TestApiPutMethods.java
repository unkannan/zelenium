package com.org.testapi;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestApiPutMethods {
	
	@Test
	 public void UpdateCustomerUsingPUT()
	 {
		 String baseURI="https://reqres.in/api/users/2"; //end point url or restapi
		
		 
		 //Sending Test Data to get created 
		 JSONObject json=new JSONObject();
		 json.put("name","James Clark");
		 json.put("job","Software Engineer");
		 //---------------------------------------------
		
		 		RestAssured.baseURI=baseURI;
		 		Response response=RestAssured.given()
		 					.contentType("application/json")
		 					.body(json.toString())
		 					.put();
		 		
		 		System.out.println(response.getStatusCode());
		 		System.out.println(response.getBody().asString());
		 		
		 		assertEquals(response.getStatusCode(), 200);
		 		
		 		//Validate the response for the test data created
		 		JsonPath js=response.jsonPath();
		 		System.out.println(js.get("name"));
		 		System.out.println(js.get("job"));
		 		System.out.println(js.get("updatedAt"));
		 		 
		 		 
	 }

}
