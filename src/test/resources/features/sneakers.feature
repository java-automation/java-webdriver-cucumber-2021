@sneakers
  Feature: keeping up with prices

    @sneakers_price
    Scenario Outline: check the price
      Given I go to <page> page
      And I google for StockX
      And I find the StockX website and click on it
      When I verify the Stock home page is open
      When I search for <model> on the main page
      And I wait for <sec> sec
      And I choose <fullModelName>
      And I wait for <sec> sec
#      Then I choose the size <sizeW> for women or <sizeW> for men
#      And I print the price

      Examples:
        | page     | model                   | sec | fullModelName                                  | sizeW | sizeW  |
        | "Google" | "university blue white" | 10   | "Jordan 1 Low Black University Blue White (W)" | "9"   | "7.5"  |
#        | "Google" | "university blue white" | 5   | "Jordan 1 Low Black University Blue White (W)" | "9.5" | "8"    |
#
#        | "Google" | "reverse bred"          | 5   | "Jordan 1 Low Reverse Bred"                    | "9"   | "7.5"  |
#        | "Google" | "reverse bred"          | 5   | "Jordan 1 Low Reverse Bred"                    | "9.5" | "8"    |
#
#        | "Google" | "bred toe"              | 5   | "Jordan 1 Low Bred Toe"                        | "9"   | "7.5"  |
#        | "Google" | "bred toe"              | 5   | "Jordan 1 Low Bred Toe"                        | "9.5" | "8"    |

      @sneakers_price_short
      Scenario: get price
        Given I open "university blue" page
        And I choose the size "9" for women or "7.5" for men










