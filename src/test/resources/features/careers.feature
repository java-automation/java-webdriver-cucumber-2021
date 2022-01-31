@careers
Feature: Scenarios for careers web-app

  Background:
    Given I go to "careers" page OOP

  @careers1
  Scenario: Recruiter removes position
    And I wait for 3 sec
    When I login as "recruiter"
    And I wait for 3 sec
    Then I verify "recruiter" login
    And I wait for 3 sec
    When I remove "Principal Automation Engineer" position
    And I wait for 3 sec
    Then I verify "Principal Automation Engineer" position is removed
    And I wait for 3 sec