package ua.artcode.week7.day2;

import java.util.Map;
import java.util.Set;

/**
 * Created by serhii on 23.08.15.
 */
public class SystemPropertyTest {

    public static void main(String[] args) {

        System.out.println(System.getenv("ownerName"));

        Map<String, String> map = System.getenv();
        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> stringStringEntry : entrySet) {
            System.out.printf("%s = %s\n", stringStringEntry.getKey(), stringStringEntry.getValue());
        }

    }
}
