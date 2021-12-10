package definitions;

import io.cucumber.java.en.Given;

import java.util.Arrays;

public class Day11hwStepDefs {

    @Given("I reverse new string {string}")
    public void printReversedString(String str) {
        System.out.println("Before: " + str);
        System.out.println("After: " + getReversed(str));
    }

    String getReversed(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            str += str.charAt(i);
        }
        return str.substring(str.length() / 2);
    }

    @Given("I check if Integer & String arrays contain some data")
    public void isArraysContain() {
        Integer[] arrInt = {2, 3, 5, 8, 9};
        Integer intEl = 8;

        String[] arrStr = {"AB", "cd", "Delta", "VZ", "n!"};
        String strEl = "VZ";

        System.out.println("arrInt contains intEl: " + checkArrays(arrInt, intEl));
        System.out.println("arrStr contains strEl: " + checkArrays(arrStr, strEl));
    }

    boolean checkArrays(Object[] array, Object element) {
        for (Object arrayEl : array) {
            if (arrayEl.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Given("I sort an int array")
    public void printSortedArray() {
        int[] unsorted = {3, 7, 3, 2, 5, 8, 9};
        System.out.println(Arrays.toString(unsorted));
        int[] sorted = getSorted(unsorted);
        System.out.println(Arrays.toString(sorted));
    }

    int[] getSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i];
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
















