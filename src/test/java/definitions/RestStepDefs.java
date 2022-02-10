package definitions;

import io.cucumber.java.en.Given;
import support.RestClient;

import java.util.Map;

import static support.TestContext.getData;

public class RestStepDefs {

    RestClient restClient = new RestClient();
    Map<String, String> automation = getData("positions");

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


    }

