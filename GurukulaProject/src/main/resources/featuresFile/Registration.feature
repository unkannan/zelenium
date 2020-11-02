@Registration
Feature: Registration Page Functionality Check 
   
	  Scenario: Registering Existing User  - User should not be able to register by providing existing user details   
    Given Registration_Feature_User launches the application
    And user navigates to Registration details page by clicking Register a new Account link in welcome screen
    When user provides the Registration details as <username> ,<Email>, <password>, <ConfirmPassword>
		|admin		|Email@yahoo.com|password		|password|
		 And Clicking Register button 
		 Then User should not be able to register as it is an existing user
		 
   Scenario: Registering New User - User should be able to register in application with valid user details 
    Given Registration_Feature_User launches the application
    And user navigates to Registration details page by clicking Register a new Account link in welcome screen
    When user provides the Registration details as <username> ,<Email>, <password>, <ConfirmPassword>
		|admin1		|Email@yahoo.com|Kann$11112		|Kann$11112|
    And Clicking Register button 
	  Then user should be successfully able to register
	   
	    
	 Scenario: Login Text Field Validation -   Validation of Login Text field with mandatory, length checks 
    Given Registration_Feature_User launches the application
    And user navigates to Registration details page by clicking Register a new Account link in welcome screen
     Then Max chars length check for Login text field if more than fifty chars entered
     And mandatory field check for Login text field if login is not provided
   And lower-case letters and digits check for Login text field if special chars entered 
   

	 Scenario: Password Text Field Validation -   Validation of Password Text field with mandatory, length checks 
    Given Registration_Feature_User launches the application
    And user navigates to Registration details page by clicking Register a new Account link in welcome screen
     Then mandatory field check for Password text field if text is not entered
      And Min chars length check for Password text field if text is less than five chars
      And Max chars length check for Password text field if text is more than fifty chars 
     
     
    Scenario: confirm Password Text Field Validation -   Validation of confirmation Password Text field with mandatory, length checks 
    Given Registration_Feature_User launches the application
    And user navigates to Registration details page by clicking Register a new Account link in welcome screen
     Then mandatory field check for confirmation Password text field if text is not entered
      And Min chars length check for confirmation Password text field if text is less than five chars
      And Max chars length check for confirmation Password text field if text is more than fifty chars 
	  And Branches_FunctionalityCheck_Feature_user closes the session
	  
	   Scenario: Password Not Matching Validation - Password and confirmation password text NOT matching validation  
  Given Registration_Feature_User launches the application
    And user navigates to Registration details page by clicking Register a new Account link in welcome screen 
  When user provides the Registration details as <username> ,<Email>, <password>, <ConfirmPassword>
		|admin1		|Email@yahoo.com|Password	|PasswordNotmatching|
		 And Clicking Register button
  Then Verify that valid warning Error message is shown up if new password and confirm password not matching
  
  
     Scenario: Password Matching Validation   -  assword and confirmation password text matching validation  
  Given Registration_Feature_User launches the application
    And user navigates to Registration details page by clicking Register a new Account link in welcome screen 
  When user provides the Registration details as <username> ,<Email>, <password>, <ConfirmPassword>
		|admin1		|Email@yahoo.com|Password	|PasswordNotmatching|
		 And Clicking Register button
  Then Verify that valid warning Error message is shown up if new password and confirm password not matching
  
  
  Scenario: Password Strength Check Validation   -  Verify password strength color should reflect according to password complexity
  Given Registration_Feature_User launches the application
    And user navigates to Registration details page by clicking Register a new Account link in welcome screen
   Then user provides different password text in Registration page for complexity check and seen that password Strength is shown up 
  