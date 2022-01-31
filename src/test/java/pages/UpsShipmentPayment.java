package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsShipmentPayment extends UpsShipmentPage {

    public UpsShipmentPayment() {
        urlRegExp = ".*www.ups.com/ship/guided/payment.*";
    }

    // fields
    @FindBy(xpath = "//input[@id='payment-card-tile']")
    private WebElement creditCardRadiobutton;

    @FindBy(xpath = "//input[@id='payment-card-tile']/following-sibling::label")
    private WebElement creditCardLabel;

    @FindBy(xpath = "//input[@id='other-ways-to-pay-tile']")
    private WebElement payPalRadiobutton;

    @FindBy(xpath = "//input[@id='other-ways-to-pay-tile']/following-sibling::label")
    private WebElement payPalLabel;

    // methods
    public void selectPayPal() {
        waitForUrlMatch();
        payPalLabel.click();
    }

}
