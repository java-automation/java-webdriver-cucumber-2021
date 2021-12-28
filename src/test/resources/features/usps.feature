@usps
Feature: USPS website scenarios

  @usps1
  Scenario Outline: Validate ZIP code for specific address
    Given I go to "usps" page
    When  I go to Lookup ZIP page by address through "<strategy>"
    *     I fill out "<address>" street, "<city>" city, "<state>" state
    Then  I validate "<zip>" zip code exists in all results

    Examples:
      | strategy    | address               | city          | state | zip   |
      | quick tools | 4970 El Camino Real   | Los Altos     | CA    | 94022 |
      | send        | Pacific Coast Highway | Malibu        | CA    | 90265 |
      | mouseover   | Golden Gate Bridge    | San Fransisco | CA    | 94102 |

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