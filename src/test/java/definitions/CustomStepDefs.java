package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import static support.TestContext.getDriver;

public class CustomStepDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String websiteReference) {
        String address = switch (websiteReference.toLowerCase()) {
            case "google" -> "https://google.com";
            case "yahoo" -> "https://yahoo.com";
            case "bing" -> "https://bing.com";
            case "gibiru" -> "https://gibiru.com";
            case "duckduckgo" -> "https://duckduckgo.com";
            case "swisscows" -> "https://swisscows.com";
            case "search encrypt" -> "https://searchencrypt.com";
            case "startpage" -> "https://startpage.com";
            case "yandex" -> "https://yandex.com";
            case "boardreader" -> "https://boardreader.com";
            case "ecosia" -> "https://ecosia.org";
            case "quote form" -> "https://skryabin.com/market/quote.html";
            case "portnov campus" -> "https://portnov.com";
            case "portnov online" -> "https://portnov.net";
            case "hidden button" -> "http://uitestingplayground.com/scrollbars";
            default -> throw new Error("No known URL for this reference: " + websiteReference);
        };
        getDriver().get(address);
    }

    @And("I print page details")
    public void iPrintPageDetails() {
        System.out.println("Page URL: " + getDriver().getCurrentUrl());
        System.out.println("Page title: " + getDriver().getTitle());
        System.out.println("Window handle: " + getDriver().getWindowHandle());
        System.out.println("All handles: " + getDriver().getWindowHandles());
        System.out.println("Page source: " + getDriver().getPageSource());
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
        getDriver().navigate().refresh();
    }
}
