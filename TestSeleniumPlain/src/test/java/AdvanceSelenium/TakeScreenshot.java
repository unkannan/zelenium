package AdvanceSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenshot {
	@Test
		public void TestScreenshot() throws IOException {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver79.exe");
			WebDriver driver=new ChromeDriver();
			TakesScreenshot ts=(TakesScreenshot) driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			File DestFile=new File("c:\\Data\\kk.jpg");

		FileUtils.copyFile(src, DestFile);
		}

}
