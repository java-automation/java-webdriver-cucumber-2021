package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class CalculatorStepDefs {
    @When("I navigate to {string}")
    public void iNavigateTo(String calculatorName) {
        getDriver().findElement(By.xpath("//a[normalize-space(.)='" + calculatorName + "']")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        List<WebElement> inputs = getDriver().findElements(By.xpath("//table[@id='calinputtable']//input[not(@type='hidden' or @type='checkbox' or @type='image')]"));
        for (WebElement el : inputs) {
            if (el.isDisplayed()) el.clear();
        }
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String errorMessage) {
        assertThat(getDriver().findElement(By.xpath("//table[@id='calinputtable']/ancestor::td/following-sibling::td")).getText()).contains(errorMessage);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} down payment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownPaymentTradeInStatePercentTaxFees(String price, String term, String interest, String downPayment,
                                                                               String tradeInValue, String state, String salesTax, String feesAmount) {
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@id='cloanterm']")).sendKeys(term);
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@id='cdownpayment']")).sendKeys(downPayment);
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@id='ctradeinvalue']")).sendKeys(tradeInValue);
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@id='csaletax']")).sendKeys(salesTax);
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@id='ctitlereg']")).sendKeys(feesAmount);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String payment) {
        String calculationResult = getDriver().findElement(By.xpath("//h2[@class='h2result']"))
                .getText()
                .replaceAll("[^$0-9.]","");
        assertThat(calculationResult).isEqualTo(payment);
    }
}
