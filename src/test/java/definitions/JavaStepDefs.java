package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

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
}










