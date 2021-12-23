@converters
Feature: Unit converters scenarios

  @UnitConverter1
  Scenario Outline: Unit Converters Outline
    Given I go to "converter" page
    When I choose <sTab> tab
    And I set from <sFromUnit> to <sToUnit> units
    Then I set <sValue> to From field and check result is <sResult>
    Examples:
      | sTab          | sFromUnit    | sToUnit     | sValue | sResult |
      | "Temperature" | "Fahrenheit" | "Celsius"   | "54"   | "12.2"  |
      | "Weight"      | "Pound"      | "Kilogram"  | "170"  | "77"    |
      | "Length"      | "Mile"       | "Kilometer" | "50"   | "80.4"  |