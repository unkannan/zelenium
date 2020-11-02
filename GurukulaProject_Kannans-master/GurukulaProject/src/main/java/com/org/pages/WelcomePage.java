package com.org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.util.FunctionLibrary;
import com.org.util.Log;
import static org.junit.Assert.*;

import org.apache.log4j.Logger;

public class WelcomePage extends FunctionLibrary {
	
	private WebDriver driver;
	 
	static Logger logger = Logger.getLogger(WelcomePage.class.getName());
	
	
	@FindBy(xpath="//*[text()='Account']")
	WebElement Accountmenu1;
	@FindBy(xpath="//*[text()='Register']")
	WebElement Register1;	
	@FindBy(xpath= "//h1[@translate='main.title']")
	WebElement MainTitle;	 
	@FindBy(xpath= "//a[text()='login']")
	WebElement login;
	@FindBy(xpath="//h1[@translate='login.title']")
	WebElement AuthenticationTitle;
	@FindBy(xpath="//span[@class='hidden-tablet ng-scope']")
	WebElement AccountMenu;
	@FindBy(xpath="//span[text()='Password']")
	WebElement PasswordSubMenu;
	@FindBy(xpath="//a[contains(text(),'Register a new account')]")
	WebElement RegisterANewAccount;	
	@FindBy(xpath="//li//a//span[@translate='global.menu.account.login']")
WebElement AuthenticateSubMenu;
	@FindBy(xpath="//h1[@translate='register.title']")
	WebElement RegisterationPageTitle;
	@FindBy(xpath="//span[contains(text(),'Register')]")
	WebElement RegisterSubMenu;
	
	public WelcomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void PasswordSubMenuClick() {
		commonClick_MenuItem(driver,AccountMenu,PasswordSubMenu);
	}
	public void WelcomePageloginlinkClick() {
		commonClick(login);
		logger.info("Welcome Page login link is clicked");		
	}
	public void MainTitleVerficationCheck() {
		String ActualResult=MainTitle.getText();
		logger.info("Gurukul main page title verification");
		assertEquals(ActualResult,"Welcome to Gurukula!");		
	}
	public void AuthenticationTitleCheck() {
		String ActualResult=AuthenticationTitle.getText();
		logger.info("Verification of Authentication page title ");
		assertEquals(ActualResult,"Authentication");
	}
	public void AccountMenuClick() {
		AccountMenu.click();
	}	
	public void AuthenticateSubMenuClick() {
		//AccountMenu.click();
		logger.info("In welcome Screen, Account Menu is clicked");
		//AuthenticateSubMenu.click();
		commonClick_MenuItem(driver,AccountMenu,AuthenticateSubMenu);
		logger.info("In welcome Screen, Account Menu > Authenticate Sub menu is clicked");
	}
	public void RegisterSubMenuClick() {
		driver.findElement(By.xpath("//span[@class='hidden-tablet ng-scope']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();",Accountmenu1);
		WebElement reg=driver.findElement(By.xpath("//span[contains(text(),'Register')]"));
		logger.info("In welcome Screen, Account Menu is clicked");
		JavascriptExecutor js1 = (JavascriptExecutor) driver; 
		js1.executeScript("arguments[0].click();",reg);		 
		logger.info("In welcome Screen, Account Menu > Register Sub menu is clicked");
	}
	 
	public void RegistrationPageTitleCheck() {
		String ActualResult=RegisterationPageTitle.getText();
		logger.info("Verification of Registration Page Title");
		assertEquals(ActualResult,"Registration");
		
	}
	public void RegisterANewAccountlinkclick() {
		//driver.findElement(By.xpath("//a[contains(text(),'Register a new account')]")).click();;
		commonClick(RegisterANewAccount);
		logger.info("RegisterANewAccount link is clicked");
	}
	
}
