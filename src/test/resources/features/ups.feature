@ups
Feature: UPS end to end scenarios

  Background:
    Given I go to UPS page

  @ups
  #valid US profiles: Richard Blank/Julie Harris
  #valid non-US profiles: Mary Johansson
  #residential address: confirm/deny
  Scenario: E2E UPS Scenario
    When I go to Create a Shipment
    *    I fill out origin shipment fields with "Julie Harris" profile
    *    I submit the shipment form
    Then I verify origin shipment fields submitted
    When I fill out destination shipment fields with "Richard Blank" profile
    *    I "confirm" residential address for non-US country
    *    I submit the shipment form
    *    I "confirm" residential address for US
    *    I set packaging type as "UPS Express Box - Small" and weight as 2 lbs
    *    I wait for 1 sec
    *    I submit the shipment form
    *    I wait for 1 sec

#    Then I verify total charges appear
#    And I select cheapest delivery option
#    And I submit the shipment form
#    And I set description and check Saturday Delivery type if available
#    And I check Deliver only to receiver's address
#    Then I verify total charges changed
#    When I submit the shipment form
#    And I select Paypal payment type
#    And I submit the shipment form
#    Then I review all recorded details on the review page
#    And I cancel the shipment form
#    Then I verify shipment form is reset