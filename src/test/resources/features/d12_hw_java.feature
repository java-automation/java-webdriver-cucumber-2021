@d12_hw_Java
Feature: Java feature

  @d12_hw_Java1
  Scenario: Quote end to end
    Given I open "quote" page
    And  I wait for 1 sec
    And I print logs to the console
    When I fill out required fields
    And I wait & check for 3 sec
    And I submit the page
    And I wait & check for 2 sec
    Then I verify the required fields