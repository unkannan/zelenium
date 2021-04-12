package LearnsQA;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumExcercises {
	//Toolsqa.com 
	
	
//	- Open browser  WebDriver driver=new WebDriver();
	//- Enter url    driver.get("http://Toolsqa.com");
	
	
	//@Test
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guru99.com/");
		String title=driver.getTitle();
		System.out.println(title);
	
		Assert.assertEquals(title, "Meet Guru99 - Free Training Tutorials & Video for IT Courses");
		driver.quit();
	}
	     
	//@Test
	public void Validate_LibTutorialsText() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guru99.com/");
		
		String text=driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]")).getText();
		System.out.println(text);
//		Assert.assertEquals(title, "Meet Guru99 - Free Training Tutorials & Video for IT Courses");
		driver.quit();
	}

	//@Test
	public void Validate_clickSoftwareTestingLink() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.guru99.com/");
		driver.findElement(By.linkText("Software Testing")).click();
	}
	
	//@Test
	public void Validate_ID_locator_ClickButton() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.testandquiz.com/selenium/testing.html");
		driver.findElement(By.id("idOfButton")).click();
		driver.findElement(By.name("firstName")).sendKeys("Leargning QA");
		//driver.findElement(By.linkText("Software Testing")).click();
	}

	//@Test
	public void clickButton() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.navigate().to("https://demoqa.com/browser-windows");
		Thread.sleep(1000);
		//driver.findElement(By.id("tabButton")).click();
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
		//driver.quit();
	}
	
	 
	
	//@Test
	public void ClearingTextBox() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://demoqa.com/browser-windows");
		Thread.sleep(1000);
				driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/span[1]/div[1]")).click();
		Thread.sleep(10000);
		
			String textBoxLink="/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/span[1]";
				driver.findElement(By.xpath(textBoxLink)).click();

				Thread.sleep(10000);
			
				String textBoxUserName="userName";
				boolean checkDisplayed=driver.findElement(By.id(textBoxUserName)).isDisplayed();
				System.out.println(checkDisplayed);
				boolean CheckEnabled=driver.findElement(By.id(textBoxUserName)).isEnabled();
				System.out.println(CheckEnabled);
				
				driver.findElement(By.id(textBoxUserName)).sendKeys("This is the first text");
		Thread.sleep(1000);
		driver.findElement(By.id(textBoxUserName)).clear();
		Thread.sleep(1000);
		driver.findElement(By.id(textBoxUserName)).sendKeys("This is the second text");
	}
	
	//@Test
	public void ExcerciseFindELements() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.guru99.com/");
		
		String SAPParentHeader="/html[1]/body[1]/div[2]/section[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li";
		int TotalLinks=driver.findElements(By.xpath(SAPParentHeader)).size();
		System.out.println(TotalLinks);
		
		List<WebElement> ListItems = driver.findElements(By.xpath(SAPParentHeader));
		    for ( WebElement we: ListItems) { 
		        System.out.println(we.getText());
		    }
	}
		  //  @Test
		    public void DropDownExcercise() throws InterruptedException {
		    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.testandquiz.com/selenium/testing.html");
				
				WebElement ele=driver.findElement(By.id("testingDropdown"));
		    		  Select obj=new Select(ele);
		    		  Thread.sleep(10000);
		    		   obj.selectByValue("Performance");
		    		   Thread.sleep(10000);
		    		   obj.selectByVisibleText("Manual Testing");
		    		   Thread.sleep(10000);
		    		   obj.selectByIndex(3);
		    		   Thread.sleep(10000);
		    		   
		    		 
		    		   obj.selectByValue("Performance");
		    		   Thread.sleep(10000);
		    }
		 //  @Test
		    public void AnotherMethodOfSelectingElement() throws InterruptedException {
		    	System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
				WebDriver driver = new ChromeDriver();
				driver.get("https://www.testandquiz.com/selenium/testing.html");
				
		    List<WebElement> ListItems = driver.findElements(By.xpath("//select[@id='testingDropdown']/option"));
		    for ( WebElement we: ListItems) { 
		        System.out.println(we.getText());
		        if(we.getText().equalsIgnoreCase("Database Testing"))
		        	we.click();
		    }
			WebElement ele=driver.findElement(By.id("testingDropdown"));
			Select obj=new Select(ele);
		    List<WebElement> dropdownList=obj.getOptions();
		    for(int i=0;i< dropdownList.size();i++){
		    	System.out.println(dropdownList.get(i).getText());
		    }
		    }
		    
		  // @Test
		    public void AnotherMethodOfSelectingElement_withFirefox() throws InterruptedException {
				System.setProperty("webdriver.gecko.driver","drivers/geckodriver.exe");
				WebDriver driver = new FirefoxDriver();
				
			driver.get("https://www.testandquiz.com/selenium/testing.html");
		    List<WebElement> ListItems = driver.findElements(By.xpath("//select[@id='testingDropdown']/option"));
		    for ( WebElement we: ListItems) { 
		        System.out.println(we.getText());
		        if(we.getText().equalsIgnoreCase("Database Testing"))
		        	we.click();
		    }
			WebElement ele=driver.findElement(By.id("testingDropdown"));
			Select obj=new Select(ele);
		    List<WebElement> dropdownList=obj.getOptions();
		    for(int i=0;i< dropdownList.size();i++){
		    	System.out.println(dropdownList.get(i).getText());
		    }
		    }
		    
		  //  @Test
		    public void ActionsExcercise() throws InterruptedException {
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();

				// Open webpage
				 driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
				  
				 // Add 5 seconds wait
				 Thread.sleep(5000);
				  
				 // Create object of actions class
				 Actions act=new Actions(driver);
				  
				 // find element which we need to drag
				 WebElement drag=driver.findElement(By.xpath(".//*[@id='draggable']"));
				  
				 // find element which we need to drop
				 WebElement drop=driver.findElement(By.xpath(".//*[@id='droppable']"));
				  
				 // this will drag element to destination
				 act.dragAndDrop(drag, drop).build().perform();
		    }
		    
		    
		 // @Test
			public void RightClick() throws InterruptedException {
			  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				 driver.get("https://demoqa.com/buttons");
				 Actions act=new Actions(driver);
				 act.contextClick(driver.findElement(By.id("rightClickBtn"))).build().perform();;
				
				}
		  
			//@Test
		  public void tooltip() throws InterruptedException {
			  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				 driver.get("https://demoqa.com/tool-tips");
				 Thread.sleep(1000);
				
				 WebElement elehavingTooltip= driver.findElement(By.xpath("//button[@id='toolTipButton']"));
				 Actions act=new Actions(driver);
				 act.moveToElement(elehavingTooltip).perform();
				 Thread.sleep(1000);
				 WebElement cssSelectorToolTipEle=driver.findElement(By.cssSelector("#toolTipButton"));
				System.out.println(cssSelectorToolTipEle.getText());
				elehavingTooltip.sendKeys(Keys.CONTROL);
				elehavingTooltip.sendKeys("A");
		  }
			
			//@Test
			  public void GettingAttributes() throws InterruptedException {
				  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					 driver.get("https://www.flipkart.com/");
					 Thread.sleep(1000);
			  }
			 // @Test
			  public void Alerts() throws InterruptedException {
				  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					 driver.get("https://demoqa.com/alerts");
					 Thread.sleep(1000);
					
					 driver.findElement(By.id("alertButton")).click();
					 Alert popup=driver.switchTo().alert();
					 Thread.sleep(1000);
					  popup.accept();
					  
					  driver.findElement(By.id("confirmButton")).click();
					  Alert confirmPopup=driver.switchTo().alert();
						 Thread.sleep(1000);
						 confirmPopup.dismiss();
						 
						 //do excercise for send keys in the popup and also reading text
			  }
			  
			  //@Test
			  public void SwitchFrames() throws InterruptedException {
				  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					 driver.get("https://demoqa.com/frames");
					 Thread.sleep(1000);
					 
					 //switching to the frame
					 WebElement frameElement=driver.findElement(By.id("frame1"));
					 driver.switchTo().frame(frameElement);
					  System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
					  driver.switchTo().defaultContent();
					  Thread.sleep(10000);
					  
					  
					 Thread.sleep(10000);
					 driver.switchTo().frame(1); //switching to 2nd frame -  you can use index or id of the frame
					 System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
					 driver.switchTo().defaultContent();//switching back to main web page
					 Thread.sleep(10000);
					 driver.findElement(By.xpath("//span[contains(text(),'Alerts')]")).click();
			  }
			  
			//  @Test
			  public void SwitchWindows() throws InterruptedException {
				  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					 driver.get("https://demoqa.com/browser-windows");
					 Thread.sleep(1000);
					 
					 driver.findElement(By.id("tabButton")).click();
					 String MainWindowHandle=driver.getWindowHandle(); //main door
					 System.out.println(MainWindowHandle);
					 Set<String> winHandles = driver.getWindowHandles(); // all doors (Bedrrom door, kitchen door)
						//Iterator<String> i1 = s1.iterator();

						for (String handle : winHandles) {
							//String ChildWindow = i1.next();

							if (!MainWindowHandle.equalsIgnoreCase(handle)) {//every door id comparing with my main door

								// Switching to Child window
								
								driver.switchTo().window(handle);
								System.out.println(driver.getWindowHandle());
								System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
								// Closing the Child Window.
								driver.close();
							}
						}
						System.out.println(driver.getTitle());
			  }
			  
			 //@Test
			  public void SwitchWindows_newwindow() throws InterruptedException {
				  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); //
					WebDriver driver = new ChromeDriver();
					driver.manage().window().maximize();
					 driver.get("https://demoqa.com/browser-windows");
					 Thread.sleep(1000);
					 
					 driver.findElement(By.id("messageWindowButton")).click();
					 String MainWindowHandle=driver.getWindowHandle(); //main door
					 System.out.println(MainWindowHandle);
					 Set<String> winHandles = driver.getWindowHandles(); // all doors (Bedrrom door, kitchen door)

						for (String handle : winHandles) {
							if (!MainWindowHandle.equalsIgnoreCase(handle)) {//every door id comparing with my main door
								// Switching to Child window
								driver.switchTo().window(handle);
								System.out.println(driver.getWindowHandle());
								//System.out.println(driver.getCurrentUrl());
								System.out.println(driver.findElement(By.xpath("/html/body")).getText());
								//System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
								// Closing the Child Window.
							}
						}
						System.out.println(driver.getTitle());
			  }
			  
			//@Test
				public void waitCommandImplicit() {
					System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
					WebDriver driver = new ChromeDriver();
					driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
					//driver.get("https://www.guru99.com/");
					//driver.findElement(By.linkText("Software Testing")).click();
					driver.get("https://timesofindia.indiatimes.com/");
					driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[10]/div[1]/div[14]/div[2]/div[2]/ul[1]/li[5]/span[1]")).click();
				}
			
			//@Test
			public void waitCommandImplictExample() {
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
				WebDriver driver = new ChromeDriver();
				 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				//driver.get("https://www.guru99.com/");
				//driver.findElement(By.linkText("Software Testing")).click();
				driver.get("https://timesofindia.indiatimes.com/");
				driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[10]/div[1]/div[14]/div[2]/div[2]/ul[1]/li[5]/span[1]")).click();
			}
			//@Test
			public void WebDriverwaitCommandExample() {
				System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); 
				WebDriver driver = new ChromeDriver();
				// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//driver.get("https://www.guru99.com/");
				//driver.findElement(By.linkText("Software Testing")).click();
				driver.get("https://timesofindia.indiatimes.com/");
				driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[10]/div[1]/div[14]/div[2]/div[2]/ul[1]/li[5]/span[1]")).click();
				
				WebDriverWait wait = new WebDriverWait(driver, 10);
				WebElement element=  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Malayalam TV')]")));
				element.click();
				
				//driver.findElement(By.xpath("//a[contains(text(),'Malayalam TV')]")).click();
			}
			//@Test		
			public void fluent_Wait() {
				System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
				driver.get("http://demo.guru99.com/test/guru99home/" );
				//Maximizes the browser window
				driver.manage().window().maximize() ;
				

				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)							
						.withTimeout(Duration.ofSeconds(20)) 			
						.pollingEvery(Duration.ofSeconds(1)) 			
						.ignoring(NoSuchElementException.class);
				
				WebElement clickseleniumlink = wait.until(new Function<WebDriver, WebElement>(){
				
					public WebElement apply(WebDriver driver ) {
							System.out.println("check");
								return driver.findElement(By.xpath("/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"));
						}
					
				});
				clickseleniumlink.click();
				driver.close() ;
				}
			
			@Test		
		    public void Login() 					
		    {		
				System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
				WebDriver driver=new ChromeDriver();			

		        //Creating the JavascriptExecutor interface object by Type casting		
		        JavascriptExecutor js = (JavascriptExecutor) driver;		
		        		
		      //Launching the Site.		
		        driver.get("http://demo.guru99.com/V4/");			
		        		
		        WebElement button =driver.findElement(By.name("btnLogin"));			
		        		
		        //Login to Guru99 		
		        driver.findElement(By.name("uid")).sendKeys("mngr34926");					
		        driver.findElement(By.name("password")).sendKeys("amUpenu");					
		      
		        //Perform Click on LOGIN button using JavascriptExecutor		
		        js.executeScript("arguments[0].click();", button);
		                                
		        //To generate Alert window using JavascriptExecutor. Display the alert message 			
		        js.executeScript("alert('Welcome to Guru99');");   
		    }	
	}

