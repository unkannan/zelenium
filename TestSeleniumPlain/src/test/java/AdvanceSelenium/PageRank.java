package AdvanceSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageRank {
	
	@Test
	public void PageRank() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver79.exe");
		WebDriver driver=new ChromeDriver();
		Boolean found = false;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver Interview questions");
		//sending keys return 
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
	}

}
