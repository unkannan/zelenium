package TestSeleniumPlain.TestSeleniumPlain;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SampleTest {
	String path = System.getProperty("user.dir");
	String ChromeExePath=path+"\\src\\resources\\chromedriver.exe";
	WebDriver driver=null;
	
	//@Test
	public void WithNullAmount() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\devtools\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		
		driver.get("https://transferwise.com/ie/currency-converter/");
			driver.findElement(By.id("cc-amount")).sendKeys("");
				WebElement SourceCurrencyWebElement=driver.findElement(By.id("sourceCurrency"));
						CurrencySelectionFromDropList(SourceCurrencyWebElement,"EUR");
					WebElement targetCurrencyWebElement=driver.findElement(By.id("targetCurrency"));
						CurrencySelectionFromDropList(targetCurrencyWebElement,"USD");
							driver.findElement(By.id("convert")).click();
								Thread.sleep(2000);
								String SourceCurrency=driver.findElement(By.xpath("//div[@class='btn-group bootstrap-select js-SourceCurrency currencies-select']//button[@class='btn dropdown-toggle btn-input']")).getText();
						 		//System.out.println(SourceCurrency.trim());
								//System.out.println("EUR");
								assertEquals(SourceCurrency.trim(), "EUR");
								
								String TargetCurrency=driver.findElement(By.xpath("//div[@class='btn-group bootstrap-select js-TargetCurrency currencies-select']//button[@class='btn dropdown-toggle btn-input']")).getText();
								//System.out.println(TargetCurrency);
								assertEquals(TargetCurrency.trim(), "USD");
							   
				String Amount=driver.findElement(By.id("cc-amount-from")).getAttribute("value");
				//System.out.println(Amount);
				assertEquals(Amount.trim(), "1");		 
						
						String Converted_to_Amount=driver.findElement(By.id("cc-amount-to")).getAttribute("value");
						String ConvertedAmountDisplay=driver.findElement(By.xpath("//span[contains(text(),'USD')]")).getText();
						System.out.println(Converted_to_Amount);
						System.out.println(ConvertedAmountDisplay);
					//	assertEquals(Converted_to_Amount, ConvertedAmountDisplay);
						
				
	}
	
	private String GetCurrencyValuedromDropList(WebElement ele) {
		Select sel=new Select(ele);
		   String SelectedValue=sel.getFirstSelectedOption().getText();
		   System.out.println(SelectedValue);
		return SelectedValue;
		 
		
	}

	void CurrencySelectionFromDropList(WebElement ele,String SourceCurrency) {
		 
		Select sel=new Select(ele);
		   sel.selectByValue(SourceCurrency);
		     
	} 
	
	
	// @Test
	 private static WebElement findElement(final WebDriver driver, final By locator, final int timeoutSeconds) {
	      FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	              .withTimeout(Duration.ofSeconds(10))
	              .pollingEvery(Duration.ofSeconds(1))
	              .ignoring(NoSuchElementException.class);
	      return wait.until(new Function<WebDriver, WebElement>()
	      {
	          public WebElement apply(WebDriver webDriver) {
	                 if(driver.findElement(locator).isDisplayed())
	                	 return driver.findElement(locator);
	                 else
	                	 {
	                	     System.out.println("pooling");
	                	     return null;
	                	 }
	          }
	      });
	}
   
	
	
	

}
