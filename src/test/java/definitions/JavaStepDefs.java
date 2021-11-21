package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.*;

import static support.TestContext.getDriver;


public class JavaStepDefs {


    @Given("I know Java and how to write Java Steps")
    public void iKnowJavaAndHowToWriteJavaSteps() throws Throwable {
        try {
            String firstName = "Jalpa";
            String lastName = "Shah";
            String favoriteColor = "Pink";
            System.out.println("firstName =" + " " + firstName);
            System.out.println("lastName =" + " " + lastName);
            System.out.println("favoriteColor =" + " " + favoriteColor);
            System.out.println(firstName.length());
            System.out.println(firstName.getClass());
            System.out.println(firstName.toUpperCase());
            System.out.println(firstName.trim());
            System.out.println(firstName.isEmpty());


            System.out.println("Hello World!");
            System.out.println("Hi" + "," + "my name is" + " " + firstName + " " + lastName
                    + "," + "my favorite color is" + " " + favoriteColor + ".");
        } catch (Throwable t) {
            System.out.println(t);
            throw t;
        }

    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String s1, String s2) {
        System.out.println("Variable 1 is" + " " + s1);
        System.out.println("Variable 2 is" + " " + s2);

        System.out.println("UpperCase :" + s1.toUpperCase());
        System.out.println("length :" + s1.length());

        System.out.println("Exact Comparison :" + s1.equals(s2));
        System.out.println("Exact Comparison :" + s1.equalsIgnoreCase(s2));
        System.out.println("Partial Comparison :" + s1.contains(s2));

    }

