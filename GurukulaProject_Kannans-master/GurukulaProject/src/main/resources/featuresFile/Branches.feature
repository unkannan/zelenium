#Author: Unni Kannan
#This feature is about the functionaliy on Branches page of having Title Verification, creating the Branch, Editing the Branch, Deleting the Branch, 
#Text Field Validations
@BranchFunctionalTesting
Feature: Branches functionality.  Covering the scnarios of Create, Edit, Delete Branch, Field Validation 

	  Scenario: Branches Page Title Verification    
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    Then User should be able to see the Branches page

    Scenario: Create Branch page popup Title verification 
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  User able to click Create a new Branch link
    Then  User should be able to see a popup for creating a Branch
    
    Scenario: Create Branch > Cancel Button - Branch will not be created when user clicks cancel in creating Branch pop up page 
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  User able to click Create a new Branch link
    And User provides the details "CancelBranchName" and "8888" in the Create new Branch popup page and clicks Cancel button
    Then User cannot see the Branch "CancelBranchName" and "8888" in the Branches page as it is cancelled
    
    Scenario: Create Branch Functionality - Create Branch click and click Save to create a Branch   
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  User able to click Create a new Branch link
    And User provides the details "NewBranchName" and "7777" in the Create new Branch popup page and clicks Save button
    Then User can see the Branch "NewBranchName" and "7777" created and listed in the Branches page
    
    Scenario: Create Multiple Branches Functionality
  	Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    Then User creates Branches by giving Branch Name <BranchName> in Name field and Code <Code> in code Field in Create Branch popup page and clicks save button
     |BranchName	|Code	|
    |GurukulBranchOne		|777|
    |GurukulBranchTwo		|888|	
    |GurukulBranchThree		|999|	
    
    Scenario: Click View link to see Branch details    
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  	User clicks the view link for the <NewBranchName> code in the webtable
    Then 	User can see the Branch details
    
    Scenario: Click Branch ID - User would be able to see the Branch details by clicking Branch ID link   
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  	User clicks the Branch ID of given <NewBranchName> in the webtable
    Then 	User can see the Branch details of "GurukulBranchOne" and "777" of the BranchID 
    
    
    Scenario: Branch View Page > Back Button functionality - User would be able Navigate to Branches page by clicking Back button in respective Branch page   
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  	User clicks the view link for the <NewBranchName> code in the webtable
    And  Back should be available in Branch details page and cicking Back button should navigate to Branches page
    Then User should be able to see the Branches page
    
    
   Scenario: Branch Popup> Name Text field validation for mandatory,length checks     
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  User able to click Create a new Branch link
    Then  Name text field has functionality of mandatory check,minmum char length, max char lenth
    
    
   Scenario: Branch Popup> Code Text field validation for mandatory,length checks,Digits entry check   
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
     And  User able to click Create a new Branch link
    Then  Code text field has functionality of mandatory check,only digits can be entered
    
    
    Scenario: Edit link Functional check -Clicking Edit link should navigate to Edit Branch page    
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  	User clicks Edit link
    Then  Name and Code is shown for for "NewBranchName" and "7777" in Edit Branch page 
    
     
     Scenario: Edit link_Cancel button functional check -Clicking cancel button should not able to modify the Branch details  
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  	User clicks Edit link
    And User provides the details "CancelBranchName" and "8888" in the Create new Branch popup page and clicks Cancel button
    Then User cannot see the Branch "CancelBranchName" and "8888" in the Branches page as it is cancelled
    
    
   Scenario: Edit link_Save button functional check - Clicking Save button should save the modified branch details  
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
     And  	User clicks Edit link
    And User provides the details "EditedBranchName" and "8888" in the Create new Branch popup page and clicks save button
     Then User can see the Branch "EditedBranchName" and "8888" created and listed in the Branches page
     
     
     Scenario: Delete popup_Cancel button functional check -Clicking cancel button should not able to delete the Branch details  
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  	User clicks the Delete link for <EditedBranchName>
    And  User Clicks the cancel button in popup window 
    Then User can see the Branch "EditedBranchName" and "8888" created and listed in the Branches page
    
    
     Scenario: Delete functinal check -Clicking Delete button in delete popup should delete the Branch details  
    Given Branches Feature_User launches the application
    And User logs in and navigates to Branches page by clicking Account Menu > Branches 
    And  	User clicks the Delete link for <EditedBranchName>
    And  User Clicks the Delete button in popup window 
    Then User cannot see the Branch "EditedBranchName" and "8888" created and listed in the Branches page
    
  
  