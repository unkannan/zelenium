@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @smoke
  Scenario: To verify Rest service of all uses list-GET Method
    Given I want to execute getUsersList endpoint
    When I submit the GET request
    Then I should get 200 sucess Status code
    
  @tag1
  Scenario: To verify Rest service of single user Provided-GET Method
    Given I want to execute SingleUser endpoint
    When I submit the GET request for single user
    Then I should get 200 sucess Status code
    And I should get Success statusCodeLine
    And I should get the Janet User details

    
    
    
     @tag1
  Scenario: To verify Rest service for single user end point -POST Method
    Given I want to execute createSingletUsersList endpoint
    When I submit the POST request for create single user
    Then I should get 201 sucess status code along with resonse body

  
    