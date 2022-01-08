package definitions;

import groovy.util.logging.Log;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class GenericStepDefs {
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
}

