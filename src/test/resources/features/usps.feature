@usps
  Feature: Usps scenarios
    @usps1
#      Scenario: Validate ZIP code for Portnov Computer School
#       Given I go to "usps" page
#       When I go to lookup ZIP page by address
#       And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
#       Then I validate "94022" zip code exists in the result

    @usps2
#      Scenario: Calculate price
#       Given I go to "usps" page
#       When I go to Calculate Price Page
#       And I select "Canada" with "Postcard" shape
#       And I define "2" quantity
#       Then I calculate the price and validate cost is "$2.60"

    @usps3
#      Scenario: Verify location
#       Given I go to "usps" page
#       When I perform "Free Boxes" search
#       And I set "Send" in filters
#       Then I verify that "7" results found
#       When I select "Priority Mail | USPS" in results
#       And I click "Ship Now" button
#       Then I validate that Sign In is required

    @usps4
#    Scenario: Quadcopters delivery
#      Given I go to "usps" page
#      When I go to "Help" link
#      And I wait for 2 sec
#      And I perform "Quadcopters delivery" help search
#      Then I verify that no results of "Quadcopters delivery" available in help search

    @usps5
    Scenario: Phone number of the nearest Mail Pickup
      Given I go to "usps" page
      When I navigate to "Locations" heading link
      And I search for location "4970 El Camino Real 110, Los Altos, CA"
      Then I verify closest location phone number is "800-275-8777"