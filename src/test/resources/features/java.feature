@java
Feature: Java feature

  @java1:
  Scenario: Dividing int by double
    Given I am dividing 20 by 5.0

  @java2:
  Scenario: The sign of a non-decimal number
    And I print if number "3" is positive
    And I print if number "+35" is positive
    And I print if number "-9223372036854775808" is positive
    And I print if number "0" is positive

  @java3:
  Scenario: Day of the week by its ordinal number
    And I print "7" day of week

  @java4:
  Scenario: Printing and checking arrays
    Then print all numbers from zero up to positive 5
    Then print all numbers from zero to -7
    Then print all integer array {1,345,   567}
    Then all even numbers from integer array {1,345,   567,  -3,0,-2,18}
    Then check if array {} is empty
    Then check if array {3,8,2} contains element 7
    Then check if array {3,8,2} contains element 8
    Then check if array {3,8,2} contains element other than present in {4,8}

  @java5:
  Scenario: Checking sorting methods
    Then array {3,2,1} sorted by method "sortIfOdd4" should match {1,2,3}
    Then array {0,1,67,-1,3,8,10,38,5,1,0,13} sorted by method "sortIfOdd4" should match {0, -1, 1, 1, 3, 8, 10, 38, 5, 13, 0, 67}

  @java6:
  Scenario: Joining arrays alternating coding challenge
    Then array {1,5,8,3,6} and array {8,3,6} are joined together alternating into {1,8,5,3,8,6,3,6}
    Then list {5,34,0} and list {0,3,0,-12,-4} are joined together alternating into {5,0,34,3,0,0,-12,-4}
    Then array {} and array {8,3,6} are joined together alternating into {8,3,6}
    Then array {1,2,3,4} and array {} are joined together alternating into {1,2,3,4}
    Then array {} and array {} are joined together alternating into {}
    Then array {1,2,3,4} and array {"a","b","c"} are joined together alternating into {"1","a","2","b","3","c","4"}
    Then array {1,2,3,4} and array {""} are joined together alternating into {"1","","2","3","4"}

  @java7:
  Scenario: FizzBuzz coding challenge
      Then do FizzBuzz printing by method 1 for number 10000
      Then do FizzBuzz printing by method 2 for number 10000
      Then do FizzBuzz printing by method 3 for number 10000
      Then do FizzBuzz printing by method 4 for number 10000
      Then do FizzBuzz printing by method 1 for number 0
      Then do FizzBuzz printing by method 1 for number -1
      Then do FizzBuzz printing by method 1 for number 1
      Then do FizzBuzz printing by method 1 for number 2

  @java8:
  Scenario: Reverse string coding challenge
    Then reverse string "a"
    Then reverse string "Z"
    Then reverse string "0123456789"
    Then reverse string "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"
    Then reverse string "a\b+c"
    Then reverse string "a\\b+c"
    Then reverse string "\t\b\n\r\f\'\"\\"
    Then reverse string "😂😃🧘️🌍🍞🚗"
    Then reverse string "🧘️"
    Then reverse string "🍞"
    Then reverse string "qwerty"
    Then reverse string "qwe1rty"
    Then reverse string "🍞"
    # with invisible Unicode Character 'VARIATION SELECTOR-16' (U+FE0F) (cursor stays still when pressing arrow button)
    Then reverse string "🧘️"
    Then reverse string "🧘️" via StringBuffer
    Then reverse string "a\b+c" unescaped
    Then reverse string "\t\b\n\r\f\'\"\\" unescaped
    Then reverse string "\uD83E\uDDD8" unescaped

    Then reverse string "\""
    Then reverse string "\"" via StringBuffer
    Then reverse string "\"" unescaped
    Then reverse common string "\""

    Then reverse string "\'"
    Then reverse string "\'" via StringBuffer
    Then reverse string "\'" unescaped
    Then reverse common string "\'"

    Then reverse string "😂, 😃, 🧘️, 🌍, 🍞, 🚗"
    Then reverse common string "😂, 😃, 🧘️, 🌍, 🍞, 🚗"

    Then reverse string "%s"
    Then reverse string "! #$%&*+-/=?^_`{}~',.~!@#$%^&*()_+=-`,.<>?/:\";'{}\|]["
    Then reverse string "          "
    Then reverse string ""
    Then reverse string "überwintern"
    Then reverse string "\u0048\u0047\u0046\u0045"
    Then reverse string "\\u0048\\u0047\\u0046\\u0045"
    Then reverse string "\u2640" unescaped
    Then reverse string "\u0048\u0047\u0046\u0045" unescaped

    # Woman Golfing: Light Skin Tone
    # ZWJ sequence combining 🏌️ Person Golfing, 🏻 Light Skin Tone, ‍ Zero Width Joiner and ♀️ Female Sign.
    Then reverse string "🏌🏻‍♀"

  @java9:
  Scenario: Reverse words in sentence coding challenge
      Then reverse words in sentence "Lorem ipsum dolor sit amet, consectetur 123 adipiscing   elit."
      Then reverse words in sentence "Have\t a nice day! 😃\n"
      Then reverse words in sentence "\u0048\u0047\u0046\u0045"

  @java10
  Scenario: Swap elements of the array
      Then swaps two elements of array {5,2,9,7,3} in positions 3 and 5
      Then swaps two elements of array {5,2,9,7,3} in positions 0 and 5
      Then swaps two elements of array {5,2,9,7,3} in positions 3 and 6
      Then swaps two elements of array {5,2,9,7,3} in positions 2 and 2
      Then swaps two elements of array {5,2,9,7,3} in positions -1 and 5

  @java11
  Scenario: Largest element in array
    Then largest element in an array {3, -1, 0, 374}
    Then largest element in an array {-2147483648}
    Then largest element in an array {-2147483648, 2147483647}
    Then largest element in an array {0, 0, 0}
    Then largest element in an array {344, 1, 85}
    Then largest element in an array {-284, -4}
    Then largest element in an array {}

  @java12
  Scenario: Find if array contains duplicates and find them
    Then run test cases for all implementations of containsDuplicates method
    Then run test cases for all implementations of findDuplicates method

  @java13
  Scenario: Determine if word is a palindrome
    Then run test cases for isWordPalindrome method

  @java14
  Scenario: Finds 2 max numbers in array
    Then run test cases for all implementations of twoLargest method

  @java15
  Scenario: Find if any two elements of an array result in sum
    Then run test cases for twoResultInSum method