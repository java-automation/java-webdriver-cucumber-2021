@predefinedExperiment
Feature: Various experiments with WebDriver

  @predefinedExperiment1
  Scenario: Check if google search for PCS will return online class website on the first page.
    Given I go to "Google" page
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Portnov Computer School" into element with xpath "//input[@name='q']"
    Then I click on element with xpath "(//input[@name='btnK'])[2]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']//a[@href='https://portnov.net/']" should be present

  @predefinedExperiment2
  Scenario: Scroll bars and hidden button
    Given I go to "hidden button" page
    Then I wait for 3 sec
    Then  I click on element with xpath "//*[@id='hidingButton']"
    Then I wait for 3 sec

  @predefinedExperiment3
  Scenario: Login functionality for The Internet app
    Given I go to "the internet" page
    When I wait for 1 sec
    And I click on element with xpath "//div[@id='content']/ul//a[@href='/login']"
    And I wait for 1 sec
    And I type "tomsmith" into element with xpath "//*[@id='username']"
    And I type "SuperSecretPassword!" into element with xpath "//*[@id='password']"
    And I wait for 3 sec
    And I click on element with xpath "//button"
    And I wait for 3 sec