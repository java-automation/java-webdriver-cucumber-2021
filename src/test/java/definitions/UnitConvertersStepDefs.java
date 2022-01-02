package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static support.TestContext.getDriver;

public class UnitConvertersStepDefs {
    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        getDriver().findElement(By.xpath("//a[text()='" + tab + "']")).click();
    }

    @And("I set {string} to {string}")
    public void iSetTo(String fromFormat, String toFormat) {
        WebElement fromElement = getDriver().findElement(By.xpath("//select[@id='calFrom']")); //выбираем всё окно select
        new Select(fromElement).selectByVisibleText(fromFormat); //уточняем, какой вариант нам нужно выбрать

        WebElement toElement = getDriver().findElement(By.xpath("//select[@id='calTo']"));
        new Select(toElement).selectByVisibleText(toFormat);
    }

    @And("I enter into From field {string}")
    public void iEnterIntoFromField(String inputText) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(inputText);
    }

    @And("I verify {string} conversion result")
    public void iVerifyConversionResult(String expectedResult) {
        String actualResult = getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value"); //getAttribure - because it's input and readonly, we cannot use getText()
        Assertions.assertThat(actualResult).contains(expectedResult);
    }
}
