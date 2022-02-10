package support;

import io.restassured.*;
import io.restassured.response.*;
import io.restassured.specification.*;

import java.util.*;

import static support.TestContext.getData;


public class RestClient {

    Map<String, String> credentials = getData("recruiter", "careers");

    public List<Map<String, Object>> getPositions() {
        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute request
        Response response = request
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
        return positions;
    }

    public Map<String, Object> getPositionById(int id) {
        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute request
        Response response = request
                .when()
                .get("/positions/" + id);

        //parse response
        Map<String, Object> position = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
        return position;
    }

//    private String getBasicAuthHeater() {
//        Map<String, String> credentials = getData("recruiter", "careers");
//        String username = credentials.get("email");
//        String password = credentials.get("password");
//        String authString = username + ":" + password;
//        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
//        String authHeader = "Basic " + encodedAuthString;
//        return authHeader;
//    }

    public int createPosition(Map<String, String> position) {
        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(position)
                .log().all();

        //execute request
        Response response = request
                .when()
                .post("/positions");

        //parse response
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

    public void updatePosition(int id, Map<String, String> update) {
        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(update)
                .log().all();

        //execute request
        Response response = request
                .when()
                .put("/positions/" + id);

        //parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");
    }

    public void deletePosition(int id) {
        //prepare request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all();

        //execute request
        Response response = request
                .when()
                .delete("/positions/" + id);

        //parse response
        String result = response
                .then()
                .log().all()
                .statusCode(204)
                .extract()
                .htmlPath()
                .getString("");
    }
}
