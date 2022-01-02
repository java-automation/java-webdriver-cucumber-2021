@usps
  Feature: USPS scenarios

    @usps1
    Scenario Outline: Validate ZIP code for Portnov Computer School
      Given I go to "usps" page
      When I go to Lookup ZIP page by address
      And I fill out <sStreet> street, <sCity> city, <sState> state
      And I click button Find
      And I wait result being loaded
      Then I validate <sZipCode> zip code exists in the result
      And I validate <sZipCode1> zip code exists in the result
      Examples:
        | sStreet               | sCity          | sState | sZipCode     | sZipCode1 |
        | "4970 El Camino Real" | "Los Altos"    | "CA"   | "94022-1473" | "94022"   |
        | "200 Cherokee Rd"     | "Nashville"    | "TN"   | "37205-1818" | "37205"   |
        | "710 N Elm Ave"       | "Broken Arrow" | "OK"   | "74012-2574" | "74012"   |

  @usps2
  Scenario Outline: Calculate price
    Given I go to "usps" page
    When I go to Calculate Price page
    And I select "<Country>" with "<Type>" shape
    And I define "<Qnt>" quantity
    Then I calculate the price and validate cost is "<Total>"
    Examples:
      | Country                                                               | Type     | Qnt | Total |
      | Canada                                                                | Postcard | 2   | $2.60 |
      | United Kingdom (United Kingdom of Great Britain and Northern Ireland) | Postcard | 2   | $2.60 |

  Scenario: Verify location
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Send" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required

  Scenario: Every door direct mail
    Given I go to "usps" page
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I choose view as "Table" on the map
    When I select all in the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

  Scenario: Quadcopters delivery
    Given I go to "usps" page
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search

  Scenario: Phone number of the nearest Mail Pickup
    Given I go to "usps" page
    When I navigate to "Locations" heading link
    And I search for location "4970 El Camino Real 110, Los Altos, CA"
    Then I verify closest location phone number is "800-275-8777"