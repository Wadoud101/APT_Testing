package tests;

import TestDatas.TestDataDummyExample;
import baseUrls.BaseUrlDummyExample;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Get_TestDataClassKullanimi extends BaseUrlDummyExample {

    @Test
    public void Test01() {

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

        specDummyExampleURL.pathParams("pp1", "employee", "pp2", "3");

        JSONObject expectedData = TestDataDummyExample.jsonResponseBodyMaker(3,"Ashton Cox", 86000, 66, "");

        Response response = given().spec(specDummyExampleURL)
                            .when()
                            .get("/{pp1}/{pp2}");


        JsonPath responseJP = response.jsonPath();

        assertEquals(TestDataDummyExample.successStatusCode, response.statusCode());
        assertEquals(TestDataDummyExample.contentType, response.contentType());

    }
}
