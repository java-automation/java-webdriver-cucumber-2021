package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import support.TestContext;

import java.util.logging.Level;

import static support.TestContext.*;

public class GenericStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page.toLowerCase()) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            default:
                throw new Error("Unsupported Page: " + page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
    }

//    @And("I print logs to the console")
//    public void iPrintLogsToTheConsole() throws InterruptedException {
//        Thread.sleep(2000);
//
//        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
//
//        for(LogEntry log : logs) {
//            if (log.getLevel().equals(Level.SEVERE)) {
//                throw new Error("Severe error: " + log);
//            } else {
//                System.out.println(log);
//            }
//        }
//    }
}
