package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.UpsHome;
import pages.UpsOrigin;

import java.util.Map;

import static support.TestContext.getData;

public class UPSStepdefs {

    UpsHome homePage = new UpsHome();
    UpsOrigin originPage = new UpsOrigin();
   Map<String, String> origin = getData("origin", "ups");



    @Given("I go to UPS page")
    public void iGoToUPSPage() {
        homePage.open();
        homePage.closeBanner();
    }
    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
    homePage.openShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
    originPage.selectCountry(origin.get("country"));
    originPage.fillEmail(origin.get("email"));
    originPage.fillAddress(origin.get("address"));
    originPage.fillName(origin.get("name"));
    originPage.fillPhone(origin.get("phone"));
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
    originPage.submit();
    }
}
