@java
Feature: Java feature

  @java0
  Scenario: Hello World
    Given I hello world
    And I say "Aloha!"

  @java1_dialog:
  Scenario: Validate Date Picker functionality
  Dialog: verify that upon clicking dialog appears
  Date Composer: verify that chosen date is formed out
  correctly if day clicked in popup
    Given I open url "https://skryabin.com/market/quote.html"
    Then I wait for element with xpath "//input[@name='dateOfBirth']" to be present
    Then I click on element with xpath "//input[@name='dateOfBirth']"
    Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
    Then I click month "Jan" in Date Composer
    Then I click year 2000 in Date Composer
    Then I click day 25 in Date Composer
    Then element with xpath "//input[@id='dateOfBirth']" should have attribute "value" as "01/25/2000"

  @java1_bonus
  Scenario: Bonus for Date Picker:
  validate that month/year selectors work as expected and back/forward buttons change month
    Given I open url "https://skryabin.com/market/quote.html"
    Then I wait for element with xpath "//input[@name='dateOfBirth']" to be present
    Then I click on element with xpath "//input[@name='dateOfBirth']"
    Then element with xpath "//div[@id='ui-datepicker-div']" should be displayed
    #back/forward buttons change month
    Then I click back arrow button in Date Picker to change month
    Then I click forward arrow button in Date Picker to change month

@java2
Scenario: Create new custom step that would accept two variables
1) Print those variables into console as they are
2) Print those variables uppercase into console
3) Print those variables length into console
4) Print result of exact comparison of those variables into console
5) Print result of exact comparison ignoring cases of those variables into console
6) Print result of partial comparison of those variables into console – if first
variable contains second
Once complete, write few steps with different variables.
  Given I perform actions with "my var" and "my VAR"
  Given I perform actions with "Star spangled Banner" and "Star"



