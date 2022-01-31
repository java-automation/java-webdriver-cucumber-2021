@usps
  Feature: Usps scenarios
    @usps1
    Scenario Outline: Validate zip code for address
      Given I go to "USPS" page
      When I go to Lookup ZIP page by address
      And I fill out "<address>" street, "<city>" city, "<state>" state
#      And I wait for 1 second
      Then I validate "<zip>" zip code exists in the result
      Examples:
        | address                 | city          | state | zip   |
        | 4970 El Camino Real     | Los Altos     | CA    | 94022 |
        | 11400 Space Center Blvd | Houston       | TX    | 77059 |
        | 1156 San Ysidro Dr      | Beverly Hills | CA    | 90210 |

#    @usps01
#    Scenario: Validate zip code for address
#      Given I go to "USPS" page
#      When I go to Lookup ZIP page by address
#      And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
##      And I wait for 1 second
#      Then I validate "94022" zip code exists in the result


    @usps2
    Scenario: Calculate price
      Given I go to "USPS" page
      When I go to Calculate Price page
      And I select "Canada" with "Postcard"
      And I define "2" quantity
      Then I calculate the price and validate the cost is "$2.60"

    @usps3
    Scenario: Verify location
      Given I go to "USPS" page
      When I perform "Free Boxes" search
      And I set "Send" in filters
      Then I verify that "7" results found
      When I select "Priority Mail | USPS" in results
      And I click "Ship Now" button
      And I wait for 2 sec
      Then I validate that Sign in is required

      @usps4
      Scenario: Every door direct mail
        Given I go to "USPS" page
        When I go to "Every Door Direct Mail" under "Business"
        And I search for "4970 El Camino Real, Los Altos, CA 94022"
        And I choose view as "Table" on the map
        When I select all in the table
        And I close modal window
        Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary

      @usps5
      Scenario: Quadcopters delivery
        Given I go to "usps" page
        When I go to "Help" tab
#        And I perform "Quadcopters delivery" help search
#        Then I verify that no results of "Quadcopters delivery" available in help search

      @usps6
      Scenario: Phone number of the nearest Mail Pickup
        Given I go to "usps" page
        When I navigate to "Locations" heading link
        And I search for location "4970 El Camino Real 110, Los Altos, CA"
        Then I verify closest location phone number is "800-275-8777"



      @ups
      Scenario: E2E UPS Scenario
        Given I go to "ups" page
        And I go to Create a Shipment
        And I wait for 2 sec
        And I close the cookie window
        When I fill out origin shipment fields
        And I wait for 2 sec
        And I submit the shipment form
        Then I verify origin shipment fields submitted
        When I fill out destination shipment fields
        When I submit the shipment form
        And I "confirm" residential address
        And I wait for 2 sec
        And I set "My Packaging" type and weight
        When I submit the shipment form
        Then I verify "total charges" appear
        And I select "Cheapest" delivery option
        And I submit the shipment form
        And I set description and check "Saturday Delivery" type if available
        And I check "Deliver only to receiver address"
        Then I verify total charges changed
        When I submit the shipment form
        And I wait for 2 sec
        And I select "PayPal" payment type
        And I submit the shipment form to review
        And I wait for 10 sec
        Then I review all recorded details on the review page
        And I cancel the shipment form
        Then I verify shipment form is reset











