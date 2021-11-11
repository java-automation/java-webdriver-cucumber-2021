@customWebDriverExercise
Feature: Selenium WebDriver API exercises

  @customWebDriverExercise1
  Scenario: Page details plus navigation
    Given I go to "google" page
    And I print page details
    Given I go to "quote form" page
    And I print page details
    And I go back and forward, then refresh the page