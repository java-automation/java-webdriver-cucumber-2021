@java
Feature: Basic Java experiments

  @java1
  Scenario: Name and Color
    Then Show the greeting when I'm "John" "Doe" and my favorite color is "yellow"

  @java2
  Scenario Template: String exercise
    Then I perform exercise on <stringOne> and <stringTwo>

    Examples:
      | stringOne  | stringTwo |
      | "my var"   | "my VAR"  |
      | "XXL XL L" | "L"       |
      | "Spear"    | "pear"    |

  @java3
  Scenario Template: Number exercise
    Then I perform exercise on <numberOne> and <numberTwo>

    Examples:
      | numberOne  | numberTwo |
      | 134        | 67        |
      | -10        | 3         |
      | 1001657    | 85462     |

  @java4
  Scenario: Boolean exercise
    Then Show the message when my favorite color is "yellow", but not "red"

  @java5
  Scenario Template: Conditions exercise
    Then Compare <stringOne> and <stringTwo>

    Examples:
      | stringOne    | stringTwo |
      | "apple"      | "apple"   |
      | "pear"       | "peach"   |
      | "plum"       | "plum"    |
      | "watermelon" | "melon"   |

  @java6
  Scenario Template: Print URL for a known website
    Then I print URL for <site> page

    Examples:
      | site             |
      | "google"         |
      | "quote form"     |
      | "Portnov School" |
      | "unknown"        |