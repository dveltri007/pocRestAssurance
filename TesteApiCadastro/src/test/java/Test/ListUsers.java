package Test;
import org.junit.jupiter.api.Test;

import Page.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertFalse;
import java.util.List;


public class ListUsers {

    @Test
    public void fazerRequisicaoAPI() {
       
        RestAssured.baseURI = "https://reqres.in/api";
        
        Response response = RestAssured.get("/users?page=2");
        
        response.then().statusCode(200);
      
        List<User> userList = response.jsonPath().getList("data", User.class);
        
        assertFalse(userList.isEmpty());
        
        for (User user : userList) {
            System.out.println("ID: " + user.getId());
            System.out.println("E-mail: " + user.getEmail());
            System.out.println("Primeiro Nome: " + user.getFirst_name());
            System.out.println("Sobrenome: " + user.getLast_name());
            System.out.println("Avatar: " + user.getAvatar());
            System.out.println("-------------------------");
        }
    }
}
