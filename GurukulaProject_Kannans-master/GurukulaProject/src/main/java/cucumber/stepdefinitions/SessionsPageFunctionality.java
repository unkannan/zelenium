package cucumber.stepdefinitions;

import org.apache.log4j.Logger;
import org.junit.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import com.org.managers.WebDriverManager;
import com.org.pages.LoginPage;
import com.org.pages.SessionsPage;
import com.org.util.Log;
import com.org.util.LoggerHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SessionsPageFunctionality {

	public static WebDriver driver;
	Logger logger=LoggerHelper.getLogger(SessionsPageFunctionality.class);
	
	@Given("^Sessions_FunctionalityCheck_Feature_user login into the Gurukul application$")
	public void LaunchApplication_Login() {
		driver=CommonPageStepDefinition.lanuchApplication();
		 LoginPage loginpage=new LoginPage(driver);
		 loginpage.ApplicationLaunchLoginButtonClick();
		 loginpage.LogindefaultUserDetails();
	}

	@When("^user navigates navigate to the sessions page through Account > Sessions menu$")
	public void SessionsPageNavigation(){
		SessionsPage sessionpage=new SessionsPage(driver);
		sessionpage.NaviateToSessionPage();
	}

	@Then("^user should be able to navigate and see the sessions page$")
	public void SessionPageTitleVerification(){
		SessionsPage sessionpage=new SessionsPage(driver);
		sessionpage.SessionPageTitleVaidation();
	}
	@Given("^User should be able to invalidate the sessions$")
	public void InvalidateSession() {
		SessionsPage sessionpage=new SessionsPage(driver);
		sessionpage.InvalidateSession();
	}

	@Then("^Valid message should be shown stating the session is invalidated$")
	public void InvalidateSessionTextVerification(){
		SessionsPage sessionpage=new SessionsPage(driver);
		sessionpage.InvalidatedSessionPageTitleVerfication();
	}
}
 
