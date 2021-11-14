@java
  Feature: Java feature

    @java1
    Scenario: Hello Java //HW
      Given  Hello Java
      And  I say "Top Secret"
      And Top Secret "Vic" and "Z" and "...depends on my mood"

    @java2
    Scenario: Calling different methods
      Given String exercise "Methods Exercises"

    @java3
    Scenario: New custom step that would accept two variables
      Given I perform actions with "my var" and "my VAR"

    @java4
    Scenario: Numbers exercises
      Given I perform actions with digits "48" and "6"

    @java5
    Scenario:  Boolean exercises
      Given I check if these colors are equal "Red" and "White"

    @java6
    Scenario: Conditions Exercise
      Given I compare "string1" and "string2" strings

    @java7
    Scenario: Conditions Exercise sequel
      Given I print url for "sample" page
