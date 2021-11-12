@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element using JavaScript with xpath "(//input[@name='btnK'])[2]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

  @predefined2
  Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title contains "Yahoo"
    Then element with xpath "//input[@id='ybar-sbq']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='ybar-sbq']"
    When I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title contains "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    When I click on element with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title contains "Gibiru – Protecting your privacy since 2009"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//button[@class='btn btn-outline-secondary']"
    Then element with xpath "//div[@id='___gcse_0']" should be present
    Then element with xpath "//div[@id='___gcse_0']" should contain text "Cucumber"
    
  @predefined5
  Scenario: Predefined steps for Duckduckgo
    Given I open url "https://duckduckgo.com/?va=b&t=hc"
    Then I should see page title contains "DuckDuckGo — Privacy, simplified."
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    When I click on element with xpath "//input[@id='search_button_homepage']"
    Then element with xpath "//div[@id='links']" should be present
    Then element with xpath "//div[@id='links']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for swiss cows
    Given I open url "https://swisscows.com/?region=en-US"
    Then I should see page title contains "Swisscows the alternative, data secure search engine."
    Then element with xpath "//input[@class='input-search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='input-search']"
    When I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for search encrypt
    Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title as "Search Encrypt | Home"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"
    Then I wait for 2 sec

  @predefined8
  Scenario: Predefined steps for Start page 
    Given I open url "https://www.startpage.com/"
    Then I should see page title contains "Startpage - Private Search Engine. No Tracking. No Search History."
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    Then element with xpath "//section[@class='w-gl w-gl--desktop w-gl--dark']" should be present
    Then element with xpath "//section[@class='w-gl w-gl--desktop w-gl--dark']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title contains "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    When I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='content__left']" to be present
    Then element with xpath "//div[@class='content__left']" should contain text "Cucumber"

  @predefined10
  Scenario: Predefined steps for board reader
    Given I open url "https://boardreader.com/"
    Then I should see page title contains "Boardreader - Forum Search Engine"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    When I click on element with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
    Then element with xpath "//ul[@class='mdl-list']" should contain text "Cucumber"
    Then I wait for 2 sec

  @predefined11
  Scenario: Predefined steps for ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia - the search engine that plants trees"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"

  @predefined12
  Scenario: Validate responsive UI of quote page
   // Given I open url "https://skryabin.com/market/quote.html"
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
    And I wait for 5 sec
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @predefined14
  Scenario: Validate email accepts only valid email addresses
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "abc" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    Then element with xpath "//label[@id='email-error']" should contain text "enter a valid email"
    When I type "@gmail.com" into element with xpath "//input[@name='email']"
    And I wait for 5 sec
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined15
  Scenario: Validate confirm password is disabled
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title contains "Get a Quote"
    Then element with xpath "//input[@id='password']" should be present
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    When I type "1234567" into element with xpath "//input[@id='password']"
    And I type "1234567" into element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//input[@id='confirmPassword']" should be displayed

  @predefined16
  Scenario: Verify name field pop up dialog appears
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title contains "Get a Quote"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@aria-describedby='nameDialog']" should be present
    When I type "Hrag" into element with xpath "//input[@id='firstName']"
    And I type "Banian" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Hrag Banian"

  @predefined17
  Scenario: Validate accepting privacy policy
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title contains "Get a Quote"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//button[@id='formRefresh']"
    Then I wait for 2 sec
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be present

  @predefined18
  Scenario: Submit the form and verify the data
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title contains "Get a Quote"
    When I type "Hrag007" into element with xpath "//input[@name='username']"
    And I type "abc@gmail.com" into element with xpath "//input[@name='email']"
    And I type "1234567" into element with xpath "//input[@name='password']"
    And I type "1234567" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@aria-describedby='nameDialog']" should be present
    When I type "Hrag" into element with xpath "//input[@id='firstName']"
    And I type "Banian" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Hrag Banian"
    When I type "6467777777" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[@*='selectMonth']/option[11]"
    And I click on element with xpath "//select[@*='selectYear']/option[@value='1899']"
    And I click on element with xpath "//td[@*='selectDay']/a[text()='7']"
    And I wait for 2 sec
    And element with xpath "//input[@id='dateOfBirth']" should contain text "11/07/1899"
    And I wait for 2 sec
    Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
    When I click on element with xpath "//a[text()='3']"
    And I wait for 2 sec
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "id" as "11/03/2021"
    And I wait for 2 sec
    When I click on element with xpath "//input[@value='male']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//div[@id='quotePageResult']" should be present
    Then element with xpath "//div[@id='quotePageResult']" should contain text "male"



  @predefined19
  Scenario: Quote form end to end scenario - required fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "jdoe" into element with xpath "//input[@name='username']"
    And I type "john.doe@example.com" into element with xpath "//input[@name='email']"
    And I type "welcome" into element with xpath "//input[@id='password']"
    And I type "welcome" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@aria-describedby='nameDialog']" should be present
    When I type "Hrag" into element with xpath "//input[@id='firstName']"
    And I type "Banian" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Hrag Banian"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//div[@id='quotePageResult']" should contain text {string}
    
    Then element with xpath "//b[@name='email']" should have text as "john.doe@example.com"

    And I wait for 5 sec

  @predefined20
  Scenario: Required fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//*[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    And I clear element with xpath "//*[@name='username']"












    



    






