@quote_oop

  Feature: Quote feature
    Scenario: Quote end to end OOP
      Given I go to the "quote" page oop
      When I fill out "user" required fields oop
      When I fill out "user" optional fields OOP
      And I submit a form OOP
      Then I verify "user" the required fields OOP
      And I wait for 8 sec


    @quote3
    Scenario: Required fields test
      Given I go to the "quote" page oop
      Then I don't see "username" error message
      Then I don't see "email" error message
      Then I don't see "password" error message
      Then I don't see "name" error message
      Then I don't see "agreedToPrivacyPolicy" error message
      And I click "Submit" button
      Then I see "username" error message "This field is required."
      And I see "email" error message "This field is required."
      And I see "password" error message "This field is required."
      And I see "name" error message "This field is required."
      And I see "agreedToPrivacyPolicy" error message "- Must check!"

    @quote4
    Scenario: Market username test
      Given I go to the "quote" page oop
      When I fill out "username" field with "a"
      And I click "Submit" button
      And I wait for 2 sec
      Then I see "username" error message "Please enter at least 2 characters."
      When I fill out "username" field with "ab"
      And I wait for 2 sec
      Then I don't see "username" error message



    @quote5
    Scenario: Market email test
      Given I go to the "quote" page oop
      When I fill out "email" field with "john"
      And I click "Submit" button
      Then I see "email" error message "Please enter a valid email address."
      When I fill out "email" field with "john@example.com"
      Then I don't see "email" error message

    @quote6
    Scenario: Market passwords test
      Given I open "quote" page
      When I fill out "password" field with "1234"
      And I click "Submit" button
      Then I see "password" error message "Please enter at least 5 characters."
      When I fill out "password" field with "12345"
      Then I don't see "password" error message
      When I fill out "confirmPassword" field with "1234"
      And I click "Submit" button
      Then I see "confirmPassword" error message "Please enter at least 5 characters."
      When I fill out "confirmPassword" field with "54321"
      Then I see "confirmPassword" error message "Passwords do not match!"
      When I fill out "confirmPassword" field with "12345"
      And I wait for 4 sec
      Then I don't see "confirmPassword" error message

    @quote7
    Scenario: Market name test
      Given I open "quote" page
      When I fill out name field with first name "John" and last name "Doe"
      Then I verify "name" field value "John Doe"
      When I fill out name field with first name "John", middle name "Richard", last name "Doe"
      Then I verify "name" field value "John Richard Doe"