package ua.artcode.week2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Daryna on 05-Jul-15.
 */
public class Test1 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        map.put("hello", "hello");

        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        map.put("2", "2");

        System.out.println(iterator.next().getKey());

    }
}
