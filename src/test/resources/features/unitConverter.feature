@uc
Feature: Unit converter scenarios

  @uc1
  Scenario Template: Convert between units of measure
    Given I go to "unit converter" page
    When  I choose to measure <category>
    *     I choose to convert from <fromUnit> to <toUnit>
    Then  I verify that <fromValue> is converted to <toValue>

    Examples:
      | category      | fromUnit     | toUnit      | fromValue | toValue |
      | "Temperature" | "Fahrenheit" | "Celsius"   | 54        | 12.2    |
      | "Weight"      | "Pound"      | "Kilogram"  | 170       | 77      |
      | "Length"      | "Mile"       | "Kilometer" | 50        | 80.4    |