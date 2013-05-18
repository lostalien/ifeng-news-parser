package org.hxj.dsa_java;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String, String>( );
        map.put("name","a");
        map.put("addr","b");
        map.put("height","c");

        //map.get("height");
        Map<String,String> lm = new LinkedHashMap<String, String>(map);
        Set<String> keys = lm.keySet();
        for( String k : keys ){
            System.out.println(k);
        }
    }
}
