package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Cat;
import pages.Tiger;

import java.util.HashMap;
import java.util.Map;

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
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday ");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");


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
                System.out.println("Element found in the num list." + el);
            } else {
                System.out.println("Element is not found");

            }


            String[] weatherList = {"Sunny", "Cloudy", "Snowy", "Rainy", "High humidity"};
            for (String s : weatherList) {
                if ("Sunny".equals(s)) {
                    System.out.println("Element found in the weather list.");
                } else {
                    System.out.println("Element is not found");
                }
            }
        }
    }


//    @Given("Write myInfo table")
//    public void writeMyInfoTable() {
//        HashMap<String, String> myInfo = new HashMap<String, String>();
//        myInfo.put("firstName", "Varvara");
//        myInfo.put("lastName", "VV");
//        myInfo.put("country", "USA");
//        System.out.println(myInfo);
//
//        HashMap<String, Integer> myYear = new HashMap<>();
//        myYear.put("day", 11);
//        myYear.put("month", 12);
//        myYear.put("yearOfBirth", 1966);
//        System.out.println(myYear);
//
//        myYear.replace("day", 11, 30);
//        System.out.println(myYear.replace("day", 11, 30));
//
//    }

//
//    @Then("Array sort num in ascending order for odd numbers")
//    public void arraySortNumInAscendingOrderForOddNumbers() {
//        //  You have an array of numbers.
////  Your task is to sort odd numbers in ascending order
////  but even numbers must be on their places.
////  Example:
////  input:  [5, 3, 2, 8, 4, 1]
////  output: [1, 3, 2, 8, 4, 5]
//        int[] arr = {5, 3, 2, 8, 4, 1};
//        // sort?
//        sortArr(arr);
//    }
//
//    private void sortArr(int[] arr) {
//        /*  [5, 3, 2, 8, 4, 1]
//            [5, 3, 2, 8, 4, 1] => 1(5) => [1, 3, 2, 8, 4, 5]
//            [1, | 3, 2, 8, 4, 5] => 2(idx) => [1, 2, 3, 8, 4, 5]
//            [1, 2, | 3, 8, 4, 5] => [1, 2, 3, 8, 4, 5]
//            [1, 2, 3, | 8, 4, 5]
//        */
//        System.out.println(Arrays.toString(arr));
//        for (int j = 0; j < arr.length - 1; j++) {
//            int indexMin = j;
//            int min = arr[indexMin];
//            for (int i = j + 1; i < arr.length; i++) {
//                if (arr[i] < min) {
//                    min = arr[i];
//                    indexMin = i;
//                }
//            }
////            int temp = arr[j];    // counting  in ascending order for all numbers in the module
////            arr[j] = min;
////            arr[indexMin] = temp;
////            System.out.println(Arrays.toString(arr));
//
//
//            if (min % 2 != 0) {
//                int temp = arr[j];
//                arr[j] = min;
//                arr[indexMin] = temp;
//
//                System.out.println(Arrays.toString(arr));
//            }
//        }
//    }
//
//    @And("Function that combine two arrays")
//    public void iSolveJavaTask() {
////        Write a function that combines two arrays (lists) by alternating taking elements,
////        e.g. [0,5,8], [1,2,3] → [0, 1, 5, 2, 8, 3].
////        e.g. [0,5,8,  9,1], [1,2,3] → [0, 1, 5, 2, 8, 3, 9, 1].
//        int[] arr2 = {0,5,8};
//        int[] arr1 = {1,2,3,9,1};
//        solveIt(arr1, arr2);
//    }
//    private void solveIt(int[] arr1, int[] arr2) {
//        int len = arr1.length + arr2.length;
//        int[] res = new int[len];
//      int min_len = Math.min(arr1.length, arr2.length);
//        int min_len = arr1.length < arr2.length ? arr1.length : arr2.length;
//        // 3
//        for (int k = 0; k < min_len * 2; k = k + 2) {
//            res[k] = arr1[k / 2];
//            res[k + 1] = arr2[k / 2]; // k = 2; 2/2 -> 1
//        }
//        // res = [0, 1, 5, 2, 8, 3, _, _]
//        // rest of arr1: [9,1]
//        // min_len = 3
//        // [0,5,8,   9,1]
//        for (int idx = min_len; idx < arr1.length; idx++) {
//            // idx = 3
//            // idx 3 -> idx - min_len => 0
//            int res_idx = min_len * 2 + idx - min_len;
//            res[res_idx] = arr1[idx];
//        }
//        for (int idx = min_len; idx < arr2.length; idx++) {
//            // idx = 3
//            // idx 3 -> idx - min_len => 0
//            int res_idx = min_len * 2 + idx - min_len;
//            res[res_idx] = arr2[idx];
//        }
//        System.out.println(Arrays.toString(res));
//    }

