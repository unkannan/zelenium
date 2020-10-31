package SeleniumSession1.SeleniumSession1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

	//@Test
	public void DragAndDrop() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();
		// driver.get("http://demo.guru99.com/test/drag_drop.html");

		/*
		 * //Element which needs to drag. WebElement
		 * From=driver.findElement(By.xpath("//*[@id='credit2']/a")); //Source Element
		 * 
		 * //Element on which need to drop. WebElement
		 * To=driver.findElement(By.xpath("//*[@id='bank']/li")); //Target Element
		 */

		driver.get("https://www.testandquiz.com/selenium/testing.html");
		// Using Action class for drag and drop.
		Actions action = new Actions(driver);

		// WebElement ele=driver.findElement(By.id("dblClkBtn"));
		// action.doubleClick(ele).build().perform();
		// driver.manage().window().maximize();
		WebElement sourceElement = driver.findElement(By.id("sourceImage"));
		WebElement TargetElement = driver.findElement(By.id("targetDiv"));
		action.dragAndDrop(sourceElement, TargetElement).build().perform();
		action.click().build().perform();

//Dragged and dropped.		

	}

	//@Test
	public void DragAndDrop1() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();
		
		 driver.get("http://demo.guru99.com/test/drag_drop.html");	
		 Thread.sleep(1000);
		 driver.switchTo().frame("flow_close_btn_iframe");
         driver.findElement(By.id("closeBtn")).click();
         driver.switchTo().defaultContent();

         
			//Element which needs to drag.    		
	        	WebElement From=driver.findElement(By.xpath("//*[@id='credit2']/a"));	
	         
	         //Element on which need to drop.		
	         WebElement To=driver.findElement(By.xpath("//*[@id='bank']/li"));					
	         		
	         //Using Action class for drag and drop.		
	         Actions act=new Actions(driver);					

		//Dragged and dropped.		
	         act.dragAndDrop(From, To).build().perform();	
	         act.click().build().perform();
	         	}		
	
	//@Test
		public void DragAndDrop2() throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			 driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");	

	         
				//Element which needs to drag.    		
		        	WebElement From=driver.findElement(By.xpath("//span[contains(text(),'Draggable 1')]"));	
		         
		         //Element on which need to drop.		
		         WebElement To=driver.findElement(By.xpath("//div[@id='mydropzone']"));					
		         		
		         //Using Action class for drag and drop.		
		         Actions act=new Actions(driver);					

			//Dragged and dropped.		
		         act.dragAndDrop(From, To).build().perform();	
		         Thread.sleep(1000);
		         act.moveToElement(To).build().perform();
		         act.click().build().perform();
		         
		         Thread.sleep(1000);
		         act.release().perform();
		       //  act.click().build().perform();
		         act.moveToElement(To, 40, 30);
		         
		         act.clickAndHold(From).build().perform();
		         act.moveToElement(To).build().perform();
		         
		         Thread.sleep(3000);
		         	}	
	
	//@Test
	public void DragAndDrop3() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open webpage
		 driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		  
		 // Add 5 seconds wait
		 Thread.sleep(5000);
		  
		 // Create object of actions class
		 Actions act=new Actions(driver);
		  
		 // find element which we need to drag
		 WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
		  
		 // find element which we need to drop
		 WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
		  
		 // this will drag element to destination
		 act.dragAndDrop(drag, drop).build().perform();
		}

	@Test
	public void DragAndDrop4() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open webpage
			driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
	 
		
			// Add 5 seconds wait
			Thread.sleep(5000);
	 
			// Create object of actions class
			Actions act=new Actions(driver);
	 
			// find element which we need to drag
			WebElement source=driver.findElement(By.className("dhx_tree-list__item dhx_tree-list-item"));
			
			WebElement destination=driver.findElement(By.className("dhx_widget dhx_list"));
			
			// it will click and hold the triller box and move to element will move cursor to history in another box and then release
			act.clickAndHold(source).pause(2000).moveToElement(destination).release().build().perform();
	 
		}
}
