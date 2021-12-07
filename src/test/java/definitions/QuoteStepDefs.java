package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

import static support.TestContext.getDriver;

public class QuoteStepDefs {
    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@example.com");
        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys("john");
        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys("doe");
        getDriver().findElement(By.xpath("//span[normalize-space()='Save']")).click();
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("test123" + Keys.ENTER);
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("test123" + Keys.ENTER);
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
//        String usernameResult = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
//        if(!usernameResult.equals("jdoe")){
//            throw new Error("Incorrect username: " + usernameResult);
//        }
        String username = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        assert "jdoe".equals(username);
        String email = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        assert "jdoe@example.com".equals(email);
        String firstName = getDriver().findElement(By.xpath("//b[@name='firstName']")).getText();
        assert "john".equals(firstName);
        String lastName = getDriver().findElement(By.xpath("//b[@name='lastName']")).getText();
        assert "doe".equals(lastName);
        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assert "test123".equals(password);
        String confirmPassword = getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).getText();
        assert "test123".equals(confirmPassword);

    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@name='formSubmit']")).click();

    }

}
