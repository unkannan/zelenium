#Author: your.email@your.domain.com
#Keywords Summary :
@FunctionalTesting
Feature: Update Password Functional check 
   
Scenario: Verify user can navigate to update password page and validation of the update password page 
  Given A user launches application logs in successfully with valid credentials
  And clicking Password submenu under Account Menu options and navigates to update password page
  And user should be able to navigate to Update Password page
   
   
  Scenario: Verify user should be able to update password
  Given A user launches application logs in successfully with valid credentials
  And clicking Password submenu under Account Menu options and navigates to update password page 
  And User provides the New Password and New Password Confirmation
  Then clicking save password should get updated successfully
     

  
  Scenario: Verify that New Password field validation of limiting of 50 chars is shown in Update Password page
  Given A user launches application logs in successfully with valid credentials
  And clicking Password submenu under Account Menu options and navigates to update password page  
  And user provides more than fifty chars length in the New Password text field
  Then Verify that Error message is shown up stating cannot be more than fifty chars for Password field
   
   
     Scenario: Verify that Confirm Password field validation of limiting of 50 chars is shown in Update Password page
  Given A user launches application logs in successfully with valid credentials 
  And clicking Password submenu under Account Menu options and navigates to update password page
  And user provides more than fifty chars length in the confirm Password text field
  Then Verify that Error message is shown up stating cannot be more than fifty chars for confirm Password field
   
   
  Scenario: Verify that Password minimum characters field validation on Update Password page
  Given A user launches application logs in successfully with valid credentials
  And clicking Password submenu under Account Menu options and navigates to update password page  
  And user provides less than five chars as "abcd" in the New Password text field
  Then Verify that Error message is shown up stating enter more than five chars for Password field
    
    
  Scenario: Verify that Confirm Password minimum characters field validation on Update Password page
  Given A user launches application logs in successfully with valid credentials
  And clicking Password submenu under Account Menu options and navigates to update password page
  And user provides less than five chars as "abcd" in the Confirm Password text field
  Then Verify that Error message is shown up stating enter more than five chars for Confirm Password field
    
    
 Scenario: Verify that Password required field validation on Update Password page
  Given A user launches application logs in successfully with valid credentials 
  And clicking Password submenu under Account Menu options and navigates to update password page
  Then Verify that Error message if data is not provided in password field
   
   
  Scenario: Verify that Confirm Password required field validation on Update Password page
  Given A user launches application logs in successfully with valid credentials 
  And clicking Password submenu under Account Menu options and navigates to update password page
  Then Verify that Error message if data is not provided in confirm password field
   
   
  Scenario: Verify password & confirm password match validation on Updated Password page
  Given A user launches application logs in successfully with valid credentials 
  And clicking Password submenu under Account Menu options and navigates to update password page 
  And user provides text "password" in new password and "NotMatchingPassword" in Confirm Password text field which are not matching
  Then Verify that Error message is shown up if new password and confirm password not matching
   
   
 Scenario: Verify password strength color should reflect according to password complexity
  Given A user launches application logs in successfully with valid credentials 
  And clicking Password submenu under Account Menu options and navigates to update password page 
  And user provides different password text for complexity check and seen that password Strength is shown up  
   
  
  