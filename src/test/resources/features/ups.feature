@ups
Feature: UPS end to end scenarios

  Background:
    Given I go to UPS page

  @ups
  #valid profiles: "Mary Johansson"/"Richard Blank"
  Scenario: E2E UPS Scenario
    When I go to Create a Shipment
    *    I fill out origin shipment fields with "Mary Johansson" profile
    And I wait for 5 sec
    *    I submit the shipment form
    Then I verify origin shipment fields submitted
    And I wait for 2 sec
#    When I fill out destination shipment fields with "test2" profile
#    When I submit the shipment form
#    And I "confirm" residential address
#    And I set packaging type and weight
#    When I submit the shipment form
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