package definitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
//import org.assertj.core.util.Arrays;
import org.openqa.selenium.WebElement;
import pages.Animal;
import pages.Cat;
import pages.Dog;

import java.sql.SQLOutput;
import java.util.*;

public class JavaStepDefs {

    @Given("I hello World")
    public void iHelloWorld() {
        String message = "Hello World!";
        String text = "I'm an engineer";
        System.out.println(message + " " + text);

        String firstName = "john";
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.getClass());
        System.out.println(firstName.length());
        System.out.println(firstName.equals("John"));
        System.out.println(firstName.contains("jo"));
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println(str1 + ", " + str2);
        System.out.println(str1.toUpperCase() + " " + str2.toUpperCase());
        System.out.println(str1.length() + " " + str2.length());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.contains(str2));

        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        System.out.println("String 1 uppercase: " + str1.toUpperCase());
        System.out.println("String 2 uppercase: " + str2.toUpperCase());

        System.out.println("String 1 length: " + str1.length());
        System.out.println("String 2 length: " + str2.length());

        System.out.println("Exact comparison: " + (str1 == str2)); // compares refs, avoid in Java
        System.out.println("Exact comparison: " + str1.equals(str2)); // compares values

        System.out.println("Exact comparison ignoring case: " + str1.equalsIgnoreCase(str2));

        System.out.println("String 1 contains String 2?: " + str1.contains(str2));
    }

    @Given("I print {string} and {string} into console")
    public void iPrintIntoConsole(String str1, String str2) {
        System.out.println(str1 + ", " + str2);
    }

    @Given("I print {string} and {string} uppercase into console")
    public void iPrintUppercaseIntoConsole(String str1, String str2) {
        System.out.println(str1.toUpperCase() + ", " + str2.toUpperCase());
    }

    @Given("I compare {string} and {string}")
    public void iCompare(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println(str1 + " and " + str2 + " are equal");
        } else {
            System.out.println(str1 + " and " + str2 + " are not equal");
        }
    }

    @Given("I compare {string} and {string} ignoring case")
    public void iCompareIgnoringCase(String str1, String str2) {
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println(str1 + " and " + str2 + " are equal ignoring case");
        } else {
            System.out.println(str1 + " and " + str2 + " are not equal");
        }
    }

    @Given("I print {string} length and {string} length into console")
    public void iPrintLengthIntoConsole(String str1, String str2) {
        System.out.println("The length of '" + str1 + "' is: " + str1.length() + ", and the length of '" + str2 + "' is: " + str2.length());
    }

    @Given("I check if {string} contains {string}")
    public void iCheckIfContains(String str1, String str2) {
        if (str1.contains(str2)) {
            System.out.println(str1 + " contains " + str2);
        } else {
            System.out.println(str1 + " doesn't contain " + str2);
        }
    }

    @Given("I divide integer {int} by integer {int}")
    public void iDivideIntegerByInteger(int int1, int int2) {
        int result = int1 / int2;
        System.out.println(int1 + " divided by " + int2 + " equals " + result);
    }

    @Given("I divide integer {int} by float {float}")
    public void iDivideIntegerByFloat(int int1, float f1) {
        float result = (float) (int1 / f1);
        System.out.println(int1 + " divided by " + f1 + " equals " + result);
    }

    @Given("I compute the sum of integer {int} and integer {int}")
    public void iComputeTheSumOfIntegerAndInteger(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println(num1 + " plus " + num2 + " equals " + sum);
    }

    @Given("I compute the difference of integer {int} and integer {int}")
    public void iComputeTheDifferenceOfIntegerAndInteger(int num1, int num2) {
        int difference = num1 - num2;
        System.out.println(num1 + " minus " + num2 + " equals " + difference);
    }

    @Given("I compute the quotient of integer {int} and integer {int}")
    public void iComputeTheQuotientOfIntegerAndInteger(int num1, int num2) {
        int quotient = num1 / num2;
        System.out.println("The quotient of " + num1 + " and " + num2 + " is: " + quotient);
    }

    @Given("I compute the product of integer {int} and integer {int}")
    public void iComputeTheProductOfIntegerAndInteger(int num1, int num2) {
        int product = num1 * num2;
        System.out.println("The product of " + num1 + " and " + num2 + " is: " + product);
    }

    @Given("I compare my color {string} with notFavoriteColor")
    public void iCompareMyColorWithNotFavoriteColor(String color) {
        String notFavoriteColor = "brown";
        boolean b = color.equalsIgnoreCase(notFavoriteColor);
        if (b) {
            System.out.println("Sorry, your color: " + color + " is the same as my not favorite color");
        } else {
            System.out.println("Congratulations, your color: " + color + " is different from my not favorite color: " + notFavoriteColor);
        }
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num > 0) {
            System.out.println("Number:" + num + " is positive");
        } else {
            System.out.println("Number:" + num + " is negative");
        }
    }

    @And("I print {int} day of week")
    public void iPrintDayOfWeek(int dayOfWeek) {
        dayOfWeek--;
        String[] days = new String[]{"Monday",
                "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(days[dayOfWeek]);
    }

    @And("I print all numbers from zero to {int}")
    public void iPrintAllNumbersFromZeroTo(int num) {

        if (num > 0) {
            System.out.println("Positive numbers:");
            for (int i = 0; i <= num; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("Negative numbers:");
            for (int i = 0; i >= num; i--) {
                System.out.println(i);
            }
        }
    }

    @And("I print all numbers from {int} to {int}")
    public void iPrintAllNumbersFromTo(int num1, int num2) {
        int i = num1;
        while (i <= num2) {
            System.out.print(i + " ");
            i++;
        }
    }

    @And("I print all integer array")
    public void iPrintAllIntegerArray(List<Integer> intArray) {
        for (Integer i : intArray) {
            System.out.print(i + " ");
        }
    }

    @And("I print all even numbers from integer array")
    public void iPrintAllEvenNumbersFromIntegerArray(List<Integer> intArray) {
        for (Integer i : intArray) {
            if (i % 2 == 0) System.out.print(i + " ");
        }
    }

    @And("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        if (array.length == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array is not empty");
        }
    }

    @And("I check if array contains {int}")
    public void iCheckIfArrayContains(int num) {
        boolean contains = false;
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                contains = true;
                break;
            }
        }
        if (contains) {
            System.out.println("Array contains: " + num);
        } else {
            System.out.println("Array doesn't contain: " + num);
        }
    }

    //***********************************************************************************************
    @Given("I hello world")
    public void iHelloWorld2() {
        String message = "Hello World!";
        String text = "I'm an engineer!";
        System.out.println(message + " " + text);

        String firstName = "john";
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.getClass());
        System.out.println(firstName.length());
        System.out.println(firstName.equals("John"));
        System.out.println(firstName.contains("jo"));

    }

    @And("I work with numbers {int} and {int}")
    public void iWorkWithNumbersAnd(int num1, int num2) {
        System.out.println("Num1 :" + num1);
        System.out.println("Num2 :" + num2);
        System.out.println(num1 % num2);

        if (num1 > num2) {
            System.out.println("Num1 is bigger than Num2!");
        } else if (num1 == num2) {
            System.out.println("Num1 is equal Num2!");
        } else {
            System.out.println("Num1 is less than Num2!");
        }

    }

    // null - not for gherkin
    // ""
    // "google"
    // "Google"
    // "GOOGLE"
    @And("I print url for {string} page")
    public void iPrintUrlForPage(String page) {
        if (page.equalsIgnoreCase("google")) {
            System.out.println("https://www.google.com");
        } else if (page.equalsIgnoreCase("yahoo")) {
            System.out.println("https://yahoo.com");
        } else {
            throw new Error("Unknown url for page: " + page);
        }

        switch (page.toLowerCase()) {
            case "google":
                System.out.println("https://www.google.com");
                break;
            case "yahoo":
                System.out.println("https://yahoo.com");
                break;
            default:
                throw new Error("Unknown url for page: " + page);
        }
    }

    @And("I work with loops")
    public void iWorkWithLoops() {
//        System.out.println(1);
//        System.out.println(1);
//        System.out.println(1);
//        System.out.println(1);
//        System.out.println(1);
//        System.out.println(1);
//        System.out.println(1);
//        System.out.println(1);
//        System.out.println(1);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String textNum) {
        double num = Double.parseDouble(textNum);
        if (num > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Zero or negative");
        }
    }

    @And("I print {int} day of the week")
    public void iPrintDayOfTheWeek(int dayOfWeek) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println(days[dayOfWeek - 1]);
    }

    //***********************************************************************************************
    @And("I work with arrays")
    public void iWorkWithArrays() {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] nums = {5, 7, 1, 0, 10, 15};
        System.out.println(nums[2]);

        for (int i = 0; i < days.length; i++) {
            System.out.print(days[i] + " ");
        }
        System.out.println();
        for (String el : days) {
            System.out.print(el + " ");
        }

        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        for (int el : nums) {
            System.out.print(el + " ");
        }
        System.out.println();

        List<String> daysList = new ArrayList<>();
        daysList.add("Sunday");
        daysList.add("Monday");
        daysList.add("Tuesday");
        daysList.add("Wednesday");
        daysList.add("Thursday");
        daysList.add("Friday");
        daysList.add("Saturday");

        System.out.println(daysList);

        List<Integer> numsList = new ArrayList<>();
        numsList.add(5);
        numsList.add(7);
        numsList.add(1);
        numsList.add(0);
        numsList.add(10);
        numsList.add(15);

        System.out.println(numsList);

        for (String el : daysList) {
            System.out.print(el + " ");
        }
        System.out.println();
        for (int el : numsList) {
            System.out.print(el + " ");
        }

        List<Integer> list = List.of(5, 5, 6, 8);
        // it can be: List<WebElement> wel = new ArrayList<>();

        List<String> list3 = List.of("plum", "apple", "kiwi");
        System.out.println(list);
