package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;
import java.util.List;
import java.util.Map;

public class RestClient {

    private static Map<String, String> basicAuthCredentials;
    private static String bearerToken;

    public void login(Map<String, String> credientials) {
        if ((bearerToken != null) && (!bearerToken.isEmpty())) logout();
        basicAuthCredentials = credientials;

        System.out.println("\n------------------------------");
        System.out.println("Login Request Log");
        System.out.println("------------------------------");
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
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", bearerToken)
                .contentType("application/json")
                .log().all();

        Response response = request
                .when()
                .post("/logout");

        response
                .then()
                .log().all()
                .statusCode(200);
    }

    public List<Map<String, Object>> getPositions() {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/positions");

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
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/positions/" + id);

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
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/candidates");

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
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        Response response = request
                .when()
                .get("/candidates/" + id);

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
}
