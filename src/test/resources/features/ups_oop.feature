@ups_oop
  Feature: UPS scenarios OOP
    @ups
    Scenario: E2E UPS Scenario OOP
      Given I go to "ups" page oop
      And I go to Create a Shipment oop
      And I wait for 2 sec
      When I fill out origin shipment fields oop
      And I submit the shipment form oop
      Then I verify origin shipment fields submitted oop

      When I fill out destination shipment fields oop
      When I submit the shipment form oop
      And I "confirm" residential address oop
      And I wait for 1 sec
      And I set "My Packaging" type and weight oop
      When I submit the shipment form oop
      And I wait for 2 sec
      Then I verify total charges appear oop
      And I select "Cheapest" delivery option oop
      And I submit the shipment form oop
      And I set description and check "Saturday Delivery" type if available oop
      And I check "Deliver only to receiver address" oop
      Then I verify total charges changed oop
      When I submit the shipment form oop
      And I select "PayPal" payment type oop
      And I submit the shipment form to review oop
      Then I review all recorded details on the review page oop
      And I cancel the shipment form oop
      Then I verify shipment form is reset oop