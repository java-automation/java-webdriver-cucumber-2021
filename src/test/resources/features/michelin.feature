@michelin
Feature: Find offer for Michelin tires;

  @michelin1
  Scenario: Find prices on Google search for michelin tires
    Given I open url "https://www.google.com/"
    Then I type "michelin tires" into element with xpath "//input[@name='q']"
    And I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    And I wait for element with xpath "//div[@id='search']//div[@data-hveid]" to be present
    And I collect text from search results
    And I collect links from search results
    And I create HashMap from search results


