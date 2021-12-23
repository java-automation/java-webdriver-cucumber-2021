package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class CalculatorStepDefs {

    private WebElement getAutoPriceField() {
        return getDriver().findElement(By.xpath("//input[@id='cloanamount']"));
    }
    private WebElement getLoanTermField() {
        return getDriver().findElement(By.xpath("//input[@id='cloanterm']"));
    }
    private WebElement getInterestRateField() {
        return getDriver().findElement(By.xpath("//input[@id='cinterestrate']"));
    }
    private WebElement getDownPaymentField() {
        return getDriver().findElement(By.xpath("//input[@id='cdownpayment']"));
    }
    private WebElement getTradeInValueField() {
        return getDriver().findElement(By.xpath("//input[@id='ctradeinvalue']"));
    }
    private WebElement getYourStateField() {
        return getDriver().findElement(By.xpath("//select[@name='cstate']"));
    }
    private WebElement getSaleTaxField() {
        return getDriver().findElement(By.xpath("//input[@id='csaletax']"));
    }
    private WebElement getOtherFeesField() {
        return getDriver().findElement(By.xpath("//input[@id='ctitlereg']"));
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String sCalcType) {
        getDriver().findElement(By.xpath("//a[normalize-space()='" + sCalcType + "']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//h1[normalize-space()='" + sCalcType + "']"))));
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getAutoPriceField().clear();
        getLoanTermField().clear();
        getInterestRateField().clear();
        getDownPaymentField().clear();
        getTradeInValueField().clear();
        new Select(getYourStateField()).selectByVisibleText("-- Select --");
        getSaleTaxField().clear();
        getOtherFeesField().clear();

        assertThat(getAutoPriceField().getAttribute("value")).isEqualTo("");
        assertThat(getLoanTermField().getAttribute("value")).isEqualTo("");
        assertThat(getInterestRateField().getAttribute("value")).isEqualTo("");
        assertThat(getDownPaymentField().getAttribute("value")).isEqualTo("");
        assertThat(getTradeInValueField().getAttribute("value")).isEqualTo("");
        assertThat(new Select(getYourStateField()).getFirstSelectedOption().getText()).isEqualTo("-- Select --");
        assertThat(getSaleTaxField().getAttribute("value")).isEqualTo("");
        assertThat(getOtherFeesField().getAttribute("value")).isEqualTo("");
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String sError) {
        assertThat(getDriver().findElement(By.xpath("//a[@name='autoloanresult']/..")).getText()).contains(sError);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String sPrice, String sMonths, String sInterest, String sDown, String sTradeIn, String sState, String sPercent, String sFees) {
        getAutoPriceField().sendKeys(sPrice);
        getLoanTermField().sendKeys((sMonths));
        getInterestRateField().sendKeys(sInterest);
        getDownPaymentField().sendKeys(sDown);
        getTradeInValueField().sendKeys(sTradeIn);
        new Select(getYourStateField()).selectByVisibleText(sState);
        getSaleTaxField().sendKeys(sPercent);
        getOtherFeesField().sendKeys(sFees);

        assertThat(getAutoPriceField().getAttribute("value")).isEqualTo(sPrice);
        assertThat(getLoanTermField().getAttribute("value")).isEqualTo(sMonths);
        assertThat(getInterestRateField().getAttribute("value")).isEqualTo(sInterest);
        assertThat(getDownPaymentField().getAttribute("value")).isEqualTo(sDown);
        assertThat(getTradeInValueField().getAttribute("value")).isEqualTo(sTradeIn);
        assertThat(new Select(getYourStateField()).getFirstSelectedOption().getText()).isEqualTo(sState);
        assertThat(getSaleTaxField().getAttribute("value")).isEqualTo(sPercent);
        assertThat(getOtherFeesField().getAttribute("value")).isEqualTo(sFees);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String sMonthly) {
        assertThat(getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText()).contains(sMonthly);
    }
}
