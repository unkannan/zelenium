package restapiautomation.restapiautomation;

 import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FunctionalTestingRestAPI {
	
	@BeforeMethod
	public void openURL() {
		System.out.println("open url");
		System.out.println("login and keep ready for tc execution");
	}
	//NO mAIN
	@Test
	public void GetEmployeeDetails_TC1() {
		 String baseURI="http://dummy.restapiexample.com/api/v1/employee/21";
			
			RestAssured.baseURI=baseURI;
			Response response=RestAssured.given().get();
			System.out.println(response.getStatusCode());
			System.out.println(response.getBody().asString());
		}
	
	@Test
	public void CreateEmployee_TC2() {
		//POST
				RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/create";
				Response resObj=RestAssured.given().body("{\"name\":\"raj\",\"salary\":\"10000\",\"age\":\"33\"}" + "").post();
				
				System.out.println(resObj.getStatusCode());
		 		System.out.println(resObj.getBody().asString());
	}
	}
 