package TestNG_AnnotationsExcercise.TestNG_AnnotationsExcercise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
	
	@BeforeClass
	public void RunBeforeClass(){
		System.out.println("This would run before all tcs");
	}
	
	@BeforeMethod
	public void open_Browser(){
		System.out.println("Open Browser");
	}
	
	
	@Test
	public void TC1() {
		System.out.println("This is a first testcase");
	}
	

	@Test
	public void TC2() {
		System.out.println("This is a 2 testcase");
	}

	@Test
	public void TC3() {
		System.out.println("This is a 3 testcase");
	}

	@Test
	public void TC4() {
		System.out.println("This is a 4 testcase");
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
		System.out.println("This would run before all tcs");
		System.out.println("My component level of test cases execution completed- currency converted execution completed");
	}
}
