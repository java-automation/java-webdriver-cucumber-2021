package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;
public class CalculatorStepDef {
    @When("I navigate to {string}")
    public void iNavigateTo(String calculateItem) {
        getDriver().
                findElement(By.xpath("//a[contains(text(),'"+calculateItem +"')]")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.id("cloanamount")).clear();
        getDriver().findElement(By.id("cloanterm")).clear();
        getDriver().findElement(By.id("cinterestrate")).clear();
        getDriver().findElement(By.id("cdownpayment")).clear();
        getDriver().findElement(By.id("ctradeinvalue")).clear();
        getDriver().findElement(By.id("csaletax")).clear();
        getDriver().findElement(By.id("ctitlereg")).clear();
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.
                xpath("//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String errorMessage) {
        String actualErrorMessage = getDriver().
                findElement(By.xpath("//a[@name='autoloanresult']/..")).getText();
        assertThat(actualErrorMessage).contains(errorMessage);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(
            String price, String months, String interest,
            String downpayment, String tradeIn, String state,
            String tax, String fees) {
        getDriver().findElement(By.id("cloanamount")).sendKeys(price);
        getDriver().findElement(By.id("cloanterm")).sendKeys(months);
        getDriver().findElement(By.id("cinterestrate")).sendKeys(interest);
        getDriver().findElement(By.id("cdownpayment")).sendKeys(downpayment);
        getDriver().findElement(By.id("ctradeinvalue")).sendKeys(tradeIn);
        getDriver().findElement(By.id("csaletax")).sendKeys(tax);
        getDriver().findElement(By.id("ctitlereg")).sendKeys(fees);
        new Select(getDriver().
                findElement(By.xpath("//select[@name='cstate']"))).selectByVisibleText(state);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String monthlyPay) {
        String monthlyPaymentActual = getDriver().
                findElement(By.xpath("//h2[@class='h2result']")).getText();
        assertThat(monthlyPaymentActual).contains(monthlyPay);
    }
}
