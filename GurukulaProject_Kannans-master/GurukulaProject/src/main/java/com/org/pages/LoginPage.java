package com.org.pages;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.util.FunctionLibrary;

  

public class LoginPage extends FunctionLibrary{
	
private WebDriver driver;
 
static Logger logger = Logger.getLogger(LoginPage.class.getName());
 
	@FindBy(xpath="//button[@type='submit' and text()='Authenticate']")
	WebElement Authenticate;
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	
	//@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[3]/a/span/span[2]")
	@FindBy(xpath="//*[text()='Account']")
	WebElement Account;
	//@FindBy(xpath="//*[text()='Log out']")
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]//span[text()='Log out']")
	WebElement Logout;
	@FindBy(xpath="//a[text()='login'] ")
	WebElement login;
	
	@FindBy(xpath="//a[@class='navbar-brand']/img")
	WebElement GurukulaLogo;
	
	
	
	@FindBy(xpath="//*[@id=\"navbar-collapse\"]//span[text()='Home']")
	WebElement GurukulaHomeLink;
	
	@FindBy(id="rememberMe")
	WebElement rememberMecheckbox;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void LogindefaultUserDetails() {
		LoginIntoGuruKulPage("admin","admin");
		}
  
public void ApplicationLaunchLoginButtonClick() {
	logger.info("Application is Launched");
	commonClick(login);
	logger.info("user clicked the login button is Launched");
}

public void LoginIntoGuruKulPage(String strusername,String strpassword) {
	// commonClick(login);
	 Boolean bool=commonSetTextTextBox(username,strusername);
	 assertTrue(bool);
	
	 logger.info(strusername+" username is entered");
	 bool=commonSetTextTextBox(password,strpassword);
	 assertTrue(bool); 
	 logger.info("password is entered");
	 commonClick(Authenticate);
	 logger.info("Authenticate button is clicked for Login");
	}

public void Logout() {
	commonClick_MenuItem(driver, Account, Logout);
	//Account.click();
	//logger.info("Account menu is clicked");
	//Logout.click();		
	//logger.info("Logout link is clicked Under Account menu");
}

public void clearLogintext(){
	 username.clear();
	 logger.info("Username text box is cleared");
	 password.clear();
	 logger.info("Password text box is cleared");
	 }

public void GurukulaLogoclick() {
	GurukulaLogo.click();
	logger.info("Gurukula logo is clicked");
}

public void GurukulaHomeLinkClick() {
	GurukulaHomeLink.click();
	logger.info("Gurukula home Link is clicked");
}
public void rememberMecheckboxClick() {
	if(rememberMecheckbox.isSelected())
		logger.info("Verified that rememberMeCheck is selected or not");
		rememberMecheckbox.click();
		logger.info("rememberMe Checkbox if selected, then unchecked it");
}

}
