package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static support.TestContext.getData;

public class RestClient {

//    private String getBasicAuthHeader() {
//        Map<String, String> credentials = getData("recruiter", "careers");
//        String username = credentials.get("email");
//        String password = credentials.get("password");
//        String authString = username + ":" + password;
//        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
//        String authHeader = "Basic " + encodedAuthString;
//        return authHeader;
//    }

    public List<Map<String, Object>> getPositions() {
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .get("/positions");

        // parse response
        List<Map<String, Object>> positions = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        return positions;
    }

    public Map<String, Object> getPositionById(int id) {
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .get("/positions/" + id);

        // parse response
        Map<String, Object> position = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return position;
    }

    public int createPosition(Map<String, String> position) {

        Map<String, String> credentials = getData("recruiter");

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(position)
                .log().all();

        // execute request
        Response response = request
                .when()
                .post("/positions");

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        int id = (Integer) result.get("id");

        return id;
    }

    public void updatePosition(String field, String updatedValue, int id) {

        Map<String, String> credentials = getData("recruiter");
        Map<String,String> updatedPosition = new HashMap<>();
        updatedPosition.put(field,updatedValue);

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(updatedPosition)
                .log().all();

        // execute request
        Response response = request
                .when()
                .patch("/positions" + id);

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

    }

    public void deletePosition(int id){
        Map<String, String> credentials = getData("recruiter");

        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .log().all();

        // execute request
        Response response = request
                .when()
                .delete("/positions" + id);

        // parse response

        ValidatableResponse result = response
                .then()
                .log().all()
                .statusCode(204);
    }
    /////////////////////////////// Candidate //////////////////////////////////////////////

    public List<Map<String, Object>> getCandidates() {
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .get("/candidate");

        // parse response
        List<Map<String, Object>> candidates = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        return candidates;
    }


    public Map<String, Object> getCandidateById(int id) {
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .get("/candidate/" + id);

        // parse response
        Map<String, Object> candidate = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return candidate;
    }

    public int createCandidate(Map<String, String> candidate) {

        Map<String, String> credentials = getData("candidate");

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(candidate)
                .log().all();

        // execute request
        Response response = request
                .when()
                .post("/candidate");

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        int idCandidate = (Integer) result.get("id");

        return idCandidate;

    }
    public void updateCandidate(String field, String updatedValue, int id) {

        Map<String, String> credentials = getData("candidate");
        Map<String,String> updatedCandidate = new HashMap<>();
        updatedCandidate.put(field,updatedValue);

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(updatedCandidate)
                .log().all();

        // execute request
        Response response = request
                .when()
                .patch("/candidate" + id);

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

    }

    public void deleteCandidate(int id){
        Map<String, String> credentials = getData("candidate");

        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .log().all();

        // execute request
        Response response = request
                .when()
                .delete("/candidate" + id);

        // parse response

        ValidatableResponse result = response
                .then()
                .log().all()
                .statusCode(204);
    }


}

