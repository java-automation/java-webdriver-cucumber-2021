@quote_oop
Feature: Quote page and page object pattern

  Background:
    Given I go to quote form page OOP

  @quote_oop1
  #valid entries when filling the form: "all"/"required"; "Monica Smith"/"John Doe"
  Scenario: Submit the form with specified field set and one of the preset profiles
    When  I fill out "required" fields with "John Doe" profile OOP
    *     I wait for 3 sec
    And   Submit the form OOP
    Then  I verify that submitted fields got saved correctly OOP
    *     I wait for 5 sec