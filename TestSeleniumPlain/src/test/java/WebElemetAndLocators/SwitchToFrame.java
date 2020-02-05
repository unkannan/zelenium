package WebElemetAndLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchToFrame {
	
	//@Test //Switching to a frame + reading the elements
    public void SwitchToOneFrame() {
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/guru99home/"); //Navigate to WebPage
			driver.switchTo().frame("a077aa5e");
			 System.out.println(driver.findElement(By.xpath("//html//body//a")).getAttribute("href"));
			   driver.findElement(By.xpath("//html//body//a//img")).click();
			driver.quit();
	}
	
	//@Test
	public void SwitchBackToMainFrame() {
    System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
		
    WebDriver driver=new ChromeDriver();
			driver.get("http://demo.guru99.com/test/guru99home/");
			driver.switchTo().frame("a077aa5e");
			driver.findElement(By.xpath("//html//body//a//img")).click();
			//driver.switchTo().defaultContent();

			driver.switchTo().parentFrame();
			System.out.println(driver.getTitle());
			
			driver.findElement(By.xpath("//input[@id='philadelphia-field-email']")).sendKeys("kannan");
			
			String textName=driver.findElement(By.xpath("//label[@class='previewLabel']")).getText();
				System.out.println(textName);
	}
	
		//@Test
		public void FindingTotalFramesInWebPage() {
				
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
			
		    WebDriver driver=new ChromeDriver();
		    
					driver.get("http://demo.guru99.com/test/guru99home/");
					
					int size = driver.findElements(By.tagName("iframe")).size();
					 System.out.println(size);
			}
		
		@Test// NOT WORKING
		public void FindingTotalFramesInWebPage1() {
				
System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
WebDriver driver=new ChromeDriver();
					driver.get("http://demo.guru99.com/test/guru99home/");
					
					int size = driver.findElements(By.tagName("iframe")).size();
					 System.out.println(size);
					
					 
					  for(int i=0; i<=size; i++){
						  try {
							driver.switchTo().frame(i);
							int total=driver.findElements(By.xpath("html/body/a/img")).size();
							System.out.println(total);
						  }
						  catch(Exception e) {}
							int total=driver.findElements(By.xpath("html/body/a/img")).size();
							System.out.println(total);
						    //driver.switchTo().defaultContent();
							}
			}

}
