package DriverFactory.DriverFactory;

import com.org.enums.DriverType;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.Drivers.DriverManager;
import com.org.Drivers.DriverManagerFactory;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	DriverManager driverManager;
	WebDriver driver;
	@BeforeMethod
	public void TestInitialize() {
		//System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
		//WebDriver driver = new ChromeDriver();
		driverManager =DriverManagerFactory.getManager(DriverType.CHROME);
		driver=driverManager.getDriver();
	}
    @Test
	public void WebTableExcercise1() {
	//System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
	//WebDriver driver = new ChromeDriver();
		driver.get("https://www.techbeamers.com/");
		
		// driver.findElement(By.linkText("Python Tutorial – Beginners")).click();
		 
		 List<WebElement> WebTableElement= driver.findElements(By.xpath("//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]/ul"));
		 for(WebElement e : WebTableElement) {
				System.out.println(e.getText());
			}
		 driver.close();
	}
    
    @Test
	public void DropDownWithoutSelectClass_WithBootStrapProgramTest() throws IOException {
		//System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
		//	WebDriver driver = new ChromeDriver();
			
				driver.get("https://www.toolsqa.com/automation-practice-form");
				driver.manage().window().maximize() ;
				//Select sel=new Select(driver.findElement(By.id("continents")));
				//sel.selectByValue("AUS");
				
				//BootStrapProgram
				WebElement cookies=driver.findElement(By.id("cookie_action_close_header"));
				if(cookies.isDisplayed())
					cookies.click();
				driver.findElement(By.id("continents")).click();
				List <WebElement> dropdown_list =driver.findElements(By.xpath("//select[@id='continents']/option"));
				System.out.println(dropdown_list.size());
				
				for(int i=0;i<dropdown_list.size();i++) {
					System.out.println(dropdown_list.get(i).getText());
					if(dropdown_list.get(i).getText().equalsIgnoreCase("South America"))
						dropdown_list.get(i).click();
						//break;
				}
				driver.quit();
	}

    @Test
	public void GooglePage() {
	//	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver79.exe");
	//	WebDriver driver=new ChromeDriver();
		Boolean found = false;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Selenium WebDriver Interview questions");
		//sending keys return 
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		driver.quit();
	}
}
