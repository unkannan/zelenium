package com.org.testapi;

import static org.testng.Assert.assertEquals;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class AuthorizedUserCheckTestCase {
	       
	          // @Test
			 public void unauthorizedRequestSent() {
				 String uri="https://dummyapi.io/data/api/user/0F8JIqi4zwvb77FGz6Wt";
				 
				 RestAssured.baseURI=uri;
				 Response res=RestAssured.given().get();
				 
				 System.out.println(res.getStatusCode());
			 		System.out.println(res.getBody().asString());
			 		assertEquals(res.getStatusCode(), 403);
			 }
			
			 // @Test
			 public void Valid_authorizedRequestSent() {
				 String uri="https://dummyapi.io/data/api/user/0F8JIqi4zwvb77FGz6Wt";
				 
				 RestAssured.baseURI=uri;
				 Response res=RestAssured
						 		.given()
						 		.header("app-id","605fcae2cc522f80083fccc4")
						 		.get();
				 
				 System.out.println(res.getStatusCode());
			 		System.out.println(res.getBody().asString());
			 		assertEquals(res.getStatusCode(), 200);
			 }

			 
			 
			 
}
