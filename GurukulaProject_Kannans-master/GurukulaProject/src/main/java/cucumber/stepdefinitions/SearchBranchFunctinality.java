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
import cucumber.api.java.en.When;

public class SearchBranchFunctinality {
	
	public static WebDriver driver;
	Logger logger=LoggerHelper.getLogger(SearchBranchFunctinality.class);
	
	@Given("^Search_Branch_Feature_User launches the application and navigates to Account Menu > Branches with default admin login$")
	public void launchesApplication() throws Throwable {
		driver=CommonPageStepDefinition.lanuchApplication();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.ApplicationLaunchLoginButtonClick();
		loginpage.LoginIntoGuruKulPage("admin","admin");
		BranchesPage branchPage=new BranchesPage(driver);
		branchPage.BranchesPageNavigate();
	}

	@Then("^Navigate to Account menu > Branches and create four different Branches  of <Name> and <Code>$")
	public void CreateBranches(DataTable testdata) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		List<List<String>> data = testdata.raw();
		for(int i=1;i<data.size();i++) {
			branchPage.NewBranchButtonClick();
			branchPage.CreateBranch(data.get(i).get(0),data.get(i).get(1));
			logger.info("New Branches are created for Search functionality check");
		}    
	}

	@When("^user search for the branch using branch name \"([^\"]*)\"$")
	public void SearchBranchName(String arg1) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		branchPage.BranchSearch(arg1);
	}

	@Then("^branch details should be shown in the branch list for \"([^\\\"]*)\"$")
	public void BranchResultsCheck(String arg1) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		Thread.sleep(3000);
		branchPage.BranchCheck(arg1);   
	}
 
	@Then("^branch details should NOT be shown for \"([^\"]*)\" search criteria as it is partinal name$")
	public void BranchNotAvailableCheckInResultsPage(String arg1) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		branchPage.BranchNotAvailable(arg1);
	}

	@When("^user search for the branch using branch name with <lowercasesANDuppercases> then branch details should be shown$")
	public void LoweCaseInputValidationforBranchSearch(DataTable testdata) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		List<List<String>> data = testdata.raw();
		for(int i=1;i<data.size();i++) {
			branchPage.BranchSearch(data.get(i).get(0));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			branchPage.BranchCheck(data.get(i).get(0));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@When("^user search for the branch using branch name with \"([^\"]*)\"$")
	public void SearchWithBranchName(String arg1) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		branchPage.BranchSearch(arg1);
	}

	@Then("^branch details should be shown for code \"([^\"]*)\"$")
	public void BrachDetailsVerification(String arg1) throws Throwable {
		BranchesPage branchPage=new BranchesPage(driver);
		branchPage.BranchCheck(arg1);
	}
	

   @When("^user search for the branch using branch name with <workwithspaces> then branch details should NOT be shown$")
public void SearchTextwithSpaces(DataTable testdata) throws Throwable {
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

   @When("^user search for the branch using branch ID with \"([^\"]*)\"$")
   public void SearchwithBranchID(String ID) throws Throwable {
	   BranchesPage branchPage=new BranchesPage(driver);
	   branchPage.BranchSearch(ID);
   }

   @Then("^branch details should be shown with \"([^\"]*)\"$")
   public void BranchSearchResultsForBranchID(String ID) throws Throwable {
	   BranchesPage branchPage=new BranchesPage(driver);
	   branchPage.BranchCheck(ID);
   }
   @When("^user search for <invalidcharacters> criteria and seen that search page will not shown any results$")
   public void SearchwithInvalidChars(DataTable testdata) throws Throwable {
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
   
   @When("^user search for the branch using \"([^\"]*)\" name where results are not shown$")
   public void BranchResultsNotShowingUp(String arg1) throws Throwable {
	   BranchesPage branchPage=new BranchesPage(driver);
	   branchPage.BranchSearch(arg1);
   }

   @When("^user search by removing the critiera and clicks the search with blank in search text field$")
   public void SearchwithBlankChars() throws Throwable {
	   BranchesPage branchPage=new BranchesPage(driver);
	   branchPage.BranchSearch("");
   }

   @Then("^all branch details should be shown in the branch list$")
   public void BranchDetailsShowUp() throws Throwable {
	   BranchesPage branchPage=new BranchesPage(driver);
	   branchPage.BranchCheck("ONEBRANCHSELENIUM");
   }
   
   


}
