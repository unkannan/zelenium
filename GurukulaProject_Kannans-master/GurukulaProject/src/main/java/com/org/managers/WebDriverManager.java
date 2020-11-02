package com.org.managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.org.util.ConfigFileReader;

import cucumber.api.java.After;

import com.org.enums.DriverType;
import com.org.enums.EnvironmentType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	ConfigFileReader configfileReader;
	public WebDriverManager() {
	 
		 configfileReader=new ConfigFileReader();
		driverType =configfileReader.getBrowser();
		environmentType = configfileReader.getEnvironment();
			 
	}
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		 urlNavigate();
		return driver;
	}
	
	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}
	private WebDriver createRemoteDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	private WebDriver createLocalDriver() {
		switch (driverType) {	    
        case FIREFOX : driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	//System.out.println("configreaderdriver   >"+configfileReader.getDriverPath());
        	//System.setProperty(CHROME_DRIVER_PROPERTY,configfileReader.getDriverPath());// FileReaderManager.getInstance().getConfigReader().getDriverPath());
        	System.setProperty(CHROME_DRIVER_PROPERTY,configfileReader.getDriverPath()+"chromedriver.exe");
        	driver = new ChromeDriver();
    		break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
    		break;
        }

        if(configfileReader.getBrowserWindowSize())
        	driver.manage().window().maximize();
             driver.manage().timeouts().implicitlyWait(configfileReader.getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}
	
	private void urlNavigate() {
		String url=configfileReader.getURL();
		driver.get(url);
	}
	
	//@After
	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
