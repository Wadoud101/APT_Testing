package herokuapp;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_JSONObjectInner {

    @Test
    public void test01(){
        JSONObject coreObject = new JSONObject();
        JSONObject addressObject = new JSONObject();
        JSONArray contact = new JSONArray();
        JSONObject phoneNumber = new JSONObject();
        JSONObject homeNumber = new JSONObject();

        phoneNumber.put("type","iphone");
        phoneNumber.put("number","0123-4567-8888");
        homeNumber.put("type","home");
        homeNumber.put("number","0123-4567-9999");

        contact.put(phoneNumber);
        contact.put(homeNumber);

        addressObject.put("streetAddress","nasirov street");
        addressObject.put("city","dushanbe");
        addressObject.put("postalCode","630-0192");

        coreObject.put("firstname","john");
        coreObject.put("Lastname","Mukhlis");
        coreObject.put("age",44);
        coreObject.put("address", addressObject);
        coreObject.put("phoneNumbers",contact);

        System.out.println(coreObject);

        /*
        {
        "firstname":"john",
        "address":{
            "streetAddress":"nasirov street",
            "city":"dushanbe",
            "postalCode":"630-0192"},
        "Lastname":"Mukhlis",
        "age":44,
        "phoneNumbers":[
                {
                "number":"0123-4567-8888",
                "type":"iphone"
                    },
                 {
                 "number":"0123-4567-9999",
                 "type":"home"
                 }
           ]
        }
         */

    }
}
