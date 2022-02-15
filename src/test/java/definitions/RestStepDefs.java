package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.RestClient;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs {

    RestClient restClient = new RestClient();
    Map<String, String> automation = getData("positions");
    Map<String, String> fieldsToUpdate = getData("updatedPosition");

    // Map<String, String> candidateInfo = getData("candidate");


    @Given("I work with rest api")
    public void iWorkWithRestApi() {

        // CRUD operations for position

        // CREATE position
        int createdId = restClient.createPosition(automation);

        // READ position
//        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);


        // UPDATE position
        // restClient.updatePositionById(createdId, fieldsToUpdate);
        // restClient.updatePosition("zip", "10013", createdId);


        // DELETE position
        restClient.deletePositionById(createdId);
    }

    @Given("I login via REST API as {string}")
    public void iLoginViaRESTAPIAs(String role) {
        System.out.println(role);
        Map<String, String> credentials = getData("recruiter");
        restClient.login(credentials);

    }

    @When("I create via REST API {string} position")
    public void iCreateViaRESTAPIPosition(String type) {
        Map<String, String> positionFromFile = getData("positions");
        restClient.createPosition(positionFromFile);
    }

    @Then("I verify via REST API new {string} position is in the list")
    public void iVerifyViaRESTAPINewPositionIsInTheList(String type) throws InterruptedException {
        Map<String, String> expectedPosition = getData("positions");
        List<Map<String, Object>> allPositions = restClient.getPositions();
        int expectedId = readTestDataInteger("lastCreatedPositionId");
        boolean isFound = false;
        for (Map<String, Object> actualPosition : allPositions) {
            int actualId = (Integer) actualPosition.get("id");
            if (actualId == expectedId) {
                isFound = true;
                for (String key : expectedPosition.keySet()) {
                    System.out.println("Verifying " + key);
                    System.out.println("Actual value: " + actualPosition.get(key));
                    System.out.println("Expected value: " + expectedPosition.get(key));
                    assertThat(actualPosition.get(key)).isEqualTo(expectedPosition.get(key));
                }
                break;
            }
        }
        assertThat(isFound).isTrue();
        Thread.sleep(2000);
    }

    @When("I update via REST API new {string} position")
    public void iUpdateViaRESTAPINewPosition(String type) {
        Map<String, String> fieldsToUpdate = getPositionDataFromFile(type + "_updated", "positions");
        int positionIdToUpdate = readTestDataInteger("lastCreatedPositionId");
        restClient.updatePositionById(positionIdToUpdate, fieldsToUpdate);
    }

    @Then("I verify via REST API new {string} position is updated")
    public void iVerifyViaRESTAPINewPositionIsUpdated(String type) {
        int updatedPositionId = readTestDataInteger("lastCreatedPositionId");
        Map<String, String> expectedFields = getPositionDataFromFile(type + "_updated", "positions");
        Map<String, Object> actualPosition = restClient.getPositionById(updatedPositionId);

        for(String key : expectedFields.keySet()) {
            System.out.println("Verifying " + key);
            System.out.println("Actual value: " + actualPosition.get(key));
            System.out.println("Expected value: " + expectedFields.get(key));
            assertThat(actualPosition.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST API new position")
    public void iDeleteViaRESTAPINewPosition() {
        int positionIdToDelete = readTestDataInteger("lastCreatedPositionId");
        restClient.deletePositionById(positionIdToDelete);
    }

    @Then("I verify via REST API new position is deleted")
    public void iVerifyViaRESTAPINewPositionIsDeleted() {
        int deletedPositionId = readTestDataInteger("lastCreatedPositionId");
        List<Map<String, Object>> allPositions = restClient.getPositions();
        for (Map<String, Object> actualPosition : allPositions) {
            int actualId = (Integer) actualPosition.get("id");
            assertThat(actualId).isNotEqualTo(deletedPositionId);
        }

    }

    @And("I logout via REST API")
    public void iLogoutViaRESTAPI() {
        restClient.logout();
    }
}



