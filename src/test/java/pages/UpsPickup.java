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

    @FindBy(xpath = "//section[@id='serviceList']//div[@id='Cheapest']/label")
    private WebElement cheapestOption;


    public boolean isTotalChargesVisible() {
        return totalCharges.isDisplayed();
    }

    public String getTotalChargeValue() {
        return totalCharges.getText();
    }

    public String getCheapestOptionCardText() {
        return cheapestOption.getText();
    }

    public void selectCheapestOption() {
        waitForSpinnerToBeInvisible();
        scrollToElementWithOffset(cheapestOption, 100);
        cheapestOption.click();
        waitForSpinnerToBeInvisible();
    }
}
