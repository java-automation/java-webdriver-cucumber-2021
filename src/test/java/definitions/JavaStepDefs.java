package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.*;

public class JavaStepDefs {

    @Given("I hello World")
    public void iHelloWorld() {
        String message = "Hello World!";
        System.out.println(message);
        String text = "I am an Engineer";
        System.out.println(message + " " + text);

        String firstName = "Madina";
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.length());

    }

    @And("I say {string}")
    public void iSay(String arg0) {
        System.out.println(arg0);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        System.out.println("String 1 uppercase: " + str1.toUpperCase());
        System.out.println("String 2 uppercase: " + str2.toUpperCase());

        System.out.println("String 1 length: " + str1.length());
        System.out.println("String 2 length: " + str2.length());

        System.out.println("Exact comparison : " + (str1 == str2));
        System.out.println("Exact comparison : " + str1.equals(str2));

        System.out.println("Exact comparison ignoring case : " + str1.equalsIgnoreCase(str2));
        System.out.println("String 1 contains String 2? : " + str1.contains(str2));

    }
    @And("I work with numbers wit {int} and {int}")
    public void iWorkWithNumbersWitAnd(int num1, int num2) {
        System.out.println("Num1 : " + num1);
        System.out.println("Num2 : " + num2);
        System.out.println(num1/num2);

        if (num1 > num2) {
            System.out.println("Num1 is bigger than Num2!");
        } else if (num1 == num2) {
            System.out.println("Num1 iis equal to Num2");
        } else {
            System.out.println("Num1 is less than Num2");
        }
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String page) {

//        if (page.equalsIgnoreCase("google")) {
//            System.out.println("https://www.google.com");
//        } else if (page.equalsIgnoreCase("yahoo")) {
//            System.out.println("https://www.yahoo.com");
//        } else {
//            throw new Error("Unknown url for page: " + page);
//        }

        switch (page.toLowerCase()) {
            case "google" -> System.out.println("https://www.google.com");
            case "yahoo" -> System.out.println("https://www.yahoo.com");
            default -> throw new Error("Unknown url for page: " + page);
        }
    }

    @And("I work with loops")
    public void iWorkWithLoops() {

        for (int i = 1; i <= 10; i++) {
            System.out.println(i);

        }
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String textNum) {
//        if (num.contains("-")) {
//            System.out.println("Number is negative.");
//        } else if (num.equals("0")) {
//            System.out.println("Number is zero.");
//        } else {
//            System.out.println("The number " + num + " is positive.");
//        }
        int num = Integer.parseInt(textNum);

        if (num > 0) {
            System.out.println("Positive");
        } else {
            System.out.println("Zero or negative");
        }


    }

    @And("I print {int} day of the week")
    public void iPrintDayOfTheWeek(int dayOfWeek) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; //list of array, immutable

        System.out.println(Arrays.toString(days));
    }


    @Given("I solve Java task")
    public void iSolveJavaTask() {

        //Write  function that prints all numbers from 0 to n:0,1,2,3
        int i = 3;
        solve(1);
    }


    private void solve(int i) {
        for (int j = 0; j <= i; j++) {
            System.out.println(j);

        }
    }
           /*
1) Given array: {5,2,9,7,3}
Write a function that swaps two array elements – 3rd and 5th
2) Write a function that accepts integer number and prints
"divisible by 3" if number is divisible by 3 "divisible by 4" if element is divisible by 4 "divisible by 3 and 4" if divisible by 3 and 4
3) Write a function to find the largest element in an array
4) Write a function, accepts integer argument
It should print all the numbers up to the argument
BUT:
if number is multiple of 3, it should print Fizz instead of number
if number is multiple of 5, it should print Buzz instead of number
if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
Result for 20:
1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz
5) Write a function that reverses string
6) Write a function that reverses words in a sentence
    * */


    @And("I work with Arrays")
    public void iWorkWithArrays() {
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println(list);

        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println("\n" + set);

    }

    @And("Task one")
    public void taskOne() {
        // {5,2,9,7,3}
        List<Integer> numList = new ArrayList();
        numList.add(5);
        numList.add(2);
        numList.add(9);
        numList.add(7);
        numList.add(3);
        System.out.println(numList);
        int third = numList.get(2);
        int fifth = numList.get(4);
        numList.set(2, fifth);
        numList.set(4, third);
        System.out.println(numList);
    }


    @And("Task two")
    public void taskTwo() {

        divis(12);
    }


    private void divis(int num){
        if(num % 3 == 0 && num % 4 == 0){
            System.out.println("Number is divisible by 3 and 4");
        } else if (num % 3 == 0){
            System.out.println("Number is divisable by 3");
        } else if (num % 4 == 0){
            System.out.println("Number is divisable by 4");
        }

    }

    //Write a function to find the largest element in an array
    @And("Task three")
    public void taskThree() {


    }

    private Integer max(List<Integer> numList) {
        return numList.get(0);
    }


