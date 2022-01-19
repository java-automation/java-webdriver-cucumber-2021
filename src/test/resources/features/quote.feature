@quote
Feature: Quote Feature

  @quote1
  Scenario: Quote end to end
    Given I go to "quote" page
    And I print logs to the console
    When I fill out the required fields
    And I do multi select of "Ford", "Toyota" and "BMW"
    And I wait for 1 sec
    And I submit the page
    And I wait for 5 sec
    Then I verity the required fields

  @quote2
  Scenario: Homework with quote
    Given I go to "google" page and print details
    And I go to "quote" page and print details
    And I go back and forward, then refresh the page
    And I change resolution to "phone"
    And I wait for 2 sec
    And I change resolution to "desktop"
    And I wait for 2 sec

  @quote3
  Scenario: Quote switch to
    Given I go to "quote" page
    And I click on Related Documents
    And I verify "Document 2" is on the list
    And I "accept" third party agreement
    And I enter "Richard Roe" as a contact person with a phone "123456789"