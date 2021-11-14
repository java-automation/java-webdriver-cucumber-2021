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



  @predefined2
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title contains "Yahoo"
    Then element with xpath "//input[@name='p']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='p']"
    When I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title contains "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    When I click on element with xpath "//*[@viewBox='0 0 25 25']"
    Then I wait for element with xpath "//div[@id='b_content']" to be present
    Then element with xpath "//div[@id='b_content']" should contain text "Cucumber"


  @predefined4
  Scenario: Predefined steps for Gibiru
    Given  I open url "https://gibiru.com/"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//*[@class='fas fa-search new']"
    Then I wait for element with xpath "//div[@class='starter-template']" to be present
    Then element with xpath "//div[@class='starter-template']" should contain text "Cucumber"


  @predefined5
  Scenario: Predefined steps for DuckDuckgo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    When I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@id='links_wrapper']" to be present
    Then element with xpath "//div[@id='links_wrapper']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title contains "Swisscows"
    Then  element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    When I click on element with xpath "//*[@class='search-submit']"
    Then I wait for element with xpath "//*[@class='page-results']" to be present
    Then element with xpath "//*[@class='page-results']" should contain text "Cucumber"


  @predefined7
  Scenario: Predefined steps for Searchencrypt
   Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title contains "Search Encrypt | Home"
    Then element with xpath "//input[@type='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@type='text']"
    When I click on element with xpath "//*[@type='submit']"
    Then I wait for element with xpath "//section[@class='serp serp-page page view']" to be present
    Then element with xpath "//section[@class='serp serp-page page view']" should contain text "Cucumber"


  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//*[@aria-label='Startpage Search']"
    Then I wait for element with xpath "//div[@class='layout']" to be present
    Then element with xpath "//div[@class='layout']" should contain text "Cucumber"


  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title contains "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    When I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='main serp i-bem']" to be present
    Then element with xpath "//div[@class='main serp i-bem']" should contain text "Cucumber"

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com/"
    Then I should see page title contains "Boardreader - Forum Search Engine"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    When I click on element with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" to be present
    Then element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" should contain text "Cucumber"


  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//*[@class='results-wrapper']" to be present
    Then element with xpath "//*[@class='results-wrapper']" should contain text "Cucumber"

  @predefined1.1
  Scenario: Validate responsive UI of qoute page
    Given I open url "https://skryabin.com/market/quote.html"
    When I resize window to 400 and 800
    And  I wait for 2 sec
    Then element with xpath "//*[@id='location']" should not be displayed
    When I resize window to 1200 and 800
    Then element with xpath "//*[@id='location']" should be displayed



  @predefined1.2
  Scenario: Validate min length username
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    When  I click on element with xpath "//button[@id='formSubmit']"
    Then  element with xpath "//label[@id='username-error']" should be displayed
    Then  element with xpath "//label[@id='username-error']" should contain text "2 char"
    When  I type "ab" into element with xpath "//input[@name='username']"
    Then  element with xpath "//label[@id='username-error']" should not be displayed



  @predefined1.3
  Scenario: Validate “Email” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='email']"
    When I click on element with xpath "//input[@name='phone']"
    Then  element with xpath "//label[@id='email-error']" should be displayed
    Then  element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address"
    When  I type "test@test.com " into element with xpath "//input[@name='email']"
    Then  element with xpath "//label[@id='email-error']" should not be displayed


  @predefined1.4
  Scenario: Validate that Confirm Password is disabled if Password
  field is empty.
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@name='password']" should be present
    When I click on element with xpath "//input[@name='password']"
    When I click on element with xpath "//input[@name='confirmPassword']"
    Then element with xpath "//input[@name='confirmPassword']" should be displayed
    When I type "a" into element with xpath "//input[@name='password']"
    When I click on element with xpath "//input[@name='confirmPassword']"
    And  I wait for 2 sec
    Then element with xpath "//input[@name='confirmPassword']" should be enabled


  @predefined1.5
  Scenario: Validate “Name” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Max" into element with xpath "//input[@id='firstName']"
    When I type "Sam" into element with xpath "//input[@id='middleName']"
    And I type "Apple" into element with xpath "//input[@id='lastName']"
    When I click on element with xpath "//*[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']"
    And I wait for 2 sec
    Then element with xpath "//input[@id='name']" should be present


  @predefined1.6
  Scenario: Validate that Accepting Privacy Policy is required field.
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@name='agreedToPrivacyPolicy']" should be displayed
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    And  element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "- Must check!"




  @predefined1.7
  Scenario: Validate entering the following non-required fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "3127008899" into element with xpath "//input[@name='phone']"
    When I click on element with xpath "//*[@name='countryOfOrigin']"
    And I wait for 1 sec
    When I click on element with xpath "//*[@value='France']"
    When I click on element with xpath "//*[@value='female']"
    When I click on element with xpath "//input[@name='allowedToContact']"
    When I type "33 State st" into element with xpath "//*[@id='address']"
    When I click on element with xpath "//*[@value='BMW']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"


  @predefined1.8

  Scenario: Validate Submission of the form and verify the data
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Max" into element with xpath "//input[@id='firstName']"
    And I type "Apple" into element with xpath "//input[@id='lastName']"
    And I wait for 2 sec
    When I click on element with xpath "//span[text()='Save']"
    Then I type "Marsik" into element with xpath "//input[@name='username']"
    When I type "test@test.com" into element with xpath "//input[@name='email']"
    When I type "Test12" into element with xpath "//input[@id='password']"
    And I type "Test12" into element with xpath "//input[@id='confirmPassword']"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='email']" should have text as "test@test.com"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "Max"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "test@test.com"
    And I wait for 2 sec
    Then element with xpath "//input[@name='email']" should not be displayed
    And I wait for 2 sec



  @predefined1.8
  Scenario: Validate Sign up options for Spotify
    Given I open url "https://www.spotify.com/us/"
    When I click on element with xpath "//div[@class='ButtonInner-peijbp-0 hJWOAl']"
    When I type "music@test" into element with xpath "//input[@id='email']"
    And I type "music@test" into element with xpath "//input[@id='confirm']"
    When I type "Test#123" into element with xpath "//input[@id='password']"
    When I type "VV1" into element with xpath "//input[@id='displayname']"
    When I click on element with xpath "//div[@class='ButtonInner-sc-14ud5tc-0 kDOdzL FacebookSignup__StyledFacebookButton-c6ymk3-1 cASlYr']"
    And I wait for 2 sec
