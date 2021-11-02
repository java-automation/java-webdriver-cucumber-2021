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
    Then element with xpath "//div//*[contains(@id,'search-box')]//input[@type='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//div//*[contains(@id,'search-box')]//input[@type='text']"
    Then I click on element using JavaScript with xpath "(//input[@id='ybar-search'])[1]"
    Then I wait for element with xpath "//*[@id='web']" to be present
    And I wait for element with xpath "//*[@id='web']/ol/li[1]/div" to be present
    Then element with xpath "//*[@id='web']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//div[@id='b_content']" to be present
    And I wait for element with xpath "//li[@class='b_algo'][last()]" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

  @predefined4
    #Forbidden to search in Gibiru for Google Fiber customers
  Scenario: Predefined steps for Gibiru Google Fiber Forbidden
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Forbidden"
    Then element with xpath "//p[1]" should be present
    Then element with xpath "//p[1]" should contain text "You don't have permission to access this resource."

  @predefined4_1
  Scenario: Predefined steps for Gibiru T-Mobile
    Given I open url "https://gibiru.com"
    Then I should see page title contains "Gibiru"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior-Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']/i"
    Then I wait for element with xpath "//div[@id='web-results']" to be present
    And  I wait for element with xpath "//div[@class='gsc-webResult gsc-result'][last()]" to be present
    Then element with xpath "//div[@id='web-results']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com"
    Then I should see page title contains "DuckDuckGo"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//input[@type='submit']"
    Then I wait for element with xpath "//div[@id='links']" to be present
    And I wait for element with xpath "//div[contains(@class,'result results_links_deep')][last()]" to be present
    Then element with xpath "//div[@id='links']" should contain text "Cucumber"

  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com"
    Then I should see page title contains "Swisscows"
    Then element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    Then I click on element using JavaScript with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    # And I wait for element with xpath "//article[@class='item item--web'][last()]" to be present
    Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com"
    Then I should see page title contains "Search Encrypt"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//section[@class='serp__results container']" to be present
    And I wait for element with xpath "//section/div[@class='serp__web-result__container'][last()]" to be present
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com"
    Then I should see page title contains "Startpage"
    Then element with xpath "//form[@id='search']//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//form[@id='search']//input[@name='query']"
    Then I click on element using JavaScript with xpath "//form[@id='search']//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='mainline-results--']" to be present
    And I wait for element with xpath "//div[@class='w-gl__result w-gl__desktop__result'][last()]" to be present
    Then element with xpath "//section[@class='w-gl w-gl--desktop w-gl--']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://www.yandex.com"
    Then I should see page title as "Yandex"
    Then element with xpath "//span[@class='input__box']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@id='text']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//*[@id='search-result']" to be present
    And I wait for element with xpath "//li[@class='serp-item desktop-card'][last()]" to be present
    Then element with xpath "//*[@id='search-result']" should contain text "Behavior Driven Development"

  @predefined10
  Scenario: Predefined steps for Boardreader
    Given I open url "https://boardreader.com"
    Then I should see page title contains "Boardreader"
    Then element with xpath "//*[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//*[@id='title-query']"
    Then I click on element using JavaScript with xpath "//*[@id='title-submit']"
    Then I wait for element with xpath "//ul[@class='mdl-list']/li[last()]" to be present
    Then element with xpath "//ul[@class='mdl-list']" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org"
    Then I should see page title contains "Ecosia"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='result js-result card-mobile'][last()]" to be present
    Then element with xpath "//div[@class='card-desktop card-web']" should contain text "Cucumber"
