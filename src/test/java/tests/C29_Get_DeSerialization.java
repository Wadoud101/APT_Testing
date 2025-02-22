package tests;

import TestDatas.TestDataDummyExample;
import baseUrls.BaseUrlDummyExample;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_DeSerialization extends BaseUrlDummyExample {
     /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine
    bir GET request gonderdigimizde
    donen response’un status code’unun 200,
    content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
        Expected Response Body
        {
            "status":"success",
            "data":{
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000,
                    "employee_age":66,
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */

    @Test
    public void Test01(){

        specDummyExampleURL.pathParams("pp1","employee","pp2","3");

        Map<String, Object> expectedData = TestDataDummyExample.mapBodyBuild();
        System.out.println(expectedData);

        Response response = given().spec(specDummyExampleURL)
                            .when()
                            .get("{pp1}/{pp2}");
        response.prettyPrint();
        Map<String, Object> responseMap = response.as(HashMap.class);

        assertEquals(TestDataDummyExample.successStatusCode, response.statusCode());
        assertEquals(TestDataDummyExample.contentType, response.contentType());
    }
}
