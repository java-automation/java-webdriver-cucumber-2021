package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class UpsStepDefs {

    UpsHome homePage = new UpsHome();
    UpsOrigin originPage = new UpsOrigin();
    UpsDestination destinationPage = new UpsDestination();
    UpsShipping shippingPage = new UpsShipping();
    UpsPickupService pickupServicePage = new UpsPickupService();

    Map<String, String> originData = getData("origin", "ups");
    Map<String, String> destinationData = getData("destination", "ups");
    Map<String, String> packageData = getData("package", "ups");


    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.closeBanner();
        homePage.openShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {
        originPage.selectCountry(originData.get("country"));
        originPage.fillName(originData.get("name"));
        originPage.fillAddress(originData.get("address"));
        originPage.fillEmail(originData.get("email"));
        originPage.fillPhone(originData.get("phone"));
        Thread.sleep(500); // to be removed after bugfix #
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() throws InterruptedException {
        Thread.sleep(1000);
        originPage.submit();
        Thread.sleep(1000);
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String actualSummary = destinationPage.getResultSummary();
        assertThat(actualSummary).contains(originData.get("name"));
        assertThat(actualSummary).contains(originData.get("address"));
        assertThat(actualSummary).contains(originData.get("email"));
        assertThat(actualSummary).contains(originData.get("phone"));
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        destinationPage.selectCountry(destinationData.get("country"));
        destinationPage.fillName(destinationData.get("name"));
        destinationPage.fillAddress(destinationData.get("address"));
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String action) {
        if (action.equals("confirm")) {
            destinationPage.checkResidentialAddressSwitch();
        } else {
            destinationPage.uncheckResidentialAddressSwitch();
        }
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() throws InterruptedException {
        shippingPage.selectPackageType(packageData.get("type"));
        Thread.sleep(1000); // to be removed after bugfix #
        shippingPage.fillPackageWeight(packageData.get("weight"));
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        assertThat(pickupServicePage.areTotalChargesAppear()).isTrue();
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        pickupServicePage.selectCheapestOption();
    }
}