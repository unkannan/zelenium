
package com.org.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.org.enums.AppValidationConstantMessages;
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
			{ "EUR", "INR","1.11210 USD" }
			//,
			//{ "INR", "USD","0.01412 USD" }, 
			//{ "GBP", "INR","87.50680 INR" },
			//{ "CAD", "MXN","14.66340 MXN" },
			//{ "AUD", "NZD","1.07160 NZD" } 
			// @formatter:on
		};
	}

}
