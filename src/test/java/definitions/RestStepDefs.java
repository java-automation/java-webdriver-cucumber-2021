package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import support.RestClient;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class RestStepDefs {

    RestClient restClient = new RestClient();
    Map<String, String> new_position = getData("new_position", "positions");
    Map<String, String> updated_position = getData("updated_position", "positions");
    Map<String, String> patched_position = getData("patched_position", "positions");
    Map<String, String> new_candidate = getData("new_candidate", "candidates");
    Map<String, String> updated_candidate = getData("updated_candidate", "candidates");
    Map<String, String> patched_candidate = getData("patched_candidate", "candidates");

    private String addUniquePostfix(String email) {
        Matcher m = Pattern.compile("(.*)@(.*)").matcher(email);
        int rand = (int) (Math.random() * 1000000);
        if (m.find()) return m.group(1) + "-" + String.format("%06d",rand) + "@" + m.group(2);
        return email;
    }

    @Given("I work with positions rest api")
    public void iWorkWithPositionsRestApi() {
        // CRUD operations for position

        // CREATE
        int createdId = restClient.createPosition(new_position);

        // READ
        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);

        // UPDATE
        int updatedId = restClient.updatePosition(createdId, updated_position);
        assertThat(updatedId).isEqualTo(createdId);

        // PATCH
        int patchedId = restClient.patchedPosition(createdId, patched_position);
        assertThat(patchedId).isEqualTo(createdId);

        // DELETE
        restClient.deletePosition(createdId);
    }

    @And("I work with candidates rest api")
    public void iWorkWithCandidateRestApi() {
        // CRUD operations for position

        // CREATE
        String emailWithUniquePostfix = addUniquePostfix(new_candidate.get("email"));
        new_candidate.put("email", emailWithUniquePostfix);
        int createdId = restClient.createCandidate(new_candidate);

        // READ
        List<Map<String,String>> candidates = restClient.getCandidates();
        Map<String,String> candidate = restClient.getCandidateById(createdId);

        // UPDATE
        // using email used when creating this candidate
        updated_candidate.put("email",emailWithUniquePostfix);
        int updatedId = restClient.updateCandidate(createdId, updated_candidate);
        assertThat(updatedId).isEqualTo(createdId);

        // PATCH
        patched_candidate.put("email",emailWithUniquePostfix);
        int patchedId = restClient.patchedCandidate(createdId, patched_candidate);
        assertThat(patchedId).isEqualTo(createdId);

        // DELETE
        restClient.deleteCandidate(createdId);
    }
}
