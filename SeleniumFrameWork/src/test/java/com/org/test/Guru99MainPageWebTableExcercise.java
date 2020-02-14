package com.org.test;


import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.org.utility.ConfigFileReader;
import com.org.utility.StartApplication;
import com.org.pages.Guru99MainPage;

public class Guru99MainPageWebTableExcercise extends StartApplication{
	private static Properties prop = ConfigFileReader.ReadProperties();
	Guru99MainPage Guru99MainPage;
	
	@Test
	public void WebTableExcercise() {
		Guru99MainPage=new Guru99MainPage(driver);
			
		Guru99MainPage.WebTableElementsCheck();
			
				
		}
		
		@Test
		public void WebTableExcercise1() {
			driver.get("https://www.techbeamers.com/");
			
			// driver.findElement(By.linkText("Python Tutorial – Beginners")).click();
			 
			 List<WebElement> WebTableElement= driver.findElements(By.xpath("//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]/ul"));
			 List elements= driver.findElements(By.xpath("//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]/ul[1]/li"));
			 
			 for(WebElement e : WebTableElement) {
					System.out.println(e.getText());
				}
			 
			 driver.close();
			 driver.quit();
		}

}
