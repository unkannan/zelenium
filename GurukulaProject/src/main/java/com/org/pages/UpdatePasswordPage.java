package com.org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.org.enums.AppValidationMessages;
import com.org.util.FunctionLibrary;
//import com.org.util.ObjectsHelper;
import com.org.util.LoggerHelper;
//import com.org.util.ObjectsHelper;

public class UpdatePasswordPage extends FunctionLibrary {
	
	Logger logger=LoggerHelper.getLogger(UpdatePasswordPage.class);
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;	
	@FindBy(xpath="//input[@name='confirmPassword']")
	WebElement confirmPassword;	
	@FindBy(xpath="//h2")
	WebElement UpdatePasswordPageTitle;	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//div[@class='alert alert-danger ng-scope']")
	WebElement PasswordNotChangedTextEle;
	@FindBy(xpath="//*[text()='Your password is required to be at least 5 characters.']")
	WebElement FivecharslengthWarningMessageForPassword;
	@FindBy(xpath="//*[text()='Your confirmation password is required to be at least 5 characters.']")
	WebElement FivecharslengthWarningMessageForConfirmPassword;
	@FindBy(xpath="//*[contains(text(),'Your password cannot be longer than 50 characters')]")
	WebElement MoreThanFiftycharslengthWarningMessageForPassword;
	@FindBy(xpath="//*[contains(text(),'Your confirmation password cannot be longer than 50 characters.')]")
	WebElement MoreThanFiftycharslengthWarningMessageForConfirmPassword;
	@FindBy(xpath="//*[text()='Your password is required.']")
	WebElement Passwordrequired;
	@FindBy(xpath="//*[text()='Your confirmation password is required.']")
	WebElement ConfirmPasswordrequired;
	@FindBy(xpath="//*[text()='The password and its confirmation do not match!']")
	WebElement PasswordConfirmationMatchTextEle;
	
	@FindBy(xpath="//ul[@id='strengthBar']/li[1]")
	WebElement StrengthRed;
	@FindBy(xpath="//ul[@id='strengthBar']/li[2]")
	WebElement StrengthOrange;
	@FindBy(xpath="//ul[@id='strengthBar']/li[3]")
	WebElement StrengthGreen;
	 
	
	
	private static final String UpdatePasswordPageTitleText="Password for [admin]";
	private static final String strPasswordNotChanged="An error has occurred! The password could not be changed.";
	private static final String FivecharslengthWarningMessageForPasswordstr="Your password is required to be at least 5 characters.";
	private static final String MoreThanFiftycharslengthWarningMessageForPasswordstr="Your password cannot be longer than 50 characters.";
	private static final String FivecharslengthWarningMessageForConfirmPasswordstr="Your confirmation password is required to be at least 5 characters.";
	private static final String MoreThanFiftycharslengthWarningMessageForConfirmPasswordstr="Your confirmation password cannot be longer than 50 characters.";
	private static final String Passwordrequiredstr="Your password is required.";
	private static final String ConfirmPasswordrequiredstr="Your confirmation password is required.";
	private static final String PasswordConfirmationMatchTextStr="The password and its confirmation do not match!";
	
	private WebDriver driver;
	public UpdatePasswordPage(WebDriver driver) {
		
		this.driver=driver;
		logger.info("UpdatePasswordPage elements are initialized");
		PageFactory.initElements(driver, this);
	}
	
	public void ValidPasswordCredentials(String Password,String strconfirmPassword) {
		password.sendKeys(Password);
		logger.info("Password is provided");
		confirmPassword.sendKeys(strconfirmPassword);
		logger.info("confirm Password is provided");
		submit.click();
		logger.info("submit button is clicked to save and udpate password");
	}
	
	public void PasswordChangeVerfication() {
		//assertFalse(!password.isDisplayed());
		 
		try{
			String text=PasswordNotChangedTextEle.getText();
		logger.info(text +" is still displaying and user not able to change password");
		if(text.equals(strPasswordNotChanged))
		{
			assertFalse(true);
		}
		}
		catch(Exception e) {}
		//assertFalse(!PasswordNotChangedTextEle.isDisplayed());
		
	}
	
	public void PasswordEntry(String strpassword) {
		password.sendKeys(strpassword);
	}
	
	public void ConfirmPasswordEntry(String password) {
		confirmPassword.sendKeys(password);
	}
	
