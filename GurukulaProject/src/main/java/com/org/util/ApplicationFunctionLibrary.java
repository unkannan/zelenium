package com.org.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.org.util.FunctionLibrary;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ApplicationFunctionLibrary extends FunctionLibrary {
	static Logger logger=LoggerHelper.getLogger(ApplicationFunctionLibrary.class);
	
	//private static final String MoreThanFiftycharslengthWarningMessageForLoginstr="Your login cannot be longer than 50 characters.";
	
	public void MandatoryFieldWarningMessageValidation
	    (WebElement Element, String strpassword) {
		Element.sendKeys(strpassword);
		 
	}
	public void FiveCharsWarningMessageValidation
    (WebElement Element, String strpassword) {
	Element.sendKeys(strpassword);
}
	
	public boolean ApplicationWarningMessageValidation(WebElement Element,String Entertext,WebElement MsgFieldElement, String ExpectedMessage) {
		  commonSetTextTextBox(Element, Entertext);
		 Boolean ExpectedResultsShown= commonVerifyLabelText(MsgFieldElement,ExpectedMessage);
		 return ExpectedResultsShown;
	 }
	 
		 
		 public void PasswordStrengthCheck(WebElement element,WebElement StrengthRed,WebElement StrengthOrange,WebElement StrengthGreen,
				 String RedPassword,String OrangePassword,String GreenPassword) {
			 logger.info("Password Strengths Validation is in progress");
			 //element(RedPassword);
			 commonSetTextTextBox(element,RedPassword);
			 String RedColorEnable=StrengthRed.getCssValue("Background");
			 
			 logger.info(StrengthRed.getCssValue("Background"));
			 if(RedColorEnable.contains("rgb(255, 0, 0)")) {
				 	 RedColorEnable = "RedEnabled";
				 	logger.info("RedColor is enabled");
				 	}
			 commonSetTextTextBox(element,OrangePassword);
			 logger.info(StrengthOrange.getCssValue("Background"));
			 String OrangeColorEnable=StrengthOrange.getCssValue("Background"); 
			  if(OrangeColorEnable.contains("rgb(255, 153, 0)")) {
				  OrangeColorEnable = "OrangeEnabled";
				  logger.info("Orange Color is enabled");
			 	}
			  
			  commonSetTextTextBox(element,GreenPassword);
			  logger.info(StrengthGreen.getCssValue("Background"));
			  String GreenColorEnable=StrengthGreen.getCssValue("Background"); 
			  if(GreenColorEnable.contains("rgb(153, 255, 0)")) {
				  GreenColorEnable = "GreenEnabled";
				  logger.info("Green Color is enabled");
			  }
			  if(RedColorEnable.equals("RedEnabled") && OrangeColorEnable.equals("OrangeEnabled") && GreenColorEnable.equals("GreenEnabled"))
				  assertTrue(true);
				   
			  else
				  assertTrue(false);
		 }

		 public Boolean CannotEnterMoreThanfiftyChars(WebElement ele,String sText) {
			logger.info("Total Text length user tries to Enter "+sText.length()+sText.length());
			commonSetTextTextBox(ele, sText+sText); 
			String eleInTheTextBox=ele.getAttribute("value");
			logger.info("Text Box showin up is "+ele.getAttribute("value"));
			logger.info("Total count of text showing up in Texbox is "+eleInTheTextBox.length());	
			if(eleInTheTextBox.length()==50)
				return true;
			return false;
		}  
	  
	 
}
