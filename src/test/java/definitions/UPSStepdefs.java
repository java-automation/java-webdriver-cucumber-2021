package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.UpsHome;

public class UPSStepdefs {

    UpsHome home = new UpsHome();




    @Given("I go to UPS page")
    public void iGoToUPSPage() {
        home.open();
        home.closePrivacyNotice();
    }
    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
    home.
    }
}
