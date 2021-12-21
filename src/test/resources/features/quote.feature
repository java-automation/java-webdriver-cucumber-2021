@quote
Feature: Quote Feature

  @quote1
  Scenario: Quote end to end
    Given I go to "quote" page
    And I print logs to the console
    When I fill out required fields
    And I wait for 2 sec
    And I submit the page
    Then I verify the required fields
