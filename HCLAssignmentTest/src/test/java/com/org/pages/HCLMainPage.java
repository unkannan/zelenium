 
package com.org.pages;

import com.org.util.StartApplication;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class HCLMainPage extends StartApplication {

     static Logger logger = Logger.getLogger(HCLMainPage.class.getName());

     private static String JavaScriptExecutorElementClick="arguments[0].click()"; 
     
    private String xpathLeaderShipLink = "//body/section[2]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]";
    private String idAllCookiesBtn = "onetrust-accept-btn-handler";
    WebDriver driver;

    public HCLMainPage(WebDriver driver) {
        this.driver = driver; 
    }

    public void clickLeadershipLink() {
    	logger.info("# Click AllCookies Button if available");
    	try {
    		driver.findElement(By.id(idAllCookiesBtn)).click();
    		}
    		catch(Exception e) {
    			logger.info("# Accept All Cookies button is not available");
    			}
    		
    		logger.info("# Click Leadership link");
    		 WebElement ele=driver.findElement(By.xpath(xpathLeaderShipLink));
    		 JavascriptExecutor jse = (JavascriptExecutor)driver;
    		 jse.executeScript(JavaScriptExecutorElementClick, ele); 
    		 logger.info("# Click Leadership link: Success");
    }
   
}
