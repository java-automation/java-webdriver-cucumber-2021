package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import support.TestContext;

import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

import static support.TestContext.getDriver;

public class GenericStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page.toLowerCase()) {
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
            default:
                throw new Error("Unsupported page: " + page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        for(LogEntry log : logs) {
            if (log.getLevel().equals(Level.SEVERE)) {
                throw new Error("Severe error: " + log);
            } else {
                System.out.println(log);
            }
        }
    }
}