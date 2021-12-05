package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;


public class JavaStepDefs {
    @Given("I write a function that prints all numbers from {int} up to {int}")
    public void iWriteAFunctionThatPrintsAllNumbersFromUpTo(int num1, int num2) {
        for (int i = num1; i <= num2; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    @When("I write a function that supports also negative numbers from {int} to {int}")
    public void iWriteAFunctionThatSupportsAlsoNegativeNumbersFromTo(int first, int last) {
        for (int j = first; j <= last; j++) {
            System.out.print(j + " ");
        }
    }

    @Then("I write a function that prints all integer array")
    public void iWriteAFunctionThatPrintsAllIntegerArray() {
        int[] nums = {12, 5, 7, 1, 0, 5};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    @And("I write a function that prints all even numbers from integer array")
    public void iWriteAFunctionThatPrintsAllEvenNumbersFromIntegerArray() {
        int[] arr = {6, 5, 8, 12, 1, 2, 18};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    @And("I write a function that checks if array is empty")
    public void iWriteAFunctionThatChecksIfArrayIsEmpty() {
        int[] emptyarr = {3, 5, 1, 6, 10};
        if (emptyarr.length == 0) {
            System.out.print("Array is emply");
        } else {
            System.out.print("Array is not empty: ");
            for (int i = 0; i < emptyarr.length; i++) {
                System.out.print(emptyarr[i] + " ");
            }
        }
    }

    @And("Write a function that checks if array contains another element")
    public void writeAFunctionThatChecksIfArrayContainsAnotherElement() {
        List<Integer> elemcheck = new ArrayList<>();
        elemcheck.add(5);
        elemcheck.add(22);
        elemcheck.add(4);
        elemcheck.add(185);
        elemcheck.add(3);
        elemcheck.add(-9);
        elemcheck.add(1);
        elemcheck.add(1);
        elemcheck.add(3);
        System.out.print(elemcheck.contains(-9));
    }

    @Given("We have have hashmap myinfo")
    public void weHaveHaveHashmapMyinfo() {
        HashMap<String, String> myInfo = new HashMap<String, String>();
        myInfo.put("firstname", "Ivan");
        myInfo.put("lastName", "Romanov");
        myInfo.put("hometown", "Chicago");
        myInfo.put("favoriteFood", "Steak");
        System.out.println(myInfo);
        myInfo.get("firstname");
        System.out.println(myInfo.get("firstname"));
        myInfo.replace("hometown", "Kirov");
        System.out.println(myInfo);
    }

    @Given("I solve java task")
    public void iSolveJavaTask() {
//        Write a function that combines two arrays (lists) by alternating taking elements,
//        e.g. [0,5,8], [1,2,3] → [0, 1, 5, 2, 8, 3].
//        e.g. [0,5,8,  9,1], [1,2,3] → [0, 1, 5, 2, 8, 3, 9, 1].
        int[] arr1 = {0, 5, 8};
        int[] arr2 = {1, 2, 3, 9, 1};
        solveIt(arr1, arr2);
    }

    private void solveIt(int[] arr1, int[] arr2) {
        int len = arr1.length + arr2.length;
        int[] res = new int[len];
//        int min_len = Math.min(arr1.length, arr2.length);
        int min_len = arr1.length < arr2.length ? arr1.length : arr2.length;
        // 3
        for (int k = 0; k < min_len * 2; k = k + 2) {
            res[k] = arr1[k / 2];
            res[k + 1] = arr2[k / 2]; // k = 2; 2/2 -> 1
        }
        // res = [0, 1, 5, 2, 8, 3, _, _]
        // rest of arr1: [9,1]
        // min_len = 3
        // [0,5,8,   9,1]
        for (int idx = min_len; idx < arr1.length; idx++) {
            // idx = 3
            // idx 3 -> idx - min_len => 0
            int res_idx = min_len * 2 + idx - min_len;
            res[res_idx] = arr1[idx];
        }
        for (int idx = min_len; idx < arr2.length; idx++) {
            // idx = 3
            // idx 3 -> idx - min_len => 0
            int res_idx = min_len * 2 + idx - min_len;
            res[res_idx] = arr2[idx];
        }
        System.out.println(Arrays.toString(res));
    }

    @Given("I solve codding challenges")
    public void iSolveCoddingChallenges() {
        toSwap(3, 5);
    }

    void toSwap(int num1, int num2) {
        System.out.println("Swap method begin - num1:" + num1 + "num2: " + num2);
        num1 = num1 + num2; //8
        num2 = num1 - num2; //3
        num1 = num1 - num2; //5
        System.out.println("Swap method end - num1:" + num1 + "num2: " + num2);
    }

    @Given("I write a function that accepts integer number and prints")
    public void iWriteAFunctionThatAcceptsIntegerNumberAndPrints() {
        toSwap(3, 5);
        printDivBy3and4(12);
        printDivBy3and4(9);
        printDivBy3and4(8);
        printDivBy3and4(7);
    }

    //I write a function that accepts integer number and prints
    //"divisible by 3" if number is divisible by 3
    //"divisible by 4" if number is divisible by 4
    //"divisible by 3 and 4" if number is divisible by 3 and 4
    void printDivBy3and4(int num) {
        System.out.println("Is " + num + " divisible by 3 and 4?");
        if (num % 3 == 0 && num % 4 == 0) {
            System.out.println("divisible by 3 and 4");
        } else if (num % 3 == 0) {
            System.out.println("divisible by 3");
        } else if (num % 4 == 0) {
            System.out.println("divisible by 4");
        } else {
            System.out.println("Not divisible by 3 and 4");
        }
    }

    @Given("I write function that swap that swap two array elements")
    public void iWriteFunctionThatSwapThatSwapTwoArrayElements() {
        List<Integer> list = Arrays.asList(5, 2, 9, 7, 3);
        System.out.println("Array before swap: " + list);
        Collections.swap(list, 0, 4);
        System.out.println("Array after swap: " + list);

    }

    @Then("I Write a function to find the largest element in an array")
    public void iWriteAFunctionToFindTheLargestElementInAnArray() {
        int[] myArr1 = {5, 2, 9, 7, 3};
        int max = myArr1[0];
        for (int i = 0; i < myArr1.length; i++) {
            if (myArr1[i] > max)
                max = myArr1[i];
        }
        System.out.println("The biggest number in array: " + max);
    }
}


    //        Write a function, accepts integer argument
//        It should print all the numbers up to the argument
//        BUT:
//        if number is multiple of 3, it should print Fizz instead of number
//        if number is multiple of 5, it should print Buzz instead of number
//        if it is multiple of both 3 and 5, it should print FizzBuzz instead of number
//        Result for 20:
//        1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz 16 17 Fizz 19 Buzz





