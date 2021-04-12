 
@functional
Feature: Loin Functional Check

  @functional1
  Scenario: Login Functionality testing with correct credentials
    Given the web application for the user
    And navigates to the Amazon application
    When he navigates to the home page
    And enters the username
    And enters the password
    And clicks Login button
    Then home page is opened
    And user is able to login

  
