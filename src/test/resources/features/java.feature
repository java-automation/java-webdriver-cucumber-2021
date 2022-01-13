@java
  Feature: Java feature

    @TestCase1
    Scenario: Validate Date Picker functionality
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@id='dateOfBirth']"
      Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
#   Dialog: verify that upon clicking dialog appears
      When I click on element with xpath "//td[@data-handler='selectDay']/a[text()='16']"
      Then element with xpath "//b[@name='dateOfBirth'][text()='01/16/2022']" should be present
#   Date Composer: verify that chosen date is formed out correctly if day clicked in popup
      When I click on element with xpath "//input[@id='dateOfBirth']"
      And I wait for 2 sec
      And element with xpath "//div[@id='ui-datepicker-div']" should be displayed
      And I click on element with xpath "//select[contains(@class,'datepicker-month')]//option[@value='3']"
      And I click on element with xpath "//select[contains(@class,'datepicker-year')]//option[@value='2000']"
      And I click on element with xpath "//td[@data-handler='selectDay']/a[text()='11']"
      Then element with xpath "//b[@name='dateOfBirth'][text()='04/11/2000']" should be present
#   Bonus for Date Picker: validate that month/year selectors work as expected and back/forward buttons change month
      When I click on element with xpath "//input[@id='dateOfBirth']"
      And I wait for 2 sec
      And element with xpath "//div[@id='ui-datepicker-div']" should be displayed
      And element with xpath "//select[contains(@class,'datepicker-month')]//option[@value='3']" should have attribute "selected" as "true"
      When I click on element with xpath "//a[@data-handler='prev']"
      Then element with xpath "//select[contains(@class,'datepicker-month')]//option[@value='2']" should have attribute "selected" as "true"
      When I click on element with xpath "//a[@data-handler='next']"
      Then element with xpath "//select[contains(@class,'datepicker-month')]//option[@value='3']" should have attribute "selected" as "true"
      When I click on element with xpath "//select[contains(@class,'datepicker-month')]"
      Then element with xpath "//select[contains(@class,'datepicker-month')]//option" should be displayed
      When I click on element with xpath "//select[contains(@class,'datepicker-year')]"
      Then element with xpath "//select[contains(@class,'datepicker-year')]//option" should be displayed

    @TestCase2
    Scenario: Declare variables, assign strings to them, and print them into console
      Given I print first name "Sam" and last name "Longmire" and favorite color "purple"

    @TestCase3
    Scenario: Print "Hi, my name is (first name) (last name), my favorite color is (favorite color)." to the console
      Given I print data with first name "" and last name "" and favorite color ""
      And I print data with first name "Sam" and last name "Murray" and favorite color "Yellow"

    @TestCase4
    Scenario: Calling different methods on String variables
      Given I get the length of the "Word" string
      And I get the "WoRd" in lower case
      And I get the "word" in upper case
      And I trim the "  word of mouth  "
      And I get the class of "word"
      And I verify if "" is empty

    @TestCase5
    Scenario: Create new custom step that would accept two variables
      Given I perform actions with "my var" and "my VAR"
      And I print those variables into console as they are
      And I print those variables uppercase into console
      And I print those variables length into console
      And I print result of exact comparison of those variables into console
      And I print result of exact comparison ignoring cases of those variables into console
      And I print result of partial comparison of those variables into console

    @TestCase6
    Scenario: Operations with integers
      Given I create two integers 1 and 2
      And I print the sum of the integers
      And I print the difference of the integers
      And I print the division of the integers
      And I print the product of the integers

    @TestCase7
    Scenario: Compare favorite and non-favorite colors
      Given I print the comparison of the colors my favorite color as "green" and my non-favorite color as "green"

    @TestCase8
    Scenario: Comparison of strings
      Given I compare "cat" and "dog" strings

    @TestCase9
    Scenario: Verify if number is positive
      Given I print if number 35 is positive
      And I print if number 0 is positive
      And I print if number -8 is positive

    @TestCase10
    Scenario: Verify day of the week
      Given I print "7" day of week
      And I print "1" day of week
      And I print "0" day of week
      And I print "9" day of week
      And I print "M" day of week

    @TestCase11
    Scenario: Fill all the fields on Quote form
      Given I open the page with url "https://skryabin.com/market/quote.html"
      And I fill in "Eric" in element "//input[@id='name']"
      And I click on element "//option[@value='USA']"
      And I fill in "906 Bates Brothers Road" in element "//*[@id='address']"
      And I click on element "//button[@id='thirdPartyButton']"
      And I accept alert window
      And I fill in "eckimsey" in element "//input[@name='username']"
      And I fill in "casianolga@gmail.com" in element "//input[@name='email']"
      And I fill in "testPass2021-11-10" in element "//input[@id='password']"
      And I fill in "testPass2021-11-10" in element "//input[@id='confirmPassword']"
      And I fill in "(563)929-6215" in element "//input[@name='phone']"
      And I fill in "11/10/2021" in element "//input[@id='dateOfBirth']"
      And I click on element "//input[@value='female']"
      And I click on element "//input[@name='allowedToContact']"
      And I click on element "//option[@value='Toyota']"
      And I switch to iframe "//*[@name='additionalInfo']"
      And I fill in "Susan" in element "//input[@id='contactPersonName']"
      And I fill in "(563)150-1008" in element "//input[@id='contactPersonPhone']"
      And I switch back from iframe
      And I click on element "//button[contains(text(),'Related documents')]"
      And I switch to previous window
      And I click on element "//a[contains(@href,'Documents.pdf')]"
      And I click on element "//a[@id='link']"
      And I navigate back
      And I upload file for element "//input[@id='attachment']"
      And I click on element "//input[@name='agreedToPrivacyPolicy']"
      And I click on element "//button[@id='formSubmit']"

     @TestCase12
     Scenario: Homework Day6
       Given I print all numbers from zero up to 5
       And I support also negative numbers like -4
       And I print all integer array
       And I print all integer array [-7, 0, 18, 101]
       And I print all even numbers from integer array [1, 14, 28, 9, 11, 6, 50, 77]
       And I check if array is empty
       And I check if array contains another element

     @TestCase13
     Scenario: Sort odd numbers in ascending order keeping even numbers on their places
       Given I sort all numbers in ascending order
       And I sort odd numbers in ASC keeping even ones at their places
       And I verify that even numbers kept their places

     @TestCase14
     Scenario: Print multiplication table up to n
       Given I print multiplication table up to 21

    @TestCase15
    Scenario: Combine two arrays by alternating the elements
      Given I combine two int arrays
      And I combine two string arrays
      And I combine two lists

    @TestCase16
    Scenario: Swap two variables values
      Given I swap two variables values "age" and "8" using a third variable
      And I swap two variables values 11 and 36 without a third variable

    @TestCase17
    Scenario: Swap two array elements – 3rd and 5th
      Given I swap elements from array [7, 42, 25, 78, 9, 11]

    @TestCase18
    Scenario: Print specific output on conditions
    "divisible by 3" if number is divisible by 3
    "divisible by 4" if element is divisible by 4
    "divisible by 3 and 4" if divisible by 3 and 4
      Given I print specific output on conditions having number 59840

    @TestCase19
    Scenario: Write a function to find the largest element in an array
      Given I find the larges element in array [34, 7, 12, 29, 41, 7, -2, 80]

    @TestCase20
    Scenario: Function accepts integer argument and prints all the numbers up to the argument
    BUT:
    if number is multiple of 3, it should print Fizz instead of number
    if number is multiple of 5, it should print Buzz instead of number
    if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
    Result for 20:
    1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz
      Given I provide integer 15 and print all the numbers up to it with conditions

    @TestCase21
    Scenario: Write a function that reverses string
      //ToDo: while loop with pointers idx, start from 0
      Given I reverse a string "Hello"

    @TestCase22
    Scenario: Write a function that reverses words in a sentence
      Given I reverse words in sentence "Hello World, what's up?"

    @TestCase23
    Scenario: Write a function that finds if array contains duplicates
      Given I find duplicates in array [34, 6, 14, 29, 41, 8, -7, 12]

    @TestCase24
    Scenario: Write a function that determines palindrome (worlds like mom, civic, anna)
      Given I check for palindrome word "taco cat"

    @TestCase25
    Scenario: Write a function that prints 2 max numbers in an array
      Given I print two max numbers in an array

    @TestCase26
    Scenario: Write a function that finds if any two elements of an array result in sum
      Given I found if two elements results in sum

    @TestCase27
    Scenario: Find if a number is a prime
    # a natural number greater than 1 that is not a product of two smaller natural numbers
      Given I find if 29 is a prime number

    @TestCase28
    Scenario: Find factorial of a number
    # (5! = 5 * 4 * 3 * 2 * 1)
      Given I calculate factorial of -7

    @TestCase29
    Scenario: Working with classes
      Given I work with class
      And I work with a new class
