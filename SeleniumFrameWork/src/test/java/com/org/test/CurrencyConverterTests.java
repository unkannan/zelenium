
package com.org.test;

import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.pages.CurrencyConverterPage;
import com.org.pages.CurrencyConverterResultsPage;
import com.org.utility.StartApplication;


@Test(groups = "CurrencyConverter")
public class CurrencyConverterTests extends StartApplication {

	public static Logger logger = Logger.getLogger(CurrencyConverterTests.class.getName());

	 
	CurrencyConverterPage currencyConverterPg;
		CurrencyConverterResultsPage ResultsPg;
	
	@Test(dataProvider = "CurrencyInput")
	public void tc_01_currencyConversionValidation(String sourceCountryCurrency, String targetCountryCurrency,String ConvertedToCurrencyResults) {
		preSteps();
		driver.get("https://transferwise.com/ie/currency-converter/");
		currencyConverterPg.CurrencyConverterMainPageHeaderCheck();
			currencyConverterPg.selectSourceCurrency(sourceCountryCurrency);
				currencyConverterPg.selectTargetCurrency(targetCountryCurrency);
					currencyConverterPg.clickOnButton(CurrencyConverterPage.ConvertButton);
						
					ResultsPg.CurrencyConverterResultsPageHeaderCheck(sourceCountryCurrency,targetCountryCurrency);
							ResultsPg.SourceCurrencyValidateResults(sourceCountryCurrency);
								ResultsPg.TargetCurrencyValidateResults(ConvertedToCurrencyResults);
	}

	private void preSteps() {
		currencyConverterPg = new CurrencyConverterPage(driver);
			ResultsPg=new CurrencyConverterResultsPage(driver);
	}

	@DataProvider(name = "CurrencyInput")
	public Object[][] CurrencySelection() {
		return new Object[][] {
			// @formatter:off
			{ "EUR", "USD","1.11210 USD" }
			//,
			//{ "INR", "USD","0.01412 USD" }, 
			//{ "GBP", "INR","87.50680 INR" },
			//{ "CAD", "MXN","14.66340 MXN" },
			//{ "AUD", "NZD","1.07160 NZD" } 
			// @formatter:on
		};
	}

}
