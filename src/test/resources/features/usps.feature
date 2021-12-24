@usps
Feature: Usps scenarios

  @usps1
  Scenario: Validate zip code for address
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  Rule: Available navigation paths at different device sizes should allow lookup of zip code by address
        Chrome width 1035px, Firefox width 991px
        message on the blue banner background jumps from being on the left to below the picture
        Chrome width 1002px, Firefox 959px
        top menu navigation disappears
        Chrome 811px, Firefox 767px
        choices on the 'Lookup ZIP code' page loose description and stack up
#    For exploration purposes also trying variations of input values on the lookup form:
#    spelling mistakes, capital letters, non-existing street that is considered as company abbreviation
#    'Mac' as street in Minneapolis finds METRO AIRPORT COMM #6040 MAC (incorrect address),
#    "101 Main" street omitting East or West with results based on building number since Main st also exists
#    Randomness is purely for the purpose of trying data tables

    @usps2
    Scenario: Validate zip code for random address via Send menu mouseover
      Given I go to "usps" page
      When I go to Lookup ZIP page by address via Send menu mouseover
      And I fill out random street, city, state
        | street              | city        | state  | zip   |
        | 4970 El Camino Real | Los Altos   | CA     | 94022 |
        | Main street         | Tracy       | CA     | 95391 |
        | 101 Main            | Louisville  | KY     | 40202 |
        | Main                | Louisville  | KY     | 40243 |
      Then I validate "test" zip code exists in the result

    @usps3
    Scenario: Validate zip code for address at small screen size via tile in a grid when main navigation bar disappears
      Given I go to "usps" page
      And I resize window to 959 and 600
      When I go to Lookup ZIP page by address on small screen
      And I fill out "7150 HUMPHREY D," street, "MNNEAPOLS" city, "MN" state
      Then I validate "55450" zip code exists in the result

    @usps4
    Scenario: Validate zip code for address at small screen size via hamburger menu when lookup choices stack up
      Given I go to "usps" page
      And I resize window to 767 and 600
      And I go to Lookup ZIP page by address on small screen via hamburger menu and Quick Tools
      And I fill out "Mac" street, "Minneapolis" city, "MN" state
      Then I validate "55450" zip code exists in the result

  Rule:

    @usps5
    Scenario: Calculate price
      Given I go to "usps" page
      When I go to Calculate Price Page
      And I select "Canada" with "Postcard" shape
      And I define "2" quantity
      Then I calculate the price and validate cost is "$2.60"

    @usps6
    Scenario: Verify location
      Given I go to "usps" page
      When I perform "Free Boxes" search
      And I set "Send" in filters
      Then I verify that "7" results found
      When I select "Priority Mail | USPS" in results
      And I click "Ship Now" button
      Then I validate that Sign In is required

    @usps7
    Scenario: Reproduce popup preview for doc and pdf files covers pagination
      Given I go to "usps" page
      When I perform "Free Boxes" search
      And I set "USPS Corporate" in filters
      Then I verify that "314" results found
      Then I click last page number in pagination and verify moving
      Then I click last page number in pagination and verify moving
      Then I click last page number in pagination and verify moving

    @usps8
    Scenario: Every door direct mail
      Given I go to "usps" page
      When I go to "Every Door Direct Mail" under "Business"
      And I search for "4970 El Camino Real, Los Altos, CA 94022"
      And I choose view as "Table" on the map
      When I select all in the table
      And I close modal window
      Then I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary