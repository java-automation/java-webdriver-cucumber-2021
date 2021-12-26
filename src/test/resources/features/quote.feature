@quote
  Feature: Quote Feature

    @quote1
    Scenario: Quote end to end
      Given I go to "quote" page
      And I print logs to the console
      When I fill out required fields
      And I submit the page
      And I wait for 2 sec
      And I submit the page
      Then I verify the required fields

    @quote2:
    Scenario: Quote switchTo
      Given I go to "quote" page
      And I click on Related Documents
      And I verify "Document 2" is in the list
      And I "Accept" third party agreement
      And I enter "Richard Roe" as contact person with a phone "123456789"


