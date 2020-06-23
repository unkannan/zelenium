
package GurukulaProject.GurukulaProject;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.org.pages.LoginPage;
import com.org.pages.WelcomePage;


//@Test(groups = "login")
public class LoginTest {

	public static Logger logger = Logger.getLogger(LoginTest.class.getName());

	WelcomePage welcomePage;
	LoginPage loginPage;

	@Test
	public void tc_01_testLoginWithValidCredentials() {
		System.out.println("this is loging page test  1  ");
	
	}

	@Test
	public void tc_02_testLoginWithInValidCredentials() {
	
		System.out.println("this is loging page test  2");
	}

	
	}

