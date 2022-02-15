package support;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.List;
import java.util.Map;

import static support.TestContext.getData;
import static support.TestContext.saveTestData;

public class RestClient {

    Map<String,String> credentials = getData("recruiter","careers");
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
        // prepare request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();
        // send request
        Response response = request
                .when()
                .get("/positions");
        // parse request
        return response
                .then()
                .log().all()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .extract()
                .jsonPath()
                .getList("");
    }

    public Map<String, Object> getPositionById(int id) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();
        Response response = request
                .when()
                .get("/positions/" + id);
        return response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
    }

    public int createPosition(Map<String,String> position) {
        RequestSpecification request = RestAssured
                .given()
//                .header("Authorization",getBasicAuthHeader());
                .auth().preemptive().basic(credentials.get("email"),credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
//                .header("Content-Type","application/json")
                .contentType(ContentType.JSON)
                .body(position)
                .log().all();
        Response response = request
                .when()
                .post("/positions");
        Map<String, Object> createdPos = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        int id = (Integer) createdPos.get("id");

        saveTestData("lastCreatedPositionId", id);

        return id;
    }

    public int updatePosition(int id, Map<String,String> position) {
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"),credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type","application/json")
                .body(position)
                .log().all();
        Response response = request
                .when()
                .put("/positions/" + id);
        Map<String, Object> updatedPos = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        return (Integer) updatedPos.get("id");
    }

    public int patchedPosition(int id, Map<String,String> position) {
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"),credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type","application/json")
                .body(position)
                .log().all();
        Response response = request
                .when()
                .patch("/positions/" + id);
        Map<String, Object> patchedPos = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        return (Integer) patchedPos.get("id");
    }

    public void deletePosition(int id) {
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .auth().preemptive().basic(credentials.get("email"),credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1");
        Response response = request
                .when()
                .delete("/positions/" + id);
        response.then()
                .log().all()
                .statusCode(204);
    }

    public List<Map<String,Object>> getCandidates() {
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri("https://skryabin.com/recruit/api/v1");
        Response response = request
                .when()
                .get("/candidates");
        return response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getList("");
    }

    public Map<String,Object> getCandidateById(int id) {
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .baseUri("https://skryabin.com/recruit/api/v1");
        Response response = request
                .when()
                .get("/candidates/" + id);
        return response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
    }

    public int createCandidate(Map<String,String> candidate) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type","application/json")
                .body(candidate)
                .log().all();
        Response response = request
                .when()
                .post("/candidates");
        Map<String,Object> createdCandidate = response
                .then()
                .log().all()
                .statusCode(201)
                .extract()
                .jsonPath()
                .getMap("");

        // HTTP/1.1 201 Created
        // "password": "$2a$08$svMZbssCZgU4u6wSDV4vzekjrIetQ3GHkjsw8Jupg5iacEgFqui4C"
        // ...
        int id = (Integer) createdCandidate.get("id");
        saveTestData("lastCreatedCandidateId", id);
        return id;
    }

    public int updateCandidate(int id, Map<String,String> candidate) {
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"),credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type","application/json")
                .body(candidate)
                .log().all();
        Response response = request
                .when()
                .put("/candidates/" + id);
        Map<String,Object> createdCandidate = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        return (Integer) createdCandidate.get("id");
    }

    public int patchedCandidate(int id, Map<String,String> candidate) {
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"),credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type","application/json")
                .body(candidate)
                .log().all();
        Response response = request
                .when()
                .put("/candidates/" + id);
        Map<String,Object> createdCandidate = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        return (Integer) createdCandidate.get("id");
    }

    public void deleteCandidate(int id) {
        RequestSpecification request = RestAssured
                .given()
                .log().all()
                .auth().preemptive().basic(credentials.get("email"),credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1");
        Response response = request
                .when()
                .delete("/candidates/" + id);
        response.then()
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

    public byte[] addResume(int candidateId, File file, String fileType) {
        String mime; // a media type (also known as a Multipurpose Internet Mail Extensions or MIME type)
        switch (fileType) {
            case "pdf" : mime = "application/pdf";
                         break;
            default: mime = "application/octet-stream"; // generic binary data (or binary data whose true type is unknown)
        }
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Authorization", authToken)
                .multiPart("resume", file, mime)
                .log().all();
        Response response = request
                .when()
                .post("/candidates/" + candidateId + "/resume");
        return response.then()
                .log().all()
                .statusCode(201)
                .extract()
                .body()
                .asByteArray();
    }

    public byte[] getResume(int candidateId) {
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();
        Response response = request
                .when()
                .get("/candidates/" + candidateId + "/resume");
        return response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .body()
                .asByteArray();
    }
}
