@d16_hw_Java
Feature: Java feature

  @d16_hw_Java1
  Scenario: Function that finds 2 max numbers in the array
    Given I find two max numbers in the array

  @d16_hw_Java2
  Scenario: Function that determines palindrome
    Given I check if "Kayak" is the palindrome

  @d16_hw_Java3
  Scenario: Function that finds if array contains duplicates
    Given I check if an Arraycontains duplicates

  @d16_hw_Java4
  Scenario: Function that finds 2 max numbers in the array; v2
    Given I write three lines code to find two max numbers in the array

  @d16_hw_Java5
  Scenario: Calculate price
    Given I open "usps" page
    And I wait & check for 1 sec
    When I go to Calculate Price Page
    And I select Canada with Postcard shape
    And I define "2" quantity
    #And I wait & check for 1 sec
    Then I calculate the price and validate cost is "$2.60"
    And I wait & check for 2 sec

  @d16_hw_Java6
  Scenario: Verify location
    Given I open "usps" page
    And I wait & check for 1 sec
    When I perform "Free Boxes" search
    And I set "Send" in filters
    Then I verify that "7" results found
    When I select "Priority Mail | USPS" in results
    And I click "Ship Now" button
    Then I validate that Sign In is required



