package definitions;

import io.cucumber.java.en.Given;

import java.util.Arrays;

public class Day9hwStepDefs {
    @Given("I create two arrays and combine them accordingly")
    public void iCreateTwoArraysAndCombineThemAccordingly() {
        int[] ar1 = {0, 5, 8, 9, 1};
        //int[] ar2 = {1, 2, 3};
        //int[] ar2 = {1, 2, 3, -70, 89};
        int[] ar2 = {1, 2, 3, -70, 89, 91, 98};

        int resultLen = ar1.length + ar2.length;
        int[] ar3 = new int[resultLen];

        int minLen = (Math.min(ar1.length, ar2.length));
        for (int i = 0; i < minLen * 2; i++) {
            if (i % 2 == 0) {
                ar3[i] = ar1[i / 2];
            } else
                ar3[i] = ar2[i / 2];
        }
        int indNext = minLen * 2;

        if (ar1.length > ar2.length) {
            int k = ar1.length - 1;
            for (int j = ar3.length - 1; j >= indNext; j--, k--) {
                ar3[j] = ar1[k];
            }
        } else {
            int k = ar2.length - 1;
            for (int j = ar3.length - 1; j >= indNext; j--, k--) {
                ar3[j] = ar2[k];
            }
        }
        System.out.println(Arrays.toString(ar3));
    }
}


//  int[] ar1 = {0, 5, 8, 9, 1};
//  int[] ar2 = {1, 2, 3};
//  result: [0, 1, 5, 2, 8, 3, 9, 1]

//   int[] ar2 = {1, 2, 3, -70, 89};
//   result: [0, 1, 5, 2, 8, 3, 9, -70, 1, 89]

//   int[] ar2 = {1, 2, 3, -70, 89, 91, 98};
//   result: [0, 1, 5, 2, 8, 3, 9, -70, 1, 89, 91, 98]