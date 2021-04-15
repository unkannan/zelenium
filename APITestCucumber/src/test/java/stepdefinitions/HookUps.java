package stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;

public class HookUps {
	
	
	@Before
	public void InitializeEndPoint() {
		System.out.println("Feature Test is in progress");
		System.out.println("***************************************");
		System.out.println("Before HookUp is called");
		RestAssured.baseURI="https://reqres.in/api";
		
	}
	
	@Before("@smoke")
	public void beforeSmokeTest() {
		System.out.println("This is before smoke");
		
	}
	
	@After
	public void TestCLose() {
		System.out.println("Test case is executed succesfully");
		System.out.println("***************************************\n\n\n\n\n\n");
		
	}

}
