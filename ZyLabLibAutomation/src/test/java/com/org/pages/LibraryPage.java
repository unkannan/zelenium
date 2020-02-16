 
package com.org.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import com.org.enums.ZyLabAppMsg;
import com.org.utility.UIOperation;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
public class LibraryPage extends UIOperation {

     static Logger logger = Logger.getLogger(LibraryPage.class.getName());

    private String LibraryPagexpathHeading = "//h3";
    private String MenuBooksXpath= "//a[contains(text(),'Books')]";
    private String MenuAuthorsXpath= "//a[contains(text(),'Authors')]";
    private String NoBookSelectedTextXpath="//div[@class='no-book-selected ng-star-inserted']";
    private String FilterSearchTextXpath="//div[@class='mat-form-field-infix']/span//span";
    private String BooksListXpath="//mat-list-item";
    private String GeekLoveBookXpath="//mat-list-item[3]/div[1]/div[2]/a[1]";
    private String GeekLoveBookDeleteLinkXpath="//mat-list-item[3]//div[1]//mat-icon[2]";
    private String FilterSearchTextBoxID="mat-input-0";
    WebDriver driver;

    public LibraryPage(WebDriver driver) {
        super(driver);
        this.driver = driver; 
    }

    /**
     * This function is to assert Converter Main page heading.
     */
    public void LibraryPageHeaderCheck() {
        waitForElement(LibraryPagexpathHeading);
        String actualHeading = assertAndGetText(LibraryPagexpathHeading);
        System.out.println(actualHeading);
        logger.info("# Library Page Header " + actualHeading);
        assertEquals(actualHeading, ZyLabAppMsg.HEADING,
            "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.HEADING+ "'.");
    }
    /**
     * This function is to assert Converter Main page heading.
     */
    public void LibraryPageMenuLinkBooksCheck() {
        waitForElement(MenuBooksXpath);
        String actualHeading = assertAndGetText(MenuBooksXpath);
        System.out.println(actualHeading);
        logger.info("# Library Page Menu " + actualHeading);
        assertEquals(actualHeading, ZyLabAppMsg.MenuBooksText,
            "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.MenuBooksText+ "'.");
    }
    /**
     * This function is to assert Converter Main page heading.
     */
    public void LibraryPageMenuLinkAuthorsCheck() {
        waitForElement(MenuAuthorsXpath);
        String actualHeading = assertAndGetText(MenuAuthorsXpath);
        System.out.println(actualHeading);
        logger.info("# Library Page Menu " + actualHeading);
        assertEquals(actualHeading, ZyLabAppMsg.MenuAuthorsText,
            "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.MenuAuthorsText+"'.");
    }

    /**
     * This function is to assert Converter Main page heading.
     */
    public void NoBooksSelectedTextCheck() {
        waitForElement(NoBookSelectedTextXpath);
        String actualText = assertAndGetText(NoBookSelectedTextXpath);
        System.out.println(actualText);
        logger.info("# Library Page Menu " + actualText);
        assertEquals(actualText, ZyLabAppMsg.NoBookSelectedText,
            "Actual heading '" + actualText + "' should be same as expected heading '" + ZyLabAppMsg.NoBookSelectedText+"'.");
    }
    
    public void ClickLinkBooksInMenu() {
    	assertAndClick(MenuBooksXpath);
        logger.info("# Clicked on Link: " + MenuBooksXpath);
    }
    
    public void FilterTextBoxAvailabilityCheck() {
    	//assertAndGetText(FilterSearchTextXpath);
    	waitForElement(FilterSearchTextXpath);
        String actualText = assertAndGetText(FilterSearchTextXpath);
        logger.info("# Filter Search Text Box Contains text as " + actualText);
        assertEquals(actualText, ZyLabAppMsg.FilterSearchText,
            "Actual heading '" + actualText + "' should be same as expected heading '" + ZyLabAppMsg.FilterSearchText+"'.");
    }
    public void DisplayAllBooks() {
    	List list=driver.findElements(By.xpath(BooksListXpath));
    	for(int i=1;i<=list.size();i++) {
    		String actualText = assertAndGetText("//mat-list-item["+i+"]/div[1]/div[2]/a[1]");
            logger.info("# Books Listed " + actualText);
    	}
    }
    public void DeleteBookCheck() {
    	String actualText = assertAndGetText(GeekLoveBookXpath);
        logger.info("# Books List has the Book Name" + actualText);
        assertEquals(actualText, ZyLabAppMsg.GeekLoveBookNameLabel,
            "Actual heading '" + actualText + "' should be same as expected heading '" + ZyLabAppMsg.GeekLoveBookNameLabel+"'.");
        assertAndClick(GeekLoveBookDeleteLinkXpath);
        RefreshPage();
        actualText = assertAndGetText(GeekLoveBookXpath);
        assertNotEquals(actualText, ZyLabAppMsg.GeekLoveBookNameLabel,
                "Actual heading '" + actualText + "' Should not be same as expected heading '" + ZyLabAppMsg.GeekLoveBookNameLabel+"'.");
        
    }
    public void SearchBooksUsingFilters() {
    	assertAndTypeID(FilterSearchTextBoxID,ZyLabAppMsg.lolitaBoookNameLabel);
    	List list=driver.findElements(By.xpath(BooksListXpath));
    	for(int i=1;i<=list.size();i++) {
    		String actualText = assertAndGetText("//mat-list-item["+i+"]/div[1]/div[2]/a[1]");
    		 logger.info("# Books Listed " + actualText);
    		 assertEquals(actualText, ZyLabAppMsg.lolitaBoookNameLabel,
    		            "Actual text '" + actualText + "' should be same as expected heading '" + ZyLabAppMsg.lolitaBoookNameLabel+"'.");
    	}
    }
    public void SearchBooksWithInvalidText() {
    	assertAndTypeID(FilterSearchTextBoxID,ZyLabAppMsg.InvalidBookNotAvlblInList);
    	List list=driver.findElements(By.xpath(BooksListXpath));
    	 logger.info("# Books found in the List for Invalid Search " + list.size());
    	if(list.size()>0)
    		assertFalse(true);
    	else
    		assertTrue(true);
    }
    
    public void VerifyBookDetailsLabelCheck() {
    	VerifyBookNameDisplayDetailsCheck();
    	verifyBooksTitleLabel();
    	verifyBooksAuthorLabel();
    	verifyBooksPublisherLabel();
    	verifyBooksYearofPublishingLabel();
    }
    public void VerifyBookNameDisplayDetailsCheck() {
System.out.println(driver.findElement(By.xpath("//mat-card-title[@class='mat-card-title']")).getText());
    	
    }
    public void verifyBooksTitleLabel() {
    	System.out.println(driver.findElement(By.xpath("//label[@id='mat-form-field-label-3']/span")).getText());
    }
    public void verifyBooksAuthorLabel() {
    	System.out.println(driver.findElement(By.xpath("//label[@id='mat-form-field-label-5']/span")).getText());
    }
    public void verifyBooksPublisherLabel() {
    	System.out.println(driver.findElement(By.xpath("//label[@id='mat-form-field-label-7']/span")).getText());
    }
    public void verifyBooksYearofPublishingLabel() {
    	System.out.println(driver.findElement(By.xpath("//label[@id='mat-form-field-label-9']/span")).getText());
    }
public void BookSelectGeekLove() {
	driver.findElement(By.xpath(GeekLoveBookXpath)).click();
}
public void VerifyBookDetailsTextCheck() {
System.out.println(driver.findElement(By.id("mat-input-1")).getText());
System.out.println(driver.findElement(By.xpath("//input[@id='mat-input-1']")).getText());
}
}
