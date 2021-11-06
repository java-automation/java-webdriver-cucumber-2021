@printing
  Feature: Printing results

    Two string variables and steps to colorfully printing results of applying built-in Java String methods to them.

    @printing1
    Scenario: Print as they are
      Given I perform actions with "myvar" and "myVAR"
      When I pick color "c52ca0" for printing
      Then print those variables to console as they are

    @printing2
    Scenario: Print uppercase
      Given I perform actions with "myvar" and "myVAR"
      When I pick color "f2a834" for printing
      Then print those variables uppercase into console

    @printing3
    Scenario: Print length
      Given I perform actions with "myvar" and "myVAR"
      When I pick color "c72d2d" for printing
      Then print those variables length into console

    @printing4
    Scenario: Print exact comparison
      Given I perform actions with "myvar" and "myVAR"
      When I pick color "2f4f6a" for printing
      Then print result of exact comparison of those variables into console

    @printing5
    Scenario: Print exact comparison ignoring case
      Given I perform actions with "myvar" and "myVAR"
      When I pick color "e6ae12" for printing
      Then print result of exact comparison ignoring cases of vars into console

    @printing6
    Scenario: Print lexicographical comparison when equal
      Given I perform actions with "november" and "november"
      When I pick color "152fb6" for printing
      Then print result of lexicographical comparison of vars into console

    @printing7
    Scenario: Print lexicographical comparison when second is less
      Given I perform actions with "November" and "novella"
      When I pick color "dc2b2b" for printing
      Then print result of lexicographical comparison of vars into console

    @printing8
    Scenario: Print lexicographical comparison when second is greater
      Given I perform actions with "November" and "Nova"
      When I pick color "b65015" for printing
      Then print result of lexicographical comparison of vars into console

    @printing9
    Scenario: Print partial comparison if first contains second
      Given I perform actions with "understand" and "stand"
      When I pick color "2b2bdc" for printing
      Then print result of partial comparison of those variables into console

    @printing10
    Scenario: Print partial comparison if first does not contain second
      Given I perform actions with "keyboard" and "stand"
      When I pick color "4a0cb4" for printing
      Then print result of partial comparison of those variables into console