package practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapConcepts {

    public static void main(String args[]) {

        HashMap<String, String> capitalMap = new HashMap<String, String>();
        capitalMap.put("MP", "Bhopal");
        capitalMap.put("UP", "Lucknow");
        capitalMap.put("Maharashtra", "Mumbai");
        capitalMap.put(null, "Test");
        capitalMap.put("Pune", null);

        //Map.put will overwrite they key value pair, while Map.remove will remove the key value pair
        capitalMap.put("Pune", "ABC");
        capitalMap.remove("UP");

        //Printing Values from keys
        System.out.println(capitalMap.get("MP"));
        System.out.println(capitalMap.get("UP"));
        System.out.println(capitalMap.get(null));

        //Iterating over Keys
//        Iterator<String> i1 = capitalMap.keySet().iterator();
//        while (i1.hasNext()) {
//            String key = i1.next();
//            String value = capitalMap.get(key);
//            System.out.println("Key is: " + key + " value is: " + value);
//        }

        //Iterating over Key-Set pair
        Iterator<Map.Entry<String, String>> i2 = capitalMap.entrySet().iterator();
        while (i2.hasNext()) {
            Map.Entry<String, String> entry = i2.next();
            System.out.println("Key is: " + entry.getKey() + " value is: " + entry.getValue());
        }

    }
}
