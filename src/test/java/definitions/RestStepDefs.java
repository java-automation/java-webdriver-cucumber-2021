package definitions;

import io.cucumber.java.en.Given;
import support.RestClient;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import static org.apache.commons.net.ntp.TimeStamp.getTime;
import static support.TestContext.getData;

public class RestStepDefs {

    RestClient restClient = new RestClient();
    Map<String, String> automation = getData("automation", "positions");
    Map<String, String> candidate = getData("automation", "candidates");

    @Given("I work with rest api")
    public void iWorkWithRestApi() {
        // CRUD operations for position
        // CREATE
        int createdId = restClient.createPosition(automation);
        // READ
//        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);
        // UPDATE
        restClient.updatePositionByID("title", "Automation Engineer updated", createdId);
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
}