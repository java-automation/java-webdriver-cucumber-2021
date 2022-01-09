package definitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Animal;
import pages.Cat;
import pages.Dog;
import pages.Frog;

import java.math.BigInteger;
import java.util.*;

public class JavaStepDefs {

    @Then("Show the greeting when I'm {string} {string} and my favorite color is {string}")
    public void showTheGreetingWhenIMAndMyFavoriteColorIs(String firstName, String lastName, String favoriteColor) {
        System.out.println("Hi, my name is '" + firstName + "' '" + lastName + "' and my favorite color is '" + favoriteColor + "'!");
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
        System.out.println("Number one devided by number two (int): " + (numberOne / numberTwo));
        System.out.println("Number one devided by 1.5: " + (numberOne / 1.5));
        System.out.println("Sum: " + (numberOne + numberTwo));
        System.out.println("Difference: " + (numberOne - numberTwo));
        System.out.println("Quotient: " + ((float) numberOne / numberTwo));
        System.out.println("Product: " + (numberOne * numberTwo));
    }

    @Then("Show the message when my favorite color is {string}, but not {string}")
    public void showTheMessageWhenMyFavoriteColorIsButNot(String favoriteColor, String notFavoriteColor) {
        System.out.println("Is my favorite color '" + favoriteColor + "' equal to '" + notFavoriteColor + "'? " +
                favoriteColor.equals(notFavoriteColor));
    }

    @Then("Compare {string} and {string}")
    public void compareStringOneAndStringTwo(String stringOne, String stringTwo) {
        if (stringOne.equals(stringTwo)) {
            System.out.println("'" + stringOne + "' is equal to '" + stringTwo + "'");
        } else {
            System.out.println("'" + stringOne + "' is not equal to '" + stringTwo + "'");
        }
    }

    @Then("I print URL for {string} page")
    public void iPrintURLForSitePage(String websiteReference) {
        String address = GenericStepDefs.getURLUsingKnownReference(websiteReference);
        System.out.println("URL for '" + websiteReference + "' reference: " + address);
    }

    @And("I print if number {string} is positive")
    public void iPrintIfNumberIsPositive(String numStr) {
        int num = Integer.parseInt(numStr);
        if (num > 0) {
            System.out.println("Number '" + numStr + "' is positive");
        } else if (num < 0) {
            System.out.println("Number '" + numStr + "' is negative");
        } else {
            System.out.println("Number is zero");
        }
    }

    @And("I print day of the week that comes {int} days after today and today is {string}")
    public void iPrintDayOfTheWeekThatComesDaysAfterTodayAndTodayIs(int numOfDays, String today) {
        System.out.println("Today is '" + today + "'. After '" + numOfDays + "' days comes '" + getDayOfTheWeekAfterNDaysConsideringToday(numOfDays, today) + "'");
    }

    private String getDayOfTheWeekAfterNDaysConsideringToday(int numOfDays, String today) {
        String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int dayShift = 0;
        for (int i = 0; i < daysOfWeek.length; ++i) {
            if (daysOfWeek[i].equals(today)) dayShift = i;
        }
        return daysOfWeek[(numOfDays % 7) + dayShift];
    }

    @And("I print my grocery list")
    public void iPrintMyGroceryList() {
        System.out.println("Basic array:");
        String[] groceryArray = {"apple", "banana", "milk", "potato", "icecream", "rice"};
        System.out.println("Print reference: " + groceryArray); //intended, to see the difference with next line
        System.out.println("To string: " + Arrays.toString(groceryArray));
        System.out.println("Element 0: " + groceryArray[0]);
        System.out.println("Element 2: " + groceryArray[2]);
        groceryArray[2] = "mango";
        System.out.println("Element 2 again: " + groceryArray[2]);
        System.out.println();

        System.out.println("List:");
        List<String> groceryList = List.of("apple", "banana", "milk", "potato", "icecream", "rice");
        System.out.println("Print reference: " + groceryList);
        System.out.println("Contains 'apple'? " + groceryList.contains("apple"));
        System.out.println("Element 0: " + groceryList.get(0));
        System.out.println("Element 2: " + groceryList.get(2));
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
        String key = "firstname";
        System.out.println("Key: " + key + ". Value: " + me.get("firstName"));
        key = "hometownR";
        System.out.println("Key: " + key + ". Value: " + me.get("hometownR"));
        System.out.println("entrySet(): " + me.entrySet());
        System.out.println("keySet(): " + me.keySet());
        System.out.println("values(): " + me.values());
    }

