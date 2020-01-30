package SeleniumGrid.CrossBrowserTesting;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGridTest {
	 String nodeURL;
	    WebDriver driver;
	    	DesiredCapabilities cap;
	    @Parameters({"Port"})
	    @BeforeMethod()
	    public void setUp(String Port) throws MalformedURLException {
	    	System.out.println("selenium grid tests");
	    		
	    	 if(Port.equals("5555")) {
	    			System.out.println("5555");
	    				cap=DesiredCapabilities.chrome();
	    				cap.setBrowserName("chrome");
	    				cap.setVersion("79");
	    				cap.setPlatform(Platform.WINDOWS);
	    				
	    					nodeURL="http://192.168.99.1:5555/wd/hub";
	    		}
	    	 else if(Port.equals("5556")){
	    			System.out.println("5556");
	    				cap = DesiredCapabilities.firefox();
	    				cap.setBrowserName("firefox");
	    				cap.setPlatform(Platform.WINDOWS);
	    					nodeURL="http://192.168.99.1:5556/wd/hub";
	    			}
	    		else if(Port.equals("5557")) {
	    			System.out.println("5557");
	    				cap=DesiredCapabilities.internetExplorer();
	    				cap.setBrowserName("internet explorer");
	    				cap.setVersion("10");
	    				cap.setPlatform(Platform.WINDOWS);
	    					nodeURL="http://192.168.99.1:5557/wd/hub";
	    		}
	    	 driver=new RemoteWebDriver(new URL(nodeURL),cap);
				System.out.println("Remote driver setup done");
	    }
	   
	    @Test
	  		public void testApp1() 
	  	    {
	  	    	System.out.println("test created");
	  	    	try {
	  	    	driver.get("https://www.techbeamers.com/");
	  	  	
	  			 List<WebElement> PythonElements=driver.findElements(By.xpath("//div[@class='main-container']//div[3]//div[1]//div[2]//div[1]//ul[1]/li")); 
	  			   
	  			 for(WebElement eachElement:PythonElements)
	  			    {
	  				   System.out.println(eachElement.getText());
	  			    }	
	  	  	}
	  	  	catch(Exception e) {e.printStackTrace();}
	  			 driver.close();
	  	        driver.quit();
	  	    }
}
