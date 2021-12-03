package definitions;

import io.cucumber.java.en.Given;

import java.util.Arrays;

public class Day10hwStepDefs {

    //#1
    @Given("I swap two array elements {int} and {int}")
    public void iSwapTwoArrayElements(int j, int k) {
        int[] ar1 = {5, 2, 9, 7, 3};
        System.out.println("Before: " + Arrays.toString(ar1));

        ar1[j - 1] = ar1[j - 1] * ar1[k - 1];
        ar1[k - 1] = ar1[j - 1] / ar1[k - 1];
        ar1[j - 1] = ar1[j - 1] / ar1[k - 1];

        System.out.println("After: " + Arrays.toString(ar1));
    }

    //#2
    @Given("I check if {int} is divisible by {int} and {int}")
    public void checkIfNumberDivisibleBy(int dividend, int firstDiv, int secDiv) {
        if (dividend % firstDiv == 0 && dividend % secDiv == 0) {
            System.out.println("Dividend: " + dividend + "; divisible by: " + firstDiv + " and " + secDiv);
            return;
        }
        if (dividend % firstDiv == 0) {
            System.out.println("Dividend: " + dividend + "; divisible by: " + firstDiv);
            return;
        }
        if (dividend % secDiv == 0) {
            System.out.println("Dividend: " + dividend + "; divisible by: " + secDiv);
        } else System.out.println("Dividend: " + dividend + "; not divisible by: " + firstDiv + " and " + secDiv);
    }

    //#3
    @Given("I get max element in an array")
    public void getMaxElement() {
        int[] ar1 = {5, 2, 9, 7, 3};
        System.out.println("Array: " + Arrays.toString(ar1));

        int maxElem = ar1[0];
        for (int i = 1; i < ar1.length; i++) {
            if (ar1[i] > maxElem) {
                maxElem = ar1[i];
            }
        }
        System.out.println("MaxElement: " + maxElem);
    }

    //#4
    @Given("I print all the elements from {int} to {int} but multiples of {int} and {int}")
    public void printElementsAndFizzBuzz(int start, int end, int multiple1, int multiple2) {
        for (int i = start; i <= end; i++) {
            if (i % multiple1 == 0 && i % multiple2 == 0) {
                System.out.print("FizzBuzz ");
                continue;
            }
            if (i % multiple1 == 0) {
                System.out.print("Fizz ");
                continue;
            }
            if (i % multiple2 == 0) {
                System.out.print("Buzz ");
            } else System.out.print(i + " ");
        }
    }

    //#5
    @Given("I reverse string {string}")
    public String reverseString(String name) {
        System.out.println("String before: " + name);

        String revName = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            revName += name.charAt(i);
        }
        System.out.println("String after: " + revName);
        return revName;
    }

    //#6
    @Given("I reverse words in a sentence {string}")
    public void reverseSentenceWords(String sentence) {
        System.out.println("Sentence before: " + sentence);

        String[] strToArr = sentence.split(" ");
        String[] strToArr2 = new String[strToArr.length];

        for (int i = 0; i < strToArr.length; i++) {
            StringBuilder reverseName = new StringBuilder(strToArr[i]);
            reverseName.reverse();
            strToArr2[i] = reverseName.toString();
        }
        System.out.println("Arrays.toString: " + Arrays.toString(strToArr2));
        System.out.println("Sentence after: " + String.join(" ", strToArr2));
    }

    @Given("I reverse String array")
    public String[] reverseArray(String[] strArray) {
        String[] revArray = new String[strArray.length];
        for (int i = strArray.length - 1; i >= 0; i--) {
            revArray[strArray.length - 1 - i] = strArray[i];
        }
        return revArray;
    }

    @Given("I use my methods to reverse words in a sentence {string}")
    public void reverseSentenceWord2(String sentence) {

        String[] revStr = reverseString(sentence).split(" ");

        String[] revSentence = reverseArray(revStr);

        System.out.println("Sentence after: " + String.join(" ", revSentence));
    }
}



