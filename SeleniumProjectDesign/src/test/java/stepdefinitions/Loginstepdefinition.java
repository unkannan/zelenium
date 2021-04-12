package stepdefinitions;

import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class  Loginstepdefinition {
	
	@Test
	public void runthistestusingmaven() {
		System.out.println("running test using maven test");
	}
	
	
	
	@Given("^the web application for the user$")
	public void the_web_application_for_the_user()  {
	   System.out.println("implmented");
	}
	

@Given("^navigates to the Amazon application$")
public void navigates_to_the_Amazon_application()   {
	System.out.println("implmented");
}

@When("^he navigates to the home page$")
public void he_navigates_to_the_home_page()  {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("implmented");
	
}

@When("^enters the username$")
public void enters_the_username()  {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("implmented");
}

@When("^enters the password$")
public void enters_the_password()  {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("implmented");
}

@When("^clicks Login button$")
public void clicks_Login_button()  {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("implmented");
}

@Then("^home page is opened$")
public void home_page_is_opened()  {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("implmented");
}

@Then("^user is able to login$")
public void user_is_able_to_login()  {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("implmented");
}

}
