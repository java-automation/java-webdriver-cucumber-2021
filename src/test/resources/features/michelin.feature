@michelin
  Feature: Find offer of michelin tires;

  @michelin1
  Scenario: Find prices on Google search for michelin tires
  Given I open url "https://www.google.com/"
    Then I type "//input[@name='q']" into element with xpath "michelin tires"
    And I wait for element with xpath "//div[@id='search']//div[@data-hveid]" to be present //need to be specified
