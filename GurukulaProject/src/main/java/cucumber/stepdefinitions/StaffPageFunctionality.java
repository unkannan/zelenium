package cucumber.stepdefinitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.pages.StaffPage;
import com.org.pages.BranchesPage;
import com.org.pages.LoginPage;
import com.org.util.LoggerHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StaffPageFunctionality {
	public static WebDriver driver;
Logger logger=LoggerHelper.getLogger(StaffPageFunctionality.class);

//user launches the application
@Given("^Staff Feature_User launches the application$")
public void lanuchApplication() {
	driver=CommonPageStepDefinition.lanuchApplication();
}
//Navigating to Staff page
@Given("^User logs in and navigates to Staff page by clicking Account Menu > Staff$")
public void NavigatingtoStaffPage() {
	    LoginPage loginpage=new LoginPage(driver);
	    loginpage.ApplicationLaunchLoginButtonClick();
		loginpage.LoginIntoGuruKulPage("admin","admin");
		StaffPage searchStaffPage=new StaffPage(driver);
		searchStaffPage.StaffPageNavigate();
}
//Staff page title validation
@Then("^User should be able to see the Staff page$")
public void StaffPageTitleValidation(){
	StaffPage StaffPage=new StaffPage(driver);
	StaffPage.StaffPageTitleValidation();
}
//Clicking the Create New Staff link to navigate Create Staff Page for creating Staff
@Given("^User able to click Create a new Staff link$")
public void clickingCreateNewStaffLink() throws Throwable {
	StaffPage staffPage=new StaffPage(driver);
		staffPage.NewStaffButtonClick();
}
//Create Staff Details Pop Up page verification
@Then("^User should be able to see a popup for creating a Staff$")
public void CreateStaffPopUp() throws Throwable {
	StaffPage staffPage=new StaffPage(driver);
	staffPage.CreateorEditStaffPopupCheck();    
}
 
//Creating Staff with inputs of Staff and Branch inputs 
@Then("^create four different Staffs  of <Name> and <Branch>$")
public void CreateStaffWithStaffBranchInputs(DataTable testdata) throws Throwable {
	StaffPage staffPage=new StaffPage(driver);
	List<List<String>> data = testdata.raw();
	for(int i=1;i<data.size();i++) {
		staffPage.NewStaffButtonClick();
		staffPage.CreateStaff(data.get(i).get(0),data.get(i).get(1));
		logger.info("New Branches are created for Search functionality check");
		}
	}
//Searching with staff name 
@When("^on the same page, user search for the Staff using Staff name \"([^\"]*)\"$")
public void SearchingForStaff(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	BranchesPage branchPage=new BranchesPage(driver);
	branchPage.BranchSearch(arg1);
}

@Then("^Staff details page should be shown in the Staff list for \"([^\"]*)\" as the staff is created$")
public void SearchResultsVerificationOfStaff(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	BranchesPage branchPage=new BranchesPage(driver);
	Thread.sleep(2000);
	branchPage.BranchCheck(arg1);
}

@Given("^User provides the details \"([^\"]*)\" and \"([^\"]*)\" in the Create new Staff popup page and clicks Cancel button$")
public void CancelButtonValidationinStaffPopup(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	//StaffPage staffPage=new StaffPage(driver);
	//staffPage.CreateStaff(arg1,arg2);
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.EnterNewBranchNametextfield(arg1);
	Thread.sleep(500);
	branchesPage.NewBranchCancelButton();
	logger.info("User is clicked the cancel button");
}

@Then("^User cannot see the Staff \"([^\"]*)\" and \"([^\"]*)\" in the Staffs page as it is cancelled$")
public void NonAvailabilityofStaff(String arg1, String arg2) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	BranchesPage branchPage=new BranchesPage(driver);
	branchPage.BranchNotAvailable(arg1, arg2);
}

@Given("^User clicks the view link for the <OneStaffSelenium> code in the webtable$")
public void ViewLinkValidation() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.ClickViewButton();
}
//Staff details screen validation when clicked view link
@Then("^User can see the Staff details$")
public void StaffDetailsScreenValidation() throws Throwable {
	StaffPage staffPage=new StaffPage(driver);
	staffPage.ViewBranchDetailsScreen();
}
//Back button functional check in Staff Details screen
@Given("^Back should be available in Branch details page and cicking Back button should navigate to Staff page$")
public void StaffDetailsScreen_BackButtonValidation() throws Throwable {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.clickBackButtonBranchDetailsPage();
}
//Name field text validation for mandatory , char length check
@Then("^Create_Edit_Staff_Pop_Up_Name text field has functionality of mandatory check,max char lenth$")
public void NameTextFieldValidation()  throws Throwable {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.NameTextFieldNewBranchmandatoryfieldCheck();
	//branchesPage.MaxCharLengthValidationNameTextField();
	StaffPage staffPage=new StaffPage(driver);
	Thread.sleep(5000);
	staffPage.maxfiftyCharslengthCheck();
}

