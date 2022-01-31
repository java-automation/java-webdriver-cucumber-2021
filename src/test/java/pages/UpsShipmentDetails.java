package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UpsShipmentDetails extends UpsShipmentPage {

    public UpsShipmentDetails() {
        urlRegExp = ".*www.ups.com/ship/guided/options.*";
    }

    // fields
    @FindBy(xpath = "//input[@name='nbsShipmentDescription']")
    private WebElement description;

    @FindBy(css = ".ups-toggle_list.ups-form_group > *")
    private List<WebElement> options;

    @FindBy(xpath = "//input[contains(@id,'DirectDeliveryOnlyOption')]")
    private WebElement directDeliveryCheckbox;

    @FindBy(xpath = "//input[contains(@id,'DirectDeliveryOnlyOption')]/following-sibling::label")
    private WebElement directDeliveryLabel;

    @FindBy(xpath = "//saturday-delivery-option")
    private List<WebElement> saturdayDeliveryOptions;

    @FindBy(xpath = "//input[contains(@id,'SaturdayDeliveryOption')]")
    private WebElement saturdayDeliveryCheckbox;

    @FindBy(xpath = "//input[contains(@id,'SaturdayDeliveryOption')]/following-sibling::label")
    private WebElement saturdayDeliveryLabel;

    // methods
    public void checkSaturdayDeliveryType() {
        if (saturdayDeliveryOptions.size() > 0 && !saturdayDeliveryCheckbox.isSelected()) {
            saturdayDeliveryLabel.click();
        }
    }

    public void checkDirectDeliveryType() {
        if (!directDeliveryCheckbox.isSelected()) {
            directDeliveryLabel.click();
        }
    }

    public void setDescription(String text) {
        description.sendKeys(text);
    }
}
