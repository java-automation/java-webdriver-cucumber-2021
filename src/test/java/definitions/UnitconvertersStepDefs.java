package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static support.TestContext.getDriver;

public class UnitconvertersStepDefs {
    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='" + tab + "']")).click();

    }

    @And("I set {string} to {string}")
    public void iSetTo(String fromTab, String toTab) {
        WebElement fromElement = getDriver().findElement(By.xpath("//select[@id='calFrom']"));
        new Select(fromElement).selectByVisibleText(fromTab);

        WebElement toElement = getDriver().findElement(By.xpath("//select[@id='calTo']"));
        new Select(toElement).selectByVisibleText(toTab);

    }

    @And("I enter into From field {string}")
    public void iEnterIntoFromField(String value) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);

    }

    @Then("I verify {string} conversion result")
    public void iVerifyConversionResult(String expectedResult) {
        String actualResult = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value"); //.getText iis not used for read only so we used .getAttribute
        assertThat(actualResult).contains(expectedResult);

        //optional but good to know
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        String roundedActualResult = decimalFormat.format(Double.parseDouble(actualResult));
        String roundedExpectedResult = decimalFormat.format(Double.parseDouble(actualResult));
        assertThat(roundedActualResult).isEqualTo(roundedExpectedResult);

//        double expectedDouble = Double.parseDouble(expectedResult);
//        double actualDouble = Double.parseDouble(actualResult);
//        double roundedExpectedDouble = Math.round(actualDouble * 100.0) / 100.0;
//        double roundedActualDouble = Math.round(actualDouble * 100.0) / 100.0;
//        assertThat(roundedActualDouble).isEqualTo(roundedExpectedDouble);
    }
}
