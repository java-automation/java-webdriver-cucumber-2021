@quote_oop

Feature: Quote Feature OOP

  @quote1
  Scenario: Quote end to end oop
    Given I go to "quote" page oop
    When I fill out required fields oop
    And I wait for 5 sec
    And I submit the page oop
    Then I verify the required fields oop
    And I wait for 2 sec