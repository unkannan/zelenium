package mainClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class DriverClass {
	@BeforeTest
	public void RunBeforeClass2(){
		System.out.println("This would run before all tcs");
	}
	
	
	@BeforeClass
	public void RunBeforeClass(){
		System.out.println("This would run before all tcs");
	}

	@BeforeMethod
	public void open_Browser(){
		System.out.println("Open Browser");
	}
	
}
