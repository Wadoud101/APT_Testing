package tests;

import baseUrls.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C16_Get_BaseUrlPathParam extends BaseUrlJsonPlaceHolder {

    @Test
    public void test01(){

        //String url = "https://restful-booker.herokuapp.com/booking/53";

        specJsonPlaceHolder.pathParams("pp1","booking","pp2",53);
        Response response = given()
                .when().spec(specJsonPlaceHolder)
                .get("/{pp1}/{pp2}");
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
