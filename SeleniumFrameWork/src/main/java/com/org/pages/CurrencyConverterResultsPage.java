 
package com.org.pages;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.utility.UIOperation;

 
public class CurrencyConverterResultsPage extends UIOperation {

    static Logger logger = Logger.getLogger(CurrencyConverterResultsPage.class.getName());

    public static final String HEADING = "Welcome to Gurukula!";

    WebDriver driver;

    public static String xpathHeading = "//h1";
    private String xpathSourceCurrency = "//h3[@class='cc__source-to-target m-t-2']/span[2]"; 
    private String xpathTargetCurrency = "//h3[@class='cc__source-to-target m-t-2']/span[3]";
    
    public CurrencyConverterResultsPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    /**
     * This function is to assert Converter Main page heading.
     */
    public void CurrencyConverterResultsPageHeaderCheck(String sourceCurrency,String targetCurrency) {
        waitForElement(xpathHeading);
        String actualHeading = assertAndGetText(xpathHeading);
        System.out.println(actualHeading);
        logger.info("# Convert Page Header " + actualHeading);
        assertEquals(actualHeading, sourceCurrency+" to "+targetCurrency,
            "Actual heading '" + actualHeading + "' should be same as expected heading '" + sourceCurrency+" to "+targetCurrency
                + "'.");
    }
    /**
     * This function is to assert the Source currency validation results.
     */
    public void SourceCurrencyValidateResults(String SourceCurrency) {
		waitForElement(xpathSourceCurrency);
		 String actualSourceCurrencyResults = assertAndGetText(xpathSourceCurrency);
	        logger.info("# Actual Source Currency results " + actualSourceCurrencyResults.substring(0, 5));
	        assertEquals(actualSourceCurrencyResults.substring(0, 5), "1 "+SourceCurrency,
	            "Actual heading '" + actualSourceCurrencyResults.substring(0, 5) + "' should be same as expected heading '" + "1 "+SourceCurrency
	                + "'.");
	}
    /**
     * This function is to assert the target currency validation results.
     */
	public void TargetCurrencyValidateResults(String ExpectedConvertedToCurrencyResults) {
		waitForElement(xpathTargetCurrency);
		 String actualTargetCurrencyResults = assertAndGetText(xpathTargetCurrency);
	        logger.info("# Actual Target Currency results " + actualTargetCurrencyResults);
	        	
	        String ActualCurrencyConvertedAmount= actualTargetCurrencyResults.substring(0,4);
	        	int ActualCurrencylen=actualTargetCurrencyResults.length();
	        	    String ActualtargetCurrencyCountry=actualTargetCurrencyResults.substring(ActualCurrencylen-3,ActualCurrencylen);
	        		
	        	    String ExpectedCurrencyConvertedAmount= ExpectedConvertedToCurrencyResults.substring(0,4);
	        	    	int ExpectedCurrencylen=ExpectedConvertedToCurrencyResults.length();
	        	    		String ExpectedtargetCurrencyCountry=ExpectedConvertedToCurrencyResults.substring(ExpectedCurrencylen-3,ExpectedCurrencylen);
	        	    	
	        
	        assertEquals(ActualCurrencyConvertedAmount+" "+ActualtargetCurrencyCountry,ExpectedCurrencyConvertedAmount+" "+ExpectedtargetCurrencyCountry,
	            "Actual heading '" + ActualCurrencyConvertedAmount+" "+ActualtargetCurrencyCountry + "' should be same as expected heading '" + ExpectedCurrencyConvertedAmount+" "+ExpectedtargetCurrencyCountry
	                + "'.");
	}
	 //[1.07160 NZD] but found [1.07084 NZD]
 
}