	public void UpdatePasswordPageTitleValidation() {
		logger.info("update Password Page title Verification");
		  assertTrue(commonVerifyLabelText(UpdatePasswordPageTitle,UpdatePasswordPageTitleText));
	}

	 
	public void FiveCharsWarningMessageValidation(String ElementName) {
		 if (ElementName.equals("password")) {
			 commonSetTextTextBox(password, AppValidationMessages.MinCharStr); 
			  assertTrue(commonVerifyLabelText(FivecharslengthWarningMessageForPassword,AppValidationMessages.FivecharslengthWarningMessageForPasswordstr));
		 }
		 else {
			 commonSetTextTextBox(confirmPassword, AppValidationMessages.MinCharStr); 
			  assertTrue(commonVerifyLabelText(FivecharslengthWarningMessageForConfirmPassword,AppValidationMessages.FivecharslengthWarningMessageForConfirmPasswordstr));
		 }
	}
	 

	public void FiftyCharsLenthValidation(String ElementName) {
		if (ElementName.equals("password")) {
			   commonSetTextTextBox(password, AppValidationMessages.MaxCharsStr); 
			   assertTrue(commonVerifyLabelText(MoreThanFiftycharslengthWarningMessageForPassword,AppValidationMessages.MoreThanFiftycharslengthWarningMessageForPasswordstr));
		}
		else
		{
					 commonSetTextTextBox(confirmPassword,  AppValidationMessages.MaxCharsStr); 
					assertTrue(commonVerifyLabelText(MoreThanFiftycharslengthWarningMessageForConfirmPassword,AppValidationMessages.MoreThanFiftycharslengthWarningMessageForConfirmPasswordstr));
		}		
	}

	public void NoEmailidVerificationWarningMessage(String ElementName) {
		if (ElementName.equals("password")) {
			password.sendKeys("remove");
			password.clear();
			String msg="Verification of password required if password is not provided";
			String ExpectedResult=Passwordrequiredstr;
			String ActualResult=Passwordrequired.getText();
		//	ObjectsHelper.MessageValidation(msg,ActualResult,ExpectedResult);
	}
	else
	{
		confirmPassword.sendKeys("remove");
		confirmPassword.clear();
		String msg="Verification of password required if password is not provided";
		String ExpectedResult=ConfirmPasswordrequiredstr;
		String ActualResult=ConfirmPasswordrequired.getText();
		//ObjectsHelper.MessageValidation(msg,ActualResult,ExpectedResult);
	}	
		
	}
	public void NoMatchingPassword() {
		String msg="Verification of password and confirm password text matching";
		String ExpectedResult=PasswordConfirmationMatchTextStr;
		String ActualResult=PasswordConfirmationMatchTextEle.getText();
		//ObjectsHelper.MessageValidation(msg,ActualResult,ExpectedResult);
	}
	public void submitClick() {
		submit.click();
	}
	 public void PasswordStrengthCheck(String RedPassword,String OrangePassword,String GreenPassword) {
		 logger.info("Password Strengths Validation is in progress");
		 PasswordEntry(RedPassword);
		 String RedColorEnable=StrengthRed.getCssValue("Background");
		 
		 logger.info(StrengthRed.getCssValue("Background"));
		 if(RedColorEnable.contains("rgb(255, 0, 0)")) {
			 	 RedColorEnable = "RedEnabled";
			 	logger.info("RedColor is enabled");
			 	}
		 PasswordEntry(OrangePassword);
		 logger.info(StrengthOrange.getCssValue("Background"));
		 String OrangeColorEnable=StrengthOrange.getCssValue("Background"); 
		  if(OrangeColorEnable.contains("rgb(255, 153, 0)")) {
			  OrangeColorEnable = "OrangeEnabled";
			  logger.info("Orange Color is enabled");
		 	}
		  
		  PasswordEntry(GreenPassword);
		  logger.info(StrengthGreen.getCssValue("Background"));
		  String GreenColorEnable=StrengthGreen.getCssValue("Background"); 
		  if(GreenColorEnable.contains("rgb(153, 255, 0)")) {
			  GreenColorEnable = "GreenEnabled";
			  logger.info("Green Color is enabled");
		  }
		  if(RedColorEnable.equals("RedEnabled") && OrangeColorEnable.equals("OrangeEnabled") && GreenColorEnable.equals("GreenEnabled"))
			  assertTrue(true);
			   
		  else
			  assertTrue(false);
	 }

}
