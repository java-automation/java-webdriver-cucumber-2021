package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SitesStepDefs {

    private String capitalize(String word){
        return word.substring(0,1).toUpperCase() + word.substring(1);
    }

    @When("I click on {string}")
    public void iClickOn(String dimension) {
        getDriver().findElement(By.xpath("//div[@id='menu']//a[text()='" + capitalize(dimension) + "']")).click();
    }

    @And("I set from {string} to {string}")
    public void iSetFromTo(String fromUnit, String toUnit) throws InterruptedException {
        Select from = new Select(getDriver().findElement(By.id("calFrom")));
        from.selectByVisibleText(capitalize(fromUnit));
        getDriver().findElement(By.xpath("//select[@name='calTo']/option[contains(text(),'" +
                                                                                  capitalize(toUnit) + "')]")).click();
    }

    @And("I set {string} in From field value")
    public void iSetInFromFieldValue(String value) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);
    }

    private String extractConvertedValue() {
        return getDriver().findElement(By.xpath("//input[@name='toVal']")).getAttribute("value");
    }

    @Then("I verify {string} in To field value")
    public void iVerifyInToFieldValue(String expectedValue) {
        assertThat(extractConvertedValue()).isEqualTo(expectedValue);
    }

    @Then("I verify {string} in To field value at scale")
    public void iVerifyInToFieldValueAtScale(String expectedValue) {
        BigDecimal actual = new BigDecimal(extractConvertedValue());
        BigDecimal expected = new BigDecimal(expectedValue);
        int actualScale = actual.scale();
        int expectedScale = expected.scale();
        if (actualScale < expectedScale) {
            throw new Error("Scale " + expectedScale + " of the expected value is higher than scale " +
                                                                                actualScale + " of the actual value");
        }
        BigDecimal actualAtScale = actual.setScale(expectedScale, RoundingMode.DOWN);
        assertThat(actualAtScale).isEqualTo(expected);
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String linkText) {
        getDriver().findElement(By.xpath("//ul[@id='hl1']//a[contains(text(),'" + linkText + "')]")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        WebElement formTable = getDriver().findElement(By.xpath("//table[@id='calinputtable']"));
        WebElement autoPrice = formTable.findElement(By.xpath("//input[@name='cloanamount']"));
        WebElement loanTerm = formTable.findElement(By.xpath("//input[@name='cloanterm']"));
        WebElement interestRate = formTable.findElement(By.xpath("//input[@name='cinterestrate']"));
        WebElement downPayment = formTable.findElement(By.xpath("//input[@name='cdownpayment']"));
        WebElement tradeInValue = formTable.findElement(By.xpath("//input[@name='ctradeinvalue']"));
        WebElement salesTax = formTable.findElement(By.xpath("//input[@name='csaletax']"));
        WebElement fees = formTable.findElement(By.xpath("//input[@name='ctitlereg']"));
        List<WebElement> els = new ArrayList<>();
        els.add(autoPrice);
        els.add(interestRate);
        els.add(loanTerm);
        els.add(downPayment);
        els.add(tradeInValue);
        els.add(salesTax);
        els.add(fees);
        for (WebElement el : els) {
            el.clear();
        }
        Select yourState = new Select(formTable.findElement(By.xpath("//select[@name='cstate']")));
        yourState.selectByVisibleText("-- Select --");
        WebElement includeFees = formTable.findElement(By.xpath("//input[@name='cttrinloan']"));
        if (includeFees.isSelected()) includeFees.click();
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//table[@id='calinputtable']//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String errorMessage) {
        List<WebElement> els = getDriver().findElements(By.xpath("//div[@id='content']//div"));
        boolean found = false;
        for (WebElement el : els) {
            if (el.getText().contains(errorMessage)) {
                found = true;
                break;
            }
        }
        if (!found) throw new Error("Error message \"" + errorMessage + "\" is not found");
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterFormValues(String price, String months, String interest, String downpayment,
                                 String tradeIn, String state, String percentTax, String fees) {
        WebElement formTable = getDriver().findElement(By.xpath("//table[@id='calinputtable']"));
        formTable.findElement(By.xpath("//input[@name='cloanamount']")).sendKeys(price);
        formTable.findElement(By.xpath("//input[@name='cloanterm']")).sendKeys(months);
        formTable.findElement(By.xpath("//input[@name='cinterestrate']")).sendKeys(interest);
        formTable.findElement(By.xpath("//input[@name='cdownpayment']")).sendKeys(downpayment);
        formTable.findElement(By.xpath("//input[@name='ctradeinvalue']")).sendKeys(tradeIn);
        formTable.findElement(By.xpath("//input[@name='csaletax']")).sendKeys(percentTax);
        formTable.findElement(By.xpath("//input[@name='ctitlereg']")).sendKeys(fees);
        Select yourState = new Select(formTable.findElement(By.xpath("//select[@name='cstate']")));
        yourState.selectByVisibleText(state);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String monthlyPay) {
        String res = getDriver().findElement(By.xpath("//a[@name='autoloanresult']/following-sibling::h2")).getText();
        Matcher m = Pattern.compile(".*(\\$.*)").matcher(res);
        assertThat(m.find()).isTrue();
        assertThat(m.group(1)).isEqualTo(monthlyPay);
    }
}
