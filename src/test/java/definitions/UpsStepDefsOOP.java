package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UpsStepDefsOOP {
    UPSHome homePage = new UPSHome();
    UpsCreateShipmentPage shipmentPage = new UpsCreateShipmentPage();
    UpsDestinationPage destinationPage = new UpsDestinationPage();
    UpsPackagePage packagePage = new UpsPackagePage();
    UpsPickupPage pickupPage = new UpsPickupPage();
    UpsDetailsPage detailsPage = new UpsDetailsPage();
    UpsPaymentPage paymentPage = new UpsPaymentPage();
    UpsReviewPage reviewPage = new UpsReviewPage();

    Map<String, String> upsUser = getData("upsUser");

    @And("I go to Create a Shipment oop")
    public void iGoToCreateAShipmentOop() {
        homePage.closeCookieWindow(); //закрыть окно cookies в начале
        homePage.openShipment();
    }


    @When("I fill out origin shipment fields oop")
    public void iFillOutOriginShipmentFieldsOop() throws InterruptedException {
        shipmentPage.selectCountry(upsUser.get("country"));
        shipmentPage.fillName(upsUser.get("name"));
        shipmentPage.fillEmail(upsUser.get("email"));
        shipmentPage.fillPhone(upsUser.get("phone"));
        shipmentPage.fillAddress(upsUser.get("address"));
    }

    @And("I submit the shipment form oop")
    public void iSubmitTheShipmentFormOop() throws InterruptedException {
        shipmentPage.submit();
    }

    @Then("I verify origin shipment fields submitted oop")
    public void iVerifyOriginShipmentFieldsSubmittedOop() {
        String resultContainer = destinationPage.getResultContainerTextInfo();
        assertThat(resultContainer).contains(upsUser.get("name"),
                                             upsUser.get("address"),
                                             upsUser.get("countryAbbreviation"),
                                             upsUser.get("email"),
                                             upsUser.get("phone"));
    }

    @When("I fill out destination shipment fields oop")
    public void iFillOutDestinationShipmentFieldsOop() throws InterruptedException {
        shipmentPage.selectCountry(upsUser.get("countryDestination"));
        shipmentPage.fillName(upsUser.get("nameDestination"));
        shipmentPage.fillAddress(upsUser.get("addressDestination"));
    }

    @And("I {string} residential address oop")
    public void iResidentialAddressOop(String option) throws Exception {
        destinationPage.switchTheResidentialAddress(option);
    }

    @And("I set {string} type and weight oop")
    public void iSetTypeAndWeightOop(String type) {
        packagePage.selectPackagingType(type);
        packagePage.setWeight(upsUser.get("weight"));
    }


    @Then("I verify total charges appear oop")
    public void iVerifyTotalChargesAppearOop() {
        assertThat(pickupPage.getTotalChargesElement().isDisplayed());
    }

    @And("I select {string} delivery option oop")
    public void iSelectDeliveryOptionOop(String option) throws Exception {
        if (option.equalsIgnoreCase("Cheapest")) {
            pickupPage.selectCheapestOption();
        } else {
            throw new Exception("Unknown option: " + option);
        }
    }

    @And("I set description and check {string} type if available oop")
    public void iSetDescriptionAndCheckTypeIfAvailableOop(String type) {
        detailsPage.fillDescription(upsUser.get("description"));
        detailsPage.checkSaturdayDelivery();
    }

    @And("I check {string} oop")
    public void iCheckOop(String type) throws InterruptedException {
        Thread.sleep(2000);
        String initial = detailsPage.getTotalCharges();
        detailsPage.checkDeliverOnlyToReceiverAddress();
        Thread.sleep(2000);
        String result = detailsPage.getTotalCharges();
        assertThat(initial).isNotEqualTo(result);
    }

    @Then("I verify total charges changed oop")
    public void iVerifyTotalChargesChangedOop() {
        //в методе выше
    }

    @And("I select {string} payment type oop")
    public void iSelectPaymentTypeOop(String paymentType) {
        paymentPage.selectPayPal();
    }

    @And("I submit the shipment form to review oop")
    public void iSubmitTheShipmentFormToReviewOop() {
        paymentPage.submitReviewButton();
    }

    @Then("I review all recorded details on the review page oop")
    public void iReviewAllRecordedDetailsOnTheReviewPageOop() {
        String fromBlock =  reviewPage.getShipFromText();
        assertThat(fromBlock).contains(upsUser.get("name"), upsUser.get("address"), upsUser.get("email"), upsUser.get("phone"));

        String toBlock = reviewPage.getShipToText();
        assertThat(toBlock).contains(upsUser.get("nameDestination"));
    }

    @And("I cancel the shipment form oop")
    public void iCancelTheShipmentFormOop() {
        reviewPage.cancelShipmentForm();

    }

    @Then("I verify shipment form is reset oop")
    public void iVerifyShipmentFormIsResetOop() {
        shipmentPage.waitTillOpen();

        String nameField = shipmentPage.nameFieldValue();
        assertThat(nameField).isEmpty();

        String addressField = shipmentPage.addressFieldValue();
        assertThat(addressField).isEmpty();

        String emailField = shipmentPage.emailFieldValue();
        assertThat(emailField).isEmpty();

        String phoneField = shipmentPage.phoneFieldValue();
        assertThat(phoneField).isEmpty();
    }
}
