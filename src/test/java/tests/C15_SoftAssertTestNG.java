package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_SoftAssertTestNG {

    @Test
    public void test01(){
        /*
        C15_Get_SoftAssertIleExpectedDataTesti
http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
Response Body
{
"userId": 7,
    "id": 70,
    "title": "voluptatem laborum magni",
    "body": "sunt repellendus quae\nest asperiores aut deleniti esse accusamus repellendus quia aut\nquia dolorem unde\neum tempora esse dolore"
}
         */

        String url = "https://jsonplaceholder.typicode.com/posts/70";

        SoftAssert softAssert = new SoftAssert();
        JSONObject object = new JSONObject();
        object.put("userId",7);
        object.put("id",70);
        object.put("title","voluptatem laborum magni");



        Response response = given().when().get(url);

        JsonPath responseJsonPath = response.jsonPath();

        softAssert.assertEquals(responseJsonPath.get("userId"),object.get("userId"));
        softAssert.assertEquals(responseJsonPath.get("title"),object.get("title"));
        softAssert.assertEquals(responseJsonPath.get("id"),object.get("id"));

        softAssert.assertAll();


    }
}
