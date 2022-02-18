package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.saveTestData;

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
        Map<String, Object> candidate = response
                .then()
                .log().all()
                .statusCode(200) //200 -- A single candidate
                .extract()
                .jsonPath()
                .getMap("");

        return candidate;
    }

    public int createPosition(Map<String, String> position) {

        Map<String, String> credentials = getData("recruiter", "careers");

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
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
        saveTestData("lastCreatedPositionId", id);
        saveTestData("lastCreatedPosition", result);
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

    public void deletePositionById(int id) {
        System.out.println("---------------------------------------");
        System.out.println("Delete Position By Id Request Log");
        System.out.println("---------------------------------------");
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", authToken)
                .log().all();

        // execute request
        Response response = request
                .when()
                .delete("/positions/" + id);

        System.out.println("\n---------------------------------------");
        System.out.println("Delete Position By Id Response Log");
        System.out.println("---------------------------------------");
        // parse response
        response
                .then()
                .log().all()
                .statusCode(204);
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

    public int createCandidate(Map<String, String> candidate) {

        Map<String, String> credentials = getData("recruiter", "careers");

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
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
                .statusCode(201) //201 -- Successfully created
                .extract()
                .jsonPath()
                .getMap("");

        int id = (Integer) result.get("id");
        saveTestData("lastCreatedCandidateId", id);
        return (Integer) result.get("id");
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

    public void deleteCandidateById(int id) {
        System.out.println("---------------------------------------");
        System.out.println("Delete Candidate By Id Request Log");
        System.out.println("---------------------------------------");
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", authToken)
                .log().all();

        // execute request
        Response response = request
                .when()
                .delete("/candidates/" + id);

        System.out.println("\n---------------------------------------");
        System.out.println("Delete Candidate By Id Response Log");
        System.out.println("---------------------------------------");
        // parse response
        response
                .then()
                .log().all()
                .statusCode(204);
    }

    public List<Map<String, Object>> getResumeByCandidateId(int id) {

        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", authToken)
                .contentType("multipart/form-data")
                .log().all();

        // execute request
        Response response = request
                .when()
                .get("/candidates/" + id + "/resume");

        // parse response
        List<Map<String, Object>> resumeByCandidateId = response
                .then()
                .log().all()
                .statusCode(200) // 200 -- Resume of the candidate
                .extract()
                .htmlPath()
                .getList("");

        return resumeByCandidateId;
    }

    public void createResumeByCandidateId(int id) throws IOException {
        String resumeAbsolutePathToFile = "/Users/gavrilova/Downloads/SilverCamp/java-webdriver-cucumber/src/test/resources/data/downloadedResume.pdf";
        Path pdfPath = Paths.get(resumeAbsolutePathToFile);
        File resume = pdfPath.toFile();
        // prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", authToken)
                .contentType("multipart/form-data")
                .multiPart("resume", resume)
                .log().all();

        // execute request
        Response response = request
                .when()
                .post("/candidates/" + id + "/resume/");

        // parse response
    }

    public int getPositionIdByTitle(String title) {
        //prepare a request
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .param("title", title)
                .log().all();
        //execute request
        Response response = requestSpecification
                .when()
                .get("/positions");
        //parse response
        List<Map<String, Object>> positions = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");

        int id = (Integer) positions.get(0).get("id");
        System.out.println("Position id to cleanUp = " + id);
        System.out.println("Position title to cleanUp = " + positions.get(0).get("title"));
        return id;
    }
}
