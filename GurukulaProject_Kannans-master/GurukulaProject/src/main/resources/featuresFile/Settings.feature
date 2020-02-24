@FunctionalTesting
Feature: Validation of Settings Page Functionality 
   
	 Scenario: Settings Page Navigation - User would be able to navigate to Settings page from Account menu > Settings   
    Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen
    Then User should be able to see the Settings page
      
	  
	  Scenario: Change Settings without changes  - User would be able to save the Settings details in Settings page 
    Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen 
    Then user without any changes should be able to change the Settings details by clicking Save button
	     
	   
	  Scenario: Change Settings changes - User would be able to change the Settings details in Settings page 
    Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen 
    Then user does the changes the settings and clicking save button should be able to change the settings 
	    
	 
  	  Scenario: First Name_Text field validation - mandatory checks,max chars in Settings details at Settings page 
    Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen 
     And mandatory field check for First Name field if text is not provided
     And Max chars can enter is fifty in the length for First Name field
     
     
	   Scenario: LastName_Text field validation - mandatory checks,max chars in Settings details at Settings page 
   Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen 
     And mandatory field check for Last Name field if text is not provided
     And Max chars can enter is fifty in the length for Last Name field   
	   
	      
	 Scenario: Email field_Text field validation - mandatory check 
   Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen
   Then User provides no emailid and verify warning error message showing up
   
      
   Scenario: Email field_Minimum chars checks
   Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen
   Then user provides email text having less than five chars without @ symbol in <Emailid> and verify validation is done for minimum char
    |Emailid	| 
    |a| 
    |ab|
    |abcd| 
   
    
    Scenario: Email field_mail id with out @ symbol  
   Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen
   Then user provides email text without @ symbol in <Emailid> and verify validation is done for invalid emailid
    |Emailid	| 
    |a| 
    |ab|
    |abcdsdafdsfdsfdsf| 
    |abcdefegfgdf|
   
     
   Scenario: Verify User can be able to see the English in the Language drop down of Settings details at Settings page
   Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen
   Then User would be able to select the English text in Language drop down
   
   
   Scenario: Verify that save button is disabled if any of the field of firstname,lastname, email is not provided
   Given A User launches application logs in successfully with valid credentials
    And User navigates to Settings page by clicking Account Menu > Settings welcome screen
   Then save button is disabled if any of the field of firstname,lastname, email is not provided
   
   
	      
	       