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
    Then I verify that "20" results found1

  @usps5
  Scenario: group study 320 results
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Postal Explorer" in filters
    Then I verify that "320" results found1

  @usps6
  Scenario: group study 314 results
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "USPS Corporate" in filters
    Then I verify that "314" results found1
