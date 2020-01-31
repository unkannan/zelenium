package WithoutTestNG_WithoutJunit_OnlyWithMain;



import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class WithOutTestNGTestAnnotationInsideMain 
{
    public static void main( String[] args ) throws IOException
    {
    	System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
		WebDriver driver = new ChromeDriver();
	 
		driver.get("https://www.techbeamers.com/");
		
		// driver.findElement(By.linkText("Python Tutorial – Beginners")).click();
		 
		 List<WebElement> WebTableElement= driver.findElements(By.xpath("//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]/ul"));
		 driver.findElements(By.xpath("//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]/ul[1]/li"));
		 
		 for(WebElement e : WebTableElement) {
				System.out.println(e.getText());
			}
		 
		 driver.close();
		 driver.quit();
    }
}
