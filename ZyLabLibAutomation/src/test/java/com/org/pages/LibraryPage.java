 
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
import org.openqa.selenium.Keys;
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
    
    public String desertSolitaireBookListXpath="//mat-list-item[2]/div[1]/div[2]/a[1]";
    private String desertSolitaireDeleteLinkXpath="//mat-list-item[2]//div[1]//mat-icon[2]";
    
    private String GeekLoveBookListXpath="//mat-list-item[3]/div[1]/div[2]/a[1]";
    private String GeeKLoveBookTitleHeaderXpath="//mat-card-title[@class='mat-card-title']";
    
    public String lolitaBookListXpath="//mat-list-item[4]/div[1]/div[2]/a[1]";
    
    private String BookTitleLabelXpath="//label[@id='mat-form-field-label-3']/span";
    private String BookAuthorLabelXpath="//label[@id='mat-form-field-label-5']/span";
    private String BookPublisherLabelXpath="//label[@id='mat-form-field-label-7']/span";
    private String BookYearOfPublishingLabelXpath="//label[@id='mat-form-field-label-9']/span";
    
    private String TitleTextValueID="mat-input-1";
    private String AuthorTextValueID="mat-input-2";
    private String PublisherTextValueID="mat-input-3";
    private String YearOfPublishingTextValueID="mat-input-4";
    private String FilterSearchTextBoxID="mat-input-0";
    
    private String SaveButtonSpanXpath="//button[@class='mat-button mat-primary']/span";
    private String CancelButtonSpanXpath="//button[@class='mat-button']/span";
    private String SaveButtonXpath="//button[@class='mat-button mat-primary']";
    private String CancelButtonXpath="//button[@class='mat-button']";
    
    private String TitleRequiredXpath="//mat-error[text()=' Title is ']";//"//mat-error[@id='mat-error-0']";
    private String PublisherRequiredXpath="//mat-error[text()=' Publisher is ']";//"//mat-error[@id='mat-error-1']";
    private String YearOfPublishingRequiredXpath="//mat-error[text()=' Year is ']";
    private String KeysControlA="Keys.CONTROL,\"a\"";
    private String KeysControlDelete="Keys.DELETE";
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
    	String actualText = assertAndGetText(desertSolitaireBookListXpath);
        logger.info("# Books List has the Book Name " + actualText);
        assertEquals(actualText, ZyLabAppMsg.DesertSolitaireBookNameLabel,
            "Actual heading '" + actualText + "' should be same as expected heading '" + ZyLabAppMsg.DesertSolitaireBookNameLabel+"'.");
        assertAndClick(desertSolitaireDeleteLinkXpath);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        actualText = assertAndGetText(desertSolitaireBookListXpath);
        logger.info("# Books List has the Book Name " + actualText);
        assertNotEquals(actualText, ZyLabAppMsg.DesertSolitaireBookNameLabel,
                "Actual heading '" + actualText + "' Should not be same as expected heading '" + ZyLabAppMsg.DesertSolitaireBookNameLabel+"'.");
        
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
    	VerifyBookNameHeaderDisplay();
    	VerifyBooksTitleLabel();
    	VerifyBooksAuthorLabel();
    	VerifyBooksPublisherLabel();
    	VerifyBooksYearofPublishingLabel();
    }
    public void VerifyBookNameHeaderDisplay() {
    	  waitForElement(GeeKLoveBookTitleHeaderXpath);
          String actualHeading = assertAndGetText(GeeKLoveBookTitleHeaderXpath);
          logger.info("# Book Details Title " + actualHeading);
          assertEquals(actualHeading, ZyLabAppMsg.GeekLoveBookNameLabel,
              "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.GeekLoveBookNameLabel+"'.");
    }
    public void VerifyBooksTitleLabel() {
    	 waitForElement(BookTitleLabelXpath);
         String actualHeading = assertAndGetText(BookTitleLabelXpath);
         logger.info("# Book Details Title " + actualHeading);
         assertEquals(actualHeading, ZyLabAppMsg.BookDetailsTitleLabel,
             "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.BookDetailsTitleLabel+"'.");
   	
    	//System.out.println(driver.findElement(By.xpath("//label[@id='mat-form-field-label-3']/span")).getText());
    }
    public void VerifyBooksAuthorLabel() {
    	 waitForElement(BookAuthorLabelXpath);
         String actualHeading = assertAndGetText(BookAuthorLabelXpath);
         logger.info("# Book Details Title " + actualHeading);
         assertEquals(actualHeading, ZyLabAppMsg.BookDetailsAuthorLabel,
             "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.BookDetailsAuthorLabel+"'.");
   	
         //System.out.println(driver.findElement(By.xpath("//label[@id='mat-form-field-label-5']/span")).getText());
    }
    public void VerifyBooksPublisherLabel() {
    	waitForElement(BookPublisherLabelXpath);
        String actualHeading = assertAndGetText(BookPublisherLabelXpath);
        logger.info("# Book Details Title " + actualHeading);
        assertEquals(actualHeading, ZyLabAppMsg.BookDetailsPublisherLabel,
            "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.BookDetailsPublisherLabel+"'.");
  	
    //	System.out.println(driver.findElement(By.xpath("//label[@id='mat-form-field-label-7']/span")).getText());
    }
    public void VerifyBooksYearofPublishingLabel() {
    	waitForElement(BookYearOfPublishingLabelXpath);
        String actualHeading = assertAndGetText(BookYearOfPublishingLabelXpath);
        logger.info("# Book Details Title " + actualHeading);
        assertEquals(actualHeading, ZyLabAppMsg.BookDetailsYearOfPublishingLabel,
            "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.BookDetailsYearOfPublishingLabel+"'.");
    }


 public void BookSelectGeekLove() {
	 assertAndClick(GeekLoveBookListXpath);
	 logger.info("# Clicked on Link: " + "Geek Love in Book List");
}

 public void BookSelectLolita() {
	 assertAndClick(lolitaBookListXpath);
	 logger.info("# Clicked on Link: " + "Geek Love in Book List");
 }
 public void BookSelectdesertSolitaire() {
	 assertAndClick(desertSolitaireBookListXpath);
	 logger.info("# Book Selected: " + "desert Solitaire in Book List");
}
public void VerifyBookDetailsTextCheck() {
	VerifyTitleText();
	VerifyAuthorText();
	VerifyPublisherText();
	VerifyYearOfPublishingText();

/*//mor than 100 chars
driver.findElement(By.id("mat-input-1")).sendKeys(" geek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeeklljljljll");
driver.findElement(By.id("mat-input-2")).sendKeys(" geek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeeklljljljll");
driver.findElement(By.id("mat-input-3")).sendKeys(" geek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeek lovegeeklljljljll");
//Can enter future dates in yeah of publishing
driver.findElement(By.id("mat-input-4")).sendKeys("2035");
driver.findElement(By.id("mat-input-1")).click();*/
}
public void VerifyTitleText() {
	waitForElementID(TitleTextValueID);
    String actualHeading = assertAndGetAttributeValueID(TitleTextValueID);
    logger.info("# Book Details Title " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.GeekLoveBookNameLabel,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.GeekLoveBookNameLabel+"'.");
}
public void VerifyAuthorText() {
	waitForElementID(AuthorTextValueID);
    String actualHeading = assertAndGetAttributeValueID(AuthorTextValueID);
    logger.info("# Book Details Title " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.GeekLoveBookAuthorText,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.GeekLoveBookAuthorText+"'.");
}
public void VerifyPublisherText() {
	waitForElementID(PublisherTextValueID);
    String actualHeading = assertAndGetAttributeValueID(PublisherTextValueID);
    logger.info("# Book Details Title " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.GeekLoveBookPublisherText,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.GeekLoveBookPublisherText+"'.");
}
public void VerifyYearOfPublishingText() {
	waitForElementID(YearOfPublishingTextValueID);
    String actualHeading = assertAndGetAttributeValueID(YearOfPublishingTextValueID);
    logger.info("# Book Details Title " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.GeekLoveBookYearOfPublishingText,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.GeekLoveBookYearOfPublishingText+"'.");
}

public void ButtonAvailableCheck() {
	SaveButtonAvailabilityCheck();
	CancelButtonAvailabilityCheck();
}
public void ButtonInitialDisableCheck() {
	SaveButtonInitialDisableCheck();
	CancelButtonInitialDisableCheck();
}
private void CancelButtonInitialDisableCheck() {
	logger.info("# Cancel Button default behavior Check whether Enable or Disable: ");
	assertFalse(isElementEnable(CancelButtonXpath));
	logger.info("# Cancel Button Behavior Check Shows : Disabled" );
}

private void SaveButtonInitialDisableCheck() {
	logger.info("# Save Button Enable Check ");
	assertFalse(isElementEnable(SaveButtonXpath));
	logger.info("# Save Button Enable : Disabled");
}

public void SaveButtonAvailabilityCheck() {
	waitForElement(SaveButtonSpanXpath);
    String actualHeading = assertAndGetText(SaveButtonSpanXpath);
    logger.info("# Save Button Name Display " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.Save,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.Save);
}
public void CancelButtonAvailabilityCheck() {
	waitForElement(CancelButtonSpanXpath);
    String actualHeading = assertAndGetText(CancelButtonSpanXpath);
    logger.info("# Cancel Button Name Display " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.Cancel,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.Cancel);
}
public void clickSave() {
	assertAndClick(SaveButtonXpath);
}
public void clickCancel() {
	assertAndClick(CancelButtonXpath);
}

//THe fields mandatory check
public void mandatoryCheck() {
	DeleteTextInBookDetails();
	MandatoryAlertsDisplayCheck();
}

public void DeleteTextInBookDetails() {
	assertEnterControlADeleteKeys(TitleTextValueID);
	assertEnterControlADeleteKeys(PublisherTextValueID);
	assertEnterControlADeleteKeys(YearOfPublishingTextValueID);
}
public void MandatoryAlertsDisplayCheck() {	
waitForElement(TitleRequiredXpath);
    String actualHeading = assertAndGetText(TitleRequiredXpath);
    logger.info("# Cancel Button Name Display " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.TitleRequired,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.TitleRequired);
    
    waitForElement(PublisherRequiredXpath);
      actualHeading = assertAndGetText(PublisherRequiredXpath);
    logger.info("# Cancel Button Name Display " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.PublisherRequired,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.PublisherRequired);
    
    waitForElement(YearOfPublishingRequiredXpath);
      actualHeading = assertAndGetText(YearOfPublishingRequiredXpath);
    logger.info("# Cancel Button Name Display " + actualHeading);
    assertEquals(actualHeading, ZyLabAppMsg.yearRequired,
        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.yearRequired);
}
 
public void NonmandatoryCheckAuthorField() {
	assertEnterControlADeleteKeys(AuthorTextValueID);
	 assertAndClick(SaveButtonXpath);
	 String actualHeading = assertAndGetAttributeValueID(AuthorTextValueID);
	    logger.info("# Author Details :" + actualHeading);
	    assertEquals(actualHeading, ZyLabAppMsg.None,
	        "Actual heading '" + actualHeading + "' should be same as expected heading '" + ZyLabAppMsg.None+"'.");
		}

public void ModifyAllbookDetails() {
	assertAndTypeID(TitleTextValueID, ZyLabAppMsg.TitleChange);
	assertAndTypeID(AuthorTextValueID, ZyLabAppMsg.AuthorChange);
	assertAndTypeID(YearOfPublishingTextValueID, ZyLabAppMsg.YearOfPublishingChange);
}

public void ValidateModifiedBookDetails() {
	String actualValue = assertAndGetAttributeValueID(TitleTextValueID);
	logger.info("# Title Details changed:" + actualValue);
	assertEquals(actualValue, ZyLabAppMsg.TitleChange, "Actual heading '" + actualValue + "' should be same as expected heading '" + ZyLabAppMsg.TitleChange);
	
	actualValue = assertAndGetAttributeValueID(AuthorTextValueID);
	logger.info("# Title Details changed:" + actualValue);
	assertEquals(actualValue, ZyLabAppMsg.AuthorChange, "Actual heading '" + actualValue + "' should be same as expected heading '" + ZyLabAppMsg.AuthorChange);
	  
    actualValue = assertAndGetAttributeValueID(YearOfPublishingTextValueID);
	logger.info("# Title Details changed:" + actualValue);
	assertEquals(actualValue, ZyLabAppMsg.YearOfPublishingChange, "Actual heading '" + actualValue + "' should be same as expected heading '" + ZyLabAppMsg.YearOfPublishingChange);
}

public void PublisherTextModify() {
	assertAndTypeID(PublisherTextValueID, ZyLabAppMsg.PublisherChange);
}

public void ValidateModifiedpublisherDetails() {
	String actualValue = assertAndGetAttributeValueID(PublisherTextValueID);
	logger.info("# Title Details changed:" + actualValue);
	assertEquals(actualValue, ZyLabAppMsg.PublisherChange, "Actual heading '" + actualValue + "' should be same as expected heading '" + ZyLabAppMsg.PublisherChange);
}

public void LargeCharactersEnterInBookDetaisl() {
	assertAndTypeID(TitleTextValueID, ZyLabAppMsg.LargeCharsText);
	assertAndTypeID(AuthorTextValueID, ZyLabAppMsg.LargeCharsText);
	assertAndTypeID(PublisherTextValueID, ZyLabAppMsg.LargeCharsText);
}
public void EnterAlphaNumbericCharacInYearofPublishing() {
	assertAndTypeID(YearOfPublishingTextValueID, ZyLabAppMsg.AlphaNumbericText);
}
public void AlertShownYearRequired() {
	 waitForElement(YearOfPublishingRequiredXpath);
     String AlertMessage = assertAndGetText(YearOfPublishingRequiredXpath);
   logger.info("# Cancel Button Name Display " + AlertMessage);
   assertEquals(AlertMessage, ZyLabAppMsg.yearRequired,
       "Actual heading '" + AlertMessage + "' should be same as expected heading '" + ZyLabAppMsg.yearRequired);
}

}
