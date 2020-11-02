package SeleniumSession1.SeleniumSession1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchTO {

	 @Test
	public void WindowHandle1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();

		// Launching the site.
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

		String MainWindow = driver.getWindowHandle();

		// To handle all new opened window.
		Set<String> winHandles = driver.getWindowHandles();
		//Iterator<String> i1 = s1.iterator();

		for (String handle : winHandles) {
			//String ChildWindow = i1.next();

			if (!MainWindow.equalsIgnoreCase(handle)) {

				// Switching to Child window
				driver.switchTo().window(handle);
				driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail");

				driver.findElement(By.name("btnLogin")).click();

				// Closing the Child Window.
				driver.close();
			}
		}
		// Switching to Parent window i.e Main Window.
		driver.switchTo().window(MainWindow);
	}

	@Test
	public void WindowHandle2() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");

		// Get current window handle
		String parentWinHandle = driver.getWindowHandle();
		System.out.println("Parent window handle: " + parentWinHandle);
		// Locate 'Click to open a new browser window!' button using id
		WebElement newWindowBtn = driver.findElement(By.id("win1"));
		// Click the button to open a new window
		newWindowBtn.click();
		// Get the window handles of all open windows
		Set<String> winHandles = driver.getWindowHandles();
		// Loop through all handles
		for (String handle : winHandles) {
			if (!handle.equals(parentWinHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(1000);
				System.out.println("Title of the new window: " + driver.getTitle());
				System.out.println("Closing the new window...");
				driver.close();
			}
		}
		// Switching the control back to parent window
		driver.switchTo().window(parentWinHandle);
		// Print the URL to the console
		System.out.println("Parent window URL: " + driver.getCurrentUrl());
	}
}