package WebElemetAndLocators;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Alerts {
		@Test
		public void AlertsExamples() throws InterruptedException {
			
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
			   WebDriver driver=new ChromeDriver(); 
			
			driver.get("https://www.toolsqa.com/handling-alerts-using-selenium-webdriver");
			   driver.findElement(By.xpath("//*[@id=\"content\"]/p[3]/button")).click();
			   Thread.sleep(5000);
			   	Alert alert1=driver.switchTo().alert();    
			   	   		 System.out.println(alert1.getText());
			   	   		 alert1.accept(); 
			   	   	driver.close();
		}

}
