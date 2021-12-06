package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.sql.SQLOutput;
import java.util.Arrays;

public class CodingDefs {
    @Given("I solve Java task")
    public void iSolveJavaTask() {

    }

    @And("I print the sum of numbers from 1 to {int}")
    public void iPrintTheNumbersFromTo(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    @And("I take a number {int} and give the possibility to choose between computing the sum and computing the program of those numbers")
    public void iTakeANumberAndGiveThePossibilityToChooseBetweenComputingTheSumAndComputingTheProgramOfThoseNumbers(int n) {
        String  option = "sum";
        if (option.equals("sum")) {

            int sum = 0;

            for (int i = 1; i <= n; i++)
                sum+=i;
            System.out.println("Sum = " + sum);
        } else if (option.equals("product")){
            int product = 1;
            for (int i = 1; i <= n; i++)
                product *= i;
            System.out.println("Product = " + product);
        } else
            System.out.println("Incorrect option: " + option);
    }

}
