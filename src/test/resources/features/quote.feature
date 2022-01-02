@quote
Feature: Selenium WebDriver API exercises using quote form

  @quote1
  Scenario: Page details, navigation, resolution
    Given I go to "yahoo" page
    Then  I print page details
    *     I wait for 1 sec
    *     I print logs to the console
    Given I go to "quote form" page
    Then  I print page details
    *     I wait for 1 sec
    *     I print logs to the console
    *     I go back and forward, then refresh the page
    *     I change resolution to "phone"
    *     I wait for 1 sec
    *     I change resolution to "desktop"
    *     I wait for 1 sec

  @quote2
  Scenario: Very basic "Email" field verification
    Given I go to "quote form" page
    Then  I verify email field behavior

  @quote3
  #valid entries when filling the form: "all"/"required"; "Monica Smith"/"John Doe"
  Scenario: Submit the form with specified field set and one of the preset profiles
    Given I go to "quote form" page
    When  I fill out "all" fields with "Monica Smith" profile
    *     I wait for 3 sec
    *     Submit the form
    Then  I verify that submitted fields got saved correctly
    *     I wait for 5 sec