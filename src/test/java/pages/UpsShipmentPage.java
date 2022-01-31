package pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Supplier;

public class UpsShipmentPage extends UpsBasePage {

    public UpsShipmentPage() {
        closeCookiesDialogIfDisplayed();
    }

    // fields
    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    protected WebElement continueButton;

    @FindBy(id = "nbsBackForwardNavigationReviewPrimaryButton")
    protected WebElement reviewButton;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    protected WebElement cancelShipmentButton;

    @FindBy(xpath = "//page-validation-errors")
    protected WebElement errorsSection;

    @FindBy(xpath = "//span[@id='total-charges-spinner']")
    protected WebElement totalCharges;

    @FindBy(xpath = "//span[@id='total-charges-spinner']//spinner/img")
    protected WebElement totalChargesSpinner;

    // modal dialog container
    @FindBy(xpath = "//div[contains(@class,'modal-content')]")
    protected WebElement modalDialog;

    // fields of the modal dialog to cancel shipment
    @FindBy(id = "nbsCancelShipmentWarningYes")
    private WebElement yes;

    @FindBy(id = "nbsCancelShipmentWarningNo")
    private WebElement no;

    // methods
    public void submitShipmentForm() {
        clickTryThenJS(continueButton);
    }

    public void submitShipmentFormForReview() {
        clickTryThenJS(reviewButton);
    }

    public void waitModalDialogDisplayed() {
        wait.withMessage("Modal dialog on " + getClass() + " page did not appear.").until(driver -> modalDialog.isDisplayed());
        wait.withMessage((Supplier<String>) null);
    }

    public void cancelShipmentForm() {
        clickTryThenJS(cancelShipmentButton);
        waitModalDialogDisplayed();
        yes.click();
    }

    public boolean verifyTotalChargesPresent() {
        return getTotalCharges().matches(".*\\$\\d+.\\d+.*");
    }

    public String getTotalCharges() {
        waitForUrlMatch();
        wait.until(ExpectedConditions.invisibilityOf(totalChargesSpinner));
        return totalCharges.getText();
    }

    public String getTotalChargesWithSpinnerWait() {
        waitForUrlMatch();
        // waiting explicitTimeOut of time set in config.yml or till spinner visible
        try {
            wait.until(ExpectedConditions.visibilityOf(totalChargesSpinner));
        } catch (TimeoutException e) {}
        wait.until(ExpectedConditions.invisibilityOf(totalChargesSpinner));
        return totalCharges.getText();
    }

}
