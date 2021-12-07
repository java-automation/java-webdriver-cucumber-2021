@usps
Feature: USPS website scenarios

  @usps1
  Scenario: Validate ZIP code for Portnov Computer School
    Given I go to "usps" page
    When  I go to Lookup ZIP page by address
    *     I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then  I validate "94022" zip code exists in the result