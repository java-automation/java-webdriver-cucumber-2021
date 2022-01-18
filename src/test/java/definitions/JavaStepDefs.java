package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Cat;

import java.util.*;

//Try calling different methods on String variables you
//        declared and print the results. Use methods such as
//        length(), getClass(), toLowerCase(), toUpperCase(), trim(),
//        isEmpty();
//        You can see all String methods by just clicking . after String.
//        For reference, can go to
//        https://docs.oracle.com/javase/11/docs/api/java/lang/String.
//        html
public class JavaStepDefs {
    @Given("I write hello world")
    public void iWriteHelloWorld() {
        String message = "Hello world";
        String text = " I'm a QA engineer ";
        System.out.println("Hello World");
        String firstName = "john";
        System.out.println(firstName.toUpperCase(Locale.ROOT));
        System.out.println(firstName.toLowerCase(Locale.ROOT));
        System.out.println(firstName.getClass());
        System.out.println(firstName.length());
        System.out.println(firstName.equals("John"));
        System.out.println(firstName.contains("jo"));
        System.out.println(text.trim()); // trim -  removes the spaces
        System.out.println(firstName.isEmpty());
        System.out.println(text.indexOf("QA")); // Java counts positions from zero.
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

//    Using variables firstName, lastName and favoriteColor
//    print to the console:
//   "Hi, my name is (first name) (last name), my favorite
//    color is (favorite color)."
//    Add a variable named notFavoriteColor and assign it to a
//    different color.
//    Print comparison result to see if these variables are equal.

    @Given("I declare String variables")
    public void iDeclareStringVariables() {
        String firstName ="Olga";
        String last ="last", first ="first";
        String lastName ="Alferova";
        String favoriteColor ="burgundy";
        String notFavoriteColor = "red";
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(favoriteColor);
        System.out.println("Hi, my name is " +firstName+" " +lastName +"," +
                " my favorite color is " +  favoriteColor +".");
        System.out.println("My favorite color is equals to not favorite one = " + favoriteColor.equals(notFavoriteColor));
    }

    //    Given I perform actions with "my var" and "my VAR"
//1) Print those variables into console as they are
//2) Print those variables uppercase into console
//3) Print those variables length into console
//4) Print result of exact comparison of those variables into console
//5) Print result of exact comparison ignoring cases of those variables into console
//6) Print result of partial comparison of those variables into console – if first variable contains second
//    Once complete, write few steps with different variables.Use System.out.println(), toUpperCase(), length(), equals(), equalsIgnoreCase(), contains()

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithStrings(String argument1, String argument2) {
        System.out.println("var is = " +argument1);
        System.out.println("VAR is = " +argument2);
        System.out.println("To upper case = " +argument1.toUpperCase(Locale.ROOT)+" "+ argument2.toUpperCase(Locale.ROOT));
        System.out.println("var length = " +argument1.length());
        System.out.println("VAR length = " +argument2.length());
        System.out.println(argument1.equals("my var"));
        System.out.println(argument2.equals("my VAR"));
        System.out.println(argument1.equalsIgnoreCase("my var"));
        System.out.println(argument2.equalsIgnoreCase("my var"));
        System.out.println("Strings are equal :" +argument1.equals(argument2)); // for Sting is better use .equals!
        System.out.println("Strings are equal :" +(argument1==argument2)); // this == compares reference not the actual values!
        System.out.println(argument1.contains("my"));
        System.out.println(argument2.contains("my"));
    }

    // Numbers exercises
//    Try dividing an integer by an integer and print results to the console.
//    Try dividing an integer by a float. How are the results different?
//    Create two integer variables called num1 and num2 and assign them
//    your favorite numbers.
//    Next, compute the sum, difference, quotient, and product of these two
//    numbers and assign these values to variables called sum, difference,
//    quotient, and product, respectively.

    @Given("I perform actions with numbers {int} and {int}")
    public void iPerformActionsWithNumbers(int num1, int num2) {
        System.out.println("num1 ="+num1 + " num2 = "+num2);
        System.out.println(num2/num1);
        int sum = num1+num2;
        System.out.println(sum);
        int difference = num1-num2;
        System.out.println(difference);
        int quotient = num1/num2;
        System.out.println(quotient);
        int product = num1*num2;
        System.out.println(product);
        System.out.println(10%3); // reminder (what is left) Result is 1
        System.out.println(9%3);// reminder (what is left) Result is 0
    }
//this method doesn't work, Cucumber issue?
//    @And("I perform actions with float numbers {int} and {double}")
//    public void iPerformActionsWithNumbers(int num1, double num2) {
//        System.out.println("num1 ="+num1 + " num2 = "+num2);
//        System.out.println(num2/num1);
//    }

//    Try dividing an integer by a float. How are the results different?
    @And("I perform actions with float numbers {int} and {double}")
    public void iPerformActionsWithFloatNumbers(int num1, double num2) {
        System.out.println(num2/num1);
    }

//    Create step definition
//    I compare "string1" and "string2" strings
//    It would accept two parameters as strings, check if they’re equal
//    and print result in console. Examples:
//    I compare "string1" and "string2" strings
//=> not equal!
//    I compare "string1" and "string2" strings
//=> equal!

    @Given("I compare {string} and {string} strings")
    public void iCompareStrings(String oneSting, String twoString) {
        if (oneSting.equals(twoString)) {
            System.out.println("Strings are equal!");
        }
        else System.out.println("Strings are NOT equal!");
    }
//    Create step definition
//    I print url for "site" page
//    It would accept one parameter – site and will print in console url for that
//    site. Examples:
//    I print url for "google" page
//=> https://www.google.com
//    I print url for "sample" page
//=> https://skryabin.com/webdriver/html/sample.html

    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String site) {
//        if (site.equalsIgnoreCase("google")) {
//            System.out.println("URL: https://www.google.com");
//        }
//        else if (site.equalsIgnoreCase("sample")) {
//            System.out.println("URL: https://skryabin.com/webdriver/html/sample.html");
//        }
//        else
//            throw new Error ("URL: not defined!");// Error is just short Exception
//            System.out.println("URL: not defined!");
//        });

        switch (site.toLowerCase()) { // first we made everything in lower case!
            case "google":
                System.out.println("URL: https://www.google.com");
                break;
            case "sample":
                System.out.println("URL: https://skryabin.com/webdriver/html/sample.html");
                break;
            default:
                throw new Error ("URL: not defined! " + site);
        }

//         from Java 14
        switch (site.toLowerCase()) {
            case "google"-> System.out.println("URL: https://www.google.com");
            case "sample"-> System.out.println("URL: https://skryabin.com/webdriver/html/sample.html");
            default -> throw new Error ("URL: not defined!"+site);
        }
    }