//
//    @Then("Function that combine arrays with digits letters")
//    public void functionThatCombineArraysWithDigitsLetters() {
//
//        int[] arr1 = {1, 2, 3};
//        int[] arr2 = { 4, 5, 6};
//
//        trainBrain(arr1, arr2);
//    }
//    private void trainBrain(int[] arr1, int [] arr2) {

//
//        // collect 2 arrays together
//        int [] length1_2 = new int [arr1.length + arr2.length];
//        int currentPosition = 0;
//
//        for (int i = 0; i < arr1.length; i++){
//            length1_2[currentPosition] = arr1[i];
//            currentPosition++;
//        }
//
//        for (int j = 0; j< arr2.length; j++) {
//            length1_2[currentPosition] = arr2[j];
//            currentPosition++;
//
//        }
//        System.out.println(Arrays.toString(length1_2));


    //int length = arr1.length + arr2.length;
//
//        int[] result = new int [arr1.length + arr2.length];
//
//        int min_len = Math.min(arr1.length, arr2.length);
//
//
//        for  (int idx = min_len; idx < arr1.length; idx++){
//            int result_idx = min_len * 2 + idx - min_len;
//            result[result_idx] = arr1[idx];
//        }
//
//        for (int idx = min_len; idx < arr2.length; idx++) {
//            int result_idx = min_len * 2 + idx - min_len;
//            result[result_idx] = arr1[idx];
//        }
//
//        System.out.println(Arrays.toString(result));
//
//
//    }
//}

    @Given("State mapping")
    public void stateMapping() {


        Map<String, String> states = new HashMap<>();
        states.put("IL", "Illinois");
        states.put("FL", "florida");
        states.put("CA", "California");
        System.out.println("\n" + states);
    }

    //Homework 1

    @Then("Function that accept integer N and P")
    public void functionThatAcceptIntegerNAndP() {  // Function that accept integer Number  and Prints "divisible by 2" and "divisible by 5"

        printDivBy2and5(30);

    }

    void printDivBy2and5(int num) {
        if (num % 2 == 0 && num % 5 == 0) {
            System.out.println(num + " Divisible by 2 and 5 ");
        } else if (num % 2 == 0) {
            System.out.println(num + " Divisible by 2");
        } else if (num % 5 == 0) {
            System.out.println(num + " Divisible by 5");
        } else {
            System.out.println(num + " Not divisible by 2 or 5");
        }

    }


    //Homework 2

    @Then("Swap Arrays")
    public void swapArrays() { //Write a function that swaps two array elements 3rd and 5th

        swapEl(new int[]{5, 2, 9, 7, 3}, 2, 4);
    }

    void swapEl(int[] arr, int a, int b) {


        int[] array = {5, 2, 9, 7, 3};
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + arr[i]);
        }

    }

    // Homework 3
    @And("Function the largest element in an array")
    public int functionTheLargestElementInAnArray() {


        int[] array = new int[]{2, 6, 7, 20, 90, 100};
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("The largest Array " + max);
        return max;


    }


    // Homework 4
    @Given("Write function for FizzBuzz")
    public void writeFunctionForFizzBuzz() {

        int num = 35;
        fizzBuzz(num);

    }

    static void fizzBuzz(int num) {
        // Write a function, accepts integer argument if number is multiple of 3, it should print Fizz instead of number

        for (int i = 1; i <= num; i++) {
                /*
            3 - Fizz
            5 - Buzz
            3 & 5 - basics.FizzBuzz
            i */

            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else System.out.println(i + " ");

        }
    }

    @Given("function that finds if array contains duplicates")
    public void functionThatFindsIfArrayContainsDuplicates() {
        int[] arr = {1, 2, 6, 7, 9, 9, 2, 22, 13, 13};


        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] == arr[j])
                    System.out.println(arr[j]);
            }
        }


    }

    @Then("Write a function that finds two max numbers in the array")
    public void writeAFunctionThatFindsTwoMaxNumbersInTheArray() {

        int[] num = {1, 2, 3, 7, 9, 2, 22, 45, 33};

        int maxOne = 0;
        int maxTwo = 0;
        for (int n : num) {
            if (maxOne < n) {
                maxTwo = maxOne;
                maxOne = n;
            } else if (maxTwo < n) {
                maxTwo = n;
            }
            System.out.println("First Max Number: " + maxOne);
            System.out.println("Second Max Number: " + maxTwo);

        }

    }

    @And("Write a function that determines palindrome")
    public void writeAFunctionThatDeterminesPalindrome() {

        isPalindrome("comoc");
    }

    public static void isPalindrome( String str) {
        String strReverse = new StringBuffer(str).reverse().toString();

        if (str.equals(strReverse)){
            System.out.println( str +" is palindrome word");
        } else {
            System.out.println(str + " is not palindrome word");
        }
    }

    @Given("I work with classes")
    public void iWorkWithClasses() {

        Cat cat = new Cat("Tom"); //instance of object
        cat.sleep();
        cat.eat("fish");
        cat.walk();
        cat.speak();
        cat.setName("Bebe");
        System.out.println(cat.getName());

        Cat secondCat = new Cat("Marsik");
        secondCat.sleep();
        secondCat.speak();
        System.out.println(secondCat.getName());



    }

    @Then("I work with tiger")
    public void iWorkWithTiger() {

        Tiger tiger = new Tiger("Simba"); //the object

        tiger.hunt();
        tiger.mate();
        tiger.sleep();
        tiger.play();
        tiger.setName("Boba");
        System.out.println(tiger.getName());

        System.out.println(tiger.getName());



    }
}





























