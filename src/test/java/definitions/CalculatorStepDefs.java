package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static support.TestContext.getDriver;


public class CalculatorStepDefs {
    @When("I navigate to {string}")
    public void iNavigateTo(String page) {
        getDriver().findElement(By.xpath("//a[text()='Auto Loan Calculator']")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
//        Set<String> fields = getDriver().findElement(By.xpath("//d"));
//        for (field : fields)


    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String errorText) {
        String errorElement = getDriver().findElement(By.xpath("//td[@valign='top']//font[text()='" + errorText + "']")).getText();
        Assertions.assertThat(errorElement).contains(errorText);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradein, String state, String percentTax, String fees) {

    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String price) {
        String monthlyPayResult = getDriver().findElement(By.xpath("//a[@name='autoloanresult']")).getText();
        Assertions.assertThat(monthlyPayResult).contains(price);
    }
}
