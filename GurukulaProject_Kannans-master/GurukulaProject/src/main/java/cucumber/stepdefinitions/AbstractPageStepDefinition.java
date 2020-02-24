package cucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.org.managers.WebDriverManager;

public class AbstractPageStepDefinition {
	
	protected static WebDriver driver;
	
	public static WebDriverManager webdrivermanager;
	
	protected static WebDriver getDriver() {
		if(driver==null) {
			 webdrivermanager=new WebDriverManager();
		 	driver=webdrivermanager.getDriver();
		}
		return driver;
	}
	

}
