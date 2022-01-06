@predefinedQuote
Feature: Smoke steps for the Quote Form

  Background:
    Given I go to "quote form" page

  @predefinedQuote1
  Scenario: Verify the quote page has a responsive UI
    When I resize window to 400 and 800
    * I wait for 1 sec
    Then element with xpath "//*[@id='location']" should not be displayed
    When I resize window to 1200 and 800
    * I wait for 1 sec
    Then element with xpath "//*[@id='location']" should be displayed

  @predefinedQuote2
  Scenario: Verify minimum length of the "Username" field
    When I type "a" into element with xpath "//input[@name='username']"
    * I click on element with xpath "//*[@id='formSubmit']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='username-error']" should be displayed
    * element with xpath "//*[@id='username-error']" should contain text "2 char"
    When I type "b" into element with xpath "//input[@name='username']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='username-error']" should not be displayed

  @predefinedQuote3
  Scenario: Verify the set of required fields ("Username", "Email", "Password", "Name", Privacy Policy checkbox)
    * I click on element with xpath "//*[@id='formSubmit']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='username-error']" should be displayed
    * element with xpath "//*[@id='username-error']" should contain text "required"
    * element with xpath "//*[@id='email-error']" should be displayed
    * element with xpath "//*[@id='email-error']" should contain text "required"
    * element with xpath "//*[@id='password-error']" should be displayed
    * element with xpath "//*[@id='password-error']" should contain text "required"
    * element with xpath "//*[@id='name-error']" should be displayed
    * element with xpath "//*[@id='name-error']" should contain text "required"
    * element with xpath "//*[@id='agreedToPrivacyPolicy-error']" should be displayed

  @predefinedQuote4
  Scenario: Verify "Email" field accepts basic valid email a@b (Happy Path)
    When I type "a@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be present
  
  @predefinedQuote5
  Scenario: Verify "Email" field clears dynamic error messages correctly
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "required"
    When I type "a@b" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be displayed
    When I type "." into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    When I type "c" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be displayed
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be displayed

  @predefinedQuote6
  Scenario: Verify "Email" field requires one and only one @ symbol with non-empty local/domain parts
    When I type "abc" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    When I type "@" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    When I type "d@e" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    And I clear element with xpath "//input[@name='email']"
    When I type "@ab" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    And I clear element with xpath "//input[@name='email']"
    When I type "a@@b" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

    #technically should go one by one
  @predefinedQuote7
  Scenario: Verify "Email" field accepts printable characters !#$%&'*+-/=?^_`{|}~ in the local part
    When I type "!#$%&'*+-/=?^_`{|}~@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be present

  @predefinedQuote8
  Scenario: Verify "Email" field accepts dot . in the local part as long as its not fist, last or consecutive use
    When I type "a.b@c" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be present
    And I clear element with xpath "//input[@name='email']"
    When I type ".b@c" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    And I clear element with xpath "//input[@name='email']"
    When I type "a.@c" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    And I clear element with xpath "//input[@name='email']"
    When I type "a..b@c" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefinedQuote9
  Scenario: Verify "Email" field accepts dot . in the domain part as long as its not fist, last or consecutive use
    When I type "a@b.c" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be present
    And I clear element with xpath "//input[@name='email']"
    When I type "a@.b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    And I clear element with xpath "//input[@name='email']"
    When I type "a@b." into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    And I clear element with xpath "//input[@name='email']"
    When I type "a@b..c" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefinedQuote10
  Scenario: Verify "Email" field does not accept quoted " " local part
    When I type "\"a\"@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefinedQuote11
  Scenario: Verify "Email" field accepts hyphen in the domain part, as long as its not first or last
    When I type "a@b-" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    When I type "-c" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be displayed
    And I clear element with xpath "//input[@name='email']"
    When I type "a@-b" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefinedQuote12
  Scenario: Verify "Email" field does not allow IP addresses in the domain part
    When I type "a@[1.1.1.1]" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"
    And I clear element with xpath "//input[@name='email']"
    When I type "a@[IPv6:2001:1:2:3:4:5:6:7]" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefinedQuote13
  Scenario: Verify "Email" field does not allow local part longer than 64 octets
    When I type "1234567890123456789012345678901234567890123456789012345678901234a@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefinedQuote14
  Scenario: Verify "Email" field does not allow labels longer than 63 octets in the domain part
    When I type "a@123456789012345678901234567890123456789012345678901234567890123b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefinedQuote15
  Scenario: Verify "Password"/"Confirm Password" fields behavior
    * I wait for 1 sec
    Then element with xpath "//*[@id='confirmPassword']" should be disabled
    When I type "a" into element with xpath "//input[@id='password']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='confirmPassword']" should be enabled
    When I click on element using JavaScript with xpath "//*[@id='formSubmit']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='password-error']" should be displayed
    * element with xpath "//*[@id='password-error']" should contain text "5 char"
    * element with xpath "//*[@id='confirmPassword-error']" should be displayed
    * element with xpath "//*[@id='confirmPassword-error']" should contain text "required"
    When I type "a" into element with xpath "//input[@id='confirmPassword']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='confirmPassword-error']" should be displayed
    * element with xpath "//*[@id='confirmPassword-error']" should contain text "5 char"
    When I type "bcde" into element with xpath "//input[@id='password']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='password-error']" should not be displayed
    When I type "bcdf" into element with xpath "//input[@id='confirmPassword']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='confirmPassword-error']" should be displayed
    * element with xpath "//*[@id='confirmPassword-error']" should contain text "match"
    * I clear element with xpath "//input[@id='confirmPassword']"
    When I type "abcde" into element with xpath "//input[@id='confirmPassword']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='confirmPassword-error']" should not be displayed

  @predefinedQuote16
  Scenario: Verify "Name" field with popup modal dialog behavior
    When I click on element with xpath "//*[@id='name']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='nameDialog']" should be displayed
    When I type "Dmitry" into element with xpath "//*[@id='firstName']"
    * I type "A" into element with xpath "//*[@id='middleName']"
    * I type "Igumnov" into element with xpath "//*[@id='lastName']"
    * I wait for 1 sec
    Then I click on element with xpath "//*[@id='nameDialog']/..//*[text()='Save']/.."
    * I wait for 1 sec
    * element with xpath "//*[@id='name']" should have attribute "value" as "Dmitry A Igumnov"
    When I click on element with xpath "//*[@id='name']"
    * I type "Someone" into element with xpath "//*[@id='firstName']"
    * I type "Else\'s" into element with xpath "//*[@id='middleName']"
    * I type "Name" into element with xpath "//*[@id='lastName']"
    * I wait for 1 sec
    Then I click on element with xpath "//*[@id='nameDialog']/..//*[text()='Cancel']/.."
    * I wait for 1 sec
    * element with xpath "//*[@id='name']" should have attribute "value" as "Dmitry A Igumnov"

  @predefinedQuote17
  Scenario: Verify "I have read and accept Privacy Policy" checkbox behavior
    When I click on element with xpath "//*[@id='formSubmit']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefinedQuote18
  Scenario: Verify minimal form submission (Happy Path)
    When I type "abc" into element with xpath "//input[@name='username']"
    * I type "a@b" into element with xpath "//input[@name='email']"
    * I type "abcde" into element with xpath "//input[@name='password']"
    * I type "abcde" into element with xpath "//input[@name='confirmPassword']"
    * I type "a b c" into element with xpath "//input[@name='name']"
    * I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    * I wait for 5 sec
    * I click on element with xpath "//*[@id='formSubmit']"
    * I wait for 5 sec
    Then element with xpath "//*[@id='quotePageResult']//*[@name='username']" should have text as "abc"
    * element with xpath "//*[@id='quotePageResult']//*[@name='email']" should have text as "a@b"
    * element with xpath "//*[@id='quotePageResult']//*[@name='password']" should have text as "[entered]"
    * element with xpath "//*[@id='quotePageResult']//*[@name='name']" should have text as "a b c"
    * element with xpath "//*[@id='quotePageResult']//*[@name='agreedToPrivacyPolicy']" should have text as "true"