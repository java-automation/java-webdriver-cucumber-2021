@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    And I should see page title as "Google"
    And element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    And I wait for 3 sec
    And element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    And I should see page title contains "Yahoo"
    And element with xpath "//input[@name='p']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='p']"
    And I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//*[@id='web']" to be present
    And I wait for 3 sec
    And element with xpath "//*[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    And I should see page title contains "Bing"
    And element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//label[@id='search_icon']//*[@viewBox]"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    And I wait for 3 sec
    And element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com"
    And I should see page title contains "Gibiru"
    And element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//*[contains(@class,'resultsbox')]" to be present
    And I wait for 3 sec
    And element with xpath "//*[contains(@class,'resultsbox')]" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com"
    And I should see page title contains "DuckDuckGo"
    And element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//input[contains(@class,'search__button')]"
    Then I wait for element with xpath "//div[@id='links']" to be present
    And I wait for 3 sec
    And element with xpath "//div[@id='links']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com"
    And I should see page title contains "Swisscows"
    And element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    And I click on element with xpath "//button[contains(@class,'submit')]"
    Then I wait for element with xpath "//*[contains(@class,'web-results')]" to be present
    And I wait for 3 sec
    And element with xpath "//*[contains(@class,'web-results')]" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com"
    And I should see page title contains "Search Encrypt"
    And element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[contains(@class,'submit')]"
    Then I wait for element with xpath "//*[contains(@class,'results container')]" to be present
    And I wait for 3 sec
    And element with xpath "//*[contains(@class,'results container')]" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    And I should see page title contains "Startpage"
    And element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    And I click on element with xpath "//button[contains(@class,'home__button-desktop')]"
    Then I wait for element with xpath "//*[contains(@class,'show-results')]" to be present
    And I wait for 3 sec
    And element with xpath "//*[contains(@class,'show-results')]" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com"
    And I should see page title contains "Yandex"
    And element with xpath "//input[contains(@name,'text')]" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[contains(@name,'text')]"
    And I click on element with xpath "//button[contains(@class,'search')]"
    Then I wait for element with xpath "//*[@id='search-result']" to be present
    And I wait for 3 sec
    And element with xpath "//*[@id='search-result']" should contain text "Cucumber"

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com"
    And I should see page title contains "Boardreader"
    And element with xpath "//input[contains(@id,'title-query')]" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[contains(@id,'title-query')]"
    And I click on element with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//*[contains(@class,'searchResults')]" to be present
    And I wait for 3 sec
    And element with xpath "//*[contains(@class,'searchResults')]" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    And I should see page title contains "Ecosia"
    And element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[contains(@class,'submit')]"
    Then element with xpath "//*[contains(@class,'container results')]" should be present
    And I wait for 3 sec
    And element with xpath "//*[contains(@class,'container results')]" should contain text "Cucumber"

  @predefined12
  Scenario: Validate responsive UI behavior
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//b[@id='location']" should be displayed
    And element with xpath "//b[@id='currentDate']" should be displayed
    And element with xpath "//b[@id='currentTime']" should be displayed
    When I resize window to 400 and 800
    Then element with xpath "//b[@id='location']" should not be displayed
    And element with xpath "//b[@id='currentDate']" should not be displayed
    And element with xpath "//b[@id='currentTime']" should not be displayed
    When I resize window to 1280 and 800
    Then element with xpath "//b[@id='location']" should be displayed
    And element with xpath "//b[@id='currentDate']" should be displayed
    And element with xpath "//b[@id='currentTime']" should be displayed

  @predefined13
  Scenario: Fill out and validate "Username" field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @predefined14
  Scenario: Validate "Email" field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "test.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='confirmPassword']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I clear element with xpath "//input[@name='email']"
#    When I type "test@com" into element with xpath "//input[@name='email']"
#    And I click on element with xpath "//label[@for='confirmPassword']"
#    Then element with xpath "//label[@id='email-error']" should be displayed
#    And I clear element with xpath "//input[@name='email']"
    When I type "test@.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='confirmPassword']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I clear element with xpath "//input[@name='email']"
    When I type "@test" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='confirmPassword']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I clear element with xpath "//input[@name='email']"
    When I type "test@t.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='confirmPassword']"
    Then element with xpath "//label[@id='email-error']" should not be displayed
#Bug: the code is not displaying error when email={'test@com'}

  @predefined15
  Scenario: Fill out and validate "Password" set of fields
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    When I type "a" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled
    When I clear element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled

  @predefined16
  Scenario: Validate "Name" field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//*[@aria-describedby='nameDialog']" should be displayed
    When I type "First" into element with xpath "//input[@id='firstName']"
    And I type "Middle" into element with xpath "//input[@id='middleName']"
    And I type "Last" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//*[@aria-describedby='nameDialog']//span[text()='Save']"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "First Middle Last"

  @predefined17
  Scenario: Validate that Accepting Privacy Policy
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefined18
  Scenario: Try entering the non-required fields in the order
    Given I open url "https://skryabin.com/market/quote.html"
    And I type "(563)929-6215" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//option[@value='USA']"
    And I click on element with xpath "//input[@value='female']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "906 Bates Brothers Road" into element with xpath "//*[@id='address']"
    And I click on element with xpath "//option[@value='Toyota']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[contains(@class,'datepicker-month')]//option[@value='3']"
    And I click on element with xpath "//select[contains(@class,'datepicker-year')]//option[@value='2000']"
    And I click on element with xpath "//td[@data-handler='selectDay']//a[text()='10']"
    
  @predefined19
  Scenario: Submit the form and verify the data
    Given I open url "https://skryabin.com/market/quote.html"
    And I type "Eric" into element with xpath "//input[@id='name']"
    And I type "eckimsey" into element with xpath "//input[@name='username']"
    And I type "testPass2021-11-3" into element with xpath "//input[@id='password']"
    And I type "testPass2021-11-3" into element with xpath "//input[@id='confirmPassword']"
    And I type "casianolga@gmail.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='name']" should contain text "Eric"
    And element with xpath "//b[@name='username']" should contain text "eckimsey"
    And element with xpath "//b[@name='password']" should contain text "[entered]"
    And element with xpath "//b[@name='email']" should contain text "casianolga@gmail.com"
    And element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
    But element with xpath "//body" should not contain text "testPass2021-11-3"
