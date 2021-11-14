@java
  Feature: Java feature

    @java1
    Scenario: Hello World
      Given I hello world
      And I say "Hello Beautiful!"


      @java2
      Scenario: My information
        Given  Hi, my name is
        Then I type "Varvara", "Love", "Blue"

    @java3
    Scenario: Two variables
    Given I perform actions with "USA" and "New York"

    @java4
    Scenario: Numeric types
      Given I have two types of number 10 and 10.5


    @java5
    Scenario: Variable Evaluation
      Given Let's do some math with 10 and 5


    @java6
    Scenario: Numbers exercises
      Given Exercises between 25 and 3
      And I print if number "35" is positive
      And I print 7 day of week



    @java7
    Scenario: Numbers amd array exercises
      Given List of all positive numbers
      Then List of positive and negative numbers
      And Write a function that prints all integer array
      And Prints all even numbers from integer array
      Then Check if array is empty
      And Check if array contains another element



