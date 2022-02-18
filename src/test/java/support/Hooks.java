package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static support.TestContext.*;

public class Hooks {

    @Before(order = 0)
    public void scenarioStart() {
        TestContext.initialize();
        TestContext.setTimestamp();
        getDriver().manage().timeouts().pageLoadTimeout(getConfig().pageLoadTimeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(getConfig().implicitTimeout, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();
    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        TestContext.teardown();
    }

    @After(value = "@cleanup_position")
    public void cleanupPosition(Scenario scenario) {
        if (scenario.isFailed()) {
            RestClient client = new RestClient();
            client.login(getData("recruiter", "careers"));
            int id = client.getPositionIdByTitle(getPositionDataFromFile("automation", "positions").get("title"));
            client.deletePositionById(id);
        }
    }
    @Before(value = "@create_position")
    public void createPosition(Scenario scenario) {
        if (scenario.isFailed()) {
            RestClient client = new RestClient();
            client.login(getData("recruiter", "careers"));
            client.createPosition(getPositionDataFromFile("automation", "positions"));
        }
    }
}
