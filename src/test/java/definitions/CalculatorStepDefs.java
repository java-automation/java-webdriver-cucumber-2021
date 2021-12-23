package definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;

import java.util.*;

import static support.TestContext.getDriver;

public class CalculatorStepDefs {
    @When("I navigate to {string}")
    public void iNavigateTo(String calculatorType) {
        getDriver().findElement(By.xpath("//a[contains(text(),'Auto Loan')]")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        String[] array = {"cloanamount", "cloanterm", "cinterestrate", "cdownpayment", "ctradeinvalue", "csaletax", "ctitlereg"};
        for(int i=0; i<array.length; i++) {
            getDriver().findElement(By.xpath("//input[@id='" + array[i] + "']")).clear();
        }
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        String xpath = "//a[@name='autoloanresult']/..";
        String text = getDriver().findElement(By.xpath(xpath)).getText();
        Assert.assertTrue(text.contains(error));
        System.out.println("Error: '" + error + "'");
        System.out.println("Found in:\n" + text);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} down payment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String down_payment, String trade_in, String state, String percent_tax, String fees) {
        String[] arrayIdFields = {"cloanamount", "cloanterm", "cinterestrate", "cdownpayment", "ctradeinvalue", "csaletax", "ctitlereg"};
        String[] arrayVar = {price, months, interest, down_payment, trade_in, percent_tax, fees};
        for (int i = 0; i < arrayIdFields.length; i++) {
            getDriver().findElement(By.xpath("//input[@id='" + arrayIdFields[i] + "']")).sendKeys(arrayVar[i]);
        }
        getDriver().findElement(By.xpath("//option[contains(text(),'" + state + "')]")).click();
    }


    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String monthlyPay) {
        Assert.assertTrue(getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText().contains(monthlyPay));
    }
}
