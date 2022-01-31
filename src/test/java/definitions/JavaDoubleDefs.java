package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.File;
import java.util.Arrays;

public class JavaDoubleDefs {
    @Given("I hello world \\(double)")
    public void iHelloWorldDouble() {
        System.out.println("Hello world");
    }

    @Given("I compare {string} and {string} \\(double)")
    public void iPerformActionsWithAndDouble(String stringOne, String stringTwo) {
        System.out.println(stringOne.equalsIgnoreCase(stringTwo));
        System.out.println(stringOne.equals(stringTwo));
    }

    @Given("I compare {string} and {string} strings \\(double)")
    public void iCompareAndStringsDouble(String stringOne, String stringTwo) {
        if (stringOne.equals(stringTwo)) {
            System.out.println(stringOne + " and " + stringTwo + ": equal");
        } else if (stringOne.equalsIgnoreCase(stringTwo)) {
            System.out.println(stringOne + " and " + stringTwo + ": equal but different case");
        } else {
            System.out.println(stringOne + " and " + stringTwo + ": not equal");
        }
    }

    @Given("I print url for {string} page \\(double)")
    public void iPrintUrlForPageDouble(String link) {
        switch (link.toLowerCase()) {
            case "google.com":
                System.out.println("https://www.google.com/");
                break;
            case "yahoo":
                System.out.println("https://www.yahoo.com/");
                break;
            default:
                throw new Error("Unknown url for page: " + link);
        }
    }

    @Given("compare numbers {int} and {int} \\(double)")
    public void compareNumbersAndDouble(int num1, int num2) {
        if (num1 > num2) {
            System.out.println(num1 + " is bigger than " + num2);
        } else if (num2 > num1) {
            System.out.println(num2 + " is bigger than " + num1);
        } else {
            System.out.println(num2 + " is equal to " + num1);
        }
    }

