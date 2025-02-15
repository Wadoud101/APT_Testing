package tests;

import baseUrls.BaseUrlJsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummyRestApi extends BaseUrlJsonPlaceHolder {

    @Test
    public void test01(){

        specJsonPlaceHolder.pathParams("pp1","posts");
        Response response = given()
                        .when().spec(specJsonPlaceHolder)
                        .get("/{pp1}");

        //response.prettyPrint();
        response.then().assertThat()
                    .statusCode (200)
                    .body("id", Matchers.hasSize(100));

    }

    @Test
    public void test02(){

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);
        Response response = given()
                .when().spec(specJsonPlaceHolder)
                .get("/{pp1}/{pp2}");

        //response.prettyPrint();
        response.then().assertThat()
                .statusCode (200)
                .body("id", Matchers.equalTo(44));

    }

    @Test
    public void test03(){

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",50);
        Response response = given()
                .when().spec(specJsonPlaceHolder)
                .delete("/{pp1}/{pp2}");

        //response.prettyPrint();
        response.then().assertThat()
                .statusCode (200);
        response.prettyPrint();

    }
}
