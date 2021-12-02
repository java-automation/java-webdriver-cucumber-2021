@java
Feature: Java experiments

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
      | numberOne | numberTwo |
      | 134       | 67        |
      | -10       | 3         |
      | 1001657   | 85462     |

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
  Scenario: Day of the week after N days
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
    And I check if number 276 is divisible by 3 and 4

  @java14
  Scenario: Write a function that prints all numbers from 0 to n
    And I print all numbers from zero to -5

  @java15
  Scenario: Array exercises
    And I do my integer array exercises with number 0
      | 2 | 4 | 43543 | 34 | -2342 | 117799 | 0 | -94 |
     #|

  @java16
  Scenario: Fibonacci number
    And I print Fibonacci number for n = 20

  @java17
  Scenario: Palindrome
    And I check if "kayak" is a palindrome word

  @java18
  Scenario: Do various array sorts
    And I sort given array using different methods
      #| 5 | 3 | 2 | 8 | 4 | 1 | -10 | 1001 | 0 | -523 |
      #| 1 | 0 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
      #| 8 | 7 | 6 | 1 | 0 | 9 | 2 |
      | 10 | 6 | 259 | 8 | 4 | 100 | 34 | 435 | 33 | 867 | 101 | 63 | 239 | 218 | 48 | 102 | 345 | 431 | 33 | 87 |

  @java19
  Scenario: Sort numbers with a specified parity in a given array
    And I sort "odd" numbers in a given array using Bubble Sort
      #| 5 | 3 | 2 | 8 | 4 | 1 |
      | 5 | 3 | 2 | 8 | 4 | 1 | -10 | 1001 | 0 | -523 |
      #| 5 | 3 | 7 | 11 | 13 | 1 | -19 | 1001 | -333 | -587 |
      #| 10 | 6 | 2 | 8 | 4 | 100 | -10 | 1000 | 0 | -500 |
      #| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |

  @java20
  Scenario: Mix two arrays using: a) primitive arrays b) lists
    And I mix given arrays
      | array 1 | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
      | array 2 | -1 | -2 | -3 | -4 | -5 |    |    |    |    |

  @java21
  Scenario: Find largest element in the array
    And I find largest element in given array
      | 10 | 6 | 259 | 8 | 4 | 100 | 34 | 435 | 33 | 867 | 101 | 63 | 239 | 218 | 48 | 102 | 345 | 431 | 33 | 87 |

  @java22
  Scenario: FizzBuzz problem for a number
    And I provide FizzBuzz output for number 45

  @java23
  Scenario: Reverse a string
    And I reverse a given string "Abrakadabra"

  @java24
  Scenario: Reverse words in a sentence
    And I reverse word order in a given sentence " Hello, )&$%)&$%(#$   I'm do-ing   %$^&^^^   my java_5  exercise for 100500 hours !  "

  @java25
  #Value range: 1-7 or error
  Scenario: Print every N day of the week
    And I print every 1 day of the week

  @java26
  Scenario: Longest palindrome in a phrase
    And I find the longest palindrome in a given sentence "Madam, how about number 4343434: 'Eva, can I see bees in a cave?'. - 'Wow!'"