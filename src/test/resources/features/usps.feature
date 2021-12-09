@usps

Feature: Usps scenarios


  @usps1
  Scenario: Validate zip code for address
    Given I go to "usps" page
    And I wait for 1 sec
    When I go to Lookup ZIP page by address
    And I fill out "1313 S Michigan" street, "Chicago" city, "IL" state
    Then I validate "60605" zip code exists in the result
