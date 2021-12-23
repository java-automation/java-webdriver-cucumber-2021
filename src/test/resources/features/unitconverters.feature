@unitconverters
  Feature: Unitconverters feature

    @unitconverters1
    Scenario: Convert temperature
      Given I go to "unitconverters" page and print details
      And I select "Temperature" converter
      When I convert value "54" from "Fahrenheit" to "Celsius"
      Then I verify the result is "12.2"

    @unitconverters2
    Scenario: Convert weight
      Given I go to "unitconverters" page and print details
      And I select "Weight" converter
      When I convert value "170" from "Pound" to "Kilogram"
      Then I verify the result is "77"

    @unitconverters3
    Scenario: Convert length
      Given I go to "unitconverters" page and print details
      And I select "Length" converter
      When I convert value "50" from "Mile" to "Kilometer"
      Then I verify the result is "80.4"

    @unitconverters4
    Scenario Outline: Use converters
      Given I go to "unitconverters" page and print details
      And I select <tab> converter
      When I convert value <value> from <fromOption> to <toOption>
      Then I verify the result is <expectedValue>
      Examples:
        | tab           | value | fromOption   | toOption    | expectedValue |
        | "Temperature" | "54"  | "Fahrenheit" | "Celsius"   | "12.2"        |
        | "Weight"      | "170" | "Pound"      | "Kilogram"  | "77"          |
        | "Length"      | "50"  | "Mile"       | "Kilometer" | "80.4"        |
