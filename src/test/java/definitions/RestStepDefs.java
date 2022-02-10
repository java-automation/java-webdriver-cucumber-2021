package definitions;

import io.cucumber.java.en.*;
import support.*;

import java.util.*;

import static support.TestContext.getData;

public class RestStepDefs {

    RestClient restClient = new RestClient();
    Map<String, String> automation = getData("automation", "positions");
    Map<String, String> update = getData("update", "positions");

    @Given("I play with rest api")
    public void iPlayWithRest() {
        // CRUD operations for position

        // CREATE
        int createdId = restClient.createPosition(automation);

        // READ
        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);

        // UPDATE
        restClient.updatePosition(createdId, update);

        // READ - verify update
        restClient.getPositionById(createdId);

        // DELETE
        restClient.deletePosition(createdId);
    }
}
