package com.org.testapi;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestApiPostMethod {
	
	
	//Validating the whether the user is created
		@Test
		 public void ValidateResponseForCreatedUser()
		 {
			 String baseURI="https://reqres.in/api/v1/create"; //end point url or restapi
			 
			 //Sending Test Data to get created 
			 JSONObject json=new JSONObject();
			 json.put("name","Rajshekar");
			 json.put("job","Software Engineer");
			
			 		RestAssured.baseURI=baseURI;
			 		Response response=RestAssured.given()
			 					.contentType("application/json")
			 					.body(json.toString())
			 					.post();
			 		
			 		System.out.println(response.getStatusCode());
			 		System.out.println(response.getBody().asString());
			 		
			 		assertEquals(response.getStatusCode(), 201);
			 		
			 		//Validate the response for the test data created
			 		JsonPath js=response.jsonPath();
			 		System.out.println(js.get("name"));
			 		System.out.println(js.get("job"));
			 		System.out.println(js.get("id"));
			 		System.out.println(js.get("createdAt"));
			 		 
			 		 
		 }
		
		@Test
		 public void PostRequestRestAssured()
		 {
			 		RestAssured.baseURI="https://reqres.in/api/v1/create";
			 		
			 		 JSONObject json=new JSONObject();
					 json.put("name","Unni");
					 json.put("job","Test Architect");
					 
					 Response response=RestAssured.given()
			 					.contentType("application/json")
			 					.body(json.toString())
			 					.post();
			 		
					 System.out.println(response.getStatusCode());
				 		System.out.println(response.getBody().asString());
		 }
		 
		
}
