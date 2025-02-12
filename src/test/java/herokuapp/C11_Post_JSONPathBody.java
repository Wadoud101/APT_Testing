package herokuapp;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C11_Post_JSONPathBody {

    @Test
    public void test01(){

    String url = "https://restful-booker.herokuapp.com/booking";

    JSONObject coreObject = new JSONObject();
    JSONObject dateObject = new JSONObject();
    dateObject.put("checkin","2023-01-10");
    dateObject.put("checkout","2023-01-20");

        coreObject.put("firstname" , "Wadoud");
        coreObject.put("lastname" , "Mukhlis");
        coreObject.put("totalprice" , 500);
        coreObject.put("depositpaid" , true);
        coreObject.put("bookingdates",dateObject);
        coreObject.put("additionalneeds" , "wi-fi");

        Response response = given().contentType(ContentType.JSON)
                .when().body(coreObject.toString())
                .post(url);

        /*
        donen Response’un,
status code’unun 200,
ve content type’inin application-json,
ve response body’sindeki
"firstname“in,"Ahmet",
ve "lastname“in, "Bulut",
ve "totalprice“in,500,
ve "depositpaid“in,false,
ve "checkin" tarihinin 2023-01-10
ve "checkout" tarihinin 2023-01-20
ve "additionalneeds“in,"wi-fi"
oldugunu test edin
Ahmet BULUTLUOZ
         */

       // response.prettyPrint();

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .body("booking.firstname",equalTo("Wadoud"),
                        "booking.lastname",equalTo("Mukhlis"),
                        "booking.totalprice",equalTo(500),
                        "booking.depositpaid",equalTo(true),
                        "booking.bookingdates.checkin",equalTo("2023-01-10"));
    }
}