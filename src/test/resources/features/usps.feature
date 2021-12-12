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



