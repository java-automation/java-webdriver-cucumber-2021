@java
  Feature: Java feature

    @java1
    Scenario: Hello World
      Given I hello World

    @java2
    Scenario: Actions with variables
      Given I perform actions with "my var" and "my Var"
      Given I print "Joy" and "Fun" into console
      Given I print "Thanksgiving" and "Christmas" uppercase into console
      Given I compare "summer" and "Summer"
      Given I compare "fall" and "FaLL" ignoring case
      Given I print "Java" length and "Cucumber" length into console
      Given I check if "notebook" contains "book"

    @java3
    Scenario: Numbers exercises
      Given I divide integer 10 by integer 2
      Given I divide integer 10 by float 2.5
      Given I compute the sum of integer 10 and integer 5
      Given I compute the difference of integer 10 and integer 5
      Given I compute the quotient of integer 10 and integer 5
      Given I compute the product of integer 10 and integer 5

    @java4
    Scenario: Boolean exercises
      Given I compare my color "green" with notFavoriteColor
      Given I compare my color "brown" with notFavoriteColor

    @java5
    Scenario: Conditions exercises
      And I print if number 35 is positive
      And I print if number -35 is positive
      And I print 7 day of week
      And I print 1 day of week




