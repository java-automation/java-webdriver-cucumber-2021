package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        //WebElement field = getDriver().findElement(By.xpath("));
        //(//table[@id='calinputtable']//input)[1]

//        WebElement[] array = new WebElement[8];
//        for (int i = 1; i >= 8; i++) {
//            getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[" + i + "]")).clear();
//        }
        //Временное решение
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[1]")).clear();
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[3]")).clear();
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[4]")).clear();
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[5]")).clear();
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[6]")).clear();
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[7]")).clear();
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[8]")).clear();
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
       //Временное решение
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[1]")).sendKeys(price);
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[3]")).sendKeys(months);
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[4]")).sendKeys(interest);
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[5]")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[6]")).sendKeys(tradein);
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[7]")).sendKeys(percentTax);
        getDriver().findElement(By.xpath("(//table[@id='calinputtable']//input)[8]")).sendKeys(fees);
        //Выбираею штат:
        WebElement selectState = getDriver().findElement(By.xpath("//select[@name='cstate']"));
//        Select select = new Select(selectState);
//        select.selectByValue(state);
        //объединим две верхние строчки в одну
        new Select(selectState).selectByVisibleText(state);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String price) {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@name='autoloanresult']")));
        String monthlyPayResult = getDriver().findElement(By.xpath("//h2[@class='h2result']")).getText();
        Assertions.assertThat(monthlyPayResult).contains(price);
    }
}
