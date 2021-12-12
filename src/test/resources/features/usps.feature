@usps
  Feature: Usps scenario

    @usps1
    Scenario: Validate zip code for address
      Given I go to "usps" page
      When I go to Lookup ZIP page by address
      And I wait for 2 sec
      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      Then I validate "94022" zip code exists in the result
