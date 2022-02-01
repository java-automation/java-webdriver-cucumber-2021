package definitions;

import io.cucumber.java.en.*;
import org.testng.*;
import pages.*;

import java.util.*;

import static support.TestContext.getData;

public class UpsStepsDef {

    UpsForm form = new UpsForm();
    Map<String, String> user = getData("user");
    String beforeCharges = "";
    String afterCharges = "";

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

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() throws InterruptedException {
        form.setPackageType();
        Thread.sleep(2000);
        form.setPackageWeight();
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        form.checkTotal();
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        form.selectOption();
    }

    @And("I set description and check Saturday Delivery type if available")
    public String iSetDescriptionAndCheckSaturdayDeliveryTypeIfAvailable() {
        form.setShippingDescription();
        //form.checkSaturdayDelivery();
        return beforeCharges = form.getTotalCharges();
    }

    @And("I check Deliver only to receiver's address")
    public String iCheckDeliverOnlyToReceiverSAddress() throws InterruptedException {
        form.checkDeliverOnlyToAddress();
        Thread.sleep(4000);
        return afterCharges = form.getTotalCharges();
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(beforeCharges);
        System.out.println(afterCharges);
        Assert.assertNotEquals(beforeCharges, afterCharges);
    }

    @And("I select {string} payment type")
    public void iSelectPaypalPaymentType(String paymentMethod) throws InterruptedException {
        form.selectPaymentMethod(paymentMethod);
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        form.reviewShipFromDetails();
        form.reviewShipToDetails();
        form.reviewPackageInformation();
        form.reviewAdditionalOptions();
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        form.cancelShipment();
    }
}
