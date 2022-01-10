@usps
  Feature: Usps scenarios

    @usps1 @usps2 @usps3 @usps4 @usps5
    Scenario Outline: Phone number of the nearest Mail Pickup
      Given I go to <page> page
      When I navigate to <headingLink> heading link
      And I search for location <location>
      Then I verify closest location phone number is <result>
      Examples:
        | page   | headingLink | location                                 | result         |
        | "usps" | "Locations" | "4970 El Camino Real 110, Los Altos, CA" | "800-275-8777" |