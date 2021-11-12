@java
Feature: Java feature

  @java0:
  Scenario: Dividing int by double
    Given I am dividing 20 by 5.0

  @java1:
  Scenario: Printing URL by page name
    Given I print URL for page "google"
    And I print URL for page "yahoo"
    And I print URL for page "test"

  @java2:
  Scenario: Go to and print details
    Given I go to "quote" page
    And I print page details

  @java3:
  Scenario: Using navigation methods
    Given I go to "google" page
    And I print page details
    And I go to "quote" page
    And I print page details
    And I go back and forward, then refresh the page

  @java4:
  Scenario: Changing page resolution
    Given I go to "quote" page
    And I change resolution to "phone"
    And I wait
    And I change resolution to "desktop"
    And I wait

  @java5:
  Scenario: Correct saving of entered required data
    Given I go to "quote" page
    When I fill out required fields
    And I submit the form
    And I wait
    Then I verify that submitted fields saved correctly

  @java6:
  Scenario: Correct saving of entered optional data
    Given I go to "quote" page
    When I fill out required fields
    And I fill out optional fields

  @java7:
  Scenario: Email field behavior
    Given I go to "quote" page
    When I verify email field behavior

  @java8:
  Scenario: The sign of a non-decimal number
    And I print if number "3" is positive
    And I print if number "+35" is positive
    And I print if number "-9223372036854775808" is positive
    And I print if number "0" is positive

  @java9:
  Scenario: Day of the week by its ordinal number
    And I print "7" day of week






