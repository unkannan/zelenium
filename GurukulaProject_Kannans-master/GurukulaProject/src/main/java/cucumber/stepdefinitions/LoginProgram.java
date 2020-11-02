package cucumber.stepdefinitions;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.org.pages.LoginPage;
import com.org.pages.RegistrationPage;
import com.org.pages.ResetPasswordPage;
import com.org.pages.WelcomePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.org.util.LoggerHelper;

public class LoginProgram {
	public static WebDriver driver;
	Logger logger=LoggerHelper.getLogger(LoginProgram.class);
	
@Given("^A user launch the Gurukul application$")
public void LanucheApplication() {
	driver=CommonPageStepDefinition.lanuchApplication();
   }
@Given("^User logs in by clicking Login button$")
public void LoginButtonClick() throws Throwable {
	LoginPage loginpage=new LoginPage(driver);
	loginpage.ApplicationLaunchLoginButtonClick();
}
@Then("^User should not be able to login with invalid credentials <username> and <password>$")
public void Login_InvalidCredentials(DataTable testdata) throws Throwable {
	LoginPage loginpage=new LoginPage(driver);
	List<List<String>> data = testdata.raw();
	for(int i=1;i<5;i++) {
		logger.info("Invalid Credentials provided and Login should fail");
		loginpage.LoginIntoGuruKulPage(data.get(i).get(0),data.get(i).get(1));
		loginpage.clearLogintext();
	}
}
@Then("^User should be able to login successfully with valid credentials <username> and <password>$")
public void Login_ValidCredentials(DataTable testdata) {
	List<String> login=testdata.asList(String.class);
	LoginPage loginpage=new LoginPage(driver);
	loginpage.LoginIntoGuruKulPage(login.get(0),login.get(1));
	WelcomePage welcomepage=new WelcomePage(driver);
	welcomepage.MainTitleVerficationCheck();
}
@Then("^User should be able to navigate to Reset Password page by clicking Forgot Password link$")
public void CickForgotPassword(){
     ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
     resetPassword.ForgotPasswordlinkClick();
}
  
@Then("^User clicking on Register new account link should navigate to register new user page$")
public void User_clicking_Register_new_account_link_navigate_register_user_page()   {
	 RegistrationPage registrationPage=new RegistrationPage(driver);
	 registrationPage.RegisterNewAccountClick();
}

@Then("^user logout button should successfully logout from the application$")
public void LogoutButtonClick() {
	LoginPage loginpage=new LoginPage(driver);
	loginpage.Logout();
}

@Then("^clicking Gurukula logo link navigates to Home page$")
public void GurukulaLogolinkClick() {
	LoginPage loginpage=new LoginPage(driver);
	loginpage.GurukulaLogoclick();
}

@Then("^clicking Home link navigates to Home page$")
public void HomeLinkClick() {
	LoginPage loginpage=new LoginPage(driver);
	loginpage.GurukulaHomeLinkClick();
}

@Then("^uncheck the remember me checkbox in login page$")
public void RememberMeCheckBoxValidation() {
	LoginPage loginpage=new LoginPage(driver);
	loginpage.rememberMecheckboxClick();
}
@Then("^after Reopen the browser should see the user remain login$")
public void ReopenBrowser() throws Throwable {
	driver.get("http://127.0.0.1:8080/#/");
}
 }