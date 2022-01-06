@quote
Feature: Quote Feature

  @quote1
  Scenario: Quote end to end
    Given I go to "quote" page
    And I print logs to the console
    When I fill out required fields
    And I wait for 2 sec
    And I submit the form
    Then I verify that submitted fields saved correctly

  @quoteJanuary03
  Scenario: Using Actions with key press
    Given I go to "quote" page
    Then I select few element in Car Make list with Action

  Scenario: Using Select class with select tag
    Given I go to "quote" page
    Then I select few elements in Car Make list with Select Class