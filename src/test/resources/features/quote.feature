@quote
  Feature: Quote Feature

    @quote1
    Scenario: Quote end to end
      Given I go to "quote" page
      And I print logs to the console
      When I fill out required fields
      And I submit the page
      And I wait for 5 sec
      Then I verify the required fields

    @quote2:
    Scenario: Quote switchTo
      Given I go to "quote" page
      And I click on Related Documents
      And I verify "Document 2" is in the list
      And I "Accept" third party agreement
      And I enter "Richard Roe" as contact person with a phone "123456789"

    @quote3:
    Scenario: Multi select car brands
      Given I go to "quote" page
      And I select "Ford Toyota Other" with Select
      And I select "Ford BMW" with actions
      And I wait for 3 sec


