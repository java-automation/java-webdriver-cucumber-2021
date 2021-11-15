@newjava
Feature: New Java tests

  @newjava1
  Scenario: Hello world printing
    Given I printing hello world
    And I type "Hi,there"
    And I type "Congrats"
    Then I type "Homework with strings"
    And I type "my var" and "MY VAR"

  @newjava2
   Scenario: Executing homework with numbers
    Given I type "Homework execution with numbers:"
    And I do some math with 20 and 5
    And I do some math with int 20 and float 3.4
    
  @newjava3
  Scenario: Practice with if/switch statements
    Given I type "My homework #5"
    And I print number 35 if positive
    And I print day 7 of the week
    And I implement print day 7 of the week using switch method
    And I implement print day 3 of the week with array

  @newjava4
  Scenario: Practice with functions
    Given I type "My Homework #6"
    And I implement method to print numbers from zero to 5
    And I implement method that prints negative numbers -1
    And I implement method that prints positive and negative numbers 0
    And I implement method to print all int array
    And I implement method that prints even numbers from the int array
    And I implement method that checks if array is empty
    And I implement method that checks if array contains another element


