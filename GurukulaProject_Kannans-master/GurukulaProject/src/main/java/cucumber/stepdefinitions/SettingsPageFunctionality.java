package cucumber.stepdefinitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.managers.WebDriverManager;
import com.org.pages.LoginPage;
import com.org.pages.RegistrationPage;
import com.org.pages.ResetPasswordPage;
import com.org.util.LoggerHelper;
import com.org.pages.SettingsPage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import org.junit.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SettingsPageFunctionality {
	public static WebDriver driver;

static Logger logger=LoggerHelper.getLogger(SettingsPageFunctionality.class);
private static final String FiftyCharsCheck="50chars";
private static final String specialCharsCheck="specialCharsCheck";
private static final String NoTextEntry="NoTextEntry";
private static final String MinCharCheck="MinCharCheck";

public void lanuchApplication() {	 
}

@Given("^A User launches application logs in successfully with valid credentials$")
public void LaunchesApplication()  {
	driver=CommonPageStepDefinition.lanuchApplication();
	LoginPage loginpage=new LoginPage(driver);
	loginpage.ApplicationLaunchLoginButtonClick();
	 loginpage.LoginIntoGuruKulPage("admin","admin");
}

@Given("^User navigates to Settings page by clicking Account Menu > Settings welcome screen$")
public void SettingsPageNavigation()  {
   SettingsPage settingspage=new SettingsPage(driver);
   settingspage.SettingsPageNaviate();
    
}

@Then("^User should be able to see the Settings page$")
public void SettingsPageVerification()  {
	SettingsPage settingspage=new SettingsPage(driver);
	   settingspage.SetttingsPageTitleValidation();
    
}

@Given("^User Logs in and navigates to Settings page from Account Menu > Settings$")
public void SettingsPageNavigationWithLogin()  {
	lanuchApplication();
	LoginPage loginpage=new LoginPage(driver);
	 loginpage.LoginIntoGuruKulPage("admin","admin");
	   SettingsPage settingspage=new SettingsPage(driver);
	     settingspage.SettingsPageNaviate();
}

@Then("^user without any changes should be able to change the Settings details by clicking Save button$")
public void SettingDetailsPg_SaveButtonClickFunctionality()  {
	SettingsPage settingspage=new SettingsPage(driver);
		settingspage.SaveClick();
			settingspage.settingssavedValidmessageVerification();
      
}
@Then("^user does the changes the settings and clicking save button should be able to change the settings$")
public void SettingsChanges(){
	SettingsPage settingspage=new SettingsPage(driver);
	settingspage.SettingsChange("firstname","lastname","add2kann@yahoo.com");
	settingspage.settingssavedValidmessageVerification();
}

@Given("^mandatory field check for First Name field if text is not provided$")
public void FirstNameMandatoryCheckValidation()  {
	SettingsPage settingspage=new SettingsPage(driver);
	settingspage.ConfirmFirstNameFieldfieldValidation(NoTextEntry);	
    
}

@Given("^Max chars can enter is fifty in the length for First Name field$")
public void FirstNameMaxCharsLengthCheck()  {
	SettingsPage settingspage=new SettingsPage(driver);
	settingspage.ConfirmFirstNameFieldfieldValidation(FiftyCharsCheck);	
}

@Given("^mandatory field check for Last Name field if text is not provided$")
public void LastNameMandatoryCheckValidation() {
	SettingsPage settingspage=new SettingsPage(driver);
	settingspage.ConfirmLastNameFieldfieldValidation(NoTextEntry);
}
@Given("^Max chars can enter is fifty in the length for Last Name field$")
public void LastNameMaxCharsLengthCheck()  {
	SettingsPage settingspage=new SettingsPage(driver);
	settingspage.ConfirmLastNameFieldfieldValidation(FiftyCharsCheck);	
}

@Then("^user provides email text with less than five chars in <Emailid> and verify proper error message is shown$")
public void EmailTextMinCharLengthCheck(DataTable testdata)  {
	List<List<String>> data = testdata.raw();
	SettingsPage settingspage=new SettingsPage(driver);
	for(int i=1;i<data.size();i++) 
		settingspage.MinimumCharEmailIdverification(data.get(i).get(0));
}


 
@Then("^User provides no emailid and verify warning error message showing up$")
public void NoEmailIDInputValidation(){
	SettingsPage settingspage=new SettingsPage(driver);
	settingspage.NoEmailIdverification();
}

@Then("^user provides email text having less than five chars without @ symbol in <Emailid> and verify validation is done for minimum char$")
public void EmailLessthanFiveCharsWithoutSymbol(DataTable testdata) {
	List<List<String>> data = testdata.raw();
	SettingsPage settingspage=new SettingsPage(driver);
	for(int i=1;i<data.size();i++) 
		settingspage.MinimumCharEmailIdverification(data.get(i).get(0));
}

@Then("^user provides email text without @ symbol in <Emailid> and verify validation is done for invalid emailid$")
public void InvalidEmailIDInputValidation(DataTable testdata) {
	List<List<String>> data = testdata.raw();
	SettingsPage settingspage=new SettingsPage(driver);
	for(int i=1;i<data.size();i++)
		settingspage.InvalidEmailIdverification(data.get(i).get(0));
}

@Then("^User would be able to select the English text in Language drop down$")
public void SelectLanguageDropDown() {
	SettingsPage settingspage=new SettingsPage(driver);
	settingspage.SelectLanguage();
}

@Then("^save button is disabled if any of the field of firstname,lastname, email is not provided$")
public void SaveButtonDisableFunctioanlityCheck(){
	SettingsPage settingspage=new SettingsPage(driver);
	settingspage.saveButtonDisableCheck();
}   
 }