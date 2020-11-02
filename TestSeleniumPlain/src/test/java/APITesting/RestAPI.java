package APITesting;

import java.util.HashMap;

import org.apache.xmlbeans.XmlObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class RestAPI {
	
	
    
	 private String text;

	//@Test
	 public void GetStatusCodeForGoogleCOM()
	 {
		 String baseURI="http://www.google.com";
		 		
		 		Response response=RestAssured.get(baseURI);
		 		System.out.println(response.getStatusCode());
		 		System.out.println(response.getBody().asString());
	 }
	//@Test
	public void GetEmployeeData() {
		 String baseURI="http://dummy.restapiexample.com/api/v1/employee/21";
	 		
	 		RestAssured.baseURI=baseURI;
	 		Response response=RestAssured.given().get();
	 		
	 		System.out.println(response.getStatusCode());
	 		System.out.println(response.getBody().asString());
	}
	//@Test
		 public void PostRequestRestAssured()
		 {
			 String baseURI="http://dummy.restapiexample.com/api/v1/create";
			 		
			 		RestAssured.baseURI=baseURI;
			 		Response response=RestAssured.given().body("{\"name\":\"name_001\",\"salary\":\"53001\",\"age\":\"23\"}" + "").post();
			 		System.out.println(response.getStatusCode());
			 		System.out.println(response.getBody().asString());
		 }
		 
	
	// @Test
	 public void UpdateRequestForRecord() {
		 String  baseURI="http://dummy.restapiexample.com/api/v1/update/21";
		 
		 RestAssured.baseURI=baseURI;
		 Response response=RestAssured.given().body("{\"name\":\"name_001\",\"salary\":\"53001\",\"age\":\"23\"}" + "").put();
		 
		 System.out.println(response.getStatusCode());
		 System.out.println(response.getBody().asString());
	 }
	 
	// @Test
	 public void DeleteRequestForRecord() {
		 String  baseURI="http://dummy.restapiexample.com/api/v1/delete/21";
		 
		 RestAssured.baseURI=baseURI;
		 Response response=RestAssured.given().delete();
		 
		 System.out.println(response.getStatusCode());
		 System.out.println(response.getBody().asString());
	 }
	 
<<<<<<< HEAD
	 // Get the RequestSpecification of the request that you want to sent
	 // to the server. The server is specified by the BaseURI that we have
	 // specified in the above step.
	 RequestSpecification httpRequest = RestAssured.given();
	 httpRequest.header("Content-Type", "application/xml;charset=UTF-8");
	 		XmlObject requestParams=(XmlObject) new XmlPath(text);
	 httpRequest.body(requestParams.toString());

=======
	 //------------------------------------------------------------------------------------------------------------------------
	 //@Test
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
>>>>>>> adfbf84d77190a22dcd4990f1e37fb68781bf2b7
	 
	 
	 
	 //@Test
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
