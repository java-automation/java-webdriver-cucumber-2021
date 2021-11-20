package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class JavaStepDefs {
    @Given("I hello world")
    public void iHelloWorld() {
        String message = "Hello world";
        System.out.println(message);
        String text = "I am an engineer";
        System.out.println(message + " " + text);

        String firstName = "Hrag";
        String lastName = "Bardizbanian";
        String favoriteColor = "Green";
        System.out.println(firstName.toUpperCase());
        System.out.println(lastName.toUpperCase());
        System.out.println(favoriteColor.toUpperCase());


    }

    @And("I say {string}")
    public void iSay(String arg0) {
        System.out.println("arg0");
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {

        System.out.println("String 1:" + str1);
        System.out.println("String 2:" + str2);

        System.out.println("String 1 uppercase: " + str1.toUpperCase());
        System.out.println("String 2 uppercase: " + str2.toUpperCase());

        System.out.println("String 1 length: " + str1.length());
        System.out.println("String 2 length: " + str2.length());

        System.out.println("Exact Comparison: " + (str1 == str2)); // compares refs, avoid in Java
        System.out.println("Exact Comparison: " + str1.equals(str2)); // compares values

        System.out.println("Exact Comparison ignoring the case: " + str1.equalsIgnoreCase(str2));

        System.out.println("String 1 contains string 2?: " + str1.contains(str2));


    }

    @And("I work with numbers")
    public void iWorkWithNumbers() {

        System.out.println(1 % 3);
        System.out.println(2 % 3);
        System.out.println(3 % 3);
        System.out.println(4 % 3);
        System.out.println(5 % 3);
        System.out.println(6 % 3);
        System.out.println(7 % 3);
        System.out.println(8 % 3);
        System.out.println(9 % 3);


        int i = 10;
        int j = 5;
        int k = i + 20 / j;
        System.out.println(k);
    }

    @And("I work with numbers {int} and {int}")
    public void iWorkWithNumbersAnd(int num1, int num2) {
        System.out.println("Num1 :" + num1);
        System.out.println("Num2 :" + num2);
        System.out.println(num1 % num2);

        if (num1 > num2) {
            System.out.println("Num1 is bigger than Num2!");
        } else if (num1 == num2){
            System.out.println("Num1 is equal than Num2!");
        } else {
            System.out.println("Num1 is less than Num2!");
        }
    }

    @And("I print url for {string}")
    public void iPrintUrlFor(String page) {

        if (page.toLowerCase().equals("google")) {
            System.out.println("https://www.google.com");
        }  else if (page.toLowerCase().equals("yahoo")) {
            System.out.println("https://www.yahoo.com");
        } else {
            throw new Error(" Unknown url for page: " + page);
        }

        switch (page) {
            case "google":
                System.out.println("https://www.google.com");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com");
                break;
            default:
                System.out.println("Unknown url for page " + page);
        }

    }

    @And("I work with loops")
    public void iWorkWithLoops() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String num) {

        if (num.equals("-")) {
            System.out.println("Number is negative");
        } else if (num.equals("0")) {
            System.out.println("Is Zero");
        } else {
            System.out.println("The number " + num + " is positive");
        }
    }

    @And("I parse if number {string} is positive")
    public void iParseIfNumberIsPositive(String textNum) {
        int num = Integer.parseInt(textNum);

        if (num > 0) {
            System.out.println("positive");
        } else {
            System.out.println("zero or negative");
        }
    }

    @And("I parse if number double {string} is positive")
    public void iParseIfNumberDoubleIsPositive(String textNum) {
        double num = Double.parseDouble(textNum);

        if (num > 0){
            System.out.println("Positive");
        } else {
            System.out.println(" Zero or negative");
        }
    }

    @Given("I print all numbers from zero to {int}")
    public void iPrintAllNumbersFromZeroTo(int num) {
        if (num >= 0) {
            for (int i = 0; i <= num; i=i+1) {
                System.out.println(i);
            }
        } else {
            for (int i = 0; i >= num; i=i-1) {
                System.out.println(i);
            }
        }
    }

    @Given("I print integer array")
    public void iPrintIntegerArray() {
        int num1 = 34;

        int [] numArr = {2,3,4,5,6,5,4,5,6,5,8};

        boolean flag = false;

        for (int i : numArr) {
            if (i == num1){
                flag = true;
            }
        }

        System.out.println(flag);


        System.out.println(Arrays.toString(numArr));



//        List<Integer> = Array.asList(2,3,4,5,6,5,4,5,6,5,8);
    }

    @Given("I print the link for website {string}")
    public void iPrintTheLinkForWebsite(String page) {
        switch (page){
            case "google":
                System.out.println("https://www.google.com");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com");
                break;
            case "bing":
                System.out.println("https://www.bing.com");
                break;
            default:
                System.out.println("kak ger");
        }
    }

    @Given("I print {int} day of the week")
    public void iPrintDayOfTheWeek(int dayOfWeek) {

        switch (dayOfWeek) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("pazavang");
        }
    }

    @Then("I print with mod {int} day of the week")
    public void iPrintWithModDayOfTheWeek(int dayOfWeek) {
        int mod = dayOfWeek % 7;
        switch (mod) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("hayvan");
        }
    }




    @Given("I solve Java task")
    public void iSolveJavaTask() {
//        Coding challenges
//       *1) Write a function that prints all numbers from 0 up to n: 0, 1, 2, 3
//        2) Write a function that supports also negative numbers: a) 3; b) -2
//        3) Write a function that prints all integer array
//        4) Write a function that prints all even numbers from integer array
//        5) Write a function that checks if array is empty
//        6) Write a function that checks if array contains another element

        int i = 3;
        solve(i);
    }

    private void solve(int i) {
        for (int j = 0; j <= i; j++) {
            //j=0
            System.out.println(j);
        }
    }

    @And("I print with array {int} day of the week")
    public void iPrintWithArrayDayOfTheWeek(int dayOfWeek) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
