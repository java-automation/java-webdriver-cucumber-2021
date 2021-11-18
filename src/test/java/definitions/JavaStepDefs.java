package definitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.*;

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
        //groceryList.add("melon");
        System.out.println(groceryArray[2]);
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
    public void iSwapElementsWithPositionsAndInArrayOfIntegers(int p1, int p2, @Transpose List<Integer> intList) {
        int[] intArr = convertListToPrimitiveArray(intList);

        System.out.print("Original array: ");
        System.out.println(Arrays.toString(intArr));

        int temp = intArr[p2-1];
        intArr[p2-1] = intArr[p1-1];
        intArr[p1-1] = temp;

        System.out.print("Result: ");
        System.out.println(Arrays.toString(intArr));
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

    @And("I print all numbers from zero to {int}")
    public void iPrintAllNumbersFromZeroTo(int num) {
        System.out.println("-n <- 0 -> n as two loops:");
        if (num >= 0) {
            for (int i = 0; i <= num; ++i) {
                System.out.println(i);
            }
        } else {
            for (int i= 0; i >= num; --i) {
                System.out.println(i);
            }
        }
        System.out.println();

        System.out.println("-n <- 0 -> n as a single loop:");
        int sign = 1;
        if (num < 0) sign = -1;
        for (int i = 0; (num - i) * sign >= 0 ; i+=sign) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("-n -> 0 -> n as two loops:");
        if (num >= 0) {
            for (int i = 0; i <= num; ++i) {
                System.out.println(i);
            }
        } else {
            for (int i= num; i <= 0; ++i) {
                System.out.println(i);
            }
        }
        System.out.println();

        System.out.println("-n -> 0 -> n as a single loop:");
        int k = 1;
        if (num < 0) k = 0;
        for (int i = (1 - k) * num; i <= k * num; ++i) {
            System.out.println(i);
        }
    }

    @And("I do my integer array exercises with number {int}")
    public void iDoMyIntegerArrayExercises(int numToCheck, @Transpose List<Integer> intList) {
        System.out.println("Printing the List as is: " + intList);
        System.out.print("Printing the List with enhanced for: ");
        for (int el : intList) {
            System.out.print(el + " ");
        }
        System.out.println();
        System.out.print("Printing the List with regular for: ");
        for (int i = 0; i < intList.size(); ++i) {
            System.out.print(intList.get(i) + " ");
        }
        System.out.println();

        int[] intArr = convertListToPrimitiveArray(intList);
        System.out.println("Printing after conversion with Array.toString(int[]): " + Arrays.toString(intArr));
        System.out.print("Printing after conversion with enhanced for: ");
        for (int el : intArr) {
            System.out.print(el + " ");
        }
        System.out.println();
        System.out.print("Printing after conversion with regular for: ");
        for (int i = 0; i < intArr.length; ++i) {
            System.out.print(intArr[i] + " ");
        }
        System.out.println();

        System.out.print("Printing all even numbers from the array: ");
        for (int el : intArr) {
            if (el % 2 == 0) {
                System.out.print(el + " ");
            }
        }
        System.out.println();

        System.out.print("Is array empty? ");
        System.out.println((intArr.length == 0));


        System.out.print("Does this array contain " + numToCheck + "? ");
        boolean flag = false;
        for (int el : intArr) {
            if (el == numToCheck) {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
    }

    private int[] convertListToPrimitiveArray(List<Integer> intList) {
        int[] intArr = new int[intList.size()];
        for (int i = 0; i < intList.size(); ++i) {
            intArr[i] = intList.get(i);
        }
        return intArr;
    }

    @And("I print Fibonacci number for n = {int}")
    public void iPrintFibonacciNumberForN(int elNum) {
        if (elNum >= 0) {
            System.out.print("Fibonacci using regular array: ");
            System.out.println(fibonacciNumberArray(elNum));
            System.out.print("Fibonacci using array list: ");
            System.out.println(fibonacciNumberArrayList(elNum));
            System.out.print("Fibonacci using recursion: ");
            System.out.println(fibonacciNumberRecursion(elNum));
        } else throw new Error("Not a whole number: " + elNum);
    }

    private long fibonacciNumberArray(int elNum) {
        long[] fibSeq = new long[elNum + 1];
        fibSeq[1] = 1;
        if (elNum > 1) {
            for (int i = 2; i <= elNum; ++i) {
                fibSeq[i] = fibSeq[i - 1] + fibSeq[i - 2];
            }
        }
        return fibSeq[elNum];
    }

    private long fibonacciNumberArrayList(int elNum) {
        List<Long> fibSeq = new ArrayList<>(elNum + 1);
        fibSeq.add((long)0);
        fibSeq.add((long)1);
        if (elNum > 1) {
            for (int i = 2; i <= elNum; ++i) {
                fibSeq.add(fibSeq.get(i - 1) + fibSeq.get(i - 2));
            }
        }
        return fibSeq.get(elNum);
    }

    private long fibonacciNumberRecursion(int elNum) {
        if (elNum > 1) {
            return fibonacciNumberRecursion(elNum - 1) + fibonacciNumberRecursion(elNum - 2);
        } else return elNum;
    }

    @And("I check if {string} is a palindrome word")
    public void iCheckIfIsAPalindrome(String wordToCheck) {
        if (wordToCheck.length() > 0) {
            char[] chars = wordToCheck.toCharArray();
            boolean isPalindrome = true;
            int len = chars.length;
            for (int i = 0; i < (len / 2); ++i) {
                if (chars[i] != chars[len - 1 - i]) {
                    isPalindrome = false;
                    break;
                }
            }
            System.out.println("Is " + wordToCheck + " a palindrome? " + isPalindrome);
        } else throw new Error("Empty word - nothing to check!");
    }
}