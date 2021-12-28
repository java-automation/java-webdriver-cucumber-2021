package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.Locale;
import java.util.logging.Level;

import static support.TestContext.getDriver;

public class GenericStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page.toLowerCase()) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
             // TestContext.getDriver().get("https://skryabin.com/market/quote.html"); - то же самое
             // TestContext.getDriver().navigate().to("https://skryabin.com/market/quote.html"); - то же самое
                break;
            case "google":
                getDriver().get("https://google.com");
                break;
            case "usps":
                getDriver().get("https://www.usps.com/");
                break;
            case "calculator":
                getDriver().get("https://www.calculator.net/");
                break;
            default:
                throw new Error("Unsupported page: " + page);
        }
        System.out.println("Current URL: " + getDriver().getCurrentUrl());
        System.out.println("Title: " + getDriver().getTitle());
        System.out.println("Window handlers: " + getDriver().getWindowHandles());
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000); // wait 1 second
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER); // it's an array
        for (LogEntry log : logs) {
            if (log.getLevel().equals(Level.SEVERE)){
                throw new Error("Severe error: " + log);
            } else
                System.out.println(log);
        }
    }

    @And("I go to {string} page and print details")
    public void iGoToPageAndPrintDetails(String page) {
        switch (page) {
            case "quote":
                getDriver().navigate().to("https://skryabin.com/market/quote.html");
                System.out.println(getDriver().getCurrentUrl());
                break;
            case "google":
                getDriver().navigate().to("https://www.google.com/");
                System.out.println(getDriver().getCurrentUrl());
                break;
            default:
                throw new Error("Unsupported page: " + page);
        }
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String device) {
        switch (device) {
            case "phone":
                getDriver().manage().window().setSize(new Dimension(400, 800));
                break;
            case "desktop":
                getDriver().manage().window().setSize(new Dimension(1280, 1024));
                break;
            default:
                throw new Error("Unsupported devices: " + device);
        }

    }
}
