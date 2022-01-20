@USPS
  Feature: USPS Feature


    Scenario: Validate ZIP code for Portnov Computer School
      Given I go to "usps" page
      When I go to Lookup ZIP page by address
      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
      Then I validate "94022" zip code exists in the result




    Scenario: Calculate price
      Given I go to "usps" page
      When I go to Calculate Price Page
      And I select "Canada" with "Postcard" shape
      And I define "2" quantity
      Then I calculate the price and validate cost is "$2.60"

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





    Scenario: Every door direct mail
      Given I go to "usps" page
      When I go to "Every Door Direct Mail" under "Business"
      And I search for "4970 El Camino Real, Los Altos, CA 94022"
      And I choose view as "Table" on the map
      When I select all in the table
      And I close modal window
      And I wait for 5 sec
      Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary
