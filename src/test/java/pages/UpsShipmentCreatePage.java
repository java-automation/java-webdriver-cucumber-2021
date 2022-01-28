package pages;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import support.ShipmentEndpoint;

import static support.TestContext.getDriver;
import java.util.Map;

public class UpsShipmentCreatePage extends UpsBasePage {

    private UpsShipmentOriginSection shipmentOriginSection;
    private UpsShipmentDestSection shipmentDestSection;
    private UpsShipmentPackageKindSection shipmentPackageKindSection;
    private UpsShipmentHowSection shipmentHowSection;

    public UpsShipmentCreatePage() {
        url = "https://www.ups.com/ship/guided/origin?loc=en_US";
        urlRegExp = ".*www.ups.com/ship/guided/origin.*";
        closeCookiesDialogIfDisplayed();
        shipmentOriginSection = new UpsShipmentOriginSection();
        shipmentDestSection = new UpsShipmentDestSection();
        shipmentPackageKindSection = new UpsShipmentPackageKindSection();
        shipmentHowSection = new UpsShipmentHowSection();
    }

    // fields
    @FindBy(id = "nbsBackForwardNavigationContinueButton")
    private WebElement continueButton;

    @FindBy(id = "nbsBackForwardNavigationCancelShipmentButton")
    private WebElement cancelShipmentButton;

    @FindBy(xpath = "//page-validation-errors")
    private WebElement errorsSection;

    // methods
    public void fillOutOrigin(ShipmentEndpoint origin) {
        wait.until(driver -> shipmentOriginSection.isSwitchedTo());
        shipmentOriginSection.fillOutOrigin(origin);
    }

    public void submitShipmentForm() {
        try {
            continueButton.click();
        } catch (ElementClickInterceptedException e) {
     System.out.println("Continued via JavaScript click");
            ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView({" +
                    "behavior: 'auto',block: 'center',inline: 'center'});", continueButton);
            continueButton.click();
        }
    }

    public void verifyOriginSubmitted(ShipmentEndpoint origin) {
        wait.until(driver -> shipmentDestSection.isSwitchedTo());
        shipmentDestSection.verifyOrigin(origin);
    }

    public void fillOutDestination(ShipmentEndpoint dest) {
        wait.until(driver -> shipmentDestSection.isSwitchedTo());
        shipmentDestSection.fillOutDestination(dest);
    }

    public void confirmResidential() {
        shipmentDestSection.confirmResidential();
    }

    public void setPackageTypeAndWeight(String type, String weight) {
        shipmentPackageKindSection.setPackageTypeAndWeight(type, weight);
    }

    public boolean verifyTotalChargesPresent() {
        wait.until(driver -> shipmentHowSection.isSwitchedTo());
        return shipmentHowSection.verifyTotalChargesPresent();
    }

    public void selectCheapestDelivery() {
        wait.until(driver -> shipmentHowSection.isSwitchedTo());
        shipmentHowSection.selectCheapestOption();
    }
}