    @Given("I compare numbers {int} and {int}")
    public void iCompareNumbersAnd(int num1, int num2) {
            System.out.println("Number 1: "+num1);
            System.out.println("Number 21: "+num2);
            System.out.println(num1%num2);

            if(num1>num2) {
                System.out.println("Number 1 is bigger than number 2");
            }
            else if (num1==num2){
                System.out.println("Number 1 is equal to number 2");
            }
            else System.out.println("Number 1 is less than number 2");
        }

    @Given("I work with Loops")
    public void iWorkWithLoops() {
        for(int i=1;i <=10;i++) {
            System.out.println(i); // print from 1-10
        }

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        for (String make : cars) {
            System.out.println(make);}
    }

    @Given("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String number) {
        int iNumber = Integer.parseInt(number); // convert String to int
        if (iNumber > 0) {
            System.out.println("Number is positive " + iNumber);
        }
        else if (iNumber == 0) {
            System.out.println("Number is zero " +iNumber);
        }
        else System.out.println("Number is negative " + iNumber);
    }

    @And("I print {string} th day of week")
    public void iPrintThDayOfWeek(String dayNumber) {
        switch (dayNumber.toLowerCase()) {
//            int modules = dayNumber%7; любое число разделить на 7 и это будет 1-7 число и тогда 204 будет понедельник.
            case "1"-> System.out.println("Monday");
            case "2"-> System.out.println("Tuesday");
            case "3"-> System.out.println("Wednesday");
            case "4"-> System.out.println("Thursday");
            case "5"-> System.out.println("Friday");
            case "6"-> System.out.println("Saturday");
            case "7"-> System.out.println("Sunday");
            default -> throw new Error ("No such day in a week! "+dayNumber);
        }
    }

    //or same can be done using Map
    @Then("I print one more {string} th day of week")
    public void iPrintOneMoreStringThDayOfWeek(String dayNumber) {
        Map<String,String> days = Map.of(
                "1","Monday",
                "2","Tuesday",
                "3","Wednesday",
                "4","Thursday",
                "5","Friday",
                "6","Saturday",
                "7","Sunday");
        System.out.println(days.get(dayNumber));
    }

    @Given("I reverse string {string}")
    public void iReverseString(String valueToReverse) {
        String reversed = "";
        for (int i=0; i < valueToReverse.length(); i++) {
            reversed = valueToReverse.charAt(i) + reversed;
            System.out.println(reversed);
        }
    }

    @Then("I reverse")
    public void iReverse() {
        // input "hello" return "olleh"
        String s = "hello";
        String reverse = "";
        for (int i = 0; i < s.length(); i++) {
            reverse = s.charAt(i) + reverse;
            System.out.println(reverse);
            //return reversed;
        }

//       // OR
//        printReverse("WebDriver");
    }

    // lesson 8 = 50 mins
//    String printReverse (String str) {
//        System.out.println("Print reversed" + str);
//        String reverse = "";
//        for (int i =str.length()-1; i>= 0; i--) {
//            reverse += str.charAt(i);
//        }
//        return reverse;
//    }

    @Given("I print FizzBuzz")
// "Write a program that prints the numbers from 1 to 100.
// But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”.
// For numbers which are multiples of both three and five print “FizzBuzz”."
    public void iPrintFizzBuzz() {
       for (int i=1;i <= 100;i++) {
           if (i%3==0 && i%5==0) { // or i%15==0
               System.out.println("FizzBuzz");
           } else if (i%3==0) {
               System.out.println("Fizz");
           } else if (i%5==0) {
               System.out.println("Buzz");
           } else System.out.println(i);
       }
    }

