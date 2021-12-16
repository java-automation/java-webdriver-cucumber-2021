@java
  Feature: Java feature

    @java01
    Scenario: Hello World
      Given I write hello world
      And I say "I say Hello World!"
      When I say "Hello again!"
      Then I say "I say Hello World one more time!!"

    @java03
      Scenario: Declare variables
      Given I declare String variables

    @java04
    Scenario: Actions with var
      Given I perform actions with "my var" and "my Var"

    @java05
    Scenario: Actions with numbers
      Given I perform actions with numbers 2 and 1
#      Then I perform actions with numbers 2 and 1.5 //  it's not working. Cucumber issue?
      And I perform actions with float numbers 2 and 1.00
      Given I perform actions with numbers 10 and 3
      Given I perform actions with numbers 100 and 300
      Given I perform actions with numbers 10 and 10

    @java06
    Scenario: Actions with conditions
      Given I compare "string1" and "string2" strings
      And I compare "same" and "same" strings
      Then I compare "Same" and "same" strings

    @java07
    Scenario: Actions with conditions - url test
      Given I print url for "sample" page
      And I print url for "google" page
      And I print url for "Google" page
      Then I print url for "yandex" page

    @java08
    Scenario: Actions with numbers for day 05
      Given I compare numbers 10 and 10

    @java09
    Scenario: Actions with loops for day 05
      Given I work with Loops

    @java10
    Scenario: Actions with numbers and conditions
      Given I print if number "35" is positive
      And I print if number "-1" is positive
     Then I print if number "0" is positive
#    Expected Output (based on number entered):
#    Number is positive (for 35) / Number is negative (for numbers less than 0)
      And I print "7" th day of week
      Then I print one more "7" th day of week
      And I print 7 th day of week with Array
#   Expected Output:
#    Monday (for 1) / Tuesday / Wednesday / Thursday / Friday / Saturday / Sunday (for 7)

    @java11
    Scenario: Reverse string
      Given I reverse string "qweqwe"
      Then I reverse

#   "Write a program that prints the numbers from 1 to 100.
#   But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
#   For numbers which are multiples of both three and five print “FizzBuzz”."
    @java12
    Scenario: FizzBuzz
      Given I print FizzBuzz

    @java13
    Scenario: I work with Arrays
      Given I work with Array

    @java14
    Scenario: I work with Maps
      Given I work with Maps

    @javachallenges
    Scenario: Java challanges
      Given I solve java challanges

    @javachallenges2
    Scenario: Java challanges day 02
      Given I solve java challanges for day two

    @javachallenges3
    Scenario: Java challanges day 03
      Given I solve java challanges for day three

    @javachallenges4
    Scenario: Homework day 6
      Given I solve java challenges for the day six homework

    @javachallenges7
    Scenario: Homework day 7 (swap, fizzbazz, largerst el, reverse)
      Given I solve java challenges for the day seven homework

    @javachallenges9
    Scenario: Class 8 and 9 coding challenges (sorting, contains element, reverse without extra var)
      Given I solve java challenges for the day nine

    @javachallenges10
#    TODO - doesn't work
    Scenario: Additional class coding challenges (reverse word in a sentence)
      Given I solve java challenges for the additional day nine

    @javachallenges11
    Scenario: Additional class coding challenges (
      Given I solve java challenges for the additional day ten