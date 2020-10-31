package SeleniumSession1.SeleniumSession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Buttons_textbox {
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe"); // 
		WebDriver driver = new ChromeDriver();
			
		//1. open the url  and get the page title
			driver.get("https://www.testandquiz.com/selenium/testing.html");
			String title=driver.getTitle();
			System.out.println(title);
		//2. enter the text in text box
			  driver.findElement(By.id("fname")).sendKeys("Selenium Session");
		//3. click the submit button
			  driver.findElement(By.id("idOfButton")).click();		  
		//4. click the link
			  String linkTextStr=driver.findElement(By.linkText("This is a link")).getText();
			  System.out.println(linkTextStr);
			    if(linkTextStr.equalsIgnoreCase("This is a link")) {
			    	System.out.println("my test case is passed");
			    }
			  driver.findElement(By.linkText("This is a link")).click();
			  Thread.sleep(1000);
			   driver.navigate().back();// navigating to the previous page
			   //driver.quit();
			   
			   //relative xpath
			    	String header=driver.findElement(By.xpath("//div[@class='col-md-offset-2 col-md-8']")).getText();
			    	   System.out.println(header);
			    	   
			   //Absolute xpath
			    	   String header1=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]")).getText();
			    	   System.out.println(header1);
			    	   
			    	   driver.findElement(By.id("male")).click(); //Radio button
			    	   Thread.sleep(5000);
			    	   driver.findElement(By.id("female")).click(); //Radio button
			    
			    	   driver.findElement(By.className("Automation")).click();  //checkbox
			    	   driver.findElement(By.xpath("//input[@class='Performance']")).click();  //checkbox
	}
}





