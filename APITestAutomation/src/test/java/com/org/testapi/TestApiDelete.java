package com.org.testapi;

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestApiDelete {
	
	@Test
	public void testDelete() {
		
			
			 String baseURI="https://reqres.in/api/users/2"; //end point url or restapi
	
	 
	 //Sending Test Data to get created 
	/* JSONObject json=new JSONObject();
	 json.put("name","James Clark");
	 json.put("job","Software Engineer");*/
	 //---------------------------------------------
	
	 		RestAssured.baseURI=baseURI;
	 		Response response=RestAssured.given()
	 					.delete();
	 		
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getBody().asString());
	 		
	 		//Write a code for GET and vlidate the user should not there
	 		
	 		
	 	//	assertEquals(response.getStatusCode(), 200);
	 		
	}

}
