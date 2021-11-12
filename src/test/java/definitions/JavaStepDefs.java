package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class JavaStepDefs {

    @Given("I hello world")
    public void iHelloWorld() {
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

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        System.out.println("String 1 uppercase: " + str1.toUpperCase());
        System.out.println("String 2 uppercase: " + str2.toUpperCase());

        System.out.println("String 1 length: " + str1.length());
        System.out.println("String 2 length: " + str2.length());

        System.out.println("Exact comparison: " + ( str1 == str2 ) ); // compares refs, avoid in Java
        System.out.println("Exact comparison: " + str1.equals(str2)); // compares values

        System.out.println("Exact comparison ignoring case: " + str1.equalsIgnoreCase(str2));

        System.out.println("String 1 contains String 2?: " + str1.contains(str2));

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

    @And("I work with arrays")
    public void iWorkWithArrays() {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] nums = {5, 7, 1, 0, 10};
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

        System.out.println(numsList);

        for (String el : daysList) {
            System.out.print(el + " ");
        }
        System.out.println();
        for (int el : numsList) {
            System.out.print(el + " ");
        }
    }
}
















