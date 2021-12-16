package definitions;

import io.cucumber.java.en.Given;

import java.util.HashMap;
import java.util.Map;

public class Day15hwStepDefs {
    @Given("I chek an array for the indexes")
    public void chekIndexes() {
        int[] nums = {-2, 11, 7, 6, 15, 7};
        //int[] arr = new int[]{};
        int target = 9;
        solveIt(nums, target);
    }

    private void solveIt(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                System.out.println(map.get(arr[i]) + ", " + i);
                return;
            }
            map.put(target - arr[i], i);
        }
        System.out.println("No solution found");
    }
}
