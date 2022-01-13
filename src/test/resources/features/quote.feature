@quote
Feature: Fill out all Quote fields and verify that submitted fields saved correctly
  Try to cover all the fields on our Quote form with WebDriver functions we learned.

  @quote1
  Scenario: Fill out all the fields in Quote form and
  Verify that submitted fields saved correctly
    Given I open url "https://skryabin.com/market/quote.html"
    And I maximize window
    #name field
    And I wait for element with xpath "//input[@id='name']" to be present
    And element with xpath "//input[@id='name']" should have attribute "value" as ""
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[contains(@class,'ui-dialog ui-widget')]" should be displayed
    When I click on element with xpath "//input[@id='firstName']"
    Then I type "Irina" into element with xpath "//input[@id='firstName']"
    Then I type "Aleksandrovna" into element with xpath "//input[@id='middleName']"
    Then I type "Gavrilova" into element with xpath "//input[@id='lastName']"
    Then I click on element with xpath "//span[@class='ui-button-text'][text()='Save']"
    Then element with xpath "//div[contains(@class,'ui-dialog ui-widget')]" should not be displayed
    Then element with xpath "//input[@id='name']" should have attribute "value" as "Irina Aleksandrovna Gavrilova"
    #Username field
    Then I type "gavrilova.irina" into element with xpath "//input[@name='username']"
    #Email field
    Then I type "passioninsoftwaretesting@gmail.com" into element with xpath "//input[@name='email']"
    #password and confirmPassword fields
    Then I type "p1234" into element with xpath "//input[@name='password']"
    Then I type "p1234" into element with xpath "//input[@name='confirmPassword']"

    #checkbox "agreedToPrivacyPolicy"
    When I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    Then element with xpath "//input[@name='agreedToPrivacyPolicy']" should be selected
    #non-required fields
    Then I type "512111111" into element with xpath "//input[@name='phone']"
    When I click on element with xpath "//select[@name='countryOfOrigin']/option[@value='Russia']"
    Then element with xpath "//select[@name='countryOfOrigin']" should have attribute "value" as "Russia"
    Then I click on element with xpath "//input[@name='gender'][@value='female']"
    Then element with xpath "//input[@name='allowedToContact']" should not be selected
    Then I click on element with xpath "//input[@name='allowedToContact']"
    And element with xpath "//input[@name='allowedToContact']" should be selected
    When I type "here is my address" into element with xpath "//textarea[@id='address']"
    Then I click on element with xpath "//select[@name='carMake']/option[@value='Other']"
    Then I click on element with xpath "//button[@id='thirdPartyButton']"
    Then I accept alert
    And element with xpath "//span[@id='thirdPartyResponseMessage']" should be displayed
    Then I click on element with xpath "//input[@id='dateOfBirth']"
    Then I click on element with xpath "//select[@class='ui-datepicker-month']/option[contains(text(),'Jan')]"
    Then I click on element with xpath "//select[@class='ui-datepicker-year']/option[@value='2000']"
    Then I click on element with xpath "(//td[@data-handler='selectDay']/a)[25]"
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "01/25/2000"

    #submit
    When I click on element with xpath "//button[@type='submit']"
    Then I wait for element with xpath "//legend[@class='applicationResult'][text()='Submitted Application']" to be present


    #verify name
    Then element with xpath "//b[@name='name']" should have text as "Irina Aleksandrovna Gavrilova"
    And element with xpath "//b[@name='firstName']" should have text as "Irina"
    And element with xpath "//b[@name='middleName']" should have text as "Aleksandrovna"
    And element with xpath "//b[@name='lastName']" should have text as "Gavrilova"
    #verify username
    Then element with xpath "//b[@name='username']" should have text as "gavrilova.irina"
    #verify email
    Then element with xpath "//b[@name='email']" should have text as "passioninsoftwaretesting@gmail.com"
    #verify password is not displayed
    Then element with xpath "//b[@name='password']" should have text as "[entered]"
    #verify agreed to Privacy Policy
    Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should have text as "true"
    #verify Phone
    Then element with xpath "//b[@name='phone']" should have text as "512111111"
    #verify Country Of Origin
    Then element with xpath "//b[@name='countryOfOrigin']" should have text as "Russia"
  #verify Gender
    Then element with xpath "//b[@name='gender']" should have text as "female"
  #verify Allowed To Contact
    Then element with xpath "//b[@name='allowedToContact']" should have text as "true"
  #verify Address
    Then element with xpath "//b[@name='address']" should have text as "here is my address"
  #verify Car Make
    Then element with xpath "//b[@name='carMake']" should have text as "Other"
  #verify Date Of Birth
    Then element with xpath "//b[@name='dateOfBirth']" should have text as "01/25/2000"
  #verify Third Party Agreement
    Then element with xpath "//b[@name='thirdPartyAgreement']" should have text as "accepted"

  @quote2
  Scenario: I go to "quote" page and fill out required fields
    Given I go to "quote" page
    And I print logs to the console
    When I fill out required fields
    And I wait for 2 sec
    And I submit the page
    Then I verify the required fields

  @quote3
  Scenario: I go to "quote" page and fill out required and optional fields
    Given I go to "quote" page
    And I print logs to the console
    When I fill out required fields
    And I fill out optional fields
    And I wait for 2 sec
    And I submit the page
    Then I verify the required fields
    And I verify the optional fields

  @quote4
  Scenario: Quote end to end
    Given I go to "quote" page
    And I print logs to the console
    When I fill out required fields1
    And I submit the page1
    And I wait for 2 sec
    Then I verify the required fields1

  @quote5
  Scenario: Quote switchTo
    Given I go to "quote" page
    And I click on Related Documents1
    And I verify "Document 2" is in the list1
    And I "accept" third party agreement1
    And I enter "Richard Roe" as contact person with a phone "123456789" one

  @quote6
  Scenario: By using Actions and key press (CTRL or COMMAND + mouse) manipulate multi-select in quote page. Select few options from it. Then try it with Select class.
    Given I go to "quote" page
    Then I fill out required fields
    Then I manipulate multi-select using Actions and key press
    And I submit the page
    Then I verify the required fields
    And I verify the multi-select field
  @quote7
  Scenario:  Manipulate multi-select in quote page with Select class.
    Given I go to "quote" page
    Then I fill out required fields
    Then I manipulate multi-select with Select class
    And I submit the page
    Then I verify the required fields
    And I verify the multi-select field

  @quote8
  Scenario: Playing with Actions class and WebElement.sendkeys()
    Given I go to "quote" page
    Then I fill out required fields Actions sendkeys
    And I submit the page
    Then I verify the required fields

