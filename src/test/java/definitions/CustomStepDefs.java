package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Dimension;

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
    public void iPrintPageDetails() throws InterruptedException {
        System.out.println("Page URL: " + getDriver().getCurrentUrl());
        System.out.println("Page title: " + getDriver().getTitle());
        System.out.println("Window handle: " + getDriver().getWindowHandle());
        System.out.println("All handles: " + getDriver().getWindowHandles());
        System.out.println("Page source: " + getDriver().getPageSource());
        Thread.sleep(1000);
    }

    @And("I go back and forward, then refresh the page")
    public void iGoBackAndForwardThenRefreshThePage() throws InterruptedException {
        getDriver().navigate().back();
        Thread.sleep(1000);
        getDriver().navigate().forward();
        Thread.sleep(1000);
        getDriver().navigate().refresh();
        Thread.sleep(1000);
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String desiredResolutionReference) throws InterruptedException {
        int width;
        int height;
        switch (desiredResolutionReference.toLowerCase()) {
            case "phone" -> { width = 400; height = 768; }
            case "desktop" -> { width = 1024; height = 768; }
            default -> throw new Error("Unknown resolution reference: " + desiredResolutionReference);
        }
        getDriver().manage().window().setSize(new Dimension(width, height));
        Thread.sleep(1000);
    }
}
