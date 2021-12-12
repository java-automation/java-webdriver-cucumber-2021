@usps
  Feature: Usps scenarios
    @usps1
    Scenario: Validate zip code for address
      Given I go to "usps" page
      When I go to Lookup ZIP page by address
      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      Then I validate "94022" zip code exists in the result

# 4970 El Camino Real , Los Altos, CA, 94022
# 119 Florence rd, Branford, CT, 06405
# 4970 Main str, Branford, CT, 06405  // Negative => Whats te best way to handle ?
# 119 Florence rd, Branford, CT, 94022 // Negative
# 119 Broadwaysr, Branford, CT          // for validating Error messages

    @usps2
    Scenario: Calculate price
      Given I go to "usps" page
      When I go to Calculate Price Page
      And I select "Canada" with "Postcard" shape
      And I define "2" quantity
      Then I calculate the price and validate cost is "$2.60"
      # 2.60 , $3


    @usps3
    Scenario: Verify location
      Given I go to "usps" page
      When I perform "Free Boxes" search
      And I set "Send" in filters
      Then I verify that "7" results found
      When I select "Priority Mail | USPS" in results
      And I click "Ship Now" button
      Then I validate that Sign In is required
