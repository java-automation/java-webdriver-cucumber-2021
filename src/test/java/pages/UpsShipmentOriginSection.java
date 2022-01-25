package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class UpsShipmentOriginSection extends UpsBasePage {

    private UpsShipmentForm originForm = new UpsShipmentForm();

    public UpsShipmentOriginSection() {
        urlRegExp = ".*www.ups.com/ship/guided/origin.*";
    }

    // fields
    @FindBy(xpath = "//origin")
    private WebElement originFormWrapper;

    @FindBy(xpath = "//input[@name='agent_emailCheckbox']")
    private WebElement sendStatusUpdates;

    @FindBy(name = "returnSwitch")
    private WebElement returnSwitch;

    // methods
    public void fillOutOrigin(Map<String,String> origin) {
        originForm.fillOutForm(origin.get("country"), origin.get("name"), origin.get("address1"),
                               origin.get("city"), origin.get("state"), origin.get("zipCode"),
                               origin.get("email"), origin.get("phone"), origin.get("type"));
    }

    public boolean isSwitchedTo() {
        return originForm.isSwitchedTo();
    }

}
