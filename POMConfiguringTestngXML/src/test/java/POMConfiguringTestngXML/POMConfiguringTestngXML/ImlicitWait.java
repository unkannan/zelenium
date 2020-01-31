package POMConfiguringTestngXML.POMConfiguringTestngXML;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ImlicitWait {
	
	//Example for using pageloadtimeout
		//1. which implies that the maximum wait time is 20 seconds for the particular element to load or to arrive at the output
		//2. Implicitly wait is applied globally, which means it is always available for all the web elements throughout the driver instance
		//3. it implies that if the driver is interacting with 100 elements, then implicitly wait is applicable for all the 100 elements.
		@Test
		public void ImplicitlyWait() throws IOException {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
			WebDriver driver = new ChromeDriver();
				System.out.println(LocalDateTime.now());
					
					driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
					
			driver.get("https://contentstack.built.io");
	        driver.quit();
	        	System.out.println(LocalDateTime.now());
		}
			

}
