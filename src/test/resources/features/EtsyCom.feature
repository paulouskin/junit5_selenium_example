Feature: Search for items on Etsy
  As a user
  I want to search for different items
  So that I will be able to buy necessary items fast

  Scenario: Search for particular item
    Given I go to "Etsy.com" page
    When I accept terms and conditions
    And I search for "handmade paper toy" items
    Then I get results page for "handmade paper toy" items