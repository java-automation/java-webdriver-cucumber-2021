@rest
Feature: REST API

  @rest1
  Scenario: REST API CRUD
    Given I work with rest api

  @rest2
  Scenario: Position REST API CRUD Operations
    Given I login via REST API as "recruiter"
    When I create via REST API "automation" position
    Then I verify via REST API new "automation" position is in the list
    When I update via REST API new "automation" position
    Then I verify via REST API new "automation" position is updated
    When I delete via REST API new position
    Then I verify via REST API new position is deleted
    And I logout via REST API

  @rest3
  Scenario: REST API Candidates CRUD
    Given I login via REST API as "recruiter"
    When I create via REST API "sdet" candidate
    Then I verify via REST API new "sdet" candidate is in the list
    When I add via REST API "pdf" resume to a new candidate
    Then I verify via REST API that "pdf" resume has been added
    When I update via REST API new "sdet" candidate
    Then I verify via REST API new "sdet" candidate is updated
    When I delete via REST API new candidate
    Then I verify via REST API new candidate is deleted
    And I logout via REST API