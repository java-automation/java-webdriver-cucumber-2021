package definitions;

import com.google.common.primitives.Ints;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.DayOfWeek;
import java.util.*;

import static java.lang.Character.toChars;
import static java.lang.System.out;
import static java.util.Arrays.asList;
import static support.TestContext.getDriver;


public class JavaStepDefs {
    @Given("I hello world")
    public void iHelloWorld() {
        out.println("Hello World!");
    }

    @And("I say {string}")
    public void iSay(String arg0) {
        out.println(arg0);
    }

    @Then("I click month {string} in Date Composer")
    public void iClickMonthStringInDateComposer(String month) {
        PredefinedStepDefs.
                elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
        PredefinedStepDefs.
                iClickOnElementWithXpath("//select[@class='ui-datepicker-month']/option[contains(text(),'" + month + "')]");
    }

    @Then("I click month {int} in Date Composer")
    public void iClickMonthIntInDateComposer(int month) {
        PredefinedStepDefs.
                elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
        PredefinedStepDefs.
                iClickOnElementWithXpath("//select[@class='ui-datepicker-month']/option[@value='" + String.valueOf(month - 1) + "']");
    }

    @Then("I click day {int} in Date Composer")
    public void iClickDayIntInDateComposer(int day) {
        PredefinedStepDefs.
                elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
        PredefinedStepDefs.iClickOnElementWithXpath("//a[contains(@class,'ui-state-default')][text()='" + String.valueOf(day) + "']");
    }

    @Then("I click day {string} in Date Composer")
    public void iClickDayStringInDateComposer(int day) {
        PredefinedStepDefs.
                elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
        PredefinedStepDefs.iClickOnElementWithXpath("//a[contains(@class,'ui-state-default')][text()='" + day + "']");
    }

    @Then("I click year {int} in Date Composer")
    public void iClickYearIntInDateComposer(int year) {
        PredefinedStepDefs.
                elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
        PredefinedStepDefs.
                iClickOnElementWithXpath("//select[@class='ui-datepicker-year']/option[@value='" + String.valueOf(year) + "']");
    }

    @Then("I click year {string} in Date Composer")
    public void iClickYearStringInDateComposer(int year) {
        PredefinedStepDefs.
                elementWithXpathShouldBeDisplayed("//div[@id='ui-datepicker-div']");
        PredefinedStepDefs.
                iClickOnElementWithXpath("//select[@class='ui-datepicker-year']/option[@value='" + year + "']");
    }

    @Then("I click back arrow button in Date Picker to change month")
    public void iClickBackArrowButtonInDatePickerToChangeMonth() {
        int currentMonth = Integer.parseInt(getAttribute("//select[@class='ui-datepicker-month']/option[@selected]", "value"));
        PredefinedStepDefs.iClickOnElementWithXpath("//a[contains(@class,'ui-datepicker-prev')]");
        int monthBack = Integer.parseInt(getAttribute("//select[@class='ui-datepicker-month']/option[@selected]", "value"));
        Assert.assertEquals(currentMonth - 1, monthBack);
    }

    public String getAttribute(String xpath, String attribute) {
        return getDriver()
                .findElement(By.xpath(xpath))
                .getAttribute(attribute);
    }

    @Then("I click forward arrow button in Date Picker to change month")
    public void iClickForwardArrowButtonInDatePickerToChangeMonth() {
        int selectedMonth = Integer.parseInt(getAttribute("//select[@class='ui-datepicker-month']/option[@selected]", "value"));
        PredefinedStepDefs.iClickOnElementWithXpath("//a[contains(@class,'ui-datepicker-next')]");
        int monthForward = Integer.parseInt(getAttribute("//select[@class='ui-datepicker-month']/option[@selected]", "value"));
        Assert.assertEquals(selectedMonth + 1, monthForward);
    }

    @Then("I click keyUp in keyboard")
    public void iClickKeyUpInKeyboard() {
        WebElement month = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        new Actions(getDriver()).sendKeys(month, Keys.ARROW_UP).perform();
        new Actions(getDriver()).sendKeys(month, Keys.ENTER).perform();
    }

