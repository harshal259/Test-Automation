package practice;

import java.util.*;

public class ArrayListConcepts {

    public static void main(String args[]) {
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("Aman", "Dinesh", "Aman", "Rajeev", "Naveen", "Aman"));
        ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("Shreya", "Neha"));
        ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("Arya", "Megha", "Rishi"));

//        list1.addAll(list2);
//        list3.addAll(0, list2);
        System.out.println(list1);
//        System.out.println(list3);

        //Remove element by index
//        list1.remove(1);
//        System.out.println(list1);

        //Remove first occurrence of String
//        list1.remove("Aman");
//        System.out.println(list1);

        //Remove all occurrences of String
//        list1.removeAll(new ArrayList<>(Arrays.asList("Aman")));
//        System.out.println(list1);

        //Retain all occurrences of String
//        list1.retainAll(Collections.singleton("Aman"));
//        System.out.println(list1);

        //Create a sublist from main list
        ArrayList<String> subList = new ArrayList<>(list1.subList(2, 5));
        System.out.println(subList);


    }
}
