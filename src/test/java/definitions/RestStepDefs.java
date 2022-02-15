package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.RestClient;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static support.TestContext.*;

public class RestStepDefs {

    private final RestClient restClient = new RestClient();

    private final Map<String, String> defaultCredentials = getData("recruiter", "secrets/careers");

    @And("I perform CRUD operations with positions")
    public void iPerformCRUDOperationsWithPositions() {
        //LOGIN
        restClient.login(defaultCredentials);

        //CREATE
        Map<String, String> position = getPositionDataFromFile("leetProgrammer", "careers");
        int id = restClient.createPosition(position);

        //READ
        //restClient.getPositions();
        restClient.getPositionById(id);

        //UPDATE
        Map<String, String> positionUpdated = getPositionDataFromFile("leetProgrammer_updated", "careers");
        restClient.updatePositionById(positionUpdated, id);
        restClient.getPositionById(id);

        //DELETE
        restClient.deletePositionById(id);
    }

    @And("I perform CRUD operations with candidates")
    public void iPerformCRUDOperationsWithCandidates() {
        //LOGIN
        restClient.login(defaultCredentials);

        //CREATE
        Map<String, String> candidate = getCandidateDataFromFile("candidateJD", "careers");
        int id = restClient.createCandidate(candidate);

        //READ
        restClient.getCandidateById(id);

        //UPDATE
        Map<String, String> candidateUpdated = getCandidateDataFromFile("candidateJD_updated", "careers");
        restClient.updateCandidateById(candidateUpdated, id);
        restClient.getCandidateById(id);

        //DELETE
        restClient.deleteCandidateById(id);
    }

    @Given("I login via REST API as {string}")
    public void iLoginViaRESTAPIAs(String role) {
        Map<String, String> credentials = getData(role, "secrets/careers");
        restClient.login(credentials);
    }

    @And("I logout via REST API")
    public void iLogoutViaRESTAPI() {
        restClient.logout();
    }

    @When("I create via REST API {string} position")
    public void iCreateViaRESTAPIPosition(String position) {
        int id = restClient.createPosition(getPositionDataFromFile(position, "careers"));
        saveTestData("lastCreatedPositionId", id);
    }

