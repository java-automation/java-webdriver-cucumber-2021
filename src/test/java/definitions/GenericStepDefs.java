package definitions;

import io.cucumber.java.en.*;
import io.cucumber.java.it.*;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.*;
import org.testng.reporters.jq.*;

import java.util.*;
import java.util.logging.*;
import static support.TestContext.*;


public class GenericStepDefs {

    Dimension phoneDimension = new Dimension(400, 768);
    Dimension desktopDimention = new Dimension(1024, 768);

    Page Page = new Page();


    @Given("I go to {string} page and print details")
    public void iGoToPage(String page) {
        switch (page.toLowerCase()) {
            case "quote":
                Page.open("https://skryabin.com/market/quote.html");
                break;
            case "google":
                Page.open("https://www.google.com/");
                break;
            case "usps":
                Page.open("https://www.usps.com/");
                break;
            case "ups":
               Page.open("https://www.ups.com/us/en/Home.page");
               break;
            case "unitconverters":
                Page.open("https://www.unitconverters.net/");
                break;
            case "calculator":
               Page.open("https://www.calculator.net/");
                break;
            case "careers":
                Page.open("https://skryabin-careers.herokuapp.com/");
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
    @And("I switch to a new window")
    public static void iSwitchToANewWindow() {
        Iterator<String> iterator = getDriver().getWindowHandles().iterator();
        String newWindow = iterator.next();
        while(iterator.hasNext()) {
            newWindow = iterator.next();
        }
        getDriver().switchTo().window(newWindow);
    }
}
