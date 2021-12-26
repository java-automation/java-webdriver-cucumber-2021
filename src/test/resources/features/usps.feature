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
    When  I select "Priority Mail | USPS" in results
    *     I click "Ship Now" button
    Then  I validate that Sign In is required

  @usps4
  Scenario: Every door direct mail
    Given I go to "usps" page
    When  I go to "Every Door Direct Mail" under "Business"
    *     I search for "4970 El Camino Real, Los Altos, CA 94022"
    *     I choose view as "Table" on the map
    *     I select all in the table
    *     I close modal window
    Then  I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary