package definitions;

import io.cucumber.java.en.And;
import support.RestClient;

import java.util.Map;

import static support.TestContext.getData;

public class RestStepDefs {

    Map<String, String> defaultCredentials = getData("recruiter", "secrets/careers");
    RestClient restClient = new RestClient(defaultCredentials);

    @And("I perform CRUD operations with positions")
    public void iPerformCRUDOperationsWithPositions() {
        //CREATE
        Map<String, String> position = getData("position2", "careers");
        int id = restClient.createPosition(position);

        //READ
        //restClient.getPositions();
        restClient.getPositionById(id);

        //UPDATE
        position.put("title", "new updated Leet Programmer");
        position.put("description", "Moved office to Canada!");
        position.put("city", "Calgary");
        position.put("state", "AB");
        restClient.updatePositionById(position, id);

        //DELETE
        restClient.deletePositionById(id);
    }

    @And("I perform CRUD operations with candidates")
    public void iPerformCRUDOperationsWithCandidates() {
        //CREATE
        Map<String, String> candidateProfile = getData("candidate2", "careers");
        Map<String, String> candidateCredentials = getData("candidate2", "secrets/careers");
        candidateProfile.putAll(candidateCredentials);
        int id = restClient.createCandidate(candidateProfile);

        //READ
        restClient.getCandidateById(id);

        //UPDATE
        candidateProfile.put("address", "123 Main St");
        candidateProfile.put("summary", "I live in Canada!");
        candidateProfile.put("city", "Calgary");
        candidateProfile.put("state", "AB");
        restClient.updateCandidateById(candidateProfile, id);

        //DELETE
        restClient.deleteCandidateById(id);
    }
}
