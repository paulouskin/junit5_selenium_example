Feature: Display filter tags on search result page
  As a user
  I want to see tags for applied filters on search results
  So that I can buy items which fit the best for me

  Scenario: Search for leather bag and apply shipping, shop location and item types filters
    Given I am on the main page
    When I accept terms and conditions
    And I search for "leather bags" items
    Then I get search results page for "leather bags" items
    When I apply "Free shipping" shipping filter
    And I apply "Anywhere" shop location filter
    And I apply "Handmade" item type filter
    Then "Free shipping, Anywhere, Handmade" filter tags is applied