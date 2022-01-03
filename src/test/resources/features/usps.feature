@usps
Feature: USPS scenarios

  @usps1
  Scenario: Validate ZIP code for Portnov Computer School
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  @usps1_1
  Scenario: Validate ZIP code for Portnov Computer School with resizing initial window and Quick Tool Tracking options;
    Given I go to "usps" page
    When I go to Lookup ZIP page by address with resizing initial window and Quick Tool Tracking options panel
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  @usps1_2
  Scenario: Validate ZIP code for Portnov Computer School through navigation panel
    Given I go to "usps" page
    When I go to Lookup ZIP page by address through navigation panel
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  @usps1_3
  Scenario: Validate ZIP code for Portnov Computer School through hamburger menu bar
    Given I go to "usps" page
    When I go to Lookup ZIP page by address through hamburger menu bar
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  @usps2
  Scenario: Calculate price
    Given I go to "usps" page
    When I go to Calculate Price Page
    And I select "Canada" with "Postcard" shape
    And I define "2" quantity
    Then I calculate the price and validate cost is "$2.60"

  @usps3
  Scenario: Verify location
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Send" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required

  @usps4
  Scenario: group study 20 results
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Business" in filters
    Then I verify that "20" results found

  @usps5
  Scenario: group study 320 results
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Postal Explorer" in filters
    Then I verify that "320" results found

  @usps6
  Scenario: group study 314 results
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "USPS Corporate" in filters
    Then I verify that "314" results found

  @usps7
  Scenario: Every door direct mail
    Given I go to "usps" page
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    And I choose view as "Table" on the map
    When I select all in the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

  @usps8
  Scenario Outline: Validate ZIP code for Portnov Computer School with 3 addresses
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<zipCode>" zip code exists in the result
    Examples:
      | street              | city        | state | zipCode |
      | 4970 El Camino Real | Los Altos   | CA    | 94022   |
      | 6025 S Pecos Rd     | Las Vegas   | NV    | 89120   |
      | 3903 N St Mary's St | San Antonio | TX    | 78212   |

  @usps9
  Scenario Outline: Quadcopters delivery
    Given I go to "usps" page
    When I go to "Help" tab
    And I perform "<search query>" help search
    Then I verify that "<doWeHaveResultsAvailable>" results of "<search query>" available in help search
    Examples:
      | search query         | doWeHaveResultsAvailable |
      | Quadcopters delivery |                          |
      | Quadcopters          | no                       |
      | Operation Santa      |                          |

  @usps10
  Scenario: Phone number of the nearest Mail Pickup
    Given I go to "usps" page
    When I navigate to "Locations" heading link
    And I search for location "4970 El Camino Real 110, Los Altos, CA"
    Then I verify closest location phone number is "800-275-8777"

  @usps11
  Scenario: Quadcopters delivery
    Given I go to "usps" page
    When I go to "Help" tab
    And I perform "Quadcopters delivery" help search
    Then I verify that no results of "Quadcopters delivery" available in help search

