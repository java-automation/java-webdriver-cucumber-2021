@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Validate responsive UI of quote page
    Given I open url "https://skryabin.com/market/quote.html"
    When I resize window to 400 and 800
    Then element with xpath "//b[@id='location']" should not be displayed
    When I resize window to 1200 and 800
    Then element with xpath "//b[@id='location']" should be displayed

  @predefined2
  Scenario: Validate min length username
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    Then element with xpath "//label[@id='username-error']" should contain text "2 char"
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed
    
  @predefined3
  Scenario: Validate email field behaviour
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "abc" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    When I type "@d" into element with xpath "//input[@name='email']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined4
  Scenario: Fill out and validate password set of fields
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//input[@id='confirmPassword']" should be disabled
    When I type "a" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//input[@name='username']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled
    And element with xpath "//label[@id='password-error']" should be displayed
    When I type "bcde" into element with xpath "//input[@id='password']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled
    And element with xpath "//label[@id='password-error']" should not be displayed
    
  @predefined5
  Scenario: Validate that text field name should should have attribute "value" as "John Doe"
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "John" into element with xpath "//input[@id='firstName']"
    And I type "Adam" into element with xpath "//input[@id='middleName']"
    And I type "Doe" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    Then element with xpath "//div[@id='nameDialog']" should not be displayed
    And element with xpath "//input[@id='name']" should have attribute "value" as "John Adam Doe"

  @predefined6
  Scenario: Validate that Accepting Privacy Policy is required to submit the form, then check the field
    Given I open url "https://skryabin.com/market/quote.html"
    Then element with xpath "//label[@for='agreedToPrivacyPolicy']" should not be present
    When I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@for='agreedToPrivacyPolicy']" should be present
    And element with xpath "//label[@for='agreedToPrivacyPolicy']" should be displayed
    When I click on element using JavaScript with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//label[@for='agreedToPrivacyPolicy']" should not be displayed

  @predefined7
  Scenario: Try entering the following non-required fields in the order: Phone Number -> Country of Origin ->
  -> Gender -> Allowed to Contact? -> Address -> Car Make -> 3rd party agreement acceptance -> Date of Birth
    Given I open url "https://skryabin.com/market/quote.html"
    Then I type "777777777" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//select/option[@value='USA']"
    And I click on element with xpath "//input[@value='male']"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "California" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//select/option[@value='Toyota']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    And I accept alert
    And I type "12/31/2021" into element with xpath "//input[@id='dateOfBirth']"

  @predefined8
  Scenario:  Submit the form and verify the data.
  Validate that after form submission entered fields values are present on the page.
  Validate that password is not displayed on the page.
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "John" into element with xpath "//input[@id='firstName']"
    And I type "Adam" into element with xpath "//input[@id='middleName']"
    And I type "Doe" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[contains(text(),'Save')]"
    And I type "johndoe" into element with xpath "//input[@name='username']"
    And I type "john@doe" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//b[@name='password']" should contain text "[entered]"
    And element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
    And element with xpath "//b[@name='firstName']" should contain text "John"
    And element with xpath "//b[@name='lastName']" should contain text "Doe"
    And element with xpath "//b[@name='middleName']" should contain text "Adam"
    And element with xpath "//b[@name='name']" should contain text "John Adam Doe"
    And element with xpath "//b[@name='username']" should contain text "johndoe"
    And element with xpath "//b[@name='email']" should contain text "john@doe"
