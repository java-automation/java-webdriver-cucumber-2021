@quote_oop

  Feature: Quote feature
    Scenario: Quote end to end OOP
      Given I go to the "quote" page oop
#      And I print logs to the console OOP
      When I fill out "user" required fields oop
  And I wait for 4 sec
#      When I fill out optional fields OOP
#      And I submit a form OOP
      Then I verify "user" the required fields OOP