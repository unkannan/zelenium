 
package com.org.pages;

import static org.testng.Assert.assertEquals;

import com.org.utility.UIOperation;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class BooksListPage extends UIOperation {

     static Logger logger = Logger.getLogger(BooksListPage.class.getName());

   
    public static final String ConvertButton = "convert";
    public static final String HEADING = "Welcome to our Library!";
	public static final String convertButton = null;

    private String xpathHeading = "//h3[contains(text(),'Welcome to our Library!')]";//ConverterPage Header
    private String idSourceCurrencySelectDropDown = "sourceCurrency";
    private String idTargetCurrencySelectDropDown = "targetCurrency";
  
    private String xpathSearchBox = "//input[@placeholder='Search...']";
    private String xpathTargetSearchBox="//input[@placeholder='Search...']";

    WebDriver driver;

    public BooksListPage(WebDriver driver) {
        super(driver);
        this.driver = driver; 
    }

    /**
     * This function is to assert Converter Main page heading.
     */
    public void BooksListPageMainPageHeaderCheck() {
       // waitForElement(driver,xpathHeading);
        String actualHeading =driver.findElement(By.xpath(xpathHeading)).getText(); 
        		//assertAndGetText(xpathHeading);
        System.out.println(actualHeading);
        logger.info("# Convert Page Header " + actualHeading);
        assertEquals(actualHeading, HEADING,
            "Actual heading '" + actualHeading + "' should be same as expected heading '" + HEADING
                + "'.");
    }

 
    
    /**
     * This function is to select currencies for source country
     */
    public void selectSourceCurrency(String selectSourceCurrency) {
    	waitForElementID(idSourceCurrencySelectDropDown);
    		setDropDownValue(idSourceCurrencySelectDropDown,xpathSearchBox,selectSourceCurrency);
    			logger.info("# Source From Drop Down Selected " + selectSourceCurrency);
    }
    
    /**
     * This function is to select currencies for target countryr
     */
    public void selectTargetCurrency(String selectTargetCurrency) {
    	waitForElementID(idTargetCurrencySelectDropDown);
    		setDropDownValue(idTargetCurrencySelectDropDown,xpathTargetSearchBox,selectTargetCurrency);
    			logger.info("# Source From Drop Down Selected " + selectTargetCurrency);
    }
   
    /**
     * This function is to click on the id present on Currency Converter page.
     */
	public void clickOnButton(String id) {
	        waitForElementID(id);
	        assertAndClickID(id);
	        logger.info("# Clicked on button: " + id);
	}

	
}
