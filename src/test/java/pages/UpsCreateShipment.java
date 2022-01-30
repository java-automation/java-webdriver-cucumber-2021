package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static support.TestContext.getDriver;

public class UpsCreateShipment extends Page {

    private final LocalStorage localStorage;

    public UpsCreateShipment() {
        setUrl("https://www.ups.com/ship");
        setTitle("UPS Shipping");
        localStorage = ((WebStorage) getDriver()).getLocalStorage();
    }


    @FindBy(css = "origin .ups-section")
    private WebElement originSection;

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(css = "img[src*='ajax-loader']")
    private List<WebElement> spinner;


    public void waitForFirstLoad() {
        waitForSpinnerToBeAbsent();
        getWait().until(ExpectedConditions.visibilityOf(originSection));
    }

    public void submitForm() {
        waitForLocalStorageUpdate();
        scrollToElementWithOffset(continueButton, 100);
        continueButton.click();
    }

    protected void sendKeysToCorrectAddressField(List<WebElement> toBeInvisible, List<WebElement> toBeVisible, String address) {
        getWait().until(driver -> toBeInvisible.stream().findFirst().isEmpty());
        toBeVisible.stream().findFirst().ifPresent(element -> element.sendKeys(address));
    }

    /*
    This method was created is to bypass a bug and to make sure that user data gets saved correctly on each step before
    proceeding to the next one. Seems like there is constant polling going on which updates the storage every ~150-200ms.
    If user or webdriver clicks on "continue" before update - last entry is not saved, even though there is no complain
    about required fields or missing information from the web app.

    There is key in local storage that gets updated regularly as well. It's called GULP_SC2 and could be Gulp related.
    One idea was to create a custom wait that would wait for the key update before proceeding, but it was unstable as well.
    You get various errors related to local storage and the wait times out. Seems like Thread.sleep is more stable.
     */
    protected void waitForLocalStorageUpdate() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        String localStorageValue = localStorage.getItem("GULP_SC2");
//        getWait().until(value -> !localStorageValue.equals(localStorage.getItem("GULP_SC2")));
    }

    protected void waitForSpinnerToBeAbsent() {
        getWait().until(driver -> spinner.stream().findFirst().isEmpty());
    }

    protected void waitForSpinnerToBeInvisible() {
        getWait().until(driver -> spinner.stream().findFirst().filter(WebElement::isDisplayed).isEmpty());
    }

    protected void waitForOptionsAvailabilityResponse() {
        getWait().until(log -> getLogs(LogType.PERFORMANCE)
                .stream()
                .filter(entry -> entry.getMessage().contains("Network.responseReceived"))
                .filter(entry -> entry.getMessage().contains("https://www.ups.com/ship/api/LookupAndValidation/GetOptionsAvailability"))
                .filter(entry -> entry.getMessage().contains("application/json"))
                .toList().size() > 0);
    }

    protected void waitForRateShipmentResponse() {
        getWait().until(log -> getLogs(LogType.PERFORMANCE)
                .stream()
                .filter(entry -> entry.getMessage().contains("Network.responseReceived"))
                .filter(entry -> entry.getMessage().contains("https://www.ups.com/ship/api/RatingAndProcessing/RateShipmentForAllServices"))
                .filter(entry -> entry.getMessage().contains("application/json"))
                .toList().size() > 0);
    }
}