    @And("I print {int} th day of week with Array")
    public void iPrintThDayOfWeekWithArray(int dayOfWeek) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
//        String dayStrings = Arrays.toString(days);
//        System.out.println(dayStrings);
        System.out.println((days[dayOfWeek-1])); // because index start with 0
//        you don't need additional dayString valuable as it's only used one
    }

    @Given("I work with Array")
    public void iWorkWithArray() {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
        int[] nums = {5,7,1,0,10}; // but can't add new values here with more indexes
        System.out.println(nums[2]); // print second in the array

        System.out.println(Arrays.toString(days)); // print all Array values

        for(int i=0; i < days.length; i++) { //i <= --> use length-1 because last index will be out of bound!
            System.out.println(days[i] + " ");
        }
        for (int i=0; i < nums.length; i++) {
            System.out.println(nums[i] + " ");
        }
        for (String element : days) {  // for each!! but you can't change it and get some index!
            System.out.println(element);
        }

        //dynamic Arrays = List - you can add more indexes with this!
        List<String> dayList = new ArrayList<>(); // new ArrayList<>() is an object for the created List
        // also can be new LinkedList but ArrayList is easy and faster.
//        List<String> dayList = List.of("Mon","Tue"); can be created this way!
        dayList.add("Sunday");
        dayList.add("Monday");
        dayList.add("Wednesday");
        dayList.add("Thursday");
        dayList.add("Friday");
        dayList.add("Saturday");
        System.out.println(dayList);
        // long l =(long) 6.0;

        for (String day : dayList) {
            System.out.println(day + " ");
        }

        //same for the Integer
        List<Integer> numbers = new ArrayList<>();
            numbers.add(5);
            numbers.add(7);
            numbers.add(1);
            numbers.add(0);
            numbers.add(10);
        System.out.println(numbers);

            for (Integer number : numbers) { // int can be used in Integer wrapper list too!
                System.out.println(number + " ");
            }
    }

    @Given("I work with Maps")
    public void iWorkWithMaps() {
    List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("a");
        System.out.println("\n" + list);

        Set<String> mySet = new HashSet<>();
        mySet.add("a");
        mySet.add("b");
        mySet.add("a");
        System.out.println("\n" + mySet);

        Set<String> mySet2 = new LinkedHashSet<>(); // keep the order
        mySet2.add("a");
        mySet2.add("b");
        mySet2.add("a");
        mySet2.add("c");
        System.out.println("\n" + mySet2);

        Map<String, String> user = new HashMap<>();
        user.put("username", "jdoe"); // method put similar to add
        user.put("email", "jdoe@gmail.com");
        user.put("password", "welcome");
        System.out.println("\n" + user);

        Map<String, String> admin = new HashMap<>();
        admin.put("username", "admin");
        admin.put("email", "admin@example.com");
        admin.put("password", "password1");
        System.out.println("\n" + admin);

        String username = user.get("username");
        String email = user.get("email");
        String password = user.get("password");

        System.out.println("User: " +username +" " + email + " " + password);
    }

    @Given("I solve java challanges")
    public void iSolveJavaChallanges() {
        // Write a function that prints all numbers from 0 to n
        //ask interviewer if that's fine to print from 0 to 3? so it will be 0,1,2,3
        int i =3;
        solve(i);
        int n = -2;
        solveNegative(n);
        Integer[] arr = {1,2,5,10,11,0};
        solveArr(arr);
        solveArrForEach(arr);
        solveEvenNum(arr);
        Integer [] arr1 ={};
        solveEmpty(arr1);
        Integer [] arr2 ={1,3,8,-1,0};
        int target =5;
        solveOther(arr2,target);
    }

    private void solve(int i) {
        for (int j = 0; j <= i; j++) {
            //j=0
            System.out.println(j);
        }
    }
    // Write a function that support negative numbers:
    // let's select a) 3; b) -2
    // ask how to select them? you can go 0, -1, -2
    // or it can be -2, -1, 0
        private void solveNegative(int n) {
            if (n >=0) {
                for (int j =0;j <=n;j++) {
                    System.out.println(j);
                }
            } else {
                for (int j =0;j >=n;j--) {
                    System.out.println(j);
                }
            }
        }

        // Write a function that prints all integer array
    // ask interviewer about the array

    private void solveArr(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr [" + i + "]" + arr[i]);
        }
    }

    private void solveArrForEach (Integer[]arr){
            for (Integer n : arr) {
                System.out.println(n);
            }
        }

    // Write a function that prints all even numbers from Int array
    private void solveEvenNum(Integer[] arr) {
        for (Integer i : arr) {
            if (i % 2 ==0) {
                System.out.println(i);
            }
        }
    }

    // Write a function that checks if array is empty
    private void solveEmpty(Integer [] arr1) {
        if (arr1 ==null) {
            return; // ask what to return here
        }
        if (arr1.length==0) {
            System.out.println(true);
        }else
        {
            System.out.println(false);
        }
    }

    // Write a function that checks if array contains another element
    // what is another element? array and target value to find? like find 0 or 1 or something else
    private void solveOther(Integer [] arr2, int target) {
        for (int i =0;i<arr2.length;i++) {
            if (arr2 [i] ==target) {
                System.out.println(true);
                return;
            }
        }
        // if we didn't find anything in the array then print false (outside the loop!)
        System.out.println(false);
    }

    @Given("I solve java challanges for day two")
    // Print the sum of the numbers from 1 to n
    public void iSolveJavaChallangesForDayTwo() {
        int n =5; // then try - 1 (to test it) - it will be failed because the start is from 1 j=1;
        solveIt(n);
    // modify the previous program such that only multiples of 3 or 5 are considered the sum
        int n2 =17;
        solveIt2(n2);
    // program that takes a number n and
    // gives the possibility between conputing the sum and the product of 1,....,n
    int n3 = 7;
    String option = "sun";
    solveIt3(n3,option);
    // homework!!
    // you have array of numbers
    // sort odd numbers in ascending order
    // but even numbers should be on their places
    // input [5,3,2,8,4,1]
    // output [1,3,2,8,4,1]
        // sort array
        int[] arr = {5,3,2,8,4,1};
        sortArray(arr);

        int[] arr2 = {0,2,5,3,2,8,4,1,10};
        sortArrayOdd(arr2);
    }
    private void sortArray(int[] arr) {
        //{5,3,2,8,4,1} - input
        //{5,3,2,8,4,1} -> 1 minimum (index 5 swap to 0) -> {1,3,2,8,4,5}
        //{1,3,2,8,4,5} -> start with index 1 not 0 -> {1,2,3,8,4,5} etc

        for (int j = 0; j < arr.length; j++) {
            int idxMin = j;
            int min = arr[idxMin];
            for (int i = j+1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    idxMin = i;
                }
            }
            System.out.println("min = " + min);
            System.out.println("Index for a min =" + idxMin);
            int temp = arr[j];
            arr[j] = min;
            arr[idxMin] = temp;
            System.out.println("Swapped array with min start" + Arrays.toString(arr));
        }
    }
        private void sortArrayOdd(int[] arr2) {
            //{5,3,2,8,4,1} - input
            //{5,3,2,8,4,1} -> 1 minimum (index 5 swap to 0) -> {1,3,2,8,4,5}
            //{1,3,2,8,4,5} -> start with index 1 not 0 -> {1,2,3,8,4,5} etc

            System.out.println(Arrays.toString(arr2));
            for (int j = 0; j < arr2.length; j++) {
                if (arr2[j] %2==0) {
                    continue;
                }
                int idxMin = j;
                int min = arr2[idxMin];
                for (int i = j+1; i < arr2.length; i++) {
                    if (arr2[i] < min && arr2[i] %2 !=0) {
                        min = arr2[i];
                        idxMin = i;
                    }
                }
                System.out.println("min = " + min);
                System.out.println("Index for a min =" + idxMin);
                int temp = arr2[j];
                arr2[j] = min;
                arr2[idxMin] = temp;
                System.out.println("Swapped array with min start" + Arrays.toString(arr2));
            }
        }

    private void solveIt(int i) {
        int sum = 0;
        for (int j=1; j <= i;j++) {
            sum = sum + j;
        }
        System.out.println("sum = " +sum);
    }

    private void solveIt2(int i) {
        int sum = 0;
        for (int j=1;j <= i;j++) {
            if (j % 3 == 0 || j % 5 ==0) {
            sum = sum + j;
            }
        }
        System.out.println("sum = " +sum);
    }

    private void solveIt3(int i, String option) { // see 0:37 mins
        if (option.equals("sun")){
            int sum = 0;
            for (int j=1;j <=i;j++) {
                sum = sum + j;
            }
            System.out.println("sum = " + sum);
        } else if (option.equals("producnt")) {
            int product =1;
            for (int j =1; j<=1; j++) {
                product *=j;
            }
            System.out.println("Product " +product);
        } else {
            System.out.println("Incorrect option: " + option +", use sun or product!");
        }
    }

    @Given("I solve java challanges for day three")
    public void iSolveJavaChallangesForDayThree() {
        //write a program to print a mulitplication table for numbers up to 12
        int n =12;
        solveNumber(n);

        //write a function that combine two arrays(lists) by alternating taking elements
        // e.g [a,b,c],[1,2,3] -> [a,1,b,2,c,3]
        // e.g [9,1,2,6,5] and [1,2,3]
        // how big is the array? different size or same?
        int [] arr1 = {0,5,8,9,1};
        int[] arr2 = {1,2,3};
        solveArrays(arr1,arr2);
    }

    //write a function that combine two arrays(lists) by alternating taking elements
    private void solveArrays(int[] arr1, int[] arr2) {
        int length =arr1.length +arr2.length;
        int[] result = new int[length];
        int min_length;
        if (arr1.length<arr2.length) {
            min_length =arr1.length; // minimum length
        } else {
            min_length = arr2.length; // in our case it's 3 and array 2
        }
//        int i =0; // index for 1st array
//        int j =0; // index for 2nd array
        for (int k =0; k < min_length *2; k= k+2) { // index for the result array
            result[k] = arr1[k / 2]; // select second value
            result[k+1] = arr2[k / 2 ]; // k =2; 12/2 - > 1
        }
        // {0,1,5,2,8,3}
        // result of 1st array {9,1}
        for (int inx =min_length; inx <arr1.length; inx++ ) {
            int restultIndex = min_length *2 +inx - min_length;
            result [restultIndex] = arr1[inx];
        }
        for (int inx =min_length; inx <arr2.length; inx++ ) {
            int restultIndex = min_length *2 +inx - min_length;
            result [restultIndex] = arr2[inx];
        }

        System.out.println(Arrays.toString(result));
    }

    //write a program to print a mulitplication table for numbers up to 12
    private void solveNumber(int n) {
        for (int y =1;y<=12;y++) {
            for (int x=1; x<=n;x++) {
                System.out.print(x * y + "\t");
            } System.out.println();
        }
    }

    @Given("I solve java challenges for the day six homework")
    public void iSolveJavaChallengesForTheDaySixHomework() {
//        1) Write a function that prints all numbers from 0 up to n
//        2) Write a function that supports also negative numbers
//        3) Write a function that prints all integer array
//        4) Write a function that prints all even numbers from integer array
//        5) Write a function that checks if array is empty
//        6) Write a function that checks if array contains another element

//        1) Write a function that prints all numbers from 0 up to n
        int n = 4;
        printNumbers (n);
//        2) Write a function that supports also negative numbers
        int negative = -4;
        printNegative(negative);
//        3) Write a function that prints all integer array
        int[] array = {1,5,6,9,0};
        printArray(array);
//        4) Write a function that prints all even numbers from integer array
        printEvenNumbers(array);
        printEvenNumbers2(array);
//        5) Write a function that checks if array is empty
        int[] array2 = {};
        if (isArrayEmpty(array2)) {
            System.out.println("Array is empty");
        }
        else {
            System.out.println("Array is NOT empty");
        }
//        6) Write a function that checks if array contains another element
       int anotherEl = 1;
        checkAnotherElement(array,anotherEl);
    }


    //        1) Write a function that prints all numbers from 0 up to n
    private void printNumbers(int n) {
        for (int i =0; i <=n; i++) { // i == index!
            System.out.println(i);
        }
    }
