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
    Given I open url "https://www.yahoo.com"
    Then I should see page title contains "Yahoo"
    Then element with xpath "//input[@id='ybar-sbq']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='ybar-sbq']"
    Then I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//*[@id='web']" to be present
    Then element with xpath "//*[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element with xpath "//label[@for='sb_form_go']"
    Then I wait for element with xpath "//*[@id='b_results']" to be present
    Then element with xpath "//*[@id='b_results']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiri
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//*[@class='gsc-expansionArea']" to be displayed
    Then element with xpath "//*[@id='web-results']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    Then I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//*[@id='links']" to be present
    Then element with xpath "//*[@id='links']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscow
    Given I open url "https://swisscows.com"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    Then I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//*[@class='web-results']" to be present
    Then element with xpath "//*[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[contains(@class,'search-bar__submit')]"
    Then I wait for element with xpath "//*[contains(@class,'serp__web-result__container')]" to be displayed
    Then element with xpath "//section[contains(@class,'serp__results')]" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    Then I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    Then I wait for element with xpath "//*[contains(@class,'w-gl--desktop')]" to be displayed
    Then element with xpath "//*[contains(@class,'w-gl--desktop')]" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com"
    Then I should see page title contains "Yandex"
    Then element with xpath "//*[contains(@class,'input__control')]" should be displayed
    When I type "Behavior Driven Development" into element with xpath "//*[contains(@class,'input__control')]"
    Then I click on element with xpath "//button[contains(@class,'button_theme_search')]"
    Then I wait for element with xpath "//*[contains(@class,'main__content')]" to be present
    Then element with xpath "//*[contains(@class,'main__content')]" should contain text "Cucumber"

  @predefined10
  Scenario: Predefined steps for Broadreader
    Given I open url "https://boardreader.com"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    And I click on element with xpath "//button[@id='title-submit']"
    And I wait for element with xpath "//li[contains(@class,'mdl-list__item')]" to be displayed
    Then element with xpath "//ul[contains(@class,'mdl-list')]" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@name='q']" should be displayed
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "//button[contains(@class,'search-form__submit')]"
    Then I wait for element with xpath "//*[contains(@class,'mainline-results')]" to be present
    Then element with xpath "//*[contains(@class,'mainline-results')]" should contain text "Cucumber"
