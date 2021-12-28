@converter
Feature: Converter scenarios

 # @converter1
 # Scenario Outline: Validate Conversion
  #  Given I go to "converter" page
  #  When I go to "<unit>" tab
  #  And I set "<from>" to "<to>"
  #  And I enter into From field "<value>"
 #  Then I verify "<result>" conversion result
  # Examples:
   #   | unit         | from       | to        | value | result |
   #   | Temperature  | Fahrenheit | Celsius   | 54    | 12.2   |
   #   | Weight       | Pound      | Kilogram  | 170   | 77     |
   #   | Length       | Mile       | Kilometer | 50    | 80.4   |

   @converter1
   Scenario: Validate Temperature
     Given I go to "converter" page
     When I go to "Temperature" tab
     And I set "Fahrenheit" to "Celsius"
     And I enter into From field "54"
     Then I verify "12.2" conversion result

    @converter2
    Scenario: Validate Weight
      Given I go to "converter" page
      When I go to "Weight" tab
      And I set "Pound" to "Kilogram"
      And I enter into From field "170"
      Then I verify "77" conversion result

    @converter3
    Scenario: Validate Length
      Given I go to "converter" page
      When I go to "Length" tab
      And I set "Mile" to "Kilometer"
      And I enter into From field "50"
      Then I verify "80.4" conversion result

#Temperature: 54 Fahrenheit to Celsius result is 12.2
#Weight: 170 Pound to Kilogram is 77
#Length: 50 Mile to Kilometer is 80.4