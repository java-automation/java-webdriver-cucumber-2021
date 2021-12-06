@quote
 Feature: Quote page automation

   @quote1
   Scenario: Quote page end to end
     Given I go to "google" page
     And I go to "quote" page
     And I change resolution to "phone"
     And I go back and forward and refresh the page
     When I fill out required fields
     And I submit the form
     Then I verify the required fields after submitting
