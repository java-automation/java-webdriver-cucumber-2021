package support;


import io.cucumber.java.nl.Stel;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import static support.TestContext.getData;

public class RestClientt {
    private String authToken;

//    private String getBasicAuthHeader(){
//
//        Map<String,String> credentials = getData("recruiter", "careers");
//        String username = credentials.get("email");
//        String password = credentials.get("password");
//        String authString = username + ":" + password;
//        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
//
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

        //prepare a request
        RequestSpecification request = RestAssured
                .given()
                .baseUri("https://skryabin.com/recruit/api/v1/")
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
        //prepare a request
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


    public int createPosition(Map<String, String> position) {
        //logging using creds  from file
        //Map<String, String> credentials = getData("recruiter", "careers");
        //prepare a request
        RequestSpecification request = RestAssured
                .given()
//                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .header("Authorization", authToken)
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

    //Update - team example
    public Map<String, Object> updatePosition(Map<String, String> position, int id) {
     //   Map<String, String> credentials = getData("recruiter", "careers");
        //prepare a request
        RequestSpecification request = RestAssured
                .given()
             //   .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .header("Authorization",authToken)
                .body(position);

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

        return result;

    }

    public void deletePositionById(int id) {

        Map<String, String> credentials = getData("recruiter", "careers");
        //prepare a request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1");
//                .header("Content-Type", "application/json");

        //execute request
        Response response = request
                .when()
                .delete("/positions/" + id);

        //parse response
        ValidatableResponse result = response
                .then()
//                .log().all()
                .statusCode(204);
//                .extract()
//                .jsonPath()
//                .getMap("");

    }

    //update - Slava example
    public void updatePositionbyId(int id, Map<String, String> fieldsToUpdate) {

        Map<String, String> credentials = getData("recruiter", "careers");
        //prepare a request
        RequestSpecification request = RestAssured
                .given()
                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
                .baseUri("https://skryabin.com/recruit/api/v1")
                .header("Content-Type", "application/json")
                .body(fieldsToUpdate)
                .log().all();

        //execute request
        Response response = request
                .when()
                .patch("/positions/" + id);

        //parse response
        Map<String, Object> result = response
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .jsonPath()
                .getMap("");


    }

}