package com.org.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import com.org.pages.BranchesPage;
import com.org.pages.UpdatePasswordPage;

import cucumber.api.DataTable;



public class FunctionLibrary {
	static Logger logger=LoggerHelper.getLogger(FunctionLibrary.class);
	
	public static final long WaitTime = 50;
	 
	 
	protected void waitForElement(By password,WebDriver driver) {
        new WebDriverWait(driver, WaitTime)
            .until(ExpectedConditions.presenceOfElementLocated(password));
    }
	
	public static void MessageValidation(String logMsg, String Actual, String Expected) {
		logger.info(logMsg);
		logger.info("ExpectedResult is "+Expected);
		logger.info("ActualResult is "+Actual);
		assertEquals(Expected,Actual);
	}
	
	public void commonWaitToLoad(WebDriver driver, int waitTime) {
		  driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public boolean commonWaitToFindElement(WebDriver driver,
			   int timeOutInSeconds, String findElementBy, String expr)
			   throws TimeoutException {
			  boolean result = false;
			  WebElement element = null;
			  try {
			   // Element is Click able - it is Displayed and Enabled.
			   WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			   // TODO - Use Switch case, move to Java 1.7
			   if (findElementBy.equals("xpath")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .xpath(expr)));
			   } else if (findElementBy.equals("id")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .id(expr)));
			   } else if (findElementBy.equals("cssSelector")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .cssSelector(expr)));
			   } else if (findElementBy.equals("className")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .className(expr)));
			   } else if (findElementBy.equals("linkText")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .linkText(expr)));
			   }

			   if (element != null) {
			    result = true;
			   } else {
			    result = false;
			   }
			  } catch (TimeoutException e) {
			   logger.info(
			     "TimeoutException in commonWaitToFindElement for :"
			       + e.getMessage(), e);
			  }
			  return result;
			 }
	
	public String commonWaitToFindElement_GetText(WebDriver driver,
			   int timeOutInSeconds, String findElementBy, String expr)
			   throws TimeoutException {

			  String elementText = null;
			  WebElement element = null;
			  try {
			   // Element is Click able - it is Displayed and Enabled.
			   WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);

			   // TODO - Use Switch case, move to Java 1.7
			   if (findElementBy.equals("xpath")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .xpath(expr)));
			   } else if (findElementBy.equals("id")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .id(expr)));
			   } else if (findElementBy.equals("cssSelector")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .cssSelector(expr)));
			   } else if (findElementBy.equals("className")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .className(expr)));
			   } else if (findElementBy.equals("linkText")) {
			    element = wait.until(ExpectedConditions.elementToBeClickable(By
			      .linkText(expr)));
			   }

			   if (element != null) {
			    elementText = element.getText();
			   }
			  } catch (NoSuchElementException e) {
				  logger.info(
			     "NoSuchElementException in commonWaitToFindElement_GetText for :"
			       + e.getMessage(), e);
			  } catch (TimeoutException e) {
				  logger.info(
			     "TimeoutException in commonWaitToFindElement_GetText for :"
			       + e.getMessage(), e);
			  } catch (Exception e) {
				  logger.info(
			     "Exception in commonWaitToFindElement_GetText for :"
			       + e.getMessage(), e);
			  }
			  return elementText;
			 }
	
	
		public WebElement commonFindElement_GetElement(WebDriver driver,
			   String findElementBy, String expr) throws TimeoutException {

			  WebElement element = null;
			  try {

			   // TODO - Use Switch case, move to Java 1.7
			   if (findElementBy.equals("xpath")) {
			    element = driver.findElement(By.xpath(expr));
			   } else if (findElementBy.equals("id")) {
			    element = driver.findElement(By.id(expr));
			   } else if (findElementBy.equals("cssSelector")) {
			    element = driver.findElement(By.cssSelector(expr));
			   } else if (findElementBy.equals("linkText")) {
			    element = driver.findElement(By.linkText(expr));
			   } else if (findElementBy.equals("className")) {
			    element = driver.findElement(By.className(expr));
			   }
			  } catch (NoSuchElementException e) {
				  logger.info(
			     "NoSuchElementException in commonWaitToFindElement for :"
			       + e.getMessage(), e);
			  } catch (TimeoutException e) {
				  logger.info(
			     "TimeoutException in commonWaitToFindElement for :"
			       + e.getMessage(), e);
			  } catch (Exception e) {
				  logger.info(
			     "Exception in commonWaitToFindElement for :"
			       + e.getMessage(), e);
			  }
			  return element;
			 }
	
		public void commonClick(WebElement iclickInfo){
				  try {
				   iclickInfo.click();
				   Thread.sleep(100);
				  } catch (Exception e) {
					  logger.info(
				     "Exception in commonClick:" + e.getMessage(), e);
				  }
				 }
	
		public void commonClick_Action(WebDriver driver,WebElement iclickInfo) {
				
				  try {
				   Actions builder = new Actions(driver);
				   builder.click(iclickInfo).build().perform();
				   Thread.sleep(1000);
				  } catch (Exception e) {
				   logger.info(
				     "Exception in commonClick_Action:" + e.getMessage(), e);
				  }
				 }
		public boolean commonSetTextTextBox(WebElement iTextBoxInfo, String sText) {

				  boolean result = false;
				  try {
				   iTextBoxInfo.click();
				   iTextBoxInfo.clear();
				   iTextBoxInfo.sendKeys(sText);
				   logger.info(sText+ " text Entered in textbox");
				   result = true;
				   
				   // VP>>>Verify that value has been entered
				  // result = commonVerifyValueTextBox(iTextBoxInfo, sText);

				  } catch (Exception ex) {
				   result = false;
				   logger.info(
				     "Exception in commonSetTextTextBox:" + ex.getMessage(), ex);
				   result = false;
				  }
				  return result;
				 }
		
		 public boolean commonVerifyValueTextBox(WebElement iTextBoxInfo,
				   String sExpectedValue)   {

				  String sTempStr = null;
				  boolean result = false;

				  try {
				   sExpectedValue = sExpectedValue.trim().toLowerCase();
				   logger.info(
						     "Expected Results is :" + sExpectedValue);
				   sTempStr = iTextBoxInfo.getAttribute("value").trim().toLowerCase();
				   logger.info(
						     "Actual Text in text field is :" + sTempStr);
				   // VP >>> Verify that Actual Value contains the expected value
				   if ((sTempStr.contains(sExpectedValue))) {
				    result = true;
				   } else {
				    result = false;
				   }
				  } catch (Exception e) {
					  logger.info(
				     "Exception in commonSetTextTextBox:" + e.getMessage(), e);
				   result = false;
				  }
				  return result;
				 }
		 
		 public boolean commonVerifyLabelText(WebElement controlInfo,
				   String sExpectedText) {
				  boolean Result;
				  String sTemp = null;

				  try {
				   sTemp = controlInfo.getText().trim().toLowerCase();
				   	logger.info("Actual Text is "+ sTemp);
				    logger.info("Expected Text is "+ sExpectedText.toLowerCase());
				   if (sTemp.contains(sExpectedText.toLowerCase())) {
				    Result = true;
				    logger.info("Validation of message is working fine");
				   } else {
				    Result = false;
				   }
				  } catch (Exception e) {
					  logger.info("Expected Text is "+ sExpectedText.toLowerCase());
					  logger.info(
				     "Exception in commonVerifyLabelText:" + e.getMessage(), e);
					  return false;
					//  logger.info("Actual Text is "+ sTemp);
					    
				  // Result = false;
				  }
				  return Result;
				 }
		 public void commonClick_MenuItem(WebDriver driver,WebElement menu,
				   WebElement subMenu) {

				  try {
				   commonClick_Action(driver,menu);
				   Thread.sleep(500);
				   JavascriptExecutor executor = (JavascriptExecutor) driver;
				   executor.executeScript("arguments[0].click();", subMenu);

				  } catch (Exception e) {
					  logger.info(
				     "Exception in commonClick_MenuItem:" + e.getMessage(), e);
				  }
				 }
		
		 public boolean ApplicationWarningMessageValidation(WebElement Element,String Entertext,WebElement MsgFieldElement, String ExpectedMessage) {
			 commonSetTextTextBox(Element, Entertext);
			 Boolean ExpectedResultsShown= commonVerifyLabelText(MsgFieldElement,ExpectedMessage);
			 return ExpectedResultsShown;
		 }
		 
		 
		//Do mouse-hovers
	public static void MouseOver(WebDriver driver,WebElement we){
		Actions actObj=new Actions(driver);
		actObj.moveToElement(we).build().perform();
	}
	
	//Take Snapshot for analysing the failures
	public static String fn_TakeSnapshot(WebDriver driver, String DestFilePath) {
		String TS=fn_GetTimeStamp();
		TakesScreenshot tss=(TakesScreenshot) driver;
		File srcfileObj= tss.getScreenshotAs(OutputType.FILE);
		DestFilePath=DestFilePath+TS+".png";
		File DestFileObj=new File(DestFilePath);
		
		try {
			FileUtils.copyFile(srcfileObj, DestFileObj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return DestFilePath;
		}
	
	//Get current Time-stamp
	public static String fn_GetTimeStamp(){
		DateFormat DF=DateFormat.getDateTimeInstance();
		Date dte=new Date();
		String DateValue=DF.format(dte);
		DateValue=DateValue.replaceAll(":", "_");
		DateValue=DateValue.replaceAll(",", "");
		return DateValue;
		}
	public Boolean CommonSelectDropDown(WebElement ele,String strText) { 
		List<WebElement> options = ele.findElements(By.tagName("option"));
		for (WebElement option : options) {
		    logger.info(option.getText());
		    if(strText.equals(option.getText())) {
		        option.click(); 
		        return true;
		}
		}
		return false;
	}
	/*
	public void commonWebTableRead(WebElement ele) { 
	WebElement mytable = driver.findElement(By.xpath("//table[@class='table table-striped']//tbody"));
	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	int rows_count = rows_table.size();
	for (int row = 0; row < rows_count; row++) {

		   //To locate columns(cells) of that specific row.
		   List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));

		   //To calculate no of columns(cells) In that specific row.
		   int columns_count = Columns_row.size();
		   System.out.println("Number of cells In Row " + row + " are " + columns_count);

		   //Loop will execute till the last cell of that specific row.
		   for (int column = 0; column < columns_count; column++) {
		    //To retrieve text from the cells.
		    String celltext = Columns_row.get(column).getText();
		    System.out.println("Cell Value Of row number " + row + " and column number " + column + " Is " + celltext);
		   }
		}
	}
	*/
	public Boolean commonWebTableVerifyText(WebElement ele,String srText1, String srText2) { 
		WebElement mytable = ele;//driver.findElement(By.xpath("//table[@class='table table-striped']//tbody"));
		List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row = 0; row < rows_count; row++) {

			   //To locate columns(cells) of that specific row.
			   List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			   //To calculate no of columns(cells) In that specific row.
			   int columns_count = Columns_row.size();

			   //Loop will execute till the last cell of that specific row.
			   for (int column = 0; column < columns_count; column++) {
			    //To retrieve text from the cells.
			    String celltext = Columns_row.get(column).getText();
			    if (Columns_row.get(column).getText().equals(srText1) && Columns_row.get(column+1).getText().equals(srText2)) {
			    	 logger.info("In Branches list "+srText1+ " Name is available and " +srText2+ " code is available");
			    	 return true;	
			    }
		}
	}
		return false;
	}
	public Boolean commonWebTableVerifyText(WebElement ele,String srText1) { 
		WebElement mytable = ele;//driver.findElement(By.xpath("//table[@class='table table-striped']//tbody"));
		List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row = 0; row < rows_count; row++) {

			   //To locate columns(cells) of that specific row.
			   List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			   //To calculate no of columns(cells) In that specific row.
			   int columns_count = Columns_row.size();

			   //Loop will execute till the last cell of that specific row.
			   for (int column = 0; column < columns_count; column++) {
			    //To retrieve text from the cells.
				  // logger.info("In Branches list "+srText1);
				 
			    String celltext = Columns_row.get(column).getText();
			   // logger.info("celltext "+celltext);
			    if (celltext.equalsIgnoreCase(srText1)) {
			    	 logger.info(srText1+ " Name is available");
			    	 return true;	
			    }
		}
	}
		return false;
	}

	public String commonGetTextWebTable(WebElement ele) {
		WebElement mytable = ele;//driver.findElement(By.xpath("//table[@class='table table-striped']//tbody"));
		List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row = 0; row < rows_count; row++) {
			   //To locate columns(cells) of that specific row.
			   List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			   int columns_count = Columns_row.size();
	  			    String celltext = Columns_row.get(1).getText();
			   	    	 return celltext;	
			    }
			return null;
			   }
		
	
}
		

