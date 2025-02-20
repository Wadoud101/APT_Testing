package TestDatas;

import org.json.JSONObject;

public class TestDataDummyExample {

    public static int successStatusCode = 200;
    public static String contentType = "application/jason";

    public static JSONObject jsonResponseBodyMaker(int id, String employee_name,
                                                   int employee_salary,
                                                   int employee_age,
                                                   String profile_image){
        JSONObject responseBody = new JSONObject();
        JSONObject dataBody = new JSONObject();

        dataBody.put("id",id);
        dataBody.put("employee_name",employee_name);
        dataBody.put("employee_salary",employee_salary);
        dataBody.put("employee-age", employee_age);
        dataBody.put("profile_image",profile_image);

        responseBody.put("status", "success");
        responseBody.put("data", dataBody);
        responseBody.put("message", "Successfully! Record has been fetched");

        return responseBody;


    }
}
