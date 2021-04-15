

import static org.testng.Assert.assertEquals;

import org.json.JSONObject;
import org.testng.annotations.Test;
 
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestApiGetMethod {

	//@Test
	public void GetUsersData() {
		  String baseURI="https://reqres.in/api/users?page=2";
		  
	 		RestAssured.baseURI=baseURI;
	 		Response response=RestAssured.given().get();
	 		
	 		
	 		try {
	 			System.out.println(response.getStatusCode());
	 		}
	 		catch(Exception e)
	 		{
	 		   System.out.println("Not able to get the status");	
	 		}
	 		
	 		System.out.println(response.getStatusLine());
	 		System.out.println(response.getBody().asString());
	 		
	 		//Assertions to validate the data
	 		// validate whether the status is success
	 		assertEquals(response.getStatusCode(), 200);
	 		assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	}
	
	//@Test
	public void GetSingleUser() {
		   RestAssured.baseURI="https://reqres.in/api/users/2";
		   
	 		Response response=RestAssured.given().get();   
	 		   																																			 
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getStatusLine());
	 		System.out.println(response.getBody().asString());
	 		
	 		//Assertions to validate the data
	 		// validate whether the status is success
	 		assertEquals(response.getStatusCode(), 200);
	 		assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	}
	
	@Test
	public void ValidateJasonForGetSingleUser() {
		   RestAssured.baseURI="https://reqres.in/api/users/2";
	 		Response response=RestAssured.given().get();   
	 		   																																			 
	 		
	 		
		 	JsonPath js = response.jsonPath();
		 	System.out.println(response.getBody().asString());
		 	System.out.println(js.get("data.first_name"));
		 	System.out.println(js.get("data.last_name"));
		 	System.out.println(js.get("data.email"));
		 	System.out.println(js.get("data111"));
		 	
		 	String ActulFirstNameResults=js.get("data.first_name");
		 	assertEquals(ActulFirstNameResults,"Janet");
		 	
		 	//Assertions to validate the data
	 		// validate whether the status is success
	 		assertEquals(response.getStatusCode(), 200);
	 		assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
	}
	
	//@Test
		public void ValidateJasonForGetSingleUser1() {
			   RestAssured.baseURI="https://api.github.com/users/Haja49";
			   
		 		Response response=RestAssured
		 							.given()
		 							.header("key", "0123456789012345678901234ab")
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
		
	
	//Validating the whether the user is created
	//@Test
	 public void ValidateResponseForCreatedUser()
	 {
		 String baseURI="https://reqres.in/api/users";
		 
		 JSONObject json=new JSONObject();
		 json.put("name","morpheus");
		 json.put("job","leader");
		
		 		RestAssured.baseURI=baseURI;
		 		Response response=RestAssured.given()
		 					.contentType("application/json")
		 					.body(json.toString())
		 					.post();
		 		System.out.println(response.getStatusCode());
		 		System.out.println(response.getBody().asString());
		 		 
		 		 JSONObject jsonResponseResult=new JSONObject(response.getBody().asString()); 
		 		System.out.println(jsonResponseResult.get("name"));
	 }
	
//@Test
public void GetRequestLive()
{
	 		RestAssured.baseURI="https://dummyapi.io/data/api/user?limit=10";
	 		
			 Response response=RestAssured.given()
					 .headers("app-id","605fcae2cc522f80083fccc4")
	 					.get();
	 		
			 System.out.println(response.getStatusCode());
		 		System.out.println(response.getBody().asString());
}

}
 
