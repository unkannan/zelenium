 
package com.org.util;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.org.util.ConfigFileReader;
import com.org.util.ScreenshotUtil;
import com.org.enums.AppValidationConstantMessages;

 public class StartApplication {

    static Logger logger = Logger.getLogger(StartApplication.class.getName());

    public WebDriver driver;
    private static Properties prop = ConfigFileReader.ReadProperties();
    public final static String URL = prop.getProperty("url");
    public final static String BROWSER = prop.getProperty("browser");

	 
    @Parameters({ "browserName" })
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        logger.info("# WebDriver Setup : Success");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(AppValidationConstantMessages.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.get(URL);
        logger.info("# Navigated to the URL successfully");
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        if (driver != null) {
          //  if (ITestResult.FAILURE == result.getStatus()) {
                ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
           // }
           driver.quit();
        }
    }
 

    private WebDriver getDriver() {
      //  String browser;
        if (BROWSER.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
        	logger.info("# firefox driver is initiated");
        	  return new FirefoxDriver();
        }
        if (BROWSER.equalsIgnoreCase("chrome")) {
        	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        	logger.info("# chrome driver is initiated");
            return new ChromeDriver();
        }
        if (BROWSER.equalsIgnoreCase("iexplorer")) {
        	System.setProperty("webdriver.ie.driver","drivers/IEDriverServer.exe");
        	logger.info("# IE driver is initiated");
            return new InternetExplorerDriver();
        }
        return  null;
    }

}
