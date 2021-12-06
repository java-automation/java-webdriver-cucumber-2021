@schedule
Feature: Purpose to find intersection between schedules

  @schedule
  Scenario: Create HashMap(s) with time as a key and value {0,1}
    Given I create timeList
    Then I create empty schedule
    Then I create full schedule
    Then I create HashMap schedule1
    And I create HashMap schedule2
    And I create HashMap schedule3
    And I create HashMap schedule4
    And I create HashMap schedule5
    And I create HashMap schedule6
    And I create HashMap schedule7
    And I create HashMap schedule8
    And I create HashMap schedule9
    Then I compare two schedules
    And I compare all schedules
