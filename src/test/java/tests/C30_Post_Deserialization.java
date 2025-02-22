package tests;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class C30_Post_Deserialization {

    public static void main(String[] args) {
        try {
            // Step 1: Set up a CookieManager to handle cookies
            CookieManager cookieManager = new CookieManager();
            cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

            // Step 2: Create an HttpClient with the CookieManager
            HttpClient client = HttpClient.newBuilder()
                    .cookieHandler(cookieManager)
                    .build();

            // Step 3: Make the initial request to set the cookie
            HttpRequest initialRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://dummy.restapiexample.com/api/v1/employee/3"))
                    .GET()
                    .build();

            HttpResponse<String> initialResponse = client.send(initialRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Initial Response: " + initialResponse.body());

            // Step 4: Make the second request with the cookie
            HttpRequest finalRequest = HttpRequest.newBuilder()
                    .uri(URI.create("http://dummy.restapiexample.com/api/v1/employee/3"))
                    .GET()
                    .build();

            HttpResponse<String> finalResponse = client.send(finalRequest, HttpResponse.BodyHandlers.ofString());
            System.out.println("Final Response: " + finalResponse.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}