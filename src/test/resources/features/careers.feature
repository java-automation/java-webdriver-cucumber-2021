Feature: Careers

  @careers1
  Scenario: Recruiter removes position
    Given I go to "careers" page oop

    And I login as "recruiter"
    Then I verify "recruiter" login
    When I remove "Principal Automation Engineer" position
    And I verify "Principal Automation Engineer" position is removed

  @careers2
  Scenario: Recruiter creates position
    Given I go to "careers" page oop
    And I login as "recruiter"
    Then I verify "recruiter" login
    When I create new position
    Then I verify new position is created
    When I remove new position
    And I verify new position is removed
    And I wait for 2 sec