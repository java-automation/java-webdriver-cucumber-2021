package definitions;

import io.cucumber.java.en.Given;

import java.util.HashMap;
import java.util.Map;

public class Day17hwStepDefs {
    @Given("return two indices of int array such that they add up to target {int}")
//Given an array of integers and an integer target, return indices of the two numbers such that they add up to target.
//Do not use the same element twice.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//arr = [2,7,11,6,15], target = 9
//expected: [0,1]
//arr[0] + arr[1] == 9

    public void returnTwoIndeces(int target) {

        //int[] arr = {2, 7, 11, 6, 15};
        int[] arr = {-2, 0, -12, -7, 181, 6, 15, 18, -2, 9};
        solveIt(arr, target);
    }

    static void solveIt(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                System.out.println(map.get(arr[i]) + ", " + i);
                return;
            }
            map.put(target - arr[i], i); // for pos=0 i need to find 9-2=7, (key=7, value=0)
        }
        System.out.println("No solution found");
    }
}

