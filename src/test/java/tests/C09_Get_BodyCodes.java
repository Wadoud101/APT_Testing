package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_BodyCodes {
    @Test
    public void test01(){
        String url2 = "https://restful-booker.herokuapp.com/booking/85";

        Response response = given().when().get(url2);
        //response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", equalTo("Josh"),
                        "totalprice", equalTo(111),
                        "bookingdates", notNullValue());



    }
}
