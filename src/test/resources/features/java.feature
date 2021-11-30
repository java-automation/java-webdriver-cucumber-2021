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

  @java10:
  Scenario: Printing and checking arrays
    Then print all numbers from zero up to positive 5
    Then print all numbers from zero to -7
    Then print all integer array {1,345,   567}
    Then all even numbers from integer array {1,345,   567,  -3,0,-2,18}
    Then check if array {} is empty
    Then check if array {3,8,2} contains element 7
    Then check if array {3,8,2} contains element 8
    Then check if array {3,8,2} contains element other than present in {4,8}

  @java11:
  Scenario: Checking sorting methods
    Then array {3,2,1} sorted by method "sortIfOdd4" should match {1,2,3}
    Then array {0,1,67,-1,3,8,10,38,5,1,0,13} sorted by method "sortIfOdd4" should match {0, -1, 1, 1, 3, 8, 10, 38, 5, 13, 0, 67}

  @java13:
  Scenario: Joining arrays alternating
    Then array {1,5,8,3,6} and array {8,3,6} are joined together alternating into {1,8,5,3,8,6,3,6}
    Then list {5,34,0} and list {0,3,0,-12,-4} are joined together alternating into {5,0,34,3,0,0,-12,-4}
    Then array {1,2,3,4} and array {"a","b","c"} are joined together alternating into {"1","a","2","b","3","c","4"}







