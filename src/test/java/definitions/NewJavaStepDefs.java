package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class NewJavaStepDefs {
    @Given("I printing hello world")
    public void iPrintingHelloWorld() {
        System.out.println("Hello world");
    }

    @And("I type {string}")
    public void iType(String message) {
        System.out.println(message);
    }

    @And("I type {string} and {string}")
    public void iTypeAnd(String part1, String part2) {
        System.out.println("Printing both variables: " + part1 + " " + part2);
        System.out.println("Printing both variables in Upper Case: " + part1.toUpperCase() + " " + part2.toUpperCase());
        System.out.println("The length of the variable" + " " + part1 + " ->" + part1.length());
        System.out.println("The length of the variable" + " " + part2 + " ->" + part2.length());
        System.out.println("Are the variables equal? " + part1.equals(part2));
        System.out.println("Equal using exact comparison ignoring cases: " + part1.equalsIgnoreCase(part2));
        System.out.println("Parial comparison using contains: " + part1.contains(part2));
    }

    @And("I do some math with {int} and {int}")
    public void iDoSomeMathWithAnd(int num1, int num2) {
        int sum = num1 + num2;
        int difference = num1 - num2;
        int quotient = num1 / num2;
        int product = num1 * num2;
        System.out.println("The result of addition is: " + sum);
        System.out.println("The result fo subtraction is: " + difference);
        System.out.println("The result of division integers: " + quotient);
        System.out.println("The result of multiplication is: " + product);

    }

    @And("I do some math with int {int} and float {double}")
    public void iDoSomeMathWithIntAndFloat(int num1, double num2) {
        System.out.println("The result of division int and flot: " + num1 / num2);
    }

    @And("I print number {int} if positive")
    public void iPrintNumberIfPositive(int num1) {
        if (num1 > 0) {
            System.out.println("The number " + num1 + " is positive");
        } else if (num1 < 0) {
            System.out.println("The number " + num1 + " is negative");
        } else {
            System.out.println("I don't know about this case");
        }
    }


    @And("I print day {int} of the week")
    public void iPrintDayOfTheWeek(int day) {
        if (day == 1) {
            System.out.println("It's Monday");
        } else if (day == 2) {
            System.out.println("It's Tuesday");
        } else if (day == 3) {
            System.out.println("It's Wednesday");
        } else if (day == 4) {
            System.out.println("It's Thursday");
        } else if (day == 5) {
            System.out.println("It's Friday");
        } else if (day == 6) {
            System.out.println("It's Saturday");
        } else if (day == 7) {
            System.out.println("It's Sunday");
        } else {
            System.out.println("Please enter the number from 1 to 7");
        }
    }

    @And("I implement print day {int} of the week using switch method")
    public void iImplementPrintDayOfTheWeekUsingSwitchMethod(int day) {
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            case 4 -> System.out.println("Thursday");
            case 5 -> System.out.println("Friday");
            case 6 -> System.out.println("Saturday");
            case 7 -> System.out.println("Sunday");
            default -> System.out.println("Please enter a number between 1 and 7");
        }
    }

    @And("I implement print day {int} of the week with array")
    public void iImplementPrintDayOfTheWeekWithArray(int day) {
        String[] daysOfTheWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        if (day >= 1 && day <= 7) {
            System.out.println("The day is: " + daysOfTheWeek[day - 1]);
        } else {
            System.out.println("Please enter a number between 1 and 7");
        }
    }


    @And("I implement method to print numbers from zero to {int}")
    public void iImplementMethodToPrintNumbersFromZeroTo(int num) {
        for (int i = 0; i <= num; i++) {
            System.out.println("Number: " + i);
        }
    }

    @And("I implement method that prints negative numbers {int}")
    public void iImplementMethodThatPrintsAlsoNegativeNumbers(int num) {
        for (int i = 0; i >= num; i--) {
            System.out.println("Number is: " + i);
        }
    }

    @And("I implement method that prints positive and negative numbers {int}")
    public void iImplementMethodThatPrintsPositiveAndNegativeNumbers(int num) {
        if (num > 0) {
            for (int i = 0; i <= num; i++) {
                System.out.println("The number: " + i);
            }
        } else if (num < 0) {
            for (int i = 0; i >= num; i--) {
                System.out.println("The number: " + i);
            }
        } else {
            System.out.println("The number " + num + "is not supported");
        }
    }

    @And("I implement method to print all int array")
    public void iImplementMethodToPrintAllIntArray() {
        int[] numbers = {1, 10, 20, 30};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("An array contains the value: " + numbers[i]);
        }
        for (int element : numbers) {
            System.out.println("An array contains the value: " + element);
        }
    }

    @And("I implement method that prints even numbers from the int array")
    public void iImplementMethodThatPrintsEvenNumbersFromTheIntArray() {
        int[] listOfNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        {
            for (int element : listOfNumbers) {
                if (element % 2 == 0) {
                    System.out.println("This number in array is even " + element);
                }
            }
        }
    }

    @And("I implement method that checks if array is empty")
    public void iImplementMethodThatChecksIfArrayIsEmpty() {
        int[] listOfNumbers = {};
        if (listOfNumbers.length == 0) {
            System.out.println("This array is empty");
        } else {
            System.out.println("The array is not empty");
        }
    }

    @And("I implement method that checks if array contains another element")
    public void iImplementMethodThatChecksIfArrayContainsAnotherElement() {
        String[] wordsInArray = {"new", "one", "two", "three", "new year", "new york", "city"};
        int count = 0;
        for (String element : wordsInArray) {
            if (element.contains("new")) {
                count++;
            }
        }
        System.out.println(count + " matches found");
    }


    @When("I implement function to swap two elements in array")
    public void iImplementFunctionToSwapTwoElementsInArray() {
        //Write a function that swaps two array elements – 3rd and 5th
        int[] arr = {5, 2, 9, 7, 3};
        swapElements(arr, 2, 4);
        System.out.println("Array after swapping elements:");
        for (int elem : arr) {
            System.out.print(elem + ",");
        }
    }

    private void swapElements(int[] arr, int elem1, int elem2) {
        int temp = arr[elem1];
        arr[elem1] = arr[elem2];
        arr[elem2] = temp;
    }

    @And("I implement a function to verify if the {int} is divisible by three or four")
    public void iImplementAFunctionToVerifyIfTheIsDivisibleByThreeOrFour(int num) {
        // Write a function that accepts integer number and prints
        //"divisible by 3" if number is divisible by 3 "divisible by 4"
        // if element is divisible by 4 "divisible by 3 and 4" if divisible by 3 and 4
        if (num == 0) {
            System.out.println("Your number is not divisible. Please enter another number");
        } else if (num % 3 == 0 && num % 4 == 0) {
            System.out.println("This number " + num + " is divisible by 3 and 4");
        } else if (num % 3 == 0) {
            System.out.println("This number " + num + " is divisible by 3");
        } else if (num % 4 == 0) {
            System.out.println("This number " + num + " is divisible by 4");
        } else {
            System.out.println("This number " + num + " is not divisible by 3 or 4");
        }

    }

    @And("I implement a function that finds the largest element in array")
    public void iImplementAFunctionThatFindsTheLargestElementInArray() {
        int[] arr = {1, 5, 8, 12, 9, 0, 43, 3, 2, 1};
        int result = findLargestElement(arr);
        System.out.println("The biggest element in array is " + result);


    }

    private int findLargestElement(int[] arr) {
        int largestElement = arr[0];
        for (int element : arr) {
            if (element > largestElement) {
                largestElement = element;
            }
        }
        return largestElement;
    }

    @And("I solving the FizzBuzz challenge with arg {int}")
    public void iSolvingTheFizzBuzzChallengeWithArg(int num) {
        //Write a function, accepts integer argument
        //It should print all the numbers up to the argument
        //if number is multiple of 3, it should print Fizz instead of number
        //if number is multiple of 5, it should print Buzz instead of number
        //if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
        //Result for 20:
        //1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    @And("I implement the function to reverse string")
    public void iImplementTheFunctionToReverseString() {
        //Write a function that reverses string
        String toReverse = "I reversing string";
        String result = reverseString(toReverse);
        System.out.println(result);

    }

    private String reverseString(String toReverse) {
        String result = "";
        for (int i = toReverse.length() - 1; i >= 0; i--) {
            result = result + toReverse.charAt(i);
        }
        return result;

    }

    @And("I implement a function to reverse words in sentence")
    public void iImplementAFunctionToReverseWordsInSentence() {
        String sentenceToReverse = "Please reverse the words in this sentence";
        System.out.println("Sentence before reversing words:" + sentenceToReverse);
        String [] words = sentenceToReverse.split(" ");
        String result ="";
        for (int i = 0; i < words.length; i++) {
            result = result + reverseString(words[i]) + "*";
        }
        result = result.substring(0,result.length()-1);
        System.out.println(result);
    }
}
