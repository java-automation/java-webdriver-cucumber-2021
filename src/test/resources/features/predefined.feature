@predefined
Feature: Smoke steps

#  @predefined1
#  Scenario: Complete the search in Google
#    Given I open url "https://google.com"
#    Then I should see page title as "Google"
#    Then element with xpath "//input[@name='q']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
#    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
#    Then I wait for element with xpath "//*[@id='res']" to be present
#    Then element with xpath "//*[@id='res']" should contain text "Cucumber"
#
#  @predefined2
#  Scenario: Complete the search in Yahoo
#    Given I open url "https://yahoo.com"
#    Then I should see page title contains "Yahoo"
#    Then element with xpath "//*[@id='ybar-sbq']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@id='ybar-sbq']"
#    Then I click on element using JavaScript with xpath "//*[@id='ybar-search']"
#    Then I wait for element with xpath "//*[@id='web']" to be present
#    Then element with xpath "//*[@id='web']" should contain text "Cucumber"
#
#  @predefined3
#  Scenario: Complete the search in Bing
#    Given I open url "https://bing.com"
#    Then I should see page title as "Bing"
#    Then element with xpath "//*[@name='q']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@name='q']"
#    Then I click on element using JavaScript with xpath "//*[@id='search_icon']"
#    Then I wait for element with xpath "//*[@id='b_results']" to be present
#    Then element with xpath "//*[@id='b_results']" should contain text "Cucumber"
#
#  @predefined4
#  Scenario: Complete the search in Gibiru
#    Given I open url "https://gibiru.com"
#    Then I should see page title contains "Gibiru"
#    Then element with xpath "//*[@id='q']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@id='q']"
#    Then I click on element using JavaScript with xpath "//*[@id='button-addon2']"
#    Then I wait for element with xpath "//*[@class='gsc-resultsbox-visible']" to be present
#    Then I wait for element with xpath "//*[@class='gsc-resultsbox-visible']//*[contains(text(),'cucumber')]" to be present
#
#  @predefined5
#  Scenario: Complete the search in DuckDuckGo
#    Given I open url "https://duckduckgo.com"
#    Then I should see page title contains "DuckDuckGo"
#    Then element with xpath "//*[@id='search_form_input_homepage']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@id='search_form_input_homepage']"
#    Then I click on element using JavaScript with xpath "//*[@id='search_button_homepage']"
#    Then I wait for element with xpath "//*[@class='results--main']" to be present
#    Then element with xpath "//*[@class='results--main']" should contain text "Cucumber"
#
#  @predefined6
#  Scenario: Complete the search in Swisscows
#    Given I open url "https://swisscows.com"
#    Then I should see page title contains "Swisscows"
#    Then element with xpath "//*[@name='query']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@name='query']"
#    Then I click on element using JavaScript with xpath "//*[@class='search-submit']"
#    Then I wait for element with xpath "//*[@class='web-results']" to be present
#    Then element with xpath "//*[@class='web-results']" should contain text "Cucumber"
#
#  @predefined7
#  Scenario: Complete the search in Search Encrypt
#    Given I open url "https://searchencrypt.com"
#    Then I should see page title contains "Search Encrypt"
#    Then element with xpath "//*[@class='search-bar__search']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@class='search-bar__search']"
#    Then I click on element using JavaScript with xpath "//*[@class='search-bar__submit']"
#    Then I wait for element with xpath "//*[@class='serp__results container']" to be present
#    Then I wait for element with xpath "//*[@class='serp__results container']//*[contains(text(),'cucumber')]" to be present
#
#  @predefined8
#  Scenario: Complete the search in Startpage
#    Given I open url "https://startpage.com"
#    Then I should see page title contains "Startpage"
#    Then element with xpath "//*[@id='q']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@id='q']"
#    Then I click on element using JavaScript with xpath "//*[@class='search-form-home__button-desktop']"
#    Then I wait for element with xpath "//*[@class='show-results']" to be present
#    Then I wait for element with xpath "//*[@class='show-results']//*[contains(text(),'cucumber')]" to be present
#
#  @predefined9
#  Scenario: Complete the search in Yandex
#    Given I open url "https://yandex.com"
#    Then I should see page title as "Yandex"
#    Then element with xpath "//*[@id='text']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@id='text']"
#    Then I click on element using JavaScript with xpath "//*[@class='search2__button']/button"
#    Then I wait for element with xpath "//*[@id='search-result']" to be present
#    Then element with xpath "//*[@id='search-result']" should contain text "Cucumber"
#
#  @predefined10
#  Scenario: Complete the search in Boardreader
#    Given I open url "https://boardreader.com"
#    Then I should see page title contains "Boardreader"
#    Then element with xpath "//*[@id='title-query']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@id='title-query']"
#    Then I click on element using JavaScript with xpath "//*[@id='title-submit']"
#    Then I wait for element with xpath "//ul[@class='mdl-list']//li" to be present
#    Then element with xpath "//ul[@class='mdl-list']" should contain text "Cucumber"
#
#  @predefined11
#  Scenario: Complete the search in Ecosia
#    Given I open url "https://ecosia.org"
#    Then I should see page title contains "Ecosia"
#    Then element with xpath "//*[@data-test-id='search-form-input']" should be present
#    When I type "Behavior Driven Development" into element with xpath "//*[@data-test-id='search-form-input']"
#    Then I click on element using JavaScript with xpath "//*[@data-test-id='search-form-submit']"
#    Then I wait for element with xpath "//*[@class='mainline-results']" to be present
#    Then element with xpath "//*[@class='mainline-results']" should contain text "Cucumber"
#
#  @predefined12
#  Scenario: Verify the quote page has a responsive UI
#    Given I open url "https://skryabin.com/market/quote.html"
#    When I resize window to 400 and 800
#    * I wait for 1 sec
#    Then element with xpath "//*[@id='location']" should not be displayed
#    When I resize window to 1200 and 800
#    * I wait for 1 sec
#    Then element with xpath "//*[@id='location']" should be displayed
#
#  @predefined13
#  Scenario: Verify minimum length of the "Username" field
#    Given I open url "https://skryabin.com/market/quote.html"
#    When I type "a" into element with xpath "//input[@name='username']"
#    * I click on element with xpath "//*[@id='formSubmit']"
#    * I wait for 1 sec
#    Then element with xpath "//*[@id='username-error']" should be displayed
#    * element with xpath "//*[@id='username-error']" should contain text "2 char"
#    When I type "b" into element with xpath "//input[@name='username']"
#    * I wait for 1 sec
#    Then element with xpath "//*[@id='username-error']" should not be displayed

  @predefined14
  Scenario: Verify the set of required fields ("Username", "Email", "Password", "Name", Privacy Policy checkbox)
    Given I open url "https://skryabin.com/market/quote.html"
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

  @predefined15
  Scenario: Verify "Email" field accepts basic valid email a@b (Happy Path)
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be present
  
  @predefined16
  Scenario: Verify "Email" field clears dynamic error messages correctly
    Given I open url "https://skryabin.com/market/quote.html"
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

  @predefined17
  Scenario: Verify "Email" field requires one and only one @ symbol with non-empty local/domain parts
    Given I open url "https://skryabin.com/market/quote.html"
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
  @predefined18
  Scenario: Verify "Email" field accepts printable characters !#$%&'*+-/=?^_`{|}~ in the local part
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "!#$%&'*+-/=?^_`{|}~@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should not be present

  @predefined19
  Scenario: Verify "Email" field accepts dot . in the local part as long as its not fist, last or consecutive use
    Given I open url "https://skryabin.com/market/quote.html"
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

  @predefined20
  Scenario: Verify "Email" field accepts dot . in the domain part as long as its not fist, last or consecutive use
    Given I open url "https://skryabin.com/market/quote.html"
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

  @predefined21
  Scenario: Verify "Email" field does not accept quoted " " local part
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "\"a\"@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefined22
  Scenario: Verify "Email" field accepts hyphen in the domain part, as long as its not first or last
    Given I open url "https://skryabin.com/market/quote.html"
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

  @predefined23
  Scenario: Verify "Email" field does not allow IP addresses in the domain part
    Given I open url "https://skryabin.com/market/quote.html"
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

  @predefined24
  Scenario: Verify "Email" field does not allow local part longer than 64 octets
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "1234567890123456789012345678901234567890123456789012345678901234a@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefined25
  Scenario: Verify "Email" field does not allow labels longer than 63 octets in the domain part
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a@123456789012345678901234567890123456789012345678901234567890123b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//*[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//*[@id='email-error']" should be displayed
    And element with xpath "//*[@id='email-error']" should contain text "valid"

  @predefined26
  Scenario: Verify "Password"/"Confirm Password" fields behavior
    Given I open url "https://skryabin.com/market/quote.html"
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

  @predefined27
  Scenario: Verify "Name" field with popup modal dialog behavior
    Given I open url "https://skryabin.com/market/quote.html"
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

  @predefined28
  Scenario: Verify "I have read and accept Privacy Policy" checkbox behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@id='formSubmit']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    * I wait for 1 sec
    Then element with xpath "//*[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefined29
  Scenario: Verify minimal form submission (Happy Path)
    Given I open url "https://skryabin.com/market/quote.html"
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