@java
Feature: Basic Java experiments

  @java1
  Scenario: Name and Color
    Then Show the greeting when I'm "John" "Doe" and my favorite color is "yellow"

  @java2
  Scenario Template: String exercise
    Then I perform exercise on <stringOne> and <stringTwo>

    Examples:
      | stringOne  | stringTwo |
      | "my var"   | "my VAR"  |
      | "XXL XL L" | "L"       |
      | "Spear"    | "pear"    |

  @java3
  Scenario Template: Number exercise
    Then I perform exercise on <numberOne> and <numberTwo>

    Examples:
      | numberOne  | numberTwo |
      | 134        | 67        |
      | -10        | 3         |
      | 1001657    | 85462     |

  @java4
  Scenario: Boolean exercise
    Then Show the message when my favorite color is "yellow", but not "red"

  @java5
  Scenario Template: Conditions exercise
    Then Compare <stringOne> and <stringTwo>

    Examples:
      | stringOne    | stringTwo |
      | "apple"      | "apple"   |
      | "pear"       | "peach"   |
      | "plum"       | "plum"    |
      | "watermelon" | "melon"   |

  @java6
  Scenario Template: Print URL for a known website
    Then I print URL for <site> page

    Examples:
      | site             |
      | "Google"         |
      | "quote form"     |
      | "Portnov School" |
      | "unKnOwN"        |

  @java7
  Scenario: Is number positive?
    And I print if number "-5435" is positive

  @java8
  Scenario: Day of the week
    And I print day of the week that comes 15465 days after today and today is "Monday"

  @java9
  Scenario: Grocery list
    And I print my grocery list

  @java10
  Scenario: Personal info HashMap
    And I print my personal info

  @java11
  Scenario: Swap two variables
    And I swap two variables in different ways

  @java12
  Scenario: Swap two elements in array
    And I swap elements with positions 3 and 5 in array of integers
    | 5 | 2 | 9 | 7 | 3 |

  @java13
  Scenario: Divisibility exercises
    And I check if number 5 is divisible by 2 and 5

  @java14
  Scenario: Write a function that prints all numbers from 0 to n
    And I print all numbers from zero to -32

  @java15
  Scenario: Array exercises
    And I do my integer array exercises with number 0
    | 2 | 4 | 43543 | 34 | -2342 | 117799 | 0 | -94 |
    #|