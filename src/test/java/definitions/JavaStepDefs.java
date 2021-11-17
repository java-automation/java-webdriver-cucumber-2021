package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.Arrays;

public class JavaStepDefs {
    @Given("I hello world")
    public void iHelloWorld() {
        System.out.println("Hello World!");

        String firstName = "John";
        String lastName = "Doe";
        String favoriteColor = "Green";
        String text1 = "Hi, my name is";
        String text2 = "my favorite color is";
        System.out.println(text1 + " " + firstName + " " + lastName + ", " + text2 + " " + favoriteColor + ".");
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str0, String str1) {
        System.out.println(str0);
        System.out.println(str1);
        System.out.println(str0.toUpperCase());
        System.out.println(str1.toUpperCase());
        System.out.println(str0.length());
        System.out.println(str1.length());
        System.out.println(str0.equals(str1));
        System.out.println(str0.equalsIgnoreCase(str1));
        System.out.println(str0.contains(str1));
    }

    @And("I work with numbers {int} and {int}")
    public void iWorkWithNumbersAnd(int num1, int num2) {
        System.out.println("Num 1: " + num1);
        System.out.println("Num 2: " + num2);
        System.out.println(num1 % num2);

        if (num1 > num2) {
            System.out.println("Num1 is greater than Num2!");
        } else if (num1 == num2) {
            System.out.println("Num1 is equal to Num2!");
        } else {
            System.out.println("Num1 is less than Num2!");
        }
    }


//    @And("I print url for {string} page")
//    public void iPrintUrlForPage(String page) {
//        if (page.toLowerCase().equals("google.com")) {
//            System.out.println("https://www.google.com");
//        } else {
//            throw new Error("Unknown url for page :"+ page);
//        }
//    }

    @And("I work with loops")
    public void iWorkWithLoops() {
        for (int i = 1; i <= 10; i = i + 1) {
            System.out.println(i);
        }
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num1) {
        if (num1 < 0) {
            System.out.println("The number is negative");
        } else if (num1 > 0) {
            System.out.println("The number is positive");
        } else {
            System.out.println("The number is zero");
        }
    }

    @And("I print all numbers from {int} to {int}")
    public void iPrintAllNumbersFromTo(int num1, int num2) {
        for (int i = num1; i <= num2; i++) {
            System.out.print(i+" ");
        }
    }

    @And("I print all numbers including negative from {int} to {int}")
    public void iPrintAllNumbersIncludingNegativeFromTo(int num1, int num2) {
        for (int i = num1; i >= num2; i--) {
            System.out.print(i+" ");
        }
    }

      @And("I print integer array")
    public void iPrintIntegerArray() {
    int[] integer = {1, 4, 8, 9, 12, 3, 7, 5, 11};
        System.out.println(Arrays.toString(integer));
    }

    @And("I print even numbers")
    public void iPrintEvenNumbers() {
        int[] nums = {3, 6, 8, 7, 5, 2, 11, 45, 20, 100};
        for (int a = 0; a < nums.length; a++){
            if (nums[a] % 2 == 0) {
            System.out.print(nums[a] + " ");}

        }
    }

    @And("I check for empty array")
    public void iCheckForEmptyArray() {
        int[] array1 = {};
        int[] array2 = {1};
        if (array1.length > 0)
        {
            System.out.println("array1 is not empty");
        }
        if (array1.length == 0)
        {
            System.out.println("array1 is empty");
        }
        if (array2.length > 0)
        {
            System.out.println("array2 is not empty");
        }
        else
        {
            System.out.println("array2 is empty");
        }
    }
}

