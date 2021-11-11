@customWebDriverExercise
Feature: Selenium WebDriver API exercises using quote form

  @customWebDriverExercise1
  Scenario: Page details, navigation, resolution
    Given I go to "google" page
    And I print page details
    Given I go to "quote form" page
    And I print page details
    And I go back and forward, then refresh the page
    And I change resolution to "phone"
    And I change resolution to "desktop"