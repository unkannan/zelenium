package RegressionTestPackage.RegComponent1;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class RegressionTCs 
{
	WebDriver driver=null;
//@BeforeSuite
public void fun_BeforeSuite() {
	System.out.println("Before Suite");
}
	
//@BeforeClass
public void fun_Beforeclass() {
	System.out.println("before class");
}
//@BeforeMethod
public void Fun_MethodBefore(ITestResult result) {
	System.out.println("BeforeMethod1");
//	System.out.println(result.getMethod().getMethodName());
}

@Test(priority=2)
public void CreateCustomer() throws InterruptedException {
	 System.out.println("CreateCustomer");
	  
	 String ExpectesStr="kannan";
	 String ActualStr="annan";
	//assertEquals(ExpectesStr, ActualStr);//
	 
	 SoftAssert softAssert = new SoftAssert();
	 softAssert.assertEquals(ExpectesStr, ActualStr);
	
	 System.out.println("proceed further");
	 assertEquals(10, 10);
	 
	 softAssert.assertAll();
}

//@Test(priority=3,dataProvider="salary")
public void AddDetaisofExistingCustomer(int sal) throws InterruptedException {
	System.out.println("AddDetaisofExistingCustomer and his slary="+sal);
	 
} 
//@Test(priority=4)
public void CustomerSearch() throws InterruptedException {
	System.out.println("CustomerSearch");
	 
}

//@Test(priority=1,dataProvider = "Login")
public void LoginFunctionality(String username,String Password) throws InterruptedException {
	System.out.println(username +" "+ Password);
}

@DataProvider(name = "Login")
public Object[][] LoginUserDetails() {
	return new Object[][] {
		// @formatter:off
		{ "kannan", "rajesh"}
		// @formatter:on
	};
}
	@DataProvider(name = "salary")
	public Object[][] SalaryDetails() {
		return new Object[][] {
			// @formatter:off
			{10000},
			{20000},
			{30000}
			// @formatter:on
		};
	}
 

//@AfterMethod
public void Fun_MethodAfter(ITestResult result) {
	System.out.println("After Method1");
	//System.out.println(result.getMethod().getMethodName());
}
//@AfterClass
public void fun_Afterclass() {
	System.out.println("After class");
	System.out.println();
	System.out.println();
}
//@AfterSuite
public void fun_AfterSuite() {
	System.out.println("After Suite");
}


}

