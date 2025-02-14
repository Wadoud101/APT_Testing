package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_RequestBody {

    @Test
    public void test01(){

        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject object = new JSONObject();
        object.put("title","API");
        object.put("body","API is very fantastic");
        object.put("userId",10);

        Response response = given().contentType(ContentType.JSON)
                .when().body(object.toString())
                .post(url);
        //response.prettyPrint();

        response.then().assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userId", Matchers.lessThan(100))
                .body("body", Matchers.containsString("API"));
    }
}
