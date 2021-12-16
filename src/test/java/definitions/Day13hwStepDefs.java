package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Day13hwStepDefs {
    @When("I go to Lookup ZIP page by address")
    public void goToLookupZIPPageByAddress() throws InterruptedException {
        //getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();

        WebElement sendMenu = getDriver().findElement(By.xpath("//a[@id='mail-ship-width']"));
        new Actions(getDriver()).moveToElement(sendMenu).perform();
        getDriver().findElement(By.xpath("//li[@class='tool-zip']/a[contains(@href,'zip')]")).click();
        getDriver().findElement(By.xpath("//a[contains(@href,'byaddress')][contains(@class,'zip-code-home')][contains(@class,'primary')]")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        WebElement selectElement = getDriver().findElement(By.xpath("//select[@id='tState']"));
        new Select(selectElement).selectByValue(state);
//        getDriver().findElement(By.xpath("//select[@id='tState']/option[@value='" + state + "']")).click();
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }


    @Then("I validate {string} zip code exists in the result")
    public void validateZipInTheResult(String zip) {
        WebElement resultContainer = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));

        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
//        wait.until(ExpectedConditions.visibilityOf(resultContainer));
//        wait.until(ExpectedConditions.textToBePresentInElement(resultContainer, zip));
        wait.until(driver -> resultContainer.getText().length() > 0);

        String resultString = resultContainer.getText();
        System.out.println(resultString);

        assertThat(resultString).contains(zip);
    }

    @Given("I sort List<Integer>")
    public void sortListInteger() {
        List<Integer> intArray = Arrays.asList(5, 8, 1, 4, 5, 7);
        System.out.println(intArray);
        //intArray.sort((i1, i2) -> i2 - i1);
        intArray.sort((i1, i2) -> i1 - i2);
        //intArray.sort(Comparator.comparingInt(i->i));
        System.out.println(intArray);

    }

    @Given("I sort List<String>")
    public void sortListString() {
        List<String> strArray = Arrays.asList("ab", "a", "abc", "ac", "vvz");
        strArray.sort(Comparator.comparingInt(String::length));
        System.out.println(strArray);
    }
}














