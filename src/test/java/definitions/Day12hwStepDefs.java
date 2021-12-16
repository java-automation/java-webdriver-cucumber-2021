package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static support.TestContext.getDriver;

public class Day12hwStepDefs {
    @Given("I open {string} page")
    public void openPage(String arg0) {
        //String url = switch (arg0.toLowerCase()) {
        switch (arg0.toLowerCase()) {
            case "google" -> getDriver().get("https://www.google.com/");
            case "quote" -> getDriver().get("https://skryabin.com/market/quote.html");
            //case "usps" -> getDriver().get("https://www.ups.com/us/en/global.page");
            case "usps" -> getDriver().get("https://www.usps.com/");
            default -> throw new Error("Unsupported page: " + arg0);
        }
        //System.out.println("Unsupported url_s1: " + arg0);
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
    }

    @And("I print logs to the console")
    public void printLogs() throws InterruptedException {
        Thread.sleep(2000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logs) {
            if (log.getLevel().equals(Level.SEVERE)) {
                throw new Error("Severe error: " + log);
            } else {
                System.out.println(log);
            }
        }
    }

    @When("I fill out required fields")
    public void fillRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("VVZav");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("vvz@gmail.com");
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("12345");
        getDriver().findElement(By.xpath("//input[@id='name']")).sendKeys("VVZ");
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

        //Debug & Watches
        //String nameValue=getDriver().findElement(By.xpath("//input[@id='name']")).getAttribute("value");
        //System.out.println(nameValue);
    }

    @And("I wait & check for {int} sec")
    public void waitAndCheck(int s) throws InterruptedException {
        TimeUnit.SECONDS.sleep(s);
    }

    @And("I submit the page")
    public void submitPage() {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void verifyRequiredFields() {
        //String usernameResult = getDriver().findElement(By.name("username")).getText();
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='username']")).getText(), "VVZav");
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='email']")).getText(), "vvz@gmail.com");
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='password']")).getText(), "[entered]");
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='name']")).getText(), "VVZ");
        Assert.assertEquals(getDriver().findElement(By.xpath("//b[@name='agreedToPrivacyPolicy']")).getText(),"true" );
    }
}















