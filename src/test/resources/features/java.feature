@java
Feature: Java feature

  @java0
  Scenario: Hello World
    Given I hello world
    And I say "Aloha!"

  @java1_dialog:
  Scenario: Validate Date Picker functionality
  Dialog: verify that upon clicking dialog appears
  Date Composer: verify that chosen date is formed out
  correctly if day clicked in popup
    Given I open url "https://skryabin.com/market/quote.html"
    Then I wait for element with xpath "//input[@name='dateOfBirth']" to be present
    Then I click on element with xpath "//input[@name='dateOfBirth']"
    Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
    Then I click month "Jan" in Date Composer
    Then I click year 2000 in Date Composer
    Then I click day 25 in Date Composer
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "01/25/2000"

  @java1_bonus
  Scenario: Bonus for Date Picker:
  validate that month/year selectors work as expected and back/forward buttons change month
    Given I open url "https://skryabin.com/market/quote.html"
    Then I wait for element with xpath "//input[@name='dateOfBirth']" to be present
    Then I click on element with xpath "//input[@name='dateOfBirth']"
    Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
    #back/forward buttons change month
    Then I click back arrow button in Date Picker to change month
    Then I click forward arrow button in Date Picker to change month

  @java2
  Scenario: Create new custom step that would accept two variables
  1) Print those variables into console as they are
  2) Print those variables uppercase into console
  3) Print those variables length into console
  4) Print result of exact comparison of those variables into console
  5) Print result of exact comparison ignoring cases of those variables into console
  6) Print result of partial comparison of those variables into console – if first
  variable contains second
  Once complete, write few steps with different variables.
    Given I perform actions with "my var" and "my VAR"
    Given I perform actions with "Star spangled Banner" and "Star"

  @java3
  Scenario: Try if/else steps:
  Expected Output :
  Number is positive / Number is negative
    And I print number "35"
    And I print number "-35"
    And I print number "0"

  @java4
  Scenario:I print "7" day of week
 # Expected Output :
 # Monday / Tuesday / Wednesday / Thursday / Friday / Saturday / Sunday
    And I print "7" day of week
    And I print "3" day of week

  @java5
  Scenario: Write a function that prints all numbers from 0 up to n
    Given I write all number from 0 to 13

  @java6
  Scenario: Write a function that supports also negative numbers
    Given I write all number from -13 to 13

  @java7
  Scenario: Write a function that prints all integer array
    Given I print integer array with length 10

  @java8
  Scenario:Write a function that prints all even numbers from integer array
    Given I print all even numbers from integer array with length 10

  @java9
  Scenario:Write a function that checks if array is empty
    Given I check if array is empty

  @java10
  Scenario:Write a function that checks if array contains another element
    Given I check if array with length 10 contains 37 element

  @java10_1
  Scenario: Write a function that checks if array contains another element
    Given I check if array with length 10 contains 37

  @java11
  Scenario: Write a function that prints all numbers from zero up to n
    Given I print all numbers from zero to 27

  @java12
  Scenario: Swap n-th and m-th elements in array
    Given I swap 2 element and 5 in integer array with length 7

  @java13
  Scenario: Bubble sort integer array
    Given I bubble sort integer array with length 7
    Given I bubble sort integer array with length 1
    Given I bubble sort integer array with length 20
    Given I bubble sort integer array with length 10

  @java14
  Scenario: I print list of towns starts from exact letter
    Given I print list of towns starts from "A" letter

  @java15
  Scenario: I print list of towns contains only n letters
    Given I print list of towns contains only 4 letters

    #print array in order













