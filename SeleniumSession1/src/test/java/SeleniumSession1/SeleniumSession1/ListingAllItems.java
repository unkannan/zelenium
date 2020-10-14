package SeleniumSession1.SeleniumSession1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListingAllItems {
	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe"); // 
		WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.guru99.com/");
			
			WebElement ulClassEle=driver.findElement(By.xpath("//div[@class='featured-box cloumnsize1']//ul[1]"));
			 List<WebElement> ListItems = ulClassEle.findElements(By.xpath("//div[@class='featured-box cloumnsize1']//ul[1]/li"));
			    for ( WebElement we: ListItems) { 
			        System.out.println(we.getText());
			    }
			    
			    WebElement SAPElement=driver.findElement(By.xpath("//section[@id='g-showcase']//div[2]//div[1]//ul[1]")); //parent
			    
				 List<WebElement> ListItems1 = SAPElement.findElements(By.xpath("//section[@id='g-showcase']//div[2]//div[1]//ul[1]/li")); //childs
				    for ( WebElement we: ListItems1) { 
				        System.out.println(we.getText());
				    }
	}
	
	

}
