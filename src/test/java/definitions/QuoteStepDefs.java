package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;

import java.io.FileNotFoundException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static support.TestContext.getData;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class QuoteStepDefs {
    @When("I fill out required fields")
    public void iFillOutRequiredFields()  {
        Map<String, String> user = getData("user");
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@example.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("welcome");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("welcome");

        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Doe");
        getDriver().findElement(By.xpath("//span[text()='Save']")).click();

        String nameValue = getDriver().findElement(By.xpath("//input[@id='name']")).getAttribute("value");
        System.out.println(nameValue);

        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {

        String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(resultText);
        assertThat(resultText).contains("jdoe");
        assertThat(resultText).doesNotContain("welcome");

        String agreed = getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText();
        assertThat(agreed).isEqualTo("true");

        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(password).isEqualTo("[entered]");


        String usernameResult = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
//        if (!usernameResult.equals("jdoe")) {
//            throw new Error("Incorrect username: " + usernameResult);
//        }
//
//        Assert.assertEquals(usernameResult, "jdoe");
        Assertions.assertThat(usernameResult).isEqualTo("jdoe");


    }
}
