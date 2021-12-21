package definitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import java.lang.Object;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Java2Stepdefs {
    @Given("I solve Java tasks")

    public void iSolveJavaTasks() {
        // ********************** Day 1 ********************************
        printNumbers(5);
        printNumbers(-5);
        int arr[] = {-2, -4, 5, 7, 8, -10};
        int array[] = {1, 2, 3, 4, 5};
        int emptyArray[] = {};
        int arrayIsNull[] = null;
        printNumFromArray(arr);
        printArray(arr);
        printIntArray(array);
        printIntArray2(array);
        printEvenNumbers(array);
        checkIfArrayIsEmpty(array);
        checkIfArrayIsEmpty(emptyArray);
        checkIfArrayIsEmpty(arrayIsNull);
        checkIfContains(arr, 5);
        checkIfContains(arr, 15);
        checkIfArrayContains(arr, 7);
        checkIfArrayContains(arr, 15);
        // ********************** Day 2 ********************************
        printSumFromOneToNum(5);
        printSumModif(17);
        option(3, "sum");
        option(3, "product");
        option2(2, "sum");
        option(2, "product");
        // ********************** Day 3 ********************************
        int array2[] = {5, 3, 2, 8, 4, 1};
        sortArr(array2);
        int[] ar1 = {0, 1, 5, 2, 8, 3};
        int[] ar2 = {0, 5, 8, -70, 88, 98};
        twoArraysWithTheSameLength(ar1, ar2);
        int[] arr1 = {0, 1, 5, 2, 8, 3};
        int[] arr2 = {0, 5, 8, -70, 76, 87, -98, 95};
        twoArraysWithDiffLength(arr1, arr2);
        // ********************** Dec_2 ********************************

    }

// 1) Write a function that prints all numbers from 0 up to n
// 2) Write a function that supports also negative numbers

    private void printNumbers(int num) {
        if (num >= 0) {
            for (int i = 0; i <= num; i++) {
                System.out.println(i);
            }
        } else {
            for (int i = 0; i >= num; i--) {
                System.out.println(i);
            }
        }
    }

    // Print all positive and negative numbers from the array
    private void printNumFromArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                System.out.println("Negative: " + array[i]);
            } else {
                System.out.println("Positive: " + array[i]);
            }
        }
    }

    // Print array
    private void printArray(int[] array) {
        System.out.println("Array:");
        System.out.println(Arrays.toString(array));
    }

    // 3) Write a function that prints all integer array
    private void printIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }

    private void printIntArray2(int[] array) {
        for (int el : array) {
            System.out.println(el);
        }
    }

    // 4) Write a function that prints all even numbers from integer array
    private void printEvenNumbers(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0)
                System.out.println(i);
        }
    }

    // 5) Write a function that checks if array is empty
    public void checkIfArrayIsEmpty(int[] array) {
        if (array == null) {
            System.out.println("Array is null");
        } else if (array.length == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array is not empty");
        }
    }

    // 6) Write a function that checks if array contains another element
    public void checkIfContains(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    public void checkIfArrayContains(int[] array, int num) {
        boolean contains = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                contains = true;
                break;
            }
        }
        if (contains) {
            System.out.println("Array contains: " + num);
        } else {
            System.out.println("Array doesn't contain: " + num);
        }
    }

    // Write a program that prints the sum of the numbers 1 to n // Ask if we should include n
    public void printSumFromOneToNum(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
    }

// Modify the previous program such that only multiples of tree or five are considered in the sum,
// e.g. 3,5,6,9,10,12,15 for n=17

    public void printSumModif(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        System.out.println("sum = " + sum);
    }

