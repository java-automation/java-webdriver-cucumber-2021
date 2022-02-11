package definitions;

import io.cucumber.java.en.And;
import support.RestClient;

import java.util.Map;

import static support.TestContext.getData;

public class RestStepDefs {

    Map<String, String> credentials = getData("recruiter", "secrets/careers");
    RestClient restClient = new RestClient(credentials);

    @And("I perform CRUD operations")
    public void iPerformCRUDOperations() {
        //CRUD operations

        //restClient.setBasicAuthCredentials(credentials);

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
}
