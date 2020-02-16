
package com.org.tests;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.org.pages.LibraryPage;
import com.org.utility.StartApplication;


public class ZyLabLibraryTests extends StartApplication {

	public static Logger logger = Logger.getLogger(ZyLabLibraryTests.class.getName());

	 
	LibraryPage lib_page;
	
//@Test
public void LibraryPageHeaderCheck() {
	preSteps();
	lib_page.LibraryPageHeaderCheck();
}
 
//@Test
public void LibraryMenuChecks() {
	preSteps();
	lib_page.LibraryPageMenuLinkBooksCheck();
	lib_page.LibraryPageMenuLinkAuthorsCheck();
}
//@Test
public void WhenNoBooksIsSelected() {
	preSteps();
	lib_page.NoBooksSelectedTextCheck();
	}

/*
//@Test//Need to correct this one
public void MenuLinkBooksClick() {
	preSteps();
	lib_page.ClickLinkBooksInMenu();
}*/

//@Test
public void FilterTextBoxCheck() {
	//System.out.println(driver.findElement(By.xpath("//div[@class='mat-form-field-infix']/span//span")).getText());
	preSteps();
	lib_page.FilterTextBoxAvailabilityCheck();
}
//@Test
public void ListingBooksDisplayCheck() {
	preSteps();
	lib_page.DisplayAllBooks();
}

//@Test//Fail
public void UserAbleToDeleteBooks() {
	preSteps();
	lib_page.DeleteBookCheck();
}

//Able to search books
//@Test
public void UserSearchBookFromFilters() {
	preSteps();
	lib_page.SearchBooksUsingFilters();
	
	
}
//@Test
public void InvalidSearchBookFromFilters() {
	preSteps();
	lib_page.SearchBooksWithInvalidText();
}

//@Test//Title,Author,publisher,year of publishing is shown
public void BookDetailsLabelsDisplayCheck() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.VerifyBookDetailsLabelCheck();
}
@Test//Title,Author,publisher,year of publishing is shown
public void BookDetailsTextBoxDetailDisplay() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.VerifyBookDetailsTextCheck();
}

	private void preSteps() {
		lib_page = new LibraryPage(driver);
	}


}
