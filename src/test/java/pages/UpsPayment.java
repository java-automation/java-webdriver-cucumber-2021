package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpsPayment extends Page {
    public UpsPayment() {
        url = "https://www.ups.com/ship/guided/payment?tx=84985068604147304&loc=en_US";
    }

    @FindBy(xpath = "//label[@for='other-ways-to-pay-tile']")
    private WebElement payPalLabel;
    @FindBy(xpath = "//label[@class='ups-radio-custom-label ng-star-inserted']")
    private WebElement labelPayPal;

    public void selectPayPal() {
        wait.until(ExpectedConditions.visibilityOf(payPalLabel));
        clickWithJS(payPalLabel);
        wait.until(ExpectedConditions.visibilityOf(labelPayPal));
    }
}
