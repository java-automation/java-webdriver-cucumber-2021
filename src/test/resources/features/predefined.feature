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
  Scenario: scenarios for https://www.yahoo.com
    Given I open url "https://www.yahoo.com"
    Then I should see page title contains "Yahoo"
    Then element with xpath "//input[@id='ybar-sbq']" should be present
    When I type "BDD" into element with xpath "//input[@id='ybar-sbq']"
    Then I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//div[@id='results']" to be present
    Then element with xpath "//div[@id='results']" should contain text "Behavior-driven development"
  
  @predefined3 
  Scenario: scenarios for https://www.bing.com
    Given I open url "https://www.bing.com"
    Then I should see page title contains "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "BDD" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Behavior-driven development"
  
  @predefined4 
  Scenario: scenario for https://gibiru.com
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@id='q']" should be present
    When I type "BDD" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@id='web-results']" to be present
    Then element with xpath "//div[@id='web-results']" should contain text "Behavior-driven development"
  
  @predefined5 
  Scenario: scenario for https://duckduckgo.com
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "BDD" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Behavior-driven development"
  
  @predefined6 
  Scenario: scenario for https://swisscows.com
    Given I open url "https://swisscows.com"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@class='input-search']" should be present
    When I type "BDD" into element with xpath "//input[@class='input-search']"
    Then I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Behavior-driven development"
  
  @predefined7 
  Scenario: scenario for https://www.searchencrypt.com
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//input[@class='search-bar__search']" should be present
    When I type "BDD" into element with xpath "//input[@class='search-bar__search']"
    Then I click on element with xpath "//button[@class='search-bar__submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Behavior-driven development"

  @predefined8 
  Scenario: scenario for https://www.startpage.com
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "BDD" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    Then I wait for element with xpath "//div[@class='show-results']" to be present
    Then I wait for 1 sec
    Then element with xpath "//div[@class='show-results']" should contain text "Behavior-driven development"
  
  @predefined9 
  Scenario: scenario for https://www.yandex.com
    Given I open url "https://www.yandex.com"
    Then I should see page title contains "Yandex"
    Then element with xpath "//input[@id='text']" should be present
    When I type "BDD" into element with xpath "//input[@id='text']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='main__content']" to be present
    Then element with xpath "//div[@class='main__content']" should contain text "Behavior-driven development"
  
  @predefined10 
  Scenario: scenario for https://boardreader.com
    Given I open url "https://boardreader.com"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "BDD" into element with xpath "//input[@id='title-query']"
    Then I click on element with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
    Then element with xpath "//ul[@class='mdl-list']" should contain text "BDD"
  
  @predefined11 
  Scenario: scenario for https://www.ecosia.org
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@type='search']" should be present
    When I type "BDD" into element with xpath "//input[@type='search']"
    Then I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results']" to be present
    Then element with xpath "//div[@class='mainline-results']" should contain text "Behavior-driven development"