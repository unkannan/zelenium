package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.json.JSONObject;


import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestingPostFeature {
	
	static Response response=null;
	static String basePath=null;
	
@Given("^I want to execute createSingletUsersList endpoint$")
public void i_want_to_execute_createSingletUsersList_endpoint() throws Throwable {
	System.out.println("End Point id for Post request is declared");
	basePath="/v1/create";
	RestAssured.basePath=basePath;
}

@When("^I submit the POST request for create single user$")
public void i_submit_the_POST_request_for_create_single_user() throws Throwable {
	
	//Sending Test Data to get created 
	 JSONObject json=new JSONObject();
	 json.put("name","Rajshekar");
	 json.put("job","Software Engineer");
	 
	response=RestAssured.given()
				.contentType("application/json")
				.body(json.toString())
				.post();
	System.out.println("Request is sent");
}

@Then("^I should get (\\d+) sucess status code along with resonse body$")
public void i_should_get_sucess_status_code_along_with_resonse_body(int arg1) throws Throwable {
	System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
		assertEquals(response.getStatusCode(), 201);
}



@Given("^a endpoint$")
public void aEndPoint() throws Throwable {
	System.out.println("a endpoint is called");
}

@When("^I submit a request for <username> and <password>$")
public void SubmittingUsernamePassword(DataTable testdata) throws Throwable {
	List<String> login=testdata.asList(String.class);
	 
	 System.out.println(login.get(0)+login.get(1));
}

@Given("^my url$")
public void my_url() throws Throwable {
	System.out.println("My url method is called");
}

@When("^I submit a request for \"([^\"]*)\" and \"([^\"]*)\"$")
public void i_submit_a_request_for_and(String arg1, String arg2, DataTable testdata) throws Throwable {
	List<String> login=testdata.asList(String.class);
	for(int i=0;i<6;i++) {
		System.out.println(login.get(i));
	}
	// System.out.println(login.get(0)+login.get(1));
}


}
