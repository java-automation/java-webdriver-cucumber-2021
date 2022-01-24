package definitions;

import io.cucumber.java.en.*;
import pages.*;

import java.util.*;

import static support.TestContext.getData;

public class UpsStepsDef {

    UpsForm form = new UpsForm();

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        form.createShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        Map<String, String> user = getData("user");
        form.fillOrigin(user.get("fullName"), user.get("address"), user.get("email"), user.get("phone"));
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        form.submit();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {

    }
}
