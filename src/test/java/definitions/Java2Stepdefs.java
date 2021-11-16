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
        printNumbers(5);
        printNumbers(-5);
        int arr[] = {-2,-4,5,7,8,-10};
        int array[] = {1,2,3,4,5};
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
    }

// 1) Write a function that prints all numbers from 0 up to n
// 2) Write a function that supports also negative numbers

    private void printNumbers(int num) {
        if (num >=0) {
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
    private void printNumFromArray(int[] array){
        for (int i = 0; i < array.length; i++){
            if (array[i] < 0) {
                System.out.println("Negative: " + array[i]);
            } else {
                System.out.println("Positive: " + array[i]);
            }
        }
    }

// Print array
    private void printArray (int[] array){
        System.out.println("Array:");
        System.out.println(Arrays.toString(array));
    }

// 3) Write a function that prints all integer array
    private void printIntArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.println("array[" + i + "] = " + array[i]);
        }
    }

    private void printIntArray2(int[] array){
        for(int el : array){
            System.out.println(el);
        }
    }

// 4) Write a function that prints all even numbers from integer array
    private void printEvenNumbers(int[] array){
        for (int i = 0; i < array.length; i++){
            if(i%2 == 0)
            System.out.println(i);
        }
    }

// 5) Write a function that checks if array is empty
    public void checkIfArrayIsEmpty(int[] array){
        if (array == null){
            System.out.println("Array is null");
        } else if (array.length == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.println("Array is not empty");
        }
    }

// 6) Write a function that checks if array contains another element
    public void checkIfContains(int[] array, int num){
        for(int i = 0; i < array.length;  i++) {
            if (array[i] == num) {
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);
    }

    public void checkIfArrayContains(int[] array, int num) {
        boolean contains = false;
        for (int i = 0; i<array.length; i++){
            if (array[i] == num){
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
}
