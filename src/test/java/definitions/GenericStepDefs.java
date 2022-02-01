package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import pages.CareersHome;
import pages.QuoteForm;
import pages.UpsHome;

import java.util.logging.Level;

import static support.TestContext.getDriver;

public class GenericStepDefs {

    @Given("I go to {string} page oop")
    public void iGoToPageOop(String page) {
        switch (page.toLowerCase()) {
            case "quote":
                new QuoteForm().open();
                break;
            case "ups":
                new UpsHome().open();
                break;
            case "careers":
                new CareersHome().open();
                break;
            default:
                throw new Error("Unsupported page: " + page);
        }
    }

    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        getDriver().manage().window().maximize();
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://google.com");
                break;
            case "yahoo":
                getDriver().get("https://yahoo.com");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            case "unitconverters", "converter":
                getDriver().get("https://www.unitconverters.net/");
                break;
            case "calculator":
                getDriver().get("http://www.calculator.net/");
                break;
            case "ups":
                getDriver().get("https://www.ups.com/us/en/Home.page?");
                break;
            case "careers":
                getDriver().get("https://skryabin-careers.herokuapp.com/");
                break;
            default:
                throw new Error("Unsupported page: " + page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
        System.out.println("Here is my cookie: " + getDriver().manage().getCookies());
        // getDriver().manage().deleteAllCookies();
        // System.out.println("Here is my cookie after deleting All cookie: " + getDriver().manage().getCookies());
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
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
}
