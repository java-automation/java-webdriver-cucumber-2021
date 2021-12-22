@unitconverters
Feature: Unit Converters

#Temperature: 54 Fahrenheit to Celsius result is 12.2
#Weight: 170 Pound to Kilogram is 77
#Length: 50 Mile to Kilometer is 80.4
#Convert to scenario outline after implementation.

  @unitconverters1
  Scenario Outline: Write scenario that would convert Temperature, Weight, Length front one units of measurements to another;
    Given I go to "converter" page
    Then Would click on "<converters>" etc
    And  Set from which "<From Unit>" and to which "<To Unit>" with specific values
    Then Set "<From value>" field and verify any result in "<To value>"

    Examples:
      | converters  | From Unit  | From value | To Unit   | To value |
      | Temperature | Fahrenheit | 54         | Celsius   | 12.2     |
      | Weight      | Pound      | 170        | Kilogram  | 77       |
      | Length      | Mile       | 50         | Kilometer | 80.4     |



