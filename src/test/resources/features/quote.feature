@quote
  Feature: Quote Feature

    @quote1
    Scenario: Quote end to end
      Given I go to "quote" page
      And I print logs to the console
      When I fill out optional fields
      And I wait for 4 sec
      And I fill out required fields
      And I wait for 4 sec
      And I submit the page
      And I wait for 4 sec
      Then I verify the required fields
      And I wait for 4 sec
      # In Quote StepDefs

    @quote2 
    Scenario: Navigate between pages
      Given I go to "quote" page
      And I go to "yahoo" page
      And I navigate back
      And I navigate forward
      And I refresh page
      # In Generic StepDefs
  
    @quote3
    Scenario: Change resolution
      Given I go to "quote" page
      And I change resolution to "phone"
      And I wait for 3 sec
      And I change resolution to "desktop"
      And I wait for 3 sec
      # In generic StepDefs
#    https://www.selenium.dev/documentation/
#    https://www.w3.org/TR/webdriver/
#    https://www.selenium.dev/selenium/docs/api/rb/Selenium/WebDriver.html