//Name and Code data verification in Edit staff page
@Then("^Name and Branch is shown in Edit Staff page$")
public void EditDetailsScreen() throws Throwable {
	StaffPage staffPage=new StaffPage(driver);
	staffPage.CheckNameAndbranchDetailsAvailableforEditedStaff();
}
//Edit link functional check in Staff page
@Given("^User clicks Edit Staff link$")
public void EditLinkValidation() throws Throwable {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.ClickEditButtonBranchList();
}
//Click button functionality check in Edit Scren popup
@Given("^User provides the details \"([^\"]*)\" in the Create new Staff popup page and clicks Cancel button$")
public void EditScreen_CancelButtonValidation(String arg1) throws Throwable {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.EnterNewBranchNametextfield(arg1);
	Thread.sleep(500);
	branchesPage.NewBranchCancelButton();
	logger.info("User is clicked the cancel button");
}
//Verifying that Staff which is not available in Staff list
@Then("^User cannot see the staff \"([^\"]*)\" in the Staff page as it is cancelled$")
public void StaffUnavaialbleCheck(String arg1) throws Throwable {
	BranchesPage branchPage=new BranchesPage(driver);
	branchPage.BranchCheckNotAvailable(arg1);
}
//Save button functionality check in Edit Screen popup
@Given("^User provides the details \"([^\"]*)\" in the Edit Staff popup page and clicks save button$")
public void EditScren_SaveButtonFunctionalityCheck(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	StaffPage staffPage=new StaffPage(driver);
	staffPage.CreateStaff(arg1,"");
	logger.info("Edited and Save button is clicked");
}
//Staff created and listed in the Staff
@Then("^User can see the Staff \"([^\"]*)\" created and listed in the Staff page$")
public void StaffAvailabilityCheck(String arg1) throws Throwable {
	BranchesPage branchPage=new BranchesPage(driver);
	Thread.sleep(200);
	branchPage.BranchCheck(arg1);
}
//Delete link in Staff Page
@Given("^User clicks the Delete link for <EditedStaffName>$")
public void StaffPage_DeleteLinkClickFunctionalCheck() throws Throwable {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.BranchIDDelete();
}
//Cancel button validation in Staff popup screen
@Then("^User Clicks the cancel button in Staff popup window$") 
public void StaffPage_DeletePopUp_CancelButtonFunctionality() throws Throwable {
	BranchesPage branchesPage=new BranchesPage(driver);
	Thread.sleep(5000);
	branchesPage.BranchDeletepopupCancelButton();
}
//Verifying for the Staff whether available in Staff page
@Then("^User can see the Staff \"([^\"]*)\" listed in the Staffs page$")
public void StaffListingCheck(String arg1) throws Throwable {
	BranchesPage branchPage=new BranchesPage(driver);
	Thread.sleep(500);
	branchPage.BranchCheck(arg1);
}
//Clicking Delete button in Delete Popup 
@Then("^User Clicks the Delete button in Staff popup window$")
public void ClickDeleteButton_DeletePopup() throws Throwable  {
    // Write code here that turns the phrase above into concrete actions
	BranchesPage branchesPage=new BranchesPage(driver);
	Thread.sleep(500);
	branchesPage.BranchListDeletebuttonInPopup();
}
//Verification for the Staff which is not available
@Then("^User cannot see the Staff \"([^\"]*)\" in the Staffs page$")
public void StaffUnavailableInStaffList(String arg1) throws Throwable {
	BranchesPage branchPage=new BranchesPage(driver);
	Thread.sleep(500);
	branchPage.BranchCheckNotAvailable(arg1);
}
//Navigating to Staff page
@Given("^User logs in and navigates to Branch page by clicking Account Menu > Branch$")
public void NavigationToStaffPage() throws Throwable {
	LoginPage loginpage=new LoginPage(driver);
    loginpage.ApplicationLaunchLoginButtonClick();
	loginpage.LoginIntoGuruKulPage("admin","admin");
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.BranchesPageNavigate();     
}
//Creating Branches with Name and Code as part of pre-requisites
@Then("^User creates Branches <BrancheName> and <Code> as a pre-requisites$")
public void CreatingMultipleBranchesForStaff(DataTable testdata) throws Throwable {
	BranchesPage branchPage=new BranchesPage(driver);
	List<List<String>> data = testdata.raw();
	for(int i=1;i<data.size();i++) {
		branchPage.NewBranchButtonClick();
		branchPage.CreateBranch(data.get(i).get(0),data.get(i).get(1));
		logger.info("New Branches are created for Search functionality check");
	}
}
//Creating staff without Branches
@Then("^create four different Staffs  of <Name> without Branch selection$")
public void CreatingStaff_ForBlankBranch(DataTable testdata) throws Throwable {
	StaffPage staffPage=new StaffPage(driver);
	List<List<String>> data = testdata.raw();
	for(int i=1;i<data.size();i++) {
		staffPage.NewStaffButtonClick();
		staffPage.CreateStaff(data.get(i).get(0),data.get(i).get(1));
		
		}
	logger.info("New Staff is created without Branch");
}
}
