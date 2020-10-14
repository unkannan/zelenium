package SeleniumSession1.SeleniumSession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();
    driver.get("http://demo.guru99.com/test/guru99home/"); 
       // navigates to the page consisting an iframe

       driver.manage().window().maximize();  //  to maximize the window
       
       driver.switchTo().frame("a077aa5e");
      
       driver.findElement(By.xpath("/html/body/a/img")).click();
       
       try {
   	    driver.findElement(By.id("philadelphia-field-email")).sendKeys("kannan");
   	    }catch(Exception e) {
   	    	driver.switchTo().defaultContent();
   	     // driver.switchTo().parentFrame();
   	     	driver.findElement(By.id("philadelphia-field-email")).sendKeys("kannan");
   	    	e.printStackTrace();
   	    	}
	}
}
