package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out the required fields")
    public void iFillOutTheRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys("john");
        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys("doe");
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
//        System.out.println(getDriver().findElement(By.xpath("//input[@name='name']")).getAttribute("value"));

        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@gmail.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("qwerty");

        WebElement privacyPolicy = getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")); // проверка на случай, если чек-бокс выбран автоматом
        if (!privacyPolicy.isSelected()){
            getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        }
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).submit();
    }

    @Then("I verity the required fields")
    public void iVerityTheRequiredFields() {
        String usernameResult = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        if (!usernameResult.equals("jdoe"))
            throw new Error("Incorrect username: " + usernameResult);
        //OR variant 2
        Assertions.assertThat(usernameResult).isEqualTo("jdoe");

        String nameResult = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
        Assertions.assertThat(nameResult).isEqualTo("john doe");

        String emailResult = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        Assertions.assertThat(emailResult).isEqualTo("jdoe@gmail.com");

        //OR check everything at once
        String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        Assertions.assertThat(resultText).contains("jdoe");
        Assertions.assertThat(resultText).contains("john doe");
        Assertions.assertThat(resultText).contains("jdoe@gmail.com");
        Assertions.assertThat(resultText).doesNotContain("qwerty"); //не содержит пароль
        //OR
        Assertions.assertThat(resultText).contains("jdoe", "john doe", "jdoe@gmail.com");
        Assertions.assertThat(resultText).doesNotContain("qwerty"); //не содержит пароль

    }

    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() {
        getDriver().findElement(By.xpath("//a[@class='nav-first-element menuitem']")).click();
        getDriver().findElement(By.xpath("//*[@alt='Zip Code™ Lookup Icon']")).click();
        getDriver().findElement(By.xpath("//a[@role='button'][text()='Find by Address']")).click();
    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String address, String city, String state) {
        getDriver().findElement(By.xpath("//input[@name='tAddress']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@name='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@name='tState']")).click();
        getDriver().findElement(By.xpath("//select[@name='tState']")).sendKeys(state);

        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) {
        String zipResult = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']")).getText();
        Assertions.assertThat(zipResult).contains(zip);
    }
}
