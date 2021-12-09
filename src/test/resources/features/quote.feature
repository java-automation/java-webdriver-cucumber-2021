@quote

  Feature: Quote Feature

    @quote1
    Scenario: Quote end to end
      Given I go first to ... and print details
      Then I go to "quote" page
      And  And I print	details
      And And I	go back and	forward,then refresh the page
      And I print logs to console
      When I fill our required fields
      Then I fill our not required fields
      And  I wait for 2 sec
      And I submit the page
      Then  I verify the required fields
      And  I wait for 2 sec
      Then  I verify the not required fields
      And I wait for 2 sec
      Then And	I change	resolution	to	"phone"
      Then And	I change your resolution to	"desktop"




