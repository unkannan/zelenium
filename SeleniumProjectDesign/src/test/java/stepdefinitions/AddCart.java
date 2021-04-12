package stepdefinitions;

import org.junit.Test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddCart {

@Test
public void runthistestusingmaven() {
	System.out.println("running test using maven test");
}
	
@Given("^the application of Flipkart$")
public void the_application_of_Flipkart() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("the application of Flipkart");
}

@When("^click Add Cart$")
public void click_Add_Cart() throws Throwable {
    System.out.println("click Add Cart");
}

@When("^Add the product$")
public void add_the_product() throws Throwable {
	System.out.println("Add the product");
}

@Then("^the product is added to cart$")
public void the_product_is_added_to_cart() throws Throwable {
	System.out.println("the product is added to cart");
}



}
