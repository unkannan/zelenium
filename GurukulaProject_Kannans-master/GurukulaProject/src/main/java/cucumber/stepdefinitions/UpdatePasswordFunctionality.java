package cucumber.stepdefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.pages.LoginPage;
import com.org.pages.UpdatePasswordPage;
import com.org.pages.WelcomePage;
import com.org.util.LoggerHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UpdatePasswordFunctionality  {

	public static WebDriver driver;
	Logger logger=LoggerHelper.getLogger(UpdatePasswordFunctionality.class);
	
	@Given("^A user launches application logs in successfully with valid credentials$")
	public void a_user_launches_application_logs_in_successfully() {  
		driver=CommonPageStepDefinition.lanuchApplication();
		 LoginPage loginpage=new LoginPage(driver);
		 loginpage.ApplicationLaunchLoginButtonClick();
		 loginpage.LoginIntoGuruKulPage("admin","admin");
	}

	@Given("^clicking Password submenu under Account Menu options and navigates to update password page$")
	public void clicking_Password_submenu_under_Account_Menu_options()  {
		WelcomePage welcomepage=new WelcomePage(driver);
		welcomepage.PasswordSubMenuClick();
	}

	@Given("^user should be able to navigate to Update Password page$")
	public void user_should_be_able_to_navigate_to_Update_Password_page() { 
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.UpdatePasswordPageTitleValidation();
	}
   
	@Given("^User provides the New Password and New Password Confirmation$")
	public void user_provides_the_New_Password_and_New_Password_Confirmation() {
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.ValidPasswordCredentials("admin", "admin");
	}
	@Then("^clicking save password should get updated successfully$")
	public void clicking_save_password_should_get_updated_successfully(){
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.PasswordChangeVerfication();
	}
	@Given("^user provides less than five chars as \"([^\"]*)\" in the New Password text field$")
	public void user_provides_less_than_five_chars_in_the_New_Password_text_field(String testdata)  {
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.PasswordEntry(testdata);
	}
	@Then("^Verify that Error message is shown up stating enter more than five chars for Password field$")
	public void verify_that_Error_message_is_shown_up_stating_enter_more_than_five_charsinPasswordField() throws Throwable {
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.FiveCharsWarningMessageValidation("password");
	}
	@Given("^user provides less than five chars as \"([^\"]*)\" in the Confirm Password text field$")
	public void user_provides_less_than_five_chars_in_the_Confirm_Password_text_field(String testdata) {
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.ConfirmPasswordEntry(testdata);
	}
	@Then("^Verify that Error message is shown up stating enter more than five chars for Confirm Password field$")
	public void verify_that_Error_message_is_shown_up_stating_enter_more_than_five_chars()  {
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.FiveCharsWarningMessageValidation("confirmPasword");
	}
 
	@Then("^Verify that Error message if data is not provided in password field$")
	public void verify_that_Error_message_is_shown_up_stating_Your_password_is_required_if_password_is_not_provided(){
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.NoEmailidVerificationWarningMessage("password");
	}
	
	@Then("^Verify that Error message if data is not provided in confirm password field$")
	public void verify_that_Error_message_if_data_is_not_provided_in_confirm_password_field(){
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.NoEmailidVerificationWarningMessage("confirmpassword");
	}
	@Given("^user provides text \"([^\"]*)\" in new password and \"([^\"]*)\" in Confirm Password text field which are not matching$")
	public void user_provides_text_in_new_password_and_in_Confirm_Password_text_field_which_are_not_matching(String arg1, String arg2){
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.PasswordEntry(arg1);
		updatePasswordPage.ConfirmPasswordEntry(arg2);
		updatePasswordPage.submitClick();
	}
	@Then("^Verify that Error message is shown up if new password and confirm password not matching$")
	public void verify_that_Error_message_is_shown_up_if_new_password_and_confirm_password_not_matching(){
		UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
		updatePasswordPage.NoMatchingPassword();
	}
@Given("^user provides different password text for complexity check and seen that password Strength is shown up$")
public void user_provides_different_password_text_for_complexity_check_and_seen_that_password_Strength_is_shown_up(){
	UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
	updatePasswordPage.PasswordStrengthCheck("Kannan", "Kannan@","Kannan@112");
}
@Given("^user provides more than fifty chars length in the New Password text field$")
public void user_provides_more_than_fifty_chars_length_in_the_New_Password_text_field(){
	UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
	updatePasswordPage.FiftyCharsLenthValidation("password");
}

@Given("^user provides more than fifty chars length in the confirm Password text field$")
public void user_provides_more_than_fifty_chars_length_in_the_confirm_Password_text_field(){
	UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
	updatePasswordPage.FiftyCharsLenthValidation("ConfirmPassword");
}

@Then("^Verify that Error message is shown up stating cannot be more than fifty chars for Password field$")
public void verify_that_Error_message_is_shown_up_stating_cannot_be_more_than_fifty_chars_for_Password_field() throws Throwable {
	UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
	updatePasswordPage.FiftyCharsLenthValidation("password");
     
}
@Then("^Verify that Error message is shown up stating cannot be more than fifty chars for confirm Password field$")
public void verify_that_Error_message_is_shown_up_stating_cannot_be_more_than_fifty_chars_for_confirm_Password_field() throws Throwable {
	UpdatePasswordPage updatePasswordPage=new UpdatePasswordPage(driver);
	updatePasswordPage.FiftyCharsLenthValidation("confirmpassword");
    
}
}
 
