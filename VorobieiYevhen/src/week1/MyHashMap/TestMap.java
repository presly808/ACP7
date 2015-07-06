package week1.MyHashMap;

import java.util.HashMap;

/**
 * Created by Джек on 02.07.2015.
 */
public class TestMap {
    public static void main(String[] args) {

        MyHashMap<User, Integer> map = new MyHashMap<User, Integer>();
        HashMap<User, Integer> test  = new HashMap<User, Integer>();
       /*System.out.println(test.size());
        System.out.println(test.put("Jack", 26));
        System.out.println(test.size());
        test.put(null,null);
        System.out.println(test.size());
        test.put("Jack", 25);
        System.out.println(test.size());

        System.out.println(test.remove("Jack"));
        System.out.println(test.get("Jack"));*/

     User user1 = new User("aa", 11);
        User user2 = new User("bb", 22);
        User user3 = new User("cc", 33);
        User user4 = new User("aa", 11);
        User user5 = new User("dd", 44);
        User user6 = new User("cg", 33);
        User user7 = new User("ahh", 11);
        User user8 = new User("bgh", 22);
        User user9 = new User("hgfh", 33);
        User user10 = new User("fd", 11);
        User user11 = new User("erf", 22);
        User user12 = new User("hgh", 33);
        User user13 = new User("hhj", 11);
        User user14 = new User("hhggj", 11);

        System.out.println(map.size());
        System.out.println(map.put(user1, 26));
        System.out.println(map.size());
        map.put(user2, 11);
        System.out.println(map.containsKey(user3));
        map.put(user3, 22);
        map.put(user4, 44);
        System.out.println(map.containsKey(user3));
        System.out.println(map.size());
        map.put(user4, 44);
        System.out.println(map.size());
        map.put(user5, 55);
        System.out.println(map.size());
        System.out.println(map.remove(user3));
        System.out.println(map.size());
        System.out.println(map.containsKey(user3));
        System.out.println(map.get(user2));
        System.out.println(map.containsValue(26));
        System.out.println(map.containsValue(44));
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.put(user6, 44);
        map.put(user7, 44);
        map.put(user8, 44);
        map.put(user9, 44);
        map.put(user10, 44);
        map.put(user11, 44);
        map.put(user12, 44);
        map.put(user13, 44);
        map.put(user14, 44);
        System.out.println(map.values());
        System.out.println(map.size());




     /* System.out.println(test.size());
        System.out.println(test.put(user1, 26));
        System.out.println(test.size());
        test.put(user2, 11);
        System.out.println(test.containsKey(user3));
        test.put(user3, 22);
        test.put(user4, 44);
        System.out.println(test.containsKey(user3));
        System.out.println(test.size());
        test.put(user4, 44);
        System.out.println(test.size());
        System.out.println(test.get(user2));
        System.out.println(test.containsValue(26));
        System.out.println(test.containsValue(44));
        System.out.println(test.keySet());
        System.out.println(test.values());
        System.out.println(test.entrySet());
        test.put(user5, 44);
        test.put(user6, 44);
        test.put(user7, 44);
        test.put(user8, 44);
        test.put(user9, 44);
        test.put(user10, 44);
        test.put(user11, 44);
        test.put(user12, 44);
        test.put(user13, 44);
        System.out.println(test.size());*/



    }
}
