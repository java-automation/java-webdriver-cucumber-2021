package definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import static org.assertj.core.api.Assertions.*;
import static io.cucumber.messages.internal.com.fasterxml.jackson.core.io.NumberInput.parseDouble;
import static java.lang.Integer.parseInt;
import static support.TestContext.getDriver;

public class UnitConvertersStepDefs {
    @And("I select {string} converter")
    public void iSelectConverter(String tab) {
        getDriver().findElement(By.xpath("//*[@id='menu']//a[contains(text(),'" + tab + "')]")).click();
    }

    @When("I convert value {string} from {string} to {string}")
    public void iConvertFromToWithValue(String value, String fromOption, String toOption) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);
        getDriver().findElement(By.xpath("//select[@id='calFrom']//option[contains(text(),'" + fromOption + "')]")).click();
        getDriver().findElement(By.xpath("//select[@id='calTo']//option[contains(text(),'" + toOption + "')]")).click();
    }

    @Then("I verify the result is {string}")
    public void iVerifyTheResultIs(String expectedValue) {
        double expected = parseDouble(expectedValue);
        String output  = getDriver().findElement(By.xpath("//*[@id='calResults']")).getText();
        int startIndex = output.indexOf("=") + 2;
        int endIndex = startIndex + 4;
        double actual = parseDouble(output.substring(startIndex, endIndex));
        assertThat(actual).isEqualTo(expected);
        System.out.println("Expected: " + expected + "\n Actual: " + actual);
    }
}
