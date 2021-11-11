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
    Then element with xpath "//input[@id='ybar-sbq']" should be displayed
    When I type "Behavoir Driven Development" into element with xpath "//input[@id='ybar-sbq']"
    Then I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//div[@id='web']" to be present
    Then element with xpath "//div[@id='web']" should contain text "Cucumber"
    
  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title as "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    Then I click on element with xpath "//label[@for='sb_form_go']"
    Then I wait for element with xpath "//ol[@id='b_results']" to be present
    Then element with xpath "//ol[@id='b_results']" should contain text "Cucumber"

   @predefined4
   Scenario: Predefined steps for Gibiru.com
     Given I open url "https://gibiru.com/"
     Then I should see page title contains "Gibiru"
     Then element with xpath "//input[@id='q']" should be displayed
     When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
     Then I click on element with xpath "//button[@type='submit' and ./i[contains(@class,'fa-search')]]"
     Then I wait for element with xpath "//div[@id='web-results']" to be present
     Then element with xpath "//div[@id='web-results']" should contain text "Cucumber"

   @predefined5
   Scenario: Predefined steps for Duckduckgo.com
     Given I open url "https://duckduckgo.com/"
     Then I should see page title contains "DuckDuckGo"
     Then element with xpath "//input[@id='search_form_input_homepage']" should be displayed
     When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
     Then I click on element with xpath "//input[@id='search_button_homepage']"
     Then I wait for element with xpath "//div[@class='results--main']" to be present
     Then element with xpath "//div[@class='results--main']" should contain text "Cucumber"

   @predefined6
   Scenario: Predefined steps for Swisscows.com
     Given I open url "https://swisscows.com/"
     Then I should see page title contains "Swisscows"
     Then element with xpath "//input[@name='query']" should be displayed
     When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
     Then I click on element with xpath "//button[@class='search-submit']"
     Then I wait for element with xpath "//div[@class='web-results']" to be present
     Then element with xpath "//div[@class='web-results']" should contain text "Cucumber"

   @predefined7
   Scenario: Predefined steps for Searchencrypt.com
     Given I open url "https://searchencrypt.com/home"
     Then I should see page title contains "Search Encrypt"
     Then element with xpath "//div[@id='autosuggest']/input" should be displayed
     When I type "Behavior Driven Development" into element with xpath "//div[@id='autosuggest']/input"
     Then I click on element with xpath "//button[@class='search-bar__submit']"
     Then I wait for element with xpath "//section[contains(@class,'serp__results')]" to be present
     Then element with xpath "//section[contains(@class,'serp__results')]" should contain text "Cucumber"

   @predefined8
   Scenario: Predefined steps for Startpage.com
     Given I open url "https://startpage.com/"
     Then I should see page title contains "Private Search Engine"
     Then element with xpath "//input[@id='q']" should be displayed
     When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
     Then I click on element with xpath "//form[@id='search']//button[contains(@aria-label,'Search')]"
     Then I wait for element with xpath "//h3[normalize-space()='Web results']/.." to be present
     Then element with xpath "//h3[normalize-space()='Web results']/.." should contain text "Cucumber"

   @predefined9
   Scenario: Predefined steps for Yandex.com
     Given I open url "https://yandex.com/"
     Then I should see page title contains "Yandex"
     Then element with xpath "//input[@aria-label='Request']" should be displayed
     When I type "Behavior Driven Development" into element with xpath "//input[@aria-label='Request']"
     Then I click on element with xpath "//span[normalize-space()='Search']/.."
     Then I wait for element with xpath "//ul[@id='search-result']" to be present
     Then element with xpath "//ul[@id='search-result']" should contain text "Cucumber"

   @predefined10
   Scenario: Predefined steps for Boardreader.com
     Given I open url "https://boardreader.com/"
     Then I should see page title contains "Boardreader"
     Then element with xpath "//input[@id='title-query']" should be displayed
     When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
     Then I click on element with xpath "//button[@id='title-submit']"
     Then I wait for element with xpath "//div[contains(@class,'searchResultsBlock')]" to be present
     Then element with xpath "//div[contains(@class,'searchResultsBlock')]" should contain text "Cucumber"

   @predefined11
   Scenario: Predefined steps for Ecosia.org
     Given I open url "https://www.ecosia.org/"
     Then I should see page title contains "Ecosia"
     Then element with xpath "//input[@name='q']" should be displayed
     When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
     Then I click on element with xpath "//button[@aria-label='Submit']"
     Then I wait for element with xpath "//div[@class='mainline-results']" to be present
     Then element with xpath "//div[@class='mainline-results']" should contain text "Cucumber"
     
   @predefined12
   Scenario: Validate responsive UI of quote page
     Given I open url "https://skryabin.com/market/quote.html"
     And I resize window to 400 and 700
     Then element with xpath "//b[@id='location']" should not be displayed
     And I resize window to 1200 and 700
     Then element with xpath "//b[@id='location']" should be displayed

   @predefined13
   Scenario: Validate min length username
     Given I open url "https://skryabin.com/market/quote.html"
     When I type "a" into element with xpath "//input[@name='username']"
     And I click on element with xpath "//button[@id='formSubmit']"
     Then element with xpath "//label[@id='username-error']" should be displayed
     Then element with xpath "//label[@id='username-error']" should contain text "2 char"
     When I type "b" into element with xpath "//input[@name='username']"
     Then element with xpath "//label[@id='username-error']" should not be displayed

   @predifined14
   Scenario: Validate email field acceptance
     Given  I open url "https://skryabin.com/market/quote.html"
     When I type "@outlook.com" into element with xpath "//input[@name='email']"
     And I click on element with xpath "//button[@id='formSubmit']"
     Then element with xpath "//label[@id='email-error']" should be displayed
     And element with xpath "//label[@id='email-error']" should contain text "enter a valid email"
     When I click on element with xpath "//button[@id='formReset']"
     And I type "odintsov@outlook.com" into element with xpath "//input[@name='email']"
     And I click on element with xpath "//button[@id='formSubmit']"
     Then element with xpath "//label[@id='email-error']" should not be displayed

   @predefined15
   Scenario: Validate set of fields Password
     Given  I open url "https://skryabin.com/market/quote.html"
     Then element with xpath "//input[@id='password']" should have attribute "value" as ""
     And element with xpath "//input[@id='confirmPassword']" should be disabled
     When I type "a" into element with xpath "//input[@id='password']"
     Then element with xpath "//input[@id='confirmPassword']" should be enabled
     When I click on element with xpath "//button[@id='formReset']"
     And I click on element with xpath "//button[@id='formRefresh']"
     Then element with xpath "//input[@id='password']" should have attribute "value" as ""
     And element with xpath "//input[@id='confirmPassword']" should be disabled

   @predefined16
   Scenario: Validate Name field behavior
     Given I open url "https://skryabin.com/market/quote.html"
     Then element with xpath "//div[@aria-describedby='nameDialog']" should not be displayed
     When I click on element with xpath "//input[@id='name']"
     Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
     When I type "Dmitry" into element with xpath "//input[@id='firstName']"
     And I type "P" into element with xpath "//input[@id='middleName']"
     And I type "Odintsov" into element with xpath "//input[@id='lastName']"
     And I click on element with xpath "//button[normalize-space()='Save']"
     Then element with xpath "//input[@id='name']" should have attribute "value" as "Dmitry P Odintsov"

  @predefined17
  Scenario: Validate Privacy Policy checkbox
    Given I open url "https://skryabin.com/market/quote.html"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//input[@name='agreedToPrivacyPolicy']/following-sibling::label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//input[@name='agreedToPrivacyPolicy']/following-sibling::label[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefined18
  Scenario: Validate non-required fields in order
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "89124536665" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[@value='Russia']"
    And I click on element with xpath "//input[@name='gender' and @value='male']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "Some Address" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select[@name='carMake']/option[@value='Toyota']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I type "01/30/1980" into element with xpath "//input[@id='dateOfBirth']"

  @predefined19
  Scenario: Submit the form and verify the data
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@aria-describedby='nameDialog']" should be displayed
    When I type "Dmitry" into element with xpath "//input[@id='firstName']"
    And I type "P" into element with xpath "//input[@id='middleName']"
    And I type "Odintsov" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//button[normalize-space()='Save']"
    And I type "dodintsov" into element with xpath "//input[@name='username']"
    And I type "odintsov@outlook.com" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='name' and normalize-space()='Dmitry P Odintsov']" should be present
    And element with xpath "//b[@name='username' and normalize-space()='dodintsov']" should be present
    And element with xpath "//b[@name='email' and normalize-space()='odintsov@outlook.com']" should be present
    And element with xpath "//b[@name='agreedToPrivacyPolicy' and normalize-space()='true']" should be present
    And element with xpath "//b[@name='password' and normalize-space()='[entered]']" should be present
    And element with xpath "//*[normalize-space()='12345']" should not be present

  @predefined20
  Scenario: Check date of birth
    Given I open url "https://skryabin.com/market/quote.html"
#    And I click on element with xpath "//input[@id='dateOfBirth']"
#    And I click on element with xpath "//select[@*='selectMonth']/option[11]"
#    And I click on element with xpath "//select[@*'selectYear']/option[@value='1899']"
#    And I click on element with xpath "//td[@*='selectDay']/a[text()='7']"
    And I type "11/07/1899" into element with xpath "//input[@id='dateOfBirth']"
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "11/07/1899"
    Then element with xpath "//input[@id='dateOfBirth']" should contain text "11/07/1899"