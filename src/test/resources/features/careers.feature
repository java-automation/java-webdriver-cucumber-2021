@careers
Feature: Scenarios for careers web-app

  Background:
    Given I go to "careers" page OOP

  @careers1
  Scenario: Recruiter removes position
    When I login as "recruiter"
    Then I verify "recruiter" login
    When I remove "Principal Automation Engineer" position
    Then I verify "Principal Automation Engineer" position is removed
    And  I wait for 1 sec

  @careers2
  Scenario: Recruiter creates position
    When I login as "recruiter"
    Then I verify "recruiter" login
    When I create new position
    Then I verify new position is created
    And  I wait for 1 sec
    When I remove new position
    Then I verify new position is removed
    And  I wait for 1 sec