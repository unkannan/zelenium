package SmokeTestPackage;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Component2 
{
	  WebDriver driver; 
//@BeforeMethod
public void Fun_MethodBefore(ITestResult result) {
	System.out.println("BeforeMethod > SmokeTestPackage.Component2");
//	System.out.println(result.getMethod().getMethodName());
}
@Test
public void Component2TC1() throws InterruptedException {
	System.out.println("SmokeTestPackage > Component1 TC2");
	 
	   System.setProperty("webdriver.chrome.driver","C:\\SeleniumGrid\\chromedriver.exe");//
		driver=new ChromeDriver();
		
			driver.get("http://www.google.com");
				  driver.findElement(By.id("gb_70")).click(); 
				  		driver.findElement(By.xpath("//div/input[@name='identifier']")).sendKeys("kk@gmail.com");
				  			driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();  //Next button click
}

//@AfterMethod
public void Fun_MethodAfter(ITestResult result) {
	System.out.println("BeforeMethod > SmokeTestPackage.Component2");
	//driver.close();
}
}