    @Then("I click keyDown in keyboard")
    public void iClickKeyDownInKeyboard() {
        WebElement month = getDriver().findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        new Actions(getDriver()).sendKeys(month, Keys.ARROW_DOWN).perform();
        new Actions(getDriver()).sendKeys(month, Keys.ENTER).perform();
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String firstVariable, String secondVariable) {
        int firstVariableLength = firstVariable.length();
        int secondVariableLength = secondVariable.length();
        out.println("1) Print those variables into console as they are: " + "\n" + firstVariable + "\n" + secondVariable);
        out.println("2) Print those variables uppercase into console: " + "\n" + firstVariable.toUpperCase() + "\n" + secondVariable.toUpperCase());
        out.println("3) Print those variables length into console: " + "\n" + firstVariableLength + "\n" + secondVariableLength);
        out.println("4) Print result of exact comparison of those variables into console: ");
        if (firstVariable.equals(secondVariable)) {
            out.println(firstVariable + " matches " + secondVariable);
        } else {
            out.println(firstVariable + " doesn't matches " + secondVariable);
        }
        out.println("5) Print result of exact comparison ignoring cases of those variables into console: ");
        if (firstVariable.equalsIgnoreCase(secondVariable)) {
            out.println(firstVariable + "ignoring cases matches " + secondVariable);
        }
        out.println("6) Print result of partial comparison of those variables into console – if first variable contains second:");
        boolean isContains = false;
        for (int i = 0; i < (firstVariableLength - secondVariableLength); i++) {
            if (firstVariable.regionMatches(i, secondVariable, 0, secondVariableLength)) {
                isContains = true;
                out.println("first variable \"" + firstVariable + "\" contains second: \"" + secondVariable + "\"");
                break;
            }
        }
        if (!isContains) {
            out.println("First variable doesn't contain second");
        }
    }

    @And("I print number {string}")
    public void iPrintIfNumberIsPositive(String number) {
        //Double numberInDouble = Double.parseDouble(number);
        //Float numberInFloat = Float.parseFloat(number);
        int numberInt = Integer.parseInt(number);
        if (numberInt > 0) {
            out.println("number " + number + " is positive");
        } else if (numberInt < 0) {
            out.println("number " + number + " is negative");
        } else {
            out.println("number " + number + " is zero");
        }
    }


    @And("I print {string} day of week")
    public void iPrintDayOfWeek(String day) {
        int i = 1;
        int dayOfTheWeek = Integer.parseInt(day);
        while (i <= dayOfTheWeek) {
            out.print(" " + DayOfWeek.of(i) + " ");
            if (i < dayOfTheWeek) out.print(toChars(92));
            i++;

        }
    }

    @Given("I write all number from {int} to {int}")
    public void iWriteAllNumberFromToInt(int firstNumber, int secondNumber) {
        int i = firstNumber;
        while (i <= secondNumber) {
            out.print(i + " ");
            i++;
        }
    }

    @Given("I print integer array with length {int}")
    public void iPrintIntegerArray(int length) {
        //initialization with for loop and print array of primitives
        int[] arr1 = iInitializingIntegerArrayWithLength(length);
        out.println("\n Printing with forEach loop:");
        for (int element : arr1) {
            out.print(element + " ");
        }
        //initializing dynamic array and print with forEach loop
        out.println("\n Dynamic array:");
        List<Integer> arrDynamic = asList(2, 76, 3, 73, 2, 459);
        for (int element : arrDynamic) {
            out.print(element + " ");
        }
    }

    @Given("I initializing integer array with length {int}")
    public int[] iInitializingIntegerArrayWithLength(int length) {
        int[] arr1 = new int[length];
        for (int i = 0; i < length; i++) {
            arr1[i] = (int) (Math.random() * 200);
        }
        return arr1;
    }

    @Given("I print integer array")
    public void iPrintIntegerArray(int[] array) {
        int[] art;
        for (int element : array) {
            out.print(element + " ");
        }
    }


