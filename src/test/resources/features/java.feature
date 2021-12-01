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

  @javaDay7HomeWork
    Scenario: Working with hashmap
      Given I work with some hashmap

  @javaDay8HomeWork
    Scenario: Array sorting (only odd numbers will be sorted)
      Given I sort an array with even and odd "11,4,7,23,9,10,5,12, 34, 65,2"

  @javaDay9HomeWork
    Scenario: Combining two arrays in one
      Given I trying to combine array "1,2,a" with array "5,c,7,8"

  @javaDay11HomeWork
    Scenario: Some homework
#      Given I check divisibility 100 by two and five
#      And I check divisibility 31 by two and five
#
#      And I check divisibility 67 by 3 and 4
#      And I check divisibility 68 by 3 and 4
#      And I check divisibility 69 by 3 and 4
#
#      And I swap 3 and 5 elements in array "5,2,9,7,3"
#      And I swap 0 and 5 elements in array "5,2,9,7,3"
#      And I swap 3 and 5 elements in array "5,2,9,7"
#
#      And I search the largest element in an array "1,2,3,6,9,8,20,0,15"
#      And I search the largest element in an array "1,2,888,6,9,8,20,0,888"
#
#      And I print numbers from zero to 8
#      And I print numbers from zero to -6
#
#      And I check array "1,-56,3,4,5,88" for element 6
#      And I check array "1,-56,3,4,5,88" for element 5
#
#      And I print all numbers from 1 to 20 with check multiplying by 3 and 5
#      And I print all numbers from 1 to 20 with check multiplying by 0 and 5
#      And I print all numbers from -1 to 20 with check multiplying by 3 and 5
#      And I print all numbers from 1 to 0 with check multiplying by 3 and 5

      And I making string "some string" reverse

      And I reverse words in sentence "This is some sentence"
      And I reverse words in sentence "This is some,sentence."
      And I reverse words in sentence "This is  some   sentence"
      And I reverse words in sentence "This"