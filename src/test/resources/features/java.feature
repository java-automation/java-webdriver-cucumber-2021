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
      Given Write a function that prints all numbers from 0 up to 13
      Then Write a function that prints negative -13 to positive 13
      And Write a function that prints all integer array
      And Prints all even numbers from integer array
      Then Check if array is empty
      And Check if array contains another element


    # @hashmap
      # Scenario: HashMap structure
      # Given Write myInfo table
      # Then Array sort num in ascending order for odd numbers
     #  And Function that combine two arrays
      # Then  Function that combine arrays with digits letters

      @hashmapHome
      Scenario: Hashmap practice
        Given State mapping
        Then Function that accept integer N and P
        Then Swap Arrays
        And Function the largest element in an array

        @FizzBuzz
        Scenario: Write function
          Given Write function for FizzBuzz


      #  @java8
       # Scenario Continue coding
         # Given Reverse String
         # Then Reverse words in a given string

    @codingChallenges
    Scenario: Coding challenges
      Given function that finds if array contains duplicates
      Then Write a function that finds two max numbers in the array
      And Write a function that determines palindrome



@cat

Scenario: Classes
  Given I work with classes




