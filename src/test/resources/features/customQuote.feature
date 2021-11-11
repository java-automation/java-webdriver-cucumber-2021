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
  Scenario: Submit the form with required fields only
    Given I go to "quote form" page
    When I fill out required fields with "Alan Smith" profile
    And Submit the form
    Then I verify that submitted required fields got saved correctly