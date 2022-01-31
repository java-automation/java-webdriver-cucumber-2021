package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class UpsStepDefs {

    private static final UpsHome homePage = new UpsHome();

    private UpsCreateShipment createShipmentPage;
    private UpsOrigin originPage;
    private UpsDestination destinationPage;
    private UpsPackage packagePage;
    private UpsPickup pickupPage;
    private Map<String, String> originData, destinationData;

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.closePrivacyPrompt();
        homePage.createShipment();
        createShipmentPage = new UpsCreateShipment();
        createShipmentPage.waitForFirstLoad();
        originPage = new UpsOrigin();
        destinationPage = new UpsDestination();
        packagePage = new UpsPackage();
        pickupPage = new UpsPickup();
    }

    @When("I fill out origin shipment fields with {string} profile")
    public void iFillOutOriginShipmentFields(String profileReference) {
        originData = getData(profileReference, "ups");

        String country = originData.get("country");
        originPage.selectOriginCountry(country);
        originPage.fillOriginCompanyOrName(originData.get("companyOrName"));

        //some countries have only one address line, some require three - need to wait for refresh of appropriate one
        String address = originData.get("address");
        String city = originData.get("city");
        String postalCode = originData.get("postalCode");
        if (isSingleLineAddressCountry(country)) {
            originPage.fillOriginAddress(address + ", " + city + ", " + postalCode);
            verifyAddressArtifacts(address, city, postalCode, originPage.getProcessedOriginAddress());
        } else {
            originPage.fillOriginAddress1(address);
            originPage.fillOriginPostalCode(postalCode);
            originPage.fillOriginCity(city);
        }

        originPage.fillOriginEmail(originData.get("email"));
        originPage.fillOriginPhone(originData.get("phone"));
    }

    private void verifyAddressArtifacts(String address, String city, String postalCode, String actualAddress) {
        for (String token : address.split(" ")) {
            assertThat(actualAddress).contains(token);
        }
        assertThat(actualAddress).contains(city, postalCode);
    }

    private boolean isSingleLineAddressCountry(String country) {
        return switch (country) {
            case "United States", "Germany", "Spain", "United Kingdom",
                 "England", "Northern Ireland", "Scotland", "Wales" -> true;
            default -> false;
        };
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        createShipmentPage.submitForm();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        assertThat(destinationPage.getOriginSummaryName()).isEqualTo(originData.get("companyOrName"));
        verifyAddressArtifacts(originData.get("address"), originData.get("city"), originData.get("postalCode"), destinationPage.getOriginSummaryAddress());
        assertThat(destinationPage.getOriginSummaryCountry()).isEqualTo(originData.get("alpha2Code"));
        assertThat(destinationPage.getOriginSummaryContact()).isEqualTo(
                originData.get("email") + ", " + originData.get("phone"));
    }

    @When("I fill out destination shipment fields with {string} profile")
    public void iFillOutDestinationShipmentFieldsWithProfile(String profileReference) {
        destinationData = getData(profileReference, "ups");
        String country = destinationData.get("country");
        boolean isDeliveryInsideCountry = country.equals(originData.get("country"));

        destinationPage.selectDestinationCountry(country);
        destinationPage.fillDestinationCompanyOrName(destinationData.get("companyOrName"));

        //contact required only if shipping to a different country (customs?)
        if (!isDeliveryInsideCountry) destinationPage.fillDestinationContactName(destinationData.get("contact"));

        //some countries have only one address line, some require three - need to wait for refresh of appropriate one
        String address = destinationData.get("address");
        String city = destinationData.get("city");
        String postalCode = destinationData.get("postalCode");
        if (isSingleLineAddressCountry(country)) {
            destinationPage.fillDestinationAddress(address + ", " + city + ", " + postalCode);
            verifyAddressArtifacts(address, city, postalCode, destinationPage.getProcessedDestinationAddress());
        } else {
            destinationPage.fillDestinationAddress1(address);
            destinationPage.fillDestinationPostalCode(postalCode);
            destinationPage.fillDestinationCity(city);
        }

        //phone required only if shipping to a different country (customs?)
        if (!isDeliveryInsideCountry) destinationPage.fillDestinationPhone(destinationData.get("phone"));
    }

    @And("I {string} residential address for non-US country")
    public void iResidentialAddressForNonUSCountry(String action) {
        if (destinationData.get("country").equals("United States")) return;

        switch (action.toLowerCase()) {
            case "confirm" -> destinationPage.confirmDestinationIsResidentialNonUS();
            case "deny" -> destinationPage.denyDestinationIsResidentialNonUS();
            default -> throw new Error("Unknown action reference: " + action);
        }
    }

    @And("I {string} residential address for US")
    public void iResidentialAddressForUS(String action) {
        if (!destinationData.get("country").equals("United States")) return;

        switch (action.toLowerCase()) {
            case "confirm" -> destinationPage.confirmDestinationIsResidentialUS();
            case "deny" -> destinationPage.denyDestinationIsResidentialUS();
            default -> throw new Error("Unknown action reference: " + action);
        }
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        packagePage.selectPackagingType(originData.get("packageType"));
        packagePage.fillPackageWeight(originData.get("weight"));
    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        assertThat(pickupPage.isTotalChargesVisible()).isTrue();
        System.out.println(pickupPage.getTotalChargesText());
    }

    @When("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        pickupPage.selectCheapestOption();
        String cardText = pickupPage.getCheapestOptionText();
        assertThat(cardText).contains("Lowest Cost");
        assertThat(cardText).contains(pickupPage.getTotalChargesText());
    }
}
