package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Arrays;
import java.util.HashMap;

public class JavaStepDefs {
    @Given("I hello world")
    public void iHelloWorld() {

        System.out.println("Hello World!");
    }

    @And("I say {string}")
    public void iSay(String arg0) {
        System.out.println(arg0);
    }

    @Given("Hi, my name is")
    public void hiMyNameIs() {
        System.out.println("Hi, my name is ");

        String firstName = "Sofia";
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.getClass());
        System.out.println(firstName.length());
        System.out.println(firstName.toLowerCase());

        String lastName = "Verk";
        System.out.println(lastName.matches("Ve"));
        System.out.println(lastName.toLowerCase());
        System.out.println(lastName.getClass());
        System.out.println(lastName.trim());
        System.out.println(false);
        System.out.println(lastName.toUpperCase());

        String color = "Yellow";
        System.out.println(color.length());
        System.out.println(color.toUpperCase());
        System.out.println(color.toLowerCase());

    }

    @Then("I type {string}, {string}, {string}")
    public void iType(String str1, String str2, String str3) {

        System.out.println(" My First Name: " + str1 + "\n " + " Last Name: " + str2 + "\n" + " My Favorite Color: " + str3);

    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String string1, String string2) {
        System.out.println("Country is: " + string1 + " Capital is : " + string2);

        System.out.println(string1.toUpperCase());
        System.out.println(string2.toUpperCase());
        System.out.println(string1.length());
        System.out.println(string2.length());
        System.out.println(string1.length());
        System.out.println(string2.length());
        System.out.println(string1.compareTo(string2));
        System.out.println(string1.compareToIgnoreCase(string2));

        if (string1.contains(string2)) {
            System.out.println("The country name contains the name of the capital.");
        } else {
            System.out.println("The country name doesn't contain the name of the capital.");
        }

        System.out.println(string1.toLowerCase());
        System.out.println(string2.toLowerCase());
        System.out.println(string1.equals(string2));
        System.out.println(string1.equalsIgnoreCase(string2));
        System.out.println(string1.contains(string2));


    }


    @Given("I have two types of number {int} and {double}")
    public void iHaveTwoTypesOfNumberAnd(int i, double f) {
        System.out.println(i);
        System.out.println(f);
    }


    @Given("Let's do some math with {int} and {int}")
    public void letSDoSomeMathWithAnd(int i, int j) {
        int k = i + 20 / j;
        System.out.println(k);

        int a = i + j;
        System.out.println(a);

        int b = i * j;
        System.out.println(b);

        int c = i - j;
        System.out.println(c);

        int d = i / j;
        System.out.println(d);

        int f = i % 3;
        System.out.println(f);
    }

    @Given("Exercises between {int} and {int}")
    public void dividingBetweenAndAnd(int num1, int num2) {

        int a = num1 / num2;
        System.out.println(a);

        double v = 1.7;
        double b = num1 / v;
        System.out.println(b);

        int sum = num1 + num2;
        System.out.println(sum);


        int difference = num1 - num2;
        System.out.println(difference);


        int quotient = num1 / num2;
        System.out.println(quotient);

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

//        if (a % 2 == 0) {
//            System.out.println(" Number is positive! ");
//        } else {
//            System.out.println("Number is negative! ");
//        }
//
//    }


    @And("I print {int} day of week")
    public void iPrintDayOfWeek(int weekday) {

        switch (weekday) {
            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday ");
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

            // or 'enhanced switch statement':
//            switch (weekday) {
//                case 1 -> System.out.println("Monday");
//                case 2 -> System.out.println("Tuesday ");
//                case 3 -> System.out.println("Wednesday");
//                case 4 -> System.out.println("Thursday");
//                case 5 -> System.out.println("Friday");
//                case 6 -> System.out.println("Saturday");
//                case 7 -> System.out.println("Sunday");


        }
    }
// 1

    @Given("Write a function that prints all numbers from {int} up to {int}")
    public void writeAFunctionThatPrintsAllNumbersFromUpTo(int num1, int num2) {
        for (int i = num1; i <= num2; i++)

            System.out.println("Number is " + i);

    }


//2

    @Then("Write a function that prints negative {int} to positive {int}")
    public void writeAFunctionThatPrintsNegativeToPositive(int num1, int num2) {

        for (int i = num1; i <= num2; i++)

            System.out.println("Number is " + i);
    }


    //3

    @And("Write a function that prints all integer array")
    public void writeAFunctionThatPrintsAllIntegerArray() {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

        System.out.println();
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i] + " ");
        }
    }

