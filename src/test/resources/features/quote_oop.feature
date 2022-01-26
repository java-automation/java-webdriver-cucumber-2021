@quote_oop
Feature: Quote page and page object pattern

  Background:
    Given I go to "quote form" page OOP

  @quote_oop1
  Scenario Outline: Submit the form with specified field set and one of the preset profiles
    When I fill out "<fields>" fields with "<profile>" profile OOP
    * I wait for <sec> sec
    * I submit the form OOP
    Then I verify that submitted fields got saved correctly OOP
    * I wait for <sec> sec

    Examples:
      | fields   | profile      | sec |
      | all      | Monica Smith | 3   |
      | required | John Doe     | 2   |

  @quote_oop2
  Scenario: Required fields error messages
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

  @quote_oop3
  Scenario: Username minimal length error message
    When I fill out "username" field with "a"
    *    I submit the form OOP
    Then I see "username" error message "Please enter at least 2 characters."
    When I fill out "username" field with "ab"
    Then I don't see "username" error message

  @quote_oop4
  Scenario: Invalid email error message
    When I fill out "email" field with "john"
    *    I submit the form OOP
    Then I see "email" error message "Please enter a valid email address."
    When I fill out "email" field with "john@example.com"
    Then I don't see "email" error message

  @quote_oop5
  Scenario: Error messages for passwords - minimal length, match
    When I fill out "password" field with "1234"
    *    I submit the form OOP
    Then I see "password" error message "Please enter at least 5 characters."
    When I fill out "password" field with "12345"
    Then I don't see "password" error message
    When I fill out "confirmPassword" field with "1234"
    *    I submit the form OOP
    Then I see "confirmPassword" error message "Please enter at least 5 characters."
    When I fill out "confirmPassword" field with "54321"
    Then I see "confirmPassword" error message "Passwords do not match!"
    When I fill out "confirmPassword" field with "12345"
    Then I don't see "confirmPassword" error message

  @quote_oop6
  Scenario: Name modal dialog filling verification
    When I fill out name field with first name "John" and last name "Doe"
    Then I verify "name" field value "John Doe"
    When I fill out name field with first name "John", middle name "Richard", last name "Doe"
    Then I verify "name" field value "John Richard Doe"