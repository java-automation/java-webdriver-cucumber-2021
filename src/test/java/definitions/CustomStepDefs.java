package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.Locale;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

public class CustomStepDefs {

    private Map<String, String> profileOne = Map.ofEntries(
            Map.entry("username", "jdoe"),
            Map.entry("email", "john.doe@corp.com"),
            Map.entry("password", "jsecret"),
            Map.entry("name", "John Vitaljevich Doe")
    );

    private Map<String, String> profileTwo = Map.ofEntries(
            Map.entry("username", "asmith"),
            Map.entry("email", "alan.smith@corp.com"),
            Map.entry("password", "asecret"),
            Map.entry("name", "Alan Ivanovich Smith")
    );

    private Map<String, String> workingProfile;

    @Given("I go to {string} page")
    public void iGoToPage(String websiteReference) {
        String address = switch (websiteReference.toLowerCase()) {
            case "google" -> "https://google.com";
            case "yahoo" -> "https://yahoo.com";
            case "bing" -> "https://bing.com";
            case "gibiru" -> "https://gibiru.com";
            case "duckduckgo" -> "https://duckduckgo.com";
            case "swisscows" -> "https://swisscows.com";
            case "search encrypt" -> "https://searchencrypt.com";
            case "startpage" -> "https://startpage.com";
            case "yandex" -> "https://yandex.com";
            case "boardreader" -> "https://boardreader.com";
            case "ecosia" -> "https://ecosia.org";
            case "quote form" -> "https://skryabin.com/market/quote.html";
            case "portnov campus" -> "https://portnov.com";
            case "portnov online" -> "https://portnov.net";
            case "hidden button" -> "http://uitestingplayground.com/scrollbars";
            default -> throw new Error("No known URL for this reference: " + websiteReference);
        };
        getDriver().get(address);
    }

    @And("I print page details")
    public void iPrintPageDetails() throws InterruptedException {
        System.out.println("Page URL: " + getDriver().getCurrentUrl());
        System.out.println("Page title: " + getDriver().getTitle());
        System.out.println("Window handle: " + getDriver().getWindowHandle());
        System.out.println("All handles: " + getDriver().getWindowHandles());
        System.out.println("Page source: " + getDriver().getPageSource());
        Thread.sleep(1000);
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() throws InterruptedException {
        getDriver().navigate().back();
        Thread.sleep(1000);
        getDriver().navigate().forward();
        Thread.sleep(1000);
        getDriver().navigate().refresh();
        Thread.sleep(1000);
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String desiredResolutionReference) throws InterruptedException {
        int width;
        int height;
        switch (desiredResolutionReference.toLowerCase()) {
            case "phone" -> { width = 400; height = 768; }
            case "desktop" -> { width = 1024; height = 768; }
            default -> throw new Error("Unknown resolution reference: " + desiredResolutionReference);
        }
        getDriver().manage().window().setSize(new Dimension(width, height));
        Thread.sleep(1000);
    }

    @And("Submit the form")
    public void submitTheForm() {
        getDriver().findElement(By.xpath("//*[@id='formSubmit']")).click();
    }

    private void verifySummaryElementIsDisplayedAndHasValue(String summaryXPath, String value) {
        WebElement usernameElement = getDriver().findElement(By.xpath(summaryXPath));
        assertThat(usernameElement.isDisplayed()).isTrue();
        assertThat(usernameElement.getText()).isEqualTo(value);
    }

    //This method assumes that workingProfile has been associated with one of the existing presets
    @Then("I verify that submitted required fields got saved correctly")
    public void iVerifyThatSubmittedFieldsGotSavedCorrectly() throws InterruptedException {
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='username']", workingProfile.get("username"));
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='email']", workingProfile.get("email"));
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='password']", "[entered]");
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='name']", workingProfile.get("name"));
        verifySummaryElementIsDisplayedAndHasValue("//*[@id='quotePageResult']//*[@name='agreedToPrivacyPolicy']", "true");
        Thread.sleep(3000);
    }

    private void setWorkingProfile(String profileReference) {
        switch (profileReference.toLowerCase()) {
            case "john doe" -> workingProfile = profileOne;
            case "alan smith" -> workingProfile = profileTwo;
            default -> throw new Error("Unknown profile reference: " + profileReference);
        }
    }

    @When("I fill out required fields with {string} profile")
    public void iFillOutRequiredFieldsWithProfile(String profileReference) throws InterruptedException {
        setWorkingProfile(profileReference);
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(workingProfile.get("username"));
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(workingProfile.get("email"));
        getDriver().findElement(By.xpath("//input[@name='password']")).sendKeys(workingProfile.get("password"));
        getDriver().findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(workingProfile.get("password"));
        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys(workingProfile.get("name"));
        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        Thread.sleep(3000);
    }
}
