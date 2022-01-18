@converter
Feature: Converter scenarios

  @converter1
  Scenario Outline: Converter page - Temperature
    Given I go to the "converter" page
    When I go to <menu> page
    And I set <convertFrom> to <convertTo>
    And I enter into From field <value>
    Then I verify <expectedResult> converted results
    Examples:
    | menu          | convertFrom  | convertTo | value | expectedResult |
    | "Temperature" | "Fahrenheit" | "Celsius" | "54"  | "12.2"         |
    | "Weight"      | "Pound"      | "Kilogram" | "170"  | "77"         |
    | "Length"      | "Mile"       | "Kilometer" | "50"  | "80.4"       |

#  Temperature: 54 Fahrenheit to Celsius result is 12.2
#  Weight: 170 Pound to Kilogram is 77
#  Length: 50 Mile to Kilometer is 80.4
#  Convert to scenario outline after implementation.