    @And("I repeat the word {string} {int} times with the help of loops \\(double)")
    public void iRepeatTheWordTimesWithTheHelpOfLoopsDouble(String word, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(word);
        }
    }

    @And("I print if number {int} is positive \\(double)")
    public void iPrintIfNumberIsPositiveDouble(int number) {
        if (number > 0) {
            System.out.println(number + " is positive");
        } else if (number == 0) {
            System.out.println(number + " equals 0");
        } else {
            System.out.println(number + " is negative");
        }
    }

    @And("I print {int} day of week \\(double)")
    public void iPrintDayOfWeekDouble(int day) {
        String[] week = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(week[day-1]);
    }

    @And("I work with arrays \\(double)")
    public void iWorkWithArraysDouble() {

    }

    @And("I print all numbers from {int} up to {int} \\(double)")
    public void iPrintAllNumbersFromUpToDouble(int firstNum, int lastNum) {
        for (int i = firstNum; i <= lastNum; i++) {
            System.out.print(i + " ");
        }
    }

    @And("I print all integer array \\(double)")
    public void iPrintAllIntegerArrayDouble() {
        int[] array = {3, 7, 4, 2 , 5};
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    @And("I print all even numbers from integer array \\(double)")
    public void iPrintAllEvenNumbersFromIntegerArrayDouble() {
        int[] array = {3, 7, 4, 2 , 5, 12, 22, 11};
        System.out.print("Even numbers: ");
        for (int i = 0; i < array.length; i++) {
            if (array[i]%2==0) {
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();

        for (int el : array) {
            if (el%2==0) {
                System.out.print(el + " ");
            }
        }
    }

    @And("I check if array is empty \\(double)")
    public void iCheckIfArrayIsEmptyDouble() {
        int[] array = {3, 7, 4, 2 , 5, 12, 22, 11};
        if (array.length==0) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array is not empty");
        }
    }

    @And("I check if array contains {int} \\(double)")
    public void iCheckIfArrayContainsDouble(int number) {
        int[] array = {3, 7, 4, 2 , 5, 12, 22, 11};
        boolean contains = false;
//        for (int el : array) {
//            if (el==number) {
//                contains = true;
//                break;
//            }
//        }
//        System.out.println(contains);

        //or
       for (int el : array) {
           if (el == number) {
               System.out.println("The array contains " + number);
               contains = true;
               break;
           }
       }
        if (!contains) { //то же самое, что и (contains==false)
            System.out.println("The array doesn't contain " + number);
        }
    }

    @And("I check if array contains {string} \\(double)")
    public void iCheckIfArrayContainsDouble(String word) {
        String[] strArray = {"yes", "no", "idk"};
        boolean contains = false;
        for (String el : strArray) {
            if (el.equalsIgnoreCase(word)) {
                System.out.println("The array contains " + word);
                contains = true;
                break;
            }
        }
        if (!contains) {
            System.out.println("The array doesn't contain " + word);
        }
    }

    @And("I sort an array \\(double)")
    public void iSortAnArrayDouble() {
        int[] arr = {4, 3, 1 ,5, 8, 4, 22, 0};
        System.out.println("Initial array: " + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));

        //OR
        int[] array = {4, 3, 1 ,5, 8, 4, 22, 0};
        int temp;
        System.out.println("Initial array: " + Arrays.toString(array));

        for (int i = 0; i < array.length-1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(array));



    }

    @Given("I swap two variables \\(double)")
    public void iSwapTwoVariablesDouble() {
        int[] array = {4, 3, 1 ,5, 8, 4, 22, 0};
        System.out.println("Initial: " + Arrays.toString(array));
        int temp = array[0];
        array[0] = array[array.length-1];
        array[array.length-1] = temp;
        System.out.println("Result: " + Arrays.toString(array));
    }

    @And("I convert a string {string} into int \\(double)")
    public void iConvertAStringIntoIntDouble(String input) {
        System.out.println(input+12); // строку 200 сливаем с числом 12 (получается 20012)
        int newInt = Integer.parseInt(input);
        System.out.println(newInt+12); //число 200 складываем с 12 (получаем 212)
    }

    @And("I check the division of {int} \\(double)")
    public void iCheckTheDivisionOfDouble(int num) {
        if (num%3==0 && num%5==0) {
            System.out.println(num + " is divisible by both 3 and 5");
        } else if (num%3==0) {
            System.out.println(num + " is divisible by 3");
        } else if (num%5==0) {
            System.out.println(num + " is divisible by 5");
        } else {
            System.out.println(num + " is not divisible neither by 3 nor 5");
        }
    }

    @And("I am looking for the largest element in an array \\(double)")
    public void iAmLookingForTheLargestElementInAnArrayDouble() {
        int[] array = {4, 3, 1 ,5, 8, 4, 22, 0};
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }
        System.out.println(largest);
    }

    @And("I am playing a FizzBuzz game \\(double)")
    public void iAmPlayingAFizzBuzzGameDouble() {
        //Print integers 1 to N, but print “Fizz” if an integer is divisible by 3, “Buzz” if an integer is divisible by 5,
        //and “FizzBuzz” if an integer is divisible by both 3 and 5.
        int n = 20;
        for (int i = 1; i <= n; i++) {
            if (i%3==0 && i%5==0) {
                System.out.print("FizzBuzz ");
            } else if (i%3==0) {
                System.out.print("Fizz ");
            } else if (i%5==0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    @And("I am playing a Fibonacci game \\(double)")
    public void iAmPlayingAFibonacciGameDouble() {
        //The Fibonacci series is a series of elements where, the previous two elements
        // are added to get the next element, starting with 0 and 1.
        int n = 11;
        int num1 = 0;
        int num2 = 1;

        for (int i = 0; i < n; i++) {
            System.out.print(num1 + " ");

            int num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
    }


    @And("I reverse a string {string} \\(double)")
    public void iReverseAStringDouble(String word) {
        System.out.println("Initial: " + word);
        System.out.print("Result: ");

        for (int i = word.length()-1; i >= 0; i--) {
            System.out.print(word.charAt(i));
        }
    }

    @And("I reverse words in a sentence {string} \\(double)")
    public void iReverseWordsInASentenceDouble(String sentence) {
        System.out.println("Initial sentence: " + sentence);
        String[] splittedSentence = sentence.split(" ");
        System.out.println("The number of words in the sentence: " + splittedSentence.length);
        System.out.print("Reversed sentence: ");

        for (int i = splittedSentence.length-1; i>=0; i--) {
            System.out.print(splittedSentence[i] + " ");
        }
    }

    @And("I check if there are duplicates in an array \\(double)")
    public void iCheckIfThereAreDuplicatesInAnArrayDouble() {
        int[] array = {1, 12, 4, 3, 1 ,5, 8, 4, 22};

        boolean doublePresence = false;

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i]==array[j]) {
                    System.out.println("There is a duplicate in the array: " + array[i]);
                    doublePresence = true;
                }
            }
        }
        if (!doublePresence) {
            System.out.println("There are no duplicates in the array");
        }
    }

    @And("I determine if {string} is a palindrome \\(double)")
    public void iDetermineIfIsAPalindromeDouble(String word) {
        System.out.println("Initial word: " + word);
        String reversedWord = "";
        for (int i = word.length()-1; i >= 0; i-- ) {
            reversedWord+=word.charAt(i);
        }
        if (reversedWord.equals(word)) {
            System.out.println(word + " is a palindrome");
        } else {
            System.out.println(word + " is not a palindrome");
        }
    }

    @And("I find the max number in array \\(double)")
    public void iFindTheMaxNumberInArrayDouble() {
        int[] array = {1, 12, 4, 3, 1 ,5, 8, 4, 22};
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Max: " + max);
    }

    @And("I find two max numbers in array \\(double)")
    public void iFindTwoMaxNumbersInArrayDouble() {
        //int[] array = {1, 12, 4, 3, 1 ,5, 8, 4, 22};
        int[] array = {1, 12, 4, 3, 1 ,5, 8, 4, 22, 22};
        Arrays.sort(array);
        int max1 = array[array.length-1];
        int max2 = Integer.MIN_VALUE;

        for (int i = array.length - 2; i>=0; i--) {
            if (max1!=array[i]) {
                max2 = array[i];
                break;
            }
        }
        System.out.println("Max1: " + max1 + ", max2: " + max2);

    }

    @And("I find the min number in array \\(double)")
    public void iFindTheMinNumberInArrayDouble() {
        int[] array = {1, 12, 4, 3, 1 ,5, 8, 4, 22};
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Min: " + min);
    }


    @And("I find if {int} is a prime number \\(double)")
    public void iFindIfIsAPrimeNumberDouble(int number) {
        boolean notPrime = false;
        if (number==0 || number==1) {
            System.out.println("This is an exception to the rule");
        } else {
            for (int i = 2; i < number; i++) { //делитель
                if (number%i==0) {
                    System.out.println(number + " is not a prime number");
                    notPrime = true;
                    break;
                }
            }
            if (!notPrime) {
                System.out.println(number + " is a prime number");
            }
        }
    }

    @And("I find factorial of {int} \\(double)")
    public void iFindFactorialOfDouble(int number) {
        int factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial*=i;
        }
        System.out.println("Factorial of " + number + " is " + factorial);
    }

    @And("I check whether {string} is a vowel or not \\(double)")
    public void iCheckWhetherIsAVowelOrNotDouble(String letterStr) {
        char letter = letterStr.charAt(0);
        char[] array = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'}; //vowel letters
        boolean vowel = false;

        for (char el : array) {
            if (letter==el) {
                System.out.println(letter + " is a vowel");
                vowel = true;
                break;
            }
        }
        if (!vowel) {
            System.out.println(letter + " is not a vowel");
        }
    }
}
