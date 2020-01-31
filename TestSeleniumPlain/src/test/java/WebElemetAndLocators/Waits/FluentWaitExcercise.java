package WebElemetAndLocators.Waits;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class FluentWaitExcercise {
	@Test		
	public void fluent_Wait() {
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver79.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/guru99home/" );
		//Maximizes the browser window
		driver.manage().window().maximize() ;
		

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
				.withTimeout(Duration.ofSeconds(20)) 			
				.pollingEvery(Duration.ofSeconds(1)) 			
				.ignoring(WebDriverException.class);
		
		WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
		
			public WebElement apply(WebDriver driver ) {
					System.out.println("check");
						return driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
				}
			
		});
		clickseleniumlink.click();
		driver.close() ;
		}
}
