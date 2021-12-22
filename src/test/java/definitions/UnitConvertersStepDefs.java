package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;

import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class UnitConvertersStepDefs {
    WebDriverWait wait = new WebDriverWait(getDriver(), 5);

    @Then("Would click on {string} etc")
    public void wouldClickOnEtc(String converter) {
        new Actions(getDriver())
                .moveToElement(getDriver().findElement(By.xpath("//div[@id='menu']//li/a[contains(text(),'" + converter + "')]")))
                .click()
                .perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='menuon']/a[contains(text(),'" + converter + "')]")));
    }

    @And("Set from which {string} and to which {string} with specific values")
    public void setFromWhichAndToWhichWithSpecificValues(String fromUnit, String toUnit) {
        new Select(getDriver().findElement(By.xpath("//select[@id='calFrom']"))).selectByVisibleText(fromUnit);
        new Select(getDriver().findElement(By.xpath("//select[@id='calTo']"))).selectByVisibleText(toUnit);

        Assert.assertTrue(
                new Select(getDriver().findElement(By.xpath("//select[@id='calFrom']")))
                        .getFirstSelectedOption()
                        .getText()
                        .contains(fromUnit)
        );
        Assert.assertTrue(
                new Select(getDriver().findElement(By.xpath("//select[@id='calTo']")))
                        .getFirstSelectedOption()
                        .getText().contains(toUnit)
        );
    }

    @Then("Set {string} field and verify any result in {string}")
    public void setFieldAndVerifyAnyResultIn(String fromValue, String toValue) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(fromValue);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(
                getDriver().findElement(By.xpath("//input[@name='toVal']")),
                "value"));
        Double actualValue = Double.parseDouble(getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value"));
        assertEquals(format(actualValue), toValue);
    }

    private String format(double value) {
        if (getDriver().findElement(By.xpath("//li[@id='menuon']/a")).getText().equals("Weight")) {
            return new DecimalFormat("#").format(value);
        } else
            return new DecimalFormat("#.#").format(value);
    }
}
