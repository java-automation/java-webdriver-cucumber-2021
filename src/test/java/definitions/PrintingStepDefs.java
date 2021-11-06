package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.support.Color;
import java.util.regex.Pattern;

public class PrintingStepDefs {

    private String str1="";
    private String str2="";
    private Boolean color_requested = false;
    private Color color = new Color(0,0,0,1);
    private Boolean header_requested = true;
    private String header_unit = "-";
    private int header_length = 20;

    private void printResult(String outputStr) {
        applyPrintingOptions();
        System.out.println(outputStr);
        clearPrintingOptions();
    }

    private void applyPrintingOptions() {
        if (color_requested) setConsoleOutputColor();
        if (header_requested) printHeader();
    }

    private void clearPrintingOptions() {
        if (color_requested) {
            unsetConsoleOutputColor();
            color_requested = false;
        }
    }

    private void printHeader() {
        System.out.println(StringUtils.repeat(header_unit, header_length));
    }

    private void setConsoleOutputColor() {
        // https://stackoverflow.com/questions/4842424/list-of-ansi-color-escape-sequences
        // Using Select Graphic Rendition subset of the ANSI escape sequences. All of these have the form \033[XXXm
        System.out.print("\033[0m"); // Code: 0, Font Effect: Reset/Normal, Note: all attributes off
        System.out.print("\033[38;2;" + color.getColor().getRed() +";" +
                                                  color.getColor().getGreen() + ";" + color.getColor().getBlue() + "m");
    }

    private void unsetConsoleOutputColor() {
        System.out.print("\033[0m");
    }

    private Boolean performActions(String s1, String s2) {
        str1 = s1;
        str2 = s2;
        return true;
    }

    @Given("I perform actions with {string} and {string}")
    public void iPerformActionsWithTwoStringInputs(String s1, String s2) {
        Boolean status = performActions(s1, s2);
        System.out.println("Actions performed successfully: " + status); }

    @When("I pick color {string} for printing")
    public void iPickColorForPrinting(String hexStr) {
        int red, green, blue;
        if (!Pattern.compile("[0-9A-Fa-f]{6}").matcher(hexStr).find()) {
            throw new IllegalArgumentException("\"" + hexStr + "\" does not represent color in hex format.");
        }
        try {
            red = Integer.parseInt(hexStr.substring(0,2), 16);
            green = Integer.parseInt(hexStr.substring(2,4), 16);
            blue = Integer.parseInt(hexStr.substring(4,6), 16);
        } catch (NumberFormatException e) {
            red = 0;
            green = 0;
            blue = 0;
        }
        color_requested = true;
        color = new Color(red,green,blue,1);
    }

    @Then("print those variables to console as they are")
    public void printVariablesToConsoleAsTheyAre() {
        printResult(str1 + " " + str2);
    }

    @Then("print those variables uppercase into console")
    public void printVariablesUppercaseIntoConsole() {
        printResult(str1.toUpperCase() + " " + str2.toUpperCase());
    }

    @Then("print those variables length into console")
    public void printVariablesLengthIntoConsole() {
        printResult("Length of \"" + str1 + "\" is " + str1.length() + "\n" +
                    "Length of \"" + str2 + "\" is " + str2.length());
    }

    @Then("print result of exact comparison of those variables into console")
    public void printExactComparisonOfVariablesIntoConsole() {
        printResult("Result of exact comparison of \"" + str1 + "\" and \"" + str2 + "\" is: " +
                    (str1.equals(str2)  ? "" : "NOT ") + "equivalent");
    }

    @Then("print result of exact comparison ignoring cases of vars into console")
    public void printResultOfExactComparisonIgnoringCasesOfVariablesIntoConsole() {
        printResult("Result of exact comparison ignoring case of \"" + str1 + "\" and \"" + str2 + "\" is: " +
                           (str1.equalsIgnoreCase(str2)  ? "" : "NOT ") + "EQUIVALENT ignoring case");
    }

    @Then("print result of lexicographical comparison of vars into console")
    public void printResultOfLexicographicalComparisonOfVarsIntoConsole() {
        String resStr;
        int res = str1.compareTo(str2);
        if (res == 0) {
            resStr = "\"" + str1 + "\" is lexicographically EQUAL to \"" + str2 + "\"";
        } else if (res < 0) {
            resStr = "\"" + str2 + "\" is lexicographically LESS than the \"" + str1 + "\"";
        } else {
            resStr = "\"" + str2 + "\" is lexicographically GREATER than the \"" + str1 + "\"";
        }
        printResult("Result of lexicographical comparison ignoring case: " + resStr);
    }

    @Then("print result of partial comparison of those variables into console")
    public void printResultOfPartialComparisonOfVarsIntoConsole() {
        String resStr;
        boolean res = str1.contains(str2);
        if (res) {
            resStr = "DOES contain \"" + str2 + "\" starting from letter number " + (str1.indexOf(str2)+1);
        } else {
            resStr = "DOES NOT contain " + str2;
        }
        printResult("Result of partial comparison: \"" + str1 + "\" " + resStr);
    }
}