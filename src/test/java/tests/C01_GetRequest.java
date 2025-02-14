package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest {


    @Test
    public void get01(){

        String url = "https://jsonplaceholder.typicode.com/posts/70";
        String url2 = "https://restful-booker.herokuapp.com/booking/143";

        Response response = given().when().get(url);
        response.prettyPrint();
        System.out.println("Status code is " + response.getStatusCode());
    }
}
