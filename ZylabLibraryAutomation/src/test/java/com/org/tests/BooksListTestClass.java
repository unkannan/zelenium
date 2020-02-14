
package com.org.tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.org.pages.BooksListPage;
import com.org.utility.StartApplication;


public class BooksListTestClass extends StartApplication {

	public static Logger logger = Logger.getLogger(BooksListTestClass.class.getName());
	
	BooksListPage booklistpg=new BooksListPage(driver);

	@Test
	public void tc_01_PageTitleVerification() {
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Welcome to our Library!')]")).getText()); 
		 booklistpg.BooksListPageMainPageHeaderCheck();
	}

	  
}
