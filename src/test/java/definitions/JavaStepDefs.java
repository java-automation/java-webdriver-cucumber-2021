package definitions;

import io.cucumber.java.Transpose;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.sql.SQLOutput;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class JavaStepDefs {

    @Given("I hello World")
    public void iHelloWorld() {
        String message = "Hello World!";
        String text = "I'm an engineer";
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
        System.out.println(str1 + ", " + str2);
        System.out.println(str1.toUpperCase() + " " + str2.toUpperCase());
        System.out.println(str1.length() + " " + str2.length());
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));
        System.out.println(str1.contains(str2));
    }

    @Given("I print {string} and {string} into console")
    public void iPrintIntoConsole(String str1, String str2) {
        System.out.println(str1 + ", " + str2);
    }

    @Given("I print {string} and {string} uppercase into console")
    public void iPrintUppercaseIntoConsole(String str1, String str2) {
        System.out.println(str1.toUpperCase() + ", " + str2.toUpperCase());
    }

    @Given("I compare {string} and {string}")
    public void iCompare(String str1, String str2) {
        if (str1.equals(str2)) {
            System.out.println(str1 + " and " + str2 + " are equal");
        } else {
            System.out.println(str1 + " and " + str2 + " are not equal");
        }
    }

    @Given("I compare {string} and {string} ignoring case")
    public void iCompareIgnoringCase(String str1, String str2) {
        if (str1.equalsIgnoreCase(str2)) {
            System.out.println(str1 + " and " + str2 + " are equal ignoring case");
        } else {
            System.out.println(str1 + " and " + str2 + " are not equal");
        }
    }

    @Given("I print {string} length and {string} length into console")
    public void iPrintLengthIntoConsole(String str1, String str2) {
        System.out.println("The length of '" + str1 + "' is: " + str1.length() + ", and the length of '" + str2 + "' is: " + str2.length());
    }

    @Given("I check if {string} contains {string}")
    public void iCheckIfContains(String str1, String str2) {
        if (str1.contains(str2)) {
            System.out.println(str1 + " contains " + str2);
        } else {
            System.out.println(str1 + " doesn't contain " + str2);
        }
    }

    @Given("I divide integer {int} by integer {int}")
    public void iDivideIntegerByInteger(int int1, int int2) {
        int result = int1 / int2;
        System.out.println(int1 + " divided by " + int2 + " equals " + result);
    }

    @Given("I divide integer {int} by float {float}")
    public void iDivideIntegerByFloat(int int1, float f1) {
        float result = (float) (int1 / f1);
        System.out.println(int1 + " divided by " + f1 + " equals " + result);
    }

    @Given("I compute the sum of integer {int} and integer {int}")
    public void iComputeTheSumOfIntegerAndInteger(int num1, int num2) {
        int sum = num1 + num2;
        System.out.println(num1 + " plus " + num2 + " equals " + sum);
    }

    @Given("I compute the difference of integer {int} and integer {int}")
    public void iComputeTheDifferenceOfIntegerAndInteger(int num1, int num2) {
        int difference = num1 - num2;
        System.out.println(num1 + " minus " + num2 + " equals " + difference);
    }

    @Given("I compute the quotient of integer {int} and integer {int}")
    public void iComputeTheQuotientOfIntegerAndInteger(int num1, int num2) {
        int quotient = num1 / num2;
        System.out.println("The quotient of " + num1 + " and " + num2 + " is: " + quotient);
    }

    @Given("I compute the product of integer {int} and integer {int}")
    public void iComputeTheProductOfIntegerAndInteger(int num1, int num2) {
        int product = num1 * num2;
        System.out.println("The product of " + num1 + " and " + num2 + " is: " + product);
    }

    @Given("I compare my color {string} with notFavoriteColor")
    public void iCompareMyColorWithNotFavoriteColor(String color) {
        String notFavoriteColor = "brown";
        boolean b = color.equalsIgnoreCase(notFavoriteColor);
        if (b) {
            System.out.println("Sorry, your color: " + color + " is the same as my not favorite color");
        } else {
            System.out.println("Congratulations, your color: " + color + " is different from my not favorite color: " + notFavoriteColor);
        }
    }

    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int num) {
        if (num > 0) {
            System.out.println("Number:" + num + " is positive");
        } else {
            System.out.println("Number:" + num + " is negative");
        }
    }

    @And("I print {int} day of week")
    public void iPrintDayOfWeek(int dayOfWeek) {
        dayOfWeek--;
        String[] days = new String[]{"Monday",
                "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        System.out.println(days[dayOfWeek]);
    }

    @And("I print all numbers from zero to {int}")
    public void iPrintAllNumbersFromZeroTo(int num) {

        if (num > 0) {
            System.out.println("Positive numbers:");
            for (int i = 0; i <= num; i++) {
                System.out.println(i);
            }
        } else {
            System.out.println("Negative numbers:");
            for (int i = 0; i >= num; i--) {
                System.out.println(i);
            }
        }
    }

    @And("I print all numbers from {int} to {int}")
    public void iPrintAllNumbersFromTo(int num1, int num2) {
        int i = num1;
        while (i <= num2) {
            System.out.print(i + " ");
            i++;
        }
    }

    @And("I print all integer array")
    public void iPrintAllIntegerArray(List<Integer> intArray) {
        for (Integer i : intArray) {
            System.out.print(i + " ");
        }
    }

    @And("I print all even numbers from integer array")
    public void iPrintAllEvenNumbersFromIntegerArray(List<Integer> intArray) {
        for (Integer i : intArray) {
            if (i % 2 == 0) System.out.print(i + " ");
        }
    }

    @And("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        if (array.length == 0) {
            System.out.println("Array is empty");
        }
        else {
            System.out.println("Array is not empty");
        }
    }

    @And("I check if array contains {int}")
    public void iCheckIfArrayContains(int num) {
        boolean contains = false;
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i<array.length; i++){
            if (array[i] == num){
                contains = true;
                break;
            }
        }
        if (contains) {
            System.out.println("Array contains: " + num);
        } else {
            System.out.println("Array doesn't contain: " + num);
        }
    }
}

