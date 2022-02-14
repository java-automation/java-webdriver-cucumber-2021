package support;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
        saveTestData("lastCreatedPositionId", id);

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

}


//    public void updatePosition(int id, Map<String, String> fieldsToUpdate) {
//
//
//        // prepare a request
//        RequestSpecification request = RestAssured
//                .given()
//                .baseUri("https://skryabin.com/recruit/api/v1")
//                .header("Content-Type", "application/json")
//                .header("Authorization", authToken)
//                .body(fieldsToUpdate)
//                .log().all();

//        // execute request
//        Response response = request
//                .when()
//                .patch("/positions/" + id);
//
//        // parse response
//        Map<String, Object> result = response
//                .then()
//                .log().all()
//                .statusCode(200)
//                .extract()
//                .jsonPath()
//                .getMap("");
//
//    }

//        Map<String, String> credentials = getData("recruiter");
//        Map<String, String> updatedPosition = new HashMap<>();
//        updatedPosition.put(field, updatedValue);
//
//        // prepare a request
//        RequestSpecification request = RestAssured
//                .given()
//                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
//                .baseUri("https://skryabin.com/recruit/api/v1")
//                .header("Content-Type", "application/json")
//                .body(updatedPosition)
//                .log().all();
//
//        // execute request
//        Response response = request
//                .when()
//                .patch("/positions" + id);
//
//        // parse response
//        Map<String, Object> result = response
//                .then()
//                .log().all()
//                .statusCode(200)
//                .extract()
//                .jsonPath()
//                .getMap("");
//
//    }

//    public void deletePosition(int id) {
//
//        System.out.println("---------------------------------------");
//        System.out.println("Delete Position By Id Request Log");
//        System.out.println("---------------------------------------");
//        // prepare a request
//        RequestSpecification request = RestAssured
//                .given()
//                .baseUri("https://skryabin.com/recruit/api/v1")
//                .header("Authorization", authToken)
//                .log().all();
//
//        // execute request
//        Response response = request
//                .when()
//                .delete("/positions/" + id);
//
//        System.out.println("\n---------------------------------------");
//        System.out.println("Delete Position By Id Response Log");
//        System.out.println("---------------------------------------");
//        // parse response
//        response
//                .then()
//                .log().all()
//                .statusCode(204);
//    }
//    }
//        Map<String, String> credentials = getData("recruiter");
//
//        RequestSpecification request = RestAssured
//                .given()
//                .auth().preemptive().basic(credentials.get("email"), credentials.get("password"))
//                .baseUri("https://skryabin.com/recruit/api/v1")
//                .header("Content-Type", "application/json")
//                .log().all();
//
//        // execute request
//        Response response = request
//                .when()
//                .delete("/positions" + id);
//
//        // parse response
//
//        ValidatableResponse result = response
//                .then()
//                .log().all()
//                .statusCode(204);
//    }
//}
//
