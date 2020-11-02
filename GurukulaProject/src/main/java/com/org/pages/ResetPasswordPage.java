package com.org.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.enums.AppValidationMessages;
import com.org.util.FunctionLibrary;
import com.org.util.LoggerHelper;

public class ResetPasswordPage extends FunctionLibrary{
	
	private WebDriver driver;
	Logger logger=LoggerHelper.getLogger(ResetPasswordPage.class);
	
	@FindBy(xpath="//h1[@translate='reset.request.title']")
	WebElement ResetPasswordPageTitle; 
	
	@FindBy(xpath="//a[text()='Did you forget your password?']")
	WebElement ForgotPasswordLink;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement EmailTextField;
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit;
	@FindBy(xpath="//strong[contains(text(),\"E-Mail address isn't registered!\")]")
	WebElement EmailIDNotRegisteredErrorMessage;
	@FindBy(xpath="//p[contains(text(),'Enter the e-mail address you used to register')]")
	WebElement EnterRegisteredEmailID;
	@FindBy(xpath="//*[text()='Your e-mail is invalid.']")
	WebElement InvalidEmailidErrorMessage;
	 
	@FindBy(xpath="//p[contains(text(),'Your e-mail is required to be at least 5 character')]")
	WebElement InvalidEmailid5charsErrorMessage;
	 
	//@FindBy(xpath="/html/body/div[3]/div[1]/div/div/div/form/div/div/p[4]")
	@FindBy(xpath="//p[contains(text(),'Your e-mail cannot be longer than 50 characters.')]")
	WebElement InvalidEmailidErrorMsgwith50Chars;
	//@FindBy(xpath="/html/body/div[3]/div[1]/div/div/div/form/div/div/p[1]")
	@FindBy(xpath="//*[text()='Your e-mail is required.']")
	WebElement EmailidRequireErrorMessageExpectedElement;
	
	 
	public ResetPasswordPage(WebDriver driver) {
		this.driver=driver;
		logger.info("ResetPasswordPage elements are initialized");
		 PageFactory.initElements(driver, this);
	}
	
	public void ResetPasswordPageVerification() {
			logger.info("ResetPasswordPageVerification is in progress");
			assertTrue(commonVerifyLabelText(ResetPasswordPageTitle, AppValidationMessages.ResetPasswordTitle));
	}
	
	public void ForgotPasswordlinkClick() {
		commonClick(ForgotPasswordLink);
		logger.info("Forgot Password link is clicked");
		}
	
	public void validEmailIdverification(String emailid ) {
		commonSetTextTextBox(EmailTextField, emailid);
			logger.info("Emailid is entered as "+emailid);
		commonClick(submit);
			logger.info("Submit button is clicked");
			logger.info("Verifying the emailid and submit button is displayed still or not ");
		assertFalse(EmailTextField.isDisplayed());		
		}
	
	public void InvalidEmailIdverification(String emailid) {
		commonSetTextTextBox(EmailTextField, emailid);
		logger.info("Invalid and unregistered Emailid is entered as "+emailid);
		commonClick(submit);
		//assertEquals(ERROR,ErrorMessage.getText());
		assertTrue(commonVerifyLabelText(EmailIDNotRegisteredErrorMessage, AppValidationMessages.EmailIDisntRegiseredstr));
		assertTrue(commonVerifyLabelText(EnterRegisteredEmailID, AppValidationMessages.EmailIDUsedtoRegsterstr));
		EmailTextField.clear();
		}

	public void InvalidEmailidWithoutSymbol(String emailid) {
		
		commonSetTextTextBox(EmailTextField, emailid);
		assertTrue(commonVerifyLabelText(InvalidEmailidErrorMessage, AppValidationMessages.InvalidEmailidErrorMessageExpected));
		EmailTextField.clear();
		
	}
	public void InvalidEmailid5CharsCheck(String emailid) {
		commonSetTextTextBox(EmailTextField, emailid);
		assertTrue(commonVerifyLabelText(InvalidEmailid5charsErrorMessage, AppValidationMessages.InvalidEmailid5charsErrorMessageExpected));
		EmailTextField.clear();
	}
	
	public void InvalidEmailidwith50CharsValidation(String emailid) {
		commonSetTextTextBox(EmailTextField, emailid);
		assertTrue(commonVerifyLabelText(InvalidEmailidErrorMsgwith50Chars, AppValidationMessages.InvalidEmailid50charsErrorMessageExpected));
		 EmailTextField.clear();
	}

	public void NoEmailidVerificationWarningMessage() {
		commonSetTextTextBox(EmailTextField, "remove");
		EmailTextField.clear();
		assertTrue(commonVerifyLabelText(EmailidRequireErrorMessageExpectedElement, AppValidationMessages.EmailidRequireErrorMessageExpected));
	}
	 
	
	
	

}
