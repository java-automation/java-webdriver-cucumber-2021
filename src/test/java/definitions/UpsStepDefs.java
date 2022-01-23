package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UpsHome;
import pages.UpsShip;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class UpsStepDefs {

    private final UpsHome homePage = new UpsHome();
    private final UpsShip shipPage = new UpsShip();

    private Map<String, String> origin, destination;

    @Given("I go to UPS page")
    public void iGoToUPSPage() {
        homePage.open();
        homePage.closePrivacyPrompt();
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.createShipment();
        shipPage.waitForFirstLoad();
    }

    @When("I fill out origin shipment fields with {string} profile")
    public void iFillOutOriginShipmentFields(String profileReference) {
        origin = getData(profileReference.toLowerCase().replace(" ", ""));

        String country = origin.get("country");
        shipPage.selectOriginCountry(country);
        shipPage.fillOriginCompanyOrName(origin.get("companyOrName"));

        //some countries have only one address line, some require three - need to wait for refresh of appropriate one
        String address = origin.get("address");
        String city = origin.get("city");
        String postalCode = origin.get("postalCode");
        if (isSingleLineAddressCountry(country)) {
            shipPage.fillOriginAddress(address + ", " + city + ", " + postalCode);
            verifyAddressArtifacts(address, city, postalCode, shipPage.getProcessedOriginAddress());
        }
        else {
            shipPage.fillOriginAddress1(address);
            shipPage.fillOriginPostalCode(postalCode);
            shipPage.fillOriginCity(city);
        }

        shipPage.fillOriginEmail(origin.get("email"));
        shipPage.fillOriginPhone(origin.get("phone"));
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
        shipPage.submitForm();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        assertThat(shipPage.getOriginSummaryName()).isEqualTo(origin.get("companyOrName"));
        verifyAddressArtifacts(origin.get("address"), origin.get("city"), origin.get("postalCode"), shipPage.getOriginSummaryAddress());
        assertThat(shipPage.getOriginSummaryCountry()).isEqualTo(
                getAlpha2CountryCode(origin.get("country")));
        assertThat(shipPage.getOriginSummaryContact()).isEqualTo(
                origin.get("email") + ", " + origin.get("phone"));
    }

    private String getAlpha2CountryCode(String country) {
        return switch (country) {
            case "United States" -> "US";
            case "Finland" -> "FI";
            default -> throw new Error("Unknown country name: " + country);
        };
    }

    @When("I fill out destination shipment fields with {string} profile")
    public void iFillOutDestinationShipmentFieldsWithProfile(String profileReference) {
        destination = getData(profileReference.toLowerCase().replace(" ", ""));
        String country = destination.get("country");
        boolean isDeliveryInsideCountry = country.equals(origin.get("country"));

        shipPage.selectDestinationCountry(country);
        shipPage.fillDestinationCompanyOrName(destination.get("companyOrName"));

        //contact required only if shipping to a different country (customs?)
        if (!isDeliveryInsideCountry) shipPage.fillDestinationContactName(destination.get("contact"));

        //some countries have only one address line, some require three - need to wait for refresh of appropriate one
        String address = destination.get("address");
        String city = destination.get("city");
        String postalCode = destination.get("postalCode");
        if (isSingleLineAddressCountry(country)) {
            shipPage.fillDestinationAddress(address + ", " + city + ", " + postalCode);
            verifyAddressArtifacts(address, city, postalCode, shipPage.getProcessedDestinationAddress());
        }
        else {
            shipPage.fillDestinationAddress1(address);
            shipPage.fillDestinationPostalCode(postalCode);
            shipPage.fillDestinationCity(city);
        }

        //phone required only if shipping to a different country (customs?)
        if (!isDeliveryInsideCountry) shipPage.fillDestinationPhone(destination.get("phone"));
    }

    @And("I {string} residential address for non-US country")
    public void iResidentialAddressForNonUSCountry(String action) {
        if (destination.get("country").equals("United States")) return;

        switch (action.toLowerCase()) {
            case "confirm" -> shipPage.confirmDestinationIsResidentialNonUS();
            case "deny" -> shipPage.denyDestinationIsResidentialNonUS();
            default -> throw new Error("Unknown action reference: " + action);
        }
    }

    @And("I {string} residential address for US")
    public void iResidentialAddressForUS(String action) {
        if (!destination.get("country").equals("United States")) return;

        switch (action.toLowerCase()) {
            case "confirm" -> shipPage.confirmDestinationIsResidentialUS();
            case "deny" -> shipPage.denyDestinationIsResidentialUS();
            default -> throw new Error("Unknown action reference: " + action);
        }
    }

    @And("I set packaging type as {string} and weight as {int} lbs")
    public void iSetPackagingTypeAsAndWeightAsLbs(String packageType, int weight) {
        shipPage.selectPackagingType(packageType);
        shipPage.fillPackageWeight(weight);
        //shipPage.removeReferenceNumbers();
    }

//    @And("I do test step")
//    public void iDoTestStep() throws InterruptedException {
//        shipPage.printSelectOptionsWithResidentialStatus();
//    }
}
