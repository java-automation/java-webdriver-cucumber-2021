package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

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
    public void iPrintIfNumberIsPositive(String textNum) {
        int num = Integer.parseInt(textNum);




    }
}



