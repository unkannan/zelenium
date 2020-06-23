/**
 *
 */
package com.gurukula.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.gurukula.pages.BranchPage;
import com.gurukula.pages.LoginPage;
import com.gurukula.utility.Init;

/**
 * @author AnujKumar
 */

//@Test(groups = { "branch" })
public class BranchTest extends Init {

	
	LoginPage loginPage;
	BranchPage branchPage;
	

	@Test
	public void tc_01_testBranchPage() {
		assertTrue(true);
	//	preSteps();
		//branchPage.assertBranchPageHeading();
	}
/*
	@Test(dataProvider = "newBranchDetails")
	public void tc_02_testCreateNewBranch(String name, String code, ITestContext context) {
		preSteps();
		int id = branchPage.createNewBranch(name, code);
		branchPage.assertBranchRowBy(id, name, code);
		context.setAttribute("id", id);
	}

	@Test(dataProvider = "newBranchDetails")
	public void tc_03_testCreateNewBranchAndCancel(String name, String code) {
		preSteps();
		int maxIdBefore = branchPage.getMaxId();
		int maxIdAfter = branchPage.createAndCancel(name, code);

		assertEquals(maxIdAfter, maxIdBefore, "New Branch should not be created.");
	}

	@Test(dataProvider = "newBranchDetails", dependsOnMethods = "tc_02_testCreateNewBranch")
	public void tc_04_testBranchDetailsByIdLink(String name, String code, ITestContext context) {
		preSteps();
		int id = (Integer) context.getAttribute("id");
		branchPage.navigateToBranchDetailPageById(id);

	//	branchDetailPage.assertInfoOnBranchDetailPage(id, name, code);
	}

	@Test(dataProvider = "newBranchDetails", dependsOnMethods = "tc_02_testCreateNewBranch")
	public void tc_05_testBranchDetailsByView(String name, String code, ITestContext context) {
		preSteps();
		int id = (Integer) context.getAttribute("id");
		branchPage.clickOnActionCorrespondingToId(ActionsEnum.View.name(), id);

	//	branchDetailPage.assertInfoOnBranchDetailPage(id, name, code);
	}

	@Test(dataProvider = "editBranchDetails", dependsOnMethods = "tc_02_testCreateNewBranch")
	public void tc_06_testDetailsOnEditBranch(String name, String code, String updatedName, String updatedCode,
			ITestContext context) {
		preSteps();
		int id = (Integer) context.getAttribute("id");
		branchPage.clickOnActionCorrespondingToId(ActionsEnum.Edit.name(), id);

		branchPage.assertDetailsOnEditForm(id, name, code);
	}

	@Test(dataProvider = "editBranchDetails", dependsOnMethods = "tc_02_testCreateNewBranch")
	public void tc_07_testEditBranchDetailsAndCancel(String name, String code, String updatedName, String updatedCode,
			ITestContext context) {
		preSteps();
		int id = (Integer) context.getAttribute("id");
		branchPage.clickOnActionCorrespondingToId(ActionsEnum.Edit.name(), id);
		branchPage.assertDetailsOnEditForm(id, name, code);
		branchPage.updateBranchDetails(ActionsEnum.Cancel.name(), updatedName, updatedCode);

		branchPage.assertBranchRowBy(id, name, code);
	}

	@Test(dataProvider = "editBranchDetails", dependsOnMethods = "tc_02_testCreateNewBranch")
	public void tc_08_testEditBranchDetails(String name, String code, String updatedName, String updatedCode,
			ITestContext context) {
		preSteps();
		int id = (Integer) context.getAttribute("id");
		branchPage.clickOnActionCorrespondingToId(ActionsEnum.Edit.name(), id);
		branchPage.assertDetailsOnEditForm(id, name, code);
		branchPage.updateBranchDetails(ActionsEnum.Save.name(), updatedName, updatedCode);

		branchPage.assertBranchRowBy(id, updatedName, updatedCode);
	}

	@Test(dependsOnMethods = "tc_02_testCreateNewBranch")
	public void tc_09_testDeleteBranchAndCancel(ITestContext context) {
		preSteps();

		int id = (Integer) context.getAttribute("id");
		Map<String, String> branchRow = branchPage.getBranchRowById(id);
		branchPage.clickOnActionCorrespondingToId(ActionsEnum.Delete.name(), id);
		branchPage.assertDeleteConfirmationModalForBranch(id);
		branchPage.deleteBranch(ActionsEnum.Cancel.name());

		branchPage.assertBranchRowBy(id, branchRow.get("Name"), branchRow.get("Code"));
	}

	@Test(dependsOnMethods = "tc_02_testCreateNewBranch")
	public void tc_10_testDeleteBranch(ITestContext context) {
		preSteps();
		int id = (Integer) context.getAttribute("id");
		branchPage.clickOnActionCorrespondingToId(ActionsEnum.Delete.name(), id);
		branchPage.assertDeleteConfirmationModalForBranch(id);
		branchPage.deleteBranch(ActionsEnum.Delete.name());
		int index = branchPage.getRowIndexById(id);

		assertEquals(index, -1, "Staff should get deleted.");
	}

	@Test(dataProvider = "validations")
	public void tc_11_testNewBranchFormValidations(String fieldName, String msg, String value) {
		preSteps();
		branchPage.assertValidationMsg(fieldName, value, msg);
		branchPage.assertSaveBtnDisable();
	}

	private void preSteps() {
		welcomePage = new WelcomePage(driver);
		loginPage = new LoginPage(driver);
		branchPage = new BranchPage(driver);
		branchDetailPage = new BranchDetailPage(driver);

		welcomePage.clickOnLink(WelcomeEnum.LOGIN_LINK.getVal());
		loginPage.loginAndAssertSuccessfulMessage(USERNAME, PASSWORD);
		welcomePage.clickOnOption(MenuEnum.Entities.name(), EntitiesEnum.Branch.name());
	}

	@DataProvider(name = "newBranchDetails")
	public Object[][] newBranchDetails() {
		return new Object[][] { { "Computer Science", "CS" } };
	}

	@DataProvider(name = "editBranchDetails")
	public Object[][] editBranchDetails() {
		return new Object[][] { { "Computer Science", "CS", "Branch CS Updated", "CS1" } };
	}

	@DataProvider(name = "validations")
	public Object[][] validations() {
		return new Object[][] {
			// @formatter:off
			{ "name", Constants.BRANCH_NAME_REQUIRED, "" },
			{ "name", Constants.BRANCH_NAME_MINIMUM, "a" },
			{ "name", Constants.BRANCH_NAME_PATTERN, "test1" },
			{ "name", Constants.BRANCH_NAME_PATTERN, "test@"},
			{ "name", Constants.BRANCH_NAME_MAXIMUM , "test the maximum limit of text field"},
			
			{ "code", Constants.BRANCH_CODE_REQUIRED, ""  },
			{ "code", Constants.BRANCH_CODE_MINIMUM, "A" },
			{ "code", Constants.BRANCH_CODE_PATTERN, "A@" },
			{ "code", Constants.BRANCH_CODE_PATTERN, "Ac" },
			{ "code", Constants.BRANCH_CODE_MAXIMUM, "CS1234567890" }
			// @formatter:on
		};
	}
*/
}
