package TestDatas;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;

import java.util.HashMap;
import java.util.Map;

public class TestDataJsonPlaceHolder {

    public static Map<String, Object> bodyBuildMap(){

        Map<String, Object> bodyMap =new HashMap<>();

        bodyMap.put("title", "Ahmet");
        bodyMap.put("body", "Merhaba");
        bodyMap.put("userId", 10.0);
        bodyMap.put("id", 70.0);

        return bodyMap;
    }
}
