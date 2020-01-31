package AdvanceSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentResports {
	@Test
	public void ExtentReportsTest() {
		 ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		 ExtentTest test = report.startTest("ExtentReportsTest");


		 System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
			WebDriver driver = new ChromeDriver();
		
			test.log(LogStatus.FAIL, "Navigated to the specified URL");
			
		 report.endTest(test);
		 report.flush();
		 report.close();
		 driver.close();

	}
	
}
