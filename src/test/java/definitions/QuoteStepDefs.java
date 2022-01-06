package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.Assertion;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class QuoteStepDefs {
    Map<String, String> user = getData("user");

    @When("I fill out required fields")
    public void iFillOutRequiredFields()  {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(user.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(user.get("email"));
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(user.get("password"));
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(user.get("password"));

        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(user.get("firstName"));
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(user.get("lastName"));
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();

//        String nameValue = getDriver().findElement(By.xpath("//input[@id='name']")).getAttribute("value");
//        System.out.println(nameValue);

        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {


        String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(resultText); // to print the results of the page
        assertThat(resultText).contains(user.get("username"), user.get("firstName"), user.get("lastName"), user.get("email"));
        assertThat(resultText).doesNotContain(user.get("password"));

//        String agreed = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
//        assertThat(agreed).isEqualTo("true");
//
//        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
//        assertThat(password).isEqualTo("[entered]");
//
//
//        String usernameResult = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
//        Assertions.assertThat(usernameResult).isEqualTo("jdoe");
    }

    @And("I select {string} with Select")
    public void iSelectWithSelect(String brands) {
        String[] options = brands.split(" ");
        Select select = new Select(getDriver().findElement(By.xpath("//select[@name='carMake']")));
        for (String el: options) {
            select.selectByValue(el);
        }
    }

    @And("I select {string} with actions")
    public void iSelectWithActions(String brands) {
        Actions actions = new Actions(getDriver());
        String[] options = brands.split(" ");
        //select[@name='carMake']//option[@value='Ford']
        actions.keyDown(Keys.COMMAND).perform();
       for (String el: options) {
           actions
                   .moveToElement(getDriver().findElement(By.xpath("//select[@name='carMake']//option[@value='" +el+ "']")))
                   .click()
                   .perform();
       }
       actions.keyUp(Keys.COMMAND).perform();
    }
}
