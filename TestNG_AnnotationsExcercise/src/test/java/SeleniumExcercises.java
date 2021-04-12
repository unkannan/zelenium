import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumExcercises {
	//Toolsqa.com 
	
	
//	- Open browser  WebDriver driver=new WebDriver();
	//- Enter url    driver.get("http://Toolsqa.com");
	
	
	@Test
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\unkan\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
	}
	     
	//- Page loaded - verification

	

}
