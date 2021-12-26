@converter
  Feature: Converter scenarios

    @converter1
    Scenario: Validate Temperature
      Given I go to "converter" page
      When I go to "Temperature" tab
      And I set "Fahrenheit" to "Celsius"
      And I enter into From field "54"
      Then I verify "12.2" conversion result
      And I wait for 2 sec

    @converter2
    Scenario: Validate Weight
      Given I go to "converter" page
      When I go to "Weight" tab
      And I set "Pound" to "Kilogram"
      And I enter into From field "170"
      Then I verify "77" conversion result
      And I wait for 2 sec

    @converter3
    Scenario: Validate Length
      Given I go to "converter" page
      When I go to "Length" tab
      And I set "Mile" to "Kilometer"
      And I enter into From field "50"
      Then I verify "80.4" conversion result
      And I wait for 2 sec


