@ups

Feature: Ups scenarios

    #Home_work_01/23/22

    @ups1
    Scenario: E2E UPS scenario
    Given I go to "ups" page
    And I go to Create a Shipment
    When I fill out origin shipment fields
    And I submit the shipment form
    And I wait for 2 sec
  #  Then I verify origin shipment fields submitted
    And I wait for 3 sec
    When I fill out destination shipment fields
    When I submit the shipment form
    And I "confirm" residential address
    And I set packaging type and weight
    When I submit the shipment form
    And I wait for 2 sec
 #   Then I verify total charges appear
    And I select cheapest delivery option
    And I wait for 2 sec   
    And I submit the shipment form
  #  And I set description and check Saturday Delivery type if available
  #  And I check Deliver only to receiver's address
  #  Then I verify total charges changed
  #  When I submit the shipment form
  #  And I select Paypal payment type
  #  And I submit the shipment form
  #  Then I review all recorded details on the review page
  #  And I cancel the shipment form
  #  Then I verify shipment form is reset