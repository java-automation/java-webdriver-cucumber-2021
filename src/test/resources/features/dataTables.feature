@datatables
Feature: providing data in scenarios

  @datatables1
  Scenario: How to get data from DataTable
    Given I print data From DataTable
      | query                         |
      | Behavior Driver Testing       |
      | michelin tire                 |
      | Gift for Granny for Christmas |


  @datatables2
    #1. Need to put quotes around name of Example columns
    #2. If you using a step table add a colon : at the end of your table
    #3. Cucumber will replace these delimited <> parameters with values from the table before it tries to match the step against a step definition
  Scenario Outline: Google search from dataTable search query
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "<query>" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "<text>"
    Examples:
      | query                   | text     |
      | Behavior Driver Testing | Cucumber |
      | michelin tire           | michelin |





