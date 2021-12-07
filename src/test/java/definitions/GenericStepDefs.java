package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.logging.Level;

import static support.TestContext.getDriver;

public class GenericStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
        switch (page){
            case "yahoo":
                getDriver().navigate().to("https://yahoo.com");
            case "google":
                getDriver().navigate().to("https://google.com");
            case "quote":
                getDriver().navigate().to("https://skryabin.com/market/quote.html");
                break;
            default:
                throw new Error("Unsupperted page " + page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);

        for(LogEntry log:logs){
            System.out.println(log);
        }
    }
}
