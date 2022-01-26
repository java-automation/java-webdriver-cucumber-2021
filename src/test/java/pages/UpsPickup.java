package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsPickup extends UpsCreateShipment {

    public UpsPickup() {
        setUrl("https://www.ups.com/ship/guided/pickup-service");
        setTitle("UPS Shipping");
    }


    @FindBy(id = "nbsBalanceBarTotalCharges")
    private WebElement totalCharges;


    public boolean isTotalChargesVisible() {
        return totalCharges.isDisplayed();
    }
}
