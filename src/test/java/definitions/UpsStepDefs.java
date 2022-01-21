package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UpsShipmentCreatePage;
import pages.UpsHomePage;

import java.util.HashMap;
import java.util.Map;

public class UpsStepDefs {

    UpsHomePage homePage = new UpsHomePage();
    UpsShipmentCreatePage shipmentPage = new UpsShipmentCreatePage();

    public Map<String,String> getOriginData() {
        Map<String, String> origin = new HashMap<>();
        origin.put("country","United States");
        origin.put("name","John Smith");
        origin.put("address1","100 Main Street");
        origin.put("city","White Plains");
        origin.put("state","NY");
        origin.put("zipCode","10601");
        origin.put("email","test@test.com");
        origin.put("phone","(111)111-11-11");
        return origin;
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.gotoCreateShipmentPage();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        shipmentPage.fillOutOrigin(getOriginData());
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        shipmentPage.submitShipmentForm();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        shipmentPage.verifyOriginSubmitted(getOriginData());
    }
}
