package definitions;

import io.cucumber.java.en.*;
import pages.*;

import java.util.*;

import static support.TestContext.getData;

public class UpsStepsDef {

    UpsForm form = new UpsForm();
    Map<String, String> user = getData("user");

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        form.dismissCookiesModal();
        form.createShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {
        form.fillOrigin(user.get("fullName"), user.get("address"), user.get("email"), user.get("phone"));
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        form.submit();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        form.verifyOrigin();
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() throws InterruptedException {
        form.fillDestinationFields(user.get("sendToName"), user.get("sendToAddress"));
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String arg0) {
        form.confirmResidentialAddress();
    }
}
