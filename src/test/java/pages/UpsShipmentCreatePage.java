package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

public class UpsShipmentCreatePage extends UpsBasePage {

    private UpsShipmentOriginSection shipmentOriginSection;
    private UpsShipmentDestSection shipmentDestSection;
    private UpsShipmentPackageKindSection shipmentPackageKindSection;

    public UpsShipmentCreatePage() {
        url = "https://www.ups.com/ship/guided/origin?loc=en_US";
        urlRegExp = ".*www.ups.com/ship/guided/origin.*";
        closeCookiesDialogIfDisplayed();
        shipmentOriginSection = new UpsShipmentOriginSection();
        shipmentDestSection = new UpsShipmentDestSection();
        shipmentPackageKindSection = new UpsShipmentPackageKindSection();
    }

    // fields
    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelShipmentButton;

    // methods
    public void fillOutOrigin(Map<String,String> origin) {
        wait.until(driver -> shipmentOriginSection.isSwitchedTo());
        shipmentOriginSection.fillOutOrigin(origin);
    }

    public void submitShipmentForm() {
        continueButton.click();
    }

    public void verifyOriginSubmitted(Map<String,String> origin) {
        wait.until(driver -> shipmentDestSection.isSwitchedTo());
        shipmentDestSection.verifyOrigin(origin);
    }

    public void fillOutDestination(Map<String,String> dest) {
        wait.until(driver -> shipmentDestSection.isSwitchedTo());
        shipmentDestSection.fillOutDestination(dest);
    }

    public void confirmResidential() {
        shipmentDestSection.confirmResidential();
    }

    public void setPackageTypeAndWeight(String type, String weight) {
        shipmentPackageKindSection.setPackageTypeAndWeight(type, weight);
    }
}
