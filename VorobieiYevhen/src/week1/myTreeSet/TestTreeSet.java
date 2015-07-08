package week1.myTreeSet;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Джек on 09.07.2015.
 */
public class TestTreeSet {
    public static void main(String[] args) {

        Set set = new TreeSet();
        BinarySearchTee mySet = new BinarySearchTee();
        BinarySearchTee<User> mySet2 = new BinarySearchTee<User>();

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

        set.add(user6);
        System.out.println(set.add(user4));
        set.add(user3);
        set.add(user2);
        set.add(user5);
        System.out.println(set.size());
        set.add(user7);
        System.out.println(set.size());
        System.out.println(set.contains(user1));
        System.out.println(set.contains(user10));
        Iterator<User> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        System.out.println(mySet.size());
        mySet.add(user5);
        mySet.add(user3);
        mySet.add(user7);
        mySet.add(user4);
        mySet.add(user2);
        mySet.add(user6);
        mySet.add(user8);
        System.out.println(mySet.size());
        System.out.println(mySet.contains(user1));
        System.out.println(mySet.contains(user10));
        mySet.print();
        System.out.println(mySet2.size());

        System.out.println(mySet.findMin());
        System.out.println(mySet.findMax());

    }

}
