package com.org.pages;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.enums.AppValidationMessages;
import com.org.util.FunctionLibrary;
import com.org.util.Log;
import com.org.util.LoggerHelper;

public class StaffPage extends FunctionLibrary {
	
	//Declarations of WebElement
	
	@FindBy(xpath="//h2[@translate='gurukulaApp.staff.home.title']")
	WebElement StaffPageTitle;
	@FindBy(xpath="//div[@class='col-md-4']//button[@class='btn btn-primary']")
	WebElement CreateNewStaff;
			@FindBy(xpath="//input[@id='searchQuery']")
			WebElement Searchtextfield;
	@FindBy(xpath="//span[contains(text(),'Search a Staff')]")
	WebElement SearchButton;
			@FindBy(xpath="//*[text()='Entities']")
			WebElement Entities;
	@FindBy(xpath="//*[text()='Staff']")
	WebElement Staff;
			@FindBy(xpath="//span[contains(text(),'Create a new Staff')]")
			WebElement NewStaff;
	@FindBy(xpath="//h2/span[@translate='gurukulaApp.staff.detail.title']")
	WebElement StaffDetailTitle;
			//Search
			@FindBy(xpath="//span[contains(text(),'Search a Staff')]")
			WebElement SearchAStaffButton;
	@FindBy(xpath="//p[contains(text(),'This field cannot be longer than 50 characters.')]")		
	WebElement MorethanfiftyCharslengthMsgWebEle;
	
	//Create or Edit a Staff popup
	@FindBy(xpath="//input[@name='name']")
	WebElement Name;
	@FindBy(xpath="//select[@name='related_branch']")
	WebElement SelectRelatedBranch;
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement NewBranchSaveButton;
	
	@FindBy(xpath="//h4[text()='Create or edit a Staff']")
	WebElement CreateorEditStaffpopup;
	@FindBy(xpath="//table[@class='table table-striped']//tbody")
	WebElement BranchListWebTable;
	private WebDriver driver;
	
	//Delete
//	@FindBy(xpath="//form[@name='deleteForm']//span[@class='ng-scope'][contains(text(),'Cancel')]")
	//WebElement BranchDeletepopupCancelButton;
	
	Logger logger=LoggerHelper.getLogger(StaffPage.class);
	
	public StaffPage(WebDriver driver) {
		this.driver=driver;
		//Log.info("BranchesPage elements are initialized");
		PageFactory.initElements(driver, this);
	}

	public void StaffPageNavigate() {
		commonClick_MenuItem(driver, Entities, Staff);
		logger.info("Navigated to Staff Page");
	}
	
	public void NewStaffButtonClick() {
		commonClick(NewStaff);
		Log.info("Create a NewStaff link is clicked in Staffs page");
	}
	
	public void StaffSearch(String sText) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 commonSetTextTextBox(Searchtextfield, sText);
	//	driver.findElement(By.xpath("//*[@id=\"searchQuery\"]")).sendKeys(sText);
		commonClick(SearchAStaffButton);
		
	}

	public void CreateStaff(String string, String string2) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		commonSetTextTextBox(Name, string);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//commonSetTextTextBox(NewBranchcodetextfield, NewBranchcode);
		CommonSelectDropDown(SelectRelatedBranch, string2);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		commonClick(NewBranchSaveButton);
		 
		 try {
		 	Thread.sleep(5000);
		 } catch (InterruptedException e) {
		 	e.printStackTrace();
		 }
		
	}
		

	public void StaffPageTitleValidation() {
		assertTrue(commonVerifyLabelText(StaffPageTitle,AppValidationMessages.StaffsPagetitle));
		
	}

	public void CreateorEditStaffPopupCheck() {
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(commonVerifyLabelText(CreateorEditStaffpopup,AppValidationMessages.CreateorEditStaffpopuptitle));
	}

	public void ViewBranchDetailsScreen() {
		commonVerifyLabelText(StaffDetailTitle,AppValidationMessages.StaffsPagetitle);
		
	}

	public void maxfiftyCharslengthCheck() {
		commonSetTextTextBox(Name,  AppValidationMessages.MaxCharsStr);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(commonVerifyLabelText(MorethanfiftyCharslengthMsgWebEle,AppValidationMessages.MoreThanFiftycharslengthWarningMessageForStaffNameStr));
	}
 
	public void CheckNameAndbranchDetailsAvailableforEditedStaff() {
	 	String Staff=commonGetTextWebTable(BranchListWebTable);
	 	BranchesPage branchesPage=new BranchesPage(driver);
		branchesPage.ClickEditButtonBranchList();
		assertTrue(commonVerifyValueTextBox(Name,Staff));
		
	}
	
	
}