//        2) Write a function that supports also negative numbers
    private void printNegative(int negative) {
        for (int i =0; i>=negative; i--) {
            System.out.println(i);
        }
    }
//        3) Write a function that prints all integer array
    private void printArray(int[] array) {
        for (int i=0;i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
//        4) Write a function that prints all even numbers from integer array
    private void printEvenNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                System.out.println(array[i] + " - even number");
            } else System.out.println(array[i] + " Not even number");
        }
    }
     // OR
    private void printEvenNumbers2(int[] array) {
            for (int current : array) {
                if (current % 2 ==0) {
                    System.out.println(current + " - even number");
                } else System.out.println(current + " Not even number");
            }
    }
//        5) Write a function that checks if array is empty
    private boolean isArrayEmpty(int[] arr) {
            return (arr.length == 0);
    }
//        6) Write a function that checks if array contains another element
    private void checkAnotherElement(int[] array, int anotherEl) {
        for (int element : array) {
            if (element == anotherEl) {
                System.out.println("Array contains this element!");
                return; // stop the method and will not go to another sout..
            }
        }
        System.out.println("Array does not contain this element!");
    }


    @Given("I solve java challenges for the day seven homework")
    public void iSolveJavaChallengesForTheDaySevenHomework() {
//        1) Given array: {5,2,9,7,3}
//        Write a function that swaps two array elements – 3rd and 5th
        int[] arr = {5,2,9,7,3};
        swap(arr);
// OR to swap variables without temp veriable:
        toSwap(3, 5);
        toSwap(1, 3);

//        2) Write a function that accepts integer number and prints
//        "divisible by 3" if number is divisible by 3 "divisible by 4" if element is divisible by 4 "divisible by 3 and 4" if divisible by 3 and 4
          printDivBy3and4(12); // without for loop
          printDivBy3and4(9);
          printDivBy3and4(8);
          printDivBy3and4(7);

//        3) Write a function to find the largest element in an array
            largestElement(arr); // int[] arr = {5,2,9,7,3}; = output 9

//        4) Write a function, accepts integer argument
//        It should print all the numbers up to the argument
//        BUT:
//        if number is multiple of 3, it should print Fizz instead of number
//        if number is multiple of 5, it should print Buzz instead of number
//        if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
//        Result for 20:
//        1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz

            fizzBazz(20); // this one has for loop!
            fizzBazz(15);
            fizzBazz(10);

//        5) Write a function that reverses string
        reverseString("Hello");
        getReversed("WebDriver");

//        6) Write a function that reverses words in a sentence
       // input "One reversed by Two"
        // output: "Two reversed by One"
        String [] array = {"One", " ","reversed"," ","by"," ","Two"};
        reverseWord(array);
    }

    //  Write a function that swaps two array elements – 3rd and 5th
    private void swap(int [] arr) {
        System.out.println("Initial array: " + Arrays.toString(arr));
        int temp = arr[2]; // third element in array, arr[4] = fifth element
        arr[2] = arr[4];
        arr[4] = temp;
        System.out.println("Swapped array: " +Arrays.toString(arr));
    }
    private void toSwap(int num1, int num2) {
        // 3, 5
        System.out.println("Swap method begin - num1: " + num1 + " num2: " + num2);
        num1 = num1 + num2; // now num 1 = 8
        num2 = num1 - num2; // now num 2 = 3 (8-5)
        num1 = num1 - num2; // now mum 1 = 5 (8-3)
        System.out.println("Swap method   end - num1: " + num1 + " num2: " + num2);
    }

    //        2) Write a function that accepts integer number and prints
