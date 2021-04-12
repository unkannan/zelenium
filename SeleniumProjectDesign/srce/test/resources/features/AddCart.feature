 
@functional
Feature: Add Car feature
   
  @Regression
  Scenario: Adding Cart
    Given the application of Flipkart
    And user is able to login
    When click Add Cart
    And Add the product
    Then the product is added to cart 