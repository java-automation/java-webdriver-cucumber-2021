@quote
  Feature: Quote Feature

    @quote1
    Scenario: Quote end to end required fields
      Given I go to "quote" page and print details
      And I print logs to the console
      When I fill out required fields
      And I wait for 2 seconds
      And I submit the page
      And I wait for 2 seconds
      Then I verify the required fields

    @quote2
    Scenario: getDriver().navigate() exercise
      Given I go to "google" page and print details
      And I go to "quote" page and print details
      And I go back and forward, then refresh the page
      And I change resolution to "phone"
      And I change resolution to "desktop"

    @quote3
    Scenario: Quote end to end optional fields
      Given I go to "Quote" page and print details
      And I fill out required fields
      And I fill out optional fields
      And I submit the page
      Then I verify the required fields
      And I verify the optional fields

    @quote4
    Scenario: Use Actions to select multiple options in dropdown
      Given I go to "Quote" page and print details
      And I fill out required fields
      And I select multiple options with Actions
      And I wait for 5 seconds
      And I submit the page
      And I wait for 5 seconds
      And I verify selected options were displayed

    @quote5
    Scenario: Use Select to select multiple options in dropdown
      Given I go to "Quote" page and print details
      And I fill out required fields
      And I select multiple options with Select
      And I wait for 5 seconds
      And I submit the page
      And I wait for 5 seconds
      And I verify selected options were displayed

#      TODO: maintain scenarios:
#       quote1: ComparisonFailure: expected:<[[entered]]> but was:<[testPass2021-11-10]>
#       quote3: NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//input[@id='contactPersonName']"}