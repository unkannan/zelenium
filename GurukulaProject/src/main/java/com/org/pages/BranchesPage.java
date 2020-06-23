package com.org.pages;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.org.enums.AppValidationMessages;
import com.org.util.FunctionLibrary;
import com.org.util.LoggerHelper;

public class BranchesPage extends FunctionLibrary {
	
	private WebDriver driver;
	Logger logger=LoggerHelper.getLogger(BranchesPage.class);
	

	//@FindBy(xpath="//*[text()='Create a new Branch']']")
	@FindBy(xpath="/html/body/div[3]/div[1]/div/div[1]/div/div[1]/button/span[2]")
	WebElement NewBranch;
	@FindBy(xpath="//*[text()='Entities']")
	WebElement Entities;
	@FindBy(xpath="//*[text()='Branch']")
	WebElement Branch;
	@FindBy(xpath="//h2[@translate='gurukulaApp.branch.home.title']")
	WebElement BranchesPageTitle;
	
	@FindBy(xpath="//h4[text()='Create or edit a Branch']")
	WebElement CreateorEditBranchpopup;
	
	//Edit Elements
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
	WebElement BranchListEdit;
	
	
	 //BranchPopup
	@FindBy(xpath="//input[@name='name']")
	
	WebElement NewBranchNametextfield;
	@FindBy(xpath="//input[@name='code']")
	WebElement NewBranchcodetextfield;
	@FindBy(xpath="//span[contains(text(),'Save')]")
	WebElement NewBranchSaveButton;
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[3]/button[1]/span[2]")
	WebElement NewBranchCancelButton;
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[2]/div[1]/p[1]")
	WebElement NewBranchNameTextfieldValidationMsgTextdRequired;
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/p[1]")
	WebElement NewBranchNameCodeTextfieldValidationMsgfieldRequired;
			
	@FindBy(xpath="//p[contains(text(),'This field is required to be at least 5 characters')]")
	WebElement NewBranchNameTextfieldminCharlengthValidationMsgEle;
	@FindBy(xpath="//p[contains(text(),'This field cannot be longer than 20 characters.')]")
	WebElement NewBranchNameTextfieldmaxCharlengthValidationMsgEle;
	
	@FindBy(xpath="//p[contains(text(),'This field is required to be at least 2 characters')]")
	WebElement NewBranchCodeTextfieldminCharlengthValidationMsgEle; 
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[3]/div[1]/p[1]")
	WebElement NewBranchCodeTextfieldValidationMsgTextfieldRequired;
	@FindBy(xpath="//p[contains(text(),'This field should follow pattern ^[A-Z0-9]*$.')]")
	WebElement NewBranchCodeTextfieldValidationMsgOnlyDigits;
	
	@FindBy(xpath="//table[@class='table table-striped']//tbody")
	WebElement BranchListWebTable;
	@FindBy(xpath="//span[contains(text(),'View')]")
	WebElement BranchListView;
	@FindBy(xpath="//a[text()='2']")
	WebElement BranchListIDlink;
	
	@FindBy(xpath="//h2/span[@translate='gurukulaApp.branch.detail.title']")
	WebElement BranchDetailTitle;
	@FindBy(xpath="//tr[1]//td[2]//input[1]")
	WebElement BranchDetailNameTextField;
	@FindBy(xpath="//tr[2]//td[2]//input[1]")
	WebElement BranchDetailCodeTextField;
	@FindBy(xpath="//span[contains(text(),'Back')]")
	WebElement BranchDetailBackButton;
	
	//Delete
	@FindBy(xpath="//button[@class='btn btn-danger btn-sm']//span[@class='ng-scope'][contains(text(),'Delete')]")
	WebElement BranchListDelete;
	 
	@FindBy(xpath="//form[@name='deleteForm']//span[@class='ng-scope'][contains(text(),'Cancel')]")
	WebElement BranchDeletepopupCancelButton;
	@FindBy(xpath="//button[@class='btn btn-danger']")
	WebElement BranchDeletepopupDeleteButton;
	
	//SearchPage
	@FindBy(xpath="//*[@id=\"searchQuery\"]")
	WebElement BranchSearchtextfield;
	@FindBy(xpath="//span[contains(text(),'Search a ')]")
	WebElement BranchSearchButton;
	
	public BranchesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void BranchSearch(String sText) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 commonSetTextTextBox(BranchSearchtextfield, sText);