//        "divisible by 3" if number is divisible by 3 "divisible by 4" if element is divisible by 4 "divisible by 3 and 4" if divisible by 3 and 4
    private void printDivBy3and4(int number) {
        if (number % 3 == 0 && number % 4 == 0) {
            System.out.println(number+" divisible by 3 and 4");
        } else if (number % 3 ==0) {
            System.out.println(number+" divisible by 3");
        }else if (number % 4 ==0) {
            System.out.println(number+" divisible by 4");
        } else {
            System.out.println(number + " not divisible by 3 and 4");
        }
    }
//        4) Write a function, accepts integer argument
//        It should print all the numbers up to the argument
//        BUT:
//        if number is multiple of 3, it should print Fizz instead of number
//        if number is multiple of 5, it should print Buzz instead of number
//        if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
//        Result for 20:
//        1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz

    private void fizzBazz(int number) {
        for (int i =1; i <= number;i ++) { // start with 1 not 0!
        if (i % 15 ==0) {
            System.out.println("FizzBuzz ");
        } else if (i % 3 ==0) {
            System.out.println("Fizz ");
        }else if (i % 5 ==0) {
            System.out.println("Buzz ");
        } else {
            System.out.println(i +" ");
        }
    }
    }

//        3) Write a function to find the largest element in an array
    private void largestElement(int[] arr) {
        System.out.println("Array: " +Arrays.toString(arr));
        int max =arr[0]; // initial max value = 1st element in the array
        for (int i = 1; i < arr.length; i++) { // start loop with 2nd element [1]
            if (max < arr[i]) { // compare max with all other array elements
                max = arr[i];
            }
        }
        System.out.println("Max array value " +max);
    }

    private void reverseString(String str) {
        System.out.println("Initial string: " +str);

        for (int i = str.length() - 1; i >= 0; i--) { // start with the end char of the string
            System.out.print(str.charAt(i)); // print every char from the loop in one line
        }
        System.out.println(); // print in new line
    }

    // OR

    String getReversed(String str) {
        System.out.println("Return reversed " + str);
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed = str.charAt(i) + reversed;
        }
        return reversed;
    }

    //        6) Write a function that reverses words in a sentence
    private void reverseWord(String[] sentence) {
        System.out.println("Initial sentence:" +Arrays.toString(sentence));
        String temp = sentence[0];
        sentence[0] = sentence[6];
        sentence[6] = temp;
        System.out.println("Swapped sentence:" + Arrays.toString(sentence));
    }

    @Given("I solve java challenges for the day nine")
    public void iSolveJavaChallengesForTheDayNine() {
        System.out.println("Returned reversed sring without extra var: " + getReversedNoVar("WebDriver"));

        Integer [] arr = {4,3,1,5,8,4};
        int number = 4;
        String [] strArray = {"ab","xy","z"};
        String str = "a";
        System.out.println(isArrayContains(arr,number));
        System.out.println(isArrayContains(strArray,str));// work for both Integer and String

        int [] arrToSort = {4,3,1,5,8,4};
        int [] sorted = sort(arrToSort);
        System.out.println("Sorted array" + Arrays.toString(sorted));

        // in real world
        List<Integer> intArray = Arrays.asList(5,6,7,9,1);
        System.out.println(intArray);
        intArray.sort((i1,i2) -> i2 - i1); // descending sorting
        System.out.println(intArray);

        List<String> strArray1 = Arrays.asList("ab", "a","abc","ab");
        System.out.println(strArray1);
        strArray1.sort(Comparator.comparingInt(String::length)); // sort by String length
        System.out.println(strArray1);
    }

        int [] sort (int [] arr) {
            for (int i = 0; i < arr.length -1; i++) { // this one for the 1st element
                // arr.length -1 in needs for the If! we don't need the last element
                for (int j = i + 1; j <arr.length; j++ ) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }// move pointer to the end of the loop
                 System.out.println(arr[i] + " ");

            }
            return arr;
        }

    // work for both Integer and String as they both are Objects - polymorphism
    private boolean isArrayContains(Object[] array, Object toFind) {
        for (Object arrayEl :array) {
            if (arrayEl.equals(toFind)) {
                return true;
            }
        } return  false;
    }

    // Reverse without extra variable
