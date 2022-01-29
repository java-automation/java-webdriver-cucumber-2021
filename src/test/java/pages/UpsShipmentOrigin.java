package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.ShipmentEndpoint;

public class UpsShipmentOrigin extends UpsShipmentPage {

    private UpsShipmentForm originForm = new UpsShipmentForm();

    public UpsShipmentOrigin() {
        url = "https://www.ups.com/ship/guided/origin";
        urlRegExp = ".*www.ups.com/ship/guided/origin.*";
    }

    // fields
    @FindBy(xpath = "//input[@name='agent_emailCheckbox']")
    private WebElement sendStatusUpdates;

    @FindBy(name = "returnSwitch")
    private WebElement returnSwitch;

    // methods
    public boolean originFormDisplayed() {
        return urlMatches() & originForm.formDisplayed();
    }

    public void fillOutOrigin(ShipmentEndpoint origin) {
        wait.until(driver -> originFormDisplayed());
        originForm.fillOutForm(origin);
    }
}
