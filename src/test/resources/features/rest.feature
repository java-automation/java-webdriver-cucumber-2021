@rest
Feature: REST API

  @rest1
  Scenario: REST API CRUD
    Given I work with rest api

  @rest2
  Scenario: GET Positions REST API CRUD
    Given I get positions with rest api

  @rest3
  Scenario: GET Candidates REST API CRUD
    Given I get candidates with rest api

  @rest4
  Scenario: REST API Candidate CRUD #Implement similar candidates entity CRUD. the trick there is that you'll need to make email always unique for the candidate.
    Given I create new candidate rest api
