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
    Then element with xpath "//*[@name='p']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@name='p']"
    When I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//*[@id='search_icon']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url " https://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    When I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='gsc-wrapper']" to be present
    Then element with xpath "//div[@class='gsc-wrapper']" should contain text "Cucumber"

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
    Scenario: Validate responsive UI of quote page
      Given I open url "https://skryabin.com/market/quote.html"
      And I resize window to 400 and 800
      Then element with xpath "//b[@id='location']" should not be displayed
      And I resize window to 1200 and 800
      Then element with xpath "//b[@id='location']" should be displayed

      @predefined8
      Scenario: Validate minimal length of username
        Given I open url "https://skryabin.com/market/quote.html"
        When I type "a" into element with xpath "//input[@name='username']"
        And I click on element with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='username-error']" should contain text "2 characters"
        When I type "b" into element with xpath "//input[@name='username']"
        Then element with xpath "//label[@id='username-error']" should not be displayed

      @predefined9
      Scenario: Verify email field accepts valid email address
        Given I open url "https://skryabin.com/market/quote.html"
        When I type "mdn@" into element with xpath "//input[@name='email']"
        Then I wait for 1 sec
        And I click on element with xpath "//button[@id='formSubmit']"
        Then element with xpath "//label[@id='email-error']" should contain text "email address"
        Then I clear element with xpath "//input[@name='email']"
        When I type "mdnochilova@gmail.com" into element with xpath "//input[@name='email']"
        Then I wait for 1 sec
        Then element with xpath "//label[@id='email-error']" should not be displayed

      @predefined10
      Scenario: Validate confirm password is disabled
        Given I open url "https://skryabin.com/market/quote.html"

        #//input[@id='confirmPassword'] - confirm password field
        #//input[@id='password'] - password field

      @predefined11
      Scenario: Verify the modal dialog upon clicking name field
        Given I open url "https://skryabin.com/market/quote.html"
          When I click on element with xpath "//input[@id='name']"
          Then element with xpath "//span[@id='ui-id-1']" should be displayed
          When I type "Madina" into element with xpath "//input[@id='firstName']"
          When I type "Ochilova" into element with xpath "//input[@id='lastName']"
          And I click on element with xpath "//span[contains(text(),'Save')]"
          Then element with xpath "//input[@value='Madina Ochilova']" should be displayed

   @predefined12
   Scenario: Validate that Accepting Privacy Policy is required
     Given I open url "https://skryabin.com/market/quote.html"
     And I click on element with xpath "//button[@name='formSubmit']"
     Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "Must check"
     When I click on element with xpath "//label[@class='required checkbox_radio']"
     And I click on element with xpath "//button[@name='formSubmit']"

  @predefined13
  Scenario: Entering non required fields in order
    Given I open url "https://skryabin.com/market/quote.html"
    Then I type "123 456 7890" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[@value='Uzbekistan']"
    And I click on element with xpath "//span[contains(text(),'Female')]"
    And I click on element with xpath "//span[contains(text(),'I allow to contact')]"
    And I type "1234 Nester Street" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//option[contains(text(),'Toyota')]"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I click on element with xpath "//input[@id='dateOfBirth']"
    Then element with xpath "//div[@class='ui-datepicker-title']" should be displayed
    And I click on element with xpath "//select[@class='ui-datepicker-year']"
    And I click on element with xpath "//option[@value='1981']"
    And I click on element with xpath "//a[contains(text(),'17')]"

  @predefined14
  Scenario: Verify password is not visible on the submitted form
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "123 456 7890" into element with xpath "//input[@name='phone']"
    When I type "mdnochilova@gmail.com" into element with xpath "//input[@name='email']"
    And I type "Dina1234" into element with xpath "//input[@id='password']"
    And I type "Dina1234" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[@value='Uzbekistan']"
    And I click on element with xpath "//span[contains(text(),'Female')]"
    And I click on element with xpath "//span[contains(text(),'I allow to contact')]"
    And I type "1234 Nester Street" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//option[contains(text(),'Toyota')]"
    And I click on element with xpath "//input[@id='dateOfBirth']"
    Then element with xpath "//div[@class='ui-datepicker-title']" should be displayed
    And I click on element with xpath "//select[@class='ui-datepicker-year']"
    And I click on element with xpath "//option[@value='1981']"
    And I click on element with xpath "//a[contains(text(),'17')]"
    Then I click on element with xpath "//button[@name='formSubmit']"
#    And element with xpath "//legend[contains(text(),'Submitted Application')]" should be displayed
    Then element with xpath "//b[contains(text(),'[entered]" should be displayed





      
   
  
  








