@java_oop
Feature: Working with classes in Java

  @java_oop1
    Scenario: Starting a family
      Given I have a home
      When I add "Marina"
      And I add cat "Marshmallow"
      And I add cat "Snowflake"
      And I add dog "Toby"
      Then there are 4 family members
      And I print all home lists of members

  @java_oop2
    Scenario: Working with classes
      Given I work with animal classes