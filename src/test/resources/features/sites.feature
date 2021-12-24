@sites
Feature: Using different sites to make calculations and conversions

  @sites1
  Scenario Outline: Convert temperature and check result at scale
    Given I go to "converter" page
    When I click on "temperature"
    And I set from "fahrenheit" to "celsius"
    And I set <value> in From field value
    Then I verify <expectedValue> in To field value at scale
    Examples:
      | value    | expectedValue  |
      | "32"     | "0"            |
      | "54"     | "12.2"         |
      | "0"      | "-17.7"        |
      | "1"      | "-17.2"        |
      | "96.8"   | "36"           |
      | "100"    | "37.77"        |
      | "100.4"  | "38"           |
      | "78"     | "25.555555556" |

  @sites2
  Scenario Outline: Convert weight
    Given I go to "converter" page
    When I click on "weight"
    And I set from "pound" to "kilogram"
    And I set <pounds> in From field value
    Then I verify <kilograms> in To field value
    Examples:
      |                   pounds | kilograms     |
      |                    "100" | "45.3592"     |
      |                     "-4" | "-1.814368"   |
      |                      "0" | "0"           |
      | "9999999999999999999999" | "4.53592E+21" |

  @sites3
  Scenario: Convert weight and check result at scale
    Given I go to "converter" page
    When I click on "weight"
    And I set from "pound" to "kilogram"
    And I set "170" in From field value
    Then I verify "77" in To field value at scale

  @sites4
  Scenario: Convert length
    Given I go to "converter" page
    When I click on "length"
    And I set from "mile" to "kilometer"
    And I set "+1.0" in From field value
    Then I verify "1.60935" in To field value

  @sites5
  Scenario Outline: Convert length and and check result at scale
    Given I go to "converter" page
    When I click on "length"
    And I set from "mile" to "kilometer"
    And I set <value> in From field value
    Then I verify <expectedValue> in To field value at scale
    Examples:
      | value    | expectedValue |
      | "50"     | "80.4"        |
      | "0.01"   | "0.016"       |
      | "0.001"  | "0.001"       |

  @sites6
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