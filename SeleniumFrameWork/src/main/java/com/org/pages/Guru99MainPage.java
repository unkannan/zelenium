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

   @SuppressWarnings("null")
public String[] WebTableElementsCheck() {
	   driver.get("http://demo.guru99.com/test/write-xpath-table.html");
	   List<WebElement> WebTableElement=driver.findElements(By.xpath("//html//body//center//table//tbody/tr/td"));
		String[] listsize = new String[WebTableElement.size()];
		int i=0;
		for(WebElement e : WebTableElement) {
			System.out.println(e.getText());
			listsize[i++]=e.getText();
		}
		return listsize;
   }

   public int getListSize() {
	   driver.get("http://demo.guru99.com/test/write-xpath-table.html");
	   List list=driver.findElements(By.xpath("//html//body//center//table//tbody/tr"));
		int count=list.size();
		
		System.out.println(list.size());
		
		for(int i=0;i<count;i++) {
			String svalue=list.get(i).toString();
		}
			return count;
	}
}