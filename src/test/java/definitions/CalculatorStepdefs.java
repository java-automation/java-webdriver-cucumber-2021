package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class CalculatorStepdefs {
    @When("I navigate to {string}")
    public void iNavigateTo(String field) {

        getDriver().findElement(By.xpath("//div[@id='contentout']//a[text()='" + field + "']")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).clear();

        Thread.sleep(2000);
    }

    @And("I calculate")
    public void iCalculate() throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();

        Thread.sleep(2000);
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String errorText) throws InterruptedException {

        WebElement errors = getDriver().findElement(By.xpath("//div[@id='contentout']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);

        wait.until(ExpectedConditions.textToBePresentInElement(errors, errorText));

        Thread.sleep(2000);

    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradeIn, String state, String tax, String fees) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@id='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@id='cloanterm']")).sendKeys(months);
        getDriver().findElement(By.xpath("//input[@id='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@id='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']")).sendKeys(tradeIn);
        getDriver().findElement(By.xpath("//select[@name='cstate']")).sendKeys(state);
        getDriver().findElement(By.xpath("//input[@id='csaletax']")).sendKeys(tax);
        getDriver().findElement(By.xpath("//input[@id='ctitlereg']")).sendKeys(fees);

        Thread.sleep(2000);
    }


    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String price) {

        WebElement resultOfCalculation = getDriver().findElement(By.xpath("//div[@id='contentout']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 2);

        wait.until(ExpectedConditions.textToBePresentInElement(resultOfCalculation, price));

    }
}
