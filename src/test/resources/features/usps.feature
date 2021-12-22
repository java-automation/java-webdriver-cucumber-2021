@usps
Feature: USPS website scenarios

  @usps1
  #valid inputs for Lookup ZIP strategies: "quick tools"/"send"/"mouseover"
  Scenario: Validate ZIP code for Portnov Computer School
    Given I go to "usps" page
    When  I go to Lookup ZIP page by address through "mouseover"
    *     I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then  I validate "94022" zip code exists in all results

  @usps2
  Scenario: Calculate price
    Given I go to "usps" page
    When  I go to Calculate Price Page
    *     I select "Canada" with "Postcard" shape
    *     I define "2" quantity
    Then  I calculate the price and validate cost is "$2.60"

  @usps3
  Scenario: Verify location
    Given I go to "usps" page
    When  I perform "Free Boxes" search
    *     I set filters
      | Send | Receive | International | USPS Corporate |
    Then  I verify that "330" results found
    *     I go to 1 results page
    When  I select "Priority Mail | USPS" in results
    *     I click "Ship Now" button
    Then  I validate that Sign In is required