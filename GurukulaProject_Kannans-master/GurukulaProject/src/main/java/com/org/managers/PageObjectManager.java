package com.org.managers;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class PageObjectManager {
	public static WebDriver driver;
	@Before
	public static void runBefore(Scenario scenario)
	    {
		WebDriverManager webdrivermanager=new WebDriverManager();
		 driver=webdrivermanager.getDriver();
		 driver.get("http://127.0.0.1:8080");	
	    }
	  //  @After
	    public static void runAfter()
	    {
	    System.out.println("do noting");
	    }
		public static WebDriver getDriver() {
			//WebDriverManager webdrivermanager=new WebDriverManager();
			// driver=webdrivermanager.getDriver();
			 return driver;
		}

	}
