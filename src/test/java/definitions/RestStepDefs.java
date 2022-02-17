package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import support.RestClientt;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class RestStepDefs {
    RestClientt restClient = new RestClientt();
    Map<String,String> automation = getData("automation","positions");

    @Given("I work with rest api")
    public void iWorkWithRestApi() {
        Map<String,String> credentials = getData("recruiter", "careers");
        //LOGIN
        restClient.login(credentials);

        // Create
        int createId = restClient.createPosition(automation);

        //READ
        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String,Object> position = restClient.getPositionById(createId);
//        System.out.println("Created ID: " +createId);


        // update
//        automation.put("title","Updated title");
//        automation.put("city", "Glendale");
//        Map<String,Object> updatedPosition = restClient.updatePosition(automation,createId);
//        restClient.deletePositionById(261);
//        System.out.println(updatedPosition.get("title"));
//        assertThat(updatedPosition.get("title")).isEqualTo( automation.get("title"));
//        updatedPosition.get("title");


    }

    @Given("I login via REST API as {string}")
    public void iLoginViaRESTAPIAs(String role) {
        Map<String,String> credentials = getData(role, "careers");
        //LOGIN
        restClient.login(credentials);
    }

    @When("I create via REST API {string} position")
    public void iCreateViaRESTAPIPosition(String type) {
    }
}
