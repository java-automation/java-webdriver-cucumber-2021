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
    Given I open url "https://www.bing.com"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@id='web-results']" to be present
    Then element with xpath "//div[@id='web-results']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for Duck Duck Go
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@id='links']" to be present
    Then element with xpath "//div[@id='links']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swiss Cows
    Given I open url "https://swisscows.com"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    When I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//div[@id='autosuggest']//input" should be present
    When I type "Behavior Driven Development" into element with xpath "//div[@id='autosuggest']//input"
    When I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Start Page
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//input[@id='q']/..//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results mainline-results__web']" to be present
    Then I wait for 1 sec
    Then element with xpath "//div[@class='mainline-results mainline-results__web']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com"
    Then I should see page title as "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    When I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//ul[@id='search-result']" to be present
    Then element with xpath "//ul[@id='search-result']" should contain text "Cucumber"

  @predefined10
  Scenario: Predefined steps for Broad Reader
    Given I open url "https://boardreader.com"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    And I click on element using JavaScript with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
    And I wait for 1 sec
    Then element with xpath "//ul[@class='mdl-list']" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@data-test-id='search-form-input']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@data-test-id='search-form-input']"
    When I click on element with xpath "//button[@data-test-id='search-form-submit']"
    Then I wait for element with xpath "//div[@class='card-desktop card-web']" to be present
    Then element with xpath "//div[@class='card-desktop card-web']" should contain text "Cucumber"


  @predefined12 @quotePage
  Scenario: Validate responsive UI for the Quote page
    Given I open url "https://skryabin.com/market/quote.html"
    And I resize window to 1200 and 800
    Then element with xpath "//b[@id='location']" should be displayed
    And I resize window to 400 and 800
    Then element with xpath "//b[@id='location']" should not be displayed

  @predefined13 @quotePage
  Scenario: Username filed validation on the Quote page
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@name='username']" should be present
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    And element with xpath "//label[@id='username-error']" should contain text "enter at least 2"
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @predefined14 @quotePage @email
  Scenario: Email filed validation on the Quote page - scenario with 0 or 1 character
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@name='email']" should be present
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And element with xpath "//label[@id='email-error']" should contain text "field is required."
    When I type "a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And element with xpath "//label[@id='email-error']" should contain text "enter a valid email"

  @predefined15 @quotePage @email
  Scenario Outline: Email filed validation on the Quote page - field does not accept invalid values
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@name='email']" should be present
    When I type "<email>" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And element with xpath "//label[@id='email-error']" should contain text "enter a valid email"
    Then I clear element with xpath "//input[@name='email']"
    When I type "Te_st12a.te-ST@test.US" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should not be displayed
    Examples:
    |email|
    |test.gmail.com|
    |testgmail.com|
    |test gmail.com|
    |test@@gmail.com|
    |test@gmail com|
    #    below email address test@gmailcom is invalid but it failed - Bug?
    |test@gmailcom|
    |test@gmail..com|
    |test@gmail,com|

  @predefined16 @quotePage @password
  Scenario: Validate blank Password field for the Quote page
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='password']" should be present
    When I click on element with xpath "//button[@id='formSubmit']"
    And element with xpath "//label[@id='password-error']" should contain text "field is required"
    And element with xpath "//input[@id='password']" should have attribute "value" as ""
    And element with xpath "//input[@id='confirmPassword']" should be disabled
    And I type "Test5" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled

  @predefined17 @quotePage @password
  Scenario Outline: Validate Password field for the Quote page - min 5 characters
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='password']" should be present
    When I type "<password>" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='password-error']" should be displayed
    And element with xpath "//label[@id='password-error']" should contain text "5 characters"
    When I clear element with xpath "//input[@id='password']"
    And I type "Test5" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='password-error']" should not be displayed
    Examples:
      |password|
      |a|
      |1|
      |1234|


  @predefined18 @quotePage
  Scenario: Validate Name field for the Quote page
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='name']" should be present
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "First" into element with xpath "//input[@id='firstName']"
    And I type "Mid" into element with xpath "//input[@id='middleName']"
    And I type "Last" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "//span[text()='Save']"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "First Mid Last"

  @predefined19 @quotePage
  Scenario: Validate Privacy Policy checkbox for the Quote page
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@name='agreedToPrivacyPolicy']" should be present
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    And element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "Must check!"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefined19 @quotePage
  Scenario: Validate optional fields for the Quote page
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "+19165559090" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='USA']"
    And I click on element with xpath "//input[@value='female']"
    Then I click on element with xpath "//input[@name='allowedToContact']"
    When I type "22 Test street 33, Test City, CA, 95999 " into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Ford']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    Then I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "(//select[@data-handler='selectMonth']/option)[5]"
    And I click on element with xpath "//*[@data-handler='selectYear']/option[@value='1988']"
    And I click on element with xpath "//*[@data-handler='selectDay']/a[text()='11']"
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "05/11/1988"

  @predefined20 @quotePage
  Scenario: Submit the form and verify the data
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "test1" into element with xpath "//input[@name='username']"
    And I type "test@gmail.com" into element with xpath "//input[@name='email']"
    And I type "Pass123" into element with xpath "//input[@id='password']"
    And I type "Pass123" into element with xpath "//input[@id='confirmPassword']"
    And I type "Olga Alferova" into element with xpath "//input[@id='name']"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//div[@id='quotePageResult']" should be displayed
    Then element with xpath "//b[@name='username']" should have text as "test1"
    And element with xpath "//b[@name='email']" should have text as "test@gmail.com"
    And element with xpath "//b[@name='name']" should have text as "Olga Alferova"
    And element with xpath "//b[@name='password']" should not contain text "Pass123"

