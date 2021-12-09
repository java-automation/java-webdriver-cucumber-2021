package definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;

import java.util.*;

import static support.TestContext.*;

public class JavaStepDefs {

    public String firstVar = "my var";
    public String secondVar = "my VAR";


    public void compareVars(String var1, String var2) {
        if (var1.equals(var2)) {
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

    @And("I print all even numbers from integer array [{int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}]")
    public void iPrintAllEvenNumbersFromIntegerArray(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        int[] intArray = {arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7};
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] % 2 == 0) {
                System.out.println(intArray[i]);
            }
        }
    }

    @And("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        String[] anyArray = {};
        if (anyArray.length > 0) {
            System.out.println("The array is not empty");
        } else if (anyArray.length == 0) {
            System.out.println("The array is empty");
        }
    }

    @And("I check if array contains another element")
    public void iCheckIfArrayContainsAnotherElement() {
        String[] someArray = {"abc", "word", "15", "holy-moly", "word"};
        String elementFound = "sword";
        for (String element : someArray) {
            if (element.equals(elementFound)) {
                System.out.println("Element \"" + element + "\" was found in array");
            } else {
                System.out.println("Element \"" + elementFound + "\" was not found in array");
                return;
            }
        }
    }

    @Given("I sort all numbers in ascending order")
    public void iSortAllNumbersInAscendingOrder() {
        int [] arr = {2, 7, 1, 5, 9, 15, 3};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int min = arr[index];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    @And("I sort odd numbers in ASC keeping even ones at their places")
    public void iSortOddNumbersInASCKeepingEvenOnesAtTheirPlaces() {
        int[] arr = {2, 7, 6, 1, 8, 5, 9, 4, 3, 11, 10};
        System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int min = arr[index];
            if (min % 2 != 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] < min) {
                        if(arr[j] % 2 != 0) {
                            min = arr[j];
                            index = j;
                        } else {
                            min = arr[index];
                        }
                    }
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
            System.out.println(Arrays.toString(arr));

        }
    }

    @And("I verify that even numbers kept their places")
    public void iVerifyThatEvenNumbersKeptTheirPlaces() {
        int [] arrStart = {2, 7, 6, 1, 8, 5, 9, 4, 3, 11, 10};
        int [] arrEnd = {2, 1, 6, 3, 8, 5, 7, 4, 9, 11, 10};
        for (int m = 0; m < arrStart.length; m++) {
            if(arrStart[m] % 2 == 0) {
                System.out.println(arrStart[m] + " is at position [" + m + "] in arrStart" );
                Assert.assertEquals(arrEnd[m], arrStart[m]);
            }
        }
    }

    @Given("I print multiplication table up to {int}")
    public void iPrintMultiplicationTableUpTo(int arg0) {
        int n = arg0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    @Given("I combine two int arrays")
    public void iCombineTwoArrays() {
        int[] arr1 = {0, 5, 8, 9, 1};
        int[] arr2 = {1, 2, 3};
        int min_len;
        int[] len = new int[arr1.length + arr2.length];

        if (arr1.length < arr2.length) {
            min_len = arr1.length;
        } else {
            min_len = arr2.length;
        }
        for (int n = 0; n < min_len * 2; n=n+2) {
            len[n] = arr1[n / 2];
            len[n+1] = arr2[n / 2];
        }
        for (int m = min_len; m < arr1.length; m++) {
            len[min_len * 2 + m - min_len] = arr1[m];
        }
        for (int m = min_len; m < arr2.length; m++) {
            len[min_len * 2 + m - min_len] = arr2[m];
        }
        System.out.println(Arrays.toString(len));
    }

    @And("I combine two string arrays")
    public void iCombineTwoStringArrays() {
        String[] arr1 = {"Cat", "on", "mat."};
        String[] arr2 = {"sat", "the"};
        String[] result = new String[arr1.length+arr2.length];
        int min_len;
        if (arr1.length < arr2.length) {
           min_len = arr1.length;
        } else {
            min_len = arr2.length;
        }
        for (int n = 0; n < min_len * 2; n=n+2) {
            result[n] = arr1[n / 2];
            result[n+1] = arr2[n / 2];
        }
        for (int i=min_len; i<arr1.length; i++) {
            result[min_len * 2 + i - min_len] = arr1[i];
        }
        for (int i=min_len; i<arr2.length; i++) {
            result[min_len * 2 + i - min_len] = arr2[i];
        }
        System.out.println(Arrays.toString(result));
    }

    @And("I combine two lists")
    public void iCombineTwoLists() {
        ArrayList<String> arr1 = new ArrayList<>();
        arr1.add("Book");
        arr1.add("1527");
        arr1.add("0123");
        arr1.add("drawer");
        ArrayList<String> arr2 = new ArrayList<>();
        arr2.add("Tomato");
        arr2.add("15.99");
        arr2.add("Carb");
        int min_len;
        String[] result = new String[arr1.size()+arr2.size()];
        if (arr1.size() < arr2.size()) {
            min_len = arr1.size();
        } else {
            min_len = arr2.size();
        }
        for (int n = 0; n < min_len * 2; n=n+2) {
            result[n] = arr1.get(n / 2);
            result[n+1] = arr2.get(n / 2);
        }
        for (int i=min_len; i<arr1.size(); i++) {
            result[min_len * 2 + i - min_len] = arr1.get(i);
        }
        for (int i=min_len; i<arr2.size(); i++) {
            result[min_len * 2 + i - min_len] = arr2.get(i);
        }
        System.out.println(Arrays.toString(result));
    }

    @Given("I swap two variables values {string} and {string} using a third variable")
    public void iSwapTwoVariablesValuesAnd(String arg0, String arg1) {
        //enum unacceptedValues{"", null};
        String firstValue = arg0;
        String  secondValue = arg1;
        if(firstValue.equals("") || firstValue.equals(null) || secondValue.equals("") || secondValue.equals(null)){
            System.out.println("Value cannot be empty or null");
            return;
        }
        System.out.println("--Before swap-- \nFirst value:" + firstValue + "\nSecond value:" + secondValue);
        String temp = firstValue;
        firstValue = secondValue;
        secondValue = temp;
        System.out.println("--After swap-- \nFirst value:" + firstValue + "\nSecond value:" + secondValue);
    }

    @And("I swap two variables values {int} and {int} without a third variable")
    public void iSwapTwoVariablesValuesAndWithoutAThirdVariable(int arg0, int arg1) {
        int firstValue = arg0;
        int secondValue = arg1;
        System.out.println("--Before swap-- \nFirst value:" + firstValue + "\nSecond value:" + secondValue);
        firstValue = firstValue + secondValue;
        secondValue = firstValue - secondValue;
        firstValue = firstValue - secondValue;
        System.out.println("--After swap-- \nFirst value:" + firstValue + "\nSecond value:" + secondValue);
    }

    @Given("I swap elements from array [{int}, {int}, {int}, {int}, {int}, {int}]")
    public void iSwapElementsFromArray(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        int[] array = {arg0, arg1, arg2, arg3, arg4, arg5};
        System.out.println("--Before swap-- "+ Arrays.toString(array));
        int temp = array[2];
        array[2] = array[4];
        array[4] = temp;
        System.out.println("--After swap-- " + Arrays.toString(array));
    }

    @Given("I print specific output on conditions having number {int}")
    public void iPrintSpecificOutputOnConditionsHavingNumber(int arg0) {
        int num = arg0;
        if(num % 3 == 0 && num % 4 == 0) {
            System.out.println(num + " is divisible by 3 and 4");
        } else if (num % 4 == 0) {
            System.out.println(num + " is divisible by 4");
        } else if (num % 3 == 0) {
            System.out.println(num + " is divisible by 3");
        } else {
            System.out.println(num + " is not divisible by 3 or 4");
        }
    }

    @Given("I find the larges element in array [{int}, {int}, {int}, {int}, {int}, {int}, {int}, {int}]")
    public void iFindTheLargesElementInArray(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        int[] array = {arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7};
        int max = 0;
        for(int element : array) {
            if(max < element) {
                max = element;
            }
        }
        max = max;
        System.out.println(max + " is the largest element in " + Arrays.toString(array));
    }

    @Given("I provide integer {int} and print all the numbers up to it with conditions")
    public void iProvideIntegerAndPrintAllTheNumbersUpToItWithConditions(int arg0) {
        int num = arg0;
        String sentence = "";
        for (int i=1; i<=num; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                sentence += "FizzBuzz ";
            } else if (i % 3 == 0) {
                sentence += "Fizz ";
            } else if (i % 5 == 0) {
                sentence += "Buzz ";
            } else {
                sentence += i + " ";
            }
        }
        System.out.println(sentence);
    }

    @Given("I reverse a string {string}")
    public void iReverseAString(String arg0) {
        String str = arg0;
        String res = "";
        for(int i=str.length()-1; i>=0; i--) {
            res += str.charAt(i);
        }
        System.out.println(res);
    }

    @Given("I reverse words in sentence {string}")
    public void iReverseWordsInSentence(String arg0) {
        String str = arg0;
        ArrayList<String> arrayList = new ArrayList<>();
        String[] array = str.split(" ");
        for(int i=array.length-1; i>=0; i--) {
            arrayList.add(array[i]);
        }
        for(int i=0; i<arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}