    @And("I swap variables {int} and {int} using different methods")
    public void iSwapVariablesAndUsingDifferentMethods(int x, int y) {
        System.out.println("Initial values: ");
        System.out.println("x = " + x + ", y = " + y);
        System.out.println();

        System.out.println("3rd variable: ");
        int temp = x;
        x = y;
        y = temp;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println();

        System.out.println("Using product: ");
        if ((x == 0) || (y == 0)) System.out.println("zero value - can't use swap by product/division");
        else {
            x = x * y;
            y = x / y;
            x = x / y;
        }
        System.out.println("x = " + x + ", y = " + y);
        System.out.println();

        System.out.println("Using sum: ");
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println();

        System.out.println("Using XOR: ");
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println("x = " + x + ", y = " + y);
        System.out.println();
    }

    @And("I swap elements with positions {int} and {int} in array of integers")
    public void iSwapElementsWithPositionsAndInArrayOfIntegers(int p1, int p2, @Transpose List<Integer> intList) {
        int[] intArr = convertListToPrimitiveArray(intList);

        System.out.print("Original array: ");
        System.out.println(Arrays.toString(intArr));

        swapIntegerArrayValues(intArr, p2 - 1, p1 - 1);

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
        } else System.out.println("Not divisible by " + div1 + " or " + div2);
    }

    @And("I print all numbers from zero to {int}")
    public void iPrintAllNumbersFromZeroTo(int num) {
        System.out.println("-n <- 0 -> n as a single loop:");
        printNumbersFromZeroToN(num);
        System.out.println();

        System.out.println("-n -> 0 -> n as a single loop:");
        printNumbersBetweenZeroAndNInAscendingOrder(num);
        System.out.println();
    }

    private void printNumbersBetweenZeroAndNInAscendingOrder(int num) {
        int k = (num < 0) ? 0 : 1;
        for (int i = (1 - k) * num; i <= k * num; ++i) System.out.print(i + " ");
    }

    private void printNumbersFromZeroToN(int num) {
        int sign = (num < 0) ? -1 : 1;
        for (int i = 0; (num - i) * sign >= 0; i += sign) System.out.print(i + " ");
    }

    @And("For given array I: print, print {string} numbers, check if it's empty, check if it contains number {int}")
    public void iDoMyArrayExercisesWithNumberAndParity(String parityStr, int numToCheck, @Transpose List<Integer> intList) {
        System.out.println("Printing list as is: " + intList);
        System.out.print("Printing list with enhanced for: ");
        for (int el : intList) System.out.print(el + " ");
        System.out.println();

        int[] intArr = convertListToPrimitiveArray(intList);

        System.out.println("Printing after conversion to primitive array: " + Arrays.toString(intArr));
        System.out.print("Printing array with enhanced for: ");
        for (int el : intArr) System.out.print(el + " ");
        System.out.println();

        System.out.print("Printing all '" + parityStr + "' numbers from the array: ");
        printArrayNumbersWithGivenParity(intArr, parityStr);
        System.out.println();

        System.out.print("Is array empty? ");
        System.out.println((intArr.length == 0));

        System.out.print("Does this array contain '" + numToCheck + "'? ");
        System.out.println(isIntegerArrayContainsGivenValue(intArr, numToCheck));
    }

    private boolean isIntegerArrayContainsGivenValue(int[] intArr, int numToCheck) {
        for (int el : intArr) {
            if (el == numToCheck) return true;
        }
        return false;
    }

    private boolean isOddParse(String parityStr) {
        boolean isOdd;
        switch (parityStr) {
            case "odd" -> isOdd = true;
            case "even" -> isOdd = false;
            default -> throw new Error("Incorrect parity reference (even/odd): " + parityStr);
        }
        return isOdd;
    }

    private void printArrayNumbersWithGivenParity(int[] intArr, String parityStr) {
        boolean printEven = !isOddParse(parityStr);
        for (int el : intArr) {
            if ((el % 2 == 0) == printEven) System.out.print(el + " ");
        }
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
            System.out.println(fibonacciNumberList(elNum));
            System.out.print("Fibonacci using BigInteger array: ");
            System.out.println(fibonacciNumberBigIntArray(elNum));
            System.out.print("Fibonacci using recursion: ");
            System.out.println(fibonacciNumberRecursion(elNum));
        } else throw new Error("Not a whole number: " + elNum);
    }

    private BigInteger fibonacciNumberBigIntArray(int elNum) {
        if (elNum <= 1) return new BigInteger(String.valueOf(elNum));

        BigInteger[] fibSeq = new BigInteger[] {new BigInteger(String.valueOf(0)), new BigInteger(String.valueOf(1))};
        for (int i = 2; i <= elNum; ++i) {
            BigInteger newFibNum = fibSeq[0].add(fibSeq[1]);
            fibSeq[0] = fibSeq[1];
            fibSeq[1] = newFibNum;
        }
        return fibSeq[1];
    }

    private long fibonacciNumberArray(int elNum) {
        if (elNum <= 1) return elNum;

        long[] fibSeq = new long[] {0, 1};
        for (int i = 2; i <= elNum; ++i) {
            long newFibNum = fibSeq[0] + fibSeq[1];
            fibSeq[0] = fibSeq[1];
            fibSeq[1] = newFibNum;
        }
        return fibSeq[1];
    }

    private long fibonacciNumberList(int elNum) {
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
        if (elNum <= 1) return elNum;
        return fibonacciNumberRecursion(elNum - 1) + fibonacciNumberRecursion(elNum - 2);
    }

    @And("I check if {string} is a palindrome")
    public void iCheckIfIsAPalindrome(String wordToCheck) {
        if ((wordToCheck == null) || (wordToCheck.length() == 0)) throw new Error("Empty word - nothing to check!");

        System.out.println("Is '" + wordToCheck + "' a palindrome (char compare)? " + isPalindromeByComparingChars(wordToCheck));
        System.out.println("Is '" + wordToCheck + "' a palindrome (reverse string)? " + wordToCheck.equals(getReversedStringWithStringBuilder(wordToCheck)));
        System.out.println("Is '" + wordToCheck + "' a palindrome (max palindrome from center)? " + wordToCheck.equals(getLongestPalindromeSubstring(wordToCheck)));
    }

    private String getReversedStringWithStringBuilder(String str) {
        return new String(new StringBuilder(str).reverse());
    }

    private boolean isPalindromeByComparingChars(String wordToCheck) {
        int len = wordToCheck.length();
        for (int i = 0; i < (len / 2); ++i) {
            if (wordToCheck.charAt(i) != wordToCheck.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    @And("I sort {string} numbers in a given array using {string} sort")
    public void iSortNumbersInAGivenArrayUsingSort(String parityStr, String sortType, @Transpose List<Integer> intList) {
        System.out.println("Given parity: " + parityStr);
        int[] arr = convertListToPrimitiveArray(intList);
        System.out.print("Given array: ");
        System.out.println(Arrays.toString(arr));

        switch (sortType) {
            case "bubble" -> sortNumbersInArrayWithParityUsingBubbleSort(arr, parityStr);
            case "selection" -> sortNumbersInArrayWithParityUsingSelectionSort(arr, parityStr);
            default -> throw new Error("Unknown sorting algorithm: " + sortType);
        }

        System.out.print("Result: ");
        System.out.println(Arrays.toString(arr));
    }

    private void sortNumbersInArrayWithParityUsingSelectionSort(int[] arr, String parityStr) {
        boolean isOdd = isOddParse(parityStr);
        for (int i = 0; i < arr.length - 1; i++) {
            if ((arr[i] % 2 == 0) == isOdd) continue;
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (((arr[j] % 2 == 0) == !isOdd) && (arr[j] < arr[minIndex])) minIndex = j;
            }
            if (minIndex > i) swapIntegerArrayValues(arr, minIndex, i);
            System.out.println(Arrays.toString(arr));
        }
    }

    private void sortNumbersInArrayWithParityUsingBubbleSort(int[] arr, String parityStr) {
        boolean isOdd = isOddParse(parityStr);
        boolean swapped;
        for (int i = 0; i < arr.length - 1; ++i) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; ++j) { // looking for first number with proper parity
                if ((arr[j] % 2 != 0) == isOdd) {
                    for (int k = j + 1; k < arr.length - i; ++k) { // looking for next number with proper parity
                        if ((arr[k] % 2 != 0) == isOdd) {
                            if (arr[j] > arr[k]) {
                                swapIntegerArrayValues(arr, j, k);
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
    }

    @And("I sort given array using {string} sort")
    public void iSortGivenArrayUsingSort(String sortType, @Transpose List<Integer> intList) {
        boolean isSorted = false;

        int[] originalArr = convertListToPrimitiveArray(intList);
        System.out.print("Given array: ");
        System.out.println(Arrays.toString(originalArr));
        System.out.println();

        if (sortType.equals("selection") || (sortType.equals("all"))) {
            int[] arr1 = originalArr.clone();
            System.out.println("Selection sort for: " + Arrays.toString(arr1));
            sortUsingSelectionSort(arr1);
            System.out.print("Result: ");
            System.out.println(Arrays.toString(arr1));
            System.out.println();
            isSorted = true;
        }

        if (sortType.equals("bubble") || (sortType.equals("all"))) {
            int[] arr2 = originalArr.clone();
            System.out.println("Bubble sort for: " + Arrays.toString(arr2));
            sortUsingBubbleSort(arr2);
            System.out.print("Result: ");
            System.out.println(Arrays.toString(arr2));
            System.out.println();
            isSorted = true;
        }

        if (sortType.equals("insertion") || (sortType.equals("all"))) {
            int[] arr3 = originalArr.clone();
            System.out.println("Insertion sort for: " + Arrays.toString(arr3));
            sortUsingInsertionSort(arr3);
            System.out.print("Result: ");
            System.out.println(Arrays.toString(arr3));
            System.out.println();
            isSorted = true;
        }

        if (sortType.equals("quick") || (sortType.equals("all"))) {
            int[] arr4 = originalArr.clone();
            System.out.println("Quick sort for: " + Arrays.toString(arr4));
            sortUsingQuickSort(arr4, 0, arr4.length - 1);
            System.out.print("Result: ");
            System.out.println(Arrays.toString(arr4));
            System.out.println();
            isSorted = true;
        }

        if (sortType.equals("merge") || (sortType.equals("all"))) {
            int[] arr5 = originalArr.clone();
            System.out.println("Merge sort for: " + Arrays.toString(arr5));
            sortUsingMergeSort(arr5, 0, arr5.length - 1);
            System.out.print("Result: ");
            System.out.println(Arrays.toString(arr5));
            System.out.println();
            isSorted = true;
        }

        if (sortType.equals("radix") || (sortType.equals("all"))) {
            int[] arr6 = originalArr.clone();
            System.out.println("Radix sort for: " + Arrays.toString(arr6));
            arr6 = sortUsingRadixSort(arr6);
            System.out.print("Result: ");
            System.out.println(Arrays.toString(arr6));
            System.out.println();
            isSorted = true;
        }

        if (!isSorted) throw new Error("Unknown sorting algorithm: " + sortType);
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

        for (int i = 0; i < leftSize; ++i) left[i] = arr[start + i];
        for (int j = 0; j < rightSize; ++j) right[j] = arr[div + 1 + j];

        int i = 0, j = 0, k = start;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while (i < leftSize) arr[k++] = left[i++];
        while (j < rightSize) arr[k++] = right[j++];

        System.out.println(Arrays.toString(arr));
    }

    private void swapIntegerArrayValues(int[] arr, int ind1, int ind2) {
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
            if (arr[left] < arr[pivot]) swapIntegerArrayValues(arr, left, right);
            ++right;
        }
        if (right < pivot) swapIntegerArrayValues(arr, pivot, right);
        System.out.println(Arrays.toString(arr));

        sortUsingQuickSort(arr, start, right - 1);
        sortUsingQuickSort(arr, right + 1, pivot);
    }

    private void sortUsingInsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; --j) {
                if (arr[j] < arr[j - 1]) swapIntegerArrayValues(arr, j - 1, j);
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
                    swapIntegerArrayValues(arr, j, j + 1);
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
            if (minIndex > j) swapIntegerArrayValues(arr, minIndex, j);
            System.out.println(Arrays.toString(arr));
        }
    }

    @And("I mix given arrays as lists then as primitive arrays")
    public void iMixGivenArraysAsListsThenAsPrimitiveArrays(Map<String, List<Integer>> input) {
        List<Integer> list1 = input.get("array 1");
        list1.removeAll(Collections.singleton(null));
        List<Integer> list2 = input.get("array 2");
        list2.removeAll(Collections.singleton(null));

        System.out.println(Arrays.toString(getMixedArray(convertListToPrimitiveArray(list1), convertListToPrimitiveArray(list2))));

        System.out.println(getMixedList(list1, list2));
    }

    private List<Integer> getMixedList(List<Integer> list1, List<Integer> list2) {
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

    private int[] getMixedArray(int[] leftArr, int[] rightArr) {
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
        if (list.size() == 0) throw new Error("No elements in the array!");
        int[] arr = convertListToPrimitiveArray(list);
        System.out.println("Given array: " + Arrays.toString(arr));
        System.out.println("Max element: " + getMaxValueInArrayOfIntegers(arr));
    }

    private int getMaxValueInArrayOfIntegers(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    @And("I provide FizzBuzz output for number {int}")
    public void iProvideFizzBuzzOutputForNumber(int num) {
        printFizzBuzzOutputForN(num);
    }

    private void printFizzBuzzOutputForN(int num) {
        for (int i = 1; i <= num; ++i) {
            if (i % 15 == 0) System.out.print("FizzBuzz ");
            else if (i % 3 == 0) System.out.print("Fizz ");
            else if (i % 5 == 0) System.out.print("Buzz ");
            else System.out.print(i + " ");
        }
        System.out.println();
    }

    @And("I reverse a given string {string}")
    public void iReverseAGivenString(String str) {
        System.out.println("Original: " + str);
        System.out.println("Result (char swap): " + getReversedStringBySwappingChars(str));
        System.out.println("Result (StringBuilder reverse): " + getReversedStringWithStringBuilder(str));
    }

    private String getReversedStringBySwappingChars(String str) {
        char[] charArr = str.toCharArray();
        int len = str.length();
        for (int i = 0; i < len / 2; ++i) {
            char temp = charArr[i];
            charArr[i] = charArr[len - 1 - i];
            charArr[len - 1 - i] = temp;
        }
        return new String(charArr);
    }

    @And("I reverse word order in a given sentence {string}")
    public void iReverseWordOrderInAGivenSentence(String sentence) {
        if ((sentence == null) || (sentence.length() == 0)) throw new Error("Empty sentence - nothing to reverse!");
        System.out.println("Original: " + sentence);
        System.out.println();

        System.out.println("Result (RegEx cleanup & split): " + getReversedSentenceCleanedAndSplitWithRegEx(sentence));
        System.out.println();
        System.out.println("Result (2idx extraction & reverse): " + getReversedSentenceAsIsByReversingSubstringsWithTwoIdx(sentence));
    }

    private String getReversedSentenceAsIsByReversingSubstringsWithTwoIdx(String sentence) {
        int start = 0;
        int end = 0;
        int len = sentence.length();
        String result = "";

        while (start < len) {
            while ((end < len) && isValidChar(sentence.charAt(end))) ++end;
            result = result.concat(getReversedStringBySwappingChars(sentence.substring(start, end)));
            start = end;
            while ((end < len) && !isValidChar(sentence.charAt(end))) ++end;
            result = result.concat(sentence.substring(start, end));
            start = end;
        }
        return getReversedStringBySwappingChars(result);
    }

    private boolean isValidChar(char c) {
        return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'));
    }

    private String getReversedSentenceCleanedAndSplitWithRegEx(String sentence) {
        String[] wordArray = sentence
                .strip()
                .replaceAll("[^a-zA-Z0-9 ]", " ")
                .split("[ ]+");
        System.out.println("Split: " + Arrays.toString(wordArray));

        StringBuilder resultSentence = new StringBuilder();
        for (int i = wordArray.length - 2; i >= 0; --i) resultSentence.append(wordArray[i]).append(" ");
        resultSentence.append(wordArray[0]); //to avoid space at the end cut 1 loop iteration
        return resultSentence.toString();
    }

    @And("I print every {int} day of the week")
    public void iPrintEveryDayOfTheWeekForOneCycle(int num) {
        if ((num <= 0) || (num > 7)) throw new Error("Week day number expected (1-7). Got: " + num);
        printEveryNDayOfTheWeek(num);
    }

    private void printEveryNDayOfTheWeek(int num) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        for (int i = 1; i <= 7 / num; ++i) System.out.print(weekDays[num * i - 1] + " ");
        System.out.println();
    }

    @And("I find the longest palindrome in a given sentence {string}")
    public void iFindTheLongestPalindromeInAGivenSentence(String phrase) {
        if ((phrase == null) || (phrase.length() == 0)) throw new Error("Empty phrase - nothing to check!");

        System.out.println("Original: " + phrase);
        String str = phrase.replaceAll("[^a-zA-z0-9]", "").toLowerCase();
        System.out.println("Stripped: " + str);

        System.out.println("Longest palindrome found: " + getLongestPalindromeSubstring(str));
    }

    private String getLongestPalindromeSubstring(String str) {
        Map<String, Integer> maxPalindrome = new HashMap<>();
        maxPalindrome.put("length", 1);
        maxPalindrome.put("startIndex", 0);

        for (int i = 0; i < str.length() - 1; ++i) {
            updateMaxPalindromeFromGivenCenter(str, i, i, maxPalindrome);
            updateMaxPalindromeFromGivenCenter(str, i, i + 1, maxPalindrome);
        }
        int startIndex = maxPalindrome.get("startIndex");
        return str.substring(startIndex, startIndex + maxPalindrome.get("length"));
    }

    private void updateMaxPalindromeFromGivenCenter(String str, int start, int end, Map<String, Integer> curMax) {
        int pSize = getMaxPalindromeFromGivenCenter(str, start, end);
        if (pSize > curMax.get("length")) {
            curMax.put("length", pSize);
            curMax.put("startIndex", end - pSize / 2);
        }
    }

    private int getMaxPalindromeFromGivenCenter(String str, int start, int end) {
        int palindromeSize = (end > start) ? 0 : -1;
        while ((start >= 0) && (end < str.length()) && (str.charAt(start) == str.charAt(end))) {
            palindromeSize += 2;
            --start;
            ++end;
        }
        return palindromeSize;
    }

    @And("I find two largest elements in a given array")
    public void iFindTwoLargestElementsInAGivenArray(@Transpose List<Integer> list) {
        if (list.size() < 2) throw new Error("Provided array has less than 2 elements!");
        int[] arr = convertListToPrimitiveArray(list);

        System.out.println("Two largest elements with one loop: " + Arrays.toString(getTwoLargestElementsWithOneLoop(arr)));
        System.out.println("Two largest elements with two max element runs: " + Arrays.toString(getTwoLargestElementsWithTwoMaxRuns(arr)));
        System.out.println("Two largest elements after sorting: " + Arrays.toString(getTwoLargestElementsWithSort(arr)));
    }

    private int[] getTwoLargestElementsWithTwoMaxRuns(int[] arr) {
        int max1Ind = 0;
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > arr[max1Ind]) max1Ind = i;
        }

        int max2Ind = (max1Ind == 0) ? 1 : 0;
        for (int j = 1 - max2Ind; j < arr.length; ++j) {
            if (j == max1Ind) continue;
            if (arr[j] > arr[max2Ind]) max2Ind = j;
        }

        return new int[] {arr[max1Ind], arr[max2Ind]};
    }

    private int[] getTwoLargestElementsWithSort(int[] arr) {
        sortUsingInsertionSort(arr);
        return new int[] {arr[arr.length - 1] , arr[arr.length - 2]};
    }

    private int[] getTwoLargestElementsWithOneLoop(int[] arr) {
        int max1 = arr[0];
        int max2 = arr[1];

        if (max1 < max2) {
            max1 ^= max2;
            max2 ^= max1;
            max1 ^= max2;
        }

        for (int i = 2; i < arr.length; ++i) {
            int itr = arr[i];
            if (itr > max2) {
                if (itr < max1) {
                    max2 = itr;
                } else {
                    max2 = max1;
                    max1 = itr;
                }
            }
        }
        return new int[] {max1, max2};
    }

    @And("I check if given array has duplicates, print if found.")
    public void iCheckIfGivenArrayHasDuplicatesPrintIfFound(@Transpose List<Integer> list) {
        int[] arr = convertListToPrimitiveArray(list);
        boolean duplicates = hasDuplicates(arr);
        System.out.println("Do we have duplicates? " + duplicates);
        if (duplicates) printDuplicates(arr);
    }

    private boolean hasDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int el : arr) set.add(el);
        return !(set.size() == arr.length);
    }

    private void printDuplicates(int[] arr) {
        Map<Integer, Integer> dupes = new HashMap<>();
        for (int el : arr) {
            if (dupes.containsKey(el)) dupes.put(el, dupes.get(el) + 1);
            else dupes.put(el, 1);
        }
        for (int el : dupes.keySet()) {
            if (dupes.get(el) > 1) System.out.println("Count for " + el + ": " + dupes.get(el));
        }
    }

    @And("I reverse digits in a number {int}")
    public void iReverseDigitsInANumber(int num) {
        System.out.println("Original: " + num);
        System.out.println("Reversed by string: " + getReversedNumberUsingStrings(num));
        System.out.println("Reversed by math: " + getReversedNumberUsingMath(num));
    }

    private int getReversedNumberUsingMath(int num) {
        int sign = (num < 0) ? -1 : 1;
        num *= sign;
        int result = 0;
        for (int i = 1; num / i > 0; i *= 10) {
            result = result * 10 + (num / i) % 10;
        }
        return sign * result;
    }

    private int getReversedNumberUsingStrings(int num) {
        String negativeSign = "";
        if (num < 0) {
             negativeSign = "-";
             num = -num;
        }
        return Integer.parseInt(negativeSign + getReversedStringWithStringBuilder(String.valueOf(num)));
    }

    @And("I print the list of digits for {int}")
    public void iPrintTheListOfDigitsFor(int num) {
        System.out.println("Original: " + num);
        System.out.println("List of digits: " + Arrays.toString(getArrayOfDigitsForGivenNumber(num)));
    }

    private int[] getArrayOfDigitsForGivenNumber(int num) {
        int sign = (num < 0) ? -1 : 1;
        num *= sign;
        int amountOfDigits = 1;
        for (int i = 10; num / i > 0; i *= 10) ++amountOfDigits; //need this for array size/iteration
        int[] arr = new int[amountOfDigits];

        int digitOrder = 1;
        for (int j = amountOfDigits; j > 0; --j) {
            arr[j - 1] = (num / digitOrder) % 10;
            digitOrder *= 10;
        }
        arr[0] *= sign;
        return arr;
    }

    @And("I print indexes of two numbers in array that add up to {int}")
    public void iPrintIndexesOfTwoNumbersInArrayThatAddUpTo(int target, @Transpose List<Integer> list) {
        if (list.size() < 2) throw new Error("Provided array has less than 2 elements!");
        int[] arr = convertListToPrimitiveArray(list);
        System.out.println(Arrays.toString(getIndexesForTwoSum(arr, target)));
    }

    private int[] getIndexesForTwoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            int element = arr[i];
            if (map.containsKey(element)) return new int[] {map.get(element), i};
            else map.put(target - element, i);
        }
        throw new Error("No solution for this target: " + target);
    }

    @And("I print phrase {string} in a frame")
    public void iPrintPhraseInAFrame(String phrase) {
        String[] words = phrase.trim().split(" ");
        printWordsInAFrame(words);
    }

    private void printWordsInAFrame(String[] words) {
        int maxLen = 0;
        for (String el : words) {
            if (el.length() > maxLen) maxLen = el.length();
        }

        System.out.println("*".repeat(maxLen + 4));

        for (String word : words) {
            System.out.println("* " + word + " ".repeat(maxLen - word.length()) + " *");
        }

        System.out.println("*".repeat(maxLen + 4));
    }

    @And("I find a factorial of {int}")
    public void iFindAFactorialOf(int num) {
        if (num < 1) throw new Error("Not a natural number!");
        System.out.println("int:         " + getFactorialInt(num));
        System.out.println("long:        " + getFactorialLong(num));
        System.out.println("big integer: " + getFactorialBigInt(num));
    }

    private BigInteger getFactorialBigInt(int num) {
        BigInteger result = new BigInteger(String.valueOf(1));
        for (int i = 2; i <= num; ++i) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }
        return result;
    }

    private long getFactorialLong(int num) {
        long result = 1;
        for (int i = 2; i <= num; ++i) result *= i;
        return result;
    }

    private int getFactorialInt(int num) {
        int result = 1;
        for (int i = 2; i <= num; ++i) result *= i;
        return result;
    }

    @And("I find if {int} is a prime number")
    public void iFindIfIsAPrimeNumber(int num) {
        if (num < 2) throw new Error("Not a natural number > 1 !");
        System.out.println("Prime check for " + num + ": " + isPrimeNumber(num));
    }

    private boolean isPrimeNumber(int num) {
        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                System.out.println("Found divisor: " + i + " ");
                return false;
            }
        }
        return true;
    }

    @And("I print all prime numbers up to {int}")
    public void iPrintAllPrimeNumbersUpToNumber(int num) {
        if (num < 2) throw new Error("Not a natural number > 1 !");
        printPrimes(num);
    }

    /*
    n = 500000
    11.5s - n/2 naive
    n = 20000000
    21.5s - i*i checking divisibility
    7-7.5s - boolean sieve / BitSet / remove even numbers - same speed, less memory?
     */
    private void printPrimes(int num) {
        int sieveSize = (num + 1) / 2; //odd numbers only
        BitSet sieve = new BitSet(sieveSize);
        sieve.flip(0, sieveSize);

        for (int p = 3; p * p <= num; p += 2) {
            if (!sieve.get(p / 2)) continue;
            for (int k = p * p; k <= num; k += 2 * p) {
                sieve.set(k / 2, false);
            }
        }

        int totalPrimes = 1;
        System.out.print("2 "); //the only even prime number
        for (int i = 1; i < sieveSize; ++i) {
            if (sieve.get(i)) {
                ++totalPrimes;
                System.out.print((i * 2 + 1) + " ");
            }
        }
        System.out.println();
        System.out.println("Found " + totalPrimes + " primes!");
    }

    @And("I calculate square root for {double}")
    public void iCalculateSquareRootFor(double num) {
        if (num <= 0) throw new Error("Invalid number: " + num);
        System.out.println("Square root for " + num + " is: " + getSquareRoot(num));
    }

    private double getSquareRoot(double num) {
        double previous;
        double approximation = num / 2;
        int i = 0;
        do {
            previous = approximation;
            approximation = (previous + num / previous) / 2;
            ++i;
        } while ((previous - approximation) != 0);
        System.out.println("Found square root in " + i + " approximations");
        return approximation;
    }

    @And("I work with Animal classes")
    public void iWorkWithAnimalClasses() {
        Animal cat = new Cat("Tom");
        cat.walk();
        cat.birthday();
        cat.speak();
        cat.eat("mouse");
        cat.sleep();
        System.out.println();

        Animal anotherCat = new Cat();
        anotherCat.walk();
        anotherCat.birthday();
        anotherCat.speak();
        anotherCat.setName("Josephine");
        anotherCat.eat("fancy cat food");
        anotherCat.speak();
        anotherCat.sleep();
        anotherCat.birthday();
        String ageDifference = (cat.getAge() > anotherCat.getAge()) ? "older" : "younger";
        System.out.println(cat.getName() + " is " + ageDifference + " than " + anotherCat.getName());
        System.out.println();

        Animal dog = new Dog("Spike", 3);
        dog.walk();
        dog.speak();
        dog.birthday();
        dog.eat("meat");
        dog.sleep();
        System.out.println();

        Animal frog = new Frog();
        frog.setName("Lucy");
        frog.walk();
        frog.speak();
        frog.eat("fly");
        frog.birthday(new Animal[] {cat, anotherCat, dog, new Cat ("Nefertiti"), new Dog("Mike", 2), new Frog()});
        frog.sleep();
        System.out.println();
    }
}