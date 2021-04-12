package org.project.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CurrencyConverterMainPage {

	  public String headerXpath="//h1[contains(text(),'Currency Converter')]";
	  public String TitleExpected="Currency Converter";
	  public String SrcCurrencyXpath="";
	  public String TargetCurrencyXpath="";
	  public String currenconvertButtonxpath="xpath";
	  
	  static Logger logger = Logger.getLogger(CurrencyConverterMainPage.class.getName());
	  WebDriver driver;
	  
	  public CurrencyConverterMainPage(WebDriver driverfromTestmethods) {
		  driver=driverfromTestmethods;
	  }
	  public String getHeader() {
		  //UIOperation.gettitle(xpath);
		  String title=driver.findElement(By.xpath(headerXpath)).getText();
		  logger.info("The title of the page is "+title);
		  return title;
	  }
	  
	  public void currencyConverterButton() {
		  driver.findElement(By.xpath(currenconvertButtonxpath)).click();
	  }

	}

