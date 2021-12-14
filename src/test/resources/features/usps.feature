@usps

Feature: Usps scenarios


  @usps1
  Scenario: Validate zip code for address
    Given I go to "usps" page
    And I wait for 1 sec
    When I go to Lookup ZIP page by address
    And I fill out "1313 S Michigan" street, "Chicago" city, "IL" state
    Then I validate "60605" zip code exists in the result
    And  I wait for 3 sec


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
