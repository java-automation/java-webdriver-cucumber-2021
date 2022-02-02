package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpsOptions extends UpsCreateShipment {

    public UpsOptions() {
        setUrl("https://www.ups.com/ship/guided/options");
        setTitle("UPS Shipping");
    }

    @FindBy(id = "nbsShipmentDescription")
    private WebElement shipmentDescription;

    private final String saturdayDeliveryLocator = "//input[@id='nbsSaturdayDeliveryOptionBaseOptionSwitch']";

    @FindBy(xpath = saturdayDeliveryLocator)
    private WebElement saturdayDeliveryCheckbox;

    @FindBy(xpath = saturdayDeliveryLocator + "/../label")
    private WebElement saturdayDeliveryLabel;

    private final String directDeliveryLocator = "//input[@id='nbsDirectDeliveryOnlyOptionBaseOptionSwitch']";

    @FindBy(xpath = directDeliveryLocator)
    private WebElement directDeliveryCheckbox;

    @FindBy(xpath = directDeliveryLocator + "/../label")
    private WebElement directDeliveryLabel;

    public void fillShipmentDescription(String description) {
        shipmentDescription.sendKeys(description);
    }

    public boolean isSaturdayDeliveryAvailable() {
        try {
            return saturdayDeliveryLabel.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void selectSaturdayDelivery() {
        if (!saturdayDeliveryCheckbox.isSelected()) {
            saturdayDeliveryLabel.click();
            cycleSpinner();
        }
    }

    public void deselectSaturdayDelivery() {
        if (saturdayDeliveryCheckbox.isSelected()) {
            saturdayDeliveryLabel.click();
            cycleSpinner();
        }
    }

    public void selectDirectDelivery() {
        if (!directDeliveryCheckbox.isSelected()) {
            directDeliveryLabel.click();
            cycleSpinner();
        }
    }

    public void deselectDirectDelivery() {
        if (directDeliveryCheckbox.isSelected()) {
            directDeliveryLabel.click();
            cycleSpinner();
        }
    }
}
