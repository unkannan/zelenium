 
package com.org.pages;

import static org.testng.Assert.assertEquals;

import com.org.utility.UIOperation;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
 
public class CurrencyConverterPage extends UIOperation {

     static Logger logger = Logger.getLogger(CurrencyConverterPage.class.getName());

    public static final String HEADING = "Currency Converter";
    public static final String ConvertButton = "convert";

	public static final String convertButton = null;

    private String xpathHeading = "//h1[contains(text(),'Currency Converter')]";//ConverterPage Header
    private String idSourceCurrencySelectDropDown = "sourceCurrency";
    private String idTargetCurrencySelectDropDown = "targetCurrency";
  
    private String xpathSearchBox = "//input[@placeholder='Search...']";
   // private String xpathSearchBox = "//input[@type='text...']";
    //private String xpathTargetSearchBox="/html[1]/body[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/input[1]";
    private String xpathTargetSearchBox="/html/body/main/section/div[2]/div/div/form/div/div[2]/div/div/div[3]/div/div/div/input";//"//input[@placeholder='Search...']";

    WebDriver driver;

    public CurrencyConverterPage(WebDriver driver) {
        super(driver);
        this.driver = driver; 
    }

    /**
     * This function is to assert Converter Main page heading.
     */
    public void CurrencyConverterMainPageHeaderCheck() {
        waitForElement(xpathHeading);
        String actualHeading = assertAndGetText(xpathHeading);
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
    	//waitForElementID(idSourceCurrencySelectDropDown);
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
