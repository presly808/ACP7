package ua.artcode.week1.hashMap;

import java.util.*;
/**
 * Created by Daryna on 07-Jul-15.
 */
public class MainHashMap {
    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(0, "Zero");
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Ten");
        map.put(5, "Ten");
        map.put(6, "Ten");
        map.put(7, "Ten");
        map.put(8, "Ten");
        map.put(9, "Ten");
        map.put(10, "Ten");
        map.put(11, "Ten");
        map.put(12, "Ten");
        map.put(13, "Ten");
        map.put(14, "Ten");


//        System.out.println(map.size());
//        System.out.println("IsEmpty? - "+ map.isEmpty());
//        System.out.println("1: " + map.get(1));
//        System.out.println("Contains value One? - "+map.containsValue("One"));
//        System.out.println("Contains key 2? - "+ map.containsKey(2));
//        map.remove(2);
//        System.out.println("Contains key 2? - "+ map.containsKey(2));
//        System.out.println("14: "+ map.get(14));

        MyHashMap<Student, String> map2 = new MyHashMap<>();
        Student st1 = new Student("Tom", "Ford");
        Student st2 = new Student("Brad", "Pitt");
        Student st3 = new Student("Tom", "Cruise");
        Student st4 = new Student("Edward", "Norton");

        map2.put(st1, "New York");
        map2.put(st2, "Kiev");
        map2.put(st3, "Odessa");
        map2.put(st4, "LA");


        System.out.println("Contains value Kiev? - "+ map2.containsValue("Kiev"));
        System.out.println("Contains key 2? - "+ map2.containsKey(st2));
        System.out.println("Contains key Brad Petrov? - "+ map2.containsKey(new Student("Brad", "Petrov")));
        System.out.println("Contains key Edward? - "+ map2.containsKey(new Student("Edward", "Norton")));
        System.out.println("Contains key Ivan? - "+ map2.containsKey(new Student("Ivan", "Petrov")));
        System.out.println("Tom Cruise lives in "+map2.get(st3));
        System.out.println(map2.keySet());
        map2.remove(null);




    }
}