    @Given("I print all even numbers from integer array with length {int}")
    public void iPrintAllEvenNumbersFromIntegerArrayWithLength(int length) {
        int[] array = iInitializingIntegerArrayWithLength(length);
        out.println("\n Printing all even numbers in integer array: \n");
        for (int element : array) {
            if (element % 2 == 0) {
                out.print(element + " ");
            }
        }
    }

    @Given("is array empty")
    public boolean isEmpty(int[] array) {
        try {
            if (array.length == 0) {
                out.println("Array is Empty");
                return true;
            } else {
                out.println("\n Array is not Empty and has size = " + array.length);
                return false;
            }
        } catch (NullPointerException exception) {
            out.println("Array is not initialized");
            return false;
        }
    }

    @Given("is list empty")
    public boolean isEmpty(List<Integer> array) {
        try {
            if (array.size() == 0) {
                out.println("Array is Empty");
                return true;
            } else {
                out.println(array.size() + " is size of an list");
                return false;
            }
        } catch (NullPointerException exception) {
            out.println("Array isn't initialized");
            return false;
        }
    }

    @Given("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        //case integer array of primitives: Null, 0 length and nonEmpty.
        int[] arrNull = null;
        isEmpty(arrNull);
        int[] arrZeroLength = new int[0];
        isEmpty(arrZeroLength);
        int[] arrPrimitive = {2};
        isEmpty(arrPrimitive);
        int[] arr2 = iInitializingIntegerArrayWithLength(10);
        isEmpty(arr2);

        //case dynamic integer array of objects
        List<Integer> arrayDynamicNull = null;
        isEmpty(arrayDynamicNull);
        List<Integer> arrayDynamicEmpty = new ArrayList<>();
        isEmpty(arrayDynamicEmpty);
        List<Integer> arrayDynamic = new ArrayList<>();
        arrayDynamic.add(2021);
        isEmpty(arrayDynamic);
        arrayDynamic.remove(0);
        isEmpty(arrayDynamic);
    }

    @Given("I check if array with length {int} contains {int} element")
    public void iCheckIfArrayWithLengthContainsElement(int length, int anotherElement) {
        int[] array = iInitializingIntegerArrayWithLength(length);
        iPrintIntegerArray(array);
        boolean isContain = false;
        for (int el : array) {
            if (el == anotherElement) {
                isContain = true;
                break;
            }
        }
        if (isContain) {
            out.println("\n Element " + anotherElement + " contains in array ");
        } else {
            out.println("\n Element " + anotherElement + " doesn't contain in array");
        }
    }

    @Given("I check if array with length {int} contains {int}")
    public void iCheckIfArrayWithLengthContains(int length, int element) {
        int[] arr = iInitializingIntegerArrayWithLength(length);
        iPrintIntegerArray(arr);
        out.println("\n element  = " + element);
        out.println(Ints.contains(arr, element));
    }

    //--------------------------------------------------------------------
    @Given("I print all numbers from zero to {int}")
    public void iPrintAllNumbersFromZeroToN(int num) {
        int[] arrayPrimitiveOne = new int[num + 1];
        int i;
        for (i = 0; i <= num; i++) {
            arrayPrimitiveOne[i] = i;
        }
        out.println("arrayPrimitiveOne");
        iPrintIntegerArray(arrayPrimitiveOne);
        List<Integer> arrayDynamic = new ArrayList<>();
        for (i = 0; i <= num; i++) {
            arrayDynamic.add(i);
        }
        out.println("\n arrayDynamic:");
        out.println(arrayDynamic);
    }

    @Given("I swap {int} element and {int} in integer array with length {int}")
    public int[] iSwapElementAnd(int index1, int index2, int length) throws Error {
        if (index1 >= length || index2 >= length) {
            throw new Error("Index(es) is out of limit of array");
        } else {
            int[] arr = iInitializingIntegerArrayWithLength(length);
            out.println("\n Before:");
            iPrintIntegerArray(arr);
            out.println("\n" + index1 + " element in array = " + arr[index1 - 1]);
            out.println(index2 + " element in array = " + arr[index2 - 1]);
            int k = arr[index1 - 1];
            arr[index1 - 1] = arr[index2 - 1];
            arr[index2 - 1] = k;
            out.println("\n After swapping");
            iPrintIntegerArray(arr);
            return arr;
        }
    }

