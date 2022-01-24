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
        origin.put("email","test@test.com");
        origin.put("phone","(111)111-11-11");

        // single address line has length limit of 35 characters
        // SOMETIMES (race condition) triggering error "Address Line 1 max length exceeded" and showing expanded form
        // 100 Main Street, White Plains, NY 10601 (33 chars without zip, 39 chars with zip)
        origin.put("type","commercial");
        origin.put("address1","100 Main Street");
        origin.put("city","White Plains");
        origin.put("state","NY");
        origin.put("zipCode","10601");

        // Note: residential addresses do not trigger max length PROBABLY due to one prediction in the list
        // residential, one prediction, more than 35 chars
        // 678 Main Street, White Plains, NY 10601 (33 chars without zip, 39 chars with zip)
//        origin.put("type","residential");
//        origin.put("address1","678 Main Street");
//        origin.put("city","White Plains");
//        origin.put("state","NY");
//        origin.put("zipCode","10601");

        // 105 Tyler Blvd, Coffeyville, KS 67337 (31 chars without zip, 37 chars with zip)
        // residential, one prediction, more than 35 chars
//        origin.put("type","residential");
//        origin.put("address1","105 Tyler Blvd");
//        origin.put("city","Coffeyville");
//        origin.put("state","KS");
//        origin.put("zipCode","67337");

        // POSSIBLE VARIATION OF DATA
        // data with incorrect zipCode
        // 105 Tyler Blvd, Coffeyville, KS 67336
        // suggestion by Google: 105 Tyler Boulevard, Coffeyville, KS USA
        // after acceptance of suggestion zipCode is auto-corrected: 105 Tyler Blvd, Coffeyville, KS 67337

        return origin;
    }

    public Map<String,String> getDestData() {
        Map<String, String> dest = new HashMap<>();
        dest.put("country", "United States");
        dest.put("name", "Terry Jackson");
        dest.put("email", "test2@test2.com");
        dest.put("phone", "(222)222-22-22");

        // commercial, multiple predictions, more than 35 chars
        // 345 Park Avenue South, New York, NY 10010 (35 chars without zip, 41 chars with zip)
        dest.put("address1","345 Park Avenue South");
        dest.put("city","New York");
        dest.put("state","NY");
        dest.put("zipCode","10010");
        dest.put("type","commercial");

        // commercial, multiple predictions, less than 35 chars
        // 2 Gold Street, New York, NY 10038 (27 chars without zip, 33 chars with zip)
//        dest.put("address1", "2 Gold Street");
//        dest.put("city", "New York");
//        dest.put("state", "NY");
//        dest.put("zipCode", "10038");
//        dest.put("type", "commercial");

        // residential, one prediction, less than 35 chars
        // 104 Fox Road, Bridgeton, NJ 08302 (27 chars without zip, 33 chars with zip)
//        origin.put("type","residential");
//        origin.put("address1","104 Fox Road");
//        origin.put("city","Bridgeton");
//        origin.put("state","NJ");
//        origin.put("zipCode","08302");

        return dest;
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

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        shipmentPage.fillOutDestination(getDestData());
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
}
