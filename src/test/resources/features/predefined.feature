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
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    And I click on element with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//main[@aria-label='Search Results']" to be present
    Then element with xpath "//main[@aria-label='Search Results']" should contain text "Agile"


    @predefined3
    Scenario: Predefined steps for Yahoo
      Given I open url "https://www.yahoo.com"
      Then I should see page title as "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
      Then element with xpath "//input[@id='ybar-sbq']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='ybar-sbq']"
      And I click on element with xpath "//input[@id='ybar-search']"
      Then I wait for element with xpath "//div[@id='left']" to be present
      Then element with xpath "//div[@id='left']" should contain text "cucumber"


    @predefined4
    Scenario: Predefined steps for Gibiru
      Given I open url "https://gibiru.com/"
      Then I should see page title contains "Gibiru"
      Then element with xpath "//input[@id='q']" should be displayed
      #Then element with xpath "//input[@id='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
      And I click on element with xpath "//button[@id='button-addon2']"
      Then I wait for element with xpath "//div[contains(@class, 'gsc-control-cse')]" to be present
      Then element with xpath "//div[contains(@class, 'gsc-control-cse')]" should contain text "cucumber"


    @predefined5
    Scenario: Predefined steps for DuckDuckGo
      Given I open url "https://duckduckgo.com"
      Then I should see page title contains ""
      Then element with xpath "//form[@id='search_form_homepage']" should be present
      When I type "java" into element with xpath "//input[@id='search_form_input_homepage']"
      And I click on element with xpath "//input[@id='search_form_input_clear']"
      Then element with xpath "//input[@id='search_form_input_homepage']" should not have text as "java"
      When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
      And I click on element with xpath "//input[@id='search_button_homepage']"
      Then I wait for element with xpath "//div[@id='links']" to be present
      Then element with xpath "//div[@id='links']" should contain text "Wikipedia"

    @predefined6
    Scenario: Predefined steps for Swisscows
      Given I open url "https://swisscows.com"
      Then I should see page title contains "Swisscows"
      Then element with xpath "//input[@name='query']" should be present
      #And element with xpath "//div[@class='regions mobile-hidden']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
      And I click on element with xpath "//button[@class='search-submit']"
      Then I wait for element with xpath "//div[@class='web-results']" to be present
      Then element with xpath "//div[@class='web-results']" should contain text "cucumber"


    @predefined7
    Scenario: Predefined steps for Yandex
      Given I open url "https://www.yandex.com/"
      Then I should see page title as "Yandex"
      Then element with xpath "//div[@class='logo__image_bg']" should be present
      And element with xpath "//td[@class='main__item main__item__search']" should be present
      When I type "vase" into element with xpath "//input[@id='text']"
      And I click on element with xpath "//button[@type='submit']"
      Then I wait for element with xpath "//ul[@class='serp-list serp-list_left_yes']" to be present
      Then element with xpath "//ul[@class='serp-list serp-list_left_yes']" should contain text "wikipedia"

    @predefined8
    Scenario: Predefined steps for Startpage
      Given I open url "https://www.startpage.com"
      Then I should see page title contains "Startpage"
      Then element with xpath "//input[@id='q']" should be present
      When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
      When I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    #  Then I wait for element with xpath "//p[@class='w-gl__description']" to be displayed
    #  Then element with xpath "//div[@class='mainline-results mainline-results__web']" should contain text "Cucumber"





    @predefined9
      Scenario: Validate responsive UI of Quote page
        Given I open url "https://skryabin.com/market/quote.html"
        And I resize window to 400 and 800
        Then element with xpath "//b[@id='location']" should not be displayed
        And I resize window to 1200 and 800
        Then element with xpath "//b[@id='location']" should be displayed

    @predefined10
      Scenario: validate min length Username
        Given I open url "https://skryabin.com/market/quote.html"
        When I type "a" into element with xpath "//input[@name='username']"
        And I click on element with xpath "//input[@name='email']"
        Then element with xpath "//label[@id='username-error']" should be displayed
        And element with xpath "//label[@id='username-error']" should contain text "2 char"
        When I type "b" into element with xpath "//input[@name='username']"
        Then element with xpath "//label[@id='username-error']" should not be displayed


    @predefined11
      Scenario: Validate Email field behavior
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "$ab@36146." into element with xpath "//input[@name='email']"
      When I click on element with xpath "//input[@id='password']"
      Then element with xpath "//label[@id='email-error']" should contain text "enter a valid"


    @predefined12
    Scenario: Confirm Password Validation
      Given I open url "https://skryabin.com/market/quote.html"
    #  When I type "dgfjh" into element with xpath "//input[@id='password']"
        # Then element with xpath "//input[@id='confirmPassword']" should be enabled
    #  When I clear element with xpath "//input[@id='password']"
    #  And I click on element with xpath "//input[@id='confirmPassword']"
      When I type "" into element with xpath "//input[@id='password']"
      Then element with xpath "//input[@id='confirmPassword']" should be disabled
      Then element with xpath "//input[@id='confirmPassword']" should have attribute "disabled" as "true"


  @predefined13
  Scenario: Name Model dialog Validation
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@id='name']"
    Then element with xpath "//*[@role='dialog']" should be displayed
    When I type "abc" into element with xpath "//*[@id='firstName']"
    And I type "m" into element with xpath "//input[@id='middleName']"
    And I type "def" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    Then element with xpath "//*[@id='name']" should have attribute "value" as "abc m def"


  @predefined14
  Scenario: Accepting Privacy Policy field Validation
    Given I open url "https://skryabin.com/market/quote.html"
    And I type "abc m def" into element with xpath "//input[@id='name']"
    And I type "abc" into element with xpath "//input[@name='username']"
    And I type "jm@gmail.com" into element with xpath "//input[@name='email']"
    And I type "1234" into element with xpath "//input[@id='password']"
    And I type "1234" into element with xpath "//input[@id='confirmPassword']"
    When I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//*[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed


  @predefined15
  Scenario: Phone number validation
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "123456789123456789123" into element with xpath "//*[@name='phone']"
    And I click on element with xpath "//*[@id='dateOfBirth']"
    Then element with xpath "//label[@id='phone-error']" should contain text "no more than 20 characters."

  @predefined16
  Scenario: Date of Birth validation
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@id='dateOfBirth']"
    Then element with xpath "//*[contains(@id,'datepicker')]" should be displayed
    When I click on element with xpath "//select[@class='ui-datepicker-month']/option[@value='6']"
    Then element with xpath "//select[contains(@class,'month')]" should contain text "Jul"
    When I click on element with xpath "//select[contains(@class,'year')]/option[@value='2000']"
    Then element with xpath "//select[contains(@class,'year')]" should contain text "2000"
    When I click on element with xpath "//a[contains(text(),'10')]"
  #  Then element with xpath "//*[@id='dateOfBirth']" should contain text "07/10/2000"T
  #  Then element with xpath "//input[@id='dateOfBirth']" should have text as "07/10/2000"



  @predefined17
  Scenario: Country of Origin Validation
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//select[@name='countryOfOrigin']"
    Then element with xpath "//select[@name='countryOfOrigin']//option[@value='Canada']" should contain text "Canada"


  @predefined18
  Scenario: Gender Validation
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//*[@value='male']"
    Then element with xpath "//*[@value='male']" should be selected
    When I click on element with xpath "//*[@value='female']"
    Then element with xpath "//*[@value='male']" should not be selected

  @predefined19
  Scenario: Allowed to Contact Validation
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@name='allowedToContact']"
    Then element with xpath "//input[@name='allowedToContact']" should be selected
    When I click on element with xpath "//input[@name='allowedToContact']"
    Then element with xpath "//input[@name='allowedToContact']" should not be selected



  @predefined20
  Scenario: Third party Agreement validation
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    Then element with xpath "//*[@id='thirdPartyResponseMessage']" should contain text "You accepted third party agreement."



