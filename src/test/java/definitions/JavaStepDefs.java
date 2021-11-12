package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.sql.SQLOutput;

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
        System.out.println("Num 1: "+ num1);
        System.out.println("Num 2: "+ num2);
        System.out.println(num1 % num2);

        if (num1 > num2) {
            System.out.println("Num1 is greater than Num2!");
        } else if (num1==num2) {
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
        for (int i = 1; i <= 10; i = i + 1){
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
}
