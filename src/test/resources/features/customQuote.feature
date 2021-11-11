@customQuote
Feature: Selenium WebDriver API exercises using quote form

  @customQuote1
  Scenario: Page details, navigation, resolution
    Given I go to "google" page
    And I print page details
    Given I go to "quote form" page
    And I print page details
    And I go back and forward, then refresh the page
    And I change resolution to "phone"
    And I change resolution to "desktop"

  @customQuote2
  Scenario: Submit the form with specified field set and one of the preset profiles
    Given I go to "quote form" page
    When I fill out "all" fields with "Monica Smith" profile
    And Submit the form
    Then I verify that submitted fields got saved correctly