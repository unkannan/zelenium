package WebElemetAndLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTableExcercise {
	@Test
		public void WebTableExcercise() {
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://demo.guru99.com/test/write-xpath-table.html");
			
			List<WebElement> WebTableElement=driver.findElements(By.xpath("//html//body//center//table//tbody/tr/td"));
			
			for(WebElement e : WebTableElement) {
				System.out.println(e.getText());
				if(e.getText().equalsIgnoreCase("second cell"))
					System.out.println(e.getText());
			}
			
			List list=driver.findElements(By.xpath("//html//body//center//table//tbody/tr"));
				int count=list.size();
				
				System.out.println(list.size());
				
				for(int i=0;i<count;i++) {
					String svalue=list.get(i).toString();
				}
				driver.close();	
		}
		
		@Test
		public void WebTableExcercise1() {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
		WebDriver driver = new ChromeDriver();
			driver.get("https://www.techbeamers.com/");
			
			// driver.findElement(By.linkText("Python Tutorial – Beginners")).click();
			 
			 List<WebElement> WebTableElement= driver.findElements(By.xpath("//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]/ul"));
			 List elements= driver.findElements(By.xpath("//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]/ul[1]/li"));
			 
			 for(WebElement e : WebTableElement) {
					System.out.println(e.getText());
				}
			 
			 driver.close();
		
		}

}
