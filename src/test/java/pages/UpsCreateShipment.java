package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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

    @FindBy(css = ".modal-dialog")
    private List<WebElement> modalWindow;

    @FindBy(id = "total-charges-spinner")
    private WebElement totalCharges;

    @FindBy(xpath = "//div[@class='ups-progress_bar']//div[contains(@class,'ups-progress_current')]/../div[@class='ups-progress_name']")
    private WebElement progressStep;


    public void waitForFirstLoad() {
        waitForSpinnerToBeAbsent();
        getWait().until(ExpectedConditions.visibilityOf(originSection));
    }

    public void submitForm() {
        waitForLocalStorageUpdate();
        /*
        Scrolling past continue button because this method is used on multiple pages and eventually footer shows up
        that intercepts the click.
         */
        scrollToElementWithOffset(continueButton, 100);
        continueButton.click();
    }

    /*
    This footer shows up for the first time on pickup page, but later if you go back it stays up and the price
    will adjust automatically based on your actions. Therefore, bringing it up to general workflow class and
    putting it in a try/catch - it maybe both present and absent on the same page, depends on user actions.
     */
    public boolean isTotalChargesVisible() {
        try {
            getWait().until(ExpectedConditions.visibilityOf(totalCharges));
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
        return !totalCharges.getText().isEmpty();
    }

    public String getTotalChargesText() {
        return totalCharges.getText().trim();
    }

    public String getProgressStepName() {
        return progressStep.getText();
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

    There is a key in local storage that gets updated regularly as well. It's called GULP_SC2 and could be Gulp related.
    One idea was to create a custom wait that would wait for the key update before proceeding, but it was unstable as well.
    You get various errors related to local storage and the wait times out. Seems like Thread.sleep is more stable.

    If this update bug gets fixed (unlikely) - can remove the method completely.
     */
    protected void waitForLocalStorageUpdate() {
        try {
            Thread.sleep(300);
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

    protected void waitForSpinnerToBeVisible() {
        getWait().until(driver -> spinner.stream().findFirst().filter(WebElement::isDisplayed).isPresent());
    }

    protected void cycleSpinner() {
        waitForSpinnerToBeVisible();
        waitForSpinnerToBeInvisible();
    }

    protected void waitForModalDialog() {
        getWait().until(driver -> modalWindow.stream().findFirst().isPresent());
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
