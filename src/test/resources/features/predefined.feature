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
    Then element with xpath "//input[@id='ybar-sbq']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='ybar-sbq']"
    Then I click on element with xpath "//input[@id='ybar-search']"
    Then I wait for element with xpath "//div[@id='results']" to be present
    Then element with xpath "//div[@id='results']" should contain text "Cucumber"

  @predefined3
  Scenario: Predefined steps for Bing
    Given I open url "https://www.bing.com/"
    Then I should see page title contains "Bing"
    Then element with xpath "//input[@id='sb_form_q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='sb_form_q']"
    And I click on element with xpath "//label[@id='search_icon']"
    Then I wait for element with xpath "//div[@id='b_content']" to be present
    Then element with xpath "//div[@id='b_content']" should contain text "Cucumber"

  @predefined4
  Scenario: Predefined steps for Gibiru
    Given I open url "https://gibiru.com/"
    Then I should see page title contains "Gibiru"
    And element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='q']"
    And I click on element with xpath "//button[@id='button-addon2']"
    Then I wait for element with xpath "//div[@class='gsc-table-result']" to be displayed
    Then element with xpath "//div[@class='gsc-wrapper']" should contain text "Cucumber"

  @predefined5
  Scenario: Predefined steps for DuckDuckGo
    Given I open url "https://duckduckgo.com/"
    Then I should see page title contains "DuckDuckGo"
    And element with xpath "//input[@id='search_form_input_homepage']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='search_form_input_homepage']"
    And I click on element with xpath "//input[@id='search_button_homepage']"
    Then I wait for element with xpath "//div[@class='results--main']" to be present
    Then element with xpath "//div[@class='results--main']" should contain text "Cucumber"
    
  @predefined6
  Scenario: Predefined steps for Swisscows
    Given I open url "https://swisscows.com/"
    Then I should see page title contains "Swisscows"
    And element with xpath "//input[@name='query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    And I click on element with xpath "//button[@class='search-submit']"
    Then I wait for element with xpath "//div[@class='web-results']" to be present
    And element with xpath "//div[@class='web-results']" should contain text "Cucumber"

  @predefined7
  Scenario: Predefined steps for Search Encrypt
    Given I open url "https://www.searchencrypt.com/"
    Then I should see page title contains "Search Encrypt"
    And element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//p[@class='web-result__description']" to be present
    And I wait for element with xpath "//section[@class='serp__results container']" to be displayed
    Then element with xpath "//section[@class='serp__results container']" should contain text "Cucumber"

  @predefined8
  Scenario: Predefined steps for Startpage
    Given I open url "https://www.startpage.com/"
    Then I should see page title contains "Startpage"
    And element with xpath "//input[@id='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='query']"
    And I click on element with xpath "//button[@class='search-form-home__button-desktop']"
    Then I wait for element with xpath "//div[@class='mainline-results--']" to be present
    And I wait for element with xpath "//p[@class='w-gl__description']/b" to be displayed
    And element with xpath "//div[@class='mainline-results--']" should contain text "Cucumber"

  @predefined9
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title as "Yandex"
    And element with xpath "//input[@id='text']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='text']"
    And I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//div[@class='main__top']" to be present

  @predefined10
  Scenario: Predefined for steps Boardreader
    Given I open url "https://boardreader.com/"
    Then I should see page title contains "Boardreader"
    And element with xpath "//input[@id='title-query']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@id='title-query']"
    And I click on element with xpath "//button[@id='title-submit']"
    Then I wait for element with xpath "//ul[@class='mdl-list']" to be present
    And I wait for element with xpath "//p[@class='text']" to be present
    And element with xpath "//ul[@class='mdl-list']" should contain text "Cucumber"

  @predefined11
  Scenario: Predefined steps for Ecosia
    Given I open url "https://www.ecosia.org/"
    Then I should see page title contains "Ecosia"
    And element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    And I click on element with xpath "//button[@data-test-id='search-form-submit']"
    Then I wait for element with xpath "//div[@class='container results']" to be present
    And element with xpath "//div[@class='container results']" should contain text "Cucumber"

  @predefined12
  Scenario: Validate responsive UI
    Given I open url "https://skryabin.com/market/quote.html"
    When I resize window to 1200 and 800
    Then element with xpath "//b[@id='location']" should be displayed
    And element with xpath "//b[@id='currentTime']" should be displayed
    When I resize window to 400 and 800
    Then element with xpath "//b[@id='location']" should not be displayed
    And element with xpath "//b[@id='currentTime']" should not be displayed

  @predefined13
  Scenario: Validate Username field min length
    Given I open url "https://skryabin.com/market/quote.html"
    And element with xpath "//label[@for='username']" should be present
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @predefined14
  Scenario: Verify "Email" field accepts valid emails only
    Given I open url "https://skryabin.com/market/quote.html"
    And element with xpath "//input[@name='email']" should be present
    When I type "yulia.kolesnyk@gmail.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should not be present
    When I clear element with xpath "//input[@name='email']"
    And I type "yulia@yahoo.com" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined15
  Scenario: Verify set of "Passwords" fields with valid data
    Given I open url "https://skryabin.com/market/quote.html"
    And element with xpath "//input[@id='password']" should be displayed
    And element with xpath "//input[@id='confirmPassword']" should be disabled
    When I type "MyPassword" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled
    When I type "MyPassword" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='confirmPassword-error']" should not be present
    Then element with xpath "//label[@id='password-error']" should not be present

  @predefined16
  Scenario: Verify "Name" field behavior after saving FN and LN
    Given I open url "https://skryabin.com/market/quote.html"
    And element with xpath "//input[@id='name']" should be displayed
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "Yulia" into element with xpath "//input[@id='firstName']"
    And I type "Kolesnyk" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Yulia Kolesnyk"

  @predefined17
  Scenario: Verify Accepting Private policy is required
    Given I open url "https://skryabin.com/market/quote.html"
    And element with xpath "//label[@class='required checkbox_radio']" should be displayed
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefined18
  Scenario: Non-required fields entering
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "333-456-8990" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[@value='Ukraine']"
    And I click on element with xpath "//input[@name='gender'][@value='female']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I click on element with xpath "//option[@value='Toyota']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I type "07/01/1991" into element with xpath "//input[@id='dateOfBirth']"

  @predefined19
  Scenario: Validate required data after form submission
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "NewUser" into element with xpath "//input[@name='username']"
    * I type "newemail@example.com" into element with xpath "//input[@name='email']"
    * I type "welcome" into element with xpath "//input[@name='password']"
    * I type "welcome" into element with xpath "//input[@name='confirmPassword']"
    * I click on element with xpath "//input[@name='name']"
    * I type "FirstName" into element with xpath "//input[@id='firstName']"
    * I type "LastName" into element with xpath "//input[@id='lastName']"
    * I click on element with xpath "//span[contains(text(),'Save')]"
    * I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    * I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='username']" should contain text "NewUser"
    And element with xpath "//b[@name='email']" should contain text "newemail@"
    And element with xpath "//b[@name='password']" should contain text "entered"
    And element with xpath "//b[@name='password']" should not contain text "welcome"
    And element with xpath "//b[@name='firstName']" should contain text "FirstName"
    And element with xpath "//b[@name='lastName']" should contain text "LastName"
    And element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
    
  @predefined20
  Scenario: Adding an item to the cart Target
    Given I open url "https://www.target.com/"
    When I type "shampoo" into element with xpath "//input[@id='search']"
    Then I wait for element with xpath "//button[@data-test='btnSearch']" to be displayed
    When I click on element with xpath "//button[@data-test='btnSearch']"
    Then I wait for element with xpath "//div[@data-test='product-list-container']" to be displayed
    When I click on element with xpath "(//div[@class='h-display-flex']/a)[1]"
    Then I wait for element with xpath "//div[@data-test='PDPFulfillmentSection']" to be displayed
    When I click on element with xpath "//button[@data-test='shipItButton']"
    Then I wait for element with xpath "//div[@data-test='addToCartModalImage']" to be displayed
    When I click on element with xpath "//button[@data-test='addToCartModalViewCartCheckout']"
    Then I wait for element with xpath "//div[@data-test='cart-item-groups']" to be displayed
    And element with xpath "//div[@data-test='cartItem-title']/div" should be displayed
    And element with xpath "//div[@data-test='cartItem-title']/div" should contain text "Shampoo"

    



    

    
    
    


    


