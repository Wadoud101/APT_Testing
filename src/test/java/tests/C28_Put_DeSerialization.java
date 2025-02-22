package tests;

import TestDatas.TestDataJsonPlaceHolder;
import baseUrls.BaseUrlJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C28_Put_DeSerialization extends BaseUrlJsonPlaceHolder {

    @Test
    public void Test01() {
        specJsonPlaceHolder.pathParams("pp1","posts", "pp2", 70);

        Map<String, Object> requestBodyMap = TestDataJsonPlaceHolder.bodyBuildMap();
        System.out.println(requestBodyMap);

        Map<String, Object> expectedData = TestDataJsonPlaceHolder.bodyBuildMap();

        Response response = given().spec(specJsonPlaceHolder).contentType(ContentType.JSON)
                            .when().body(requestBodyMap)
                            .put("/{pp1}/{pp2}");


        Map responseMap = response.as(HashMap.class);
        System.out.println(responseMap);

        assertEquals(expectedData.get("title"),responseMap.get("title"));
        assertEquals(expectedData.get("body"),responseMap.get("body"));
        assertEquals(expectedData.get("userId"),responseMap.get("userId"));
        assertEquals(expectedData.get("id"),responseMap.get("id"));
    }
}
