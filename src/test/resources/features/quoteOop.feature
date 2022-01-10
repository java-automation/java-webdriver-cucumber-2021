@quote_oop
Feature: Quote page maintenance OOP

  @quote_oop1
  Scenario: Quote end to end oop
    Given I go to "quote" page oop
    When I fill out "user" required fields oop
    And I submit the page oop
    Then I verify "user" required fields oop
    And I wait for 2 sec