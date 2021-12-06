package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out the required fields")
    public void iFillOutTheRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys("john");
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@gmail.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("qwerty");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("qwerty");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).submit();
    }

    @Then("I verity the required fields")
    public void iVerityTheRequiredFields() {
        String nameResult = getDriver().findElement(By.xpath("//b[@name='name']")).getText();
        if (!nameResult.equals("john"))
            throw new Error("Incorrect name: " + nameResult);
        String usernameResult = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        if (!usernameResult.equals("Username jdoe"))
            throw new Error("Incorrect username: " + usernameResult);
        String emailResult = getDriver().findElement(By.xpath("//input[@name='email']")).getText();
        if (!emailResult.equals("Email jdoe@gmail.com"))
            throw new Error("Incorrect email: " + emailResult);
    }


}
