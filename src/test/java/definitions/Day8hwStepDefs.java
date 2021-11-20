package definitions;

import io.cucumber.java.en.Given;

import java.util.Arrays;

public class Day8hwStepDefs {

    @Given("I create an array, and sort odd numbers")
    public void iCreateAnArrayAndSortOddNumbers() {
        //int[] arr = {5, 3, 2, 8, 4, 1};
        //int[] arr = {10, 5, 0, 7, 3, 2, 8, 4, 1};
        int[] arr = {12, 10, 5, 0, 7, 3, 2, -1, 8, 4, 1};
        System.out.println(Arrays.toString(arr));

        for (int j = 0; j < arr.length - 1; j++) {
            int idxMin = j;
            int min = arr[idxMin];

            for (int i = j + 1; i < arr.length; i++) {
                if (arr[i] % 2 != 0 && (arr[i] < min)) {
                    idxMin = i;
                    min = arr[i];
                }
            }
            if (arr[j] % 2 != 0 && arr[idxMin] % 2 != 0) {
                int temp = arr[j];
                arr[j] = min;
                arr[idxMin] = temp;
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    @Given("I create an array, and sort odd numbers in anthr way")
    public void iCreateAnArrayAndSortOddNumbersInAnthrWay() {
        //int[] arr = {5, 3, 2, 8, 4, 1};
        //int[] arr = {10, 5, 0, 7, 3, 2, 8, 4, 1};
        int[] arr = {12, 10, 5, 0, 7, 3, 2, -1, 8, 4, 1};
        System.out.println("Before: " + Arrays.toString(arr));

        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] % 2 != 0) {
                int min = arr[j];

                for (int i = j + 1; i < arr.length; i++) {
                    if (arr[i] % 2 != 0 && (arr[i] < min)) {
                        min = arr[i];

                        int temp = arr[j];
                        arr[j] = min;
                        arr[i] = temp;
                    }
                }
            }
        }
        System.out.println("After: " + Arrays.toString(arr));
    }
}
