@usps
  Feature: Usps scenarios
    @usps1
    Scenario: Validate zip code for address
      Given I go to "usps" page
      When I go to Lookup ZIP page by address
      And I fill out "119 Florence rd" street, "Branford" city, "CT" state
      Then I validate "06405" zip code exists in the result
# 4970 El Camino Real , Los Altos, CA, 94022
# 119 Florence rd, Branford, CT, 06405
# 4970 Main str, Branford, CT, 06405  // Negative => Whats te best way to handle ?
# 119 Florence rd, Branford, CT, 94022 // Negative
# 119 Broadwaysr, Branford, CT          // for validating Error messages