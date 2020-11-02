/**
 *
 */
package com.gurukula.utility;

import com.gurukula.common.Constants;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * @author UnniKannan
 */

public class Init {

    static Logger logger = Logger.getLogger(Init.class.getName());

    public WebDriver driver;
    private static Properties prop = ReadPropertiesFile.getProperties();
    public final static String URL = prop.getProperty("url");
    public final static String USERNAME = prop.getProperty("username");
    public final static String PASSWORD = prop.getProperty("password");

    /**
     * This function is to perform pre setup for every test case, like initializing the WebDriver,
     * launching the browser, etc.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
        driver.get(URL);

    }

    /**
     * This function is to quit the driver instance. And to take screenshots on failure.
     */
    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {
        if (driver != null) {
            if (ITestResult.FAILURE == result.getStatus()) {
                ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
            }
            driver.quit();
        }
    }

    private WebDriver getDriver() {
        String browser = System.getProperty("browser");
        if (null == browser) {
            browser = "firefox";
        }
        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        }
        return new ChromeDriver();
    }

}
