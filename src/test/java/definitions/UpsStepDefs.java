package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import support.ShipmentEndpoint;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class UpsStepDefs {

    UpsHomePage homePage = new UpsHomePage();
    UpsShipmentOriginSection shipmentOriginSection = new UpsShipmentOriginSection();
    UpsShipmentDestSection shipmentDestSection = new UpsShipmentDestSection();
    UpsShipmentPackageKindSection shipmentPackageKindSection = new UpsShipmentPackageKindSection();
    UpsShipmentHowSection shipmentHowSection = new UpsShipmentHowSection();

    List<ShipmentEndpoint> shipmentEndpoints = getData(ShipmentEndpoint[].class,"shipmentEndpoints", "ups");
    Map<String,String> packageData = getData("package","ups");
    ShipmentEndpoint origin;

    private ShipmentEndpoint getShipment(Predicate<ShipmentEndpoint> condition) {
        return shipmentEndpoints.stream().filter(condition).findFirst().orElseThrow();
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.openShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        origin = getShipment(s -> s.getType().equals("commercial") && (s.getSingleLineAddressLength() > 35));
        shipmentOriginSection.fillOutOrigin(origin);
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        shipmentOriginSection.submitShipmentForm();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        shipmentDestSection.verifyOrigin(origin);
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        ShipmentEndpoint shipment = getShipment(s -> s.getType().equals("residential"));
        shipmentDestSection.fillOutDestination(shipment);
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String choice) {
        if (choice.equalsIgnoreCase("confirm")) {
            shipmentDestSection.confirmResidential();
        }
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        shipmentPackageKindSection.setPackageTypeAndWeight(packageData.get("type"),packageData.get("weight"));
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        assertThat(shipmentHowSection.verifyTotalChargesPresent()).isTrue();
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        shipmentHowSection.selectCheapestOption();
    }

    @And("verify leaf present")
    public void waitLeafPresent() {
        new WebDriverWait(support.TestContext.getDriver(),5,200).until(driver ->
                support.TestContext.getDriver().findElement(
                org.openqa.selenium.By.xpath("//img[contains(@src,'Carbon_Neutral_hover')]")).isDisplayed());
    }
}
