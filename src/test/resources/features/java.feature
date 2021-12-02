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

  @java9_1
  Scenario: Check if method gets a null array of primitive type
    Given We provide null not declared array to method

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

  @java16
  Scenario: Print array of random elements from zero to 10000
    Given Print array with 15 of random elements from zero to 10000
    Then Print array with 5 of random elements from zero to 100

  @java17
  Scenario: Define a HashMap variable called myInfo which will
  have the following keys:
  "firstName"
  "lastName"
  "hometown"
  "favoriteFood"
    Then Define a HashMap variable called myInfo and print some of those values in the console.

  @java18
  Scenario: odd number - ascending order; even number - stayed in their place
  input: {5,3,2,8,4,1}
  output: {1,3,2,8,4,5}
    Given I sort array even stayed in place, odd - in ascending order
    Then I sort array with one element in order where even stayed in place, odd - in ascending order
    Then I sort array with length 10 and range 999 in order where even stayed in place, odd - in ascending order


  @java19
  Scenario: I rearrange numbers in ascending order
    And I rearrange numbers in ascending order

  @java20
  Scenario: Write a function that combines two arrays (lists) by alternating taking elements;
    Given I create two array and combine them by alternating taking elements;

  @java21 #Interview coding task 3-8
  #Write a function, accepts integer argument
  #It should print all the numbers up to arguments:
  #if Number %3==0 it should print Fizz instead of number
  #if Number %5==0 it should print Buzz instead of number
  #if (Number %3==0) && (Number %5 ==0) print FizzBuzz
  Scenario: Write a function that accepts integer argument and print Fizz, if number divided by 3,
  Buzz - if number divided by 5, and FizzBuzz - if number divided for 3 and 5; otherwise - print numbers up to the argument;
    Given I print all numbers up to the argument 30

  @java21_1 #FizzBuzz
  Scenario: FizzBuzz game
    Given I play to FizzBuzz to 46

  @java22 #Given array{5,2,9,7,3}. Write a function that swaps two array elements 3rd and 5th.
  Scenario: I swap two 3rd and 5th elements in array {5,2,9,7,3}
    Given I swap 3 and 5 elements in array

  @java23
  Scenario: I reverse String
    Given I reverse "string"

  @java24
  Scenario: I reverse words in sentence
   # Given I reverse words in sentence "NewYork"
    And I reverse words in sentence "I love NewYork!"
    And I reverse words in sentence "I love NewYork! "
    And I reverse words in sentence "I  love NewYork!"

  @java25
  Scenario: I create array from String with space delimiter 1
    Given I has "I love NewYork!" and create Array with " " as delimiter

  @java26
  Scenario: I create array from String with space delimiter
    Given I has "I love NewYork!" and create Array with " " as delimiter and reverse words in it
    And I has "I  love NewYork!" and create Array with " " as delimiter and reverse words in it














