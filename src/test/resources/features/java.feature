@java
  Feature: Java feature

    @java1
    Scenario: Hello World
      Given I hello world
      Given I perform actions with "my var" and "my VAR"
      And I perform actions with "outside" and "side"
      When I divide two integer variables 5 by 3
      And I divide integer by float: 5 by 3.6
      And I perform different arithmetic action with two integer variable 10 and 3
      And I check integer number 5
      And I check integer number 0
      And I check integer number -6
      And I compare "string1" and "string2" strings
      And I compare "abc" and "abc" strings
      And I print url for "site" page
      And I print url for "sample" page

      
