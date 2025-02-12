package herokuapp;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequestPrettyPrint {

    @Test
    public void get02(){

        String url = "https://restful-booker.herokuapp.com/booking/143";

        Response response = given().when().get(url);
       // response.prettyPrint();    //System.out.println(response.getBody()); ???
        System.out.println("Status Code: " + response.getStatusCode() +
                            "\nContent Type: " + response.contentType() +
                            "\nServer header Value: " + response.getHeader("Server"));
    }
}
