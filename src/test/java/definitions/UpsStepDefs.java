package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.UpsShipmentCreatePage;
import pages.UpsHomePage;
import support.ShipmentEndpoint;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getShipment;

public class UpsStepDefs {

    UpsHomePage homePage = new UpsHomePage();
    UpsShipmentCreatePage shipmentPage = new UpsShipmentCreatePage();
    ShipmentEndpoint origin;

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.gotoCreateShipmentPage();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        origin = getShipment(s -> s.getType().equals("commercial") && (s.getFullAddressLength() > 35));
        shipmentPage.fillOutOrigin(origin);
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        shipmentPage.submitShipmentForm();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        shipmentPage.verifyOriginSubmitted(origin);
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        ShipmentEndpoint shipment = getShipment(s -> s.getType().equals("residential"));
        shipmentPage.fillOutDestination(shipment);
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String choice) {
        if (choice.equalsIgnoreCase("confirm")) {
            shipmentPage.confirmResidential();
        }
    }

    @And("I set packaging type {string} and weight {string} lbs")
    public void iSetPackagingTypeAndWeightLbs(String type, String weight) {
        shipmentPage.setPackageTypeAndWeight(type, weight);
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        assertThat(shipmentPage.verifyTotalChargesPresent()).isTrue();
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        shipmentPage.selectCheapestDelivery();
    }

    @And("verify leaf present")
    public void waitLeafPresent() {
        new WebDriverWait(support.TestContext.getDriver(),5,200).until(driver ->
                support.TestContext.getDriver().findElement(
                org.openqa.selenium.By.xpath("//img[contains(@src,'Carbon_Neutral_hover')]")).isDisplayed());
    }
}
