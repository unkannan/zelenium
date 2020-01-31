package AdvanceSelenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HeadlessBrowser {
	
	@Test
	public void headlessbrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://contentstack.built.io");
        driver.get("https://www.google.co.in/");
        System.out.println("title is: " + driver.getTitle());
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        
        FileUtils.copyFile(scrFile, new File("drivers/pathTOSaveFile.jpg"));
        driver.quit();
	}

}
