package definitions;

import io.cucumber.java.en.And;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.logging.Level;

import static support.TestContext.getDriver;

public class GenericStepDefs {
    @And("I print logs to the console")
    public void iPrintLogsToTheConsole() throws InterruptedException {
        Thread.sleep(1000);
        LogEntries logs = getDriver().manage().logs().get(LogType.BROWSER);
        for(LogEntry log : logs) {
            if (log.getLevel().equals(Level.SEVERE)) {
//                throw new Error("Severe error: " + log);
                System.out.println("Severe error: " + log);
            } else {
                System.out.println(log);
            }
        }
    }
}
