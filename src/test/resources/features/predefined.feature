@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined0
  Scenario: Another Java
    Given I say "My Message on Cicumber"

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
    Given I open url "https://www.bing.com"
    Then I should see page title contains "Bing"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//main[@aria-label='Search Results']" to be present
    Then element with xpath "//main[@aria-label='Search Results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@id='web-results']" to be present
    Then element with xpath "//div[@id='web-results']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for Duckduckgo
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@id='links']" to be present
    Then element with xpath "//div[@id='links']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    When I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Searchencrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    Then I wait for element with xpath "//section[@class='w-gl w-gl--desktop w-gl--']" to be present
    Then element with xpath "//section[@class='w-gl w-gl--desktop w-gl--']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com"
    Then I should see page title contains "Yandex"
    Then element with xpath "//input[@name='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='text']"
    When I click on element with xpath "//*[text()='Search']/.."
    Then I wait for element with xpath "//div[@class='content__left']" to be present
    Then element with xpath "//div[@class='content__left']" should contain text "Cucumber"

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    When I click on element with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
    Then element with xpath "//ul[@class='mdl-list']" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//div[@class='search-form__actions']/button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"

  @predefined12
  Scenario: Validate responsive UI of quote page
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 400 and 800
    Then element with xpath "//b[@id='location']" should not be displayed
    And I resize window to 1200 and 800
    Then element with xpath "//b[@id='location']" should be displayed

  @predefined13
  Scenario: Validate min length username
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    Then element with xpath "//label[@id='username-error']" should contain text "2 char"
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should have attribute "style" as "display: none;"

    @predefined14
    Scenario: Validate "Email" field behavior.
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "123" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='email-error']" should be displayed
      Then element with xpath "//label[@id='email-error']" should contain text "valid email"
      When I type "@b" into element with xpath "//input[@name='email']"
      Then element with xpath "//label[@id='email-error']" should not be displayed

    @predefined15
    Scenario: Validate min length Password
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "a" into element with xpath "//input[@id='password']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='password-error']" should be displayed
      Then element with xpath "//label[@id='password-error']" should contain text "5 char"
      When I type "1234" into element with xpath "//input[@id='password']"
      Then element with xpath "//label[@id='password-error']" should not be displayed

    @predefined16
    Scenario: Validate Password is required field
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@id='password']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='password-error']" should be displayed
      Then element with xpath "//label[@id='password-error']" should contain text "is required"
      When I type "12345" into element with xpath "//input[@id='password']"
      Then element with xpath "//label[@id='password-error']" should not be displayed

    @predefined17
    Scenario: Validate that Confirm Password is disabled if Password field is empty.
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@id='password']"
      Then element with xpath "//input[@name='confirmPassword']" should be disabled
      When I type "1" into element with xpath "//input[@id='password']"
      Then element with xpath "//input[@name='confirmPassword']" should be enabled

    @predefined18
    Scenario: Validate "Name" field behavior. Verify that upon clicking inside of Name field popup dialog appears.
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@id='nameDialog']" should be displayed

    @predefined19
    Scenario: Validate "Name" field behavior. Verify name concatination.
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@id='nameDialog']" should be displayed
      When I type "Amanda" into element with xpath "//input[@id='firstName']"
      And I type "Evelin" into element with xpath "//input[@id='middleName']"
      And I type "Smith" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[contains(text(),'Save')]"
      Then element with xpath "//input[@id='name'][@value='Amanda Evelin Smith']" should be displayed

    @predefined20
    Scenario: Validate that Accepting Privacy Policy is required to summit the form, then check the field.
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
      When I click on element with xpath "//div[contains(@class, 'agreedToPrivacyPolicy')]"
      Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

    @predefined21
    Scenario: Try entering non-required fields in the given order.
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "5554444555" into element with xpath "//input[@name='phone']"
      And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Ukraine']"
      And I click on element with xpath "//*[@name='gender'][@value='female']"
      And I click on element with xpath "//input[@name='allowedToContact']/.."
      And I type "My Address" into element with xpath "//textarea[@id='address']"
      And I click on element with xpath "//select[@name='carMake']/option[@value='Other']"
      And I click on element using JavaScript with xpath "//button[@id='thirdPartyButton']"

    @predefined22
    Scenario: Quote form end to end scenario - required fields.
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "User123" into element with xpath "//input[@name='username']"
      And I type "user123@yahoo.com" into element with xpath "//input[@name='email']"
      And I type "password123" into element with xpath "//input[@id='password']"
      And I type "password123" into element with xpath "//input[@id='confirmPassword']"
      When I click on element with xpath "//input[@id='name']"
      And I type "Amanda" into element with xpath "//input[@id='firstName']"
      And I type "Smith" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[text()='Save']"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "Amanda Smith"
      And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      And I click on element with xpath "//button[@id='formSubmit']"

      Then element with xpath "//b[@name='password']" should not contain text "password123"
      Then element with xpath "//b[@name='email']" should have text as "user123@yahoo.com"
      Then element with xpath "//div[@id='quotePageResult']" should contain text "User123"
      Then element with xpath "//div[@id='quotePageResult']" should contain text "Amanda Smith"
      Then element with xpath "//[@name='agreedToPrivacyPolicy']" should have text as "true"

  @predefined23
  Scenario: Covered element.
    Given I open url "https://www.ups.com/us/en/global.page"
    When I resize window to 1024 and 800
    And I click on element with xpath "//a[@data-map='ups-svg-mideast']//span"
    And I wait for 1 sec
    And I click on element using JavaScript with xpath "//a[@data-map='ups-svg-africa']//span"
    And I wait for 5 sec










