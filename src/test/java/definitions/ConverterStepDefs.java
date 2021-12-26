package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class ConverterStepDefs {
    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='" + tab + "']")).click();;
    }

    @And("I set {string} to {string}")
    public void iSetTo(String fromTab, String toTab) {
       WebElement fromElement = getDriver().findElement(By.xpath("//select[@name='calFrom']"));
       new Select(fromElement).selectByVisibleText(fromTab);

       WebElement toElement = getDriver().findElement(By.xpath("//select[@name='calTo']"));
       new Select(toElement).selectByVisibleText(toTab);
    }

    @And("I enter into From field {string}")
    public void iEnterIntoFromField(String value) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);

    }

    @Then("I verify {string} conversion result")
    public void iVerifyConversionResult(String expectedResult) {
        String actualResult = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value"); // attribute is value
        assertThat(actualResult).contains(expectedResult);

        DecimalFormat decimalFormat = new DecimalFormat("0");
        String roundedActualResult = decimalFormat.format(Double.parseDouble(expectedResult));
        String roundedExpectedResult = decimalFormat.format(Double.parseDouble(actualResult));
        assertThat(roundedActualResult).isEqualTo(roundedExpectedResult);
    }

}
