package definitions;

import io.cucumber.java.en.Given;

import java.util.Arrays;

public class Day16hwStepDefs {

    @Given("I find two max numbers in the array")
    public void findTwoMaxArrayNumbers() {
        int[] unsorted = {3, 7, -3, -2, 9, 5, 8, 9};
        System.out.println("Before: " + Arrays.toString(unsorted));

        int[] sorted = getSorted(unsorted);
        System.out.println("After: " + Arrays.toString(sorted));

        System.out.println(String.format("First MaxElement: %d, Second MaxElement: %d", sorted[sorted.length - 1], sorted[sorted.length - 2]));
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

    @Given("I check if {string} is the palindrome")
    public void iCheckIfStringIsThePalindrome(String str) {
        System.out.println("Before: " + str);
        System.out.println("After: " + reverseString(str.toUpperCase()));
        System.out.println("Palindrome: " + checkPalindrome(str.toUpperCase(), reverseString(str.toUpperCase())));
    }

    static String reverseString(String name) {
        String revName = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            revName += name.charAt(i);
        }
        return revName;
    }

    static boolean checkPalindrome(String str1, String str2) {
        return str1.equals(str2);
    }

    @Given("I check if an Arraycontains duplicates")
    public void checkDuplicates() {
        int[] arr = {2, 3, 5, 7, 8, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Array contains duplicates");
                    return;
                }
            }
        }
        System.out.println("No duplicates");
    }



    @Given("I write three lines code to find two max numbers in the array")
    public void iWriteThreeLinesCodeToFindTwoMaxNumbersInTheArray() {

        int[] ar1 = {3, 7, -3, -2, 9, 5, 8, 9};
        Arrays.sort(ar1);
        System.out.println(String.format("First Max: %d, Second Max: %d", ar1[ar1.length - 1], ar1[ar1.length - 2]));
    }
}

