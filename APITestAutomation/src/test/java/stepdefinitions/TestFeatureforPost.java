package stepdefinitions;

import org.json.JSONObject;

import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TestFeatureforPost {
	
	static Response response=null;
	static String basePath=null;
	
	@Given("^the endpoint URl$")
	public void the_endpoint_URl() throws Throwable {
		basePath="/v1/create";
		RestAssured.basePath=basePath; 
	}

	@When("^I send a post request$")
	public void i_send_a_post_request() throws Throwable {
		 JSONObject json=new JSONObject();
		 json.put("name","Anuradha");
		 json.put("job","Software Test Lead");
		 
		 response=RestAssured.given()
					.contentType("application/json")
					.body(json.toString())
					.post();
	}


	@Then("^verify the new user is created$")
	public void verify_the_new_user_is_created() throws Throwable {
		JsonPath js=response.jsonPath();
 		System.out.println(js.get("name"));
 		System.out.println(js.get("job"));
 		System.out.println(js.get("id"));
 		System.out.println(js.get("createdAt"));
	}

	@Then("^status code should be success$")
	public void status_code_should_be_success() throws Throwable {
		System.out.println(response.getStatusCode());
 		System.out.println(response.getBody().asString());
	}


}
