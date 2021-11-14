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
  Scenario: Validate responsive UI of quote page
    Given I open url "https://skryabin.com/market/quote.html"
    When I resize window to 400 and 800
    And I wait for 5 sec
    Then element with xpath "//b[@id='location']" should not be displayed
    When I resize window to 1200 and 800
    And I wait for 5 sec
    Then element with xpath "//b[@id='location']" should be displayed

  @predefined3
  Scenario: Validatr min lenght username as 2 chars
    Given I open url "https://skryabin.com/market/quote.html"
    And I wait for 1 sec
    When I type "a" into element with xpath "//input[@name='username']"
    And I wait for 1 sec
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should be displayed
    And I wait for 1 sec
    Then element with xpath "//label[@id='username-error']" should contain text "2 char"
    When I type "1" into element with xpath "//input[@name='username']"
    And I wait for 1 sec
    And I click on element with xpath "//button[@id='formSubmit']"
    And I wait for 3 sec
    Then element with xpath "//label[@id='username-error']" should not be displayed

  @predefined4
  Scenario: Validate that email field accepts only valid emai
    Given I open url "https://skryabin.com/market/quote.html"
    When  I type "nick2gmail.com" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I wait for 1 sec
    And I clear element with xpath "//input[@name='email']"
    And I wait for 1 sec
    When  I type "nick2@gmail.com" into element with xpath "//input[@name='email']"
    And I wait for 1 sec
    And I click on element with xpath "//button[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @predefined5
  Scenario: Validate that Confirm Password is disabled if Password field is empty
    Given I open url "https://skryabin.com/market/quote.html"
    And I wait for 1 sec
    When I type "a" into element with xpath "//input[@id='password']"
    And I wait for 1 sec
    And I mouse over element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//input[@id='confirmPassword']" should be enabled
    And I wait for 1 sec
    When I clear element with xpath "//input[@id='password']"
    And I wait for 1 sec
    When  I mouse over element with xpath "//input[@id='confirmPassword']"
    And I wait for 1 sec
    Then element with xpath "//input[@id='confirmPassword']" should be disabled

  @predefined6
  Scenario: Verify that upon clicking inside of Name field popup dialog appears, then check name concatenation
    Given I open url "https://skryabin.com/market/quote.html"
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//body/div[3]" should be displayed
    When I type "John" into element with xpath "//input[@id='firstName']"
    And I type "Abby" into element with xpath "//input[@id='middleName']"
    And I type "Smith" into element with xpath "//input[@id='lastName']"
    And I wait for 1 sec
    And I click on element with xpath "//span[text()='Save']"
    And I wait for 1 sec
 #  Then element with xpath "//input[@id='name']" should have text as "John Abby Smith"
 #  Then element with xpath "//input[@ng-model='formData.name']" should contain text "John"
 #  Then element with xpath "//input[@id='name']" should contain text "John"
    Then I wait for element with xpath "//input[@value='John Abby Smith']" to be present

  @predefined7
  Scenario: Validate that Accepting Privacy Policy is required to submit the form, then check the field.
    Given I open url "https://skryabin.com/market/quote.html"
    And I wait for 1 sec
    When I type "JS1" into element with xpath "//input[@name='username']"
    And I wait for 1 sec
    And I click on element with xpath "//button[@id='formSubmit']"
    And I wait for 1 sec
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed
    And I wait for 1 sec
    When I click on element with xpath "(//input[@type='checkbox'])[2]"
    And I wait for 1 sec
#   Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be present
    Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should not be displayed

  @predefined8
  Scenario: Entering non-required fields in the order:PN,CoO,G,AtC,A,CM,3PA,DoB
    Given I open url "https://skryabin.com/market/quote.html"
    When I type "7863031111" into element with xpath "//input[@name='phone']"
    And I click on element with xpath "//select[@name='countryOfOrigin']"
    And I click on element with xpath "//option[@value='USA']"
    And I click on element with xpath "(//input[@name='gender'])[1]"
    And I click on element with xpath "//input[@name='allowedToContact']"
    And I type "830 Stewart Dr, CA" into element with xpath "//textarea[@id='address']"
    And I click on element with xpath "//option[@value='BMW']"
    And I click on element with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert
    Then element with xpath "//span[@id='thirdPartyResponseMessage']" should be displayed
    And I wait for 3 sec
    When I type "04/06/1980" into element with xpath "//input[@id='dateOfBirth']"
    And I wait for 3 sec