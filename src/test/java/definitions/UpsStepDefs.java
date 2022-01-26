package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UpsDestination;
import pages.UpsHome;
import pages.UpsOrigin;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class UpsStepDefs {

    UpsHome homePage = new UpsHome();
    UpsOrigin originPage = new UpsOrigin();
    UpsDestination destinationPage = new UpsDestination();

    Map<String, String> originData = getData("origin", "ups");
    Map<String, String> destinationData = getData("destination", "ups");

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        homePage.closeBanner();
        homePage.openShipment();
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() throws InterruptedException {
        originPage.selectCountry(originData.get("country"));
        originPage.fillName(originData.get("name"));
        originPage.fillAddress(originData.get("address"));
        originPage.fillEmail(originData.get("email"));
        originPage.fillPhone(originData.get("phone"));
        Thread.sleep(500); // to be removed after bugfix #
    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        originPage.submit();
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        String actualSummary = destinationPage.getResultSummary();
        assertThat(actualSummary).contains(originData.get("name"));
        assertThat(actualSummary).contains(originData.get("address"));
        assertThat(actualSummary).contains(originData.get("email"));
        assertThat(actualSummary).contains(originData.get("phone"));
    }
}