//  // Homework5  ----- BEtter do not touch because cucumber will not run
//    @Given("Reverse String")
//    public void reverseString() {
//
//
//        String str = "Today";
//        String newstr = "";
//        char changing;
//
//        System.out.println("Original word " + str);
//
//        for (int i = 0; i < str.length(); i++) {
//
//            changing = str.charAt(i);
//            newstr = changing + newstr;
//        }
//        System.out.println("New Word " + newstr);
//    }
//
//
//
//    @Then("Reverse words in a given string")
//    public void reverseWordsInAGivenString() {
//        String str = " I love java!";
//        String newStr = "";
//        for ( int i = str.length()- 1; i >=0; i--){
//
//           // newStr += str[i] + " ";
//        }
//        System.out.println("Reversed String: " );
//
//
//
//    }
//}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    @Given("I solve coding challenges")
//    public void iSolveCodingChallenges() {

        //toSwap(3, 5);
//        printDivBy3and4(12);
//        printDivBy3and4(9);
//        printDivBy3and4(8);
//        printDivBy3and4(7);
//        fizzBuzz(20);
//        printReversed("WebDriver");
//        System.out.println(getReversed("WebDriver"));
//        System.out.println(getReversedNoVar("WebDriver"));

//        Integer[] arr = {4, 3, 1, 5, 8, 4};
//        Integer num = 8;
//
//        String[] strArray = {"ab", "xy", "z"};
//        String str = "z";
//
//        System.out.println(isArrayContains(strArray, str));
//        System.out.println(isArrayContains(arr, num));

//        int[] unsortedArr = {4, 3, 1, 5, 8, 4};
//        int[] sorted = sort(unsortedArr);
//        System.out.println(Arrays.toString(sorted));
//        String sentence = "I love WebDriver";
//        printReversedWords(sentence);
//    }
//
//    void printReversedWords(String sentence) {
//        System.out.println("Print reverse sentence: " + sentence);
//        String[] stringArray = sentence.split(" ");
//        for (int i = stringArray.length - 1; i >= 0; i--) {
//            System.out.print(stringArray[i] + " ");
//        }
//        System.out.println();
//    }



//    void printReversed(String str) {
//        for (int i = str.length() - 1; i >= 0; i--) {
//            System.out.print(str.charAt(i));
//        }
//        System.out.println();
//    }
//
//                int[] sort(int[] arr) {
//                for (int i = 0; i < arr.length - 1; i++) {
//        for (int j = i + 1; j < arr.length; j++) {
//        if (arr[i] > arr[j]) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//        }
//        }
//        }
//        return arr;
//        }
//
//        boolean isArrayContains(Object[] array, Object toFind) {
//        for (Object arrayEl : array) {
//        if (arrayEl.equals(toFind)) {
//        return true;
//        }
//        }
//        return false;
//        }
//
//        String getReversedNoVar(String str) {
//        System.out.println("Return reversed without extra var " + str);
//        for (int i = str.length() - 1; i >= 0; i--) {
//        str += str.charAt(i);
//        }
//        return str.substring(str.length() / 2);
//        }
//
//        String getReversed(String str) {
//        System.out.println("Return reversed " + str);
//        String reversed = "";
//        for (int i = str.length() - 1; i >= 0; i--) {
//        reversed += str.charAt(i);
//        }
//        return reversed;
//        }
//
//        void printReversed(String str) {
//        System.out.println("Print reversed " + str);
//        for (int i = str.length() - 1; i >= 0; i--) {
//        System.out.print(str.charAt(i));
//        }
//        System.out.println();
//        }
//        }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////

































