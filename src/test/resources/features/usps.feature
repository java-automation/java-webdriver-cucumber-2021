@usps
Feature: Usps scenarios

  @usps1
  Scenario: Validate zip code for address
    **ZIP** is an acronym for Zone Improvement Plan.

    Given I go to "usps" page
    When I go to Lookup ZIP page by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result

  @usps2
  Scenario: Validate zip code for random address
    
    Given I go to "usps" page
    When I go to Lookup ZIP page by address using different path
    And I fill out random street, city, state
      | street              | city        | state  | zip   |
      | 4970 El Camino Real | Los Altos   | CA     | 94022 |
      | Main street         | Tracy       | CA     | 95391 |
#      | [blank]             | Watsonville | CA     | 95076 |
    Then I validate "test" zip code exists in the result

  @usps3
  Scenario: Validate zip code for small screen size

    Given I go to "usps" page
# Firefox: message on the blue background from being on the left jumps below the picture
#    And I resize window to 991 and 600
# Chrome: message on the blue background from being on the left jumps below the picture
#    And I resize window to 1035 and 600
# Firefox: top menu navigation menu disappears
#    And I resize window to 959 and 600
# Chrome: top menu navigation menu disappears
    And I resize window to 1002 and 600
    When I go to Lookup ZIP page by address on small screen
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state
    Then I validate "94022" zip code exists in the result