//    TODO - check why it's not working
    String getReversedNoVar(String str) {
        System.out.println(("Initial string:" + str));

        for (int i = str.length()-1; i >= 0; i-- ) {
            str += str.charAt(i);
        }
        return str.substring(str.length()/2); // substring - second portion of the String
    }

    @Given("I solve java challenges for the additional day nine")
    public void iSolveJavaChallengesForTheAdditionalDayNine() {
        // reverse the word in the sentence
        String sentence = String.format("I love Java");
        resolveReversedSentece(sentence);

        //inxWordStarted: [0,1] -> 0; " "
        // [2,3,4,5,6] -> 2 ('love' starts with index 2
        // [7...] -> Java starts with index 7
        resolveReversedSenteceWithChar(sentence);

        // I love Java --> avaJ evol I
        resolveReversedSenteceTotal(sentence);
    }

    private void resolveReversedSenteceTotal(String sentence) {
        int inxWordStarted = 0;
//        String [] words = new String[sentence.length()];
        ArrayList<String> words = new ArrayList<>();
        int inxWord = 0;
        for (int i =0; i < sentence.length();i++) {
            if (sentence.charAt(i) == ' ') {
                // word finished, need to save it
                words.add(reverseWord(sentence.substring(inxWordStarted,i)));
                inxWord++; // I -> inxWord = 1;
                inxWordStarted = i + 1;
            } // else it will continue

        }
        // words[inxWord] = sentence.substring(inxWordStarted);
        words.add(reverseWord(sentence.substring(inxWordStarted)));
        // inxWord++;

        String result = "";
        for (int i =0; i <words.size() -1 ; i ++) {
            result += words.get(i) + " ";
        }

        result+= words.get(words.size()-1);
        System.out.println(result);
    }

    private String reverseWord (String s) {
        String result ="";
        for (int i =s.length() -1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return null; // ??
    }

    private void resolveReversedSenteceWithChar(String sentence) {
        int inxWordStarted = 0;
//        String [] words = new String[sentence.length()];
        ArrayList<String> words = new ArrayList<>();
        int inxWord = 0;
        for (int i =0; i < sentence.length();i++) {
            if (sentence.charAt(i) == ' ') {
                // word finished, need to save it
              words.add(reverseWord(sentence.substring(inxWordStarted,i)));
                inxWord++; // I -> inxWord = 1;
                inxWordStarted = i + 1;
            } // else it will continue

        }
       // words[inxWord] = sentence.substring(inxWordStarted);
        words.add(sentence.substring(inxWordStarted));
       // inxWord++;

        String result = "";
        for (int i =words.size() -1; i >=0 ; i --) {
            result += words.get(i) + " ";
        }
        result += words.get(words.size()-1);
        System.out.println(result);
    }

    private void resolveReversedSentece(String sentence) {
       //  sentence.split(" ")--> array of words
        String [] words = sentence.split(" "); //[I, love, Java] - it will not work if more than one space
        String result ="";
//        for(int i=0; i< words.length; i++) {
//            result += words[words.length-i -1] + " "; // complicated, not easy to read
//        }
           for(int i=words.length-1; i >=0; i--) { // start from the end
            result += words[i] + " "; // but there is one additional space in the end
           if (i !=0) {
               result = result + " "; // add space only if that's not the last one
           }
        }
        System.out.println(result);
    // result.trim()); // remove extra space from end
    }



    // String Tokenazer

    @Given("I solve java challenges for the additional day ten")
    public void iSolveJavaChallengesForTheAdditionalDayTen() {
    // Reverse number: 2345-> 5432
   // ask about negative numbers
        // is it ing or double?
        //1234 - > "1234"
        int number = -2345;
        solveRevNumber (number);
        solveRevNumberNegative(number);
        // 1234 / 10 = 123

        // takes a number and return digits like 2342 - > [2,3,4,2]
        int num = 2342;
        returnDigits(num);
        // array of int and int target, return indices of the two numbers such that they add up to target
        // do not use element twice. input would have exactly the solution.
        // [2,7,11,15] => target 9 (2+7=9)
        //expected [0,1]
        //num[0] + nums [1] == 9

        int[] arr = {2,3,11,7}; // check negative values, in the end of the loop, more than 4 digits, only one element, empty array
        int target =9;
        returnSecondLarge(arr, target);
        returnSecondLargeOneFor(arr,target);
    }

    private void returnSecondLarge(int [] arr, int target ) {
        for (int i =0; i < arr.length-1; i++) { // i =0
            for (int j =i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    System.out.println( i + " " +j);
                    return;
                }
            }
        }
        System.out.println("No solution!"); // if the is not 9 sum
    }
    private void returnSecondLargeOneFor(int [] arr, int target ) {
       Map<Integer,Integer> map = new HashMap<>();

        for (int i =0; i < arr.length-1; i++) { // i =2->7 (2)
            if (map.containsKey(arr[i])) {
                System.out.println(map.get(arr[i])+ " " + i);
            }
           map.put(target - arr[i],i); // key 7, value =0; for position 0 - I need to find 7 [2,7,11,15]
        }
        System.out.println("No solution!"); // if the is not 9 sum
    }

    private void returnDigits(int num) {
        List<Integer> res = new ArrayList<>();
        while (num > 0) {
            int digits = num % 10;
            res.add(0,digits); // add digits in the beginning
            num = num / 10;
        }
        System.out.println(res);
    }

    private void solveRevNumber (int n) {
        // TODO: add verification for negative numbers
        int res = 0;
       while (n > 0) {
           int d = n % 10; // 5 (2345 last one)
           res =res * 10 +d;// first res =0, d =5, res=5; //rest=5; d =4;5*10+4-> 54
           n = n / 10; // 2345 - > 234, 234->23, 23->2, 2->0
       } // we don't need the length for while instead of for loop
        System.out.println(res);
    }
    private void solveRevNumberNegative (int n) {
        // added verification for negative numbers
        int sign = (n < 0) ? -1 : 1; // short version below if statment
//        if (n <0) {
//            sign = -1;
//        } else {
//            sign =1;
//        }
        n = n * sign; // only positive so sign is same as (-)

        int res = 0;
        while (n > 0) {
            int d = n % 10; // 5 (2345 last one)
            res =res * 10 +d;// first res =0, d =5, res=5; //rest=5; d =4;5*10+4-> 54
            n = n / 10; // 2345 - > 234, 234->23, 23->2, 2->0
        } // we don't need the length for while instead of for loop
        System.out.println(res *sign);
    }


    @Given("I solve java challenges for the additional second day ten")
    public void iSolveJavaChallengesForTheAdditionalSecondDayTen() {
        //array of Strings String [] arr = {"Hello","World","in""};
        // take a list of strings and print them 
        // one per line in rectangular frame like
        //*******
        //*Hello*
        //*World*
        //*in   *
        //*******
        String [] arr = {"Hello","World","in", "frame"};
//        solveArrInFrame(arr);

        // calculate Fibonacci numbers F(n)
        int n = 3; // 1+1 = 2
        solveFibonacci(n);
        // test Fibonacci
        // -1 -> doesn't work
        // 0 ? , 10 ?
        // null
        // time complexity - 0 (n) - n elements and loop
        // n - is the index
        // space complexity 0 (1) - because it's only one array with 2 elements
    }

    private void solveFibonacci(int n) {
        int [] fib = {0,1};
        if (n <= 1) {
            System.out.println(fib[n]);
            return;
        }
        // n >=3
        int i = 2; // because 0 and 1 already in fib
        while (i <= n) {
            int fibNext = fib[0] + fib[1]; // 0+1 => 1 F(2) =1
            fib[0] = fib[1]; // 1 (F (1)
            fib[1] = fibNext; // 1 (F (2)
            i++;
        }
        System.out.println(fib[1]);
    }

    private void solveArrInFrame(String[] arr) { // doesn't work
        int max =0;
        for (String word :arr) {
            if (word.length() > max) {
                max = word.length();
            }
        } // max 5
       for (int i =1;i <= max+4; i++) {
           System.out.println();
       }
       for (String word : arr) {
           System.out.print("* ");
           System.out.print(word);
           for (int i =1; i <= max +4; i ++) {
               System.out.println(" ");
           }
       } System.out.print(" *\n");
    }

    @Given("I solve java challenges for class twelve")
    public void iSolveJavaChallengesForClassTwelve() {
        Integer [] numArr = {6,2,3,5,9};
        Integer [] numArr2 = {6,2,9,5,7};
        Integer [] numArr3 = {9,2,6,5,7};
        //find Max Number
        System.out.println(findMaxNumber(numArr));
        // find two max numbers
        printTwoMaxNumbers(numArr);
        printTwoMaxNumbers(numArr2);
        printTwoMaxNumbers(numArr3);
        System.out.println("Returned twoMax numbers: " + Arrays.toString(returnTwoMaxNumbers(numArr)));
    }
    private int findMaxNumber(Integer[] numArr) { // O(N)
        System.out.println("Max number in the array: " +Arrays.toString(numArr));
        //  int max = 0; // will not work with negative number
        // int max =Integer.MIN_VALUE; // will work with any numbers
        int max = numArr[0];// will work with any numbers:
        for (int i =1; i < numArr.length; i++) {
            if (max < numArr[i]) {
                max = numArr[i];
            }
        } return max;
    }

    private void printTwoMaxNumbers(Integer[] numArr) {
        System.out.println("Max number in the array: " + Arrays.toString(numArr));
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i =0; i < numArr.length; i++) {
            if (max1 < numArr[i]) {
                max2 = max1;
                max1 = numArr[i]; // this part only check for max1. Doesn't compare max2
            } else if (max2 < numArr[i]) {
                max2 = numArr[i]; // this part compares max2
            }
       }  System.out.println("Largest: " + max1 + " "+ "Second largest: " +max2);
    }
    private int[] returnTwoMaxNumbers(Integer[] numArr) {
        System.out.println("Max number in the array: " + Arrays.toString(numArr));
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < numArr.length; i++) {
            if (max1 < numArr[i]) {
                max2 = max1;
                max1 = numArr[i]; // this part only check for max1. Doesn't compare max2
            } else if (max2 < numArr[i]) {
                max2 = numArr[i]; // this part compares max2
            }
        }
         int [] twoMaxNumbers = {max1,max2};
         return twoMaxNumbers;
    }
    @Given("I work with classes")
    public void iWorkWithClasses() {
        Cat cat = new Cat("Basilio");
        cat.sleep();
        cat.walk();
        cat.eat("fish");
        cat.speak();
        cat.setName("newCatName");
        cat.sleep();
        cat.getName();
    }

    @Given("I work with java")
    public void iWorkWithJava() {
        //given array print sum of elements
        int[] arr = {3,5,1};
        solvePrintSum(arr);
        // given n, print factorial: 1+2+3(...n) ??? doesn' work
//        int n =4;
//        solveFactorial(n);
//        System.out.println(result);

        // check string if it is Palindrome
        // "anna" = true , "java" = false
        String str = "java";
        boolean result = solvePalindrome(str);
        System.out.println(result);
    }

