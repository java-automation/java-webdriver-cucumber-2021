@quote
Feature: Quote Feature

  @quote1:
  Scenario: Quote end to end
    Given I go to "quote" page
    And I print logs to the console
    When I fill out required fields
    When I fill out optional fields
    And I wait for 2 sec
    And I submit the form
    Then I verify the required fields

  @quote2:
  Scenario: Printing URL by page name
    Given I print URL for page "google"
    And I print URL for page "yahoo"
    And I print URL for page "test"

  @quote3:
  Scenario: Go to and print details
    Given I go to "quote" page
    And I print page details

  @quote4:
  Scenario: Using navigation methods
    Given I go to "google" page
    And I print page details
    And I go to "quote" page
    And I print page details
    And I go back and forward, then refresh the page

  @quote5:
  Scenario: Changing page resolution
    Given I go to "quote" page
    And I change resolution to "phone"
    And I wait
    And I change resolution to "desktop"
    And I wait

  @quote6:
  Scenario: Correct saving of entered required data
    Given I go to "quote" page
    When I fill out required fields
    And I submit the form
    And I wait
    Then I verify that submitted fields saved correctly

  @quote7:
  Scenario: Correct saving of entered optional data
    Given I go to "quote" page
    When I fill out required fields
    And I fill out optional fields

  @quote8:
  Scenario: Email field behavior
    Given I go to "quote" page
    When I verify email field behavior

  @quote9:
  Scenario: Manipulate multi-select in quote page with Actions
    Given I go to "quote" page
    When I select "Ford,Toyota,BMW" car makes with Actions
    And I fill out required fields
    And I submit the form
    Then I verify that submitted fields saved correctly
    Then I verify car makes

  @quote10:
  Scenario: Manipulate multi-select in quote page with Select
    Given I go to "quote" page
    When I select "BMW,Toyota,Other" car makes with Actions
    And I fill out required fields
    And I submit the form
    Then I verify that submitted fields saved correctly
    Then I verify car makes
