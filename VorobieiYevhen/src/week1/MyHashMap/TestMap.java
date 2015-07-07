package week1.MyHashMap;

import java.util.HashMap;

/**
 * Created by Джек on 02.07.2015.
 */
public class TestMap {
    public static void main(String[] args) {

        MyHashMap<User, Integer> map = new MyHashMap<User, Integer>();
        HashMap<User, Integer> test  = new HashMap<User, Integer>();


        User user1 = new User("Antony", 18);
        User user2 = new User("Bob", 22);
        User user3 = new User("Carl", 31);
        User user4 = new User("Antony", 18);
        User user5 = new User("Din", 45);
        User user6 = new User("Euclid", 16);
        User user7 = new User("Fagot", 78);
        User user8 = new User("Georg", 18);
        User user9 = new User("Hana", 29);
        User user10 = new User("Iraq", 10);
        User user11 = new User("Jack", 11);
        User user12 = new User("Kelly", 22);
        User user13 = new User("Lana", 19);
        User user14 = new User("Monika", 33);
        User user15 = new User("Nick", 34);
        User user16 = new User("Owen", 34);
        User user17 = new User("Peter", 45);
        User user18 = new User("Rankle", 16);
        User user19 = new User("Susy", 19);

        System.out.println(map.size());
        System.out.println(map.put(user1, 1));
        System.out.println(map.size());
        map.put(user2, 2);
        System.out.println(map.containsKey(user3));
        map.put(user3, 3);
        map.put(user4, 4);
        System.out.println(map.containsKey(user3));
        System.out.println(map.size());
        map.put(user4, 5);
        System.out.println(map.size());
        map.put(user5, 5);
        System.out.println(map.size());
        System.out.println(map.remove(user3));
        System.out.println(map.size());
        System.out.println(map.containsKey(user3));
        System.out.println(map.get(user2));
        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(4));
        System.out.println(map.keySet());
        System.out.println(map.values());
        map.put(user6, 6);
        map.put(user7, 7);
        map.put(user8, 8);
        map.put(user9, 8);
        map.put(user10, 8);
        map.put(user11, 9);
        map.put(user12, 10);
        map.put(user13, 11);
        map.put(user14, 12);
        System.out.println(map.values());
        System.out.println(map.size());
        map.put(user15, 11);
        map.put(user16, 13);
        map.put(user17, 14);
        map.put(user18, 15);
        map.put(user19, 16);
        System.out.println(map.size());




      /*  System.out.println(test.size());
        System.out.println(test.put(user1, 1));
        System.out.println(test.size());
        test.put(user2, 2);
        System.out.println(test.containsKey(user3));
        test.put(user3, 3);
        test.put(user4, 4);
        System.out.println(test.containsKey(user3));
        System.out.println(test.size());
        test.put(user4, 5);
        System.out.println(test.size());
        test.put(user5, 5);
        System.out.println(test.size());
        System.out.println(test.remove(user3));
        System.out.println(test.size());
        System.out.println(test.containsKey(user3));
        System.out.println(test.get(user2));
        System.out.println(test.containsValue(1));
        System.out.println(test.containsValue(4));
        System.out.println(test.keySet());
        System.out.println(test.values());
        test.put(user6, 6);
        test.put(user7, 7);
        test.put(user8, 8);
        test.put(user9, 8);
        test.put(user10, 8);
        test.put(user11, 9);
        test.put(user12, 10);
        test.put(user13, 11);
        test.put(user14, 12);
        System.out.println(test.values());
        System.out.println(test.size());
        test.put(user15, 11);
        test.put(user16, 13);
        test.put(user17, 14);
        test.put(user18, 15);
        test.put(user19, 16);
        System.out.println(test.size());*/



    }
}
