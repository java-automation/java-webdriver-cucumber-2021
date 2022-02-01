package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import support.Shipment;
import support.ShipmentEndpoint;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getShipment;

public class UpsStepDefs {

    UpsHomePage homePage = new UpsHomePage();
    UpsShipmentOrigin shipmentOrigin = new UpsShipmentOrigin();
    UpsShipmentDestination shipmentDest = new UpsShipmentDestination();
    UpsShipmentWhat shipmentWhat = new UpsShipmentWhat();
    UpsShipmentHow shipmentHow = new UpsShipmentHow();
    UpsShipmentDetails shipmentDetails = new UpsShipmentDetails();
    UpsShipmentPayment shipmentPayment = new UpsShipmentPayment();
    UpsShipmentReview shipmentReview = new UpsShipmentReview();
    Shipment shipment = getShipment();
    List<ShipmentEndpoint> shipmentEndpoints = shipment.getShipmentEndpoints();
    ShipmentEndpoint origin;
    ShipmentEndpoint destination;
    String totalCharges;

    private Double extractDouble(String charge) {
        Locale locale = new Locale("en","US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        try {
            return formatter.parse(charge).doubleValue();
        } catch (ParseException e) {
            throw new Error(e);
        }
    }

    private String countryCode(String country){
        // ISO2 country code from country name
        for (String iso : Locale.getISOCountries()) {
            if (new Locale("", iso).getDisplayCountry().equals(country)) {
                return iso;
            }
        }
        return "";
    }

    private ShipmentEndpoint getShipmentEndpoint(Predicate<ShipmentEndpoint> condition) {
        return shipmentEndpoints.stream().filter(condition).findFirst().orElseThrow();
    }

    private void verifyEndpointSummary(String summary, ShipmentEndpoint endpoint) {
        assertThat(summary).containsIgnoringCase(endpoint.getName());
        assertThat(summary).containsIgnoringCase(endpoint.getPostalAddress());
        assertThat(summary).containsIgnoringCase(endpoint.getEmail() + ", " + endpoint.getPhone());
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.openShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        origin = getShipmentEndpoint(s -> s.getType().equals("commercial") && (s.getSingleLineAddressLength() > 35));
        shipmentOrigin.fillOutOrigin(origin);
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        shipmentOrigin.submitShipmentForm();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        verifyEndpointSummary(shipmentDest.getOriginSummary(), origin);
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        destination = getShipmentEndpoint(s -> s.getType().equals("residential"));
        shipmentDest.fillOutDestination(destination);
    }

    @And("I {string} residential address")
    public void iResidentialAddress(String action) {
        if (action.equals("confirm")) {
            shipmentDest.checkResidentialAddressSwitch();
        } else {
            shipmentDest.uncheckResidentialAddressSwitch();
        }
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        shipmentWhat.setPackageTypeAndWeight(shipment.getType(),shipment.getWeight());
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        assertThat(shipmentHow.verifyTotalChargesPresent()).isTrue();
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        shipmentHow.selectCheapestOption();
        totalCharges = shipmentHow.getTotalCharges();
    }

    @And("I set description and check Saturday Delivery type if available")
    public void iSetDescriptionAndCheckSaturdayDeliveryTypeIfAvailable() {
        shipmentDetails.setDescription(shipment.getDescription());
        shipmentDetails.checkSaturdayDeliveryType();
    }

    @And("I check Deliver only to receiver's address")
    public void iCheckDeliverOnlyToReceiverSAddress() {
        shipmentDetails.checkDirectDeliveryType();
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
        String currentTotalCharges = shipmentDetails.getTotalChargesWithSpinnerWait();
        assertThat(extractDouble(currentTotalCharges)).isGreaterThan(extractDouble(totalCharges));
        totalCharges = currentTotalCharges;
    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        shipmentPayment.selectPayPal();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
//        John Smith
//        100 Main Street, WHITE PLAINS, NY 10601
//        test@test.com, (111)111-11-11
//        Peter Doe
//        678 Main Street, White Plains, NY 10601
//        test@test.com, (111)111-11-11
//        Residential
//        1. UPS Tube - 1.1 lbs. - 38 x 6 x 6 in.
//                Edit
//        Edit Package 0
//        No, I'll drop it off 01/30/2022.
//        Wednesday February 2, 2022 by End of Day via our UPS 2nd Day Air service for $37.46
//        Description of Goods: Book
//        PayPal

        // TO DO: remove hardcoded asserts
        shipmentReview.waitForUrlMatch();
        verifyEndpointSummary(shipmentReview.getOriginSummary(),origin);
        verifyEndpointSummary(shipmentReview.getDestinationSummary(),destination);
        assertThat(shipmentReview.getDestinationSummary()).containsIgnoringCase("residential");
        assertThat(shipmentReview.getPackageSummary()).containsIgnoringCase(shipment.getType());
        assertThat(shipmentReview.getPackageSummary()).containsIgnoringCase(shipment.getWeight());
        assertThat(shipmentReview.getDropOffOrPickupSummary()).containsIgnoringCase("No");
        assertThat(shipmentReview.getDeliveryDaySummary()).contains(totalCharges);
        assertThat(shipmentReview.getGoodsSummary()).containsIgnoringCase(shipment.getDescription());
        assertThat(shipmentReview.getPaymentMethodSummary()).isEqualToIgnoringCase("PayPal");
    }

    @And("I submit the shipment form for review")
    public void iSubmitTheShipmentFormForReview() {
        shipmentPayment.submitShipmentFormForReview();
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        shipmentReview.cancelShipmentForm();
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        assertThat(shipmentOrigin.originFormDisplayed()).isTrue();
    }
}
