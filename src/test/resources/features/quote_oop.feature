@quote_oop
  Feature: Quote Feature OOP

    @quote1
    Scenario: Quote end to end required fields oop
      Given I go to "quote" page and print details oop
      When I fill out "admin" required fields oop
      And I submit the page oop
      And I wait for 2 seconds
      Then I verify "admin" required fields oop
      And I wait for 2 seconds