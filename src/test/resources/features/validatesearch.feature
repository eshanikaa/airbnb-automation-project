Feature: Airbnb Search Feature
  Scenario: User searches for a location
    Given User is on Airbnb homepage
    When User enters location "New York"
    And User clicks on search button
    Then Search results should be displayed
 