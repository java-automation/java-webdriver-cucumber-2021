@careers
  Feature: Careers scenario

    @careers1
    Scenario: Recruiter removes position
      Given I go to "careers" page and print details
      And I login as "recruiter"
      Then I verify "recruiter" login
      When I remove "Principal Automation Engineer" position
      And I verify "Principal Automation Engineer" position is removed