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
      | "Portnov Campus" |
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
  Scenario: Personal info
    And I print my personal info

  @java11
  Scenario: Swap two variables
    And I swap variables -5 and 0 using different methods

  @java12
  Scenario: Swap two elements in array
    And I swap elements with positions 3 and 5 in array of integers
      | 5 | 2 | 9 | 7 | 3 |

  @java13
  Scenario: Divisibility
    And I check if number 276 is divisible by 3 and 4

  @java14
  Scenario: Write a function that prints all numbers from 0 to n
    And I print all numbers from zero to -5

  @java15
  #Empty list is ok, but assumes no empty cells (null) values
  Scenario: Array exercises
    And For given array I: print, print "even" numbers, check if it's empty, check if it contains number 7
      | 2 | 4 | 43543 | 34 | -2342 | 117799 | 0 | -94 | 7 | 11 |
      #|

  @java16
  #three methods: 2-element array, dynamic list (all elements), recursion
  Scenario: Fibonacci number
    And I print Fibonacci number for n = 40

  @java17
  Scenario: Palindrome word
    And I check if "kayak" is a palindrome

  @java18
  #valid input: selection/bubble/insertion/quick/merge/radix/all
  Scenario: Sort array of integers
    And I sort given array using "quick" sort
      #| 5 | 3 | 2 | 8 | 4 | 1 | -10 | 1001 | 0 | -523 |
      #| 1 | 0 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |
      #| 8 | 7 | 6 | 1 | 0 | 9 | 2 | 3 |
      | 10 | 6 | 259 | 8 | 4 | 100 | 34 | 435 | 33 | 867 | 101 | 63 | 239 | 218 | 48 | 102 | 345 | 431 | 33 | 87 |

  @java19
  #valid inputs: even/odd; bubble/selection
  Scenario: Sort numbers with a specified parity in a given array
    And I sort "even" numbers in a given array using "selection" sort
      #| 5 | 3 | 2 | 8 | 4 | 1 |
      | 5 | 3 | 2 | 8 | 4 | 1 | -10 | 1001 | 0 | -523 |
      #| 5 | 3 | 7 | 11 | 13 | 1 | -19 | 1001 | -333 | -587 |
      #| 10 | 6 | 2 | 8 | 4 | 100 | -10 | 1000 | 0 | -500 |
      #| 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |

  @java20
  Scenario: Mix two arrays
    And I mix given arrays as lists then as primitive arrays
      | array 1 | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  |
      | array 2 | -1 | -2 | -3 | -4 | -5 |    |    |    |    |

  @java21
  Scenario: Largest element in the array
    And I find largest element in given array
      | 10 | 6 | 259 | 8 | 4 | 100 | 34 | 435 | 33 | 867 | 101 | 63 | 239 | 218 | 48 | 102 | 345 | 431 | 33 | 87 |

  @java22
  Scenario: FizzBuzz
    And I provide FizzBuzz output for number 45

  @java23
  Scenario: Reverse a string
    And I reverse a given string "Abrakadabra"

  @java24
  Scenario: Reverse words in a sentence
    And I reverse word order in a given sentence " Hello, )&$%)&$%(#$   I'm do-ing   %$^&^^^   my java_5  exercise for 100500 hours !  "
    #"I live in Canada"

  @java25
  #valid input: 1-7
  Scenario: Print every N day of the week
    And I print every 1 day of the week

  @java26
  Scenario: Longest palindrome in a phrase
    And I find the longest palindrome in a given sentence "Madam, how about number 4343434: 'Eva, can I see bees in a cave?'. - 'Wow!'"

  @java27
  #duplicates are allowed, returns two max values even if they are identical
  Scenario: 2nd largest element
    And I find two largest elements in a given array
      | 5 | 3 | 2 | 8 | 4 | 1 |

  @java28
  Scenario: Check array for duplicates
    And I check if given array has duplicates, print if found.
      | 4 | 3 | 1 | 8 | 7 | 3 | 9 | 4 | 7 | 3 | 0 | 3 | 2 |

  @java29
  Scenario: Reverse digits in a number
    And I reverse digits in a number -54789

  @java30
  Scenario: List of digits
    And I print the list of digits for -73268

  @java31
  #throws error if less than two elements in array or no solution
  Scenario: Two sum
    And I print indexes of two numbers in array that add up to 7
      | 5 | 3 | -2 | 8 | 4 | 1 |

  @java32
  Scenario: Hello World in a frame
    And I print phrase "Hello World in a frame" in a frame

  @java33
  Scenario: Factorial
    And I find a factorial of 15

  @java34
  Scenario Outline: Prime number
    And I find if <number> is a prime number
    And I print all prime numbers up to <number>

    Examples:
      | number       |
      | 19876543     |

  @java35
  Scenario: Square root
    And I calculate square root for 2.5

  @java36
  Scenario: OOP exercise
    And I work with Animal classes

  @java37
  Scenario: Recursion exercise
    And I print numbers from 10 to one recursively
    And I find a sum on numbers in a given array recursively
      | 3 | 5 | 0 | 11 | 18 | 2 | -3 |