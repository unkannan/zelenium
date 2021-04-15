package stepdefinitions;

import static org.testng.Assert.assertEquals;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestAPIFeaturefile{
	
	static Response response=null;
	static String basePath=null;
	
	@Given("^I want to execute getUsersList endpoint$")
	public void i_want_to_execute_getUsersList_endpoint() throws Throwable {
		System.out.println("End Point id declared");
		basePath="/users?page=2";
		RestAssured.basePath=basePath;
	}

	@When("^I submit the GET request$")
	public void i_submit_the_GET_request() throws Throwable {
		response=RestAssured.given().get();
		System.out.println("Request is sent");
	}

	@Then("^I should get (\\d+) sucess Status code$")
	public void i_should_get_sucess_Status_code(int arg1) throws Throwable {
		System.out.println("Resonse GetStatusCode:"+response.getStatusCode());
		assertEquals(response.getStatusCode(), 200);
	}
	

@Given("^I want to execute SingleUser endpoint$")
public void i_want_to_execute_SingleUser_endpoint() throws Throwable {
   System.out.println("checking for dummy");
	System.out.println("New test step for connecting single user");
	basePath="/users?page=2";
	RestAssured.basePath=basePath;
}

@When("^I submit the GET request for single user$")
public void i_submit_the_GET_request_for_single_user() throws Throwable {
	response=RestAssured.given().get();
	System.out.println("Request is sent");
}

@Then("^I should get Success statusCodeLine$")
public void i_should_get_Success_statusCodeLine() throws Throwable {
	System.out.println("Resonse GetStatusCode:"+response.getStatusLine());
}

@Then("^I should get the Janet User details$")
public void i_should_get_the_Janet_User_details() throws Throwable {
    System.out.println("Janet is shown");
}

}
