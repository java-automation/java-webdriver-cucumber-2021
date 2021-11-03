@testcase
Feature: TestCases Day3 lab

  @testcase1
  Scenario: Validate responsive UI behavior
    Given I open url "https://skryabin.com/market/quote.html"
    And I maximize window
    Then I wait for element with xpath "//b[@id='location']" to be present
    And I resize window to 400 and 800
    Then element with xpath "//b[@id='location']" should not be displayed
    And I resize window to 1200 and 800
    Then element with xpath "//b[@id='location']" should be displayed

  @testcase2
  Scenario: Validate minimal “Username” field length requirement
  as 2 characters
    Given I open url "https://skryabin.com/market/quote.html"
    Then I wait for element with xpath "//b[@id='location']" to be present
    When I type "a" into element with xpath "//input[@name='username']"
    And I click on element using JavaScript with xpath "//button[@id='formSubmit']"
    Then element with xpath "//label[@id='username-error']" should contain text "2 char"
    When I type "b" into element with xpath "//input[@name='username']"
    Then element with xpath "//label[@id='username-error']" should not be displayed
    And I clear element with xpath "//input[@name='username']"
