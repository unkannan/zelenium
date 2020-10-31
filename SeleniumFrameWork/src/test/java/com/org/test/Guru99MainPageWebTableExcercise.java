package com.org.test;


import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.org.utility.ConfigFileReader;
import com.org.utility.StartApplication;

import junit.framework.Assert;

import com.org.pages.CurrencyConverterPage;
import com.org.pages.CurrencyConverterResultsPage;
import com.org.pages.Guru99MainPage;

public class Guru99MainPageWebTableExcercise extends StartApplication{
	private static Properties prop = ConfigFileReader.ReadProperties();
	Guru99MainPage Guru99MainPage;
	
	private void preSteps() {
		Guru99MainPage=new Guru99MainPage(driver);
	}
	
	//@Test
	public void VerifyListSize() {
		preSteps();
		int size=Guru99MainPage.getListSize();
		assertEquals(size, 2);
		}
	
	//@Test
	public void listAllElementsSize() {
		preSteps();
			String[] expectedResults= {"first cell","second cell","third cell","fourth cell"};
				
			String[] listsizeActual=Guru99MainPage.WebTableElementsCheck();
				assertEquals(listsizeActual, expectedResults);
		}
}
