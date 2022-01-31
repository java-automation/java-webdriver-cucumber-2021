package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsPayment extends UpsCreateShipment {

    public UpsPayment() {
        setUrl("https://www.ups.com/ship/guided/payment");
        setTitle("UPS Shipping");
    }

    @FindBy(xpath = "//input[@id='other-ways-to-pay-tile']/../label")
    private WebElement paypalOption;

    @FindBy(id = "nbsBackForwardNavigationReviewPrimaryButton")
    private WebElement reviewButton;


    public void selectPayPal() {
        paypalOption.click();
        cycleSpinner();
    }

    public void proceedToReview() {
        //avoiding footer
        scrollToElementWithOffset(reviewButton, 100);
        reviewButton.click();
        cycleSpinner();
    }
}
