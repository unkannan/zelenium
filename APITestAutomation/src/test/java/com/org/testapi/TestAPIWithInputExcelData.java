package com.org.testapi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.org.util.ExcelReader;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestAPIWithInputExcelData {
	
	@Test
	public void ValidateJasonForGetSingleUser1() {
		
		ExcelReader xl=new ExcelReader();
		
		
		String xlFIle="resources/APIInputExcelTestData.xlsx";
		   String baseURI=xl.getcellvalueUsingIndex(xlFIle, 0, 1, 0);
		   String keyAuth=xl.getcellvalueUsingIndex(xlFIle, 0, 1, 1);
		
		   
		   System.out.println(baseURI);
		   System.out.println(keyAuth);
	//	   RestAssured.baseURI="https://api.github.com/users/Haja49";
		   RestAssured.baseURI=baseURI;
		   
	 		Response response=RestAssured
	 							.given()
	 							.header("key", keyAuth)
	 							.get();   
	 		   																																			 
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getStatusLine());
	 		System.out.println(response.getBody().asString());
	 		
	 		//Assertions to validate the data
	 		// validate whether the status is success
	 		assertEquals(response.getStatusCode(), 200);
	 		assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	 		
	 		 
		 	JsonPath js = response.jsonPath();
		 	System.out.println("id " + js.get("id"));
		 	System.out.println("name " + js.get("login"));
	}
	
	 

}
		