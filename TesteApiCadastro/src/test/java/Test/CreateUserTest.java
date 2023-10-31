package Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import Page.CreateUserRequest;


public class CreateUserTest {

    @Test
    public void fazerRequisicaoPOST() {
        RestAssured.baseURI = "https://reqres.in/api";
        
        CreateUserRequest request = new CreateUserRequest("John", "Software Developer");

        Response response = given()
            .header("Content-Type", "application/json")
            .body(request)
            .when()
            .post("/users");
        
        response.then().statusCode(201);
        
        String responseBody = response.getBody().asString();
        System.out.println("Corpo da Resposta:\n" + responseBody);
        
        assertTrue(responseBody.contains("name"));
        assertTrue(responseBody.contains("job"));
    }
}
