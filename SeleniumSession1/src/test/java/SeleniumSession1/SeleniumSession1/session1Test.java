package SeleniumSession1.SeleniumSession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

  

public class session1Test {
	
	static WebDriver driver=null;
   
	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
			driver.get("https://www.guru99.com/");
			/*
			System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
				driver.get("https://www.guru99.com/");
			*/
			// System.out.println(driver.getTitle());
			 
			 String gettext=driver.findElement(By.xpath("//h1[@class='thick-heading']")).getText();
			 System.out.println(gettext);
			 
			  gettext=driver.findElement(By.xpath("//a[contains(text(),'MongoDB')]")).getText();
			  System.out.println(gettext);
			  
			  driver.findElement(By.xpath("//div[@class='featured-box cloumnsize1']//ul[1]//li[3]//a[1]")).click();
			 
	}
}
