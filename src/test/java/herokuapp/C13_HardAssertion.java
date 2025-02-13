package herokuapp;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_HardAssertion {

    @Test
    public void test01(){

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        Response response = given().when().get(url);

        response.prettyPrint();

        JSONObject expectedData = new JSONObject();
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita earum mollitia molestiae aut atque rem suscipit\\nnam impedit esse");

        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        System.out.println(expectedData.get("id"));
        System.out.println(responseJsonPath.getInt("id"));
    }
}
