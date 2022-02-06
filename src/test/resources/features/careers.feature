@careers
  Feature: Careers scenario

    @careers1
    Scenario: Recruiter removes position
      Given I go to "careers" page and print details
      And I wait for 2 seconds
      And I login as "recruiter"
      And I wait for 2 seconds
      Then I verify "recruiter" login
      When I remove "Principal Automation Engineer" position
      And I wait for 2 seconds
      And I verify "Principal Automation Engineer" position is removed

    @careers2
    Scenario: Recruiter creates position
      Given I go to "careers" page and print details
      And I wait for 2 seconds
      And I login as "recruiter"
      And I wait for 2 seconds
      Then I verify "recruiter" login
      When I create new position
      Then I verify new position is created
      When I remove new position
      And I wait for 2 seconds
      And I verify new position is removed