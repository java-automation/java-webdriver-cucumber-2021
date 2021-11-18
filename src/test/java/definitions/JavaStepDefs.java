package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class JavaStepDefs {
    @Given("I write a function that prints all numbers from {int} up to {int}")
    public void iWriteAFunctionThatPrintsAllNumbersFromUpTo(int num1, int num2) {
        for (int i = num1; i <= num2; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    @When("I write a function that supports also negative numbers from {int} to {int}")
    public void iWriteAFunctionThatSupportsAlsoNegativeNumbersFromTo(int first, int last) {
        for (int j = first; j <= last; j++) {
            System.out.print(j + " ");
        }
    }

    @Then("I write a function that prints all integer array")
    public void iWriteAFunctionThatPrintsAllIntegerArray() {
        int[] nums = {12, 5, 7, 1, 0, 5};
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    @And("I write a function that prints all even numbers from integer array")
    public void iWriteAFunctionThatPrintsAllEvenNumbersFromIntegerArray() {
        int[] arr = {6, 5, 8, 12, 1, 2, 18};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
    }

    @And("I write a function that checks if array is empty")
    public void iWriteAFunctionThatChecksIfArrayIsEmpty() {
        int[] emptyarr = {3, 5, 1, 6, 10};
        if (emptyarr.length == 0) {
            System.out.print("Array is emply");
        } else {
            System.out.print("Array is not empty: ");
            for (int i = 0; i < emptyarr.length; i++) {
                System.out.print(emptyarr[i] + " ");
            }
        }
    }

    @And("Write a function that checks if array contains another element")
    public void writeAFunctionThatChecksIfArrayContainsAnotherElement() {
        List<Integer> elemcheck = new ArrayList<>();
        elemcheck.add(5);
        elemcheck.add(22);
        elemcheck.add(4);
        elemcheck.add(185);
        elemcheck.add(3);
        elemcheck.add(-9);
        elemcheck.add(1);
        elemcheck.add(1);
        elemcheck.add(3);
        System.out.print(elemcheck.contains(-9));
    }

    @Given("We have have hashmap myinfo")
    public void weHaveHaveHashmapMyinfo() {
        HashMap<String,String> myInfo = new HashMap<String, String>();
        myInfo.put("firstname","Ivan");
        myInfo.put("lastName","Romanov");
        myInfo.put("hometown","Chicago");
        myInfo.put("favoriteFood","Steak");
        System.out.println(myInfo);
        myInfo.get("firstname");
        System.out.println(myInfo.get("firstname"));
        myInfo.replace("hometown","Kirov");
        System.out.println(myInfo);
    }
}