//    private void solveFactorial(int n) {
//        if (n==1) {
//            return 1;
//        }
//        return n * solveFactorial(n-1);
//    }


    private  boolean solvePalindrome(String str) {
        for (int i =0; i < str.length() / 2 ; i++) { // half of the string
            if (str.charAt(i) != str.charAt(str.length() -i -1)) {
                return false;
            }
        } return true;
    }

    private void solvePrintSum(int[] arr) {
        int result = 0;
        for(int i = 0;i < arr.length;i ++) {
            result += arr[i];
        }
        System.out.println(result);
    }

    @Given("I work with java challenges for homework eleven")
    public void iWorkWithJavaChallengesForHomeworkEleven() {
        String palindrome = "anna";
        System.out.println(
                isPalindrome(palindrome) ? "palindrome" : "not palindrome");

        //Write a function that finds if any two elements of an array result in sum
        int [] arrayForSum = {1,4,5,7,5};
        int [] arrayForSum1 = {1,4,5,7,6,3,5,1,-1,11};
        int [] arrayForDuplicate = {1,4,-1,5,5,6,3,5,1,0,-1};
        int sum = 10;
        findSumResult(arrayForSum,sum);
        findSumResult(arrayForSum1,sum);
        //sum of all elements
        sumOfAll(arrayForSum);

        //Write a function that finds if array contains duplicates
        findDuplicates(arrayForDuplicate);
    }

    private void sumOfAll(int[] arrayForSum) {
        System.out.println("Array to sum: " + Arrays.toString(arrayForSum));
       int result = 0;
       for (int i = 0; i < arrayForSum.length; i ++) {
            result += arrayForSum[i];
       }
        System.out.println("Sum of all elements is: " + result);
    }

    private void findSumResult(int[] arrayForSum, int sum) {
        System.out.println("Array to sum: " + Arrays.toString(arrayForSum));
        for (int i =0; i < arrayForSum.length; i ++) { // get 'i' values
            for (int j = i + 1; j < arrayForSum.length; j ++) { // i+1 because you don't need to compare each element with itself
                if (arrayForSum[j] + arrayForSum[i] == sum) { // get i + j value
                    System.out.println("Sum of the elements " +
                            arrayForSum[i] +"+" +arrayForSum[j] +": is " + sum);
                }
            }
        }
    }
    private void findDuplicates(int[] arrayForDupl) {
        System.out.println("Array with duplicates? " + Arrays.toString(arrayForDupl));
        for (int i =0; i < arrayForDupl.length; i++) {
            for (int j =i+1; j <arrayForDupl.length; j ++) {
                if (arrayForDupl[j] == arrayForDupl[i]) {
                    System.out.println("Array contains duplicates: "  +
                            arrayForDupl[i] +" " + arrayForDupl[i]);
                }
            }
        }
    }


    private boolean isPalindrome(String palindrome) {
        int i = 0;
        int j = palindrome.length()-1; // because length more than index (it starts with 0)
        while (i <= j ) { //loop until i and j meet == half of the string
            if (palindrome.charAt(i) == palindrome.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
//interview
//1.clarify
//2.solve the task in any way
//3.improve solution if you can
//4. test it! you are QA - null; {}; {"string"};
//5. 0(1) (time) (size) - big annotation


