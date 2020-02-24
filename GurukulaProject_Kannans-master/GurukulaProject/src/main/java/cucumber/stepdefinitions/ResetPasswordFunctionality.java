package cucumber.stepdefinitions;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.org.pages.LoginPage;
import com.org.pages.ResetPasswordPage;
import com.org.util.LoggerHelper;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ResetPasswordFunctionality {
	public static WebDriver driver;
	Logger logger=LoggerHelper.getLogger(ResetPasswordFunctionality.class);
  
	@Given("^A user launches application and navigates to Reset Password page through Forgot Password link$")
	public void ApplicationLaunchNaviageResetPasswordPage() { 
		driver=CommonPageStepDefinition.lanuchApplication();
		LoginPage login=new LoginPage(driver);
		login.ApplicationLaunchLoginButtonClick();
		 ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
		 	resetPassword.ForgotPasswordlinkClick();
			resetPassword.ResetPasswordPageVerification();	 
	   }
	
	@Then("^verify that user is able to navigate to ResetPasswordpage$")
	public void ResetPasswordPageTitleVerification() {
		ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
		resetPassword.ResetPasswordPageVerification();
	}
	
	@Then("^user provides a unregistered and invalid emailid <Emailid> and verify proper error message is shown$")
	public void InvalidEmailIdverification(DataTable testdata) throws Throwable {
		List<List<String>> data = testdata.raw();
		ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
		for(int i=1;i<data.size();i++) {
	     resetPassword.InvalidEmailIdverification(data.get(i).get(0));
		}
	}
 
	@When("^user provides a valid registered email id \"([^\"]*)\"$")
	public void RegisteredEmailIDverification(String arg1) throws Throwable {
		ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
		 resetPassword.validEmailIdverification(arg1);
	}

	@Then("^user provides emailid without @ symbol in <Emailid> and verify proper error message is shown$")
	public void InvalidEmailidWithoutSymbol(DataTable testdata) throws Throwable {
		List<List<String>> data = testdata.raw();
		ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
		for(int i=1;i<data.size();i++) 
	     resetPassword.InvalidEmailidWithoutSymbol(data.get(i).get(0));
	}
	
	@Then("^user provides emailid with less than five chars in <Emailid> and verify proper error message is shown$")
	public void InvalidEmailidwithlessthanFivechars(DataTable testdata) throws Throwable {
		List<List<String>> data = testdata.raw();
		ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
		for(int i=1;i<data.size();i++) 
	     resetPassword.InvalidEmailid5CharsCheck(data.get(i).get(0));
	}
	@Then("^user provides emailid with more than fifty chars in <Emailid> and verify proper error message is shown$")
	public void InvalidEmailidwithmorethanfiftychars(DataTable testdata) throws Throwable {
		List<List<String>> data = testdata.raw();
		ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
		for(int i=1;i<data.size();i++) 
	     resetPassword.InvalidEmailidwith50CharsValidation(data.get(i).get(0));
	}

	@Then("^user provides no emailid and verify proper error message is shown$")
	public void user_provides_no_emailid_and_verify_proper_error_message_is_shown()   {
		ResetPasswordPage resetPassword=new ResetPasswordPage(driver);
	     resetPassword.NoEmailidVerificationWarningMessage();
	}
}
