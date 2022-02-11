package definitions;

import io.cucumber.java.en.Given;
import support.RestClient;

import java.util.Map;

import static support.TestContext.getData;

public class RestStepDefs {

    RestClient restClient = new RestClient();

    Map<String, String> automation = getData("positions");
    Map<String, String> candidateInfo = getData("candidate");


    @Given("I work with rest api")
    public void iWorkWithRestApi(){

        // CRUD operations for position

        // CREATE position
        int createdId = restClient.createPosition(automation);

        // READ position
//        List<Map<String, Object>> positions = restClient.getPositions();
        Map<String, Object> position = restClient.getPositionById(createdId);


        // UPDATE position
        restClient.updatePosition("zip","10013", createdId);


        // DELETE position
        restClient.deletePosition(createdId);



        //////////////////// Candidates/////////////////////

        // READ candidate
        Map<String, Object> candidate = restClient.getCandidateById(createdId);

      // CREATE candidate
       int candidate1 = restClient.createCandidate(candidateInfo);

        // UPDATE candidate
        restClient.updateCandidate("zip","60644", createdId);

        // DELETE candidate
        restClient.deleteCandidate(createdId);
    }


    }

