package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

import static support.TestContext.getDriver;

public class UpsShipmentCreatePage {

    private UpsShipmentOriginSection shipmentOriginSection;
    private UpsShipmentDestSection shipmentDestSection;
    private UpsShipmentPackageKindSection shipmentPackageKindSection;

    private WebDriverWait wait = new WebDriverWait(getDriver(),10,200);

    public UpsShipmentCreatePage() {
        PageFactory.initElements(getDriver(),this);
        shipmentOriginSection = new UpsShipmentOriginSection();
        shipmentDestSection = new UpsShipmentDestSection();
        shipmentPackageKindSection = new UpsShipmentPackageKindSection();
    }

    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelShipmentButton;

    // methods
    public void fillOutOrigin(Map<String,String> origin) {
        wait.until(driver -> shipmentOriginSection.isSwitchedTo());
        shipmentOriginSection.fillOutOrigin(origin.get("country"),origin.get("name"),origin.get("address1"),
                                            origin.get("city"),origin.get("state"),origin.get("zipCode"),
                                            origin.get("email"),origin.get("phone"),origin.get("type"));
    }

    public void submitShipmentForm() {
        continueButton.click();
    }

    public void verifyOriginSubmitted(Map<String,String> origin) {
        wait.until(driver -> shipmentDestSection.isSwitchedTo());
        shipmentDestSection.verifyOrigin(origin);
    }

    public void fillOutDestination(Map<String,String> origin) {
        wait.until(driver -> shipmentDestSection.isSwitchedTo());
        shipmentDestSection.fillOutOrigin(origin.get("country"), origin.get("name"), origin.get("address1"),
                origin.get("city"), origin.get("state"), origin.get("zipCode"),
                origin.get("email"), origin.get("phone"), origin.get("type"));
    }

    public void confirmResidential() {
        shipmentDestSection.confirmResidential();
    }

    public void setPackageTypeAndWeight(String type, String weight) {
        shipmentPackageKindSection.setPackageTypeAndWeight(type, weight);
    }
}
