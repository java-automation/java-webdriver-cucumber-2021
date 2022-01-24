package definitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.Scanner;
import java.util.*;
import pages.Animal;

import pages.Cat;
import pages.Dog;
import pages.Parrot;


import java.util.*;

public class JavaStepDefs<now> {
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
        } else if (num1 == num2) {
            System.out.println("Num1 is equal than Num2!");
        } else {
            System.out.println("Num1 is less than Num2!");
        }
    }

    @And("I print url for {string}")
    public void iPrintUrlFor(String page) {

        if (page.toLowerCase().equals("google")) {
            System.out.println("https://www.google.com");
        } else if (page.toLowerCase().equals("yahoo")) {
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

        if (num > 0) {
            System.out.println("Positive");
        } else {
            System.out.println(" Zero or negative");
        }
    }

    @Given("I print all numbers from zero to {int}")
    public void iPrintAllNumbersFromZeroTo(int num) {
        if (num >= 0) {
            for (int i = 0; i <= num; i = i + 1) {
                System.out.println(i);
            }
        } else {
            for (int i = 0; i >= num; i = i - 1) {
                System.out.println(i);
            }
        }
    }

    @Given("I print integer array")
    public void iPrintIntegerArray() {
        int num1 = 34;

        int[] numArr = {2, 3, 4, 5, 6, 5, 4, 5, 6, 5, 8};
        System.out.println(numArr[0]);

        boolean flag = false;

        for (int i : numArr) {
            if (i == num1) {
                flag = true;
            }
        }

        System.out.println(flag);


        System.out.println(Arrays.toString(numArr));

        int i = 5;
        double d = 5.5;

        Integer j = 5;
        Double e = 5.5;

        System.out.println(i);
        System.out.println(d);
        System.out.println(j);
        System.out.println(e);


//        List<Integer> = Array.asList(2,3,4,5,6,5,4,5,6,5,8);
    }

    @Given("I print the link for website {string}")
    public void iPrintTheLinkForWebsite(String page) {
        switch (page) {
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

      //  int i = 3;
        //    solve(i);
    }

//    void fizzBuzz(int num) {
//        System.out.println("FizzBuzz for " + num);
//    }




//    void fizzBuzz(int num) {
//        System.out.println("FizzBuzz for" + num);
//
//        for (int i = 1; i <= num; i++) {            // because it says start from i =1
//            System.out.println(i + " ");
//            if (i % 15 == 0) {
//                System.out.println("FizzBuzz");
//            } else if (i % 3 == 0){
//                System.out.println("Fizz ");
//            } else if (i % 5 == 0) {
//                System.out.println("Buzz ");
//            } else {
//                System.out.println(i + " ");
//            }
//        }
//        System.out.println();
//    }
//
//
//    private void solve(int i) {
//        for (int j = 0; j <= i; j++) {
//            //j=0
//            System.out.println(j);
//        }
//    }

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
//        for (String el : days) {
//            System.out.println(el + " "); // to print all days
//        }

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

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println("\n" + list);

       Set<String> set = new HashSet<>();
       set.add("a");
       set.add("b");
       set.add("a");
       System.out.println("\n" + set);

       ///

       Map <String, String> user = new HashMap<>();
        user.put("username", "hrag");
        user.put("email", "hragbanian@gmail.com");
        user.put("password", "welcome");
        System.out.println("\n" + user);

        Map<String, String> admin = new HashMap<>();
        admin.put("username", "Sarkis");
        admin.put("email", "sarkissian@gmail.com");
        admin.put("password", "thanks");
        System.out.println("\n" + admin);

        String username = user.get("username");
        String email = user.get("email");
        String password = user.get("password");

        System.out.println(username);
        System.out.println(email);
        System.out.println(password);




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
        String[] tiver = {"1", "2", "3", "4", "5", "6", "7", "8"};
        int length = tiver.length;


//        System.out.println(Arrays.toString(tiver));


        System.out.println(tiver[1]);
        System.out.println(tiver[tiver.length - 2]);

        byte age = 30;
        Date now = new Date();

        System.out.println(now);

        int[][] numbers = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(numbers));

    }

    @Given("I practice sorting")
    public void iPracticeSorting() {
//            int[] arr = {5, 3, 2, 6, 4, 1};
        int[] arr = {9,1,8,2,7,4,6,5,3};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    System.out.println(Arrays.toString(arr));
                }
            }
        }
    }

    @Then("I practice comparison")
    public void iPracticeComparison() {
        int x = 1;
        int y = 1;
        System.out.println(x == y);


    }

    @Then("I practice logical operators")
    public void iPracticeLogicalOperators() {
//        int temperature = 19;
//        boolean isWarm = temperature > 20 && temperature < 30;
//        System.out.println(isWarm);

        boolean hasHighIncome = true;
        boolean hasGoodCredit = true;
        boolean hasCriminalRecord = false;
        boolean isEligible = (hasHighIncome || hasGoodCredit) && hasCriminalRecord; // high income of good credit
        System.out.println(isEligible);


    }

    @Then("I practice if operators")
    public void iPracticeIfOperators() {
        int temp = 32;
        if (temp > 30) {
            System.out.println("It's a hot day, Drink plenty of water");
        } else if (temp > 20 && temp < 30 ) {
            System.out.println("It's a nice day");
        } else {
            System.out.println("It's cold");
        }
    }


    @Then("I practice if operators with {string}")
    public void iPracticeIfOperatorsWith(String roleType) {
        String type = roleType;
        if (type.equals("admin")) {
            System.out.println("You're an admin");
        } else if (type.equals("moderator")){
            System.out.println("You're a moderator");
        } else {
            System.out.println("You're a esh");
        }
    }


    @And("I solve while loop")
    public void iSolveWhileLoop() {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals("quit")) {
            System.out.println("Input: ");
            input = scanner.next().toLowerCase();
            if (!input.equals("quit")) {
                System.out.println(input);
            }
        }
    }




    @Then("I practice switch statement")
    public void iPracticeSwitchStatement() {
        String role = "admin";
        switch (role) {
            case "admin":
                System.out.println("You're an admin");
                break;
            case "moderator":
                System.out.println("You're a moderator");
                break;
            default:
                System.out.println("You're a guest");
        }
    }

    @Then("I practice insertion sort")
    public void iPracticeInsertionSort() {
        int[] arr = {9,1,8,2,7,4,6,5,3};

        for (int i=1; i < arr.length; i++) {
            var current = arr[i];
            var j = i -1;
            while (j >= 0 && arr[j] > current) {
                j--;
            }
            arr[j + 1] = current;
            System.out.println(Arrays.toString(arr));
        }
    }


    @Given("I solve coding challenges")
    public void iSolveCodingChallenges() {
//        toSwap(3, 5);
//        printDivBy3and4(12);
//
//        int [] arr = {3, 4, 1, 5, 8, 4};
//        int i = 1;
//        System.out.println(isArrayContains(arr, i));
//
        for (int i=0; i<= 100; i++) {
            if (isPrime(i)) {
                System.out.println(i + "");
            }
        }
    }

    //find if a number is a prime number
    boolean isPrime (int num) {
        if (num < 2) {
            return false;
        }

        for (int i=2; i < num; i++) {               // if i = 2; 2 can't be less than 2, so it kicks out to return True
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }



    boolean isArrayContains(int [] array, int el) {
        for (int arrayEl : array) {
            if( arrayEl == el) {
                return true;
            }
        }
        return false;
    }



    // Write a function that accepts integer number and prints
    // "divisible by 3" if number is divisible by 3
    // "divisible by 4" if element is divisible by 4
    // "divisible by 3 and 4" if divisible by 3 and 4 



    void printDivBy3and4 (int num) {
        System.out.println("Is " + num + " div by 3 and 5?");
        if (num % 3 == 0 && num % 4 == 0) {
            System.out.println("Div by 3");
        } else if (num % 4 == 0) {
            System.out.println("Div by 4");
        } else if (num % 3 == 0) {
            System.out.println("Div by 3 and 4");
        } else {
            System.out.println("Not divisible by 3 and 4");
        }
    }

    // do slide number 40 in Day 7 similar to previous code




    void toSwap(int num1, int num2) {
        System.out.println("Swap method begin - num1: " + num1 + " num2: " + num2);
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("Swap method end - num1: " + num1 + " ,num2: " + num2);
    }

    @Then("I solve FizzBuzz")
    public void iSolveFizzBuzz() {
        //        Coding challenges
//       *1) Write a function that prints all numbers from 0 up to n: 0, 1, 2, 3
//        2) Write a function that supports also negative numbers: a) 3; b) -2
//        3) Write a function that prints all integer array
//        4) Write a function that prints all even numbers from integer array
//        5) Write a function that checks if array is empty
//        6) Write a function that checks if array contains another element

//      Write a function, accepts integer argument
//      It should print all the numbers up to the argument
//      BUT:
//      if number is multiple of 3, it should print Fizz instead of number
//      if number is multiple of 5, it should print Buzz instead of number
//      if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
//      Result for 20:
//      1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz

      fizzBuzz(20);

    }

    void fizzBuzz(int num) {
        System.out.println("FizzBuzz for " + num);

        for (int i = 1; i <= num; i++) {
            if (i % 15 == 0 ) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    @And("I solve FizzBuzz with scanner")
    public void iSolveFizzBuzzWithScanner() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Number: ");
        int number = scanner.nextInt();

        if (number % 5 == 0){
            System.out.println("Fizz");
        } else if (number % 3 == 0) {
            System.out.println("Buzz");
        } else if (number % 5 == 0 && number % 3 == 0) {
            System.out.println("FizzBuzz");
        } else {
            System.out.println(number);
        }
    }




    @And("I solve reverse")
    public void iSolveReverse() {
//        getReversed("WebDriver");
//        System.out.println(getReversed("WebDriver"));
//        System.out.println(getReversedNoVar("WebDriver"));

        int[] unsortedArr = {4, 3, 1, 5, 8, 4};
        int [] sorted = sort(unsortedArr);
        System.out.println(Arrays.toString(sorted));

        String sentence = "I love WebDriver";
        printReversedWords(sentence);
    }

    void printReversedWords (String sentence) {
        System.out.println("Print reversed sentence" + sentence);
        String [] stringArray = sentence.split(" "); // in this case you will have three elements
        for (int i = stringArray.length - 1; i >= 0; i --) {
            System.out.print(stringArray[i] + " ");
        }
        System.out.println();

    }

//    void printReversed(String str) {
//        System.out.println("Print reversed " + str);
//        for (int i = str.length() -1; i >= 0; i--) {
//            System.out.print(str.charAt(i));
//        }
//        System.out.println();
//    }

    int[] sort(int [] arr) {
        for (int i = 0; i < arr.length; i++) { // if we put arr.length -1 it will skip the last number
           for (int j = i + 1; j < arr.length; j++) {
               if (arr[i] > arr[j]) {
                   int temp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = temp;
               }
            }
        }
        return arr;
    }




    String getReversedNoVar(String str) {
        System.out.println("Return reversed without extra var " + str);
        for (int i = str.length() - 1; i >= 0; i--) {
            str += str.charAt(i);
        }

        return str;
    }



    String getReversed(String str) {
        System.out.println("Return reversed " + str);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return reversed;
    }

    @Then("I calculate the mortgage")
    public void iCalculateTheMortgage() {




    }

    @And("I say the sentence five times")
    public void iSayTheSentenceFiveTimes() {
        for (int i=0; i < 5; i++)
            System.out.println("Hello World" + i);
    }


    @Given("I work with classes")
    public void iWorkWithClasses() {
        Animal myAnimal = new Animal();
        myAnimal.speak();
        System.out.println();
        System.out.println();

        Animal parrot = new Parrot();
        parrot.speak();
        parrot.sleep();
        System.out.println();



        Animal cat = new Cat("Tom");
        cat.sleep();
        cat.walk();
        cat.speak();
        cat.eat("fish");
//        cat.setName("Esh"); // we can't use Jerry otherwise it throws an error
        cat.sleep();
        System.out.println(cat.getName()); //to get the name of the cat



        Animal anotherCat = new Cat(); // no name cat
        System.out.println();
        anotherCat.sleep();
        anotherCat.walk();
        anotherCat.speak();
        System.out.println(anotherCat.getName()); // does not return any name
        System.out.println();

        Animal dog = new Dog();
        System.out.println("Dog name is " + dog.getName());
        dog.setName("Bobby");
        dog.eat("bone");
        dog.sleep();
        System.out.println(dog.getName());
        dog.speak();


        List<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(anotherCat);
        animals.add(dog);
        printAnimalNames(animals);
    }
    void printAnimalNames(List<Animal> animals) {
        System.out.println();
        System.out.println("All animal names >>>>>");
        for (Animal animal: animals) {
            System.out.println(animal.getName());
            animal.speak();

        }
    }
}



  