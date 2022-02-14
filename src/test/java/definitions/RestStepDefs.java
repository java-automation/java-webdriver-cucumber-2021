package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.RestClient;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static org.apache.commons.net.ntp.TimeStamp.getTime;
import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs {

    RestClient restClient = new RestClient();
    Map<String, String> automation = getData("automation", "positions");
    Map<String, String> candidate = getData("automation", "candidates");
    Map<String, String> fieldsToUpdate = getPositionDataFromFile("automation_updated", "positions");
    int createdCandidateID;

    @Given("I work with rest api")
    public void iWorkWithRestApi() {
        // CRUD operations for position
        // CREATE
        int createdId = restClient.createPosition(automation);
        // READ
//        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);
        // UPDATE
        restClient.updatePositionById(createdId, fieldsToUpdate);
        // DELETE
        restClient.deletePositionByID(createdId);

        // CRUD operations for candidates
        // CREATE
        String email = candidate.get("email");
        email = email.replace("@", System.currentTimeMillis() + "@");
        candidate.put("email", email);
        int createdCandidateID = restClient.createCandidate(candidate);

        // READ
        Map<String, Object> createdCandidate = restClient.getCandidateById(createdCandidateID);

        // UPDATE
        restClient.updateCandidateByID("address", "123, Some st.,", createdCandidateID);

        // DELETE
        restClient.deleteCandidateByID(createdCandidateID);

    }

    @Given("I login via REST API as {string}")
    public void iLoginViaRESTAPIAs(String role) {
        Map<String, String> credentials = getData(role, "careers");
        restClient.login(credentials);
    }

    @When("I create via REST API {string} position")
    public void iCreateViaRESTAPIPosition(String type) {
        Map<String, String> positionFromFile = getPositionDataFromFile(type, "positions");
        restClient.createPosition(positionFromFile);
    }

    @Then("I verify via REST API new {string} position is in the list")
    public void iVerifyViaRESTAPINewPositionIsInTheList(String type) {
        Map<String, String> expectedPosition = getPositionDataFromFile(type, "positions");
        List<Map<String, Object>> allPositions = restClient.getPositions();
        int expectedId = readTestDataInteger("lastCreatedPositionId");
        boolean isFound = false;
        for (Map<String, Object> actualPosition : allPositions) {
            int actualId = (Integer) actualPosition.get("id");
            if (actualId == expectedId) {
                isFound = true;
                for(String key : expectedPosition.keySet()) {
                    System.out.println("Verifying " + key);
                    System.out.println("Actual value: " + actualPosition.get(key));
                    System.out.println("Expected value: " + expectedPosition.get(key));
                    assertThat(actualPosition.get(key)).isEqualTo(expectedPosition.get(key));
                }
                break;
            }
        }
        assertThat(isFound).isTrue();
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
        restClient.deletePositionByID(positionIdToDelete);
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

    @When("I create via REST API {string} candidate")
    public void iCreateViaRESTAPICandidate(String type) {
        candidate = getData(type, "candidates");
        String email = candidate.get("email");
        email = email.replace("@", System.currentTimeMillis() + "@");
        candidate.put("email", email);
        createdCandidateID = restClient.createCandidate(candidate);
        saveTestData("lastCreatedCandidateId", createdCandidateID);
        saveTestData("lastCreatedCandidateEmail", email);
    }

    @Then("I verify via REST API new {string} candidate is in the list")
    public void iVerifyViaRESTAPINewCandidateIsInTheList(String type) {
        Map<String, String> expectedCandidate = getPositionDataFromFile(type, "candidates");
        List<Map<String, Object>> allCandidates = restClient.getCandidates();
        int expectedId = readTestDataInteger("lastCreatedCandidateId");
        boolean isFound = false;
        for (Map<String, Object> actualCandidate : allCandidates) {
            int actualId = (Integer) actualCandidate.get("id");
            if (actualId == expectedId) {
                isFound = true;
                for(String key : expectedCandidate.keySet()) {
                    if (key.equals("email")) {
                        assertThat(actualCandidate.get(key)).isEqualTo(readTestDataString("lastCreatedCandidateEmail"));
                    } else if (key.equals("password")) {
                        assertThat(true).isTrue();
                    }
                    else {
                        System.out.println("Verifying " + key);
                        System.out.println("Actual value: " + actualCandidate.get(key));
                        System.out.println("Expected value: " + expectedCandidate.get(key));
                        assertThat(actualCandidate.get(key)).isEqualTo(expectedCandidate.get(key));
                    }
                }
                break;
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I add via REST API {string} resume to a new candidate")
    public void iAddViaRESTAPIResumeToANewCandidate(String fileType) {
        restClient.addResumeToCandidateByID(readTestDataInteger("lastCreatedCandidateId"), "ResumeODP", fileType);
    }

    @Then("I verify via REST API that {string} resume has been added")
    public void iVerifyViaRESTAPIThatResumeHasBeenAdded(String ext) {
        restClient.checkResumeAddedToCandidateByID(readTestDataInteger("lastCreatedCandidateId"));
    }

    @When("I update via REST API new {string} candidate")
    public void iUpdateViaRESTAPINewCandidate(String type) {
        Map<String, String> fieldsToUpdate = getPositionDataFromFile(type + "_updated", "candidates");
        int candidateIdToUpdate = readTestDataInteger("lastCreatedCandidateId");
        restClient.updateCandidateById(candidateIdToUpdate, fieldsToUpdate);
    }

    @Then("I verify via REST API new {string} candidate is updated")
    public void iVerifyViaRESTAPINewCandidateIsUpdated(String type) {
        int updatedCandidateId = readTestDataInteger("lastCreatedCandidateId");
        Map<String, String> expectedFields = getPositionDataFromFile(type + "_updated", "candidates");
        Map<String, Object> actualPosition = restClient.getCandidateById(updatedCandidateId);

        for(String key : expectedFields.keySet()) {
            System.out.println("Verifying " + key);
            System.out.println("Actual value: " + actualPosition.get(key));
            System.out.println("Expected value: " + expectedFields.get(key));
            assertThat(actualPosition.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST API new candidate")
    public void iDeleteViaRESTAPINewCandidate() {
        int candidateIdToDelete = readTestDataInteger("lastCreatedCandidateId");
        restClient.deleteCandidateByID(candidateIdToDelete);
    }

    @Then("I verify via REST API new candidate is deleted")
    public void iVerifyViaRESTAPINewCandidateIsDeleted() {
        int deletedCandidateId = readTestDataInteger("lastCreatedCandidateId");
        List<Map<String, Object>> allPositions = restClient.getPositions();
        for (Map<String, Object> actualPosition : allPositions) {
            int actualId = (Integer) actualPosition.get("id");
            assertThat(actualId).isNotEqualTo(deletedCandidateId);
        }
    }
}