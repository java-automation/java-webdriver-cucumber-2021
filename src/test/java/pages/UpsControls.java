package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpsControls extends Page {

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(id = "nbsBackForwardNavigationBackButton")
    private WebElement backButton;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelButton;

    @FindBy(id = "total-charges-spinner")
    WebElement totalCharges;

    public boolean areTotalChargesAppear() {
        try {
            getWait().until(ExpectedConditions.visibilityOf(totalCharges));
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
        return !totalCharges.getText().isEmpty();
    }

    public void submit() {
        continueButton.click();
    }

    public void back() {
        backButton.click();
    }

    public void cancel() {
        cancelButton.click();
    }
}