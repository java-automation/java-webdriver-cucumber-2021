package definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import static support.TestContext.*;



public class QuoteStepDefs {

    TestData testdata = new TestData();

    @When("I fill out required fields")
    public void iFillOutRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(testdata.username1);
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(testdata.email1);
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys(testdata.pass1);
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys(testdata.pass1);
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys(testdata.name1);
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
    }

    @And("I submit the page")
    public void iSubmitThePage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='username']")).getText(), testdata.username1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='email']")).getText(), testdata.email1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='password']")).getText(), testdata.pass1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='name']")).getText(), testdata.name1);
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText(), testdata.policy1);
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() throws InterruptedException {
        getDriver().navigate().back();
        Thread.sleep(3000);
        getDriver().navigate().forward();
        Thread.sleep(3000);
        getDriver().navigate().refresh();
        Thread.sleep(3000);
    }
}
