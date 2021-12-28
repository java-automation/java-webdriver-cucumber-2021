package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.Time;

import static support.TestContext.getDriver;

public class Hooks {

    @Before(order = 0)
    public void scenarioStart() {
        TestContext.initialize();
//        getDriver().manage().timeouts().implicitlyWait(500, Time); //на случай, если выскакивает ошибка из-за того, что элемент не успевает загрузиться
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
}
