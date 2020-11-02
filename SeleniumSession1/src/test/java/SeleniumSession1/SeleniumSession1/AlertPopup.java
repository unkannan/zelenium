package SeleniumSession1.SeleniumSession1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopup {
	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.testandquiz.com/selenium/testing.html");

		driver.findElement(By.xpath("//button[contains(text(),'Generate Alert Box')]")).click();
		Thread.sleep(10000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(10000);
		alert.accept();
		
		driver.findElement(By.xpath("/html/body/div/div[12]/div/p[1]/button")).click();
		
		Thread.sleep(10000);
		
		Alert alert1 = driver.switchTo().alert();
		System.out.println(alert1.getText());
		
		Thread.sleep(10000);
		if(alert1.getText().equalsIgnoreCase("Press a button")) 		
			alert1.accept();
		else
			alert1.dismiss();
	}
}
