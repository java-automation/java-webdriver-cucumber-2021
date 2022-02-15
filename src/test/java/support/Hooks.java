package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

import static support.TestContext.getConfig;
import static support.TestContext.getDriver;

//import static support.TestContext.getConfig;

public class Hooks {

    @Before(order = 0)
    public void scenarioStart() {
//        TestContext.initialize();
//        getDriver().manage().deleteAllCookies();

        TestContext.initialize();
      //  getDriver().manage().timeouts().pageLoadTimeout(getConfig().pageLoadTimeout, TimeUnit.SECONDS);
      //  getDriver().manage().timeouts().implicitlyWait(getConfig().implicitTimeout, TimeUnit.SECONDS);

        getDriver().manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
       // getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        TestContext.setTimestamp();
        getDriver().manage().timeouts().pageLoadTimeout(getConfig().pageLoadTimeout, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(getConfig().implicitTimeout, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();

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
