 
package com.org.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.org.utility.UIOperation;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class NuvasiveLoginPage extends UIOperation {

     static Logger logger = Logger.getLogger(NuvasiveLoginPage.class.getName());

    public static final String HEADING = "Welcome";
    public static final String ToOurSiteHeadingText = "To Our Site";
    public static final String LoginText = "Login";
    public static final String CharacterCountText = "Character Count";
    
    public static final int LoginFrameIndex=0;
    public static final String convertButton = null;
    
    private String xpathHeading = "//span[contains(text(),'Welcome')]";//Nuvasive Page Header
    private String xpathToOurSite = "//font[contains(text(),'To Our Site')]";;
    private String xpathLoginLink = "//a[contains(text(),'Login')]";
    private String xpathCharacterCountLink ="//a[contains(text(),'Character Count')]";
   // private String xpathUsernameTextBox ="//*[@id=\"dest\"]/div/form/div[1]/input";
   // private String xpathPasswordTextBox ="//*[@id=\"dest\"]/div/form/div[2]/input";
    private String LocUsernameTextBox ="username";
    private String LocPasswordTextBox ="password";
    private String LocSubmitButton="submit";
    private String typeAtrribute="type";
    WebDriver driver;

    public NuvasiveLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver; 
    }

    /**
     * This function is to Verify the Nuvasive Welcome Page Header.
     */
    public void NuvasiveLoginPageMainPageHeaderCheck() {
        waitForElement(xpathHeading);
        String actualHeading = assertAndGetText(xpathHeading);
        logger.info("# Login Page " + actualHeading);
        assertEquals(actualHeading, HEADING,"Actual heading '" + actualHeading + "' should be same as expected heading '" + HEADING+ "'.");
    }
    
    /**
     * This function is to Verify the Nuvasive main Page to out site text.
     */
    public void ToOurSiteHeaderAvailable() {
		 waitForElement(xpathToOurSite);
        String actualHeading = assertAndGetText(xpathToOurSite);
        logger.info("# Login Page " + actualHeading);
        assertEquals(actualHeading, ToOurSiteHeadingText,"Actual heading '" + actualHeading + "' should be same as expected heading '" + ToOurSiteHeadingText+ "'.");
	}

	public void LoginLinkAvailabilityCheck() {
		waitForElement(xpathLoginLink);
        String actualHeading = assertAndGetText(xpathLoginLink);
        logger.info("# Login Page " + actualHeading);
        assertEquals(actualHeading, LoginText,"Actual heading '" + actualHeading + "' should be same as expected heading '" + LoginText+ "'.");
		
	}

	public void CharacterCountLinkAvailabilityCheck() {
		waitForElement(xpathCharacterCountLink);
        String actualHeading = assertAndGetText(xpathCharacterCountLink);
        logger.info("# Login Page " + actualHeading);
        assertEquals(actualHeading, CharacterCountText,"Actual heading '" + actualHeading + "' should be same as expected heading '" + CharacterCountText+ "'.");
	}

	public void UserNamePasswordTextBoxAvailabilityCheck() {
		SwitchFrameToLogin(LoginFrameIndex);
		waitForElementName(LocUsernameTextBox);
				logger.info("# Login Page UserName Field Availability Check");
					assertTrue(isElementNamePresent(LocUsernameTextBox), "Element LoginTextbox not found.");
				
					waitForElementName(LocPasswordTextBox);
					logger.info("# Login Page Password Field Availability Check");
						assertTrue(isElementNamePresent(LocPasswordTextBox), "Element PasswordTextbox not found.");
	}
	public void SubmitButtonAvailabilityCheck() {
		SwitchFrameToLogin(LoginFrameIndex);
			waitForElementName(LocSubmitButton);
				logger.info("# Login Page Submit Button Availability Check");
					assertTrue(isElementNamePresent(LocSubmitButton), "Element SubmitButton not found.");
	}
	
	public void SubmitButtonisClickable() {
		SwitchFrameToLogin(LoginFrameIndex);
			waitForElementName(LocSubmitButton);
				logger.info("# Login Page Submit Button is Clickable Check");
					assertTrue(waitForElementNameClickable(LocSubmitButton), "Element SubmitButton not found.");
	}
	public void ClickLoginLink() {
			waitForElement(xpathLoginLink);
				logger.info("# Login Page Login Link click");
					clickLoginlink(xpathLoginLink);
	}	
	public void LoginCredentialsProvision(String Username,String Password) {
		SwitchFrameToLogin(LoginFrameIndex);
		assertAndTypeLocName(LocUsernameTextBox,Username);
		assertAndTypeLocName(LocPasswordTextBox,Password);
		logger.info("# Login Page Credentials provisions");
				 
}	
	public void SubmitButtonClick() {
		waitForElementName(LocSubmitButton);
			logger.info("# Login Page Submit Button click");
				ClickButtonByname(LocSubmitButton);
}	
	public void UsernamePasswordTypeCheck() {
		waitForElementName(LocSubmitButton);
			logger.info("# Login Page Username Type Check");
				String usernameType=getElementAttribute(LocUsernameTextBox,typeAtrribute);
				assertEquals(usernameType, "text","Actual heading '" + usernameType + "' should be same as expected heading '" + "text"+ "'.");
				logger.info("# Login Page Password Type Check");
				String passwordType=getElementAttribute(LocPasswordTextBox,typeAtrribute);
				assertEquals(passwordType, "password","Actual heading '" + passwordType + "' should be same as expected heading '" + "password"+ "'.");
}	
	
}
