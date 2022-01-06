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

    @usps4
    Scenario: Every door direct mail
      Given I go to "usps" page
      When I go to "Every Door Direct Mail" under "Business"
      And I search for "4970 El Camino Real, Los Altos, CA 94022"
      And I choose view as "Table" on the map
      And I wait for 5 sec
      When I select all in the table
      And I close modal window
      Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary
      And I wait for 2 sec

    @usps5
    Scenario: Verify calculator result
      Given I go to "calculator" page
      When I navigate to "Auto Loan Calculator"
      And I clear all calculator fields
      And I calculate
      Then I verify "Please provide a positive auto price." calculator error
      Then I verify "Please provide a positive interest value." calculator error
      And I enter "25000" price, "60" months, "4.5" interest, "5000" downpayment, "0" trade-in, "California" state, "7" percent tax, "300" fees
      And I calculate
      Then I verify monthly pay is "$372.86"

    @usps6
    Scenario: Quadcopters delivery
      Given I go to "usps" page
      When I navigate to "Help" tab
      And I perform "Quadcopters delivery" help search
      Then I verify that no results of "Quadcopters delivery" available in help search

    @usps7
    Scenario: Phone number of the nearest Mail Pickup
      Given I go to "usps" page
      When I navigate to "Locations" heading link
      And I search for location "4970 El Camino Real 110, Los Altos, CA"
      And I wait for 2 sec
      Then I verify closest location phone number is "650-960-0817"