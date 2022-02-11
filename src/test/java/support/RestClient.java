package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;
import java.util.List;
import java.util.Map;

public class RestClient {

    Map<String, String> basicAuthCredentials;

    public RestClient(Map<String, String> credentials) {
        basicAuthCredentials = credentials;
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
                .auth().preemptive().basic(getBasicAuthLogin(),getBasicAuthPassword())
                .baseUri("https://skryabin.com/recruit/api/v1")
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
                .auth().preemptive().basic(getBasicAuthLogin(),getBasicAuthPassword())
                .baseUri("https://skryabin.com/recruit/api/v1")
                .contentType("application/json")
                .body(position)
                .log().all();

        Response response = request
                .when()
                .put("/positions/" + id);

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
                .auth().preemptive().basic(getBasicAuthLogin(),getBasicAuthPassword())
                .baseUri("https://skryabin.com/recruit/api/v1")
                .log().all()
                .when()
                .delete("/positions/" + id)
                .then()
                .log().all()
                .statusCode(204);
    }

    public void setBasicAuthCredentials(Map<String, String> credentials) {
        basicAuthCredentials = credentials;
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
