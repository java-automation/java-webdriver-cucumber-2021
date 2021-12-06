@quote
Feature: Selenium WebDriver API exercises using quote form

  @quote1
  Scenario: Page details, navigation, resolution
    Given I go to "google" page
    And I print page details
    Given I go to "quote form" page
    And I print page details
    And I go back and forward, then refresh the page
    And I change resolution to "phone"
    And I change resolution to "desktop"

  @quote2
  Scenario: Very basic "Email" field verification
    Given I go to "quote form" page
    When I verify email field behavior

  @quote3
  Scenario: Submit the form with specified field set and one of the preset profiles
    Given I go to "quote form" page
    When I fill out "all" fields with "Monica Smith" profile
    And Submit the form
    Then I verify that submitted fields got saved correctly