package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;
import java.text.ParseException;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class UnitConverterStepDefs {
    @When("I choose to measure {string}")
    public void iChooseToMeasure(String category) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[contains(@href,'" + category + "')]")).click();
    }

    @And("I choose to convert from {string} to {string}")
    public void iChooseToConvertFromTo(String convertFrom, String convertTo) {
        new Select(getDriver().findElement(By.xpath("//select[@id='calFrom']"))).selectByVisibleText(convertFrom);
        new Select(getDriver().findElement(By.xpath("//select[@id='calTo']"))).selectByVisibleText(convertTo);
    }

    @Then("I verify that {double} is converted to {double}")
    public void iVerifyThatIsConvertedTo(double fromValue, double toValue) {
        DecimalFormat df = new DecimalFormat("0.0");
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(df.format(fromValue));
        String calculatedToValue = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
        assertThat(df.format(Double.parseDouble(calculatedToValue))).isEqualTo(df.format(toValue));
    }
}
