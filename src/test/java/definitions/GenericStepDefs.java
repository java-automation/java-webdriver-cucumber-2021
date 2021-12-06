package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.logging.Level;

import static support.TestContext.getDriver;

public class GenericStepDefs {

    //Home_work_2

    @Given("I go first to ... and print details")
    public void iGoFirstToAndPrintDetails() {
        getDriver().navigate().to("https://www.google.com/");

        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());

    }



    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "amazon":
                getDriver().get("https://www.amazon.com/");
                break;

            default:
                throw new Error("Unsupported page: " + page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
    }

    //Home_work_3
    @And("And I print	details")
    public void andIPrintDetails() {
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getPageSource());
        System.out.println(getDriver().getClass());
    }

    //Home_work_4
    @And("And I	go back and	forward,then refresh the page")
    public void andIGoBackAndForwardThenRefreshThePage() throws InterruptedException {

        getDriver().navigate().back();
        Thread.sleep(1050);
        getDriver().navigate().forward();
        Thread.sleep(1050);
        getDriver().navigate().refresh();
        Thread.sleep(1050);

    }


    @And("I print logs to console")
    public void iPrintLogsToConsole() throws InterruptedException {

        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logs) {
            if (log.getLevel().equals(Level.SEVERE)) {
                throw new Error("Severe error: " + log);
            } else {
                System.out.println(log);
            }
        }
    }

    //HomeWork_1

    @When("I fill our required fields")
    public void iFillOurRequiredFields() {
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("jdoe");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("jdoe@gmail.com");
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys("Test12test");
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("Test12test");
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@name='firstName']")).sendKeys("Joe");
        getDriver().findElement(By.xpath("//input[@name='lastName']")).sendKeys("Doe");
        getDriver().findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")).click();
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();

    }

    @And("I submit the page")
    public void iSubmitThePage() {

        getDriver().findElement(By.xpath("//button[@name='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {
        getDriver().findElement(By.xpath("//*[text()='Email']")).isDisplayed();
        getDriver().findElement(By.xpath("//*[text()='First Name']")).isDisplayed();
        getDriver().findElement(By.xpath("//*[text()='Last Name']")).isDisplayed();
        getDriver().findElement(By.xpath("//*[text()='Agreed To Privacy Policy']")).isDisplayed();
        getDriver().findElement(By.xpath("//*[text()='Name']")).isDisplayed();
        getDriver().findElement(By.xpath("//*[text()='Username']")).isDisplayed();
        getDriver().findElement(By.xpath("//*[text()='Password']")).isDisplayed();
    }


   //Home_work_5
    @Then("And	I change	resolution	to	{string}")
    public void andIChangeResolutionTo(String phoneRes) throws InterruptedException {
        getDriver().manage().window().setSize(new Dimension(400,768));
        Thread.sleep(3000);

    }


    @Then("And	I change your resolution to	{string}")
    public void andIChangeYourResolutionTo(String desktopRes) throws InterruptedException {

        getDriver().manage().window().setSize(new Dimension(1024,768));
        Thread.sleep(3000);
    }
}


