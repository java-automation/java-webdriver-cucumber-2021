@quote
Feature: Quote page feature

 @quote1
 Scenario: Quote end to end
   Given I go to the "quote" page
   Then I go to the "google" page
   And I go back and forward, then refreshed the page

 @quote2
 Scenario: Quote end to end, homework day 08
  Given I go to the "quote" page
  And I print logs to the console
  When I fill out required fields
  And I submit the page
  And I wait for 2 sec
  Then I verify the required fields

  @quote3
  Scenario: Quote optional fields, homework day 09
    Given I go to the "quote" page
    And I fill out required fields
    When I fill out DOB as 11 and month "May" and year 1988
    Then I fill out optional fields
    And I submit the page
    Then I verify the required fields
    And I verify the optional fields

