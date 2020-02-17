
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


//@Test//Need to correct this one
public void MenuLinkBooksClick() {
	preSteps();
	lib_page.ClickLinkBooksInMenu();
}

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

//@Test//Title,Author,publisher,year of publishing is shown
public void BookDetailsTextValuesCheck() throws InterruptedException {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.VerifyBookDetailsTextCheck();
	//lib_page.mandatoryCheck();
}

//@Test
public void ButtonsAvailabilityCheck() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.ButtonAvailableCheck();
	lib_page.ButtonInitialDisableCheck();
}

//@Test
public void BookDetailsMandatoryCheck() {
	preSteps();
	lib_page.BookSelectLolita();
	lib_page.mandatoryCheck();
}

//@Test
public void BookDetailsNonMandatoryFieldCheck() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.NonmandatoryCheckAuthorField();
}

//@Test
public void ModifyBookDetails() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.ModifyAllbookDetails();
	lib_page.clickSave();
	lib_page.BookSelectdesertSolitaire();
	lib_page.BookSelectGeekLove();
	lib_page.ValidateModifiedBookDetails();
}
//@Test

//@Test
public void ModifyPublisherBookDetails() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.PublisherTextModify();
	lib_page.clickSave();
	lib_page.BookSelectdesertSolitaire();
	lib_page.BookSelectGeekLove();
	lib_page.ValidateModifiedpublisherDetails();
}

//@Test
public void LargeCharsEntryBookDetailsCheck() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.LargeCharactersEnterInBookDetaisl();
	lib_page.clickSave();
}

@Test
public void CancelButtonFunctionalityCheck() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.ModifyAllbookDetails();
	lib_page.clickCancel();
	lib_page.AlertShownYearRequired();
	
}

//@Test
public void YearofPublishingEnterAlphaNumeric() {
	preSteps();
	lib_page.BookSelectGeekLove();
	lib_page.EnterAlphaNumbericCharacInYearofPublishing();
	lib_page.clickSave();
	lib_page.AlertShownYearRequired();
	
}
private void preSteps() {
		lib_page = new LibraryPage(driver);
	}


}