    @Given("I print list of towns starts from {string} letter")
    public void iPrintStringStartsFrom(String letter) {
        List<String> towns = asList("Austin", "Houston", "Dallas", "San Diego", "San Paulo", "Albuquerque");
        out.println(towns);
        List<String> sortedTowns =
                towns.stream().filter((town) -> town.startsWith(letter)).toList();
        out.println(sortedTowns);
    }

    @Given("I print list of towns contains only {int} letters")
    public void iPrintListOfStringsContainsNLetters(int number) {
        List<String> towns = asList("Austin", "Houston", "Dallas", "San Diego", "San Paulo", "Albuquerque");
        out.println(towns);
        List<String> sortedTowns =
                towns.stream().filter((town) -> (town.length() == number)).toList();
        out.println(sortedTowns);
    }

    @Given("I bubble sort integer array with length {int}")
    public void iBubbleSortIntegerArrayWithLength(int length) {
        int[] a = iInitializingIntegerArrayWithLength(length);
        out.println("Before:");
        iPrintIntegerArray(a);
        int k;
        int i;
        for (k = 0; k < length; k++) {
            for (i = 0; i < (length - 1 - k); i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        out.println("\n After:");
        iPrintIntegerArray(a);
    }

    @Given("We provide null not declared array to method")
    public void weProvideNullNotDeclaredArrayToMethod() {
        int[] arr = null;
        int[] arrEmpty = {};
        int[] arrNonEmpty = {7};
        out.println("arrEmpty: " + isEmptyAnotherMethod(arrEmpty));
        out.println("arrNonEmpty: " + isEmptyAnotherMethod(arrNonEmpty));
        out.println(("arr : " + isEmptyAnotherMethod(arr)));
    }

    public boolean isEmptyAnotherMethod(int[] array) throws NullPointerException {
        try {
            boolean isEmpty = false;
            if (array.length == 0) {
                isEmpty = true;
            } else out.println("We have nonEmpty array" + array.length);
            return isEmpty;

        } catch (NullPointerException exception) {
            out.println("Our array is null");
            return false;
        }
    }

    @Given("Print array with {int} of random elements from zero to {int}")
    public int[] createArrayOfRandomElementsFromZeroTo(int length, int range) {
        out.println("\n Array:");
        int[] arr1 = new int[length];
        for (int i = 0; i < length; i++) {
            arr1[i] = (int) (Math.random() * range);
            System.out.print(arr1[i] + " ");
        }
        return arr1;
    }

    @Then("Define a HashMap variable called myInfo and print some of those values in the console.")
    public void defineAHashMapVariableCalledMyInfoAndPrintSomeOfThoseValuesInTheConsole() {
        HashMap<String, String> myInfo = new HashMap<>();
        myInfo.put("firstName", "Irina");
        myInfo.put("lastName", "Gavrilova");
        myInfo.put("hometown", "Kirov");
        myInfo.put("favoriteFood", "grapes");
        out.println(myInfo.get("firstName"));
        out.println(myInfo);
        myInfo.replace("favoriteFood", "raisins");
        out.println(myInfo);
    }


    @Given("I sort array even stayed in place, odd - in ascending order")
    public void iSortArrayEvenStayedInPlaceOddInAscendingOrder() {
        iSortArrayEvenStayedInPlaceOddInAscendingOrder(new int[]{5, 3, 2, 8, 4, 1});
    }

    private void iSortArrayEvenStayedInPlaceOddInAscendingOrder(int[] arrayBeforeSorting) {
        int[] arrayAfterSorting = Arrays.stream(arrayBeforeSorting).toArray();
        ArrayList<Integer> indexOfOdds = new ArrayList<>();
        ArrayList<Integer> odds = new ArrayList<>();
        for (int i = 0; i < arrayBeforeSorting.length; i++) {
            if (arrayBeforeSorting[i] % 2 == 1) {
                indexOfOdds.add(i);
                odds.add(arrayBeforeSorting[i]);
            }
        }
        out.println("\n indexOfOdds: " + indexOfOdds);
        bubbleSortIntegerArray(odds);
        out.println("Odds elements in original array:");
        for (int i = 0; i < indexOfOdds.size(); i++) {
            arrayAfterSorting[indexOfOdds.get(i)] = odds.get(i);
        }
        out.println("arrayBeforeSorting: ");
        iPrintIntegerArray(arrayBeforeSorting);
        out.println("\n arrayAfterSorting: ");
        iPrintIntegerArray(arrayAfterSorting);
    }

    public void bubbleSortIntegerArray(ArrayList<Integer> array) {
        out.println("Before:");
        out.println(array);
        int k;
        int i;
        for (k = 0; k < array.size(); k++) {
            for (i = 0; i < (array.size() - 1 - k); i++) {
                if (array.get(i) > array.get(i + 1)) {
                    int temp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set((i + 1), temp);
                }
            }
        }
        out.println("\n After:");
        out.println(array);
    }

    @Then("I sort array with one element in order where even stayed in place, odd - in ascending order")
    public void iSortArrayWithOneElementInOrderWhereEvenStayedInPlaceOddInAscendingOrder() {
        iSortArrayEvenStayedInPlaceOddInAscendingOrder(new int[]{0});
        iSortArrayEvenStayedInPlaceOddInAscendingOrder(new int[]{1});
    }

    @Then("I sort array with length {int} and range {int} in order where even stayed in place, odd - in ascending order")
    public void iSortArrayWithLengthAndRangeInOrderWhereEvenStayedInPlaceOddInAscendingOrder(int length, int range) {
        iSortArrayEvenStayedInPlaceOddInAscendingOrder(createArrayOfRandomElementsFromZeroTo(length, range));
    }

    @And("I rearrange numbers in ascending order")
    public void iRearrangeNumbersInAscendingOrder() {
        //  You have an array of numbers.
        //  Your task is to sort odd numbers in ascending order
        //  but even numbers must be on their places.
        //  Example:
        //  input:  [5, 3, 2, 8, 4, 1]
        //  output: [1, 3, 2, 8, 4, 5]
        // int[] arr = {5, 3, 2, 8, 4, 1};

        int[] arr = createArrayOfRandomElementsFromZeroTo(15, 999);
        sortArr(arr);
    }

    private void sortArr(int[] arr) {
        /*  [5, 3, 2, 8, 4, 1]
            [5, 3, 2, 8, 4, 1] => 1(5) => [1, 3, 2, 8, 4, 5]
            [1, | 3, 2, 8, 4, 5] => 2(idx) => [1, 2, 3, 8, 4, 5]
            [1, 2, | 3, 8, 4, 5] => [1, 2, 3, 8, 4, 5]
            [1, 2, 3, | 8, 4, 5]
        */
        out.println("\n Array before sorting:");
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1; j++) { //here we do the extra redundant iteration for even number in array
            int idxMin = j;
            int min = arr[idxMin];
            for (int i = j + 1; i < arr.length; i++) { //Algorithm mistake: when we are comparing our min with even number that less our min;
                if ((arr[i] < min) && (arr[i] % 2 != 0)) { //we should only compare oly with odd numbers
                    min = arr[i];
                    idxMin = i;
                }
            }
            if (min % 2 != 0) {
                int temp = arr[j];
                arr[j] = min;
                arr[idxMin] = temp;
            }
        }
        out.println("Array after sorting: ");
        System.out.println(Arrays.toString(arr));
    }

    @Given("I create two array and combine them by alternating taking elements;")
    public void iCreateTwoArrayAndCombineThemByAlternatingTakingElements() {
        int[] firstArray = {384, 24, 11, 54,};
        int[] secondArray = {6, 57};
        alternatingTakingElements(secondArray, firstArray);
        alternatingTakingElements(firstArray, secondArray);
        alternatingTakingElements(
                createArrayOfRandomElementsFromZeroTo(4, 300),
                createArrayOfRandomElementsFromZeroTo(4, 100));
        alternatingTakingElements(new int[]{}, new int[]{346});
        alternatingTakingElements(new int[]{5}, new int[]{});
        alternatingTakingElements(new int[]{}, new int[]{});
        alternatingTakingElements(new String[]{}, new String[]{});
        alternatingTakingElements(new String[]{"apple", "mango", "red cherry", "yellow cherry"}, new int[]{3, 75, 0});
        alternatingTakingElements(new int[]{3, 7, 99}, new String[]{"apple", "mango", "red cherry", "yellow cherry"});
    }

    private int[] alternatingTakingElements(int[] firstArray, int[] secondArray) {
        int length1 = firstArray.length;
        int length2 = secondArray.length;
        int lengthFinal = length1 + length2;
        int[] finalArray = new int[lengthFinal];
        int j;
        int i = 0;
        if (length1 > length2) {
            j = length2;
            for (int k = 2 * j; k < lengthFinal; k++) {
                finalArray[k] = firstArray[k - j];
            }
        } else {
            j = length1;
            for (int k = 2 * j; k < lengthFinal; k++) {
                finalArray[k] = secondArray[k - j];
            }
        }
        while (i < j) {
            finalArray[2 * i] = firstArray[i];
            finalArray[2 * i + 1] = secondArray[i];
            i++;
        }
        out.println("First Array:");
        out.println(Arrays.toString(firstArray));
        out.println("Second Array:");
        out.println(Arrays.toString(secondArray));
        out.println("Final Array:");
        out.println(Arrays.toString(finalArray));
        return finalArray;
    }

    private String[] alternatingTakingElements(String[] firstArray, String[] secondArray) {
        int length1 = firstArray.length;
        int length2 = secondArray.length;
        int lengthFinal = length1 + length2;
        String[] finalArray = new String[lengthFinal];
        int j;
        int i = 0;
        if (length1 > length2) {
            j = length2;
            for (int k = 2 * j; k < lengthFinal; k++) {
                finalArray[k] = firstArray[k - j];
            }
        } else {
            j = length1;
            for (int k = 2 * j; k < lengthFinal; k++) {
                finalArray[k] = secondArray[k - j];
            }
        }
        while (i < j) {
            finalArray[2 * i] = firstArray[i];
            finalArray[2 * i + 1] = secondArray[i];
            i++;
        }
        out.println("First Array:");
        out.println(Arrays.toString(firstArray));
        out.println("Second Array:");
        out.println(Arrays.toString(secondArray));
        out.println("Final Array:");
        out.println(Arrays.toString(finalArray));
        return finalArray;
    }

    private String[] alternatingTakingElements(int[] firstArr, String[] secondArray) {
        int length1 = firstArr.length;
        String[] firstArray = new String[length1];
        for (int i = 0; i < length1; i++) {
            firstArray[i] = Integer.toString(firstArr[i]);
        }
        return alternatingTakingElements(firstArray, secondArray);
    }

    private String[] alternatingTakingElements(String[] firstArray, int[] secondArr) {
        int length2 = secondArr.length;
        String[] secondArray = new String[length2];
        for (int i = 0; i < length2; i++) {
            secondArray[i] = Integer.toString(secondArr[i]);
        }
        return alternatingTakingElements(firstArray, secondArray);
    }

    @Given("I print all numbers up to the argument {int}")
    public void iPrintAllNumbersUpToTheArguments(int number) {
        for (int i = 1; i <= number; i++) {
            if ((i % 3 == 0) && (i % 5 != 0)) {
                out.print("Fizz");
            } else if ((i % 3 != 0) && (i % 5 == 0)) {
                out.print("Buzz");
            } else if ((i % 3 == 0) && (i % 5 == 0)) {
                out.print("FizzBuzz");
            } else out.print(i);
            out.print(" ");
        }
    }
}
