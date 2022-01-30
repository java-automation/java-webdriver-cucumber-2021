package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import pages.QuoteForm;
import pages.UpsHome;

import java.util.logging.Level;

import static support.TestContext.getDriver;

public class GenericStepDefs {

    @Given("I go to {string} page")
    public void iGoToPage(String websiteReference) {
        getDriver().get(getURLUsingKnownReference(websiteReference));
    }

    @Given("I go to {string} page OOP")
    public void iGoToPageOOP(String pageReference) {
        switch (pageReference.toLowerCase()) {
            case "quote form" -> new QuoteForm().open();
            case "ups" -> new UpsHome().open();
            default -> throw new Error("Unknown URL reference: " + pageReference);
        }
    }

    static String getURLUsingKnownReference(String websiteReference) {
        return switch (websiteReference.toLowerCase()) {
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
            case "usps" -> "https://usps.com";
            case "unit converter" -> "https://www.unitconverters.net";
            case "calculator" -> "https://www.calculator.net";
            case "the internet" -> "https://the-internet.herokuapp.com";
            default -> throw new Error("Unknown URL reference: " + websiteReference);
        };
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println("Page URL: " + getDriver().getCurrentUrl());
        System.out.println("Page title: " + getDriver().getTitle());
        System.out.println("Window handle: " + getDriver().getWindowHandle());
        System.out.println("All handles: " + getDriver().getWindowHandles());
        //System.out.println("Page source: " + getDriver().getPageSource());
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
    public void iChangeResolutionTo(String desiredResolutionReference) {
        int width;
        int height;
        switch (desiredResolutionReference.toLowerCase()) {
            case "phone" -> { width = 400; height = 768; }
            case "desktop" -> { width = 1024; height = 768; }
            default -> throw new Error("Unknown resolution reference: " + desiredResolutionReference);
        }
        getDriver().manage().window().setSize(new Dimension(width, height));
    }

    @Then("I print logs to the console")
    public void iPrintLogsToTheConsole() {
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logs) {
            if (entry.getLevel().equals(Level.SEVERE)) throw new Error("Severe error: " + entry);
            else System.out.println(entry);
        }
    }
}
