@usps
  Feature: Usps scenario

    @usps1
    Scenario Outline: : Validate zip code for address
      Given I go to "usps" page
      When I go to Lookup ZIP page by address
      And I wait for 2 sec
      And I fill out "<Street Address>" street, "<City>" city, "<State>" state
      Then I validate "<Zip Code>" zip code exists in the result
      Examples:
        |Street Address  | City   | State | Zip Code |
        | 1109 Alomar Way| Belmont| CA    |  94002 |

    @usps2
    Scenario: Calculate price
      Given I go to "usps" page
      When I go to Calculate Price Page
      And I select "Canada" with "Postcard" shape
      And I define "2" quantity
      Then I calculate the price and validate cost is "$2.60"

    @usps3
    Scenario: Verify location
      Given I go to "usps" page
      When I perform "Free Boxes" search
      And I set "Send" in filters
      Then I verify that "7" results found
      When I select "Priority Mail | USPS" in results
      And I click "Ship Now" button
      Then I validate that Sign In is required

    Scenario: Quadcopters delivery
      Given I go to "usps" page
      When I go to "Help" tab
      And I perform "Quadcopters delivery" help search
      Then I verify that no results of "Quadcopters delivery" available in help search

    Scenario: Phone number of the nearest Mail Pickup
      Given I go to "usps" page
      When I navigate to "Locations" heading link
      And I search for location "4970 El Camino Real 110, Los Altos, CA"
      And I wait for 2 sec
      Then I verify closest location phone number is "800-275-8777"