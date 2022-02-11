package definitions;

import io.cucumber.java.en.Given;
import support.RestClient;

import java.util.List;
import java.util.Map;

import static support.TestContext.getData;

public class RestStepDefs {
    RestClient restClient = new RestClient();
    Map<String, String> automation = getData("automation", "positions");
    Map<String, String> newCandidates = getData("new_candidate1", "careers");
    long currentTimeMillis = System.currentTimeMillis();

    @Given("I work with rest api")
    public void iWorkWithRestApi() {
        // CRUD operations for position

        // CREATE
        int createdId = restClient.createPosition(automation);

        // READ
//        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);

        // UPDATE


        // DELETE

    }

    @Given("I get positions with rest api")
    public void iGetPositionsWithRestApi() {
        List<Map<String, Object>> positions = restClient.getPositions();
    }

    @Given("I create new candidate rest api")
    public void iCreateNewCandidateRestApi() {
        // CRUD operations for position

        // CREATE
        String newEmail = newCandidates.get("email").replace("@", currentTimeMillis + "@");
        newCandidates.replace("email", newEmail);
        int createdId = restClient.createCandidate(newCandidates);

        // READ
        // List<Map<String, Object>> candidates = restClient.getCandidates();
        System.out.println("I create new candidate!");
        Map<String, Object> candidatesId = restClient.getCandidateById(createdId);

        // UPDATE


        // DELETE

    }

    @Given("I get candidates with rest api")
    public void iGetCandidatesWithRestApi() {
        List<Map<String, Object>> candidates = restClient.getCandidates();
    }
}
