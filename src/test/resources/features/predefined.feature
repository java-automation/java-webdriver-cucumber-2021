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

  @predefined0
  Scenario: Another Java
    Given I say "My Message on Cucumber"
    And I hello world

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
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    When I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    Then I wait for element with xpath "//p[@class='w-gl__description']" to be displayed
    Then element with xpath "//div[@class='mainline-results mainline-results__web']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    When I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined5
  Scenario: Validate responsive UI of quote page
    Given I open url "https://skryabin.com/market/quote.html"
    When I resize window to 400 and 800
    Then element with xpath "//b[@id='location']" should not be displayed
    When I resize window to 1200 and 800
    Then element with xpath "//b[@id='location']" should be displayed

  @predefined6
  Scenario: Validate min length username
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    Then element with xpath "//label[@id='username-error']" should contain text "2 char"
    And I clear element with xpath "//input[@name='username']"
    When I type "ab" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

#    And element with xpath {string} should contain text "John Doe"
#    And element with xpath {string} should have attribute "value" as "John Doe"

  @predefined7
  Scenario: Quote form end to end scenario - required fields
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "jdoe" into element with xpath "//input[@name='username']"
    And I type "john.doe@example.com" into element with xpath "//input[@name='email']"
    And I type "welcome" into element with xpath "//input[@id='password']"
    And I type "welcome" into element with xpath "//input[@id='confirmPassword']"

    When I click on element with xpath "//input[@id='name']"
    And I type "John" into element with xpath "//input[@id='firstName']"
    And I type "Doe" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "John Doe"

    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    
    Then element with xpath "//b[@name='password']" should not have text as "welcome"

    Then I wait for element with xpath "//div[@id='asdf']" to be present

    Then element with xpath "//div[@id='quotePageResult']" should contain text "jdoe"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "john.doe@example.com"
    Then element with xpath "//div[@id='quotePageResult']" should contain text "John Doe"


  @predefined8
  Scenario: Covered element
    Given I open url "https://www.ups.com/us/en/global.page"
    When I resize window to 1024 and 800
    And I click on element with xpath "//a[@data-map='ups-svg-mideast']//span"
    And I wait for 1 sec
    And I click on element using JavaScript with xpath "//a[@data-map='ups-svg-africa']//span"
    And I wait for 5 sec
