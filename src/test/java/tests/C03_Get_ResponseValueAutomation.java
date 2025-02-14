package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_Get_ResponseValueAutomation {

    @Test
    public void get03(){

        String url = "https://restful-booker.herokuapp.com/booking/53";
        Response response = given().when().get(url);
        //response.prettyPrint();
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy");

        System.out.println("Status Code: "+response.getStatusCode());
        response.prettyPrint();

    }
}
