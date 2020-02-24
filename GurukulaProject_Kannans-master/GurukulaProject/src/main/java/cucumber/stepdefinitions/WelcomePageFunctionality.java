package cucumber.stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.org.managers.WebDriverManager;
 
import com.org.pages.WelcomePage;
import com.org.util.LoggerHelper;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class WelcomePageFunctionality  {
	public static WebDriver driver;

Logger logger=LoggerHelper.getLogger(WelcomePageFunctionality.class);
  

@Given("^The user launches the application$")
public void ApplicationLaunch(){
	driver=CommonPageStepDefinition.lanuchApplication();
   }	
 
@Then("^Welcome page should be displayed successfully$")
public void WelcomePageShouldbedispalyed() {
	WelcomePage welcomepage=new WelcomePage(driver);
	welcomepage.MainTitleVerficationCheck();
}

@Given("^user clicks on login link in Welcome page$")
public void user_clicks_on_login_link()   {
	WelcomePage welcomepage=new WelcomePage(driver);
	welcomepage.WelcomePageloginlinkClick();
}

@Then("^user should be able to navigate to login page$")
public void user_should_be_able_to_navigate_to_login_page(){
	WelcomePage welcomepage=new WelcomePage(driver);
	welcomepage.AuthenticationTitleCheck();
}

@Given("^in welcome screen user clicks on Authenticate link under Account menu$")
public void in_welcome_screen_user_clicks_on_Authenticate_link_under_Account_menu()   {
	WelcomePage welcomepage=new WelcomePage(driver);
	welcomepage.AuthenticateSubMenuClick();
}

@Given("^in welcome screen user clicks on Register link under Account menu$")
public void in_welcome_screen_user_clicks_on_Register_link_under_Account_menu() {
	WelcomePage welcomepage=new WelcomePage(driver);
	//welcomepage.RegisterSubMenuClick();
}

@Then("^user should be able to navigate to Registration page$")
public void user_should_be_able_to_navigate_to_Registration_page(){
	WelcomePage welcomepage=new WelcomePage(driver);
	welcomepage.RegistrationPageTitleCheck();
}

@Then("^user navigates to Welcome Screen by clicking Home link$")
public void user_navigates_to_Welcome_Screen_by_clicking_Home_link() {
	driver.findElement(By.xpath("//a[@class='navbar-brand']/img")).click();
}
 
@Given("^in welcome screen user clicks on Register a new Account link$")
public void in_welcome_screen_user_clicks_on_Register_a_new_Account_link() {
	WelcomePage welcomepage=new WelcomePage(driver);
	welcomepage.RegisterANewAccountlinkclick();
	}	   
 }