@rest
Feature: REST API

  @rest1
  Scenario: CRUD operations on Career app entities
    And I perform CRUD operations with positions
    And I perform CRUD operations with candidates

  @rest2
  Scenario: REST API Position CRUD operations
    Given I login via REST API as "recruiter"
    When  I create via REST API "leetProgrammer" position
    Then  I verify via REST API new "leetProgrammer" position is in the list
    When  I update via REST API new "leetProgrammer" position
    Then  I verify via REST API new "leetProgrammer" position is updated
    When  I delete via REST API new position
    Then  I verify via REST API new position is deleted
    *     I logout via REST API

  @rest3
  Scenario: REST API Candidate CRUD operations
    Given I login via REST API as "recruiter"
    When  I create via REST API "sdet" candidate
    Then  I verify via REST API new "sdet" candidate is in the list
    #When  I add via REST API "pdf" resume to a new candidate
    #Then  I verify via REST API that "pdf" resume has been added
    When  I update via REST API new "sdet" candidate
    Then  I verify via REST API new "sdet" candidate is updated
    When  I delete via REST API new candidate
    Then  I verify via REST API new candidate is deleted
    *     I logout via REST API