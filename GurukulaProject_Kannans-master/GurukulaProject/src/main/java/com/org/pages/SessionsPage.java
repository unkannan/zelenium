package com.org.pages;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.util.FunctionLibrary;
import com.org.util.LoggerHelper;

public class SessionsPage extends FunctionLibrary {
	private WebDriver driver;
	public SessionsPage(WebDriver driver) {
		this.driver=driver;
		logger.info("UpdatePasswordPage elements are initialized");
		PageFactory.initElements(driver, this);
	}
 
	Logger logger=LoggerHelper.getLogger(SessionsPage.class);
			
		  
			@FindBy(xpath="//*[@id=\"navbar-collapse\"]/ul/li[3]/a/span/b")
			WebElement Accountmenu;
			@FindBy(xpath="/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li[3]/a[1]/span[2]")
			WebElement SessionSubMenu;
			@FindBy(xpath="//h2[contains(text(),'Active sessions for')]")
			WebElement SessionPageTitle;
			@FindBy(xpath="//tr[1]//td[4]//button[1]")
			WebElement DefaultInvalidateButton;
			@FindBy(xpath="//strong[contains(text(),'Session invalidated!')]")
			WebElement SessionInvalidateActualTextMsg;
			//table count
			@FindBy(xpath="//tbody//tr[1]")
			WebElement TableCount;
			
			private static final String SessionPageTitleExpected="Active sessions for [admin]";
			private static final String SessionInvalidateExpectedTextMsg="Session invalidated!";
			
			public void NaviateToSessionPage() {
				commonClick_MenuItem(driver,Accountmenu,SessionSubMenu);
				 }
			
			public void SessionPageTitleVaidation() {
				boolean bool=commonVerifyLabelText(SessionPageTitle,SessionPageTitleExpected);
				assertTrue(bool);
			}

			public void InvalidateSession() { 
				commonClick(DefaultInvalidateButton);
				logger.info("Invalidate Button is clicked to delete the session");
			}

			public void InvalidatedSessionPageTitleVerfication() { 
				boolean bool=commonVerifyLabelText(SessionInvalidateActualTextMsg,SessionInvalidateExpectedTextMsg);
				assertTrue(bool);
			}
}
