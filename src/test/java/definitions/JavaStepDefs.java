package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class JavaStepDefs {
    @Given("Hello Java")
    public void helloJava() {
        System.out.println("Hello Java Boot Camp");
    }

    @And("I say {string}")
    public void iSay(String str) {
        System.out.println(str);
        String str1 = "Vic";
        String str2 = "RED";
        System.out.println("The name is: " + str1 + ". And the tag is: " + str2 + " \uD83D\uDE0E ");
    }

    @And("Top Secret {string} and {string} and {string}")
    public void topSecretAndAnd(String firstName, String lastName, String favoriteColor) {
        System.out.println("Hi, my name is " + firstName + " " + lastName + ", " + "my favorite color is " + favoriteColor);
    }

    @Given("String exercise {string}")
    public void stringExercise(String arg0) {
        String str = "Hello Java Boot Camp";
        String str1 = "  Hello Java Boot Camp  ";
        System.out.println("str.length(): " + str.length());
        System.out.println("str.toLowerCase: " + str.toLowerCase());
        System.out.println("str.getClass(): " + str.getClass());
        System.out.println("str.toUpperCase(): " + str.toUpperCase());
        System.out.println("str1.trim(): " + str1.trim() + " //trim works");
        System.out.println("str.isEmpty(): " + str.isEmpty());
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithAnd(String arg0, String arg1) {
        System.out.println(arg0 + "; " + arg1);
        System.out.println(arg0.toUpperCase() + "; " + arg1.toUpperCase());
        System.out.println(arg0.length() + "; " + arg1.length());
        System.out.println("links are equal: " + (arg0 == arg1));
        System.out.println("Strings are equal: " + arg0.equals(arg1));
        System.out.println("compareToIgnoreCase(): " + arg0.compareToIgnoreCase(arg1));
        System.out.println("compareToIgnoreCase(): " + arg0.equalsIgnoreCase(arg1));
        System.out.println("partial comparison: " + arg0.contains("my"));
    }

    @Given("I perform actions with digits {string} and {string}")
    public void iPerformActionsWithDigitsAnd(String arg0, String arg1) {
        int n1 = Integer.parseInt(arg0);
        int n2 = Integer.parseInt(arg1);
        int sum = n1 + n2;
        int difference = n1 - n2;
        int quotient = n1 / n2;
        int product = n1 * n2;
        System.out.println("sum: " + sum);
        System.out.println("difference: " + difference);
        System.out.println("quotient: " + quotient);
        System.out.println("product: " + product);
    }

    @Given("I check if these colors are equal {string} and {string}")
    public void iCheckIfTheseColorsAreEqualAnd(String arg0, String arg1) {
        String color1 = arg0;
        String color2 = arg1;

        System.out.println("Boolean//links are equal: " + (color1 == color2));
        System.out.println("Text//Colors are equal: " + color1.equals(color2));
    }

    @Given("I compare {string} and {string} strings")
    public void iCompareAndStrings(String arg0, String arg1) {
        if (arg0 == arg1) {
            System.out.println("Links//I compare " + "'" + arg0 + "'" + " and " + "'" + arg1 + "'" + ", strings => equal!");
        }
        else
            System.out.println("Links//I compare " + "'" + arg0 + "'" + " and " + "'" + arg1 + "'" + ", strings => not equal!");

        System.out.println((arg0.equals(arg1)) ? "Text equal" : "Text not equal");
    }

    @Given("I print url for {string} page")
    public void iPrintUrlForPage(String arg0) {
        String[] urlBase = {"https://www.google.com", "https://skryabin.com/webdriver/html/sample.html"};
        if (arg0.equals("Google")) {
            System.out.println(urlBase[0]);
        }
        else if (arg0.equals("sample")) {
            System.out.println(urlBase[1]);
        }
        else System.out.println("Unknown url");
    }
}
