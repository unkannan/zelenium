package APITesting;

import org.apache.xmlbeans.XmlObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
	 
	// @Test
	 public void PostRestAPItest1()
	 {   
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = "http://phvparser-test.emea.eu.int/vetadr/resources/validate";
	 
	 // Get the RequestSpecification of the request that you want to sent
	 // to the server. The server is specified by the BaseURI that we have
	 // specified in the above step.
	 RequestSpecification httpRequest = RestAssured.given();
	 httpRequest.header("Content-Type", "application/xml;charset=UTF-8");
	 XmlObject requestParams=(XmlObject) new XmlPath(text);
	 httpRequest.body(requestParams.toString());

	 
	 // Make a request to the server by specifying the method Type and the method URL.
	 // This will return the Response from the server. Store the response in a variable.
	 Response response = httpRequest.request(Method.POST, "/feed.json");
	 
	 
	 // Now let us print the body of the message to see what response
	 // we have recieved from the server
	// String responseBody = response.getBody().asString();
	// System.out.println("Response Body is =>  " + responseBody);
		 int responseBody = response.getStatusCode();
		 System.out.println("Response Body is =>  " + responseBody);
		 
		 System.out.println(response.asString());
	 }

}
