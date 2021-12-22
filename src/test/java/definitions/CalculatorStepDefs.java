package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.getDriver;

public class CalculatorStepDefs {

    public static final String Auto_Price = "//input[@id='cloanamount']";
    public static final String Loan_Term = "//input[@id='cloanterm']";
    public static final String Interest_Rate = "//input[@id='cinterestrate']";
    public static final String Down_Payment = "//input[@id='cdownpayment']";
    public static final String Trade_in_Value = "//input[@id='ctradeinvalue']";
    public static final String Your_State = "//select[@name='cstate']";
    public static final String Sales_Tax = "//input[@id='csaletax']";
    public static final String Title_Registration_And_Other_Fees = "//input[@id='ctitlereg']";
    public static final String Calculation_Result = "//h2[@class='h2result']";
    public static final String Calculate_Button = "//input[@value='Calculate']";
    public static final String Amortization_Graph_Field = "//div[@id='cchartdiv']";
    public static final String All_Text_Fields_Except_Auto_Price = "//table[@id='calinputtable']/tbody/tr/td/input[@type='text']";
    WebDriverWait wait = new WebDriverWait(getDriver(), 5);

    @When("I navigate to {string}")
    public void iNavigateTo(String calculatorName) {
        getDriver().findElement(By.xpath("//li/a[contains(text(),'" + calculatorName + "')]")).click();
        wait.until(ExpectedConditions.titleIs(calculatorName));
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath(Auto_Price)).clear();
        getDriver().findElement(By.xpath(Loan_Term)).clear();
        getDriver().findElement(By.xpath(Interest_Rate)).clear();
        getDriver().findElement(By.xpath(Down_Payment)).clear();
        getDriver().findElement(By.xpath(Trade_in_Value)).clear();

        new Select(getDriver().findElement(By.xpath(Your_State))).selectByIndex(0);
        getDriver().findElement(By.xpath(Sales_Tax)).clear();
        getDriver().findElement(By.xpath(Title_Registration_And_Other_Fees)).clear();
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath(Calculate_Button)).click();
        if (isOneOfTheTextFieldsEmpty()) {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Amortization_Graph_Field)));
        } else {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Calculation_Result)));
        }
    }

    private boolean isOneOfTheTextFieldsEmpty() {
        return (getDriver().findElements(By.xpath(All_Text_Fields_Except_Auto_Price))
                .stream()
                .filter(el -> el.getAttribute("value").isEmpty()).toList().size() > 0) ||
                (getDriver().findElement(By.xpath(Auto_Price)).getAttribute("value").isEmpty()
                );
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        String errorsText = getDriver().findElement(By.xpath("//td[@valign='top']/a[@name='autoloanresult']//..")).getText();
        if (isOneOfTheTextFieldsEmpty()) {
            Assert.assertTrue(error.length() > 0);
            Assert.assertTrue(errorsText.contains(error));
        } else throw new Error("There is no error text on the page");
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradein, String state, String percentTax, String fees) throws InterruptedException {
        getDriver().findElement(By.xpath(Auto_Price)).sendKeys(price);
        getDriver().findElement(By.xpath(Loan_Term)).sendKeys(months);
        getDriver().findElement(By.xpath(Interest_Rate)).sendKeys(interest);
        getDriver().findElement(By.xpath(Down_Payment)).sendKeys(downpayment);
        getDriver().findElement(By.xpath(Trade_in_Value)).sendKeys(tradein);

        new Select(getDriver().findElement(By.xpath(Your_State))).selectByVisibleText(state);
        getDriver().findElement(By.xpath(Sales_Tax)).sendKeys(percentTax);
        getDriver().findElement(By.xpath(Title_Registration_And_Other_Fees)).sendKeys(fees);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Calculation_Result)));
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String monthlyPay) {
        Assert.assertTrue(getDriver().findElement(By.xpath(Calculation_Result)).getText().contains(monthlyPay));
    }
}
