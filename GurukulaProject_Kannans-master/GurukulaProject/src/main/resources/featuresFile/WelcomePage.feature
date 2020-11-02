@FunctionalTesting
Feature: Validation of Welcome Page object Functionality
   
 Scenario: User can navigate to login page from Authenticate link under Account menu	
	Given The user launches the application  
	And in welcome screen user clicks on Authenticate link under Account menu 
	Then user should be able to navigate to login page
	
	Scenario: User can navigate to login page by clicking login link
	Given The user launches the application 
	And user clicks on login link in Welcome page 
	Then user should be able to navigate to login page
	
 Scenario: User can able to see the welcome page
    Given The user launches the application 
    Then Welcome page should be displayed successfully 
    
Scenario: User can navigate to Registration page by clicking Register a new Account link in welcome screen	
	Given The user launches the application  
	And in welcome screen user clicks on Register a new Account link
	Then user should be able to navigate to Registration page