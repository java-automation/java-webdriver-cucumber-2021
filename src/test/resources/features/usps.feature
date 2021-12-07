@usps
  Feature: USPS scenarios

  @usps1
  Scenario: Validate ZIP code for Portnov Computer School
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    And I click button Find
    And I wait result being loaded
    Then I validate "94022-1473" zip code exists in the result
#    And I go back to search form
    And I validate "94021" zip code exists in the result