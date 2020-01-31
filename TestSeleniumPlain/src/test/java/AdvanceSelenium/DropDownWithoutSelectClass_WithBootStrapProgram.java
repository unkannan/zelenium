package AdvanceSelenium;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DropDownWithoutSelectClass_WithBootStrapProgram {
	
	@Test
	public void DropDownWithoutSelectClass_WithBootStrapProgramTest() throws IOException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
			WebDriver driver = new ChromeDriver();
			
				driver.get("https://www.toolsqa.com/automation-practice-form");
				driver.manage().window().maximize() ;
				//Select sel=new Select(driver.findElement(By.id("continents")));
				//sel.selectByValue("AUS");
				
				//BootStrapProgram
				WebElement cookies=driver.findElement(By.id("cookie_action_close_header"));
				if(cookies.isDisplayed())
					cookies.click();
				driver.findElement(By.id("continents")).click();
				List <WebElement> dropdown_list =driver.findElements(By.xpath("//select[@id='continents']/option"));
				System.out.println(dropdown_list.size());
				
				for(int i=0;i<dropdown_list.size();i++) {
					System.out.println(dropdown_list.get(i).getText());
					if(dropdown_list.get(i).getText().equalsIgnoreCase("South America"))
						dropdown_list.get(i).click();
						//break;
				}
				driver.quit();
	}

}
