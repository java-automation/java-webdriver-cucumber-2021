package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given; // referencing import of annotation Given
import org.openqa.selenium.Dimension;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import support.TestContext; // instead of typing every time TestContext.getDriver() we do import, help from the compiler/editor

import java.util.logging.Level;

import static support.TestContext.getDriver;

public class GenericStepDefs {
    @Given("I go to {string} page")// link to our cucumber step
    public void iGoToPage(String page) {
        switch (page.toLowerCase()) {
            case "quote" ->
                    //TestContext.getDriver().navigate().to("https://skryabin.com/market/quote.html");// one way to get to URL
                    getDriver().get("https://skryabin.com/market/quote.html");
            case "google" -> getDriver().get("https://google.com");
            case "yahoo" -> getDriver().get("https://www.yahoo.com");
            case "usps" -> getDriver().get("https://www.usps.com/");
            default -> throw new Error("Unsupported page " + page);
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandles());
    }

    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(500);
        LogEntries logs=getDriver().manage().logs().get(LogType.BROWSER);
        for (LogEntry log : logs){
            if(log.getLevel().equals(Level.SEVERE)){
                throw new Error("SEVERE error: " + log);
            }else{
            System.out.println(log);
        }

    }
}

    @And("I navigate back")
    public void iNavigateBack() {
        getDriver().navigate().back();
    }

    @And("I navigate forward")
    public void iNavigateForward() {
        getDriver().navigate().forward();
    }

    @And("I refresh page")
    public void iRefreshPage() {
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String device) {
        switch (device) {
            case ("phone") -> getDriver().manage().window().setSize(new Dimension(400,768));
            case ("desktop") -> getDriver().manage().window().setSize(new Dimension(1024,768));
            default -> throw new Error("Provide correct type of device");
        }

    }


}
