@validation
  Feature: Form validations
    Validate that user inputs are not missing where required and entered data does not break validation rules.

  Rule: Responsive UI of quote page

#  Firefox min width 450px is due to fix for the https://bugzilla.mozilla.org/show_bug.cgi?id=1610497
#  Chrome min width is 500px
#  Empirical data for Chrome 95 on Ubuntu:
#  Requesting resize to any width < 544px actually resizes to window.innerWidth=500, window.outerWidth=544 (window has scrollbar)
#  Requesting resize to any width N >= 544px actually resizes to window.innerWidth=N-44, window,outerWidth=N
#  Popular sizes: https://gbksoft.com/blog/common-screen-sizes-for-responsive-web-design/
    @validation1
    Scenario Outline: Application Section's Location/Date/Time disappear in Phone layout
      Given I open url "https://skryabin.com/market/quote.html"
      When I resize window to <width> and <height>
      Then I wait for 1 sec
      Then element with xpath "//*[contains(@class,'form-summary')]" should be displayed
      Then element with xpath "//*[contains(@class,'form-summary')]//div[contains(@class,'hidden-xs')]" should not be displayed
      Examples:
        | device | width | height |
        | mobile |   360 |    640 |
        | mobile |   414 |    896 |

#  setSize in Selenium sets window.outerWidth of the browser, while window.innerWidth is what marketed as device size
#  https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.Window.html#getSize()
#  Empirical data for browsers on Ubuntu:
#  for Chrome resizing window to 812 translates to window.innerWidth of 768 and window.outerSize of 812 due to scrollbar visibility
#  for Firefox resizing window to 768 translates to innerWidth and outerWidth both 768
#  https://www.sitepoint.com/rwd-scrollbars-is-chrome-better/
    @validation2
    Scenario Outline: Application Section has Location/Date/Time for Desktop and Tablet layouts
      Given I open url "https://skryabin.com/market/quote.html"
      And I resize window to 1 and 1
      Then I wait for 1 sec
      When I resize window to <width> and <height>
      Then I wait for 1 sec
      Then element with xpath "//*[contains(@class,'form-summary')]//div[contains(@class,'hidden-xs')]" should be displayed
      Examples:
        | device | width | height |
  #      | tablet |   800 |   1024 |
  #      | tablet |   811 |   1024 |
        | tablet |   812 |   1024 |
  #      | tablet |   767 |   1024 |
        | tablet |   768 |   1024 |
        | tablet |   769 |   1024 |
        | tablet |  1280 |    800 |
  #      | tablet |   601 |    962 |
        | laptop |  1366 |    768 |
        | laptop |  1920 |   1080 |

  Rule: Minimum username requirement is 2 characters.
#    Validation is triggered when form is submitted or Enter is pressed in any input field on the form
#    After validation is triggered changes in the fields are validated continuously

    @validation3
    Scenario: No error message about invalid username until form is submitted
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "a" into element with xpath "//input[@name='username']"
      And I wait for 1 sec
      Then element with xpath "//label[@id='username-error']" should not be present

    @validation4
    Scenario: No error message about username necessity if text is deleted and field still in focus
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "D" into element with xpath "//input[@name='username']"
      When I press Backspace into element with xpath "//input[@name='username']"
      And I wait for 1 sec
      Then element with xpath "//label[@id='username-error']" should not be present

    @validation5
    Scenario: Error message about username necessity if field had no interactions when form is submitted
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should have text as "This field is required."

    @validation6
    Scenario: Error message about username necessity if field is empty and Enter is pressed
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@name='username']"
      When I press Enter into element with xpath "//input[@name='username']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should have text as "This field is required."

    @validation7
    Scenario: Error message about username necessity if field is in focus and empty when form is submitted
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should have text as "This field is required."

    @validation8
    Scenario: Error message about username length if only 1 character when Enter is pressed
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "a" into element with xpath "//input[@name='username']"
      And I press Enter into element with xpath "//input[@name='username']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should have text as "Please enter at least 2 characters."

    @validation9
    Scenario: Error message about username length if only 1 character when field loses focus
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "A" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//input[@name='email']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should have text as "Please enter at least 2 characters."

