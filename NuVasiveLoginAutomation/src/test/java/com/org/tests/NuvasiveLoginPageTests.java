
package com.org.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.pages.NuvasiveLoginPage;
import com.org.utility.StartApplication;


public class NuvasiveLoginPageTests extends StartApplication {
	public static Logger logger = Logger.getLogger(NuvasiveLoginPageTests.class.getName());
	NuvasiveLoginPage NuvasiveLoginPage;

	@Test
	public void tc_01_LoginPageHeaderAvailableCheck() {
		preSteps();
			NuvasiveLoginPage.NuvasiveLoginPageMainPageHeaderCheck();
				NuvasiveLoginPage.ToOurSiteHeaderAvailable();
	}
	@Test
	public void tc_02_LoginPageLinkAvailabilityCheck() {
		preSteps();
			NuvasiveLoginPage.LoginLinkAvailabilityCheck();
				NuvasiveLoginPage.CharacterCountLinkAvailabilityCheck();
	}
	@Test
	public void tc_03_LoginUsernamePasswordObjectAvailabilityCheck() {
		preSteps();
		  NuvasiveLoginPage.UserNamePasswordTextBoxAvailabilityCheck();
	}
	@Test
	public void tc_04_LoginSubmitButtonAvailabilityCheck() {
		preSteps();
		  NuvasiveLoginPage.SubmitButtonAvailabilityCheck();
		  NuvasiveLoginPage.SubmitButtonisClickable();
	}
	@Test
	public void tc_05_ClickLoginLinkFunctionality() {
		preSteps();
		  NuvasiveLoginPage.ClickLoginLink();
		  	NuvasiveLoginPage.NuvasiveLoginPageMainPageHeaderCheck();
	}
	@Test(dataProvider = "LoginInput")
	public void tc_06_LoginProvisionWithValidCredentials(String Username,String Password) {
		preSteps();
		  NuvasiveLoginPage.LoginCredentialsProvision(Username,Password);
		  NuvasiveLoginPage.SubmitButtonClick();
	}
	@Test
		public void tc_07_UserNamePasswordFieldTypeCheck() {
			preSteps();
				NuvasiveLoginPage.LoginCredentialsProvision("Username55","Passwordcheck");
			  		NuvasiveLoginPage.UsernamePasswordTypeCheck();
		}

	private void preSteps() {
		NuvasiveLoginPage = new NuvasiveLoginPage(driver);
	}

	@DataProvider(name = "LoginInput")
	public Object[][] LoginCredentailsData() {
		return new Object[][] {
			// @formatter:off
			{ "username1", "Password1"},
			{ "username2", "Password2"}, 
			{ "username3", "Password3"},
			{ "u23432£EERECSe3", "P£!$!£!3"}
			// @formatter:on
		};
	}

}
