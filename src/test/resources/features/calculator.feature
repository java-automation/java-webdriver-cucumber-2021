@calc
Feature: Scenarios for various calculators

  @calc1
  Scenario: Verify auto loan calculator result
    Given I go to "calculator" page
    When  I navigate to "Auto Loan Calculator"
    *     I clear all calculator fields
    *     I calculate
    Then  I verify "Please provide a positive auto price." calculator error
    *     I verify "Please provide a positive interest value." calculator error
    When  I enter "25000" price, "60" months, "4.5" interest, "5000" down payment, "0" trade-in, "California" state, "7" percent tax, "300" fees
    *     I calculate
    Then  I verify monthly pay is "$372.86"