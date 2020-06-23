package cucumber.stepdefinitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.pages.BranchesPage;
import com.org.pages.LoginPage;
import com.org.util.LoggerHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BranchesFunctionality {
	public static WebDriver driver;
Logger logger=LoggerHelper.getLogger(BranchesFunctionality.class);

//Appliation Lanuches 
@Given("^Branches Feature_User launches the application$")
public void lanuchApplication() {
	driver=CommonPageStepDefinition.lanuchApplication();
}

//Navigating to Branches page
@Given("^User logs in and navigates to Branches page by clicking Account Menu > Branches$")
public void NavigationToBranchesPage() {
	    LoginPage loginpage=new LoginPage(driver);
	    loginpage.ApplicationLaunchLoginButtonClick();
		loginpage.LoginIntoGuruKulPage("admin","admin");
		BranchesPage branchesPage=new BranchesPage(driver);
		branchesPage.BranchesPageNavigate();
}
//Verification of Branches Title 
@Then("^User should be able to see the Branches page$")
public void BranchesPageTitleValidation(){
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.BranchesPageTitleValidation();
}
//clicking the Create New Branch link to navigate Create Branch Page for creating Branches
@Given("^User able to click Create a new Branch link$")
public void clickingCreateNewBranchLink() {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.NewBranchButtonClick();
}
//Create Branch Details Pop Up page verification
@Then("^User should be able to see a popup for creating a Branch$")
public void CreateBranchPopUp() {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.BranchDetailsPopupCheck();
}
//Providing Inputs for Name,Code to Create Branch
@Given("^User provides the details \"([^\"]*)\" and \"([^\"]*)\" in the Create new Branch popup page and clicks Save button$")
public void CreateBranchWithNameCodeInputs(String Name, String Code) {
BranchesPage branchesPage=new BranchesPage(driver);
branchesPage.CreateBranch(Name,Code);
}
//Verifying the Created Branch in the Branch list in Branches Page
@Then("^User can see the Branch \"([^\"]*)\" and \"([^\"]*)\" created and listed in the Branches page$")
public void CreatedBranchVerification(String Name, String Code){
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.BranchCheck(Name,Code);
}
//multiple Branch creations
@Then("^User creates Branches by giving Branch Name <BranchName> in Name field and Code <Code> in code Field in Create Branch popup page and clicks save button$")
public void CreateMultipleBranches(DataTable testdata) throws Throwable {
	BranchesPage branchPage=new BranchesPage(driver);
	List<List<String>> data = testdata.raw();
	for(int i=1;i<data.size();i++) {
		branchPage.NewBranchButtonClick();
		branchPage.CreateBranch(data.get(i).get(0),data.get(i).get(1));
		logger.info("New Branches are created for Search functionality check");
		}
	}
//Cancel Button Validation In Create New Branch PopUp
@Given("^User provides the details \"([^\"]*)\" and \"([^\"]*)\" in the Create new Branch popup page and clicks Cancel button$")
public void CancelButtonValidationInCreateNewBranchPopUp(String Name, String Code) {
BranchesPage branchesPage=new BranchesPage(driver);
branchesPage.EnterNewBranchNametextfield(Name);
branchesPage.EnterNewBranchCodetextfield(Code);
branchesPage.NewBranchCancelButton();
}
//Verifying that Branch should not be listed in Branches Page
@Then("^User cannot see the Branch \"([^\"]*)\" and \"([^\"]*)\" in the Branches page as it is cancelled$")
public void VerifyNonAvailabilityOfBranchInBranchesPageList(String Name, String Code) {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.BranchNotAvailable(Name,Code);
}
//View link validation
@Given("^User clicks the view link for the <NewBranchName> code in the webtable$")
public void ViewLinkValidation()  {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.ClickViewButton();
}
//Branches Detail Screen  Validation where Name and Code is shown for the specific Branch
@Then("^User can see the Branch details$")
public void BranchDetailsScreenValidation()  {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.ViewBranchDetailsScreen();    
}
//Clicking Branch ID link
@Given("^User clicks the Branch ID of given <NewBranchName> in the webtable$")
public void ClickingBranchIDLink()  {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.ClickingBranchID();
}
//Validation Of Name Code in BranchesDetailsScreen
@Then("^User can see the Branch details of \"([^\"]*)\" and \"([^\"]*)\" of the BranchID$")
public void ValidationOfNameCodeinBrancheDetailsScreen(String Name, String Code) {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.ViewBranchDetailsNameCode(Name,Code);
}
//Back Button functional Verification in Branches Details Screen
@Then("^Back should be available in Branch details page and cicking Back button should navigate to Branches page$")
public void BranchesDetailsScreen_BackButtonValidation() {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.clickBackButtonBranchDetailsPage();
}
//Create Branch - Name Text Field Validation of mandatory check , char length
@Then("^Name text field has functionality of mandatory check,minmum char length, max char lenth$")
public void NameTextFieldValidation()  {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.NameTextFieldNewBranchmandatoryfieldCheck();
	branchesPage.MiniumCharLengthValidationNameTextField();
	branchesPage.MaxCharLengthValidationNameTextField();
}
//Create Branch - Code Text Field Validation of mandatory check , char length
@Then("^Code text field has functionality of mandatory check,only digits can be entered$")
public void CodeTextFieldValidation(){
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.CodeTextFieldNewBranchmandatoryfieldCheck();
	branchesPage.MiniumCharLengthValidationCodeTextField();
	branchesPage.OnlyDigitsInputValidationNameTextField();
}
//Edit link validation
@Given("^User clicks Edit link$")
public void EditLinkValidation()  {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.ClickEditButtonBranchList();
}
//Verification of Name,Code availability in Edit Screen page 
@Then("^Name and Code is shown for for \"([^\"]*)\" and \"([^\"]*)\" in Edit Branch page$")
public void EditScreenUIValidation(String Name,String Code)  {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.EditScreenValidation(Name,Code);   
}
//Save Button Functionality
@Given("^User provides the details \"([^\"]*)\" and \"([^\"]*)\" in the Create new Branch popup page and clicks save button$")
public void CreateNewBranch_SaveButtonFunctionality(String Name, String Code) {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.CreateBranch(Name,Code);
}
//Delete Link click in Branches Page 
@Given("^User clicks the Delete link for <EditedBranchName>$")
public void BranchesPage_DeleteLinkFunctionalCheck()  {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.BranchIDDelete();
}
//Cancel Button Validation in Delete Popup window
@Then("^User Clicks the cancel button in popup window$")
public void user_Clicks_the_cancel_button_and_seen_that_Branch_ID_is_not_deleted_and_can_be_seen_in_Branch_details_page()  {
	BranchesPage branchesPage=new BranchesPage(driver);
	branchesPage.BranchDeletepopupCancelButton();
}
//Delete button Action in Delete Popup
@Then("^User Clicks the Delete button in popup window$")
public void DeleteButtonActionInDeletePopup() throws InterruptedException  {
    // Write code here that turns the phrase above into concrete actions
	BranchesPage branchesPage=new BranchesPage(driver);
	Thread.sleep(5000);
	branchesPage.BranchListDeletebuttonInPopup();
}
//Branch should not be available when after Delete function
@Then("^User cannot see the Branch \"([^\"]*)\" and \"([^\"]*)\" created and listed in the Branches page$")
public void BranchUnavaialbleCheck(String Name, String Code) throws InterruptedException {
	BranchesPage branchesPage=new BranchesPage(driver);
	Thread.sleep(3000);
	branchesPage.BranchNotAvailable(Name,Code);
}	   
 }