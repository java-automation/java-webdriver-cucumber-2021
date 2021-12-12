@usps
  Feature: USPS Scenarios
    @usps1
    Scenario: Validate zipcode by address 
      Given I go to "usps" page
      When I go to lookup zip page by address
      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      Then I validate "94022" zip code exists in the result

    @usps2
    Scenario: Calculate price
      Given I go to "usps" page
      When I go to Calculate Price Page
