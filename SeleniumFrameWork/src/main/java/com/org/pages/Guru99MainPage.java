package com.org.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Guru99MainPage{

  // private String xpathTargetSearchBox="//input[@placeholder='Search...']";
   WebDriver driver;
   
   public Guru99MainPage(WebDriver driver) {
      // super(driver);
       this.driver = driver; 
   }

   public void WebTableElementsCheck() {
	   List<WebElement> WebTableElement=driver.findElements(By.xpath("//html//body//center//table//tbody/tr/td"));
		
		for(WebElement e : WebTableElement) {
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase("second cell"))
				System.out.println(e.getText());
		}
		
		List list=driver.findElements(By.xpath("//html//body//center//table//tbody/tr"));
			int count=list.size();
			
			System.out.println(list.size());
			
			for(int i=0;i<count;i++) {
				String svalue=list.get(i).toString();
			}
   }
  
    
}