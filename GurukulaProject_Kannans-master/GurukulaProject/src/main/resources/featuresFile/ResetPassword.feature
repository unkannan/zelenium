#Author: Unni Kannan
@ResetPassword
Feature: Reset Password

  Scenario: Reset Password with unRegistered Email 
   Given A user launches application and navigates to Reset Password page through Forgot Password link
   Then verify that user is able to navigate to ResetPasswordpage
  
  
  Scenario: Reset Password with Invalid Email
   Given A user launches application and navigates to Reset Password page through Forgot Password link
   Then user provides a unregistered and invalid emailid <Emailid> and verify proper error message is shown
    |Emailid	| 
    |invalid@c.com| 
    |invalid@c| 
    |invalid@com|	 
    
   
   Scenario: Reset Password with Valid Email - Happy Path
   Given A user launches application and navigates to Reset Password page through Forgot Password link
   When user provides a valid registered email id "admin@localhost"
    
    
   Scenario: Email id Text Validation - alpha chars, alphanumberic entry
   Given A user launches application and navigates to Reset Password page through Forgot Password link
   Then user provides emailid without @ symbol in <Emailid> and verify proper error message is shown
    |Emailid	| 
    |abcde| 
    |12345|
    |abcde12345| 
    
    
    Scenario: Emailid - Minimum Chars Entry validation check  
   Given A user launches application and navigates to Reset Password page through Forgot Password link
   Then user provides emailid with less than five chars in <Emailid> and verify proper error message is shown
    |Emailid	| 
    |abc| 
    |abcd|
    |a| 
    |1234| 
    
    
     Scenario: Emailid - Maximum Chars Entry validation check  
   Given A user launches application and navigates to Reset Password page through Forgot Password link
   Then user provides emailid with more than fifty chars in <Emailid> and verify proper error message is shown
    |Emailid	| 
    |sfsdfsfsddddddddsafdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd| 
    |sfsdfsfsddddddddsafdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsdfsdfsdfsfsdfs|
    |sfsdfsfsddddddddsafdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddsdfsdfsdfsfsdfsfsdfsfsdfs|  
    
    
   
   Scenario: Emailid - Mandatory field check Validation 
   Given A user launches application and navigates to Reset Password page through Forgot Password link
   Then user provides no emailid and verify proper error message is shown
    	 
     	  
 
  
   
   
  
