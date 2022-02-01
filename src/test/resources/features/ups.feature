@ups
  Feature: UPS scenarios

    @ups1
    Scenario: E2E UPS Scenario
      Given I go to "ups" page and print details
      And I go to Create a Shipment
      And I wait for 7 sec
      When I fill out origin shipment fields
      And I wait for 2 sec
      And I submit the shipment form
      And I wait for 2 sec
      Then I verify origin shipment fields submitted
      And I wait for 2 sec
      When I fill out destination shipment fields
      And I wait for 2 sec
      When I submit the shipment form
      And I wait for 5 sec
      And I "confirm" residential address
      And I wait for 3 sec
      And I set packaging type and weight
      And I wait for 2 sec
      When I submit the shipment form
      And I wait for 3 sec
      Then I verify total charges appear
      And I wait for 3 sec
      And I select cheapest delivery option
      And I wait for 3 sec
      And I submit the shipment form
      And I wait for 3 sec
      And I set description and check Saturday Delivery type if available
      And I wait for 2 sec
      And I check Deliver only to receiver's address
      And I wait for 2 sec
      Then I verify total charges changed
      And I wait for 2 sec
      When I submit the shipment form
      And I wait for 5 sec
      And I select "Paypal" payment type
      And I wait for 2 sec
      And I submit the shipment form
      And I wait for 3 sec
      Then I review all recorded details on the review page
      And I wait for 2 sec
      And I cancel the shipment form
      Then I verify shipment form is reset