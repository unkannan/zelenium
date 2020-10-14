package SeleniumSession1.SeleniumSession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectExample {
	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe"); // 
		WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.testandquiz.com/selenium/testing.html");
	
			WebElement element=driver.findElement(By.className("Performance"));
			element.click();
			element.getText();
			
			//Select button
			WebElement selectbtn=driver.findElement(By.id("testingDropdown")); // select webelement
				//selectbtn.click();
				
			Select sel=	new Select(selectbtn);
				sel.selectByIndex(1); //performance testing
				sel.selectByValue("Manual");
				sel.selectByVisibleText("Database Testing");
			//Select completed
				
				//Listing all items from the dropdown
				
			    List<WebElement> ListItems = selectbtn.findElements(By.xpath("//select[@id='testingDropdown']/option"));
			    for ( WebElement we: ListItems) { 
			        System.out.println(we.getText());
			    }
	}
}
