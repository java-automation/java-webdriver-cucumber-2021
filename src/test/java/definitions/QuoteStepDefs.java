package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Date;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class QuoteStepDefs {
    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("user123");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("user123@yahoo.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("password123");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("password123");

        WebElement nameElement = getDriver().findElement(By.xpath("//input[@id='name']"));
        nameElement.click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Amanda");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Smith");
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();
        System.out.println(nameElement.getAttribute("value"));

        WebElement privacyPolicy = getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(resultText);
        assertThat(resultText).contains("user123", "Amanda Smith", "user123@yahoo.com");
        assertThat(resultText).doesNotContain("password123");

        String agreed = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreed).isEqualTo("true");

        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(password).isEqualTo("[entered]");
    }


}

