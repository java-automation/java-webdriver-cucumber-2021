@quote_oop
Feature: Quote page and page object pattern

  Background:
    Given I go to quote form page OOP

  @quote_oop1
  #valid entries when filling the form: "all"/"required"; "Monica Smith"/"John Doe"
  Scenario: Submit the form with specified field set and one of the preset profiles
    When  I fill out "all" fields with "Monica Smith" profile OOP
    *     I wait for 3 sec
    *     I submit the form OOP
    Then  I verify that submitted fields got saved correctly OOP
    *     I wait for 3 sec

  @quote_oop2
  Scenario: Required fields test
    Then I don't see "username" error message
    *    I don't see "email" error message
    *    I don't see "password" error message
    *    I don't see "name" error message
    *    I don't see "agreedToPrivacyPolicy" error message
    When I submit the form OOP
    Then I see "username" error message "This field is required."
    *    I see "email" error message "This field is required."
    *    I see "password" error message "This field is required."
    *    I see "name" error message "This field is required."
    *    I see "agreedToPrivacyPolicy" error message "- Must check!"