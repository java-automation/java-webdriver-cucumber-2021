@usps
  Feature: Usps scenarios
    @usps1
    Scenario: Validate zip code for address
      Given I go to "USPS" page
      When I go to Lookup ZIP page by address
      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      And I wait for 5 sec
      Then I validate "94022" zip code exists in the result