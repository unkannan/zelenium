package APITesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;  // Do do an automation for Rest API
import io.restassured.response.Response;
import org.json.JSONObject;

public class RestAPI {
	
	
    
	 private String text;

	@Test
	 public void GetStatusCodeForGoogleCOM()
	 {
		 String baseURI="http://www.google.com";
		 		
		 		Response response=RestAssured.get(baseURI);
		 		
		 		
		 		System.out.println(response.getStatusCode());
		 		System.out.println(response.getBody().asString());
	 }
	// create a customer
	// customer is created  - customer id will be given as the response
	// validation on the output of that rest api request
	
	
	
	
	@Test
	public void GetEmployeeData() {
		 String baseURI="http://dummy.restapiexample.com/api/v1/employee/21";
	 		
	 		RestAssured.baseURI=baseURI;
	 		Response response=RestAssured.given().get();
	 		
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getBody().asString());
	}
	@Test
		 public void PostRequestRestAssured()
		 {
			 String baseURI="http://dummy.restapiexample.com/api/v1/create";
			 		
			 		RestAssured.baseURI=baseURI;
			 		Response response=RestAssured.given().body("{\"name\":\"name_001\",\"salary\":\"53001\",\"age\":\"23\"}" + "").post();
			 		System.out.println(response.getStatusCode());
			 		System.out.println(response.getBody().asString());
		 }
		 
	
	 @Test
	 public void UpdateRequestForRecord() {
		 String  baseURI="http://dummy.restapiexample.com/api/v1/update/21";
		 
		 RestAssured.baseURI=baseURI;
		 Response response=RestAssured.given().body("{\"name\":\"name_001\",\"salary\":\"53001\",\"age\":\"23\"}" + "").put();
		 
		 System.out.println(response.getStatusCode());
		 System.out.println(response.getBody().asString());
	 }
	 
	 @Test
	 public void DeleteRequestForRecord() {
		 String  baseURI="http://dummy.restapiexample.com/api/v1/delete/21";
		 
		 RestAssured.baseURI=baseURI;
		 Response response=RestAssured.given().delete();
		 
		 System.out.println(response.getStatusCode());
		 System.out.println(response.getBody().asString());
	 }
	 
	 //------------------------------------------------------------------------------------------------------------------------
	 @Test
	 public void GetWhetherDetailsCity()
	 {
		 String  baseURI="https://maps.googleapis.com";
		 
		 RestAssured.baseURI=baseURI;
		 RestAssured.basePath="/maps/api";
		 
		 Response response=RestAssured.given().param("origins", "Boston,MA")
				 			.param("destinations","Lexington,MA")
				 			.param("key")
				 			.when()
				 				.get("/distancematrix/json");
		 
		 System.out.println(response.getStatusCode());
		 System.out.println(response.body().prettyPrint());
	 }
	 
	 
	 
	 @Test
	 public void ReqresURL_GetSingleUser()
	 {
		 String baseURI="https://reqres.in/api/users/2";
		 		
		
		 		RestAssured.baseURI=baseURI;
		 		Response response=RestAssured.given()
		 					.contentType("application/json")
		 					.get();
		 		System.out.println(response.getStatusCode());
		 		System.out.println(response.getBody().asString());
	 }
	 
	 @SuppressWarnings("unchecked")
	@Test
	 public void ReqresURL_CreateUserPost()
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
	 
	 

}