//***********************************************************************************************
        //Collection<String> list4 = new ArrayList<>(); - high level hierarchy

        List<String> list4 = new ArrayList<>();
        list4.add("a");
        list4.add("b");
        list4.add("a");
        list4.add("c");
        System.out.println("\n" + list4);

        List<String> list5 = List.of("x", "v", "z");  // you can only print, not add in this case
        list4.add("a");
        list4.add("b");
        list4.add("a");
        list4.add("c");
        System.out.println("\n" + list5);

        Set<String> set = new HashSet(); // no duplicate
        set.add("a");                    // no guarantee that the elements will be in the same order
        set.add("b");
        set.add("a");
        set.add("c");
        System.out.println("\n" + set);

        Set<String> set2 = new HashSet<>(list4); // can be Set<Integer> also
        System.out.println("\n" + set2);

        Set<String> set3 = new LinkedHashSet<>(list4); // to have the same order
        System.out.println("\n" + set3);

//******************************************************************************************
        List<String> user1 = new ArrayList<>(); // "placeholder"
        user1.add("jdoe");
        // what if someone add another value here? it's going to mess up the indexes
        // user1.add("John Doe");
        user1.add("jdoe@example.com");
        user1.add("password123");
        System.out.println("\n" + user1);

        //String username = user1.get(0);
        //String email = user1.get(1); // it's not an email anymore...
        //String password = user1.get(2);

        Map<String, String> user = new HashMap();
        user.put("username", "jdoe");
        user.put("name", "jdoe"); // it's OK to have the same value, but different key
        user.put("email", "jdoe@example.com");
        user.put("password", "password123");
        System.out.println("\n" + user);
        // you can't have the same key(duplicate keys)(by definition key is set, value is list)
        // if
        // user.put("name", "new_name"); - it will overwrite the value of the name

        Map<String, String> admin = new HashMap();
        admin.put("username", "rroe");
        admin.put("name", "Robert Roe");
        admin.put("email", "rroe@example.com");
        admin.put("password", "password456");
        System.out.println("\n" + admin);

        String username = user.get("username");
        String email = user.get("email");
        String password = user.get("password");
        String name = user.get("name");

        System.out.println(user); // output from HashMap can be not in the same order
        // Change to - LinkedHashMap - to have the output in the order, but it's slower
        // Map<String, String> user = new LinkedHashMap();
    }

    @And("I solve coding challenges")
    public void iSolveCodingChallenges() {
        toSwap(3, 5);
        int[] arr = {4, 3, 1, 5, 8, 4};
        int i = 5;
        isArrayContains(arr, i);

        int array[] = {5, 2, 9, 7, 3};
        //Write a function that swaps two array elements – 3rd and 5th
        toSwapArrEl(array, 2, 4);
        printDivBy3and4(12);

        String[] strArray = {"ab", "xy", "z"};
        String str = "z";
        System.out.println(isArrayContains2(strArray, str));

        //largestElementInArray(array);
        int array20[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println("Largest in given array is " + largestElementInArray(array));
        fizzBuzz(20);
        printFizzBuzz(array20);
        fizzBuzz(20);
        reverseString("welcome");
        printReversed("WebDriver");
        System.out.println(getReversed("WebDriver"));
        System.out.println(getReversedNoVar("WebDriver"));
        reverseWords("I love Kansas");
        sort(arr);
    }
    //O(1)
    void toSwap(int num1, int num2) {
        System.out.println("Swap method begin: num1: " + num1 + ", num2: " + num2);

        int temp = num1;
        num1 = num2;
        num2 = temp;

//        num1 = num1 + num2; // 3+5=8
//        num2 = num1 - num2; // 8-5=3 (num2)
//        num1 = num1 - num2; // 8-3=5 (num1)
//
//        num1 = num1 * num2; // 3*5=15
//        num2 = num1 / num2; // 15/5=3 (num2)
//        num1 = num1 / num2; // 15/3=5 (num1)

        System.out.println("Swap method end: num1: " + num1 + ", num2: " + num2);
    }
    //O(N^2)
    int[] sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    //O(1)
    void printDivBy3and4(int num) {
        System.out.println("\n" + "Is " + num + " div by 3 and 4?");
        if (num % 3 == 0 && num % 4 == 0) {
            System.out.println("divisible by 3 and 4");
        } else if (num % 3 == 0) {
            System.out.println("divisible by 3");
        } else if (num % 4 == 0) {
            System.out.println("divisible by 3");
        } else {
            System.out.println("Not divisible by 3 and 4");
        }
    }

    //O(N)
    boolean isArrayContains(int[] array, int el) {
        //boolean res = false;
        for (int arrayEl : array) {
            if (arrayEl == el) {
                // res = true;
                return true;
            }
        }
        // return res;
        return false;
    }

    //O(N)
    boolean isArrayContains2(String[] array, String toFind) {
        for (String arrayEl : array) {
            if (arrayEl.equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    //O(N)
    boolean isArrayContainsboth(Object[] array, Object toFind) {
        for (Object arrayEl : array) {
            if (arrayEl.equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    void isArrayContains3(int[] array, int el) {
        for (int arrayEl : array) {
            if (arrayEl == el) {
                return;
            }
        }
        return;
    }

    //**********************************************************************************************

    //1) Given array: {5,2,9,7,3}
    //Write a function that swaps two array elements – 3rd and 5th

    /**
     * Replaces value of the elements at index_el1 with the value at index_el2
     *
     * @param array     input array
     * @param index_el1
     * @param index_el2
     */

    //O(1)
    void toSwapArrEl(int array[], int index_el1, int index_el2) {

        System.out.print("Initial array: ");
        for (int el : array) {
            System.out.print(el + " ");
        }
        int temp = array[index_el1];
        array[index_el1] = array[index_el2];
        array[index_el2] = temp;

        System.out.print("\n" + "After swap: ");
        for (int el : array) {
            System.out.print(el + " ");
        }
    }

    //2) Write a function that accepts integer number and prints
    //"divisible by 3" if number is divisible by 3, "divisible by 4" if element is divisible by 4, "divisible by 3 and 4" if divisible by 3 and 4

    //3) Write a function to find the largest element in an array

    /**
     * @param arr
     */
    int largestElementInArray(int arr[]) {
        // Initialize maximum element
        int max = arr[0];

        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        return max;
    }

    //4) Write a function, accepts integer argument
    //It should print all the numbers up to the argument
    //BUT: if number is multiple of 3, it should print Fizz instead of number
    //if number is multiple of 5, it should print Buzz instead of number
    //if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
    //Result for 20:
    //1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz

    // O(N)
    void fizzBuzz(int num) {
        System.out.println("FizzBuzz for " + num);

        for (int i = 1; i <= num; i++) {
            if (i % 15 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // O(N)
    void printFizzBuzz(int array[]) {

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            boolean m = false;
            if ((value % 3) == 0) {
                System.out.print("Fizz");
                m = true;
            }
            if ((value % 5) == 0) {
                System.out.print("Buzz");
                m = true;
            }

            if (!m) {
                System.out.print(value);
            }
            System.out.print(" ");
        }
    }

    //5) Write a function that reverses string
    void reverseString(String str) {
        StringBuilder r = new StringBuilder(str).reverse();
        System.out.println("\n" + r.toString());
    }

    //O(N )
    void printReversed(String str) {
        System.out.println("Print reversed " + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    String getReversed(String str) {
        System.out.println("Return reversed " + str);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    String getReversedNoVar(String str) {
        System.out.println("Return reversed without extra var " + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            str += str.charAt(i);
        }
        return str.substring(str.length() / 2);
    }

    //6) Write a function that reverses words in a sentence
    void reverseWords(String str) {
        String[] words = str.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
    }

    //**********************************************************************************************

    @And("I do my HW for Day_10")
    public void iDoMyHWForDay10() {
        int arrayOfNum[] = {1, 1, 2, 4, 2, 1, 7, 8, 9, 10};
        int arrayOfNum2[] = {1, 7, 3, 2, 8};
     //   findMaxNum(arrayOfNum);
        System.out.println(containsDuplicateNum(arrayOfNum));
        System.out.println(containsDuplicateNum(arrayOfNum2));

        String arrayOfStr[] = {"green", "yellow", "red"};
        String arrayOfStr2[] = {"green", "yellow", "red", "green", "red"};
        System.out.println(containsDuplicateString(arrayOfStr));
        containsDuplicateString2(arrayOfStr2);
        containsDuplicateString2(arrayOfStr);

        int[] resultMax = findTwoHighestDistinctValues(arrayOfNum2);
        System.out.println("1 max = " + resultMax[0]);
        System.out.println("2 max = " + resultMax[1]);

        String name = "Anna";
        String name2 = "Maria";
        System.out.println(name + " is Polindrome: " + isPalindrome(name));
        System.out.println(name2 + " is Polindrome: " + isPalindrome(name2));
    }

    // a) Write a function that finds if array contains duplicates
    public boolean containsDuplicateNum(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicateString(String[] str) {
        for (int i = 1; i < str.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (str[i].equals(str[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    void containsDuplicateString2(String[] str) {
        for (int i = 1; i < str.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (str[i].equals(str[j])) {
                    System.out.println("Found a duplicate element in array: " + str[i]);
                }
            }
        }
        System.out.println("No duplicates found");
    }

    //b) Write a function that determines palindrome (worlds like mom, civic, anna)
    public boolean isPalindrome(String text) {
        String newText = text.replaceAll("\\s+", "").toLowerCase();
        int length = newText.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = newText.charAt(forward++);
            char backwardChar = newText.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }

    //c) Write a function that finds 2 max numbers in the array
    // O(N)
    public static int[] findTwoHighestDistinctValues(int[] array) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int value : array) {
            if (value > max) {
                secondMax = max;
                max = value;
            } else if (value > secondMax && value < max) {
                secondMax = value;
            }
        }
        return new int[]{max, secondMax};
    }

    // O(N)
    int findMaxNum(int[] numArr) {
        System.out.println("Max num in array: " + Arrays.toString(numArr));
        int max = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            if (max < numArr[i]) {
               max = numArr[i];
            }
        }
        return max;
    }

    //**********************************************************************************************

    @And("I do my HW for Day_11")
    public void iDoMyHWForDay11() {
       int arr[] = {1, 7, 3, 2, 8};
        findTwoMaxNum(arr);
    }
    //Write a function that prints two max numbers in an array
    // O(N)
    void findTwoMaxNum(int[] numArr) {
        System.out.println("Two max num in array: " + Arrays.toString(numArr));
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int i = 0; i < numArr.length; i++) {
            if (max1 < numArr[i]) {
                max2 = max1;
                max1 = numArr[i];
            } else if (max2 < numArr[i]) {
                max2 = numArr[i];
            }
        }
        System.out.println("Largest: " + max1 + " Second largest: " + max2);
    }

    //Write a function that finds if any two elements of an array result in sum

    //**********************************************************************************************

    @And("I do my HW for Day_12")
    public void iDoMyHWForDay12() {
        int num = 5;
        System.out.println("Number " + num + " is prime: " + isPrimeNumber(num));
        System.out.println("Factorial of number " + num + " is " + findFactortial(num));
    }

//    Find if a number is a prime (a natural number greater than 1 that is not a product of two smaller natural numbers)
    public boolean isPrimeNumber(int num){
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag)
            return true;
        else
           return false;
    }

//    Find factorial of a number (5! = 5 * 4 * 3 * 2 * 1)
    public long findFactortial(int num){
        long factorial = 1;
        for(int i = 1; i <= num; ++i){
            factorial *= i;
        }
        return factorial;
    }

    //**********************************************************************************************

    @Given("I work with classes")
    public void iWorkWithClasses() {

        System.out.println();
        System.out.println();

        Animal cat = new Cat("Tom");
        cat.sleep();
        cat.walk();
        cat.speak();
        cat.eat("fish");
        System.out.println(cat.getName());

        System.out.println();

        Animal anotherCat = new Cat();
        anotherCat.sleep();
        anotherCat.speak();
        System.out.println("Street cat name is " + anotherCat.getName());

        System.out.println();
        System.out.println();

        Animal dog = new Dog();
        System.out.println("Dog name is " + dog.getName());
        dog.setName("Bobby");
        dog.eat("bone");
        dog.sleep();
        dog.speak();

        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(anotherCat);
        animals.add(dog);
        printAnimalNames(animals);
    }

    void printAnimalNames(List<Animal> animals) {
        System.out.println();
        System.out.println("All animal names >>>> ");
        for (Animal animal : animals) {
            System.out.println(animal.getName());
            animal.sleep();
            animal.speak();
        }
    }
}

// Locators - XPath + DevTools (Chrome)
// IDE - Intellij CE + Cucumber (BDD)
// Java - types, JDK 17
// Coding Challenges
// WebDriver - API, basic + adv
// Page Object Model - OOP (encapsulation, inheritance, abstraction, polymorphism)
// REST API automation
// Projects - SPA, REST API project, etc.



