package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;

import static support.TestContext.getDriver;

public class GenericStepDefs {
    @Given("I go to {string} page")
    public void iNavigateToPage(String page) {
        switch (page) {
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            case "google":
                getDriver().get("https://google.com");
                break;
            default:
                throw new Error("Sorry, this page " + page + " is not supported" );
        }
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
        System.out.println(getDriver().getWindowHandle());
    }

    @And("I go back and forward and refresh the page")
    public void iGoBackAndForwardAndRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String device) {
        switch (device) {
            case "phone":
                getDriver().manage().window().setSize(new Dimension(400, 768));
                break;
            case "desktop":
                getDriver().manage().window().setSize(new Dimension(1024, 768));
                break;
            default:
                throw new Error("Unsupported device. Please enter phone or desktop");
        }
    }
}
