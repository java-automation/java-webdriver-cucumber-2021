@d5hwJava
   Feature: Java feature

     @d5hwJava1
      Scenario: Try if/else steps; positive or negative
      And I print if number 35 is positive

     @d5hwJava2
     Scenario: Day of week
       And I print 5 day of week

     @d5hwJava3
     Scenario: Conditions Exercise
       Given I go to "QuOTE" page

     @d5hwJava4
     Scenario: getDriver() exercises #1
       Given I go to "google" page again
       #And I wait for 1 sec
       And I print page details
       And I go to "quote" page again
       And I wait for 1 sec
       And I print page details
       And I go back and forward, then refresh the page

     @d5hwJava5
     Scenario: getDriver().manage().window() exercises #2
       Given I go to "google" page again
       And I wait for 1 sec
       Given I change resolution to "desktop"