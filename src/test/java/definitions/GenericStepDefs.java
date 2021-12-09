package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
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
                getDriver().get("https://www.google.com");
                break;
            case "usps":
                getDriver().get("https://www.usps.com");
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

        WebElement privacyPolicy = getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
        if (!privacyPolicy.isSelected()) {
            privacyPolicy.click();
        }

    }

    @And("I submit the page")
    public void iSubmitThePage() {

        getDriver().findElement(By.xpath("//button[@name='formSubmit']")).click();
    }

    @Then("I verify the required fields")
    public void iVerifyTheRequiredFields() {


// Slava example:
//          String resultText = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
//          System.out.println(resultText);
//          Assertions.assertThat(resultText).contains("jdoe", "Joe", "Doe", "jdoe@exaple.com");
         // Assertions.assertThat(resultText).doesNotContain("welcome");


        //Assertions.assertThat(agreed).isEqualTo("true");

//        String password = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
//        Assertions.assertThat(password).isEqualTo("[entered]");


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

    //Home_work_1  12/08/21
    @Then("I fill our not required fields")
    public void iFillOurNotRequiredFields() {

        getDriver().findElement(By.xpath("//*[@id='address']")).sendKeys("333 State st");
        getDriver().findElement(By.xpath("//input[@name='phone']")).sendKeys("312-777-8999");
        getDriver().findElement(By.xpath("//input[@name='gender']/..//*[text()='Female']")).click();
        getDriver().findElement(By.xpath("//*[@value='BMW']")).click();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).click();
        getDriver().findElement(By.xpath("//*[@value='France']")).click();

    }
    @Then("I verify the not required fields")
    public void iVerifyTheNotRequiredFields() {

        String resultForm = getDriver().findElement(By.xpath("//div[@id='quotePageResult']")).getText();
        System.out.println(resultForm);

        getDriver().findElement(By.xpath("//*[@id='address']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='phone']")).isDisplayed();
        getDriver().findElement(By.xpath("//*[@value='BMW']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='allowedToContact']")).isDisplayed();
        getDriver().findElement(By.xpath("//*[@value='France']")).isDisplayed();
        getDriver().findElement(By.xpath("//input[@name='gender']/..//*[text()='Female']")).isDisplayed();


    }


    // Home_work_2 12/08/21
    @When("I go to Lookup ZIP page by address")
    public void iGoToLookupZIPPageByAddress() throws InterruptedException {

        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//a[text()='Look Up a ZIP Code'][parent::h2]")).click();

        getDriver().findElement(By.xpath("//a[text()='Find by Address']")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@name='tCity']")).sendKeys(city);
        getDriver().findElement(By.xpath("//select[@id='tState']")).click();
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//*[@value='IL']")).click();
        Thread.sleep(3000);
    }

    @Then("I validate {string} zip code exists in the result")
    public void iValidateZipCodeExistsInTheResult(String zip) throws InterruptedException {

        getDriver().findElement(By.xpath("//input[@name='tZip-byaddress']")).sendKeys(zip);
        Thread.sleep(3000);
        getDriver().findElement(By.xpath("//a[@id='zip-by-address']")).click();
        Thread.sleep(3000);

        String resultZip = getDriver().findElement(By.xpath("//div[@id='zip-lookup-app']")).getText();
        System.out.println(resultZip);
        Assertions.assertThat(resultZip).contains("60605");
        Thread.sleep(3000);

    }


}


