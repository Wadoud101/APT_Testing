package herokuapp;

import org.json.JSONObject;
import org.junit.Test;

public class C05_JSONObjectInnerObject {

    @Test
    public void test05(){
        JSONObject bodyObject = new JSONObject();
        JSONObject dateObject = new JSONObject();

        dateObject.put("chekin","2018-01-01");
        dateObject.put("chekout","2019-01-01");

        bodyObject.put("firstname","Wadoud");
        bodyObject.put("additionalneed","Sport");
        bodyObject.put("bookingdates",dateObject);
        bodyObject.put("totalprice",550);
        bodyObject.put("depositpaid",true);
        bodyObject.put("lastname","Mukhlis");

        System.out.println(bodyObject);

        /*
        {"firstname":"Wadoud"
        "additionalneed":"Sport"
        "bookingdates":
                    {
                    "chekout":"2019-01-01"
                    "chekin":"2018-01-01"
                    }
        "totalprice":550
        "depositpaid":true
        "lastname":"Mukhlis"}
         */
    }
}