#    Selenium interactions and user interaction differ: When Selenium sends Shift+Tab to return to the field,
#    text does not get selected as it happens with user interactions
#    @validation10
#    Scenario: Error message about username necessity when Tab out and Shift+Tab back in and selection removed
#      Given I open url "https://skryabin.com/market/quote.html"
#      When I type "John Doe" into element with xpath "//input[@name='username']"
#      And I press Tab into element with xpath "//input[@name='username']"
#      And I press Tab_and_Shift into element with xpath "//body"
#      And I press Backspace into element with xpath "//input[@name='username']"
#      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
#      Then element with xpath "//label[@id='username-error']" should have text as "This field is required."

    @validation11
    Scenario: Error message about username length if only 1 character when form is submitted
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "z" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//input[@name='email']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should have text as "Please enter at least 2 characters."

    @validation12
    Scenario: Error message removed when 2nd character is added to username
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "J" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
      When I type "o" into element with xpath "//input[@name='username']"
      Then element with xpath "//label[@id='username-error']" should not be displayed

    @validation13
    Scenario: Error message changes when username length gets from 0 to 1 to 2 characters long
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should have text as "This field is required."
      When I type "!" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for element with xpath "//label[@id='username-error']" to be displayed
      Then element with xpath "//label[@id='username-error']" should contain text "Please enter at least 2 characters."
      When I type "!!" into element with xpath "//input[@name='username']"
      Then element with xpath "//label[@id='username-error']" should not be displayed

  Rule: The format of an email address is local-part@domain. Input field maximum length is 100 characters.
