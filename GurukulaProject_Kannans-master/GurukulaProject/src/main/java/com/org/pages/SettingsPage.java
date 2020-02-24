package com.org.pages;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.org.enums.AppValidationMessages;
import com.org.util.ApplicationFunctionLibrary;
import com.org.util.FunctionLibrary;
import com.org.util.Log;
import com.org.util.LoggerHelper;

public class SettingsPage extends FunctionLibrary {
	
	private WebDriver driver;
	Logger logger=LoggerHelper.getLogger(SettingsPage.class);
	
	//Registration Page Objects Web Elements
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstName;
	@FindBy(xpath="//input[@name='lastName']")
	WebElement lastName;
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	@FindBy(xpath="//select[@name='langKey']")
	WebElement langkey;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	@FindBy(xpath="//*[text()='Account']")
	WebElement Account;
	@FindBy(xpath="//*[text()='Settings']")
	WebElement Settings;
	@FindBy(xpath="//h2[@translate='settings.title']")
	WebElement AuthenticationTitle;
	
	@FindBy(xpath="//*[text()='Settings saved!']")
	WebElement SettingsSavedEle;	
	@FindBy(xpath="//*[text()='Your first name is required.']")
	WebElement firstnameRequiredMsgEle;	
	@FindBy(xpath="//*[text()='Your last name is required.']")
	WebElement lastnameRequiredMsgEle;	
	 
				//Email
				@FindBy(xpath="//*[text()='Your e-mail is invalid.']")
				WebElement EmailInvalidMsgEle;
				@FindBy(xpath="//*[text()='Your e-mail is required to be at least 5 characters.']")
				WebElement emailMinCharsLengthMsgEle;
				@FindBy(xpath="//*[text()='Your e-mail is required.']")
				WebElement emailRequiredMsgEle;	
				@FindBy(name="langKey")
				WebElement LanguageDropDownEle;	
	public SettingsPage(WebDriver driver) {
		this.driver=driver;
		Log.info("Settings page elements are initialized");
		PageFactory.initElements(driver, this);
	}
	
	public void SaveClick() {
		commonClick(save);	
		Log.info("Save button is clicked in Settings page");
		}
	
	public void Enterfirstname(String firstNamestr) {
		commonSetTextTextBox(firstName, firstNamestr);
	}
	public void EnterEmail(String Email) {
	commonSetTextTextBox(email, Email);
	}
	public void Enterlastname(String lastNamestr) {
 		commonSetTextTextBox(lastName, lastNamestr);
	}
	
	public void SettingsPageNaviate() {
		commonClick_MenuItem(driver, Account, Settings);
	}
	public void SetttingsPageTitleValidation() {
		assertTrue(commonVerifyLabelText(AuthenticationTitle,AppValidationMessages.SettingPagetitle));
	}

	public void SettingsChange(String firstNamestr,String lastNamestr, String Email) {
		Enterfirstname(firstNamestr);
		Enterlastname(lastNamestr);
		EnterEmail(Email);
		SaveClick();
	}

	public void settingssavedValidmessageVerification() {
		assertTrue(commonVerifyLabelText(SettingsSavedEle,AppValidationMessages.SettingsSavedMsg));
	}

	public void ConfirmFirstNameFieldfieldValidation(String Entertext) { 
		ApplicationFunctionLibrary AppFunLib=new ApplicationFunctionLibrary();
		if (Entertext.equals(AppValidationMessages.FiftyCharsCheck))
			//assertTrue(ApplicationWarningMessageValidation(confirmPasswordtextbox, AppValidationMessages.MaxCharsStr,MoreThanFiftycharslengthWarningMessageForConfirmPassword, AppValidationMessages.MoreThanFiftycharslengthWarningMessageForConfirmPasswordstr));
			assertTrue(AppFunLib.CannotEnterMoreThanfiftyChars(firstName,AppValidationMessages.MaxCharsStr));
		else if (Entertext.equals(AppValidationMessages.NoTextEntry)) {
				firstName.sendKeys("a");
				firstName.clear();
			assertTrue(AppFunLib.ApplicationWarningMessageValidation(firstName, AppValidationMessages.NoCharStr, 
								firstnameRequiredMsgEle,AppValidationMessages.firstnameRequiredMsgStr));
			}
	}
	
	public void ConfirmLastNameFieldfieldValidation(String Entertext) { 
		ApplicationFunctionLibrary AppFunLib=new ApplicationFunctionLibrary();
		if (Entertext.equals(AppValidationMessages.FiftyCharsCheck))
			assertTrue(AppFunLib.CannotEnterMoreThanfiftyChars(lastName,AppValidationMessages.MaxCharsStr));
		else if (Entertext.equals(AppValidationMessages.NoTextEntry)) {
			lastName.sendKeys("a");
			lastName.clear();
			assertTrue(AppFunLib.ApplicationWarningMessageValidation(lastName, AppValidationMessages.NoCharStr, 
								lastnameRequiredMsgEle,AppValidationMessages.lastnameRequiredMsgStr));
			}
	}
	public void InvalidEmailIdverification(String srText) {
			commonSetTextTextBox(email, srText); 
			  commonVerifyLabelText(EmailInvalidMsgEle,AppValidationMessages.InvalidEmailidMessagestr);	
		 
	}
	
	public void MinimumCharEmailIdverification(String srText) {
			commonSetTextTextBox(email, srText); 
			  commonVerifyLabelText(emailMinCharsLengthMsgEle,AppValidationMessages.FivecharslengthWarningMessageForEmailstr);
	}
	
	public void NoEmailIdverification() {
		commonSetTextTextBox(email, ""); 
		  commonVerifyLabelText(emailRequiredMsgEle,AppValidationMessages.EmailRequiredMsgStr);
}  
	public void SelectLanguage() {		
		String LanguageSelect="English";
		assertTrue(CommonSelectDropDown(LanguageDropDownEle,LanguageSelect));
		logger.info("English Language is selected");
	}

	public void saveButtonDisableCheck() {
		logger.info("Save button is enabled check as all the fields are available by default in Settings page");
		assertTrue(save.isEnabled());
		commonSetTextTextBox(firstName, "");	
		assertTrue(!save.isEnabled());
		commonSetTextTextBox(lastName, "");
		assertTrue(!save.isEnabled());
		logger.info("Save button is disabled if firstname, last names are not provided");
	}
	public void CloseSession() {
		logger.info("user closes the session");
		driver.close();
		driver.quit();		
	}
}
