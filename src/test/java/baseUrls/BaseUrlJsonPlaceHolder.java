package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static io.restassured.RestAssured.given;

public class BaseUrlJsonPlaceHolder {

    protected RequestSpecification specJsonPlaceHolder;

    @Before
    public void setup(){
        String url = "https://jsonplaceholder.typicode.com";
        specJsonPlaceHolder = new RequestSpecBuilder()
                .setBaseUri(url).build();
    }
}
