@usps

Feature: Usps scenarios

# Home_work_12/28/21

  @usps1
  Scenario Outline: Validate zip code for address
    Given I go to "usps" page
    And I wait for 1 sec
    When I go to Lookup ZIP page by address
    And I fill out "<street>" street, "<city>" city, "<state>" state
    Then I validate "<result>" zip code exists in the result
    And  I wait for 2 sec

    # Outline Upgrade
    Examples:
      | street                | city      | state | result |
      | 555 W Madison         | Chicago   | IL    | 60661  |
      | 4970 El	Camino Real   | Los Altos | CA    | 94022  |
      | 3131 S Las Vegas Blvd | Las Vegas | NV    | 89109  |


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

  Scenario: Every door direct mail
    Given I go to "usps" page
    When I go to "Every Door Direct Mail" under "Business"
    And I search for "4970 El Camino Real, Los Altos, CA 94022"
    Then I click search
    And I choose view as "Table" on the map
    When I select all in the table
    And I close modal window
    Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summar


  @usps5
  Scenario: Quadcopters delivery
    Given I go to "usps" page
    When I go to "Help"  tab
    And I perform "Quadcopters delivery" help search
    And I wait for 2 sec
    Then I verify that no results of "Quadcopters delivery" available in help search

#Home_work_12/28/21
  @usps6
  Scenario: Phone number of the nearest Mail Pickup
    Given I go to "usps" page
    When I navigate to "Locations" heading link
    And I search for location "4970 El Camino Real, Los Altos, CA 94022"
    Then I verify closest location phone number is "800-275-8777"

