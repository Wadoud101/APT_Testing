package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C14_Post_ExpectedDataAssertionJsonPath {

    @Test
    public void test01(){

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject coreObject = new JSONObject();

        JSONObject bokingDateObj = new JSONObject();
        bokingDateObj.put("checkin", "2021-06-01");
        bokingDateObj.put("checkout", "2021-06-10");

        coreObject.put("firstname","Wadoud");
        coreObject.put("lastname","Mukhlis");
        coreObject.put("totalprice",1500);
        coreObject.put("depositpaid",true);
        coreObject.put("bookingdates",bokingDateObj);
        coreObject.put("additionalneeds","Wi-Fi");

        Response response = given().contentType(ContentType.JSON)
                .when().body(coreObject.toString())
                .post(url);

        response.prettyPrint();
        System.out.println(response.statusCode());
    }
}
