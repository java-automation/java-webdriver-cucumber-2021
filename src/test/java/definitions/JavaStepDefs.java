package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class JavaStepDefs {

    public String firstVar = "my var";
    public String secondVar = "my VAR";
    public String notFavoriteColor = "yellow";


    public void compareVars(String var1, String var2) {
        if (var1 == var2) {
            System.out.println("Variable " + var1 + " is identical with variable " + var2);
        } else {
            System.out.println("Variables " + var1 + " and " + var2 + " are not exact the same.");
        }
    }

    PrintData num = new PrintData();

    @Given("I hello world")
    public void iHelloWorld() {
        System.out.println("Hello World!");
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }


    @Given("I print first name {string} and last name {string} and favorite color {string}")
    public void iPrintTheNameWithFirstNameAndLastNameAndMyFavoriteColor(String firstName, String lastName, String favoriteColor) {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Favorite Color: " + favoriteColor);
    }

    @Given("I print data with first name {string} and last name {string} and favorite color {string}")
    public void iPrintData(String arg0, String arg1, String arg2) {
        PrintData myData = new PrintData();
        myData.PrintTheData(arg0, arg1, arg2);
    }

    @Given("I get the length of the {string} string")
    public void iGetTheLengthOfTheString(String text) {
        System.out.println("The length of the " + text + " is " + text.length() + " characters long.");
    }

    @And("I get the {string} in lower case")
    public void iGetTheInLowerCase(String text) {
        System.out.println("The lower case of " + text + " is: " + text.toLowerCase());
    }

    @And("I get the {string} in upper case")
    public void iGetTheInUpperCase(String text) {
        System.out.println("The upper case of " + text + " is: " + text.toUpperCase());
    }

    @And("I trim the {string}")
    public void iTrimThe(String text) {
        System.out.println("The trimmed version of '" + text + "' is: '" + text.trim() + "'");
    }

    @And("I get the class of {string}")
    public void iGetTheClassOf(String text) {
        System.out.println("The class of " + text + " is: " + text.getClass());
    }

    @And("I verify if {string} is empty")
    public void iVerifyIfIsEmpty(String text) {
        System.out.println("Is the " + text + " empty? " + text.isEmpty());
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String arg0, String arg1) {
        String firstString = arg0;
        String secondString = arg1;
    }

    @And("I print {string} and {string} variables into console as they are")
    public void iPrintAndVariablesIntoConsoleAsTheyAre(String arg0, String arg1) {
        PrintData print = new PrintData();
        print.PrintToConsole(arg0, arg1);
    }

    @And("I print those variables into console as they are")
    public void iPrintThoseVariablesIntoConsoleAsTheyAre() {
        System.out.println("First variable: " + firstVar);
        System.out.println("Second variable: " + secondVar);
    }

    @And("I print those variables uppercase into console")
    public void iPrintThoseVariablesUppercaseIntoConsole() {
        iGetTheInUpperCase(firstVar);
        iGetTheInUpperCase(secondVar);
    }

    @And("I print those variables length into console")
    public void iPrintThoseVariablesLengthIntoConsole() {
        iGetTheLengthOfTheString(firstVar);
        iGetTheLengthOfTheString(secondVar);
    }

    @And("I print result of exact comparison of those variables into console")
    public void iPrintResultOfExactComparisonOfThoseVariablesIntoConsole() {
        compareVars(firstVar, secondVar);
    }

    @And("I print result of exact comparison ignoring cases of those variables into console")
    public void iPrintResultOfExactComparisonIgnoringCasesOfThoseVariablesIntoConsole() {
        compareVars(firstVar.toLowerCase(), secondVar.toLowerCase());
    }

    @And("I print result of partial comparison of those variables into console")
    public void iPrintResultOfPartialComparisonOfThoseVariablesIntoConsole() {
        if (firstVar.contains(secondVar)) {
            System.out.println("Variable '" + firstVar + "' contains '" + secondVar + "' variable.");
        } else {
            System.out.println("Variable '" + firstVar + "' do not contain '" + secondVar + "' variable.");
        }
    }

    @Given("I create two integers {int} and {int}")
    public void iCreateTwoIntegersAnd(int arg0, int arg1) {
        PrintData.getNumbers(arg0, arg1);
    }

    @And("I print the sum of the integers")
    public void iPrintTheSumOfTheIntegers() {
        System.out.println(num.num1 + num.num2);
    }

    @And("I print the difference of the integers")
    public void iPrintTheDifferenceOfTheIntegers() {
        System.out.println(num.num1 - num.num2);
    }

    @And("I print the division of the integers")
    public void iPrintTheDivisionOfTheIntegers() {
        System.out.println(num.num1 / num.num2);
    }

    @And("I print the product of the integers")
    public void iPrintTheProductOfTheIntegers() {
        System.out.println(num.num1 * num.num2);
    }

    @Given("I print the comparison of the colors my favorite color as {string} and my non-favorite color as {string}")
    public void iProvideMyFavoriteColorAsAndMyNonFavoriteColorAs(String arg0, String arg1) {
        String favoriteColor = arg0;
        String nonFavoriteColor = arg1;
        Assert.assertEquals(favoriteColor, nonFavoriteColor);
    }

    @Given("I compare {string} and {string} strings")
    public void iCompareAndStrings(String arg0, String arg1) {
        if (arg0.equals(arg1)) {
            System.out.println("equal!");
        } else {
            System.out.println("not equal!");
        }
    }

    @Given("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num >= 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }
    }

    @Given("I print {string} day of week")
    public void iPrintDayOfWeek(String dayNum) {
        switch (dayNum) {
            case "1":
                System.out.println("Monday");
                break;
            case "2":
                System.out.println("Tuesday");
                break;
            case "3":
                System.out.println("Wednesday");
                break;
            case "4":
                System.out.println("Thursday");
                break;
            case "5":
                System.out.println("Friday");
                break;
            case "6":
                System.out.println("Saturday");
                break;
            case "7":
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Unsupported case. Please provide 1 though 7 as a string");
        }
    }

    @Given("I open the page with url {string}")
    public void iOpenThePageWithUrl(String url) {
        getDriver().get(url);
    }

    @And("I fill in {string} in element {string}")
    public void iFillInInElement(String input, String element) {
        getDriver().findElement(By.xpath(element)).sendKeys(input);
    }

    @And("I click on element {string}")
    public void iClickOnElement(String element) {
        getDriver().findElement(By.xpath(element)).click();
    }

    @And("I accept alert window")
    public void iAcceptAlertWindow() {
        getDriver().switchTo().alert().accept();
    }

    @And("I switch to iframe {string}")
    public void iSwitchToIframe(String element) {
        getDriver().switchTo().frame(getDriver().findElement(By.xpath(element)));
    }

    @And("I switch to previous window")
    public void iSwitchToPreviousWindow() {
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
    }

    @And("I switch back from iframe")
    public void iSwitchBackFromIframe() {
        getDriver().switchTo().defaultContent();
    }

    @And("I wait for element {string} to be displayed")
    public void iWaitForElementToBeDisplayed(String element) {
        getDriver().findElement(By.xpath(element)).isDisplayed();
    }

    @And("I navigate back")
    public void iNavigateBack() {
        getDriver().navigate().back();
    }

    @And("I upload file for element {string}")
    public void iUploadFileForElement(String element) {
        getDriver().findElement(By.xpath(element)).sendKeys("C:\\Users\\casia\\Downloads\\Documents.pdf");
    }

    @Given("I print all numbers from zero up to {int}")
    public void iPrintAllNumbersFromZeroUpTo(int numN) {
        for (int i = 0; i <= numN; i++) {
            System.out.println(i);
        }
    }

    @And("I support also negative numbers like {int}")
    public void iSupportAlsoNegativeNumbersLike(int allNum) {
        if (allNum >= 0) {
            for (int i = 0; i <= allNum; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = allNum; i < 0; i++) {
                System.out.println(i);
            }
        }
    }

    @And("I print all integer array")
    public void iPrintAllIntegerArray() {
        int[] intArray = {-5, 0, 13, 1544};
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    @And("I print all integer array [{int}, {int}, {int}, {int}]")
    public void iPrintAllIntegerArray(int arg0, int arg1, int arg2, int arg3) {
        int[] intArray = {arg0, arg1, arg2, arg3};
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }

    @And("I print all integer numbers from integer array [{int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}]")
    public void iPrintAllIntegerNumbersFromIntegerArray(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        int[] intArray = {arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7};
        for(int i=0; i<intArray.length; i++) {
            if(intArray[i] % 2 == 0) {
                System.out.println(intArray[i]);
            }
        }
    }

    @And("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        String[] anyArray = {};
        if(anyArray.length > 0) {
            System.out.println("The array is not empty");
        } else if(anyArray.length == 0) {
            System.out.println("The array is empty");
        }
    }

    @And("I check if array contains another element")
    public void iCheckIfArrayContainsAnotherElement() {
        String[] someArray ={"abc", "word", "15", "holy-moly", "word"};
        String elementFound = "sword";
        for(String element : someArray) {
            if(element == elementFound) {
                System.out.println("Element \"" + element + "\" was found in array");
            } else {
                System.out.println("Element \"" + elementFound + "\" was not found in array");
                return;
            }
        }
    }
}