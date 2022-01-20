@quote
  Feature: Quote Feature

    @quote1
    Scenario: Quote end to end
      Given I go to the "quote" page
#      And I print logs to the console
      When I fill out required fields
      When I fill out optional fields
      And I wait for 5 sec
      And I submit a form
#      And I wait for 5 sec
#      Then I verify the required fields

    @quote2
    Scenario: Multiselect car brands
      Given I go to the "quote" page
      And I select "Ford BMW" with Select
      And I select "Ford BMW" with Actions
      And I wait for 5 sec
      
      
    @quote3  
    Scenario: Work with Switch To
      Given I go to the "quote" page
      And I click on element with xpath "//button[contains(@onclick, 'new')]"
      And I switch to another window
      And I enter "Ivan Ivanov" as contact person with a phone "555-555-55-45"

    @quote4
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