package TestNG_AnnotationsExcercise.TestNG_AnnotationsExcercise;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import mainClass.DriverClass;

public class AppTest extends DriverClass{
	
	
	
	@Test(dataProvider="customerdetails",priority=2) 
	public void TC1(int customerid,String name,int rollno) {
		System.out.println("This is a first testcase");
		System.out.println(customerid);
		System.out.println(name);
		String actual="login failed....";
		assertEquals(actual, "login sucess");
	}
	

	@Test (dataProvider="customername",enabled = true)
	public void TC2(String name) {
		System.out.println("This is a 2 testcase");
		System.out.println(name);
		assertEquals("actual", "actual");
	}

	@Test (dependsOnMethods = {"TC1"},priority=1) 
	public void TC3() {
		System.out.println("This is a 3 testcase");
	}

	@Parameters({ "browser" })
	@Test 
	public void TC4(String browser) {
		System.out.println("This is a 4 testcase");
		System.out.println(browser);
	}
	@Test
	public void TC5() {
		System.out.println("This is a 5 testcase");
	}
    
	@AfterMethod
	public void Close_Browser(){
		System.out.println("Close Browser and post conditions");
	}
	
	@AfterClass
	public void RunAfterClass(){
		System.out.println("This would run after all tcs");
		System.out.println("My component level of test cases execution completed- currency converted execution completed");
	}
	@DataProvider(name = "customerdetails")
	public Object[][] customerID() {
		return new Object[][] {
			// @formatter:off
			{10000,"Raj",101},
			{20000,"Karan",102},
			{30000,"Mahesh",103}
			// @formatter:on
		};
	}
	@DataProvider(name = "customername")
	public Object[][] custname() {
		return new Object[][] {
			// @formatter:off
			{"A"},
			{"B"},
			{"C"}
			// @formatter:on
		};
	}
	
	
}
