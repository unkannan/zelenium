@tag
Feature: Post Methods check for creating user

  @tag1
  Scenario: Creating a new user
    Given the endpoint URl 
    When I send a post request
    Then verify the new user is created
    And status code should be success 