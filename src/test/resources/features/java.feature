@java
  Feature: Java feature

    @java1
    Scenario: Hello World
      Given I write in Java
      And I go wild "Wooo-hooo"

    @java2
    Scenario: String Exercises
      Given They say "Tell us about yourself"
      When I say "I'm Alice" "Liddell"  "and my favorite color is green"
      And They say "How nice! Welcome to Wonderland, Alice!"
      And They say "Would you like a Cucumber? GIVEN it's green."
      Then I say "Cucumber sandwich" "would be nice THEN"  ""
      And They say "Child! You obviously suffer from BDD!..or is it ADD?"

    @java3
    Scenario: Methods Exercises
      Given Kitty likes to play with "Strings"
      When "Cheshire Cat" is "cheshire cat"
      And "caterpillar" is "caterpillar"
      And "White Rabbit" is "White"
      Then Humpty Dumpty fell off the wall

    @java4
    Scenario: Numbers exercises
      Given I play with numbers

    @java5
    Scenario: Boolean exercises
      Given I check boolean data type
      When I try it with string "orange"
      # green, pink, orange, brown

    @java6
    Scenario: Conditions Exercise
      Given I compare "March Hare" and "March Hare" strings
      And I compare "March Hare" and "Hare" strings

    @java7
    Scenario: Conditions URL
      Given I print url for "Quote"
      # google, quote, Quote, AOL

#    @java8
#    Scenario: Regex
#      Given I work with regex and "la"

#https://www.meetcode.com
#https://www.hackerrank.com


    # Day 5 Homework
#    2) Do exercises from Day 5 slides
#    3) Try creating below steps with conditions (in java.feature)
#      And I print if number "35" is positive
#    Expected Output (based on number entered):
#    Number is positive (for 35) / Number is negative (for numbers less than 0)
#      And I print "7" th day of week
#    Expected Output:
#    Monday (for 1) / Tuesday / Wednesday / Thursday / Friday / Saturday / Sunday (for 7)

   @java9
   Scenario: Numbers
     Given I check if number 35 is positive
     # if...else if
     And I print 6 day of the week
     #switch
     And I print 2 day of the week with enhanced switch
     # enhanced switch
     And I print 1 day of the week using array
     # array and if..else
     And I check if number 31 is even or odd

