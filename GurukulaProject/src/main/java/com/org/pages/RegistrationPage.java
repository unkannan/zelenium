package com.org.pages;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.enums.AppValidationMessages;
import com.org.util.ApplicationFunctionLibrary;
import com.org.util.FunctionLibrary;
import com.org.util.LoggerHelper;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class RegistrationPage extends FunctionLibrary {
	
	private WebDriver driver;
	Logger logger=LoggerHelper.getLogger(RegistrationPage.class);
	
	//Registration Page Objects Web Elements
	@FindBy(xpath="//input[@name='login']")
	WebElement logintextbox;
	@FindBy(xpath="//input[@name='email']")
	WebElement emailtextbox;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordtextbox;
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement confirmPasswordtextbox;
	@FindBy(xpath="//a[text()='Register a new account']")
	WebElement RegisterNewAccount;
	
	//Registration page - Registration success/ failures Warning Messages Web Elements
	@FindBy(xpath="//strong[contains(text(),'Login name already registered!')]")
	WebElement LoginNameAlreadyRegisteredElement;
	@FindBy(xpath="//strong[contains(text(),'Registration failed!')]")
	WebElement RegistrationfailedEle;
	//@FindBy(xpath="//strong[contains(text(),'Registration Success!')]")
	WebElement RegistrationSuccessEle;
	
		
	
	//Registration page - text fileds validation warning messages Web Elements
		//Login
		@FindBy(xpath="//*[text()='Your login is required.']")
		WebElement LoginRequiredWarningMsgEle;
		@FindBy(xpath="//*[text()='Your login cannot be longer than 50 characters.']")
		WebElement MaxCharsLoginFieldEle;
		@FindBy(xpath="//*[text()='Your login can only contain lower-case letters and digits.']")
		WebElement SpecialCharsMsgEle;
		
		
				//Emaild
				@FindBy(xpath="//*[text()='Your e-mail is invalid.']")
				WebElement EmailInvalidMsgEle;
				@FindBy(xpath="//*[text()='Your e-mail is required to be at least 5 characters.']")
				WebElement MinCharsLengthMsgEle;
	
					//Password
					@FindBy(xpath="//*[text()='Your password is required.']")
					WebElement PasswordrequiredEle;	
					@FindBy(xpath="//*[text()='Your password is required to be at least 5 characters.']")
					WebElement FivecharslengthWarningMessageForPassword;
					@FindBy(xpath="//*[contains(text(),'Your password cannot be longer than 50 characters')]")
					WebElement MoreThanFiftycharslengthWarningMessageForPassword;
					
					
					//ConfirmPassword
					@FindBy(xpath="//*[text()='Your confirmation password is required.']")
					WebElement ConfirmPasswordrequired;
					@FindBy(xpath="//*[text()='Your confirmation password is required to be at least 5 characters.']")
					WebElement FivecharslengthWarningMessageForConfirmPassword;
					@FindBy(xpath="//*[contains(text(),'Your confirmation password cannot be longer than 50 characters.')]")
					WebElement MoreThanFiftycharslengthWarningMessageForConfirmPassword;
									
					@FindBy(xpath="//*[text()='The password and its confirmation do not match!']")
					WebElement PasswordConfirmationMatchTextEle;
					 
		//PasswordStrengthColor Weblements
					@FindBy(xpath="//ul[@id='strengthBar']/li[1]")
					WebElement StrengthRed;
					@FindBy(xpath="//ul[@id='strengthBar']/li[2]")
					WebElement StrengthOrange;
					@FindBy(xpath="//ul[@id='strengthBar']/li[3]")
					WebElement StrengthGreen;
	
	 
	
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		logger.info("RegistrationPage elements are initialized");
		PageFactory.initElements(driver, this);
	}
	
	public void RegisterNewAccountClick() {
		RegisterNewAccount.click();	
		logger.info("Register New Account link is clicked");
		}
	
	public void EnterUsername(String username) {
		//logintextbox.sendKeys(username);
		commonSetTextTextBox(logintextbox, username);
	}
	public void EnterEmail(String Email) {
		//emailtextbox.sendKeys(Email);
		commonSetTextTextBox(emailtextbox, Email);
	}
	public void Enterpassword(String password) {
	//	passwordtextbox.sendKeys(password);
		commonSetTextTextBox(passwordtextbox, password);
	}
	public void EnterconfirmPassword(String confirmPassword) {
		//confirmPasswordtextbox.sendKeys(confirmPassword);
		commonSetTextTextBox(confirmPasswordtextbox, confirmPassword);
	}

	public void EnterRegistrationDetails(String username,String Email,String password, String confirmPassword) {
		commonSetTextTextBox(logintextbox,username);
		commonSetTextTextBox(emailtextbox,Email);
		commonSetTextTextBox(passwordtextbox,password);
		commonSetTextTextBox(confirmPasswordtextbox,confirmPassword);
	}

	public void RegistrationValidationMessage(String Message) {
		boolean bool=false;
		if (Message.equalsIgnoreCase(AppValidationMessages.ExistingUser))
			bool=commonVerifyLabelText(LoginNameAlreadyRegisteredElement,AppValidationMessages.LoginNameAlreadyRegisteredElementStr);
		else if (Message.equalsIgnoreCase(AppValidationMessages.SuccessUser))
			bool=commonVerifyLabelText(RegistrationSuccessEle,AppValidationMessages.RegistrationSuccessEleStr);
		
		assertTrue(bool);
	}
	
	public void LoginFieldfieldValidation(String Entertext) {
		if (Entertext.equals(AppValidationMessages.FiftyCharsCheck))
			assertTrue(ApplicationWarningMessageValidation(logintextbox, AppValidationMessages.MaxCharsStr, 
					MaxCharsLoginFieldEle,AppValidationMessages.MoreThanFiftycharslengthWarningMessageForLoginstr ));	
		else if (Entertext.equals(AppValidationMessages.NoTextEntry))
			assertTrue(ApplicationWarningMessageValidation(logintextbox, AppValidationMessages.NoCharStr, 
					LoginRequiredWarningMsgEle, AppValidationMessages.LoginRquiredStr));
		else if (Entertext.equals("specialCharsCheck"))
			assertTrue(ApplicationWarningMessageValidation(logintextbox, AppValidationMessages.SpecialChar, 
					SpecialCharsMsgEle, AppValidationMessages.specialCharsCheckStr));
	}
	
	public void PasswordFieldfieldValidation(String Entertext) {
		if (Entertext.equals(AppValidationMessages.FiftyCharsCheck))
			assertTrue(ApplicationWarningMessageValidation(passwordtextbox, AppValidationMessages.MaxCharsStr,
					MoreThanFiftycharslengthWarningMessageForPassword, AppValidationMessages.MoreThanFiftycharslengthWarningMessageForPasswordstr));
		else if (Entertext.equals(AppValidationMessages.NoTextEntry)) {
			passwordtextbox.sendKeys("a");
			passwordtextbox.clear();
			assertTrue(ApplicationWarningMessageValidation(passwordtextbox, AppValidationMessages.NoCharStr, PasswordrequiredEle, AppValidationMessages.Passwordrequiredstr));
			}
		else if (Entertext.equals(AppValidationMessages.MinCharCheck))
			assertTrue(ApplicationWarningMessageValidation(passwordtextbox, AppValidationMessages.MinCharStr, 
					FivecharslengthWarningMessageForPassword, AppValidationMessages.FivecharslengthWarningMessageForPasswordstr));
	}

	public void ConfirmPasswordFieldfieldValidation(String Entertext) { 
		if (Entertext.equals(AppValidationMessages.FiftyCharsCheck))
			assertTrue(ApplicationWarningMessageValidation(confirmPasswordtextbox, AppValidationMessages.MaxCharsStr,
												MoreThanFiftycharslengthWarningMessageForConfirmPassword, AppValidationMessages.MoreThanFiftycharslengthWarningMessageForConfirmPasswordstr));
		else if (Entertext.equals(AppValidationMessages.NoTextEntry)) {
			confirmPasswordtextbox.sendKeys("a");
			confirmPasswordtextbox.clear();
			assertTrue(ApplicationWarningMessageValidation(confirmPasswordtextbox, AppValidationMessages.NoCharStr, 
																	ConfirmPasswordrequired,AppValidationMessages.ConfirmPasswordrequiredstr));
			}
		else if (Entertext.equals(AppValidationMessages.MinCharCheck))
				assertTrue(ApplicationWarningMessageValidation(confirmPasswordtextbox, AppValidationMessages.MinCharStr, 
							FivecharslengthWarningMessageForConfirmPassword, AppValidationMessages.FivecharslengthWarningMessageForConfirmPasswordstr));
	}
	
	public void ValidationMessageCheck_for_PasswordMatching()	{
	assertTrue(commonVerifyLabelText(PasswordConfirmationMatchTextEle,AppValidationMessages.PasswordConfirmationMatchTextStr));
	}

	public void PasswordStrengthCheck(String RedPassword, String OrangePassword, String GreenPassword) {
		ApplicationFunctionLibrary appfun=new ApplicationFunctionLibrary();
		appfun.PasswordStrengthCheck(passwordtextbox, StrengthRed,StrengthOrange,StrengthGreen, RedPassword, OrangePassword, GreenPassword);
		
	}
  
}
