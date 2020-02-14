 
package com.org.utility;

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

import com.org.enums.AppConstantMessages;

 public class StartApplication {

    static Logger logger = Logger.getLogger(StartApplication.class.getName());

    public WebDriver driver;
    private static Properties prop = ConfigFileReader.ReadProperties();
    public final static String URL = prop.getProperty("url");
    public final static String BROWSER = prop.getProperty("browser");

	 

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        System.out.println("Setup");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(AppConstantMessages.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        if (driver != null) {
            if (ITestResult.FAILURE == result.getStatus()) {
                ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
            }
          // driver.quit();
        }
    }
 

    private WebDriver getDriver() {
      //  String browser;
        if (BROWSER.equalsIgnoreCase("firefox")) {
        	System.setProperty("webdriver.gecko.driver","src/main/resources/drivers/geckodriver.exe");
        	  return new FirefoxDriver();
        }
        if (BROWSER.equalsIgnoreCase("chrome")) {
        	System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe"); 
            return new ChromeDriver();
        }
        if (BROWSER.equalsIgnoreCase("iexplorer")) {
        	System.setProperty("webdriver.ie.driver","src/main/resources/drivers/IEDriverServer.exe");
            return new InternetExplorerDriver();
        }
        return  null;
    }

}
