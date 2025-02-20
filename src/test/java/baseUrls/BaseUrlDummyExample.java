package baseUrls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlDummyExample {

    protected RequestSpecification specDummyExampleURL;

    @Before
    public void Setup(){
        specDummyExampleURL = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();

    }
}
