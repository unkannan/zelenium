package com.org.util;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.org.pages.UpdatePasswordPage;



public class ObjectsHelper {
	static Logger logger=LoggerHelper.getLogger(UpdatePasswordPage.class);
	
	public static final long WaitTime = 50;
	public static WebDriver driver;
	public ObjectsHelper(WebDriver driver) {
		this.driver=driver;
	}
	protected void waitForElement(By password) {
        new WebDriverWait(driver, WaitTime)
            .until(ExpectedConditions.presenceOfElementLocated(password));
    }
	
	public static void MessageValidation(String logMsg, String Actual, String Expected) {
		logger.info(logMsg);
		logger.info("ExpectedResult is "+Expected);
		logger.info("ActualResult is "+Actual);
		assertEquals(Expected,Actual);
	}

}
