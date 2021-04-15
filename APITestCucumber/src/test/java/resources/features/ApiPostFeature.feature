@tag
Feature: POST feature
  I want to use this feature for posting my requests

  @tag1
  Scenario Outline: This is new scenario
    Given a endpoint
    When I submit a request for "<username>" and "<password>"
    Then should execute
    |username	|password	|
    |admin		|admin1		|
    |admin1		|admin		|	
    
