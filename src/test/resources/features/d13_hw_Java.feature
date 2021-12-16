@d13_hw_Java
Feature: Java feature

  @d13_hw_Java1
  Scenario: Validate ZIP code for Portnov Computer School
    Given I open "usps" page
    And I wait & check for 2 sec
    When I go to Lookup ZIP page by address
    And I wait & check for 2 sec
    And I fill out "830 Stewart Dr" street, "Sunnyvale" city, "CA" state
    And I wait & check for 3 sec
    Then I validate "94085" zip code exists in the result

  @d13_hw_Java2
  Scenario: Function that sorts List<Integer>
    Given I sort List<Integer>

  @d13_hw_Java3
Scenario: Function that sorts List<String>
    Given I sort List<String>