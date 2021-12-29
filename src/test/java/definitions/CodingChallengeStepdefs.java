package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CodingChallengeStepdefs {
    @Given("Write a function that prints two max numbers in an array")
    public void writeAFunctionThatPrintsTwoMaxNumbersInAnArray() {

        int num[] = {13, 99, 78, 2, 45, 1, 55, 101};
        printTwoMaxNumbers(num);


    }

    public void printTwoMaxNumbers(int[] nums) {
        int maxOne = 0;
        int maxTwo = 0;
        for (int n : nums) {
            if (maxOne < n) {
                maxTwo = maxOne;
                maxOne = n;
            } else if (maxTwo < n) {
                maxTwo = n;
            }
        }
        System.out.println("First Max Number: " + maxOne);
        System.out.println("Second Max Number: " + maxTwo);
    }


    @And("Find factorial of a number")
    public void findFactorialOfANumber() {
// (5! = 5 * 4 * 3 * 2 * 1)

        int number = 5;
        int fact = 1;

        for (int i = 1;  i <= number; i++ ){
            fact = fact*i;
        }
        System.out.println("Factorial of " + number + " is " + fact);

    }

    @Then("Find if a number is a prime number")
    public  void findIfANumberIsAPrimeNumber() {

        //A prime number is a number that is divisible by only two numbers: 1 and itself. So, if any number is divisible by any other number, it is not a prime number.
         int num = 31;
         boolean flag = false;

         for(int i = 2; i <= num / 2; i++){
             //condition for nonprime number

             if(num % i == 0){
                 flag = true;
                 break;
             }
         }
         if (!flag) {

             System.out.println(num + " is prime number. ");
         }
             else {
             System.out.println(num + " is not a prime number. ");
         }

         }

    }










//    @Then("Write a function that finds if any two elements of an array result in sum")
//    public boolean writeAFunctionThatFindsIfAnyTwoElementsOfAnArrayResultInSum() {
//
//        int arr[] = {2, 11, 5, 1, 4, 7};
//        int n = arr.length;
//        if (checkPair(arr, n) == false)
//        {
//            System.out.printf("No pair found");
//        }
//
//
//        static boolean checkPair(int arr1[], int n)
//        {
//            // Find sum of whole array
//            int sum = 0;
//            for (int i = 0; i < n; i++)
//            {
//                sum += arr[i];
//            }
//
//            // If sum of array is not even than we can not
//            // divide it into two part
//            if (sum % 2 != 0)
//            {
//                return false;
//            }
//            sum = sum / 2;
//
//            // For each element arr[i], see if there is
//            // another element with value sum - arr[i]
//            HashSet<Integer> s = new HashSet<Integer>();
//            for (int i = 0; i < n; i++)
//            {
//                int val = sum - arr[i];
//
//                // If element exist than return the pair
//                if (s.contains(val) &&
//                        val == (int) s.toArray()[s.size() - 1])
//                {
//                    System.out.printf("Pair elements are %d and %d\n",
//                            arr[i], val);
//                    return true;
//                }
//                s.add(arr[i]);
//            }
//            return false;
//        }
//
//
//    }
//}
