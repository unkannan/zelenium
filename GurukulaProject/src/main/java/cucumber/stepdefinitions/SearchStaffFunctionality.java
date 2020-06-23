package cucumber.stepdefinitions;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.org.pages.BranchesPage;
import com.org.pages.LoginPage;
import com.org.pages.StaffPage;
import com.org.util.LoggerHelper;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchStaffFunctionality {
	
	public static WebDriver driver;
	Logger logger=LoggerHelper.getLogger(SearchStaffFunctionality.class);
	
	@Given("^Search_Staff_Feature_User launches the application and navigates to Account Menu > Staffes with default admin login$")
	public void LaunchesApplication_NavigatesStaffPage() throws Throwable {
	    driver=CommonPageStepDefinition.lanuchApplication();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.ApplicationLaunchLoginButtonClick();
		loginpage.LoginIntoGuruKulPage("admin","admin");
		StaffPage searchStaffPage=new StaffPage(driver);
		searchStaffPage.StaffPageNavigate();
	}
	@Then("^Navigate to Account menu > Staffs and create four different Staffs  of <Name> and <Branch>$")
	public void CreateStaffs(DataTable testdata) throws Throwable {
		StaffPage staffPage=new StaffPage(driver);
		List<List<String>> data = testdata.raw();
		for(int i=1;i<data.size();i++) {
			staffPage.NewStaffButtonClick();
			staffPage.CreateStaff(data.get(i).get(0),data.get(i).get(1));
			logger.info("New Branches are created for Search functionality check");
		}
	}	
	@When("^user search for the Staff using Staff name \"([^\"]*)\"$")
	public void SearchStaff(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BranchesPage branchPage=new BranchesPage(driver);
		branchPage.BranchSearch(arg1);
	}
	@Then("^Staff details should be shown in the Staff list for \"([^\"]*)\"$")
	public void StaffAvailableCheckInList(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		BranchesPage branchPage=new BranchesPage(driver);
		branchPage.BranchCheck(arg1);
	}
	@Then("^Staff details should NOT be shown for \"([^\"]*)\" search criteria as it is partial name$")
	public void PartialInputSearchForStaff(String arg1) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		branchPage.BranchNotAvailable(arg1);	   
	}
	@When("^user search for the Staff using Staff name with <lowercasesANDuppercases> then Staff details should be shown$")
	public void LoweCasesInputSearchForStaff(DataTable testdata) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		List<List<String>> data = testdata.raw();
		for(int i=1;i<data.size();i++) {
			branchPage.BranchSearch(data.get(i).get(0));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			branchPage.BranchCheck(data.get(i).get(0));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	  
	@When("^user search for the Staff using Staff name with <workwithspaces> then Staff details should NOT be shown$")
	public void TextWithSpacesInputSearchForStaff(DataTable testdata) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		List<List<String>> data = testdata.raw();
		for(int i=1;i<data.size();i++) {
			branchPage.BranchSearch(data.get(i).get(0));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			branchPage.BranchNotAvailable(data.get(i).get(0));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	   
	}

	@When("^user search for the Staff using Staff ID with \"([^\"]*)\"$")
	public void SearchWIthStaffID(String arg1) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		   branchPage.BranchSearch(arg1);
	}

	@Then("^Staff details should be shown with \"([^\"]*)\"$")
	public void VerifyStaffDetails(String arg1) throws Throwable {
		 BranchesPage branchPage=new BranchesPage(driver);
		   branchPage.BranchCheck(arg1);
	}

	@When("^user search for staff with invalid characters <invalidcharacters> and see that search page will not shown any results$")
	public void InvalidCharsInputSearchForStaff(DataTable testdata) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		List<List<String>> data = testdata.raw();
		for(int i=1;i<data.size();i++) {
			branchPage.BranchSearch(data.get(i).get(0));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			branchPage.BranchNotAvailable(data.get(i).get(0));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@When("^user search for the Staff using \"([^\"]*)\" name where results are not shown$")
	public void user_search_for_the_Staff_using_name_where_results_are_not_shown(String arg1) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		   branchPage.BranchSearch(arg1);
	}
	@When("^user clears the search criteria and clicks the search with blank in search text field$")
	public void SearchingStaffWithBlankInput() throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		   branchPage.BranchSearch("");
	}
	@Then("^all Staff details should be shown in the Staff list$")
	public void StaffDetailsPageVerificationforBranch() throws Throwable {
		 BranchesPage branchPage=new BranchesPage(driver);
		   branchPage.BranchCheck("ONEBRANCHSELENIUM");
	}
}
