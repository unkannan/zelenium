
package com.org.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.utility.StartApplication;


public class ZyLabLibraryTests extends StartApplication {

public static Logger logger = Logger.getLogger(ZyLabLibraryTests.class.getName());

	 
	
@Test
public void TC01_LibraryPageHeaderCheck() {
	lib_page.LibraryPageHeaderCheck();
}
 
@Test
public void TC02_LibraryMenuChecks() {
	
	lib_page.LibraryPageMenuLinkBooksCheck();
	lib_page.LibraryPageMenuLinkAuthorsCheck();
}
@Test
public void TC03_WhenNoBooksIsSelected() {
	
	lib_page.NoBooksSelectedTextCheck();
	}

@Test
public void TC04_FilterTextBoxCheck() {
	
	lib_page.FilterTextBoxAvailabilityCheck();
}
@Test
public void TC05_ListingBooksDisplayCheck() {
	
	lib_page.DisplayAllBooks();
}

@Test//Fail
public void TC06_UserAbleToDeleteBooks() {
	
	lib_page.BookSelectdesertSolitaire();
	lib_page.DeleteBookCheck();
}

//Able to search books
@Test
public void TC07_UserSearchBookFromFilters() {
	
	lib_page.SearchBooksUsingFilters();
	
	
}
@Test
public void TC08_InvalidSearchBookFromFilters() {
	
	lib_page.SearchBooksWithInvalidText();
}

@Test//Title,Author,publisher,year of publishing is shown
public void TC09_BookDetailsLabelsDisplayCheck() {
	
	lib_page.BookSelectGeekLove();
	lib_page.VerifyBookDetailsLabelCheck();
}

@Test//Title,Author,publisher,year of publishing is shown
public void TC10_BookDetailsTextValuesCheck() {
	
	lib_page.BookSelectGeekLove();
	lib_page.VerifyBookDetailsTextCheck();
	//lib_page.mandatoryCheck();
}

@Test
public void TC11_ButtonsAvailabilityCheck() {
	
	lib_page.BookSelectGeekLove();
	lib_page.ButtonAvailableCheck();
	lib_page.ButtonInitialDisableCheck();
}

@Test
public void TC12_BookDetailsMandatoryCheck() {
	
	lib_page.BookSelectLolita();
	lib_page.mandatoryCheck();
}

@Test
public void TC13_BookDetailsNonMandatoryFieldCheck() {
	
	lib_page.BookSelectGeekLove();
	lib_page.NonmandatoryCheckAuthorField();
}

@Test
public void TC14_ModifyBookDetails() {
	
	lib_page.BookSelectGeekLove();
	lib_page.ModifyAllbookDetails();
	lib_page.clickSave();
	lib_page.BookSelectdesertSolitaire();
	lib_page.BookSelectGeekLove();
	lib_page.ValidateModifiedBookDetails();
}

@Test
public void TC15_ModifyPublisherBookDetails() {
	
	lib_page.BookSelectGeekLove();
	lib_page.modifyPublisher();
	lib_page.clickSave();
	lib_page.BookSelectdesertSolitaire();
	lib_page.BookSelectGeekLove();
	lib_page.ValidateModifiedpublisherDetails();
}

@Test
public void TC16_LargeCharsEntryBookDetailsCheck() {
	
	lib_page.BookSelectGeekLove();
	lib_page.LargeCharactersEnterInBookDetaisl();
	lib_page.clickSave();
}


@Test
public void TC17_YearofPublishingEnterAlphaNumeric() {
	
	lib_page.BookSelectGeekLove();
	lib_page.EnterAlphaNumbericCharacInYearofPublishing();
	lib_page.clickSave();
	lib_page.AlertShownYearRequired();
	
}

@Test
public void TC18_CancelButtonFunctionalityCheck() {
	
	lib_page.BookSelectGeekLove();
	lib_page.modifyTitle();
	lib_page.modifyAuthor();
	lib_page.modifyPublisher();
	lib_page.clickCancel();
	lib_page.VerifyBookDetailsTextCheck();
}
@Test
public void TC19_CancelButtonForTestingYearofPublishing() {
	
	lib_page.BookSelectGeekLove();
	lib_page.modifyYearofPublishing();
	lib_page.clickCancel();
	lib_page.VerifyYearOfPublishingText();
}

@Test
public void TC20_YearOfPublishingShouldRestrictTo4digits() {
	
	lib_page.BookSelectGeekLove();
	lib_page.EnterYearMoreThan4DigitsInYearofPublishing();
}
@Test
public void TC20_YearOfPublishingRestrictsFutureDates() {
	
	lib_page.BookSelectGeekLove();
	lib_page.EnterYearFutureDate();
}

}