// Write program that takes a number n and gives the possibility to choose between computing
// the sum and computing the product of 1....n

    public void option(int num, String option) {
        if (option.equals("sum")) {
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i;
            }
            System.out.println("sum = " + sum);
        } else if (option.equals("product")) {
            int product = 1;
            for (int i = 1; i <= num; i++) {
                product += i;
            }
            System.out.println("product = " + product);
        } else {
            System.out.println("Incorrect option: " + option + ", use sum or product");
        }
    }

    public void option2(int num, String option) {
        int result;
        if (option.equals("sum")) {
            result = 0;
        } else if (option.equals("product")) {
            result = 1;
        } else {
            System.out.println("Incorrect option: " + option + ", use sum or product");
            return;
        }
        for (int i = 1; i <= num; i++) {
            if (option.equals("sum")) {
                result += i;
            } else {
                result *= i;
            }
        }
        System.out.println("result = " + result);
    }

    public void option3(int num, String option) {
        int result;
        switch (option) {
            case "sum":
                result = 0;
                break;
            case "product":
                result = 1;
                break;
            default:
                System.out.println("Incorrect option: " + option + ", use sum or product");
                return;
        }
        for (int i = 1; i <= num; i++) {
            if (option.equals("sum")) {
                result += i;
            } else {
                result *= i;
            }
        }
        System.out.println("result = " + result);
    }

    // Sort array
    private void sortArr(int[] arr) {
        /*  [5, 3, 2, 8, 4, 1]
            [5, 3, 2, 8, 4, 1] => 1(5) => [1, 3, 2, 8, 4, 5]
            [1, | 3, 2, 8, 4, 5] => 2(idx) => [1, 2, 3, 8, 4, 5]
            [1, 2, | 3, 8, 4, 5] => [1, 2, 3, 8, 4, 5]
            [1, 2, 3, | 8, 4, 5]
        */
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < arr.length - 1; j++) {
            int idxMin = j;
            int min = arr[idxMin];
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    idxMin = i;
                }
            }
            int temp = arr[j];
            arr[j] = min;
            arr[idxMin] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }

    private void sortArr2() {
        // original array
        int arr[] = {5, 3, 2, 8, 4, 1};
        System.out.println(Arrays.toString(arr));
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = arr[temp];
                }
            }
        }
        // sorted array
        System.out.println(Arrays.toString(arr));
    }

    //*******************************************************************************

//  You have an array of numbers.
//  Your task is to sort odd numbers in ascending order but even numbers must be on their places.
//  Example:
//  input:  [5, 3, 2, 8, 4, 1]
//  output: [1, 3, 2, 8, 4, 5]

    public void twoArrays() {
//        Write a function that combines two arrays (lists) by alternating taking elements,
//        e.g. [0,5,8], [1,2,3] → [0, 1, 5, 2, 8, 3].
//        e.g. [0,5,8,  9,1], [1,2,3] → [0, 1, 5, 2, 8, 3, 9, 1].
        int[] arr1 = {0,5,8};
        int[] arr2 = {1,2,3,9,1};
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

//Write a function that combines two arrays (lists) by alternating taking elements,
//        e.g. [0,5,8], [1,2,3] → [0, 1, 5, 2, 8, 3].
//        e.g. [0,5,8,  9,1], [1,2,3] → [0, 1, 5, 2, 8, 3, 9, 1].

    private void twoArraysWithTheSameLength(int[] ar1, int[] ar2) {

        int n = ar1.length + ar2.length;
        int[] ar3 = new int[n];

        for (int i = 0; i < ar3.length; i++) {
            if (i % 2 == 0) {
                ar3[i] = ar1[i / 2];
            } else
                ar3[i] = ar2[i / 2];
        }
        System.out.println(Arrays.toString(ar3));
    }

    public void twoArraysWithDiffLength(int[] arr1, int[] arr2) {
        //Write a function that combines two arrays (lists) by alternating taking elements,
//        e.g. [0,5,8], [1,2,3] → [0, 1, 5, 2, 8, 3].
//        e.g. [0,5,8,  9,1], [1,2,3] → [0, 1, 5, 2, 8, 3, 9, 1].

        int n = arr1.length + arr2.length;
        int[] arr3 = new int[n];

        //System.out.println(Arrays.toString(ar3));
        int minLen = (Math.min(arr1.length, arr2.length));

        for (int i = 0; i < minLen * 2; i++) {
            if (i % 2 == 0) {
                arr3[i] = arr1[i / 2];
            } else
                arr3[i] = arr2[i / 2];
        }
        int indNext = minLen * 2;

        if (arr1.length > arr2.length) {
            int k = arr1.length - 1;
            for (int j = arr3.length - 1; j >= indNext; j--, k--) {
                arr3[j] = arr1[k];
            }
        } else {
            int k = arr2.length - 1;
            for (int j = arr3.length - 1; j >= indNext; j--, k--) {
                arr3[j] = arr2[k];
            }
        }
        System.out.println(Arrays.toString(arr3));
    }
    //************************************Dec_2******************************************

    // Write a function that reverses words in a sentence
    // "I love Kansas" --> "Kansas love I"
    // str.split() --> array
    // StringBuilder

    // for --> insert

    // .split(" " | ",")

    // while loop with idx, start from 0
    // idx2
    // "I   love Kansas"

    //*******************************************************************************************
}