#  using format specifications as outlined in
#  https://en.wikipedia.org/wiki/Email_address and https://en.wikipedia.org/wiki/Hostname
#  The format of an email address is local-part@domain, where the local part may be up to 64 octets long and the domain may have a maximum of 255 octets.
#  Note: An unqualified hostname may be automatically combined with a default domain name configured into the system.
#  Hostnames are composed of a sequence of labels concatenated with dots. Each label must be from 1 to 63 characters long.
#  !#$%&*+-/=?^_`{|}~'’

    @validation14
    Scenario Outline: Validate email addresses
      Given I open url "https://skryabin.com/market/quote.html"
      When I type <invalid email> into element with xpath "//input[@name='email']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for element with xpath "//label[@id='email-error']" to be displayed
      Then element with xpath "//label[@id='email-error']" should be displayed

      Examples:
        | invalid email | description |
  #      | "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcde@a.com" | local part is 65 octets long |
  #      | "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcde@abcdefghijabcdefghijabcdefghijabcdefghijabcdefghija.com" | 65 octets local part and 35 octets domain  |
        | "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij" | local part 100 octets long |
        | "a@abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcd" | hostname label is 64 characters long |
        |   "\" \"" ||
        |       "a" ||
        |       "@" ||
        |      "b@" ||
        |   "a.com" ||
        |  "@a.com" ||
        |    ".com" ||
        |      "#a" ||
        |   "     " ||
        | "test@a..m" ||
        | "m@m.com@m.com" ||
        | "m@example.com m" ||
        | "m@m.com m@m.com" ||
        | "m@ma.com,ma@m.com" ||
        | "! #$%&*+-/=?^_`{}~'@example.com" | "only space is invalid here, and vertical bar also allowed but omitted" |

    @validation15
    Scenario: Valid email address should not trigger error message
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "a!#$%&*+-/=?^_`{}~z'’@example.com" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for 1 sec
      Then element with xpath "//label[@id='email-error']" should not be present

  Rule: Password should be at least 5 characters.

    @validation16
    Scenario: Confirm Password is disabled if Password field is empty.
      Given I open url "https://skryabin.com/market/quote.html"
      When element with xpath "//input[@name='password']" should have attribute "value" as ""
      Then element with xpath "//input[@name='confirmPassword']" should be disabled

  Rule: Name can be entered via popup dialog or directly if field gets in focus

    @validation17
    Scenario: Popup dialog appears if clicked inside name field
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@name='name']"
      Then I wait for element with xpath "//*[@id='nameDialog']" to be displayed
      Then element with xpath "//*[@id='nameDialog']" should be displayed

    @validation18
    Scenario: Validate concatenation of First, Middle and Last names entered in the popup 
      Given I open url "https://skryabin.com/market/quote.html"
      When I click on element with xpath "//input[@name='name']"
      And I wait for element with xpath "//*[@id='nameDialog']" to be displayed
      And I type "John" into element with xpath "//input[@name='firstName']"
      And I type "Peter" into element with xpath "//input[@name='middleName']"
      And I type "Ferguson" into element with xpath "//input[@name='lastName']"
      And I click on element with xpath "//*[@class='ui-dialog-buttonset']//span[text()='Save']"
      Then element with xpath "//input[@name='name']" should have attribute "value" as "John Peter Ferguson"

  Rule: Accepting Privacy Policy required

    @validation19
    Scenario:  Validate that Accepting Privacy Policy is required when form is empty
      Given I open url "https://skryabin.com/market/quote.html"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for 1 sec
      Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed

    @validation20
    Scenario:  Validate that Accepting Privacy Policy is required when other required fields are filled
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "Peter Pan" into element with xpath "//input[@name='name']"
      And I type "peter@example.com" into element with xpath "//input[@name='email']"
      And I type "abcdefg" into element with xpath "//input[@name='password']"
      And I type "abcdefg" into element with xpath "//input[@name='confirmPassword']"
      And I type "peter_p" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for 1 sec
      Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should be displayed

  Rule: Form should be accepted

    @validation21
    Scenario:  Form with all the fields filled out should be submittable
      Given I open url "https://skryabin.com/market/quote.html"
      And I type "Dan Beck" into element with xpath "//input[@name='name']"
      And I type "dan@example.com" into element with xpath "//input[@name='email']"
      And I type "qwerty" into element with xpath "//input[@name='password']"
      And I type "qwerty" into element with xpath "//input[@name='confirmPassword']"
      And I type "dan_b" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      And I type "2353456" into element with xpath "//input[@name='phone']"
      And I click on element with xpath "//select[@name='countryOfOrigin']//option[@value='Austria']"
      And I click on element with xpath "//input[@value='male']"
      And I click on element with xpath "//input[@name='allowedToContact']"
      And I type "123 Sweet street, Los Angeles, CA" into element with xpath "//textarea[@name='address']"
      And I click on element with xpath "//select[@name='carMake']//option[@value='Ford']"
      And I click on element with xpath "//select[@name='carMake']//option[@value='Toyota']"
      And I click on element with xpath "//*[@id='thirdPartyButton']"
      And I accept alert
      And I click on element with xpath "//input[@name='dateOfBirth']"
      And I wait for element with xpath "//*[@id='ui-datepicker-div']" to be displayed
      And I click on element with xpath "//select[@class='ui-datepicker-month']//option[@value='2']"
      And I click on element with xpath "//select[@class='ui-datepicker-year']//option[@value='2000']"
      And I click on element with xpath "//a[@class='ui-state-default'][text()='10']"
      Then element with xpath "//input[@name='dateOfBirth']" should have attribute "value" as "03/10/2000"
      When I click on element with xpath "//button[@id='formSubmit']"
      Then I wait for element with xpath "//div[@id='quotePageResult']" to be displayed
      Then element with xpath "//div[@id='quotePageResult']" should contain text "Dan Beck"
      Then element with xpath "//div[@id='quotePageResult']" should contain text "2353456"

    @validation22
    Scenario: Quote form end to end scenario - required fields
      Given I open url "https://skryabin.com/market/quote.html"
      When I type "jdoe" into element with xpath "//input[@name='username']"
      And I type "john.doe@example.com" into element with xpath "//input[@name='email']"
      And I type "welcome" into element with xpath "//input[@id='password']"
      And I type "welcome" into element with xpath "//input[@id='confirmPassword']"

      When I click on element with xpath "//input[@id='name']"
      And I type "John" into element with xpath "//input[@id='firstName']"
      And I type "Doe" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[text()='Save']"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "John Doe"
      And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      And I click on element with xpath "//button[@id='formSubmit']"

      Then element with xpath "//b[@name='password']" should not have text as "welcome"
      Then element with xpath "//b[@name='agreedToPrivacyPolicy']" should have text as "true"

      Then element with xpath "//div[@id='quotePageResult']" should contain text "jdoe"
      Then element with xpath "//div[@id='quotePageResult']" should contain text "john.doe@example.com"
      Then element with xpath "//div[@id='quotePageResult']" should contain text "John Doe"