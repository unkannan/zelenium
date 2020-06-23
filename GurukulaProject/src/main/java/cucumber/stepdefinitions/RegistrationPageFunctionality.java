package cucumber.stepdefinitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.org.pages.RegistrationPage;
import com.org.pages.WelcomePage;
import com.org.util.LoggerHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegistrationPageFunctionality {
	public static WebDriver driver;

Logger logger=LoggerHelper.getLogger(RegistrationPageFunctionality.class);
private static final String FiftyCharsCheck="50chars";
private static final String specialCharsCheck="specialCharsCheck";
private static final String NoTextEntry="NoTextEntry";
private static final String MinCharCheck="MinCharCheck";

@Given("^Registration_Feature_User launches the application$")
public void LaunchApplication() throws Throwable {
	driver=CommonPageStepDefinition.lanuchApplication();
}

@Given("^user navigates to Registration details page by clicking Register a new Account link in welcome screen$")
public void NavigatetoRegistrationDetailsPage(){
	 WelcomePage welcomepage=new WelcomePage(driver);
		welcomepage.RegisterANewAccountlinkclick(); 
   }	
  
@Then("^user provides the Registration details$")
public void RegistrationDetailsWithUsername() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.EnterUsername("kan");
	registrationPage.EnterEmail("add2kannan@yahoo.com"); 
	registrationPage.Enterpassword("password");
	registrationPage.EnterconfirmPassword("password");
	
}
   
@Then("^Clicking Register button$")
public void clicking_Register_button() {
	 driver.findElement(By.xpath("//button[text()='Register']")).click();
}

@When("^user provides the Registration details as <username> ,<Email>, <password>, <ConfirmPassword>$")
public void TextFieldInputforRegistration(DataTable testdata) {
	List<String> login=testdata.asList(String.class);
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.EnterRegistrationDetails(login.get(0),login.get(1),login.get(2),login.get(3));
}
@Then("^User should not be able to register as it is an existing user$")
public void ExistingUserCheckForRegistration() throws InterruptedException {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	Thread.sleep(3000);
	registrationPage.RegistrationValidationMessage("ExistingUser");
}

@Then("^user should be successfully able to register$")
public void RegisterwithValidUser() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.RegistrationValidationMessage("Success");
}
@Given("^mandatory field check for Login text field if login is not provided$")
public void LoginTextFieldMandatoryCheck(){
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.LoginFieldfieldValidation("NoTextEntry");
}

@Given("^Max chars length check for Login text field if more than fifty chars entered$")
public void MaxCharsLengthCheckLoginText(){
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.LoginFieldfieldValidation(FiftyCharsCheck);	
}

@Given("^lower-case letters and digits check for Login text field if special chars entered$")
public void LowerCase_Digits_SpecialcharsInputLoginText(){
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.LoginFieldfieldValidation(specialCharsCheck);	
}
 
@Given("^mandatory field check for Password text field if text is not entered$")
public void MandatoryFieldVerification_Password() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.PasswordFieldfieldValidation(NoTextEntry);	
}

@Given("^Min chars length check for Password text field if text is less than five chars$")
public void MinCharsLenCheck_Password() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.PasswordFieldfieldValidation(MinCharCheck);	
}

@Given("^Max chars length check for Password text field if text is more than fifty chars$")
public void MaxCharsLenCheck_Password() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.PasswordFieldfieldValidation(FiftyCharsCheck);
}

@Given("^mandatory field check for confirmation Password text field if text is not entered$")
public void MandatoryFieldVerification_ConfirmPassword() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.ConfirmPasswordFieldfieldValidation(NoTextEntry);	
}

@Given("^Min chars length check for confirmation Password text field if text is less than five chars$")
public void MinCharsLenCheck_ConfirmPassword() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.ConfirmPasswordFieldfieldValidation(MinCharCheck);	
}

@Given("^Max chars length check for confirmation Password text field if text is more than fifty chars$")
public void MaxCharsLenCheck_ConfirmPassword() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.ConfirmPasswordFieldfieldValidation(FiftyCharsCheck);
}


@Then("^Verify that valid warning Error message is shown up if new password and confirm password not matching$")
public void NotMatchPasswdAndConfirmPasswd() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.ValidationMessageCheck_for_PasswordMatching();
}

@Given("^user provides different password text in Registration page for complexity check and seen that password Strength is shown up$")
public void StrengthCheck_Password() {
	RegistrationPage registrationPage=new RegistrationPage(driver);
	registrationPage.PasswordStrengthCheck("Kannan", "Kannan@","Kannan@112");
}	   
 }