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

        int temp = intArr[p2 - 1];
        intArr[p2 - 1] = intArr[p1 - 1];
        intArr[p1 - 1] = temp;

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
            for (int i = 0; i >= num; --i) {
                System.out.println(i);
            }
        }
        System.out.println();

        System.out.println("-n <- 0 -> n as a single loop:");
        int sign = 1;
        if (num < 0) sign = -1;
        for (int i = 0; (num - i) * sign >= 0; i += sign) {
            System.out.println(i);
        }
        System.out.println();

        System.out.println("-n -> 0 -> n as two loops:");
        if (num >= 0) {
            for (int i = 0; i <= num; ++i) {
                System.out.println(i);
            }
        } else {
            for (int i = num; i <= 0; ++i) {
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
        fibSeq.add((long) 0);
        fibSeq.add((long) 1);
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

    @And("I sort {string} numbers in a given array using Bubble Sort")
    public void iSortNumbersInAGivenArrayUsingBubbleSort(String parity, @Transpose List<Integer> intList) {
        boolean isOdd;
        switch (parity) {
            case "odd" -> isOdd = true;
            case "even" -> isOdd = false;
            default -> throw new Error("Incorrect number parity reference: " + parity);
        }
        System.out.println("Given parity: " + parity + ". Is odd? " + isOdd);
        int[] arr = convertListToPrimitiveArray(intList);
        System.out.print("Given array: ");
        System.out.println(Arrays.toString(arr));

        boolean swapped;
        for (int i = 0; i < arr.length - 1; ++i) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; ++j) { // looking for first number with proper parity
                if ((arr[j] % 2 != 0) == isOdd) {
                    for (int k = j + 1; k < arr.length - i; ++k) { // looking for next number with proper parity
                        if ((arr[k] % 2 != 0) == isOdd) {
                            if (arr[j] > arr[k]) {
                                swapArrayValues(arr, j, k);
                                swapped = true;
                            }
                            j = k - 1;
                            break;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!swapped) break;
        }

        System.out.print("Result:      ");
        System.out.println(Arrays.toString(arr));
    }

    @And("I sort given array using different methods")
    public void iSortGivenArrayUsingDifferentMethods(@Transpose List<Integer> intList) {
        int[] originalArr = convertListToPrimitiveArray(intList);
        System.out.print("Given array: ");
        System.out.println(Arrays.toString(originalArr));
        System.out.println();

        int[] arr1 = originalArr.clone();
        System.out.println("Selection sort for: " + Arrays.toString(arr1));
        sortUsingSelectionSort(arr1);
        System.out.print("Result: ");
        System.out.println(Arrays.toString(arr1));
        System.out.println();

        int[] arr2 = originalArr.clone();
        System.out.println("Bubble sort for: " + Arrays.toString(arr2));
        sortUsingBubbleSort(arr2);
        System.out.print("Result: ");
        System.out.println(Arrays.toString(arr2));
        System.out.println();

        int[] arr3 = originalArr.clone();
        System.out.println("Insertion sort for: " + Arrays.toString(arr3));
        sortUsingInsertionSort(arr3);
        System.out.print("Result: ");
        System.out.println(Arrays.toString(arr3));
        System.out.println();

        int[] arr4 = originalArr.clone();
        System.out.println("Quick sort for: " + Arrays.toString(arr4));
        sortUsingQuickSort(arr4, 0, arr4.length - 1);
        System.out.print("Result: ");
        System.out.println(Arrays.toString(arr4));
        System.out.println();

        int[] arr5 = originalArr.clone();
        System.out.println("Merge sort for: " + Arrays.toString(arr5));
        sortUsingMergeSort(arr5, 0, arr5.length - 1);
        System.out.print("Result: ");
        System.out.println(Arrays.toString(arr5));
        System.out.println();

        int[] arr6 = originalArr.clone();
        System.out.println("Radix sort for: " + Arrays.toString(arr6));
        arr6 = sortUsingRadixSort(arr6);
        System.out.print("Result: ");
        System.out.println(Arrays.toString(arr6));
        System.out.println();
    }

    private int[] sortUsingRadixSort(int[] input) {
        int inputSize = input.length;
        int[] output = new int[inputSize];
        int[] counts = new int[10];

        int maxValue = 0;
        for (int m = 1; m < inputSize; ++m) {
            if (input[m] > maxValue) maxValue = input[m];
        }

        for (int digitOrderNumber = 1; maxValue / digitOrderNumber > 0; digitOrderNumber *= 10) {
            //zero out the counts
            Arrays.fill(counts, 0);
            //filling the buckets for appropriate cycle
            for (int n : input) {
                int bucket = (n / digitOrderNumber) % 10;
                counts[bucket]++;
            }
            //prefix sum
            for (int s = 1; s < 10; ++s) {
                counts[s] += counts[s - 1];
            }
            //generating output
            for (int i = inputSize - 1; i >= 0; --i) {
                int bucket = ((input[i] / digitOrderNumber) % 10);
                output[counts[bucket] - 1] = input[i];
                counts[bucket]--;
            }
            System.out.println(Arrays.toString(output));

            int[] tempArr = input;
            input = output;
            output = tempArr;
        }
        return input;
    }

    private void sortUsingMergeSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int div = (start + end) / 2;
        sortUsingMergeSort(arr, start, div);
        sortUsingMergeSort(arr, div + 1, end);

        int leftSize = div - start + 1;
        int rightSize = end - div;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; ++i) {
            left[i] = arr[start + i];
        }
        for (int j = 0; j < rightSize; ++j) {
            right[j] = arr[div + 1 + j];
        }

        int i = 0, j = 0, k = start;

        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < leftSize) arr[k++] = left[i++];
        while (j < rightSize) arr[k++] = right[j++];

        System.out.println(Arrays.toString(arr));
    }

    private void swapArrayValues(int[] arr, int ind1, int ind2) {
        if (ind1 == ind2) return;
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    private void sortUsingQuickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int pivot = end; // pivot strategy - rightmost element
        int left;
        int right = start;
        while (arr[right] < arr[pivot]) ++right;

        for (left = right + 1; left < pivot; ++left) {
            if (arr[left] < arr[pivot]) swapArrayValues(arr, left, right);
            ++right;
        }
        if (right < pivot) swapArrayValues(arr, pivot, right);
        System.out.println(Arrays.toString(arr));

        sortUsingQuickSort(arr, start, right - 1);
        sortUsingQuickSort(arr, right + 1, pivot);
    }

    private void sortUsingInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; --j) {
                if (arr[j] < arr[j - 1]) swapArrayValues(arr, j - 1, j);
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    private void sortUsingBubbleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; ++i) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swapArrayValues(arr, j, j + 1);
                    swapped = true;
                }
            }
            System.out.println(Arrays.toString(arr));
            if (!swapped) break;
        }
    }

    private void sortUsingSelectionSort(int[] arr) {
        for (int j = 0; j < arr.length - 1; j++) {
            int minIndex = j;
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] < arr[minIndex]) minIndex = i;
            }
            if (minIndex > j) swapArrayValues(arr, minIndex, j);
            System.out.println(Arrays.toString(arr));
        }
    }

    @And("I mix given arrays")
    public void iMixGivenArrays(Map<String, List<Integer>> input) {
        List<Integer> list1 = input.get("array 1");
        list1.removeAll(Collections.singleton(null));
        int[] arr1 = convertListToPrimitiveArray(list1);
        List<Integer> list2 = input.get("array 2");
        list2.removeAll(Collections.singleton(null));
        int[] arr2 = convertListToPrimitiveArray(list2);

        int[] resultArray = mixArrays(arr1, arr2);
        System.out.println(Arrays.toString(resultArray));

        List<Integer> resultList = mixLists(list1, list2);
        System.out.println(resultList);
    }

    private List<Integer> mixLists(List<Integer> list1, List<Integer> list2) {
        ListIterator<Integer> leftItr = list1.listIterator();
        ListIterator<Integer> rightItr = list2.listIterator();
        List<Integer> resultList = new ArrayList<>();

        while (leftItr.hasNext() && rightItr.hasNext()) {
            resultList.add(leftItr.next());
            resultList.add(rightItr.next());
        }
        while (leftItr.hasNext()) resultList.add(leftItr.next());
        while (rightItr.hasNext()) resultList.add(rightItr.next());

        return resultList;
    }

    private int[] mixArrays(int[] leftArr, int[] rightArr) {
        int leftLen = leftArr.length;
        int rightLen = rightArr.length;
        int[] resultArr = new int[leftLen + rightLen];

        int i = 0, j = 0, k = 0;
        while ((i < leftLen) && (j < rightLen)) {
            resultArr[k++] = leftArr[i++];
            resultArr[k++] = rightArr[j++];
        }
        while (i < leftLen) resultArr[k++] = leftArr[i++];
        while (j < rightLen) resultArr[k++] = rightArr[j++];

        return resultArr;
    }

    @And("I find largest element in given array")
    public void iFindLargestElementInGivenArray(@Transpose List<Integer> list) {
        int[] arr = convertListToPrimitiveArray(list);

        int maxInd = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > arr[maxInd]) maxInd = i;
        }
        System.out.println("Max element: " + arr[maxInd]);
    }

    @And("I provide FizzBuzz output for number {int}")
    public void iProvideFizzBuzzOutputForNumber(int num) {
        for (int i = 0; i <= num; ++i) {
            if ((i % 3 == 0) && (i % 5 == 0)) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }

    @And("I reverse a given string {string}")
    public void iReverseAGivenString(String str) {
        System.out.println("Original: " + str);
        char[] charArr = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < len / 2; ++i) {
            char temp = charArr[i];
            charArr[i] = charArr[len - 1 - i];
            charArr[len - 1 - i] = temp;
        }
        System.out.println("Result: " + new String(charArr));

        System.out.println("StringBuilder reverse: " + new StringBuilder(str).reverse());
    }

    @And("I reverse word order in a given sentence {string}")
    public void iReverseWordOrderInAGivenSentence(String sentence) {
        System.out.println("Original: " + sentence);
        String[] words = sentence.split(" ");
        System.out.println(Arrays.toString(words));
        int len = words.length;
        for (int i = 0; i < len / 2; ++i) {
            String temp = words[i];
            words[i] = words[len - 1 - i];
            words[len - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(words));
        String resultSentence = "";
        for (String el : words) resultSentence = resultSentence.concat(el + " ");
        System.out.println("Result: " + resultSentence);
    }
}