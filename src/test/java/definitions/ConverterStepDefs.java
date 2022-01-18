package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class ConverterStepDefs {
    @When("I go to {string} page")
    public void iGoToPage(String menu) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='" +menu +"']")).click();
    }

    @And("I set {string} to {string}")
    public void iSetTo(String convertFrom, String convertTo) {
        WebElement fromElement = getDriver().findElement(By.xpath("//select[@id='calFrom']"));
        new Select(fromElement).selectByVisibleText(convertFrom);

        WebElement toElement = getDriver().findElement(By.xpath("//select[@id='calTo']"));
        new Select(toElement).selectByVisibleText(convertTo);
    }

    @And("I enter into From field {string}")
    public void iEnterIntoFromField(String value) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);
    }

    @Then("I verify {string} converted results")
    public void iVerifyConvertedResults(String expectedResult) {
        String actualResult = getDriver().findElement(By.
                xpath("//input[@name='toVal']")).getAttribute("value");
        assertThat(actualResult).contains(expectedResult);
    }
}
