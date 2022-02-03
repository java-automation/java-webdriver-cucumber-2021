package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.CareersHome;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static support.TestContext.getDriver;

public class GenericStepDefs {

    public GenericStepDefs(){
        PageFactory.initElements(getDriver(),this);
    }

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        switch (page.toLowerCase()){
            case "careers" -> new CareersHome().open();
        }
    }

    @Given("I go to the {string} page")
    public void iGoToThePage(String url) {
        switch (url) {
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
            case "google" -> getDriver().get("https://google.com");
            case "etonline" -> getDriver().get("https://www.etonline.com/");
        }
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() {
       LogEntries logs =  getDriver().manage().logs().get(LogType.BROWSER);
       for (LogEntry log : logs){
           System.out.println(log);
       }
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        //verifying Name field
        getDriver().findElement(By.xpath("//b[@name='name']")).getText().equalsIgnoreCase("Ivan Ivanov Ivanovich");
        assertThat(getDriver().findElement(By.xpath("//b[@name='firstName']")).getText()).isEqualTo("Ivan");
        // getDriver().findElement(By.xpath("//b[@name='firstName']")).getText().equalsIgnoreCase("Ivan");
        getDriver().findElement(By.xpath("//b[@name='middleName']")).getText().equalsIgnoreCase("Ivanov");
        getDriver().findElement(By.xpath("//b[@name='lastName']")).getText().equalsIgnoreCase("Ivanovich");
        //verifying Username
        assertThat(getDriver().findElement(By.xpath("//b[@name='username']")).getText()).contains("69");
    }

    @When("I fill out optional fields")
    public void iFillOutOptionalFields() {
        //select country
        Select country = new Select(getDriver().findElement(By.xpath("//select[@name='countryOfOrigin']")));
        country.selectByValue("Russia");

        // Address
        getDriver().findElement(By.xpath("//textarea[@id='address']")).sendKeys("Lorem ipsum");
        //phone
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("555-555-55-55");
        getDriver().findElement(By.xpath("//input[@name='gender']")).click();
        //date of birth
        getDriver().findElement(By.xpath("//select[@data-handler='selectMonth']/option[@value='8']")).click();
        Select year = new Select(getDriver().findElement(By.xpath("//select[@data-handler='selectYear']")));
        year.selectByValue("1991");
        getDriver().findElement(By.xpath("//a[contains(text(),'30')]")).click();


    }

    @And("I select {string} with Select")
    public void iSelectWithSelect(String brands) {
        String[] options = brands.split(" ");
        Select select = new Select(getDriver().findElement(By.xpath("//select[@name='carMake']")));
        for (String el : options){
            select.selectByValue(el);
        }
    }

    @And("I select {string} with Actions")
    public void iSelectWithActions(String brands) {
        Actions actions = new Actions(getDriver());
        String[] options = brands.split(" ");
        actions.keyDown(Keys.COMMAND).perform();
        for (String el : options){
            actions.moveToElement(getDriver().findElement(By.xpath("//select[@name='carMake']//option[@value='"+el+"']")))
                    .click()
                    .perform();
        }
        actions.keyDown(Keys.COMMAND).perform();
    }

    @And("I switch to another window")
    public void iSwitchToAnotherWindow() {
        String originalWindow = getDriver().getWindowHandle();
        for (String handle : getDriver().getWindowHandles() ){
            getDriver().switchTo().window(handle);
        }
        getDriver().switchTo().window(originalWindow);
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String page) {
        getDriver().findElement(By.xpath("//a[contains(text(),'"+ page +"')]")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        autoPrice.clear();
        loanTerm.clear();
        interestRate.clear();
        downPayment.clear();
        tradeInValue.clear();
//        state.clear();
        titleReg.clear();
        salesTax.clear();
    }


    @FindBy(xpath = "//input[@id='cloanamount']")
    private WebElement autoPrice;

    @FindBy(xpath = "//input[@id='cloanterm']")
    private WebElement loanTerm;

    @FindBy(xpath = "//input[@id='cinterestrate']")
    private WebElement interestRate;

    @FindBy(xpath = "//input[@id='cdownpayment']")
    private WebElement downPayment;

    @FindBy(xpath = "//input[@id='ctradeinvalue']")
    private WebElement tradeInValue;

    @FindBy(xpath = "//select[@name='cstate']")
    private WebElement state;

    @FindBy(xpath = "//select[@name='cstate']/option[@value='CA']")
    private WebElement stateCa;

    @FindBy(xpath = "//input[@id='ctitlereg']")
    private WebElement titleReg;

    @FindBy(xpath = "//input[@id='csaletax']")
    private WebElement salesTax;

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();

    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String error) {
        assertThat(getDriver().findElement(By.xpath("//font[contains(text(), '"+ error+ "')]")).getText()).isEqualTo(error);
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String month, String interest, String downpayment, String tradein, String stateValue, String percent, String feeValue) throws InterruptedException {
        autoPrice.sendKeys(price);
        loanTerm.sendKeys(month);
        interestRate.sendKeys(interest);
        downPayment.sendKeys(downpayment);
        tradeInValue.sendKeys(tradein);
        selectState(stateValue,state);
        salesTax.sendKeys(percent);
        titleReg.sendKeys(feeValue);

    }

    public void selectState(String value, WebElement xpath){
        Select selectState = new Select(xpath);
        selectState.selectByVisibleText(value);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String paymentValue) {
        assertTrue(getDriver().findElement(By.xpath("//a[@name='autoloanresult']/../h2")).getText().contains(paymentValue));
    }

    @And("I enter {string} as contact person with a phone {string}")
    public void iEnterAsContactPersonWithAPhone(String contactName, String contactPhone) throws InterruptedException {
        getDriver().switchTo().frame("additionalInfo");

        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(contactName);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(contactPhone);

        getDriver().switchTo().defaultContent();
        Thread.sleep(5000);
    }

}


