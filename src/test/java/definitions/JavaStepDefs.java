package definitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaStepDefs {

    @Then("Show the greeting when I'm {string} {string} and my favorite color is {string}")
    public void showTheGreetingWhenIMAndMyFavoriteColorIs(String firstName, String lastName, String favoriteColor) {
        System.out.println("Hi, my name is " + firstName + " " + lastName + " and my favorite color is " + favoriteColor + "!");
    }

    @Then("I perform exercise on {string} and {string}")
    public void iPerformExerciseOnStringValueOneAndStringValueTwo(String stringValueOne, String stringValueTwo) {
        System.out.println("Value one: " + stringValueOne);
        System.out.println("Value two: " + stringValueTwo);
        System.out.println("Upper case one: " + stringValueOne.toUpperCase());
        System.out.println("Upper case two: " + stringValueTwo.toUpperCase());
        System.out.println("Length one: " + stringValueOne.length());
        System.out.println("Length two: " + stringValueTwo.length());
        System.out.println("Equal: " + stringValueOne.equals(stringValueTwo));
        System.out.println("Equal ignoring case: " + stringValueOne.equalsIgnoreCase(stringValueTwo));
        System.out.println("First contains second: " + stringValueOne.contains(stringValueTwo));
    }

    @Then("I perform exercise on {int} and {int}")
    public void iPerformExerciseOnNumberOneAndNumberTwo(int numberOne, int numberTwo) {
        System.out.println("Number one: " + numberOne);
        System.out.println("Number two: " + numberTwo);
        System.out.println("Number one devided by number two (int): " + numberOne / numberTwo);
        System.out.println("Number one devided by 1.5: " + numberOne / 1.5);
        int sum = numberOne + numberTwo;
        int difference = numberOne - numberTwo;
        float quotient = (float) numberOne / numberTwo;
        int product = numberOne * numberTwo;
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Quotient: " + quotient);
        System.out.println("Product: " + product);
    }

    @Then("Show the message when my favorite color is {string}, but not {string}")
    public void showTheMessageWhenMyFavoriteColorIsButNot(String favoriteColor, String notFavoriteColor) {
        System.out.println("Is my favorite color (" + favoriteColor + ") equal to " + notFavoriteColor + "? " +
                favoriteColor.equals(notFavoriteColor));
    }

    @Then("Compare {string} and {string}")
    public void compareStringOneAndStringTwo(String stringOne, String stringTwo) {
        if (stringOne.equals(stringTwo)) {
            System.out.println(stringOne + " is equal to " + stringTwo);
        } else {
            System.out.println(stringOne + " is not equal to " + stringTwo);
        }
    }

    @Then("I print URL for {string} page")
    public void iPrintURLForSitePage(String websiteReference) {
        String address = switch (websiteReference.toLowerCase()) {
            case "google" -> "https://google.com";
            case "quote form" -> "https://skryabin.com/market/quote.html";
            case "portnov school" -> "https://portnov.com";
            default -> throw new Error("No URL for this reference in our database: " + websiteReference);
        };
        System.out.println(address);
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String numStr) {
        int num = Integer.parseInt(numStr);
        if (num > 0) {
            System.out.println("Number is positive");
        } else if (num < 0) {
            System.out.println("Number is negative");
        } else {
            System.out.println("Number is zero");
        }
    }

    @And("I print day of the week that comes {int} days after today and today is {string}")
    public void iPrintDayOfTheWeekThatComesDaysAfterTodayAndTodayIs(int dayNumber, String startDayStr) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int dayShift = 0;
        for (int i = 0; i < daysOfWeek.length; ++i) {
            if (daysOfWeek[i].equals(startDayStr)) {
                dayShift = i;
            }
        }
        System.out.println(daysOfWeek[(dayNumber % 7) + dayShift]);
    }

    @And("I print my grocery list")
    public void iPrintMyGroceryList() {
        System.out.println("Basic array:");
        String[] groceryArray = {"apple", "banana", "milk", "potato", "icecream", "rice"};
        System.out.println(groceryArray);
        System.out.println(Arrays.toString(groceryArray));
        System.out.println(groceryArray[0]);
        System.out.println(groceryArray[2]);
        groceryArray[2] = "mango";
        System.out.println(groceryArray[2]);
        System.out.println();

        System.out.println("List:");
        List<String> groceryList = List.of("apple", "banana", "milk", "potato", "icecream", "rice");
        System.out.println(groceryList);
        System.out.println(groceryList.contains("apple"));
        System.out.println(groceryList.get(0));
        System.out.println(groceryList.get(2));
        //groceryList.set(2, "mango");
        System.out.println(groceryArray[2]);
        System.out.println();

        int[] numArray = {3, 234, 23, 2, 34, 67, 9};
        for (int el : numArray) {
            System.out.println(el);
        }
        for (int i = 0; i < numArray.length; ++i) {
            System.out.println(numArray[i]);
        }
        System.out.println();

        List<Integer> numList = Arrays.asList(3, 234, 23, 2, 34, 67, 9);
        for (int el : numList) {
            System.out.println(el);
        }
        numList.set(0, 300);
        for (int i = 0; i < numList.size(); ++i) {
            System.out.println(numList.get(i));
        }
        System.out.println();
    }

    @And("I print my personal info")
    public void iPrintMyPersonalInfo() {
        Map<String, String> me = new HashMap<>();
        me.put("firstName", "Dmitry");
        me.put("lastName", "Igumnov");
        me.put("hometownR", "Novosibirsk");
        me.put("hometownC", "Edmonton");
        me.put("favoriteFood", "seafood");
        System.out.println(me.get("firstName"));
        System.out.println(me.get("hometownR"));
    }

    @And("I swap two variables in different ways")
    public void iSwapTwoVariablesInDifferentWays() {
        int x = 10;
        int y = 20;
        System.out.println("Initial x: " + x);
        System.out.println("Initial y: " + y);
        System.out.println();

        int temp = x;
        x = y;
        y = temp;
        System.out.println("Final x: " + x);
        System.out.println("Final y: " + y);
        System.out.println();

        x = x * y;
        y = x / y;
        x = x / y;
        System.out.println("Final x: " + x);
        System.out.println("Final y: " + y);
        System.out.println();

        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("Final x: " + x);
        System.out.println("Final y: " + y);
        System.out.println();

        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("Final x: " + x);
        System.out.println("Final y: " + y);
        System.out.println();
    }

    @And("I swap elements with positions {int} and {int} in array of integers")
    public void iSwapElementsWithPositionsAndInArrayOfIntegers(int p1, int p2, @Transpose List<Integer> numList) {
        int[] numArr = new int[numList.size()];
        for (int i = 0; i < numList.size(); ++i) {
            numArr[i] = numList.get(i);
        }
        System.out.print("Original array: ");
        System.out.println(Arrays.toString(numArr));

        int temp = numArr[p2-1];
        numArr[p2-1] = numArr[p1-1];
        numArr[p1-1] = temp;

        System.out.print("Result: ");
        System.out.println(Arrays.toString(numArr));
    }

    @And("I check if number {int} is divisible by {int} and {int}")
    public void iCheckIfNumberIsDivisibleByAnd(int num, int div1, int div2) {
        if ((num % div1 == 0) && (num % div2 == 0)) {
            System.out.println("Divisible by " + div1 + " and " + div2);
        } else if (num % div1 == 0) {
            System.out.println("Divisible by " + div1 + " only");
        } else if (num % div2 == 0) {
            System.out.println("Divisible by " + div2 + " only");
        } else System.out.println("Not divisible by " + div1 + " and " + div2);
    }
}
