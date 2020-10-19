package RestAPIValidation;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

import io.restassured.response.Response;

public class RestAPIValidationcls {
	
@Test
public void getCount(){
	RestAssured.baseURI="https://spor.azure-api.net/sms/api/v2/SubstanceDefinition?&";
	 RequestSpecification httpRequest = RestAssured.given();
	 
	 httpRequest.header("Ocp-Apim-Subscription-Key", "a16868e8d2d84cf69b530271ed1378af");
	 httpRequest.header("Accept", "*/*");
	 httpRequest.header("Accept-Encoding", "gzip, deflate, br");
	httpRequest.header("Connection", "keep-alive");
	 
	 httpRequest.param("_summary", "count");
	//Makes calls to the server using Method type.
	 Response response1 = RestAssured.get(RestAssured.baseURI);
     
   //Checks the Status Code
     int statusCode = response1.getStatusCode();
     System.out.println(response1.getStatusCode());
     System.out.println(response1.contentType());
     System.out.println(response1.body().toString());
     Assert.assertEquals(statusCode, 200);
}

}