		 try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		commonClick(BranchSearchButton);
	}
	
	public void NewBranchButtonClick() {
		commonClick(NewBranch);
		logger.info("NewBranch link is clicked in Branches page");
		}
	
	public void createNewBranch(String BranchName,String Code) {
		NewBranchButtonClick();
		CreateBranch(BranchName,Code); 
	}
	 
	public void EnterNewBranchNametextfield(String BranchName) {
		commonSetTextTextBox(NewBranchNametextfield, BranchName);
	}
	public void EnterNewBranchCodetextfield(String Code) {
		commonSetTextTextBox(NewBranchcodetextfield, Code);
	}
	public void BranchesPageNavigate() {
		commonClick_MenuItem(driver, Entities, Branch);
	}
	public void BranchesPageTitleValidation() {
		assertTrue(commonVerifyLabelText(BranchesPageTitle,AppValidationMessages.BranchesPagetitle));
		}
	public void NewBranchCancelButton() {
		commonClick(NewBranchCancelButton);
	}

	public void BranchDetailsPopupCheck() {
		commonVerifyLabelText(CreateorEditBranchpopup, AppValidationMessages.CreateorEditBranchpopupStr);
	}

	public void CreateBranch(String NewBranchname,String NewBranchcode) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commonSetTextTextBox(NewBranchNametextfield, NewBranchname);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commonSetTextTextBox(NewBranchcodetextfield, NewBranchcode);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		commonClick(NewBranchSaveButton);
		logger.info("Save button is clicked to create a new Branch");
		 
		 try {
		 	Thread.sleep(5000);
		 } catch (InterruptedException e) {
			// TODO Auto-generated catch block
		 	e.printStackTrace();
		 }
	}

	public void BranchCheck(String name, String code) {
		logger.info("Branch Title verification");
		assertTrue(commonWebTableVerifyText(BranchListWebTable,name,code));
		
	}
	public void BranchCheck(String name) {
		logger.info("List is verified for the respective searching criteria");
		assertTrue(commonWebTableVerifyText(BranchListWebTable,name));	
		logger.info("List is verified and found the Branch/ Staff which is created/ Edited");
	}
	public void BranchNotAvailable(String name, String code) {
		logger.info("Details verification for Branch Name " +name+" having code " +code);
		assertTrue(!commonWebTableVerifyText(BranchListWebTable,name,code));
		
	}
	public void BranchNotAvailable(String name) {
		logger.info("Branch/Staff details verification for Name " +name);
		assertTrue(!commonWebTableVerifyText(BranchListWebTable,name));
		logger.info("Search Results are not shown up for " +name);
	}

	public void ClickViewButton() {
		logger.info("Clicking view button");
		commonClick(BranchListView);
		
	}
	public void clickBackButtonBranchDetailsPage() {
			commonClick(BranchDetailBackButton);
			logger.info("BranchDetailPage_BackButton is clicked");
	}
	

	public void ViewBranchDetailsScreen() {
		commonVerifyLabelText(BranchDetailTitle,AppValidationMessages.BranchDetailTitleStr);
	}
	
	public void ClickingBranchID() {
		commonClick(BranchListIDlink);
	}

	public void ViewBranchDetailsNameCode(String Name,String Code) {
		assertTrue(commonVerifyValueTextBox(BranchDetailNameTextField, Name));
		assertTrue(commonVerifyValueTextBox(BranchDetailCodeTextField, Code));
	}

	//Name Field Validation
	public void NameTextFieldNewBranchmandatoryfieldCheck() {
		logger.info("Name Text field_Mandatory Check is in progress");
		commonSetTextTextBox(NewBranchNametextfield, AppValidationMessages.NoCharStr);
		assertTrue(commonVerifyLabelText(NewBranchNameTextfieldValidationMsgTextdRequired,AppValidationMessages.NewBranchNameTextfieldValidationMsgfieldRequiredstr));
		logger.info("Name field_Mandatory check validation is working fine");
	}
	  
	public void MiniumCharLengthValidationNameTextField() {
		commonSetTextTextBox(NewBranchNametextfield,  AppValidationMessages.MinCharStr);
		assertTrue(commonVerifyLabelText(NewBranchNameTextfieldminCharlengthValidationMsgEle,AppValidationMessages.minimumcharlengthvalidationstr));
		logger.info("Minimum Char length validation check is working fine");
	}
	public void MaxCharLengthValidationNameTextField() {
		commonSetTextTextBox(NewBranchNametextfield,  AppValidationMessages.MaxCharsStr);
		assertTrue(commonVerifyLabelText(NewBranchNameTextfieldmaxCharlengthValidationMsgEle,AppValidationMessages.Maxtwentytwocharlengthvalidationstr));
		logger.info("Max char length validation check is working fine");
	}
	
	
	public void CodeTextFieldNewBranchmandatoryfieldCheck() {
		commonSetTextTextBox(NewBranchcodetextfield, AppValidationMessages.NoCharStr);
		assertTrue(commonVerifyLabelText(NewBranchNameCodeTextfieldValidationMsgfieldRequired,AppValidationMessages.NewBranchNameTextfieldValidationMsgfieldRequiredstr));
		logger.info("Code field_Mandatory check validation is working fine");
	}
	public void OnlyDigitsInputValidationNameTextField() {
		commonSetTextTextBox(NewBranchcodetextfield, AppValidationMessages.MinCharStr);
		assertTrue(commonVerifyLabelText(NewBranchCodeTextfieldValidationMsgOnlyDigits,AppValidationMessages.PatternfollowedTextFieldvalidationstr));
		logger.info("Code field_Only Digits_validation is working fine");
	}

	public void MiniumCharLengthValidationCodeTextField() { 
		commonSetTextTextBox(NewBranchcodetextfield, AppValidationMessages.MintwoCharStr);
		assertTrue(commonVerifyLabelText(NewBranchCodeTextfieldminCharlengthValidationMsgEle,AppValidationMessages.minimumtwocharlengthvalidationstr));
	}

	public void ClickEditButtonBranchList() {
		commonClick(BranchListEdit);	
	}

	public void EditScreenValidation(String Name,String Code) {
		assertTrue(commonVerifyValueTextBox(NewBranchNametextfield,Name));
		assertTrue(commonVerifyValueTextBox(NewBranchcodetextfield,Code));
		logger.info("Edit Screen validation is working fine showing the Name and Code data");
	}
public void BranchIDDelete() {
	commonClick(BranchListDelete);
	logger.info("Delete button is clicked");
}

public void BranchListDeletebuttonInPopup() {
	commonClick(BranchDeletepopupDeleteButton);
}
public void BranchDeletepopupCancelButton() {
	commonClick(BranchDeletepopupCancelButton);
}

public void BranchCheckNotAvailable(String name) {
	assertTrue(!commonWebTableVerifyText(BranchListWebTable,name));
	
}
  
}