    @And("I work with numbers {int} and {int}")
    public void iWorkWithNumbersAnd(int num1, int num2) {
        System.out.println("Number 1 :" + " " + num1);
        System.out.println("Number 2 :" + " " + num2);
        System.out.println("Addition :" + " " + (num1 + num2));
        System.out.println("Quotient :" + " " + (num1 / num2));
        System.out.println("Remainder :" + " " + (num1 % num2));

    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String page) throws Exception {
       /* if (page.equalsIgnoreCase("google")) {
            System.out.println(" https://www.google.com/");
            }
            else if(page.equalsIgnoreCase("yahoo")){
            System.out.println("https://www.yahoo.com/");
            } else {
            throw new Exception("unknown url for page :" + " " + page);
            }*/

        switch (page.toLowerCase()) {
            case "google": {
                System.out.println("https://www.google.com/");
            }
            break;
            case "yahoo": {
                System.out.println("https://www.yahoo.com/");
            }
            break;
            default: {
                System.out.println("unknown url for page :" + " " + page);
            }

        }
            /* New Java feature for switch statement
            switch(page.toLowerCase()){
                case "google"-> System.out.println("https://www.google.com/");
                case "yahoo"-> System.out.println("https://www.yahoo.com/");
                default -> throw new Error("Unknown url for page : " + page);
            }*/
    }


    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String num) {
        int i = Integer.parseInt(num);

        if (i >= 0) {
            System.out.println("Given number" + " " + num + " " + "is positive :");
        } else {
            System.out.println("Given number" + " " + num + " " + "is negative :");
        }
    }


    @And("I print {string}th day of the week")
    public void iPrintThDayOfTheWeek(String num) throws Exception {

        switch (num) {
            case "1":
                System.out.println("Sunday");
                break;
            case "2":
                System.out.println("Monday");
                break;
            case "3":
                System.out.println("Tuesday");
                break;
            case "4":
                System.out.println("Wednesday");
                break;
            case "5":
                System.out.println("Thursday");
                break;
            case "6":
                System.out.println("Friday");
                break;
            case "7":
                System.out.println("Saturday");
                break;
            default:
                throw new Exception("Incorrect number of day :" + num);
        }
                        //OR
    /*    int dayOfWeek = Integer.parseInt(num);
        int mod = dayOfWeek % 7;

        switch (mod) {
            case 1:
                System.out.println("Sunday");
                break;
            case 2:
                System.out.println("Monday");

                break;
            case 3:
                System.out.println("Tuesday");

                break;
            case 4:
                System.out.println("Wednesday");

                break;
            case 5:
                System.out.println("Thursday");

                break;
            case 6:
                System.out.println("Friday");

                break;
            case 7:
                System.out.println("Saturday");
                break;
            default:
                throw new Exception("Incorrect number of day :" + num);
        }*/
    
    }

    @And("I print my grocery list")
    public void iPrintMyGroceryList() {
        String[] groceryArray = {"milk", "bread", "banana", "pasta", "cereal", "humus"};
        //1ST OPTION
        System.out.println("Printing Array :" + Arrays.toString(groceryArray));// If you want the output looks like, [milk, bread, banana, pasta, cereal, humus]
        System.out.println();

        //2ND OPTION
        for (int i = 0; i < groceryArray.length; i++) {
            System.out.println(groceryArray[i]);
        }
        System.out.println();
        System.out.println("value at index 0 :" + groceryArray[0]);
        System.out.println("value at index 2 :" + groceryArray[2]);
        System.out.println();

        //3RD OPTION - Converting Array to List (Native method)
        //List<String> groceryList = List.of("milk","bread","banana","pasta","cereal","humus");
        List<String> groceryList = new ArrayList<String>();
        for (String item : groceryArray) {
            groceryList.add(item);
        }
        System.out.println("Printing List :" + groceryList);
        System.out.println();
        groceryList.add("rice");
        System.out.println("Printing modified List :" + groceryList);
        System.out.println();
        boolean b = groceryList.contains("milk");
        System.out.println("grocery list contains milk :" + b);
    }

    @And("I print personal info")
    public void iPrintPersonalInfo() {
        Map<String, String> info = new HashMap<>();
        info.put("firstName", "Jalpa");
        info.put("lastName", "Shah");
        info.put("hometown", "San Jose");
        info.put("favoriteFood", "Pasta");
        System.out.println(info);
    }

    @And("I swap values {int} and {int} of two variables")
    public void iSwapValuesAndOfTwoVariables(int num1, int num2) {

        int temp;

        temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);


    }

    @And("I swap values {int} and {int} for two variables without use of third variable")
    public void iSwapValuesAndForTwoVariablesWithoutUseOfThirdVariable(int a, int b) {

        a = a + b;
        System.out.println("a = " + a);
        b = a - b;
        System.out.println("b = " + b);
        a = a - b;
        System.out.println("a = " + a);
    }


    @Given("I Write a function that prints all numbers \\(including negative) from {int} up to {int}")
    public void iWriteAFunctionThatPrintsAllNumbersIncludingNegativeFromUpTo(int num1, int num2) {
        if (num1 >= 0 && num2 > 0) {
            for (int i = num1; i <= num2; i++) {
                System.out.print(i + "," + " ");
            }
        } else {
            for (int i = num1; i >= num2; i--) {
                System.out.println(i);
            }
        }
    }

    @And("Write a function that prints all integer array")
    public void writeAFunctionThatPrintsAllIntegerArray() {

        int[] numArr = {3,5,7,8,9};

        // To see the result as [3, 5, 7, 8, 9]
        System.out.println(Arrays.toString(numArr));
        System.out.println();

        /* To see the result as
        3
        5
        7
        8
        9 */

        for(int i=0; i< numArr.length; i++){
            System.out.println(numArr[i]);
        }
        System.out.println();
        /* OR
        for(int el : numArr){
            System.out.println(el);
        } */

     // To convert from Array to List by Native method and To see the result as [3, 5, 7, 8, 9]
        List<Integer> numList = new ArrayList<>();
        for(int el : numArr){
           numList.add(el);
       }
        System.out.println(numList);

        //Converting Array to List by Arrays.asList() method and To see the result as [3, 5, 7, 8, 9]
        List<Integer> numList1 = Arrays.asList(3,5,7,8,9);
        System.out.println("numList1 :" + numList1);



    }

    @And("Write a function that prints all even numbers from integer array")
    public void writeAFunctionThatPrintsAllEvenNumbersFromIntegerArray() {
        int[] arr = {2,3,10,373,4080,5216};
        List<Integer> list = new ArrayList<>();// if you want output look like [2, 10, 4080, 5216] then only do this
        for(int i=0; i< arr.length; i++){
            if(arr[i] % 2 == 0){
                System.out.println(arr[i]);
                list.add(arr[i]); // if you want output look like [2, 10, 4080, 5216]
            }
        }
        System.out.println(list); // if you want output look like [2, 10, 4080, 5216]
    }

    @And("Write a function that checks if array is empty")
    public void writeAFunctionThatChecksIfArrayIsEmpty() {
        String[] arr = {"java"};

        if(arr.length == 0){
            System.out.println("This is an empty array");
        }
        else{
            System.out.println("This is not an empty array");
        }

    }

    @And("Write a function that checks if array contains another element")
    public void writeAFunctionThatChecksIfArrayContainsAnotherElement() {
        int[] arr = {73,84,63,95,0};
        int anotherEle = 63;
        boolean flag = false;
        for(int i=0; i< arr.length; i++){
            if(arr[i]==anotherEle){
                flag = true;
                break;
            }
        }
        System.out.println("ArrayContainsAnotherElement statement is :" + flag);
    }

    @And("I print {int} th day of the week")
    public void iPrintThDayOfTheWeek(int dayOfWeek) {
        String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        System.out.println(days[dayOfWeek - 1]);
    }
}





