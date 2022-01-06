@quote
Feature: Selenium WebDriver API exercises using quote

  Background:
    Given I go to "quote form" page

  @quote1
  Scenario: Page details, navigation, resolution
    Then  I print page details
    *     I wait for 1 sec
    *     I print logs to the console
    *     I go back and forward, then refresh the page
    *     I change resolution to "phone"
    *     I wait for 1 sec
    *     I change resolution to "desktop"
    *     I wait for 1 sec
    Given I go to "yahoo" page
    Then  I print page details
    *     I wait for 1 sec
    *     I print logs to the console

  @quote2
  Scenario: Very basic "Email" field verification
    Then  I verify email field behavior

  @quote3
  #valid entries when filling the form: "all"/"required"; "Monica Smith"/"John Doe"
  Scenario: Submit the form with specified field set and one of the preset profiles
    When  I fill out "all" fields with "Monica Smith" profile
    *     I wait for 3 sec
    *     Submit the form
    Then  I verify that submitted fields got saved correctly
    *     I wait for 5 sec

  @quote4
  #valid strategies: "select"/"actions"
  Scenario Outline: Multiple choice select
    Then  I select "<options>" in Car Make Select with "<strategy>"
    *     I wait for 2 sec

    Examples:
      | options          | strategy   |
      | Ford, BMW, Other | select     |
      | Toyota, BMW      | actions    |