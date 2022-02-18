package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.RestClient;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs {
    RestClient restClient = new RestClient();
    Map<String, String> automation = getPositionDataFromFile("automation", "positions");
    Map<String, String> fieldsToUpdate = getPositionDataFromFile("automation_updated", "positions");
    Map<String, String> newCandidates = getPositionDataFromFile("new_candidate1", "careers");
    Map<String, String> fieldsToUpdateCandidate = getCandidateDataFromFile("sdet_updated", "careers");
    long currentTimeMillis = System.currentTimeMillis();

    @Given("I work with rest api")
    public void iWorkWithRestApi() {
        // CRUD operations for position
        Map<String, String> credentials = getData("recruiter", "careers");

        // LOGIN
        restClient.login(credentials);
        // CREATE
        String newTitle = automation.get("title") + " " + currentTimeMillis;
        automation.replace("title", newTitle);
        int createdId = restClient.createPosition(automation);

        // READ
//        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);

        // UPDATE
        restClient.updatePositionById(createdId, fieldsToUpdate);

        // DELETE
        restClient.deletePositionById(createdId);
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

        for (String key : expectedFields.keySet()) {
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

    @Given("I create new position rest api")
    public void iCreateNewPositionRestApi() {
        String newTitle = automation.get("title") + currentTimeMillis;
        automation.replace("title", newTitle);
        int createdId = restClient.createPosition(automation);
        Map<String, Object> position = restClient.getPositionById(createdId);
    }

    @Given("I get positions with rest api")
    public void iGetPositionsWithRestApi() {
        List<Map<String, Object>> positions = restClient.getPositions();
    }

    @Given("I create new candidate rest api")
    public void iCreateNewCandidateRestApi() {
        // CRUD operations for candidate
        Map<String, String> credentials = getData("recruiter", "careers");
        // LOGIN
        restClient.login(credentials);
        // CREATE
        String newEmail = newCandidates.get("email").replace("@", currentTimeMillis + "@");
        newCandidates.replace("email", newEmail);
        int createdId = restClient.createCandidate(newCandidates);

        // READ
        // List<Map<String, Object>> candidates = restClient.getCandidates();
        Map<String, Object> candidatesId = restClient.getCandidateById(createdId);

        // UPDATE

        restClient.updateCandidateById(createdId, fieldsToUpdateCandidate);
        // DELETE
        restClient.deleteCandidateById(createdId);
    }

    @Given("I get candidates with rest api")
    public void iGetCandidatesWithRestApi() {
        List<Map<String, Object>> candidates = restClient.getCandidates();
    }


    @When("I create via REST API {string} candidate")
    public void iCreateViaRESTAPICandidate(String type) {
        Map<String, String> candidateFromFile = getCandidateDataFromFile(type, "careers");
        restClient.createCandidate(candidateFromFile);
    }

    @Then("I verify via REST API new {string} candidate is in the list")
    public void iVerifyViaRESTAPINewCandidateIsInTheList(String type) {
        Map<String, String> expectedCandidates = getCandidateDataFromFile(type, "careers");
        List<Map<String, Object>> allCandidates = restClient.getCandidates();
        int expectedId = readTestDataInteger("lastCreatedCandidateId");
        boolean isFound = false;
        for (Map<String, Object> actualCandidate : allCandidates) {
            int actualId = (Integer) actualCandidate.get("id");
            if (actualId == expectedId) {
                isFound = true;
                for (String key : expectedCandidates.keySet()) {
                    if (!key.equals("password")) {
                        System.out.println("Verifying " + key);
                        System.out.println("Actual value: " + actualCandidate.get(key));
                        System.out.println("Expected value: " + expectedCandidates.get(key));
                        assertThat(actualCandidate.get(key)).isEqualTo(expectedCandidates.get(key));
                    } else System.out.println("Password field is not verified!");
                }
                break;
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I add via REST API {string} resume to a new candidate")
    public void iAddViaRESTAPIResumeToANewCandidate(String fileType) throws IOException {
        int id = readTestDataInteger("lastCreatedCandidateId");
        restClient.createResumeByCandidateId(id);
/*
A hint on resume file addition headers in rest assured request:
.multiPart("resume", resume)
Where resume is File type.
 */
    }

    @Then("I verify via REST API that {string} resume has been added")
    public void iVerifyViaRESTAPIThatResumeHasBeenAdded(String fileType) {
        int id = readTestDataInteger("lastCreatedCandidateId");
        restClient.getResumeByCandidateId(id);
    }

    @When("I update via REST API new {string} candidate")
    public void iUpdateViaRESTAPINewCandidate(String type) {
        Map<String, String> fieldsToUpdateCandidate = getCandidateDataFromFile(type + "_updated", "careers");
        int candidateIdUToUpdate = readTestDataInteger("lastCreatedCandidateId");
        restClient.updateCandidateById(candidateIdUToUpdate, fieldsToUpdateCandidate);
    }

    @Then("I verify via REST API new {string} candidate is updated")
    public void iVerifyViaRESTAPINewCandidateIsUpdated(String type) {
        int updatedCandidateId = readTestDataInteger("lastCreatedCandidateId");
        Map<String, String> expectedFields = getCandidateDataFromFile(type + "_updated", "careers");
        Map<String, Object> actualCandidate = restClient.getCandidateById(updatedCandidateId);

        for (String key : expectedFields.keySet()) {
            System.out.println("Verifying " + key);
            System.out.println("Actual value: " + actualCandidate.get(key));
            System.out.println("Expected value: " + expectedFields.get(key));
            assertThat(actualCandidate.get(key)).isEqualTo(expectedFields.get(key));
        }
    }

    @When("I delete via REST API new candidate")
    public void iDeleteViaRESTAPINewCandidate() {
        int candidateIdToDelete = readTestDataInteger("lastCreatedCandidateId");
        restClient.deleteCandidateById(candidateIdToDelete);
    }

    @Then("I verify via REST API new candidate is deleted")
    public void iVerifyViaRESTAPINewCandidateIsDeleted() {
        int deletedCandidateId = readTestDataInteger("lastCreatedCandidateId");
        List<Map<String, Object>> allCandidates = restClient.getCandidates();
        for (Map<String, Object> actualCandidate : allCandidates) {
            int actualId = (Integer) actualCandidate.get("id");
            assertThat(actualId).isNotEqualTo(deletedCandidateId);
        }
    }
}
