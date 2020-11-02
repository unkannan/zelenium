#Author: Unni Kannan
#Summary:  This feature is about the functionaliy on Staff page of having Title Verification, creating the Staff, Editing the Staff, Deleting the Staff, 
#Text Field Validations
@StaffPage
Feature: Staff Page Functional Check

 	 Scenario: Navigate to Staff page-User would be able to navigate to Staff page from Account menu > Staff   
    Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff 
    Then User should be able to see the Staff page

   Scenario: Create Staff page Navigation -User should be able to navigate to Create Staff page from Staff page
    Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff  
    And  User able to click Create a new Staff link
    Then  User should be able to see a popup for creating a Staff
    
    Scenario: Create Branches as a pre-requisite for creating Staffs for the new Branches
  	Given Staff Feature_User launches the application
    And User logs in and navigates to Branch page by clicking Account Menu > Branch
    Then User creates Branches <BrancheName> and <Code> as a pre-requisites 
     |BrancheName	|Code	|
    |BranchOneForStaff		|111|
    |BranchTwoForStaff		|122|	
  
  	Scenario: Create Staff Functionality> Staff created Functionality -User would be able to create a new staff and can see the same created staff details in the staff page   
  	Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff   
    Then create four different Staffs  of <Name> and <Branch>  
    |Name	|Branch	|
    |oneSTAFFSELENIUM		|BranchOneForStaff|
    |twoSTAFFSELENIUM		|BranchTwoForStaff|	
    |THREESTAFFSELENIUM	|BranchTwoForStaff|
    When on the same page, user search for the Staff using Staff name "oneSTAFFSELENIUM"
    Then Staff details page should be shown in the Staff list for "oneSTAFFSELENIUM" as the staff is created
    
     Scenario: Create Staff Functionality without Branch> User would be able to create a new staff without a Branch   
  	Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff   
    Then create four different Staffs  of <Name> without Branch selection  
    |Name	|Branch	|
    |oneStaffWithoutBranch		||
    |twoStaffWithoutBranch		||	
    |threeStaffWithoutBranch	||
    When on the same page, user search for the Staff using Staff name "oneStaffWithoutBranch"
    Then Staff details page should be shown in the Staff list for "oneStaffWithoutBranch" as the staff is created
    
    
    Scenario: Create Staff > Cancel Button -Staff will not be created when user clicks cancel in creating Staff pop up page 
    Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff    
    And  User able to click Create a new Staff link
    And User provides the details "CancelStaffName" and "BranchOneForStaff" in the Create new Staff popup page and clicks Cancel button
    Then User cannot see the Staff "CancelStaffName" and "BranchOneForStaff" in the Staffs page as it is cancelled
    
   Scenario: Staff page > View -User would be able to see the Staff details by clicking view link   
     Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff  
    And  	User clicks the view link for the <OneStaffSelenium> code in the webtable
    Then 	User can see the Staff details 
    
    Scenario: Staff View Page > Back Button functionality - User would be able Navigate to Staff page by clicking Back button in respective Branch page   
    Given Staff Feature_User launches the application
    And  User logs in and navigates to Staff page by clicking Account Menu > Staff  
    And  User clicks the view link for the <OneStaffSelenium> code in the webtable
    And  Back should be available in Branch details page and cicking Back button should navigate to Staff page
    Then User should be able to see the Staff page
    
    Scenario: Create Staff Popup > Name Text field validation > Name field in Create Staff popup has mandatory check,minmum char length, max char lenth for Name field   
    Given Staff Feature_User launches the application
    And  User logs in and navigates to Staff page by clicking Account Menu > Staff 
    And  User able to click Create a new Staff link
    Then Create_Edit_Staff_Pop_Up_Name text field has functionality of mandatory check,max char lenth
    
   Scenario: Staff > Edit link -Clicking Edit link should navigate to Edit Branch page    
    Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff
    Then  Name and Branch is shown in Edit Staff page
      
   Scenario: Staff > Edit link > Cancel -Clicking cancel button should not able to modify the Staff details  
    Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff
    And  User clicks Edit Staff link
    And User provides the details "CancelStaffName" in the Create new Staff popup page and clicks Cancel button
    Then User cannot see the staff "CancelStaffName" in the Staff page as it is cancelled
    
   Scenario: Staff > Edit link > Save -Clicking save button should be able to modify the Staff details  
    Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff
   And  User clicks Edit Staff link
    And User provides the details "EditedStaffName" in the Edit Staff popup page and clicks save button
     Then User can see the Staff "EditedStaffName" created and listed in the Staff page
    
   Scenario: StaffID > Delete > Cancel -Clicking cancel button should not able to delete the Staff details  
   Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff
    And  	User clicks the Delete link for <EditedStaffName>
    And  User Clicks the cancel button in Staff popup window 
    Then User can see the Staff "EditedStaffName" listed in the Staffs page
    
    
   Scenario: StaffID > Delete > Cancel -Clicking cancel button should not able to delete the Staff details  
    Given Staff Feature_User launches the application
    And User logs in and navigates to Staff page by clicking Account Menu > Staff
    And  	User clicks the Delete link for <EditedStaffName>
    And  User Clicks the Delete button in Staff popup window 
    Then User cannot see the Staff "EditedStaffName" in the Staffs page
     
     
   