package com.org.tests;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.org.pages.HCLMainPage;
import com.org.pages.LeadershipPage;
import com.org.util.StartApplication;

public class HCLWebTests extends StartApplication{
	public static Logger logger = Logger.getLogger(HCLWebTests.class.getName());
	HCLMainPage hclmnpgObj;
	LeadershipPage LeadershipPgObj;
	
	@Test
	public void ValidateShivNadarTextInBODList() {
		 preSteps();
		 String expectedResult="Shiv Nadar";
		 hclmnpgObj.clickLeadershipLink();
		 String actualResult=LeadershipPgObj.ShivNadarTextCheck();
     	logger.info("# actualResult for Shiv Nadar Text is retrieved Successfully for validation");
     	logger.info("# actualResult found : "+actualResult); 
		 assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void SavingShivNadarPhoto() {
		preSteps();
		logger.info("# clicking leadership link");
		hclmnpgObj.clickLeadershipLink();
		logger.info("# Saving Shiv Nadar Photo in Target Folder");
		LeadershipPgObj.savePhoto();
	}
	
	public void preSteps() {
		  hclmnpgObj=new HCLMainPage(driver);
		  LeadershipPgObj=new LeadershipPage(driver);
	}

}
