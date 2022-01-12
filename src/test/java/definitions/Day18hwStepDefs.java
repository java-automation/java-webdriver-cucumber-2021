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
}
