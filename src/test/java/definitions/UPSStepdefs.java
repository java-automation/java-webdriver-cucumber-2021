package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.UpsHome;

import java.util.Map;

public class UPSStepdefs {

    UpsHome home = new UpsHome();
//    Map<String, String> origin =



    @Given("I go to UPS page")
    public void iGoToUPSPage() {
        home.open();
        home.closeBanner();
    }
    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
    home.openShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
    }
}
