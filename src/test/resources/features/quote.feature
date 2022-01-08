@quote
  Feature: Quote Feature

    @quote1
    Scenario: Quote end to end
      Given I go to the "quote" page
#      And I print logs to the console
      When I fill out required fields
      When I fill out optional fields
      And I wait for 5 sec
      And I submit a form
#      And I wait for 5 sec
#      Then I verify the required fields

    @quite2
    Scenario: Multiselect car brands
      Given I go to the "quote" page
      And I select "Ford BMW" with Select
      And I select "Ford BMW" with Actions
      And I wait for 5 sec