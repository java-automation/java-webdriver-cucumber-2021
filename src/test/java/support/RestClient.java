package support;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.collections.Maps;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.readTestDataString;

public class RestClient {

    private static String authToken;

//    private String getBasicAuthHeader() {
//        Map<String, String> credentials = getData("recruiter", "careers");
//        String username = credentials.get("email");
//        String password = credentials.get("password");
//        String authString = username + ":" + password;
//        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
//        String authHeader = "Basic " + encodedAuthString;
//        return authHeader;
//    }
    String newPositionEmail = "";

    public void login(Map<String, String> credentials) {

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(credentials)
                .log().all();

        // execute request
        Response response = request
                .when()
                .post("/login");

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        String token = (String) result.get("token");
        System.out.println(token);

        authToken = "Bearer " + token;
    }

    public void logout() {

        System.out.println("---------------------------------------");
        System.out.println("Logout Request Log");
        System.out.println("---------------------------------------");
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                .log().all();

        // execute request
        Response response = request
                .when()
                .post("/logout");

        System.out.println("\n---------------------------------------");
        System.out.println("Logout Response Log");
        System.out.println("---------------------------------------");
        // parse response
        response
                .then()
                .log().all()
                .statusCode(200);
    }

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

        Map<String, String> credentials = getData("recruiter", "careers");

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

    public void updatePositionById(int id, Map<String, String> fieldsToUpdate) {
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                .body(fieldsToUpdate)
                .log().all();

        // execute request
        Response response = request
                .when()
                .patch("/positions/" + id);

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

    }

    public void deletePositionByID(int id) {

        Map<String, String> credentials = getData("recruiter", "careers");

        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .delete("/positions/" + id);

        // parse response
        ValidatableResponse result = response
                .then()
                .log().all()
                .statusCode(204);
    }

    public int createCandidate(Map<String, String> candidate) {
        Map<String, String> credentials = getData("recruiter", "careers");
        newPositionEmail = candidate.get("email");

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(candidate)
                .log().all();

        // execute request
        Response response = request
                .when()
                .post("/candidates");

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

    public Map<String, Object> getCandidateById(int id) {
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .get("/candidates/" + id);

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

    public void updateCandidateByID(String field, String newValue, int id) {

        Map<String, String> credentials = getData("automation", "candidates");
        Map<String, String> fieldUpdate = new HashMap<>();
        fieldUpdate.put(field, newValue);

        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(newPositionEmail, credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(fieldUpdate)
                .log().all();

        // execute request
        Response response = request
                .when()
                .patch("/candidates/" + id);

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
    }

    public void deleteCandidateByID(int id) {

        Map<String, String> credentials = getData("automation", "candidates");

        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(newPositionEmail, credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .delete("/candidates/" + id);

        // parse response
        ValidatableResponse result = response
                .then()
                .log().all()
                .statusCode(204);
    }

    public List<Map<String, Object>> getCandidates() {
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .get("/candidates");

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

    public void addResumeToCandidateByID(int id, String fileName, String ext) {

        Map<String, String> credentials = getData("sdet", "candidates");
        String resume = System.getProperty("user.dir") + "/src/test/resources/data/" + fileName + "." + ext;

        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(readTestDataString("lastCreatedCandidateEmail"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "multipart/form-data")
                .multiPart("resume", new File(resume), ext)
//                .body(resume)
                .log().all();

        // execute request
        Response response = request
                .when()
                .post("/candidates/" + id + "/resume");

        // parse response
        response
                .then()
                .log().all()
                .statusCode(201);
    }

    public void checkResumeAddedToCandidateByID(int id) {
        Map<String, String> credentials = getData("sdet", "candidates");
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        // execute request
        Response response = request
                .when()
                .get("/candidates/" + id + "/resume");

        // parse response
        response
                .then()
                .log().all()
                .statusCode(200);
    }

    public void updateCandidateById(int id, Map<String, String> fieldsToUpdate) {
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
                .body(fieldsToUpdate)
                .log().all();

        // execute request
        Response response = request
                .when()
                .patch("/candidates/" + id);

        // parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

    }


}