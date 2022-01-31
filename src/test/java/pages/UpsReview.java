package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsReview extends UpsCreateShipment {

    public UpsReview() {
        setUrl("https://www.ups.com/ship/single-page");
        setTitle("UPS Shipping");
    }

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelShipmentButton;

    @FindBy(id = "nbsCancelShipmentWarningYes")
    private WebElement cancelShipmentWarningYes;


    public void cancelShipment() {
        //avoiding footer
        scrollToElementWithOffset(cancelShipmentButton, 100);
        cancelShipmentButton.click();
        waitForModalDialog();
        cancelShipmentWarningYes.click();
        waitForFirstLoad();
    }
}
