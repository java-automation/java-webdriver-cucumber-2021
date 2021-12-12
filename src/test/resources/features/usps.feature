@usps
  Feature: USPS scenarios

  @usps1
  Scenario: Validate ZIP code for Portnov Computer School
    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    And I click button Find
    And I wait result being loaded
    Then I validate "94022-1473" zip code exists in the result
#    And I go back to search form
    And I validate "94021" zip code exists in the result

  @usps2
  Scenario Outline: Calculate price
    Given I go to "usps" page
    When I go to Calculate Price page
    And I select "<Country>" with "<Type>" shape
    And I define "<Qnt>" quantity
    Then I calculate the price and validate cost is "<Total>"
    Examples:
      | Country                                                               | Type     | Qnt | Total |
      | Canada                                                                | Postcard | 2   | $2.60 |
      | United Kingdom (United Kingdom of Great Britain and Northern Ireland) | Postcard | 2   | $2.60 |

  Scenario: Verify location
    Given I go to "usps" page
    When I perform "Free Boxes" search
    And I set "Send" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required