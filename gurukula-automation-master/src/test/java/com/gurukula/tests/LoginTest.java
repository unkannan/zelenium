
package com.gurukula.tests;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.gurukula.pages.LoginPage;
import com.gurukula.pages.TechBeamersPage;
import com.gurukula.utility.Init;

/**
 * @author AnujKumar
 */

//@Test(groups = "login")
public class LoginTest extends Init {

	public static Logger logger = Logger.getLogger(LoginTest.class.getName());


	LoginPage loginPage;

	//@Test
	public void tc_01_testLoginWithValidCredentials() {
		//preSteps();
		//loginPage.loginAndAssertSuccessfulMessage(USERNAME, PASSWORD);
		 
		assertTrue(true);
	}
	
	private void preSteps() {
		//welcomePage = new WelcomePage(driver);
		loginPage = new LoginPage(driver);
		techBeamersPG = new TechBeamersPage(driver);

		//welcomePage.clickOnLink(WelcomeEnum.LOGIN_LINK.getVal());
	}
	
	TechBeamersPage techBeamersPG;
	 
	@Test
	public void WebTableExcercise1() {
	 preSteps();
	 techBeamersPG.elementsinLearnPythonList();
	}

	 
/*
	@Test(dataProvider = "invalidCredentials")
	public void tc_02_testLoginWithInValidCredentials(String username, String password) {
		preSteps();
		loginPage.assertLoginValidationMsg(username, password);
	}

	@Test
	public void tc_03_testForgotPasswordLink() {
		preSteps();
		loginPage.clickOnLink(LoginPage.FORGET_LINK);

		//ResetPasswordPage resetPasswordPage = new ResetPasswordPage(driver);
		resetPasswordPage.assertResetPasswordPageHeading();
	}

	@Test
	public void tc_04_testRegistrationLink() {
		preSteps();
		loginPage.clickOnLink(LoginPage.REGISTER_LINK);

		RegistrationPage registrationPage = new RegistrationPage(driver);
		registrationPage.assertRegistrationPageHeading();
	}

	@Test
	public void tc_05_testLogout() {
		preSteps();
		loginPage.loginAndAssertSuccessfulMessage(USERNAME, PASSWORD);

		welcomePage.clickOnOption(MenuEnum.Account.name(), AccountEnum.Logout.getVal());
		welcomePage.assertWelcomePageHeading();

	}

	@Test
	public void tc_06_testHomeTab() {
		preSteps();
		loginPage.loginAndAssertSuccessfulMessage(USERNAME, PASSWORD);

		welcomePage.clickOnOption(MenuEnum.Entities.name(), EntitiesEnum.Staff.name());
		welcomePage.clickOnMenu(MenuEnum.Home.name());
		welcomePage.assertWelcomePageHeading();
	}

	@Test
	public void tc_07_testLogoNavigation() {
		preSteps();
		loginPage.loginAndAssertSuccessfulMessage(USERNAME, PASSWORD);

		welcomePage.clickOnOption(MenuEnum.Entities.name(), EntitiesEnum.Staff.name());
		welcomePage.clickOnLogo();
		welcomePage.assertWelcomePageHeading();
	}

	private void preSteps() {
		welcomePage = new WelcomePage(driver);
		loginPage = new LoginPage(driver);

		welcomePage.clickOnLink(WelcomeEnum.LOGIN_LINK.getVal());
	}

	@DataProvider(name = "invalidCredentials")
	public Object[][] invalidCredentials() {
		return new Object[][] {
			// @formatter:off
			{ "!nv@lid", "INVALID" }, 
			{ "admin", "INVALID" }, 
			{ "INVALID", "admin" }, 
			{ "", "" },			
			{ "admin", "" }, 
			{ "", "admin" }
			// @formatter:on
		};
	}
*/
}
