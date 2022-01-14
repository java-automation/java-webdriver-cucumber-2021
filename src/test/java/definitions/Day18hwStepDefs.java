package definitions;

import io.cucumber.java.en.Given;

public class Day18hwStepDefs {
    @Given("I return Fibonacci number # {int}")
    //Fibonacci numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21...

    public void getFibonacciNumber(int seqNumber) {

        System.out.println(fib(seqNumber));
    }

    private int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    @Given("I return n! of {int}")
    public void getFactorial(int n) {
        System.out.println(factResult(n));
    }

    private int factResult(int n) {
        if (n < 0) {
            System.out.println("n!, is the product of all positive integers");
            return Integer.parseInt(null);
        }
        int result = 1;
        if (n == 0) {
            return result;
        }
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    @Given("I use recursive function to get n! of {int}")
    public void recursiveGetFactorial(int n) {
        System.out.println(factorial(n));
    }

    private int factorial(int n) {
        if (n < 0) {
            System.out.println("n!, is the product of all positive integers");
            return n;
        }

        int result = 1;

        if (n == 1 || n == 0) {
            return result;
        }

        result = n * factorial(n - 1); // 3 * factorial(2)  —▶︎  3 * 2 * factorial(1) —▶ 3 * 2 * 1
        return result;
    }

    @Given("I use recursive function to get all numbers from {int} to 1 in reversed order")
    //print all numbers from given int n down to 1 in reversed order

    public void getCompositeNumbers(int n) {
        solveIt(n);
    }

    public static void solveIt(int n) {
        if (n == 0) {             // exit/terminate infinitive loop
            return;
        }
        System.out.println(n); // 5 for  ➤  int n = 5;
        solveIt(n - 1);

//Common approach
  /*public static void solveIt(int n) {
        for (int i = n; i > 0; i--) {
            System.out.println(i);
        }
    }*/
    }

    @Given("I use recursive function to get the sum of all numbers from {int} to 1")
    // given int n ➤ 1 + 2+ ... + (n-1) + n
    // if n = 3 ➤ 1+2+3=6

    public void getTheSum(int n) {
        System.out.println(solveIt2(n));
        // solveIt2(n);
    }

    private int solveIt2(int n) {
        if (n == 0) {     // exit/terminate infinitive loop
            return 0;
        }
        return n + solveIt2(n - 1);

//Common approach
 /* public static void solveIt2(int n) {
        int res2 = 0;
        for (int i = 0; i <= n; i++) {
            res2 += i;
        }
        System.out.println(res2);
    }*/
    }


    @Given("I use recursive function to checks {string} if its a polindrome")
    //check string if its a polindrome

    public void checkIfPolindrome(String str) {
        boolean res3 = solveIt3(str);
        System.out.println(res3);
    }

    public static boolean solveIt3(String str) {
        if (str.length() <= 1) {
            return true;          // everything is OK
        }

        if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return solveIt3(str.substring(1, str.length() - 1)); // substring ➤ "aya" for KayaK
        }
        return false;

//Common approach
  /*public static boolean solveIt(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }*/
    }
}

