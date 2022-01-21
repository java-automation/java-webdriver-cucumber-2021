@quote

  Feature: OooP quote

    @quote1
    Scenario: Quote end to end oop
      Given I go to "quote" page oop
      When I fill out "user" required fields oop
      And I submit the page oop
      Then I verify "user" required fields oop
      And I wait for 2 sec


      @quote2
    Scenario: Required fields test
      Given I go to "quote" page oop
      Then I don't see "username" error message
      Then I don't see "email" error message
      Then I don't see "password" error message
      Then I don't see "name" error message
      Then I don't see "agreedToPrivacyPolicy" error message
      And I submit the page
      Then I see "username" error message "This field is required."
      And I see "email" error message "This field is required."
      And I see "password" error message "This field is required."
      And I see "name" error message "This field is required."
      And I see "agreedToPrivacyPolicy" error message "- Must check!"


        @quote3

        Scenario: Market username test
          Given I go to "quote" page
          When I fill out "username" field with "a"
          And I wait for 2 sec
          And I submit the page
          And I wait for 2 sec
          Then I see "username" error message "Please enter at least 2 characters."
          When I fill out "username" field with "ab"
          And I wait for 2 sec
          Then I don't see "username" error message



    @quote4
    Scenario: Market email test
      Given I go to "quote" page
      When I fill out "email" field with "john"
      And I wait for 2 sec
      And I submit the page
      And I wait for 2 sec
      Then I see "email" error message "Please enter a valid email address."
      When I fill out "email" field with "john@example.com"
      And I wait for 2 sec
      Then I don't see "email" error message