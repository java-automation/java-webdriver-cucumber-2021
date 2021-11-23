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
    Given I open url "https://yahoo.com"
    Then I should see page title contains "Yahoo"
    Then element with xpath "//input[@name='p']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='p']"
    When I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://bing.com"
    Then I should see page title contains "Bing"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='gsc-wrapper']" to be present
    Then element with xpath "//div[@class='gsc-wrapper']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    When I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@class='input-search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='input-search']"
    When I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com/home"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//input[@class='search-bar__search']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@class='search-bar__search']"
    When I click on element with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    Then I wait for element with xpath "//div[@class='show-results']" to be present
    Then I wait for 2 sec
    Then element with xpath "//div[@class='show-results']" should contain text "Cucumber"

  @predefined9
    #Just decided to use Yandex.RU out of curiosity
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.ru/"
    Then I should see page title contains "Яндекс"
    Then element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    When I click on element with xpath "//button[contains(@class,'button mini-suggest__')]"
    Then I wait for element with xpath "//div[@class='content__left']" to be present
    Then element with xpath "//div[@class='content__left']" should contain text "BDD"

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com/"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    When I click on element with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" to be present
    Then I wait for 1 sec
    Then element with xpath "//div[@class='mdl-cell mdl-cell--12-col searchResultsBlock']" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"



    ###################################Homework for Lesson 3###############################################



  @predefined12 @HW3
  Scenario: Validate responsive UI of quote page
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "(//div[@class='row'])[3]" should be present
    Then element with xpath "(//div[@class='row'])[3]" should contain text "Location Los Altos, CA 94022"
    When I resize window to 1024 and 768
    Then element with xpath "(//div[@class='row'])[3]" should contain text "Location Los Altos, CA 94022"
    When I resize window to 375 and 667
    Then element with xpath "(//div[@class='row'])[3]" should not contain text "Location Los Altos, CA 94022"


  @predefined13 @HW3
  Scenario: Fill out and validate “Username” field
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "1" into element with xpath "//input[@name='username']"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
    And I take screenshot


  @predefined14 @HW3
  Scenario: Validate “Email” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "zhuk" into element with xpath "//input[@name='email']"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should contain text "Please enter a valid email address."
    When I type "test@test.com" into element with xpath "//button[@id='formSubmit']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should not be present

  @predefined15 @HW3
  Scenario: Fill out and validate “Password” set of fields
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    When I type "123" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled

  @predefined16 @HW3
  Scenario: Validate “Name” field behavior
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be present
    When I type "Ivan" into element with xpath "//input[@id='firstName']"
    When I type "Ivanov" into element with xpath "//input[@id='middleName']"
    When I type "Ivanovich" into element with xpath "//input[@id='lastName']"
    When I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Ivan Ivanov Ivanovich"


  @predefined17 @HW3
  Scenario: Validate that Accepting Privacy Policy is required to submit the form, then check the field
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "- Must check!"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed


    
    
    
  @predefined18 @HW3
  Scenario: entering the following non-required fields in the order
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be present
    When I type "Ivan" into element with xpath "//input[@id='firstName']"
    When I type "Ivanov" into element with xpath "//input[@id='middleName']"
    When I type "Ivanovich" into element with xpath "//input[@id='lastName']"
    When I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "555-555-55-55" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Russia']"
    And I click on element with xpath "//input[@value='male']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "my address" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Toyota']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    When I click on element with xpath "//input[@id='dateOfBirth']"
    And I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='8']"
    And I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='1991']"
    And I click on element with xpath "//td[@data-handler='selectDay']/*[text()='30']"

    @predefined19
    Scenario: Weather in Izhevsk
      Given I open url "https://yandex.ru/pogoda/"
      When I type "Ижевск" into element with xpath "//input[contains(@class,'mini-suggest')]"
      #Implemented press Return key step
      And I press enter key in the element with xpath "//input[contains(@class,'mini-suggest')]"
      And I click on element with xpath "//a[contains(text(),'Ижевск, Удмуртская Республика, Россия')]"
      And I take screenshot
