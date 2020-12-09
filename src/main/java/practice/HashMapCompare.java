package practice;

import java.util.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapCompare {

    public static void main(String args[]) {

        HashMap<Integer, String> map1 = new HashMap<Integer, String>();
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        HashMap<Integer, String> map2 = new HashMap<Integer, String>();
        map2.put(3, "C");
        map2.put(1, "A");
        map2.put(2, "B");


        HashMap<Integer, String> map3 = new HashMap<Integer, String>();
        map3.put(1, "A");
        map3.put(2, "B");
        map3.put(3, "C");
        map3.put(3, "D");

        //Compare using key-value pair : use equals method
        System.out.println(map1.equals(map2));
        System.out.println(map1.equals(map3));

        //Compare keys for 2 hashmaps : use equals on map.keyset()
        System.out.println(map1.keySet().equals(map2.keySet()));
        System.out.println(map1.keySet().equals(map3.keySet()));

        //Combine keys from both maps : find extra key
        HashMap<Integer, String> map4 = new HashMap<Integer, String>();
        map4.put(1, "A");
        map4.put(2, "B");
        map4.put(3, "C");
        map4.put(4, "D");

        HashSet<Integer> combineKeys = new HashSet<>(map1.keySet());
        combineKeys.addAll(map4.keySet());
        combineKeys.removeAll(map1.keySet());
        System.out.println(combineKeys);

        //Compare Maps by values:
        HashMap<Integer, String> map5 = new HashMap<Integer, String>();
        map5.put(1, "A");
        map5.put(2, "B");
        map5.put(3, "C");

        HashMap<Integer, String> map6 = new HashMap<Integer, String>();
        map6.put(4, "A");
        map6.put(5, "B");
        map6.put(6, "C");


        HashMap<Integer, String> map7 = new HashMap<Integer, String>();
        map7.put(1, "A");
        map7.put(2, "B");
        map7.put(3, "C");
        map7.put(4, "C");

        //Compare map values when duplicates are allowed : use arraylists to compare
        System.out.println((new ArrayList<>(map1.values())).equals(new ArrayList<>(map5.values())));
        System.out.println((new ArrayList<>(map5.values())).equals(new ArrayList<>(map7.values())));

        //Compare map values when duplicates are not allowed : use HashSet to compare
        System.out.println((new HashSet<>(map1.values())).equals(new HashSet<>(map5.values())));
        System.out.println((new HashSet<>(map5.values())).equals(new HashSet<>(map7.values())));

    }
}
