package com.gurukula.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gurukula.utility.Services;

public class TechBeamersPage extends Services {

	WebDriver driver;
	
	 static Logger logger = Logger.getLogger(TechBeamersPage.class.getName());
	 
	 /*Locators*/
	 private String xpathLearnPythonList = "//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]/ul";
	 
	 	/*
	 	 * Constructor to assign the driver
	 	 *  */
		public TechBeamersPage(WebDriver driver) {
			super(driver);
			this.driver=driver;
		}
		
		public void elementsinLearnPythonList() {
		
		driver.get("https://www.techbeamers.com/");
			waitForElement(xpathLearnPythonList);
				List<WebElement> WebTableElement= driver.findElements(By.xpath(xpathLearnPythonList));
			 
				for(WebElement e : WebTableElement) {
					System.out.println(e.getText());
						if(e.getText().equalsIgnoreCase("Selenium Python Tutorial"))
						{	
							logger.info("# Tech Beamers Page > Learn Python Frame: " + e.getText() +" is available" );
							}
					}
			 
		}
		
}