    @Then("I verify via REST API new {string} position is in the list")
    public void iVerifyViaRESTAPINewPositionIsInTheList(String position) {
        Map<String, String> expectedPosition = getPositionDataFromFile(position, "careers");
        List<Map<String, Object>> allPositions = restClient.getPositions();
        int expectedId = readTestDataAsInteger("lastCreatedPositionId");
        boolean isFound = false;
        for (Map<String, Object> actualPosition : allPositions) {
            int actualId = (Integer) actualPosition.get("id");
            if (actualId == expectedId) {
                isFound = true;
                for (String key : expectedPosition.keySet()) {
                    System.out.println("Verification for: " + key);
                    System.out.println("Actual: " + actualPosition.get(key));
                    System.out.println("Expected: " + expectedPosition.get(key));
                    assertThat(actualPosition.get(key)).isEqualTo(expectedPosition.get(key));
                }
                break;
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I update via REST API new {string} position")
    public void iUpdateViaRESTAPINewPosition(String position) {
        Map<String, String> fieldsToUpdate = getPositionDataFromFile(position + "_updated", "careers");
        int positionToUpdate = readTestDataAsInteger("lastCreatedPositionId");
        restClient.updatePositionById(fieldsToUpdate, positionToUpdate);
    }

    @Then("I verify via REST API new {string} position is updated")
    public void iVerifyViaRESTAPINewPositionIsUpdated(String position) {
        int updatedPositionId = readTestDataAsInteger("lastCreatedPositionId");
        Map<String, String> expectedFields = getPositionDataFromFile(position + "_updated", "careers");
        Map<String, Object> actualPosition = restClient.getPositionById(updatedPositionId);
        for (String key : expectedFields.keySet()) {
            System.out.println("Verification for: " + key);
            System.out.println("Actual: " + actualPosition.get(key));
            System.out.println("Expected: " + expectedFields.get(key));
            assertThat(actualPosition.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST API new position")
    public void iDeleteViaRESTAPINewPosition() {
        int positionIdToDelete = readTestDataAsInteger("lastCreatedPositionId");
        restClient.deletePositionById(positionIdToDelete);
    }

    @Then("I verify via REST API new position is deleted")
    public void iVerifyViaRESTAPINewPositionIsDeleted() {
        List<Map<String, Object>> allPositions = restClient.getPositions();
        int deletedId = readTestDataAsInteger("lastCreatedPositionId");
        for (Map<String, Object> actualPosition : allPositions) {
            int actualId = (Integer) actualPosition.get("id");
            assertThat(actualId).isNotEqualTo(deletedId);
        }
    }

    @When("I create via REST API {string} candidate")
    public void iCreateViaRESTAPICandidate(String candidate) {
        int id = restClient.createCandidate(getCandidateDataFromFile(candidate, "careers"));
        saveTestData("lastCreatedCandidateId", id);
    }

    @Then("I verify via REST API new {string} candidate is in the list")
    public void iVerifyViaRESTAPINewCandidateIsInTheList(String candidate) {
        Map<String, String> expectedCandidate = getCandidateDataFromFile(candidate, "careers");
        List<Map<String, Object>> allCandidates = restClient.getCandidates();
        int expectedId = readTestDataAsInteger("lastCreatedCandidateId");
        boolean isFound = false;
        for (Map<String, Object> actualCandidate : allCandidates) {
            int actualId = (Integer) actualCandidate.get("id");
            if (actualId == expectedId) {
                isFound = true;
                for (String key : expectedCandidate.keySet()) {
                    if (key.equals("password")) continue;
                    System.out.println("Verification for: " + key);
                    System.out.println("Actual: " + actualCandidate.get(key));
                    System.out.println("Expected: " + expectedCandidate.get(key));
                    assertThat(actualCandidate.get(key)).isEqualTo(expectedCandidate.get(key));
                }
                break;
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I update via REST API new {string} candidate")
    public void iUpdateViaRESTAPINewCandidate(String candidate) {
        Map<String, String> fieldsToUpdate = getCandidateDataFromFile(candidate + "_updated", "careers");
        int candidateToUpdate = readTestDataAsInteger("lastCreatedCandidateId");
        restClient.updateCandidateById(fieldsToUpdate, candidateToUpdate);
    }

    @Then("I verify via REST API new {string} candidate is updated")
    public void iVerifyViaRESTAPINewCandidateIsUpdated(String candidate) {
        int updatedCandidateId = readTestDataAsInteger("lastCreatedCandidateId");
        Map<String, String> expectedFields = getCandidateDataFromFile(candidate + "_updated", "careers");
        Map<String, Object> actualCandidate = restClient.getCandidateById(updatedCandidateId);
        for (String key : expectedFields.keySet()) {
            System.out.println("Verification for: " + key);
            System.out.println("Actual: " + actualCandidate.get(key));
            System.out.println("Expected: " + expectedFields.get(key));
            assertThat(actualCandidate.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST API new candidate")
    public void iDeleteViaRESTAPINewCandidate() {
        int candidateIdToDelete = readTestDataAsInteger("lastCreatedCandidateId");
        restClient.deleteCandidateById(candidateIdToDelete);
    }

    @Then("I verify via REST API new candidate is deleted")
    public void iVerifyViaRESTAPINewCandidateIsDeleted() {
        List<Map<String, Object>> allCandidates = restClient.getCandidates();
        int deletedId = readTestDataAsInteger("lastCreatedCandidateId");
        for (Map<String, Object> actualCandidate : allCandidates) {
            int actualId = (Integer) actualCandidate.get("id");
            assertThat(actualId).isNotEqualTo(deletedId);
        }
    }
}
