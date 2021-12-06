package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import support.TestContext;

import static support.TestContext.*;

public class GenericStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) {
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
            default:
                throw new Error("Unsupported page: " +page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
    }

    @And("I print logs to the Console")
    public void iPrintLogsToTheConsole()  throws InterruptedException {
        Thread.sleep(2000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        for(LogEntry log :logs){
            System.out.println(log);
        }
    }
}
