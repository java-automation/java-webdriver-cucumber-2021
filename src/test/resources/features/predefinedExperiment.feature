@predefinedExperiment
Feature: Various experiments with WebDriver

  @predefinedExperiment1
  Scenario: Check if google search for PCS will return online class website on the first page.
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "(//input[@name='btnK'])[2]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']//a[@href='https://portnov.net/']" should be present

  @predefinedExperiment2
  Scenario: Scroll bars
    Given I open url "http://uitestingplayground.com/scrollbars"
    Then I wait for 3 sec
    Then  I click on element with xpath "//*[@id='hidingButton']"
    Then I wait for 3 sec