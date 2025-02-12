package herokuapp;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_AssertPutRequest {

    @Test
    public void test01(){

        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject object = new JSONObject();

        object.put("title","Wadoud");
        object.put("body","Selamlar");
        object.put("userId",10);
        object.put("id",70);


        Response response = given().contentType(ContentType.JSON)
                            .when().body(object.toString())
                            .put(url);

       // response.prettyPrint(); //for printing the response

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");
    }
}
