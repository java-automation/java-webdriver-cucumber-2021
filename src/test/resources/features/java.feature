@java
Feature: Java feature

  @javaDay4HomeWork
  Scenario: Hello World
    Given I hello world
    And I say my name "Dmitry" "Odintsov" with my favorite color "red"
    And I perform actions with "my var" and "my VAR"
    And I perform actions with "my var" and "my"
    And I perform actions with "my var" and "my"

    And I divide an integer 100 by integer 3
    And I divide an integer 100 by float "3.3f"
    And I perform actions with 5 and 2023

    And I check for not favorite color is "Yellow"

    And I compare "string1" and "string1" strings

    And I print url for "Yahoo" page

  @javaDay5HomeWork
    Scenario: Work with ifs and switches
      Given I print if number "35" is positive
      And I print "4" th day of week

    Scenario: Working with getDriver()
      Given I go to "quote" page
      And I print page details

    Scenario: Working with browser navigation
      Given I go to "google" page
      And I print page details
      And I go to "quote" page
      And I print page details
      And I go back and forward, then refresh the page
      And I change resolution to "phone"
      And I wait for 2 sec
      And I change resolution to "desktop"

    Scenario: Fill out all required fields with Java
      Given I go to "quote" page
      When I fill out required fields
      And I submit the form
      And I wait for 2 sec

    Scenario: Verify email field behavior with Java
      Given I go to "quote" page
      When I fill out required fields
      When I verify email field behavior
      And I wait for 1 sec

    Scenario: Verify submitted fields with Java
      Given I go to "quote" page
      When I fill out required fields
      And I submit the form
      And I wait for element with xpath "//legend[@class='applicationResult']" to be present
      Then I verify that submitted fields saved correctly

    Scenario: Covering all fields on Quote page
      Given I go to "quote" page
      When I fill out required fields
      When I fill out optional fields
      And I submit the form
      Then I verify that submitted fields saved correctly
      And I verify all optional fields saved correctly

  @javaDay6HomeWork
    Scenario: Printing numbers from 0 to n
      Given I print numbers from zero to 8

    Scenario: Printing numbers form 0 to n including negative
      Given I print numbers from zero to -6

    Scenario: Printing integer array
      Given I print integer array "1,-55,3,4,5,88"

    Scenario: Printing even numbers from integer array
      Given I print even numbers from integer array "1,-56,3,4,5,88"

    Scenario: Checking array is empty
      Given I check array "1,-56,3,4,5,88" is empty
      And I check array "" is empty

    Scenario: Check array for containing element
      Given I check array "1,-56,3,4,5,88" for element 6

    Scenario: Working with hashmap
      Given I work with some hashmap