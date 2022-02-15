package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.RestClient;

import java.io.*;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class RestStepDefs {

    RestClient restClient = new RestClient();
//    Map<String, String> new_position = getData("new_position", "positions");
//    Map<String, String> updated_position = getData("updated_position", "positions");
//    Map<String, String> patched_position = getData("patched_position", "positions");
//    Map<String, String> new_candidate = getData("new_candidate", "candidates");
//    Map<String, String> updated_candidate = getData("updated_candidate", "candidates");
//    Map<String, String> patched_candidate = getData("patched_candidate", "candidates");

    @Given("I work with positions rest api")
    public void iWorkWithPositionsRestApi() {
        // CRUD operations for position

        // CREATE
        int createdId = restClient.createPosition(getPositionDataWithFittings("new_position","positions"));

        // READ
        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);

        // UPDATE
        int updatedId = restClient.updatePosition(createdId, getPositionDataWithFittings("updated_position","positions"));
        assertThat(updatedId).isEqualTo(createdId);

        // PATCH
        int patchedId = restClient.patchedPosition(createdId, getPositionDataWithFittings("patched_position","positions"));
        assertThat(patchedId).isEqualTo(createdId);

        // DELETE
        restClient.deletePosition(createdId);
    }

    @And("I work with candidates rest api")
    public void iWorkWithCandidateRestApi() {
//        // CRUD operations for position
//
//        // CREATE
//        String emailWithUniquePostfix = addUniquePostfix(new_candidate.get("email"));
//        new_candidate.put("email", emailWithUniquePostfix);
//        int createdId = restClient.createCandidate(new_candidate);
//
//        // READ
//        List<Map<String,String>> candidates = restClient.getCandidates();
//        Map<String,String> candidate = restClient.getCandidateById(createdId);
//
//        // UPDATE
//        // using email used when creating this candidate
//        updated_candidate.put("email",emailWithUniquePostfix);
//        int updatedId = restClient.updateCandidate(createdId, updated_candidate);
//        assertThat(updatedId).isEqualTo(createdId);
//
//        // PATCH
//        patched_candidate.put("email",emailWithUniquePostfix);
//        int patchedId = restClient.patchedCandidate(createdId, patched_candidate);
//        assertThat(patchedId).isEqualTo(createdId);
//
//        // DELETE
//        restClient.deleteCandidate(createdId);
    }

    @Given("I login via REST API as {string}")
    public void iLoginViaRESTAPIAs(String role) {
        Map<String, String> credentials = getData(role, "careers");
        restClient.login(credentials);
    }

    @When("I create via REST API {string} position")
    public void iCreateViaRESTAPIPosition(String type) {
        Map<String, String> positionFromFile = getPositionDataWithFittings(type, "positions");
        restClient.createPosition(positionFromFile);
    }

    @Then("I verify via REST API new {string} position is in the list")
    public void iVerifyViaRESTAPINewPositionIsInTheList(String type) {
        Map<String, String> expectedPosition = getPositionDataWithFittings(type, "positions");
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
        Map<String, String> fieldsToUpdate = getPositionDataWithFittings(type + "_updated", "positions");
        int positionIdToUpdate = readTestDataInteger("lastCreatedPositionId");
        restClient.updatePosition(positionIdToUpdate, fieldsToUpdate);
    }

    @Then("I verify via REST API new {string} position is updated")
    public void iVerifyViaRESTAPINewPositionIsUpdated(String type) {
        int updatedPositionId = readTestDataInteger("lastCreatedPositionId");
        Map<String, String> expectedFields = getPositionDataWithFittings(type + "_updated", "positions");
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
        restClient.deletePosition(positionIdToDelete);
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
        Map<String, String> candidate = getCandidateDataWithFittings(type,"candidates");
        restClient.createCandidate(candidate);
    }

    @Then("I verify via REST API new {string} candidate is in the list")
    public void iVerifyViaRESTAPINewCandidateIsInTheList(String type) {
        Map<String, String> expectedCandidate = getCandidateDataWithFittings(type,"candidates");
        int expectedCandidateId = readTestDataInteger("lastCreatedCandidateId");
        List<Map<String,Object>> allCandidates = restClient.getCandidates();
        boolean isFound = false;
        for (Map<String,Object> actualCandidate : allCandidates) {
            if (((Integer) actualCandidate.get("id")) == expectedCandidateId) {
               isFound = true;
               for (String key : expectedCandidate.keySet()) {
                   if (key.equals("password")) {
                       assertThat(actualCandidate.get(key)).isNull();
                   } else {
                       assertThat(actualCandidate.get(key)).isEqualTo(expectedCandidate.get(key));
                   }
               }
            }
        }
        assertThat(isFound).isTrue();
    }

    @When("I add via REST API {string} resume to a new candidate")
    public void iAddViaRESTAPIResumeToANewCandidate(String resumeType) {
        File resumeFile = new File("src/test/resources/data/resume." + resumeType);
        int candidateId = readTestDataInteger("lastCreatedCandidateId");
        byte[] byteArr = restClient.addResume(candidateId, resumeFile, resumeType);
        assertThat(byteArr.length).isEqualTo(0);
    }

    @Then("I verify via REST API that {string} resume has been added")
    public void iVerifyViaRESTAPIThatResumeHasBeenAdded(String resumeType) {
        int candidateId = readTestDataInteger("lastCreatedCandidateId");
        byte[] actualByteArr = restClient.getResume(candidateId);
// writing resume gotten as a response into file
//        File actualResume = new File("src/test/resources/data/resumeDownloaded." + resumeType);
//        actualResume.delete();
//        try {
//            OutputStream outStream = new FileOutputStream(actualResume);
//            outStream.write(actualByteArr);
//            outStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File expectedResume = new File("src/test/resources/data/resume." + resumeType);
        BufferedReader actualBr, expectedBr;
        try {
//            actualBr = new BufferedReader(new FileReader(actualResume));
            actualBr = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(actualByteArr)));
            expectedBr = new BufferedReader(new FileReader(expectedResume));
            for (String line = expectedBr.readLine(); line != null; line = expectedBr.readLine()) {
                assertThat(line).isEqualTo(actualBr.readLine());
                System.out.println("+");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @When("I update via REST API new {string} candidate")
    public void iUpdateViaRESTAPINewCandidate(String type) {
        int updatedCandidateId = readTestDataInteger("lastCreatedCandidateId");
        Map<String, String> fieldsToUpdate = getCandidateDataWithFittings(type + "_updated", "candidates");
        restClient.updateCandidate(updatedCandidateId, fieldsToUpdate);
    }

    @Then("I verify via REST API new {string} candidate is updated")
    public void iVerifyViaRESTAPINewCandidateIsUpdated(String type) {
        int updatedCandidateId = readTestDataInteger("lastCreatedCandidateId");
        Map<String, String> expectedCandidate = getCandidateDataWithFittings(type + "_updated","candidates");
        Map<String, Object> actualCandidate = restClient.getCandidateById(updatedCandidateId);
        for (String key : expectedCandidate.keySet()) {
            System.out.println("Verifying " + key);
            System.out.println("Actual value: " + actualCandidate.get(key));
            System.out.println("Expected value: " + expectedCandidate.get(key));
            assertThat(actualCandidate.get(key)).isEqualTo(expectedCandidate.get(key));
        }
    }

    @When("I delete via REST API new candidate")
    public void iDeleteViaRESTAPINewCandidate() {
        int candidateIdToDelete = readTestDataInteger("lastCreatedCandidateId");
        restClient.deleteCandidate(candidateIdToDelete);
    }

    @Then("I verify via REST API new candidate is deleted")
    public void iVerifyViaRESTAPINewCandidateIsDeleted() {
        int deletedCandidateId = readTestDataInteger("lastCreatedCandidateId");
        List<Map<String, Object>> allCandidates = restClient.getCandidates();
        for (Map<String, Object> actualPosition : allCandidates) {
            int actualId = (Integer) actualPosition.get("id");
            assertThat(actualId).isNotEqualTo(deletedCandidateId);
        }
    }

}
