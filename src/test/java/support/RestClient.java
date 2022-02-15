package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.Map;

public class RestClient {

    private static Map<String, String> basicAuthCredentials;
    private static String bearerToken;

    public void login(Map<String, String> credientials) {
        if ((bearerToken != null) && (!bearerToken.isEmpty())) logout();
        basicAuthCredentials = credientials;

        System.out.println("\n----------------------------------------------");
        System.out.println("Login Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(getBasicAuthLogin(),getBasicAuthPassword())
                .baseUri("https://skryabin.com/recruit/api/v1")
                .contentType("application/json")
                .body(credientials)
                .log().all();

        Response response = request
                .when()
                .post("/login");

        System.out.println("\n----------------------------------------------");
        System.out.println("Login Response Log");
        System.out.println("----------------------------------------------");
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        bearerToken = "Bearer " + result.get("token"); //auto cast Object -> String
    }

    public void logout() {
        System.out.println("\n----------------------------------------------");
        System.out.println("Logout Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .contentType("application/json")
                .log().all();

        Response response = request
                .when()
                .post("/logout");

        System.out.println("\n----------------------------------------------");
        System.out.println("Logout Response Log");
        System.out.println("----------------------------------------------");
        response
                .then()
                .log().all()
                .statusCode(200);
    }

    public List<Map<String, Object>> getPositions() {
        System.out.println("\n----------------------------------------------");
        System.out.println("Get Positions Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/positions");

        System.out.println("\n----------------------------------------------");
        System.out.println("Get Positions Response Log");
        System.out.println("----------------------------------------------");
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
        System.out.println("\n----------------------------------------------");
        System.out.println("Get Position By ID Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/positions/" + id);

        System.out.println("\n----------------------------------------------");
        System.out.println("Get Position By ID Response Log");
        System.out.println("----------------------------------------------");
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
        System.out.println("\n----------------------------------------------");
        System.out.println("Create Position Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .contentType("application/json")
                .body(position)
                .log().all();

        Response response = request
                .when()
                .post("/positions");

        System.out.println("\n----------------------------------------------");
        System.out.println("Create Position Response Log");
        System.out.println("----------------------------------------------");
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        return (Integer) result.get("id");
    }

    public Map<String, Object> updatePositionById(Map<String, String> position, int id) {
        System.out.println("\n----------------------------------------------");
        System.out.println("Update Position By ID Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .contentType("application/json")
                .body(position)
                .log().all();

        Response response = request
                .when()
                .patch("/positions/" + id);

        System.out.println("\n----------------------------------------------");
        System.out.println("Update Position By ID Response Log");
        System.out.println("----------------------------------------------");
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

    public void deletePositionById(int id) {
        System.out.println("\n----------------------------------------------");
        System.out.println("Delete Position By ID Request & Response Logs");
        System.out.println("----------------------------------------------");
        RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .log().all()
                .when()
                .delete("/positions/" + id)
                .then()
                .log().all()
                .statusCode(204);
    }

    public int createCandidate(Map<String, String> candidateProfile) {
        System.out.println("\n----------------------------------------------");
        System.out.println("Create Candidate Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .contentType("application/json")
                .body(candidateProfile)
                .log().all();

        Response response = request
                .when()
                .post("/candidates");

        System.out.println("\n----------------------------------------------");
        System.out.println("Create Candidate Response Log");
        System.out.println("----------------------------------------------");
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        return (Integer) result.get("id");
    }

    public List<Map<String, Object>> getCandidates() {
        System.out.println("\n----------------------------------------------");
        System.out.println("Get Candidates Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/candidates");

        System.out.println("\n----------------------------------------------");
        System.out.println("Get Candidates Response Log");
        System.out.println("----------------------------------------------");
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
        System.out.println("\n----------------------------------------------");
        System.out.println("Get Candidate By ID Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/candidates/" + id);

        System.out.println("\n----------------------------------------------");
        System.out.println("Get Candidate By ID Response Log");
        System.out.println("----------------------------------------------");
        Map<String, Object> candidate = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return candidate;
    }

    public Map<String, Object> updateCandidateById(Map<String, String> candidateProfile, int id) {
        System.out.println("\n----------------------------------------------");
        System.out.println("Update Candidate By ID Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .contentType("application/json")
                .body(candidateProfile)
                .log().all();

        Response response = request
                .when()
                .patch("/candidates/" + id);

        System.out.println("\n----------------------------------------------");
        System.out.println("Update Candidate By ID Response Log");
        System.out.println("----------------------------------------------");
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");

        return result;
    }

    public void deleteCandidateById(int id) {
        System.out.println("\n----------------------------------------------");
        System.out.println("Delete Candidate By ID Request & Response Logs");
        System.out.println("----------------------------------------------");
        RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .log().all()
                .when()
                .delete("/candidates/" + id)
                .then()
                .log().all()
                .statusCode(204);
    }

    private String getBasicAuthLogin() {
        return basicAuthCredentials.get("email");
    }

    private String getBasicAuthPassword() {
        return basicAuthCredentials.get("password");
    }

    private String getBasicAuthHeader() {
        return "Basic " + Base64.getEncoder().encodeToString((getBasicAuthLogin() + ":" + getBasicAuthPassword()).getBytes());
    }

    public void addResumeForCandidate(int candidateId, File resumeFile) {
        System.out.println("\n----------------------------------------------");
        System.out.println("Add Resume For Candidate With ID Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .multiPart("resume", resumeFile, "multipart/form-data")
                .log().all();

        Response response = request
                .when()
                .post("/candidates/" + candidateId + "/resume");

        System.out.println("\n----------------------------------------------");
        System.out.println("Add Resume For Candidate With ID Response Log");
        System.out.println("----------------------------------------------");
        response
                .then()
                .log().all()
                .statusCode(201);
    }

    public InputStream getResumeForCandidate(int candidateId, String expectedFileName) {
        System.out.println("\n----------------------------------------------");
        System.out.println("Get Resume For Candidate With ID Request Log");
        System.out.println("----------------------------------------------");
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/candidates/" + candidateId + "/resume");

        System.out.println("\n----------------------------------------------");
        System.out.println("Get Resume For Candidate With ID Request Log");
        System.out.println("----------------------------------------------");
        InputStream result = response
                .then()
                .log().all()
                .statusCode(200)
                .header("content-disposition", "attachment; filename=" + expectedFileName)
                .extract()
                .asInputStream();

        return result;
    }
}
