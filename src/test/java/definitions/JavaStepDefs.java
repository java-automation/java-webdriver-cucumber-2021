package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Locale;

public class JavaStepDefs {

    @Given("I hello world")
    public void iHelloWorld() {
        String message = "Hello World!";
        String text = "I'm an engineer!";
        System.out.println(message + " " + text);

        String firstName = "john";
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.getClass());
        System.out.println(firstName.length());
        System.out.println(firstName.equals("John"));
        System.out.println(firstName.contains("jo"));
    }

    @And("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String str1, String str2) {
        System.out.println("first variable - " + str1 + " and second variable - " + str2);
        System.out.println("variables to upper case - " + str1.toUpperCase() + " and " + str2.toUpperCase());
        System.out.println("variables length - " + str1.length() + " and " + str2.length());
        System.out.println("variables exact comparison - " + str1.equals(str2));
        System.out.println("variables exact comparison ignoring cases - " + str1.equalsIgnoreCase(str2));
        System.out.println("variables partial comparison ignoring cases - " + str1.contains(str2));
    }

    @When("I divide two integer variables {int} by {int}")
    public void iDivideTwoIntegerVariablesBy(int arg0, int arg1) {
        System.out.println(arg0 / arg1);
    }

    @And("I divide integer by float: {int} by {float}")
    public void iDivideIntegerByFloatBy(int arg0, float arg1) {
        System.out.println(arg0 / arg1);
    }

    @And("I perform different arithmetic action with two integer variable {int} and {int}")
    public void iPerformDifferentArithmeticActionWithTwoIntegerVariableAnd(int arg0, int arg1) {
        System.out.println("Sum: " + (arg0 + arg1));
        System.out.println("Difference: " + (arg0 - arg1));
        System.out.println("Quotient: " + (arg0 / arg1));
        System.out.println("Product: " + (arg0 * arg1));
    }

    @And("I check integer number {int}")
    public void iCheckIntegerNumber(int arg0) {
        if (arg0 == 0){
            System.out.println("Given number is 0 - not negative and not positive");
        }
        else if (arg0 < 0) {
            System.out.println("Given number is negative");
        }
        else {
            System.out.println("Given number is positive");
        }
    }

    @And("I compare {string} and {string} strings")
    public void iCompareAndStrings(String arg0, String arg1) {
        if (arg0.equals(arg1)){
            System.out.println("equal!");
        }
        else {
            System.out.println("not equal!");
        }
    }

    @And("I print url for {string} page")
    public void iPrintUrlForPage(String arg0) {
        if (arg0.equals("sample")) {
            System.out.println("https://skryabin.com/webdriver/html/" + arg0 + ".html");
        }
        else {
            System.out.println("https://www." + arg0 + ".com");
        }
    }
}