//        System.out.println(Arrays.toString(days)); // to print all days
//        System.out.println(days[1]); // to print the second day
//        System.out.println(days[3]); // to print the 4th day
//        System.out.println(days[days.length -1]); // to print the last day
//        System.out.println(days[dayOfWeek]); // to print the number of days specified in .feature file
        System.out.println(days[dayOfWeek - 1]);
    }

    @And("I work with arrays")
    public void iWorkWithArrays() {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] nums = {5, 7, 1, 0, 10};
        String[] names = {"Hrag", "Harout", "Smpad", "Ani", "Shante"};

        System.out.println(nums[4]);
        System.out.println(Arrays.toString(nums)); // to print all the numbers in the array
        System.out.println(Arrays.toString(names));
        for (int i = 0; i < days.length; i++) {
            System.out.println(days[i] + " ");
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " ");
        }
        for (String el: days) {
            System.out.println(el + " "); // to print all days
        }

        List<String> daysList = new ArrayList<>();
        daysList.add("Sunday");
        daysList.add("Monday");

        System.out.println(daysList);

        List<Integer> numsList = new ArrayList<>();
        numsList.add(5);
        numsList.add(6);
        numsList.add(7);
        numsList.add(8);
        numsList.add(9);
        System.out.println(numsList);

        List<String> nameList = new ArrayList<>();
        nameList.add("Hrag");
        nameList.add("Harout");
        System.out.println(nameList);




    }

    @Given("I print random number {int}")
    public void iPrintRandomNumber(int number) {
       int mod = number % 10;
        switch (mod) {
            case 1:
                System.out.println("1st");
                break;
            case 2:
                System.out.println("2nd");
                break;
            case 3:
                System.out.println("3rd");
                break;
            case 4:
                System.out.println("4th");
                break;
            case 5:
                System.out.println("5th");
                break;
            case 6:
                System.out.println("6th");
                break;
            case 7:
                System.out.println("7th");
                break;
            case 8:
                System.out.println("8th");
                break;
            case 9:
                System.out.println("9th");
                break;
            case 10:
                System.out.println("10th");
                break;
        }
    }

    @Then("I print number {int} using arrays")
    public void iPrintNumberUsingArrays(int number) {
        String [] tiver = {"1","2","3","4","5","6","7","8"};
        int length = tiver.length;
//        System.out.println(Arrays.toString(tiver));
        System.out.println(tiver[1]);
        System.out.println(tiver [tiver.length - 2]);

    }

    @Given("I solve java task")
    public void iSolveJavaTask() {
        //Write a program that prints the sum of the numbers 1 to n

        int n = 5;
        solveIt
    }
}



