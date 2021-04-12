package com.org.test;

import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.*;

import com.org.pages.TacxMainPage;
import com.org.utility.StartApplication;

public class TacxTestAssignment extends StartApplication{
	public static Logger logger = Logger.getLogger(TacxTestAssignment.class.getName());
	TacxMainPage tacxMainpg;
	
	@BeforeMethod
	public void OpenTacxApplication() {
	//	driver.get(prop.getProperty("url"));
		tacxMainpg=new TacxMainPage(driver);
	}
/*	@Test
	public void tc_01_createAccount_tacx_MainPageVerification() {
		
		//Tacx image is shown
		//push your limits is shown
		//Login button is shown
		//Create Account is shown
	}
	
	@Test
	public void tc_02_clickCreateAccountFunctionalCheck() {
		//Click CreateAccount
	}
	
	@Test
	public void tc_03__SignUpPageVerification() {
		//Verify SignUp
		//Verify Push your limits
		//Verify First name text box
	}
	
	@Test
	public void tc_04_click_Returntologinpage_FunctionalCheck() {
		//clickReturntoLoginPage
		//Verify SignUp
				//Verify Push your limits
	}*/
	
	@Test
	public void tc_05_clickSignUp_withdetails() {
		//Enter firstname, email, passwrd, repeat, select checkbox
		//click signup
		/*
		1. Launch any browser and navigate to https://cloud.tacx.com/
			2. Select Create Account option
			3. Enter details and click on sign up button to create new Tacx account
			4. Verify the URL in App dashboard
			5. Select “Create workout” menu item from left pane in dashboard
			6. Select Power workout and then select distance as target and then select continue
			7. Set distance to 12 KM and save the workout with title name
			8. Then navigate to “Workouts” menu item and verify the created new Workout with
			mentioned title name
			9. Logout from Account*/
		//driver.findElement(By.id("create-account")).click();
		tacxMainpg.clickCreateAccount();
		tacxMainpg.EnterSignUpDetails();
		tacxMainpg.clickSignUp();
			System.out.println(driver.getCurrentUrl());
			driver.findElement(By.xpath("//md-content[1]/ul[1]/sidenav-section[1]/ul[1]/li[4]/button[1]/div[1]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'Power')]")).click();
			driver.findElement(By.xpath("//p[contains(text(),'Distance')]")).click();
			driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
			
			while(true) {
			String kms=driver.findElement(By.xpath("//md-toolbar[2]/div[1]/div[2]/div[1]/span[1]")).getText();
			if(kms.equals("12.0 km"))
				break;
			driver.findElement(By.xpath("//body/section[3]/md-content[1]/div[3]/div[1]/div[1]/div[1]/md-toolbar[2]/div[1]/div[2]/div[2]/button[1]/ng-md-icon[1]")).click();
			}
			
			driver.findElement(By.xpath("//button[contains(text(),'save')]")).click();
		//	driver.switchTo().frame("//body/div[3]/md-dialog[1]");
			driver.findElement(By.xpath("//*[@id=\"input_5\"]")).sendKeys("save workout");
			driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("//body[1]/section[3]/md-sidenav[1]/div[1]/md-content[1]/ul[1]/sidenav-section[1]/ul[1]/li[2]/button[1]/div[1]")).click();
			System.out.println(driver.findElement(By.xpath("//h4")).getText());
}
}