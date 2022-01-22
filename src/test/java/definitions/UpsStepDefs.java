package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.UpsHome;
import pages.UpsShip;

import java.util.Arrays;
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
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.closePrivacyPrompt();
        homePage.createShipment();
        shipPage.waitForPageLoad();
    }

    @When("I fill out origin shipment fields with {string} profile")
    public void iFillOutOriginShipmentFields(String profileReference) throws InterruptedException {
        origin = getData(profileReference.toLowerCase().replace(" ", ""));

        String country = origin.get("country");
        shipPage.selectOriginCountry(country);
        //Thread.sleep(1000);
        shipPage.fillOriginName(origin.get("name"));

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

    private void verifyAddressArtifacts(String address, String city, String postalCode, String processedOriginAddress) {
        for (String token : address.split(" ")) {
            assertThat(processedOriginAddress).contains(token);
        }
        assertThat(processedOriginAddress).contains(city, postalCode);
    }

    private boolean isSingleLineAddressCountry(String country) {
        return switch (country) {
            case "United States", "Germany", "Spain", "United Kingdom" -> true;
            default -> false;
        };
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        shipPage.submitForm();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        assertThat(shipPage.getOriginSummaryName()).isEqualTo(origin.get("name"));
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
}
