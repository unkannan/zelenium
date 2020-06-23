@SmokeTest
Feature: Sessions Page Functional Scenarios
  
 
  
  Scenario: Verify that user can navigate for the sessions page 
    Given Sessions_FunctionalityCheck_Feature_user login into the Gurukul application
    When user navigates navigate to the sessions page through Account > Sessions menu
    Then user should be able to navigate and see the sessions page
    

    Scenario: Verify that user can able to delete the session 
    Given Sessions_FunctionalityCheck_Feature_user login into the Gurukul application
    When user navigates navigate to the sessions page through Account > Sessions menu 
    And User should be able to invalidate the sessions
    Then Valid message should be shown stating the session is invalidated 
      
	