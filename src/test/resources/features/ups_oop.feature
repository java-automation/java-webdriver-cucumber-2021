@ups_oop

  Feature: UPS OOP features

    @usps1
    Scenario: E2E UPS Scenario
      Given I go to "ups" main page
      And I go to Create a Shipment
      When I fill out origin shipment fields
      And I submit the shipment form
      Then I verify origin shipment fields submitted
      And I wait for 5 sec