@usps
Feature: USPS website scenarios

  Background:
    Given I go to "usps" page

  @usps1
  Scenario Outline: Validate ZIP code for specific address
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
    When  I go to Calculate Price Page
    *     I select "Canada" with "Postcard" shape
    *     I define "2" quantity
    Then  I calculate the price and validate cost is "$2.60"

  @usps3
  Scenario: Verify location
    When  I perform "Free Boxes" search
    *     I set filters
      | Send | Receive | International | USPS Corporate |
    Then  I verify that "329" results found
    When  I select "Priority Mail | USPS" in results
    *     I click "Ship Now" button
    Then  I validate that Sign In is required

  @usps4
  Scenario: Every door direct mail
    When  I go to "Every Door Direct Mail" under "Business"
    *     I search for "4970 El Camino Real, Los Altos, CA 94022"
    *     I choose view as "Table" on the map
    *     I select all in the table
    *     I close modal window
    Then  I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

  @usps5
  Scenario: Quadcopters delivery
    When  I go to "Help" tab
    *     I perform "Quadcopters delivery" help search
    Then  I verify that no results of "Quadcopters delivery" available in help

  @usps6
  Scenario: Phone number of the nearest Mail Pickup
    When  I navigate to "Locations" heading link
    *     I search for location "4970 El Camino Real 110, Los Altos, CA"
    Then  I verify closest location phone number is "650-960-0817"