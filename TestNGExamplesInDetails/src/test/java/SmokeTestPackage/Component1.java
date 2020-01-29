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

public class Component1 
{
	WebDriver driver;
//@BeforeMethod
public void Fun_MethodBefore(ITestResult result) {
	System.out.println("BeforeMethod > SmokeTestPackage.Component1");
//	System.out.println(result.getMethod().getMethodName());
}
@Test
public void Component1TC1() throws InterruptedException {
	System.out.println("Component1TC1");
}
@Test
public void Component1TC2() throws InterruptedException {
	
	System.out.println("Component1TC2");
}
@Test
public void Component1TC3() throws InterruptedException {
	System.out.println("Component1TC3");
}

//@AfterMethod
public void Fun_MethodAfter(ITestResult result) {
	System.out.println("AfterMethod > SmokeTestPackage.Component1");
	driver.close();
}
}
