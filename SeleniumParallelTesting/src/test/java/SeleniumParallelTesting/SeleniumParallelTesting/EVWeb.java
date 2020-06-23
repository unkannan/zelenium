package SeleniumParallelTesting.SeleniumParallelTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EVWeb {
	
	 @Test
		public void WebTableExcercise1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
			driver.get("https://eudravigilance-human-perf-test.ema.europa.eu");
			driver.manage().window().maximize() ;
			driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a")).click();
			driver.findElement(By.id("username")).sendKeys("MAHTEST01GWU01");	
			driver.findElement(By.id("password")).sendKeys("admin12345_");	
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'ICSR Download')]")).click();
			driver.findElement(By.xpath("//button[contains(text(),'PV obligations reports (L2A)')]")).click();
			driver.findElement(By.xpath("//div[@class='btn-group ng-scope dropdown open']//li[3]")).click();
			
			//ReadExcel();
		//	driver.findElement(by)
			 
			 //driver.close();
		}
	 
}
