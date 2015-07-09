package week1.myHashMap;

import java.util.HashMap;

/**
 * Created by Джек on 02.07.2015.
 */
public class TestMap {
    public static void main(String[] args) {

        MyHashMap<User, Integer> map = new MyHashMap<User, Integer>();
        HashMap<User, Integer> test = new HashMap<User, Integer>();


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
        User user20 = new User("Tom", 57);
        User user21 = new User("Una", 17);
        User user22 = new User("Viva", 21);

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

        test.put(user20, 21);
        test.put(user21, 22);
        test.put(user22, 23);

        map.putAll(test);
        System.out.println(map.values());
        System.out.println(map.size());


    }
}