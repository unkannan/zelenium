package com.org.testapi;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JasonResponsedataInArray {
	
	//@Test
	public void ValidateAllSearchResulrsUsingArray() throws ParseException {
		  
		//Step 1: Declaring end point
			String baseURI="https://reqres.in/api/users";

			
	 		RestAssured.baseURI=baseURI;
	 		
			//Step 2: Sending request and  getting response
	 		Response response=RestAssured.given().get();
	 		
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getStatusLine());
	 		System.out.println(response.getBody().asString());
	 		
	 		//Assertions to validate the data
	 		// validate whether the status is success
	 		assertEquals(response.getStatusCode(), 200);
	 		assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	 	
	 		String responseStr=response.getBody().asString();
	 		 
	 		//Jason Array
//Step 3: Parse the Jason response
	 		JSONParser parse = new JSONParser();
	 		JSONObject jobj = (JSONObject)parse.parse(responseStr);

//Step 4: Assigning the parsed jason data to array 
	 		JSONArray jsonarr_1 = (JSONArray) jobj.get("data"); 
	 		
	 		for(int i=0;i<6;i++)
	 		{
	 		//Store the JSON objects in an array
	 		//Get the index of the JSON object and print the values as per the index
	 		JSONObject jsonobj_1 = (JSONObject)jsonarr_1.get(i);
	 		System.out.println(jsonobj_1.get("id"));
	 		System.out.println(jsonobj_1.get("first_name"));
	 		System.out.println(jsonobj_1.get("last_name"));
	 		}
	}

	
	@Test
	public void ValidateAllSearchResulrsUsingArray1() throws ParseException {
		  String baseURI="https://reqres.in/api/users";
		  
	 		RestAssured.baseURI=baseURI;
	 		Response response=RestAssured.given().get();
	 		
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getStatusLine());
	 		System.out.println(response.getBody().asString());
	 		
	 		//Assertions to validate the data
	 		// validate whether the status is success
	 		assertEquals(response.getStatusCode(), 200);
	 		assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	 	
	 		String responseStr=response.getBody().asString();
	 		
	 		//Jason Array
	 		
	 		JsonPath js = response.jsonPath();
	 		
	 		List<String> AllRecords = js.get("data.email");
	 		 for(String name : AllRecords)
	 		 {
	 		 System.out.println("email: " + name);
	 		 
	 		 }
	}
}
