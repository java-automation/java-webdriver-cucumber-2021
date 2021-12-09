package definitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.*;
import java.util.logging.*;
import static support.TestContext.*;

public class GenericStepDefs {

    Dimension phoneDimension = new Dimension(400, 768);
    Dimension desktopDimention = new Dimension(1024, 768);

    @Given("I go to {string} page and print details")
    public void iGoToPage(String page) {
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
            if(log.getLevel().equals(Level.WARNING)) {
                throw new Error("Warning error: " + log);
            } else if(log.getLevel().equals(Level.SEVERE)) {
                throw new Error("Severe error: " + log);
            } else {
                System.out.println(log);
            }
        }
    }
    @And("I wait for {int} seconds")
    public void iWaitForSec(int sec) throws Exception {
        Thread.sleep(sec * 1000);
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String mode) throws InterruptedException {
        switch (mode) {
            case "phone":
                getDriver().manage().window().setSize(phoneDimension);
                Thread.sleep(3000);
                break;
            case "desktop":
                getDriver().manage().window().setSize(desktopDimention);
                Thread.sleep(3000);
                break;
            default:
                throw new Error("Unsupported mode: " + mode);
        }
    }
}
