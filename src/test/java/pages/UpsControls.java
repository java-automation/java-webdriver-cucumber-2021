package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpsControls extends Page {

    public final By CHEAPEST_PRICE_SELECT = By.xpath("//div[@id='Cheapest']//span[@class='serviceCard_header-icon ups-icon-checkcircle-solid']");

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    public WebElement continueButton;
    @FindBy(id = "nbsBackForwardNavigationReviewPrimaryButton")
    public WebElement reviewButton;
    @FindBy(id = "nbsBackForwardNavigationBackButton")
    public WebElement backButton;
    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    public WebElement cancelShipment;
    @FindBy(xpath = "//div[@class='modal-content']//button[@id='nbsCancelShipmentWarningYes']")
    private WebElement buttonYesToCancelModalWindow;

    public void submit() {
        wait.until(ExpectedConditions.presenceOfElementLocated(CONTINUE_BUTTON_XPATH)).click();
    }

    public void review() {
        wait.until(ExpectedConditions.visibilityOf(reviewButton));
        clickWithJS(reviewButton);
    }

    public void back() {
        wait.until(ExpectedConditions.visibilityOf(backButton)).click();
    }

    public void cancel() {
        wait.until(ExpectedConditions.visibilityOf(cancelShipment));
        clickWithJS(cancelShipment);
        wait.until(ExpectedConditions.visibilityOf(buttonYesToCancelModalWindow));
        clickWithJS(buttonYesToCancelModalWindow);
    }

}
