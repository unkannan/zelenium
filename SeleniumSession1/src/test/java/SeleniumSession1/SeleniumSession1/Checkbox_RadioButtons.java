package SeleniumSession1.SeleniumSession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkbox_RadioButtons {
	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
	//	WebDriver driver = new ChromeDriver();

			ChromeOptions options = new ChromeOptions();
	        options.addArguments("headless");
	        options.addArguments("window-size=1200x600");
	        
	        WebDriver driver = new ChromeDriver(options);

		// 1. open the url and get the page title
		driver.get("https://www.testandquiz.com/selenium/testing.html");
        System.out.println(driver.getTitle());
		WebElement maleRadioBtn=driver.findElement(By.id("male")); // Radio button
		
		System.out.println(maleRadioBtn.getTagName());
		System.out.println(maleRadioBtn.getText());
		driver.findElement(By.id("female")).click(); // Radio button

		driver.findElement(By.className("Automation")).click(); // checkbox
		driver.findElement(By.xpath("//input[@class='Performance']")).click(); // checkbox
		
		/*
		System.setProperty("webdriver.chrome.driver", ChromeExePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("window-size=1200x600");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://contentstack.built.io");
        driver.get("https://www.google.co.in/");
        System.out.println("title is: " + driver.getTitle());
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        
        FileUtils.copyFile(scrFile, new File("C:\\Users\\kannanu\\Downloads\\chromedriver_win32 (2)\\pathTOSaveFile.jpg"));
        driver.quit();
*/
		
		
	}
}
