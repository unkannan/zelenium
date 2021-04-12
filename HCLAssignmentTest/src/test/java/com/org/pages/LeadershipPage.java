package com.org.pages;

import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.org.enums.AppValidationConstantMessages;

public class LeadershipPage {
	static Logger logger = Logger.getLogger(LeadershipPage.class.getName());

    private String xpathShivNadarText = "//h4[contains(text(),'Shiv Nadar')]";
    private String xpathShivNadarImage="//body/div[5]/div[1]/div[4]/div[1]/div[1]/div[1]/img[1]";
    private String srcAttributeName="src";
    private String FileName="ShivNadar.png";
    
  
    WebDriver driver;

    public LeadershipPage(WebDriver driver) {
        this.driver = driver; 
    }
    
    public String ShivNadarTextCheck() {
		 logger.info("# Retreiving Shiv Nadar text");
		 String actualResult=driver.findElement(By.xpath(xpathShivNadarText)).getText();
		 return actualResult;
    }

	public void savePhoto() {
		try {
			logger.info("# declared the log for ShivNadar Image");
		     WebElement logo = driver.findElement(By.xpath(xpathShivNadarImage));
		     logger.info("# Retrieving src Attribute url");
		     String logoSRC = logo.getAttribute(srcAttributeName);
		     
		     URL imageURL = new URL(logoSRC);
		     logger.info("# Reading the image to save");
		     BufferedImage saveImage = ImageIO.read(imageURL);
		     
		     logger.info("# Saving the Image to Target Folder");
		     ImageIO.write(saveImage, AppValidationConstantMessages.getFileType(), new File(AppValidationConstantMessages.getScreenshotLocation()+FileName));
		     
		     } catch (Exception e) {
		        e.printStackTrace();
		     } finally {
		        driver.close();
		     }
	}

     

}
