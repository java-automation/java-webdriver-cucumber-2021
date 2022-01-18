package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Locale;
import java.util.logging.Level;
import static support.TestContext.getDriver;

public class GenericStepDef {
    @Given("I go to the {string} page")
    public void iGoToThePage(String page) {
        switch (page.toLowerCase()) {
            case "quote":
                getDriver().navigate().to("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().navigate().to("https://www.google.com/");
                break;
            case "usps":
                getDriver().navigate().to("https://www.usps.com/");
                break;
            case "converter":
                getDriver().navigate().to("https://www.unitconverters.net/");
                break;
            case "calculator":
                getDriver().navigate().to("http://www.calculator.net//");
                break;
            default:
                throw new Error("Unsupported page: " + page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
    }

    @And("I go back and forward, then refreshed the page")
    public void iGoBackAndForwardThenRefreshedThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }
    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(500);

        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER); // get console log
        // data type LogEntry

        for (LogEntry log : logs) {
            if (log.getLevel().equals(Level.SEVERE)) { // log level - warning, severe etc
                throw  new Error("Severe error: " +log);
            } else {
                System.out.println(log);
            }
        }
    }
}

