package restapiautomation.restapiautomation;

import io.restassured.RestAssured;
import io.restassured.response.*;

public class RestAPITest {
	public static void main(String args[]) {
		//String baseURI="http://dummy.restapiexample.com/api/v1/employee/21";
 	
	RestAssured.baseURI="https://reqres.in/api/users?page=2";
	Response resObj=null;
	int flag=0;
	try {
 	resObj=RestAssured.given().get();
	}catch(Exception e) 
	{
		System.out.println("test case failed with error");
		flag=1;
		}
	if(flag==0) {
 	System.out.println(resObj.getStatusCode());
 	int status=resObj.getStatusCode();
 	
 	if(status==200) 
 		System.out.println("my test cases passed");
 		else 
 		System.out.println("test case failed");
 	
 	
 	System.out.println(resObj.getBody().asString());
 	
 	
 	
 	 String baseURI="http://dummy.restapiexample.com/api/v1/employee/21";
		
		RestAssured.baseURI=baseURI;
		Response response=RestAssured.given().get();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
	}
	}
}
