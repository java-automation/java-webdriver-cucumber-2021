package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsPickupPage extends Page {
    //constructor
    public UpsPickupPage() {
        url = "https://www.ups.com/ship/guided/pickup-service?tx=24968987274335228&loc=en_US";
    }

    @FindBy(id="nbsBalanceBarTotalCharges")
    private WebElement totalCharges;

    @FindBy(id = "Cheapest")
    private WebElement cheapestOption;

    public WebElement getTotalChargesElement() {
        return totalCharges;
    }

    public void selectCheapestOption() {
        cheapestOption.click();
    }
}
