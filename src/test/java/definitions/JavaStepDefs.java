package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class JavaStepDefs {

    @Given("I hello world")
    public void iHelloWorld() {
        System.out.println("Hello World!");
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println(str1 + ", " + str2);
        System.out.println(str1.toUpperCase() + ", " + str2.toUpperCase());
        System.out.println(str1.length() + ", " + str2.length());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.contains(str2));
    }

    @Given("I perform actions with numbers")
    public void iPerformActionsWithNumbers() {
        int num1 = 15;
        int num2 = 20;
        int sum = num1+num2;
        System.out.println("Sum: " + sum);
        int difference = num1-num2;
        System.out.println("Difference: " + difference);
        int quotient = num2/num1;
        System.out.println("Quotient: " + quotient);
        int product = num1*num2;
        System.out.println("Product: " + product);
    }

    @Given("I perform actions with boolean")
    public void iPerformActionsWithBoolean() {
        String notFavoriteColor = "orange";
        String color1 = "red";
        String color2 = "orange";
        System.out.println(color1.equals(notFavoriteColor));
        System.out.println(color2.equals(notFavoriteColor));
    }

    @Given("I compare {string} and {string} strings")
    public void iCompareAndStrings(String str1, String str2) {
        if(str1.equals(str2)) {
            System.out.println("Equal!");
        } else {
            System.out.println("Not equal!");
        }
    }


    @Given("I work with numbers {int} and {int}")
    public void iInteractWithNumbersAnd(int num1, int num2) {
        System.out.println("Number 1: " + num1);
        System.out.println("Number 2: " + num2);
        System.out.println(num1 % num2);
        if (num1 > num2) {
            System.out.println("Number 1 is bigger than number 2");
        } else if (num1 == num2) {
            System.out.println("Number 1 equals number 2");
        } else {
            System.out.println("Number 1 is less than number 2");
        }
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String page) {
//        if (page.equalsIgnoreCase("google")){
//            System.out.println("https://www.google.com/");
//        } else if (page.equalsIgnoreCase("yahoo")) {
//            System.out.println("https://www.yahoo.com/");
//        } else {
//            throw new Error("Unknown url for page: " + page);
//        }

        switch (page.toLowerCase()){
            case "google":
                System.out.println("https://www.google.com/");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com/");
                break;
            default:
                throw new Error("Unknown url for page: " + page);
        }
    }

    @And("I work with loops")
    public void iWorkWithLoops() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Mysh");
        }
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num > 0) {
            System.out.println("Number is positive");
        } else if (num == 0) {
            System.out.println("Number equals 0");
        } else {
            System.out.println("Number is negative");
        }
    }

    @And("I print {int} day of week")
    public void iPrintDayOfWeek(int day) {
//        int mod = day % 7;
//        switch (mod) {
//            case 0:
//                System.out.println("Sunday");
//                break;
//            case 1:
//                System.out.println("Monday");
//                break;
//            case 2:
//                System.out.println("Tuesday");
//                break;
//            case 3:
//                System.out.println("Wednesday");
//                break;
//            case 4:
//                System.out.println("Thursday");
//                break;
//            case 5:
//                System.out.println("Friday");
//                break;
//            case 6:
//                System.out.println("Saturday");
//                break;
//            default:
//                System.out.println("The input is incorrect");
//        }

        String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(Arrays.toString(days));
        System.out.println(days[day-1]);
    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        String [] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int[] nums = {5, 7, 1, 0, 10};
        System.out.println(nums[2]);
        System.out.println(Arrays.toString(nums));
        for (int i =0; i < days.length; i++)
            System.out.print(days[i] + " ");
        System.out.println();

        System.out.println();
        List<String> daysList = new ArrayList<>();
        daysList.add("Monday");
        daysList.add("Tuesday");
        daysList.add("Wednesday");
        daysList.add("Thursday");
        daysList.add("Friday");
        daysList.add("Saturday");
        daysList.add("Sunday");
        System.out.println(daysList);

        for (String el : daysList)
            System.out.print(el + " ");

        List<String> weekList = List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
        System.out.println(weekList);

        List<Integer> numsList = new ArrayList<>();
        numsList.add(5);
        numsList.add(7);
        numsList.add(1);
        numsList.add(0);
        numsList.add(10);
        System.out.println(numsList);

    }

    @And("I print all numbers from 0 up to {int}")
    public void iPrintAllNumbersFrom0UpTo(int n) {
        for (int i = 0; i <= n; i++)
            System.out.print(i + " ");
    }

    @And("I print all numbers from {int} up to 0")
    public void iPrintAllNumbersFromUpTo0(int n) {
        for (int i = 0; i >= n; i--)
            System.out.print(i + " ");
    }

    @And("I print all integer array")
    public void iPrintAllIntegerArray() {
        int[] array = {2, 3, 7, 9, 12, 22, 49};
        System.out.println(Arrays.toString(array));
    }

    @And("I print all even numbers from integer array")
    public void iPrintAllEvenNumbersFromIntegerArray() {
        int[] array = {2, 3, 7, 9, 12, 22, 49};
        for(int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0)
                System.out.print(array[i] + " ");
        }
    }

    @And("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        int[] emptyArray = {};
        if (emptyArray.length == 0)
            System.out.println("The array is empty");
        else
            System.out.println("The array is not empty");
    }

    @And("I check if array contains {int}")
    public void iCheckIfArrayContains(int num) {
        int[] array = {2, 3, 7, 9, 12, 22, 49};
        boolean numContains = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                System.out.println("The array contains " + num);
                numContains = true;
                break;
            }
        }
        if(!numContains)
                System.out.println("The array doesn't contain " + num);
    }

    @And("I work with java")
    public void iWorkWithJava() {
        int i = 3;
        int[] array = {2, 3, 7, 81, 11, 22, 24};
        Arrays.stream(array).sorted();

    }

    @Given("I swap two variables")
    public void iSwapTwoVariables() {
        int[] array = {2, 4, 7, 9, 22};
        int a = array[0];
        int b = array[4];
        array[0] = b;
        array[4] = a;
        System.out.println(Arrays.toString(array));

        int num1 = 1;
        int num2 = 2;
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("Swap method: num1: " + num1 + ", num2: " + num2);

        int[] array1 = {5, 2, 9, 7, 3};
        //swap 3rd and 5th
        int temp1 = array1[2]; //3rd element = 9
        array1[2] = array1[4]; //put 3 from 5th element into 3rd element
        array1[4] = temp1; //put temp 9 into 5th element
        System.out.println(Arrays.toString(array1));
    }

    @And("I convert a string {string} into int")
    public void iConvertAStringIntoInt(String arg) {
        int result = Integer.parseInt(arg);
        System.out.println(result);
    }

    @And("I solve coding challenges")
    public void iSolveCodingChallenges() {
        int num = 15;
        if (num%3==0 && num%5==0)
            System.out.println(num + " is div by both 3 and 5");
        else if (num%3==0)
            System.out.println(num + " is div by 3");
        else if (num%5==0)
            System.out.println(num + " is div by 5");
        else
            System.out.println(num + " is not div neither by 3 nor 5");
    }

    @And("I check the division")
    public void iCheckTheDivision() {
        int n = 11;
        if (n%3==0 && n%4==0)
            System.out.println(n + " is divisible by both 3 and 4");
        else if (n%3==0)
            System.out.println(n + " is divisible by 3");
        else if (n%4==0)
            System.out.println(n + " is divisible by 4");
        else
            System.out.println(n + "is not divisible by 3 nor 4");
    }

    @And("I am looking for the largest element in an array")
    public void iAmLookingForTheLargestElementInAnArray() {
        int[] array = {3, 12, 6, 21, 1, 4, 5};
        int theLargest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]>theLargest){
                theLargest = array[i];
            }
        }
        System.out.println(theLargest);
    }

    @And("I am playing a FizzBuzz game")
    public void iAmPlayingAFizzBuzzGame() {
        int n = 20;
        for (int i = 1; i<= n; i++) {
            if (i%3==0 && i%5==0)
                System.out.print("FizzBuzz" + " ");
            else if (i%3==0)
                System.out.print("Fizz" + " ");
            else if (i%5==0)
                System.out.print("Buzz" + " ");
            else
                System.out.print(i + " ");
        }
    }

    @And("I reverse a string")
    public void iReverseAString() {
        String original = "WebDriver";
        System.out.println("Reverse a word: " + original);

        System.out.print("Reversed result: ");
        for (int i = original.length()-1; i >= 0; i--)
            System.out.print(original.charAt(i));
    }

    @And("I reverse words in a sentence")
    public void iReverseWordsInASentence() {
        String sentence[] = "now I know it".split(" ");
        String result = "";
        for (int i = sentence.length-1; i >= 0; i--)
            result += sentence[i] + " ";

        System.out.println("The result: " + result);
    }
}










