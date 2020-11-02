@SmokeTestFunSmokeTest
Feature: Login Functionality Check 
   
 
   Scenario: Invalid User Credentials - Login Functionailty Check - User should not ble able login with invalid credentials
    Given A user launch the Gurukul application
    And User logs in by clicking Login button
    Then User should not be able to login with invalid credentials <username> and <password>
    |username	|password	|
    |admin		|admin1		|
    |admin1		|admin		|	
    |			|admin		|
    |admin		|			|
    | 			| 			|   
   
    
    Scenario: Vaild user Credentials - Login with Valid user credentials
    Given A user launch the Gurukul application
     And User logs in by clicking Login button
    Then User should be able to login successfully with valid credentials <username> and <password>
    |admin		|admin		|
   
   Scenario:  ForgotPassword link click navigation check  
    Given A user launch the Gurukul application
     And User logs in by clicking Login button
    Then User should be able to navigate to Reset Password page by clicking Forgot Password link
    
 
    Scenario: Registration link click navigation check
    Given A user launch the Gurukul application
     And User logs in by clicking Login button
    Then User clicking on Register new account link should navigate to register new user page
 
    
    Scenario: Logout Functionality check
    Given A user launch the Gurukul application 
     And User logs in by clicking Login button
	   Then User should be able to login successfully with valid credentials <username> and <password>
    |admin		|admin		|
  	Then user logout button should successfully logout from the application 
  	 
  	
		 Scenario:  Gurukula logo link functional check of navigating to Home page 
     Given A user launch the Gurukul application 
     And User logs in by clicking Login button
     Then clicking Gurukula logo link navigates to Home page 
    
     
      Scenario:  User should not remain logged in if remember me checkbox is unchecked
     Given A user launch the Gurukul application 
     And User logs in by clicking Login button
     Then uncheck the remember me checkbox in login page
     Then User should be able to login successfully with valid credentials <username> and <password>
  	 	|admin		|admin		|
  	  
  	 
  
  	Scenario:  Home link functional check where clicking it should navigate to Home page
     Given A user launch the Gurukul application 
     And User logs in by clicking Login button
     Then clicking Home link navigates to Home page 
     
   