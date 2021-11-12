@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @yahoo
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
    Then element with xpath "//input[@id='ybar-sbq']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='ybar-sbq']"
    Then I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//div[@id='results']" to be present
    Then element with xpath "//div[@id='results']" should contain text "Cucumber"

  @bing
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@id='sb_form_q']"
    Then I click on element with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//div[@id='b_content']" to be present
    Then element with xpath "//div[@id='b_content']" should contain text "Cucumber"
    
  @gibiru
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title as "Gibiru – Protecting your privacy since 2009"
    Then element with xpath "//input[@id='q']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@id='web-results']" to be present
    Then element with xpath "//div[@id='web-results']" should contain text "Cucumber"

  @duckduckgo
  Scenario: Predefined steps for Duckduckgo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title as "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results js-results']" to be present
    Then element with xpath "//div[@class='results js-results']" should contain text "Cucumber"

  @swisscows
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title as "Swisscows the alternative, data secure search engine."
    Then element with xpath "//input[@class='input-search']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@class='input-search']"
    Then I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @searchencrypt
  Scenario: Predefined steps for Searchencrypt
    Given I open url "https://www.searchencrypt.com/"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//input[@name='q']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @startpage
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title as "Startpage - Private Search Engine. No Tracking. No Search History."
    Then element with xpath "//input[@id='q']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    Then I wait for element with xpath "//div[@class='mainline-results--']" to be present
    Then element with xpath "//div[@class='mainline-results--']" should contain text "Cucumber"

  @yandex
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title as "Yandex"
    Then element with xpath "//input[@class='input__control input__input mini-suggest__input']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@class='input__control input__input mini-suggest__input']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//ul[@id='search-result']" to be present
    Then element with xpath "//ul[@id='search-result']" should contain text "Cucumber"

  @boardreader
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com/"
    Then I should see page title as "Boardreader - Forum Search Engine"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@id='title-query']"
    Then I wait for element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" to be present
    And I wait for 1 sec
    Then element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" should contain text "Cucumber"

  @ecosia
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title as "Ecosia - the search engine that plants trees"
    Then element with xpath "//input[@name='q']" should be present
    When I type 'Behavior Driven Development' into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='results-page']" to be present
    Then element with xpath "//div[@class='results-page']" should contain text "Cucumber"
  
  @predefined2
  Scenario: Validate responsive UI of Quote page
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 400 and 800
    And I wait for 1 sec
    Then element with xpath "//b[@id='location']" should not be displayed
    And I resize window to 1200 and 800
    And I wait for 1 sec
    Then element with xpath "//b[@id='location']" should be displayed

  @predefined3
  Scenario: Validate min name length
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    Then element with xpath "//label[@id='username-error']" should contain text "2 char"
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @predefined4
  Scenario: Validate Email field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I clear element with xpath "//input[@name='email']"
    And I type "a.b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    And I type "a@" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    And I type "@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    And I type "a@@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    And I type "a b@c" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    And I type "a@_b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    And I type "a,@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I clear element with xpath "//input[@name='email']"
    And I type "a@b" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//label[@for='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined5
  Scenario:  Fill out and validate Password set of fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "1234" into element with xpath "//input[@id='password']"
    And I type "1234" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//label[@for='password']"
    Then element with xpath "//label[@id='password-error']" should be displayed
    And element with xpath "//label[@id='confirmPassword-error']" should be displayed
    When I clear element with xpath "//input[@id='confirmPassword']"
    And I clear element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "1234a" into element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='confirmPassword-error']" should be displayed
    And element with xpath "//label[@id='password-error']" should not be displayed
    When I clear element with xpath "//input[@id='confirmPassword']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[@id='confirmPassword-error']" should not be displayed
    And element with xpath "//label[@id='password-error']" should not be displayed
    And element with xpath "//label[@id='confirmPassword-error']" should not be displayed
    When I clear element with xpath "//input[@id='confirmPassword']"
    And I clear element with xpath "//input[@id='password']"
    And I click on element with xpath "//label[@for='password']"
    Then element with xpath "//input[@id='confirmPassword'][@disabled='disabled']" should be present

  @predefined6
  Scenario:  Validate Name field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
    When I type "John" into element with xpath "//input[@id='firstName']"
    And I type "A" into element with xpath "//input[@id='middleName']"
    And I type "Doe" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "John A Doe"

  @predefined7
  Scenario: Validate Accepting Privacy Policy
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    And I type "John" into element with xpath "//input[@id='firstName']"
    And I type "A" into element with xpath "//input[@id='middleName']"
    And I type "Doe" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    And I type "jdoe" into element with xpath "//input[@name='username']"
    And I type "jdoe@gmail.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//div[@id='quotePageResult'][@style='display: none;']" should not be present

  @predefined8
  Scenario: Submit the form and verify the data
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    And I type "John" into element with xpath "//input[@id='firstName']"
    And I type "A" into element with xpath "//input[@id='middleName']"
    And I type "Doe" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    And I type "jdoe" into element with xpath "//input[@name='username']"
    And I type "jdoe@gmail.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='firstName']" should contain text "John"
    And element with xpath "//b[@name='middleName']" should contain text "A"
    And element with xpath "//b[@name='lastName']" should contain text "Doe"
    And element with xpath "//b[@name='name']" should contain text "John A Doe"
    And element with xpath "//b[@name='username']" should contain text "jdoe"
    And element with xpath "//b[@name='email']" should contain text "jdoe@gmail.com"
    And element with xpath "//b[@name='password']" should not contain text "12345"
    And element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"