//4

    @And("Prints all even numbers from integer array")
    public void printsAllEvenNumbersFromIntegerArray() {
        int[] num = {0, 1, 5, 7, 8, 10, 13, 16, 20};

        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 != 0) {
                System.out.println("Odd Numbers: " + num[i]);
            }
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.println("Even Numbers: " + num[i]);
            }
        }


    }

    //5

    @Then("Check if array is empty")
    public void checkIfArrayIsEmpty() {
        int[] num = {1, 5, 7};

//        if (num.length == 0) {
//            return true;
//        } esle {
//            return false;
//        }

        if (num == null) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array is not empty");
        }
    }


    // 6
    @And("Check if array contains another element")
    public void checkIfArrayContainsAnotherElement() {

        int[] num = {2, 5, 7, 8, 8, 9};

        for (int el : num) {
            if (7 == el) {
                System.out.println("Element found in the num list.");
            }

        }


        String[] weatherList = {"Sunny", "Cloudy", "Snowy", "Rainy", "High humidity"};
        for (String s : weatherList) {
            if ("Sunny".equals(s)) {
                System.out.println("Element found in the weather list.");
            }
        }
    }

    @Given("Write myInfo table")
    public void writeMyInfoTable() {
        HashMap<String, String> myInfo = new HashMap<String, String>();
        myInfo.put("firstName", "Varvara");
        myInfo.put("lastName", "VV");
        myInfo.put("country", "USA");
        System.out.println(myInfo);

        HashMap<String, Integer> myYear = new HashMap<>();
        myYear.put("day", 11);
        myYear.put("month", 12);
        myYear.put("yearOfBirth", 1966);
        System.out.println(myYear);

        myYear.replace("day", 11, 30);
        System.out.println(myYear.replace("day", 11, 30));

    }


    @Then("Array sort num in ascending order for odd numbers")
    public void arraySortNumInAscendingOrderForOddNumbers() {
        //  You have an array of numbers.
//  Your task is to sort odd numbers in ascending order
//  but even numbers must be on their places.
//  Example:
//  input:  [5, 3, 2, 8, 4, 1]
//  output: [1, 3, 2, 8, 4, 5]
        int[] arr = {5, 3, 2, 8, 4, 1};
        // sort?
        sortArr(arr);
    }

    private void sortArr(int[] arr) {
        /*  [5, 3, 2, 8, 4, 1]
            [5, 3, 2, 8, 4, 1] => 1(5) => [1, 3, 2, 8, 4, 5]
            [1, | 3, 2, 8, 4, 5] => 2(idx) => [1, 2, 3, 8, 4, 5]
            [1, 2, | 3, 8, 4, 5] => [1, 2, 3, 8, 4, 5]
            [1, 2, 3, | 8, 4, 5]
        */
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1; j++) {
            int indexMin = j;
            int min = arr[indexMin];
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    indexMin = i;
                }
            }
//            int temp = arr[j];    // counting  in ascending order for all numbers in the module
//            arr[j] = min;
//            arr[indexMin] = temp;
//            System.out.println(Arrays.toString(arr));


            if (min % 2 != 0) {
                int temp = arr[j];
                arr[j] = min;
                arr[indexMin] = temp;

                System.out.println(Arrays.toString(arr));
            }
        }
    }
}
































