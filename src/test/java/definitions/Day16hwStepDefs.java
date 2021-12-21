package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Day16hwStepDefs {

    @Given("I find two max numbers in the array")
    public void findTwoMaxArrayNumbers() {
        int[] unsorted = {3, 7, -3, -2, 9, 5, 8, 9};
        System.out.println("Before: " + Arrays.toString(unsorted));

        int[] sorted = getSorted(unsorted);
        System.out.println("After: " + Arrays.toString(sorted));

        System.out.println(String.format("First MaxElement: %d, Second MaxElement: %d", sorted[sorted.length - 1], sorted[sorted.length - 2]));
    }

    int[] getSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int temp = arr[i];
                if (arr[i] > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    @Given("I check if {string} is the palindrome")
    public void iCheckIfStringIsThePalindrome(String str) {
        System.out.println("Before: " + str);
        System.out.println("After: " + reverseString(str.toUpperCase()));
        System.out.println("Palindrome: " + checkPalindrome(str.toUpperCase(), reverseString(str.toUpperCase())));
    }

    static String reverseString(String name) {
        String revName = "";
        for (int i = name.length() - 1; i >= 0; i--) {
            revName += name.charAt(i);
        }
        return revName;
    }

    static boolean checkPalindrome(String str1, String str2) {
        return str1.equals(str2);
    }

    @Given("I check if an Arraycontains duplicates")
    public void checkDuplicates() {
        int[] arr = {2, 3, 5, 7, 8, 8};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("Array contains duplicates");
                    return;
                }
            }
        }
        System.out.println("No duplicates");
    }


    @Given("I write three lines code to find two max numbers in the array")
    public void iWriteThreeLinesCodeToFindTwoMaxNumbersInTheArray() {

        int[] ar1 = {3, 7, -3, -2, 9, 5, 8, 9};
        Arrays.sort(ar1);
        System.out.println(String.format("First Max: %d, Second Max: %d", ar1[ar1.length - 1], ar1[ar1.length - 2]));
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'calculateretailpostage')]")).click();
    }


    @And("I select Canada with Postcard shape")
    public void iSelectCanadaWithPostcardShape() {
        getDriver().findElement(By.xpath("//select[@id='CountryID']/option [@value='10054']")).click();
        getDriver().findElement(By.xpath("//input [@value='Postcard']")).click();
    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String arg0) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(arg0);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String price) {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='total']"));

        WebDriverWait waitSec = new WebDriverWait(getDriver(), 5);
        waitSec.until(webDriver -> resultContainer.getText().length() > 0);

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        assertThat(resultString).contains(price);

    }
}

