package ResendHumanMessagesGateway.ResendingHumanMessages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	 WebDriver driver=null;
	
	   String IDdropdown="selectActionId";
	   String idSelectedbutton="task.selected";
   
	
	public void Login() {
		 String loginUserId="loginUserId", username="kannanu";
		   String loginPassword="loginPassword", password="kannan";
		   String LoginButtonID="N10074";
		   String URL="http://dgateway.emea.eu.int:6080/ui";
		   String xpathSearchPageLast24hrsID="//table[1]/tbody[1]/tr[4]/td[1]/span[1]/a[1][text()='All messages-last 24 hours']";
		 //Login
		    driver.get(URL);
		    driver.findElement(By.id(loginUserId)).sendKeys(username);
		    driver.findElement(By.id(loginPassword)).sendKeys(password);
		    driver.findElement(By.id(LoginButtonID)).click();
		    
		    //Navigate to Search page
		    WebDriverWait wait=new WebDriverWait(driver, 20);
		    WebElement ele=driver.findElement(By.xpath(xpathSearchPageLast24hrsID));
		    wait.until(ExpectedConditions.visibilityOf(ele)); //clicking 24 hrs ////*[@id="N10502"]
		    ele.click();
	 }
	
	public void  SearchCoreID(String InputCoreid){
		 String xpathCoreID="//*[@id=\"field\"]/tbody/tr[19]/td[2]/input";
		 String xpathfindButton="//form[1]/div[2]/span[1]/a[text()='Find']";//"//*[@id=\"N10386\"]";
		 String nameCoreIDResult="selectedId";
		 String ActualCoreid=null;
		 
		 System.out.println("CoreID searching is in Progress");
		 	driver.findElement(By.xpath(xpathCoreID)).clear();
		    driver.findElement(By.xpath(xpathCoreID)).sendKeys(InputCoreid);
		    driver.findElement(By.xpath(xpathfindButton)).click();
		    System.out.println("CoreID searching is completed.  Please verify the Coreid Search Results");
	   }

	public void ResendCoreID(String ActualCoreid) {
		
		 String nameCoreIDResult="selectedId";
		 try {
		 WebElement SearchResultWebElement=driver.findElement(By.name(nameCoreIDResult));
		//Resending the search result coreid
 			  SearchResultWebElement.click();
 			    Select SelWebElement=new Select(driver.findElement(By.id(IDdropdown)));
 			        SelWebElement.selectByValue("resend");
 			    		driver.findElement(By.id(idSelectedbutton)).click();
 			    		System.out.println("Coreid is selected");
 			    			Alert alert=driver.switchTo().alert();
 			    			alert.accept();
 			    			System.out.println("Alert box is accepted for Resend");
 			    					try {
										Thread.sleep(5000);
									} catch (InterruptedException e) {
										// TODO Auto-generated catch block
										System.out.println("Resend Coreid is having exception");
										e.printStackTrace();
									}
		 }catch(Exception e) {System.out.println("Coreid is not shown in results page :"+ActualCoreid);}
	 	}
	 
	private int ValidateCoreIDSearchResults(String inputCoreid) {
		int Resultscount=0;String CoreidValue=null;
		String tableSearchResults="//table[@id='queryResults']/tbody/tr";
		List  rows = driver.findElements(By.xpath(tableSearchResults));  
		System.out.println("Validation of Coreid: Verifying whether coreid is showing up in Results Page.");
			System.out.println(rows.size());
			for(int i=2;i<=rows.size();i++) {
				try {
					CoreidValue=driver.findElement(By.xpath("//table[@id='queryResults']/tbody/tr["+i+"]/td[1]/span/input")).getAttribute("value");
				}catch(Exception e) {
					System.out.println("Coreid is not shown in the search Results page");
					return 0;
				}
					if(inputCoreid.equalsIgnoreCase(CoreidValue)) {
						System.out.println("Coreid is shown up in the Search Results Page");
						Resultscount++;
					}
			}
				
			return Resultscount;
		}
	
	
	
	
	
	 public void testApp()
	    {
	    	System.setProperty("webdriver.chrome.driver","drivers/chromedriver79.exe");
			   driver=new ChromeDriver();
			   
			   Login();
			   String InputCoreid=null;
			   
			   //Open Text file
			   BufferedReader br = null;
			   try {

		            br = new BufferedReader(new FileReader("C:\\Data\\coreid.txt"));

		            while ((InputCoreid = br.readLine()) != null) {
		            	System.out.println("*************************************************");
		            	System.out.println("*************************************************");
		            		System.out.println("InputCoreid="+InputCoreid);
		            		if(InputCoreid!=null) {
		    		    							SearchCoreID(InputCoreid);
		    		    			int Resultscount=ValidateCoreIDSearchResults(InputCoreid);				
		    		    			if(Resultscount==1) {
		    		    				System.out.println("Coreid Resend is in Progress");
		    		    					ResendCoreID(InputCoreid);
		    		    					SearchCoreID(InputCoreid);
		    		    					Resultscount=ValidateCoreIDSearchResults(InputCoreid);
		    		    						if(Resultscount==2) {
		    		    							System.out.println("Resend successfull");
		    		    						}
		    		    						else
		    		    							System.out.println("Either Coreid is not shown results or Resend is unsuccessfull");
		    		    			}
		            		}
		            } } catch (IOException e) {} finally {try {if (br != null)br.close();} catch (IOException ex) {}
		            }
			   
			
			    	
	    	assertTrue( true );
			    
	    }
}