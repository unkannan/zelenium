package TestSeleniumPlain.TestSeleniumPlain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import AdvanceSelenium.UIOperation;


public class EVWeb {
	
	WebDriver driver;
	
	 public void  Click(WebDriver driver,String xpath) {
		 new WebDriverWait(driver, 100)
         .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	        driver.findElement(By.xpath(xpath)).click();
	    }
	 @Test
		public void WebTableExcercise1() throws InterruptedException, IllegalStateException, InvalidFormatException, IOException {
		
		 System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
		 WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(300,TimeUnit.SECONDS) ;
			driver.get("https://eudravigilance-human-perf-test.ema.europa.eu");
			driver.manage().window().maximize() ;
			driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a")).click();
			driver.findElement(By.id("username")).sendKeys("MAHTEST01GWU01");
			Thread.sleep(3000);
			driver.findElement(By.id("password")).sendKeys("admin12345_");	
			driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
			Click(driver,"//button[@class='btn btn-primary btn-block']");
			//driver.findElement(By.xpath("//a[contains(text(),'ICSR Download')]")).click();
			Click(driver,"//a[contains(text(),'ICSR Download')]");
			driver.findElement(By.xpath("//button[contains(text(),'PV obligations reports (L2A)')]")).click();
			//Click(driver,"//button[contains(text(),'PV obligations reports (L2A)')]");
			//driver.findElement(By.xpath("//div[@class='btn-group ng-scope dropdown open']//li[3]")).click();
			Click(driver,"//div[@class='btn-group ng-scope dropdown open']//li[3]");
			
			for(int i=1;i<5;i++) {
						WebElement e=SelectStartDate(i);
						e.click();
						Thread.sleep(10000);
						driver.findElement(By.xpath("//ul[@class='dropdown-menu ng-scope input-container']//button[@class='btn btn-sm btn-primary'][contains(text(),'Update')]")).click();
						//Click(driver,"//ul[@class='dropdown-menu ng-scope input-container']//button[@class='btn btn-sm btn-primary'][contains(text(),'Update')]");
						//Thread.sleep(10000);
						//driver.findElement(By.xpath("//button[contains(text(),'Count')]")).click();
						Click(driver,"//button[contains(text(),'Count')]");
						System.out.println(driver.findElement(By.xpath("//b[@class='ng-binding']")).getText());
						Thread.sleep(10000);
						driver.findElement(By.xpath("//input[@placeholder='Request name...']")).sendKeys(driver.findElement(By.xpath("//b[@class='ng-binding']")).getText());
						//driver.findElement(By.xpath("//button[contains(text(),'Request')]")).click();
						Click(driver,"//button[contains(text(),'Request')]");
						
				}
			}
	 
	 
	 public WebElement SelectStartDate(int i) throws InterruptedException{
		 Thread.sleep(10000);
		 Click(driver,"//span[contains(text(),'Start Date:')]");
		 //driver.findElement(By.xpath("//span[contains(text(),'Start Date:')]")).click();
         driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[1]/div[1]/ev-search-criteria[1]/div[1]/div[1]/search-criterion[2]/div[1]/ul[1]/li[1]/div[1]/table[1]/thead[1]/tr[1]/th[1]/button[1]")).click();
         List <WebElement> eles=driver.findElements(By.xpath("//td[contains(@id,'datepicker')]/button/span"));
         for(WebElement e: eles) {
				System.out.println(e.getText());
					if(Integer.parseInt(e.getText())==i || e.getText().equals("0"+i )) 
						return e;
         }
		return null;
	 }
	 
	  
	 
	     public void ReadExcel() throws IOException, IllegalStateException, InvalidFormatException {
			//ExcelReadin
			InputStream inp = new FileInputStream("C:\\Data\\data.xlsx"); 
		    	Workbook wb = WorkbookFactory.create(inp);
		    
		    //Navigating to mainsheet
		    Sheet sheet = wb.getSheet("BizRuleSheet");
		    
					  String CreateFileFlag=sheet.getRow(0).getCell(0).toString();
					  String CreateFileFlag1=sheet.getRow(1).getCell(0).toString();
					  System.out.println(CreateFileFlag);
					  System.out.println(CreateFileFlag1);
				}
}