//    private int max(List<Integer> numList){
//        return numList.get(0);
//
//    }

    // Write a function that reverses string
    @And("Task Four")
    public void taskFour() {
        String word = "Madina";
        String revWord =  reverseWord(word);
        System.out.println(revWord);

    }
    public String reverseWord(String str){
        String revertStr = "";
        for (int i = str.length()-1; i >= 0; i--){
            char c = str.charAt(i);
            revertStr = revertStr.concat(String.valueOf(c));
        }
        return revertStr;
    }

        //Write a function that reverses words in a sentence
    @And("Task Six")
    public void taskSix() {
        String sentence = "Write a function that reverses words in a sentence";
        String revSent =  reverseSent(sentence);
        System.out.println(revSent);
    }

    private String reverseSent(String sentence){
        String revert = "";
        String[] strArray = sentence.split(" ");
        for(int i = 0; i < strArray.length; i++){
            strArray[i] = reverseWord(strArray[i]);
        }
        return String.join(" ", strArray);
    }
    @And("Task Five")
    public void taskFive() {
        fizzbuzz(15);

    }
    private void fizzbuzz(int num){
        System.out.println("fizzbuzz for " + num);
        for(int i = 1; i <= num; i++ ){
            System.out.print(i + " ");
            if(num % 3 == 0 && num % 5 == 0){
                System.out.print("FizzBuzz");
            }else if(num % 3 == 0){
                System.out.print("Fizz");
            }else if(num % 5 == 0){
                System.out.print("Buzz");
            }else{
                System.out.println(i + " ");
            }
        }
    }

    /* 2) Coding challenges
     a) Write a function that finds if array contains duplicates
     b) Write a function that determines palindrome (worlds like mom, civic, anna)
     c) Write a function that finds 2 max numbers in the array
     */

    @And("I write a function that finds if array contains duplicates")
    public void iWriteAFunctionThatFindsIfArrayContainsDuplicates() {


    }


    @And("I write a function that determines palindrome")
    public void iWriteAFunctionThatDeterminesPalindrome() {
        String[] words = {"mom", "racecar", "tree", "cup"};
        for(int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                System.out.println(words[i] + " - is a palindrome.");
            } else {
                System.out.println(words[i] + " - is not a palindrome.");
            }
            System.out.println();
        }
    }

    private boolean isPalindrome(String str){
        if(reverseWord(str).equals(str)){
            return true;
        }
        return false;
    }

    @And("I write a function that finds {int} max numbers in the array")
    public void iWriteAFunctionThatFindsMaxNumbersInTheArray(int arg0) {
        int[] intArray = {3,7,9,24,65,21,-76,-35,98};
        int maxVal = maxArr(intArray);
        System.out.println(maxVal);
    }
    private int maxArr(int[] arr){
        int max = -Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    @And("I solve coding challenges")
    public void iSolveCodingChallenges() {

    }

    void printReversedWords(String sentence){
        System.out.println("Print reverse sentence " + sentence);
        String[] stringArray = sentence.split(" ");
        for(int i = stringArray.length-1; i >= 0; i--){
            System.out.println(stringArray[i]+" ");
        }
        System.out.println();
    }
}

