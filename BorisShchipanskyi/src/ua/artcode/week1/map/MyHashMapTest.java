package ua.artcode.week1.map;


import java.io.IOException;
import java.util.Map;


public class MyHashMapTest {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new MyHashMap<>(0.7);
        map.put("1", "val 1");
        map.put("2", "val 2");
        map.put("3", "val 3");
        map.put("4", "val 4");
        map.put("5", "val 5");



        for(String key: map.keySet()){
            System.out.println(key);
        }
        for(String val: map.values()){
            System.out.println(val);
        }
        printMap(map);

        map.remove("5");
        map.remove("4");
        map.remove("3");
        map.remove("2");
        printMap(map);
        map.put("2", "val 2");
        map.put("3", "val 3");
        map.put("4", "val 4");
        map.put("5", "val 5");
        printMap(map);


    }
    public static <K,V>void printMap(Map<K,V> map){
        System.out.println("You map:");
        for(Map.Entry<K, V> entry : map.entrySet()){
            System.out.println(entry.toString());
        }
    }
}
